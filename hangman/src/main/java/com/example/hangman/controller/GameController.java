package com.example.hangman.controller;

import com.example.hangman.model.GameState;
import com.example.hangman.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {
    @Autowired
    private GameService gameService;

    @MessageMapping("/game/start")
    @SendTo("/topic/updates")
    public GameState startGame(String roomId) {
        return gameService.startGame(roomId);
    }

    @MessageMapping("/game/guess")
    @SendTo("/topic/updates")
    public GameState makeGuess(Guess guess) {
        return gameService.makeGuess(guess.getRoomId(), guess.getCharacter());
    }
}

class Guess {
    private String roomId;
    private char character;
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public char getCharacter() {
		return character;
	}
	public void setCharacter(char character) {
		this.character = character;
	}
    }
