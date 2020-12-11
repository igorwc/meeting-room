package com.cavalcanti.meetingroom.meetingroom.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cavalcanti.meetingroom.meetingroom.dto.RoomDTO;
import com.cavalcanti.meetingroom.meetingroom.exception.ResourceNotFoundException;
import com.cavalcanti.meetingroom.meetingroom.model.Room;
import com.cavalcanti.meetingroom.meetingroom.repository.RoomRepository;

@Service
public class RoomService {

	@Autowired
	private RoomRepository repository;

	public List<RoomDTO> getAll() {
		List<Room> list = repository.findAll();
		return list.stream().map(e -> RoomDTO.fromEntity(e)).collect(Collectors.toList());

	}

	public RoomDTO getById(Long id) throws ResourceNotFoundException {
		Room room = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Room not found"));
		return RoomDTO.fromEntity(room);
	}

	public RoomDTO save(@Valid RoomDTO room) {
		return RoomDTO.fromEntity(repository.save(room.toEntity()));
		
	}

	public RoomDTO update(Long id, @Valid RoomDTO dto) throws ResourceNotFoundException {
		Room room = repository.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("Room "+id+"not found for update"));
		room.setDate(dto.getDate());
		room.setEndHour(dto.getEndHour());
		
		room.setName(dto.getName());
		room.setStartHour(dto.getStartHour());
		
		
		return RoomDTO.fromEntity(repository.save(room));
		 
	}

	public void delete(Long id) throws ResourceNotFoundException {
		Room room = repository.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("Room "+id+"not found for update"));
		repository.delete (room);
		
	}

//	public 
}
