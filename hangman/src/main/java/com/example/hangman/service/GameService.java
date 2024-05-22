package com.example.hangman.service;

import com.example.hangman.model.GameState;
import com.example.hangman.model.Room;
import com.example.hangman.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    @Autowired
    private RoomRepository roomRepository;

    public GameState startGame(String roomId) {
        Room room = roomRepository.findByRoomId(roomId);
        GameState gameState = new GameState();
        gameState.setWord(room.getWord());
        gameState.setMaskedWord(maskWord(room.getWord()));
        gameState.setIncorrectGuesses(room.getIncorrectGuesses());
        gameState.setMaxIncorrectGuesses(room.getMaxIncorrectGuesses());
        return gameState;
    }

    public GameState makeGuess(String roomId, char guess) {
        Room room = roomRepository.findByRoomId(roomId);
        GameState gameState = new GameState();
        gameState.setWord(room.getWord());
        gameState.setMaskedWord(updateMaskedWord(room.getWord(), room.getMaskedWord(), guess));
        gameState.setIncorrectGuesses(room.getIncorrectGuesses());
        gameState.setMaxIncorrectGuesses(room.getMaxIncorrectGuesses());
        roomRepository.save(room);
        return gameState;
    }

    private String maskWord(String word) {
        return word.replaceAll(".", "*");
    }

    private String updateMaskedWord(String word, String maskedWord, char guess) {
        StringBuilder updatedMaskedWord = new StringBuilder(maskedWord);
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                updatedMaskedWord.setCharAt(i, guess);
            }
        }
        return updatedMaskedWord.toString();
    }
}
