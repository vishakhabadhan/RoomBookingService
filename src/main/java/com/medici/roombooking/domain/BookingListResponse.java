package com.medici.roombooking.domain;

import java.time.LocalDate;

public class BookingListResponse {

	private Long bookingId;
	private Long roomId;
	private String roomType;
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	
	public BookingListResponse(Long bookingId, Long roomId, String roomType, LocalDate checkInDate,
			LocalDate checkOutDate) {
		this.bookingId = bookingId;
		this.roomId = roomId;
		this.roomType = roomType;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
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

	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}	
}
