package com.medici.roombooking.domain;

import java.util.Optional;

import com.medici.roombooking.db.entities.Booking;

public class BookingResponse {

	private Long dbId = null;
	private Boolean bookingSuccessful = false;
		
	public BookingResponse(Optional<Booking> response) {				
		if(response.isPresent()){
			this.dbId = response.get().getId();
			this.bookingSuccessful = true;
		}		
	}
	
	public Long getDbId() {
		return dbId;
	}
	public void setDbId(Long dbId) {
		this.dbId = dbId;
	}
	public Boolean getBookingSuccessful() {
		return bookingSuccessful;
	}
	public void setBookingSuccessful(Boolean bookingSuccessful) {
		this.bookingSuccessful = bookingSuccessful;
	}
}
