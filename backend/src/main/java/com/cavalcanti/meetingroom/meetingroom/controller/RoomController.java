package com.cavalcanti.meetingroom.meetingroom.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cavalcanti.meetingroom.meetingroom.dto.RoomDTO;
import com.cavalcanti.meetingroom.meetingroom.exception.ResourceNotFoundException;
import com.cavalcanti.meetingroom.meetingroom.service.RoomService;

@RestController 
@RequestMapping("/api/v1/room")
public class RoomController {

	@Autowired
	private RoomService roomService;

	@GetMapping("")
	@CrossOrigin 
	public List<RoomDTO> getAllRooms() {
		return roomService.getAll();
	}

	@GetMapping("/{id}")
	@CrossOrigin 
	public ResponseEntity<RoomDTO> getRoomById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
		RoomDTO room = roomService.getById(id);
		return ResponseEntity.ok().body(room);
	}

	@PostMapping("")
	@CrossOrigin 
	public RoomDTO createRoom(@Valid @RequestBody RoomDTO room) {
		return roomService.save(room);

	}

	@PutMapping("/{id}")
	@CrossOrigin 
	public ResponseEntity<RoomDTO> updateRoom(@PathVariable(name = "id") Long id, @Valid @RequestBody RoomDTO room) throws ResourceNotFoundException {
		return ResponseEntity.ok().body(roomService.update(id, room));

	}
	
	@DeleteMapping("/{id}")
	@CrossOrigin 
	public Map<String, Boolean> deleteRoom(@PathVariable("id") Long id) throws ResourceNotFoundException{
		roomService.delete(id);
		
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted", Boolean.TRUE);
		return response;
		
	}
}
