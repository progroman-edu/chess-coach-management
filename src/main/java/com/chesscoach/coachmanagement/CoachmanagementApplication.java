package com.chesscoach.coachmanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.chesscoach.coachmanagement.model.Coach;
import com.chesscoach.coachmanagement.repository.CoachRepository;

@SpringBootApplication
public class CoachmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoachmanagementApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CoachRepository coachRepository) {
		return args -> {
			if (coachRepository.count() == 0) {
				coachRepository.save(new Coach("John", "Doe", "john@example.com", "09123456789"));
				System.out.println("Saved a sample coach!");
			}
		};
	}

}
