package com.medici.roombooking.db.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_MS_ROOM_TYPE")
public class RoomType {
    
    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    private int id;
    
    @Column(name = "type")
    private String Type;

    @OneToOne(mappedBy = "roomType")
    private Room room;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "RoomType [id=" + id + ", Type=" + Type + ", room=" + room + "]";
	}
}