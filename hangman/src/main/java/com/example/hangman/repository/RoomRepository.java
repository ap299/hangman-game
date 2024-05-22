package com.example.hangman.repository;

import com.example.hangman.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findByRoomId(String roomId);
}