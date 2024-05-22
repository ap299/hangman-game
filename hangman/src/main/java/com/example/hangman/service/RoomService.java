package com.example.hangman.service;

import com.example.hangman.model.Room;
import com.example.hangman.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public Room createRoom(String password) {
        Room room = new Room();
        room.setRoomId(generateUniqueRoomId());
        room.setPassword(password);
        room.setIncorrectGuesses(0);
        room.setMaxIncorrectGuesses(6);
        return roomRepository.save(room);
    }

    public boolean joinRoom(String roomId, String password) {
        Room room = roomRepository.findByRoomId(roomId);
        return room != null && room.getPassword().equals(password);
    }

    private String generateUniqueRoomId() {
        return UUID.randomUUID().toString();
    }
}
