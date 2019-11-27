package com.medici.roombooking.services;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.medici.roombooking.db.entities.Booking;
import com.medici.roombooking.db.entities.Room;
import com.medici.roombooking.db.repositories.BookingRepository;
import com.medici.roombooking.db.repositories.RoomRepository;
import com.medici.roombooking.domain.CreateBookingRequest;
import com.medici.roombooking.domain.BookingResponse;

@Service
public class BookingService {
    
    private static final Logger log = LoggerFactory.getLogger(BookingService.class);
    
    RoomRepository roomRepository;
    BookingRepository bookingRepository;
    
    @Autowired
    public BookingService(BookingRepository bookingRepository, RoomRepository roomRepository) {
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
    }
        
    public List<Room> findRooms() {
        log.info("findRooms");
        return roomRepository.findAll();
    }
    
    public BookingResponse createBooking(final CreateBookingRequest createBookingRequest) {
        log.info("createBooking"); 
        
        if(!validateBooking(createBookingRequest)) {
        	log.info("invalid booking, overlapping booking dates");	
        	return new BookingResponse(null, false);
        }
        
        log.info("Booking successful");
        return new BookingResponse(bookingRepository.save(new Booking(
        		createBookingRequest.getCheckInDate(), createBookingRequest.getCheckOutDate(),
        		roomRepository.findById(createBookingRequest.getRoomId()).get())).getId(), true);
    }
      
    private boolean validateBooking(CreateBookingRequest createBookingRequest) {
    	log.info("Validate booking dates");
    	
    	if(createBookingRequest.getCheckInDate().isAfter(createBookingRequest.getCheckOutDate())) {
    		log.info("CheckInDate is after checkOutDate");
    		return false;
    	}
    	
    	log.info("Finding overlapping booking dates");
    	List<Booking> bookingList = bookingRepository.findAllByRoomIdAndCheckInDateCriteria(
    			createBookingRequest.getRoomId(), createBookingRequest.getCheckInDate(), createBookingRequest.getCheckOutDate());
    	return bookingList != null && !bookingList.isEmpty() ? false : true;
    }
    
    public List<Booking> findBookings() {
        log.info("findBooking");
        return bookingRepository.findAll();
    }  
}