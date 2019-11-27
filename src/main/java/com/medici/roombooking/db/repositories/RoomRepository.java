package com.medici.roombooking.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.medici.roombooking.db.entities.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
    
}

