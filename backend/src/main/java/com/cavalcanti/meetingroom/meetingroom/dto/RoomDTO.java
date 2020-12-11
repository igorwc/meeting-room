package com.cavalcanti.meetingroom.meetingroom.dto;

import com.cavalcanti.meetingroom.meetingroom.model.Room;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {

	private Long id;
 
    private String name; 
    private String date; 
    private String startHour; 
    private String endHour;
    
    public static RoomDTO  fromEntity(Room e) {
    	return RoomDTO.builder()
    			.id(e.getId())
    			.date(e.getDate())
    			.startHour(e.getStartHour())
    			.endHour(e.getEndHour())
    			.name(e.getName())
    			.build();
    }
    
    public Room toEntity() {
    	return Room.builder()
    	.id(getId())
		.date(getDate())
		.startHour(getStartHour())
		.endHour(getEndHour())
		.name(getName())
		.build();
    }
}
