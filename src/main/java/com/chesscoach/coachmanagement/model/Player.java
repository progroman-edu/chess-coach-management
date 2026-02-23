package com.chesscoach.coachmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer rating;

    public Player() {}

    public Player(String name, Integer rating) {
        this.name = name;
        this.rating = rating;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public Integer getRating() { return rating; }

    public void setName(String name) { this.name = name; }
    public void setRating(Integer rating) { this.rating = rating; }
}