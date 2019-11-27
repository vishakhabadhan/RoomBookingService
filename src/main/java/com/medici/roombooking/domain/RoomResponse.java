package com.medici.roombooking.domain;

import java.time.LocalDate;
import java.util.List;

public class RoomResponse {
	
	private Long roomId;
	private String roomType;
	private List<LocalDate> bookingDates;
	
	public RoomResponse(Long roomId, String roomType, List<LocalDate> bookingDates) {
		this.roomId = roomId;
		this.roomType = roomType;
		this.bookingDates = bookingDates;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public List<LocalDate> getBookingDates() {
		return bookingDates;
	}

	public void setBookingDates(List<LocalDate> bookingDates) {
		this.bookingDates = bookingDates;
	}	
}
