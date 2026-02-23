package com.chesscoach.coachmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chesscoach.coachmanagement.model.Coach;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {
    // Optional: custom query methods
    Coach findByEmail(String email);
}
