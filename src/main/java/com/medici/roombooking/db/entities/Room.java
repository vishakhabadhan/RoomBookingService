package com.medici.roombooking.db.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_MS_ROOM")
public class Room {
    
    @Id
    @GeneratedValue(generator = "RoomSeq")
    @SequenceGenerator(name = "RoomSeq", sequenceName = "SEQ_TBL_ROOM", allocationSize = 1)
    @Column(name = "ID", nullable = false, updatable = false)
    private long id;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_type", referencedColumnName = "id")
    private RoomType roomType;
    
    @OneToMany(mappedBy="room", fetch=FetchType.EAGER)
    private List<Booking> booking = new ArrayList<>();
    
	public Room() {
	}

	public Room(RoomType roomType, List<Booking> booking) {
		this.roomType = roomType;
		this.booking = booking;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}  
}