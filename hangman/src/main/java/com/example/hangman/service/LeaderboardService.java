package com.example.hangman.service;

import com.example.hangman.model.User;
import com.example.hangman.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderboardService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getTopPlayers() {
        return userRepository.findAll(Sort.by(Sort.Direction.DESC, "score"));
    }
}
