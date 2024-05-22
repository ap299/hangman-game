package com.example.hangman.model;

import java.util.List;
import java.util.Map;

public class GameState {
    private String word;
    private String maskedWord;
    private int incorrectGuesses;
    private int maxIncorrectGuesses = 6;
    private List<String> players;
    private int currentTurn;
    private List<Character> guesses;
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getMaskedWord() {
		return maskedWord;
	}
	public void setMaskedWord(String maskedWord) {
		this.maskedWord = maskedWord;
	}
	public int getIncorrectGuesses() {
		return incorrectGuesses;
	}
	public void setIncorrectGuesses(int incorrectGuesses) {
		this.incorrectGuesses = incorrectGuesses;
	}
	public int getMaxIncorrectGuesses() {
		return maxIncorrectGuesses;
	}
	public void setMaxIncorrectGuesses(int maxIncorrectGuesses) {
		this.maxIncorrectGuesses = maxIncorrectGuesses;
	}
	public List<String> getPlayers() {
		return players;
	}
	public void setPlayers(List<String> players) {
		this.players = players;
	}
	public int getCurrentTurn() {
		return currentTurn;
	}
	public void setCurrentTurn(int currentTurn) {
		this.currentTurn = currentTurn;
	}
	public List<Character> getGuesses() {
		return guesses;
	}
	public void setGuesses(List<Character> guesses) {
		this.guesses = guesses;
	}
    
    
}
