package com.example.hangman.controller;

import com.example.hangman.model.Room;
import com.example.hangman.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/create-room")
    public String showCreateRoomForm(Model model) {
        model.addAttribute("roomRequest", new RoomRequest());
        return "create-room";
    }

    @PostMapping("/create-room")
    public String createRoom(@ModelAttribute RoomRequest roomRequest, Model model) {
        Room room = roomService.createRoom(roomRequest.getPassword());
        model.addAttribute("roomId", room.getRoomId());
        return "room-created";
    }

    @GetMapping("/join-room")
    public String showJoinRoomForm(Model model) {
        model.addAttribute("joinRoomRequest", new JoinRoomRequest());
        return "join-room";
    }

    @PostMapping("/join-room")
    public String joinRoom(@ModelAttribute JoinRoomRequest joinRoomRequest, Model model) {
        boolean success = roomService.joinRoom(joinRoomRequest.getRoomId(), joinRoomRequest.getPassword());
        if (success) {
            model.addAttribute("roomId", joinRoomRequest.getRoomId());
            return "redirect:/game?roomId=" + joinRoomRequest.getRoomId();
        } else {
            model.addAttribute("error", "Failed to join room");
            return "join-room";
        }
    }
}

class RoomRequest {
    private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
}

class JoinRoomRequest {
    private String roomId;
    private String password;
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
}
