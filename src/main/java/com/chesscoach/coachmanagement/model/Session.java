package com.chesscoach.coachmanagement.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startTime;
    private Integer durationMinutes;
    private String topic;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    public Session() {}

    public Session(LocalDateTime startTime, Integer durationMinutes, String topic, Player player) {
        this.startTime = startTime;
        this.durationMinutes = durationMinutes;
        this.topic = topic;
        this.player = player;
    }

    public Long getId() { return id; }
    public LocalDateTime getStartTime() { return startTime; }
    public Integer getDurationMinutes() { return durationMinutes; }
    public String getTopic() { return topic; }
    public Player getPlayer() { return player; }

    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
    public void setDurationMinutes(Integer durationMinutes) { this.durationMinutes = durationMinutes; }
    public void setTopic(String topic) { this.topic = topic; }
    public void setPlayer(Player player) { this.player = player; }
}