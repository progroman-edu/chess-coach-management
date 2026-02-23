package com.chesscoach.coachmanagement.repository;

import com.chesscoach.coachmanagement.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    // Add custom queries if needed, e.g., find sessions by player
}
