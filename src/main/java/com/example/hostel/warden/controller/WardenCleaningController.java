package com.example.hostel.warden.controller;

import com.example.hostel.cleaning.entity.Booking;
import com.example.hostel.cleaning.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warden")
public class WardenCleaningController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/uncleaned-rooms")
    public ResponseEntity<List<Booking>> getUncleanedRooms() {
        return ResponseEntity.ok(bookingService.getUncleanedRooms());
    }

    @PostMapping("/rooms/{roomId}/mark-cleaned")
    public ResponseEntity<Booking> markRoomAsCleaned(@PathVariable Long roomId) {
        return ResponseEntity.ok(bookingService.markRoomAsCleaned(roomId));
    }
} 