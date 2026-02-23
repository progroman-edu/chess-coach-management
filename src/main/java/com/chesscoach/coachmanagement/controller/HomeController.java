package com.chesscoach.coachmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/players-page")
    public String playersPage() {
        return "players";
    }

    @GetMapping("/sessions-page")
    public String sessionsPage() {
        return "sessions";
    }

    @GetMapping("/coach")
    public String coachPage() {
        return "coach";
    }
}