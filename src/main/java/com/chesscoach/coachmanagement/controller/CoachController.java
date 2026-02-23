package com.chesscoach.coachmanagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chesscoach.coachmanagement.model.Coach;
import com.chesscoach.coachmanagement.repository.CoachRepository;

@RestController
@RequestMapping("/coaches")
public class CoachController {

    private final CoachRepository coachRepository;

    public CoachController(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    @GetMapping
    public List<Coach> getAllCoaches() {
        return coachRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coach> getCoachById(@PathVariable Long id) {
        return coachRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Coach> createCoach(@RequestBody Coach coach) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(coachRepository.save(coach));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coach> updateCoach(@PathVariable Long id, @RequestBody Coach coachDetails) {
        return coachRepository.findById(id)
            .map(coach -> {
                coach.setFirstName(coachDetails.getFirstName());
                coach.setLastName(coachDetails.getLastName());
                coach.setEmail(coachDetails.getEmail());
                coach.setPhoneNumber(coachDetails.getPhoneNumber());
                return ResponseEntity.ok(coachRepository.save(coach));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoach(@PathVariable Long id) {
        if (coachRepository.existsById(id)) {
            coachRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
