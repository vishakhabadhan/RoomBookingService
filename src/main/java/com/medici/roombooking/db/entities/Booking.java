package com.medici.roombooking.db.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_MS_BOOKING")
public class Booking {
    
    @Id
    @GeneratedValue(generator = "BookingSeq")
    @SequenceGenerator(name = "BookingSeq", sequenceName = "SEQ_TBL_BOOKING", allocationSize = 1)
    @Column(name = "ID", nullable = false, updatable = false)
    private long id;
    	
    @Column(name = "check_in_date", nullable = false)
    private LocalDate checkInDate;
    
    @Column(name = "check_out_date", nullable = false)
    private LocalDate checkOutDate;
    
    @Column(name = "booking_creation_date", nullable = false)
    private LocalDateTime bookingCreationDate;
    
    @Column(name = "booking_cancellaton_date")
    private LocalDateTime bookingCancellatonDate;
       
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="room_id", nullable=false)
    private Room room;
    
	public Booking() {
	}

	public Booking(LocalDate checkInDate, LocalDate checkOutDate, Room room) {
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.room = room;
		this.bookingCreationDate = LocalDateTime.now();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	public LocalDateTime getBookingDateTime() {
		return bookingCreationDate;
	}

	public void setBookingDateTime(LocalDateTime bookingDateTime) {
		this.bookingCreationDate = bookingDateTime;
	}

	public LocalDateTime getBookingCreationDate() {
		return bookingCreationDate;
	}

	public void setBookingCreationDate(LocalDateTime bookingCreationDate) {
		this.bookingCreationDate = bookingCreationDate;
	}

	public LocalDateTime getBookingCancellatonDate() {
		return bookingCancellatonDate;
	}

	public void setBookingCancellatonDate(LocalDateTime bookingCancellatonDate) {
		this.bookingCancellatonDate = bookingCancellatonDate;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate
				+ ", room=" + room + "]";
	}
}