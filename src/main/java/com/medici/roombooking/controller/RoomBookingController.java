package com.medici.roombooking.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.medici.roombooking.domain.RoomResponse;
import com.medici.roombooking.domain.CreateBookingRequest;
import com.medici.roombooking.domain.BookingListResponse;
import com.medici.roombooking.domain.BookingResponse;
import com.medici.roombooking.services.BookingService;
import com.medici.roombooking.utils.ControllerUtil;

@RestController
@RequestMapping("/")
public class RoomBookingController {
	
private static final Logger log = LoggerFactory.getLogger(RoomBookingController.class);
    
    private BookingService bookingService;
    private ControllerUtil controllerUtil;
    
    @Autowired
    public RoomBookingController(BookingService bookingService) {
        this.bookingService = bookingService;
        this.controllerUtil = new ControllerUtil();
    }
    
    @RequestMapping(path = "rooms", method = RequestMethod.GET)
    public ResponseEntity<List<RoomResponse>> findRooms() {
        log.info("Controller findRooms");
        List<RoomResponse> response = controllerUtil.toRoomResponseList(bookingService.findRooms());
        return ResponseEntity.ok().body(response);
    }
    
    @RequestMapping(path = "booking", method = RequestMethod.POST)
    public ResponseEntity<BookingResponse> createBooking(@RequestBody final CreateBookingRequest createBookingRequest) {
        log.info("Controller createBooking");
        BookingResponse response = new BookingResponse(bookingService.createBooking(createBookingRequest));
        return ResponseEntity.ok().body(response);
    }   
    
    @RequestMapping(path = "bookings", method = RequestMethod.GET)
    public ResponseEntity<List<BookingListResponse>> findBooking() {
        log.info("Controller findBooking");
        List<BookingListResponse> response = controllerUtil.toBookingListResponse(bookingService.findBookings());
        return ResponseEntity.ok().body(response);
    } 
}
