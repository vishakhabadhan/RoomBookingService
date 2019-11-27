package com.medici.roombooking.db.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medici.roombooking.db.entities.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
	
	@Query("SELECT b FROM Booking b WHERE b.room.id = ?1 and b.checkOutDate >= ?2 and b.checkInDate <= ?3")
	List<Booking> findAllByRoomIdAndCheckInDateCriteria(@Param("roomId") final Long roomId, @Param("checkInDate") final LocalDate checkInDate, @Param("checkOutDate") final LocalDate checkOutDate);
}

