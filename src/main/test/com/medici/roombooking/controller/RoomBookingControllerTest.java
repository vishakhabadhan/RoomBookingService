package com.medici.roombooking.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.medici.roombooking.db.entities.Room;
import com.medici.roombooking.db.entities.RoomType;
import com.medici.roombooking.domain.RoomResponse;
import com.medici.roombooking.services.BookingService;
import com.medici.roombooking.utils.ControllerUtil;

public class RoomBookingControllerTest {

	BookingService bookingService;
	RoomBookingController controller;
	ControllerUtil util;
	
	@Before
    public void setUp() throws Exception {
		bookingService = mock(BookingService.class);
		controller = new RoomBookingController(bookingService);
		util = mock(ControllerUtil.class);
    }
	
	
	@Test
	public void findRooms() {
		RoomType rt = new RoomType();
		rt.setType("single");
		
		Room room = new Room();
		room.setId(100L);
		room.setRoomType(rt);
		
		List<Room> rooms = new ArrayList<>(Arrays.asList(room)); 
		
		List<RoomResponse> response = new ArrayList<>();
		
        when(bookingService.findRooms()).thenReturn(rooms);
        when(util.toRoomResponseList(rooms)).thenReturn(response);
        
        ResponseEntity<List<RoomResponse>> result = controller.findRooms();
        
        assertEquals(HttpStatus.OK, result.getStatusCode());
	}

}
