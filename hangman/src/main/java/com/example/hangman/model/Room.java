package com.example.hangman.model;

import javax.persistence.*;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomId;
    private String password;
    private String word;
    private String maskedWord;
    private int incorrectGuesses;
    private int maxIncorrectGuesses = 6;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
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
    
    
}
