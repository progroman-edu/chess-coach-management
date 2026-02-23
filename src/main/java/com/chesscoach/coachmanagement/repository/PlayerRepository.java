package com.chesscoach.coachmanagement.repository;

import com.chesscoach.coachmanagement.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    // You can add custom queries here if needed
}
