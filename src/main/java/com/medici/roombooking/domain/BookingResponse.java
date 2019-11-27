package com.medici.roombooking.domain;

public class BookingResponse {

	private Long dbId;
	private Boolean bookingSuccessful;
		
	public BookingResponse(Long dbId, Boolean bookingSuccessful) {
		this.dbId = dbId;
		this.bookingSuccessful = bookingSuccessful;
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
