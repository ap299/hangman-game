package com.example.hangman.controller;

import com.example.hangman.service.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/leaderboard")
public class LeaderboardController {
    @Autowired
    private LeaderboardService leaderboardService;

    @GetMapping
    public String showLeaderboard(Model model) {
        model.addAttribute("players", leaderboardService.getTopPlayers());
        return "leaderboard";
    }
}
