package com.medici.roombooking.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.medici.roombooking.db.entities.Booking;
import com.medici.roombooking.db.entities.Room;
import com.medici.roombooking.domain.BookingListResponse;
import com.medici.roombooking.domain.RoomResponse;

public class ControllerUtil {

	public List<RoomResponse> toRoomResponseList(List<Room> rooms) {		
		return rooms.stream().map(r -> new RoomResponse(r.getId(), 
				r.getRoomType().getType(),
				toLocalDateList(r.getBooking())))
				.collect(Collectors.toList());
	}

	public List<LocalDate> toLocalDateList(List<Booking> list) {
		List<LocalDate> bookingDates = new ArrayList<>();
		list.forEach(b -> bookingDates.addAll(getDatesBetween(b.getCheckInDate(), b.getCheckOutDate())));
		return bookingDates;
	}
		  	
	public List<LocalDate> getDatesBetween(LocalDate startDate, LocalDate endDate) { 
		long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate); 
		return IntStream.iterate(0, i -> i + 1)
			      .limit(numOfDaysBetween)
			      .mapToObj(i -> startDate.plusDays(i))
			      .collect(Collectors.toList()); 
	}
		
	public List<BookingListResponse> toBookingListResponse(List<Booking> bookings) {		
		return bookings.stream().map(b -> new BookingListResponse(
				b.getId(), b.getRoom().getId(), b.getRoom().getRoomType().getType(), 
				b.getCheckInDate(), b.getCheckOutDate())).collect(Collectors.toList());
	}
}
