package com.medici.roombooking.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import com.medici.roombooking.db.entities.Room;
import com.medici.roombooking.db.repositories.BookingRepository;
import com.medici.roombooking.db.repositories.RoomRepository;

public class BookingServiceTest {

	RoomRepository roomRepository;
	BookingRepository bookingRepository;
	
	BookingService bookingService;
	
	@Before
    public void setUp() throws Exception {
		roomRepository = mock(RoomRepository.class);
		bookingRepository = mock(BookingRepository.class);
		bookingService = new BookingService(bookingRepository, roomRepository);
    }
	
	@Test
	public void findRooms() {
		Room room = new Room();
		room.setId(100L);
		
		List<Room> rooms = new ArrayList<>(Arrays.asList(room));
		
		Mockito.when(roomRepository.findAll()).thenReturn(rooms);
		
		List<Room> roomList = bookingService.findRooms();
		
		assertNotNull(roomList);
		assertEquals(1, roomList.size());
		assertTrue(roomList.equals(rooms));
	}
}
