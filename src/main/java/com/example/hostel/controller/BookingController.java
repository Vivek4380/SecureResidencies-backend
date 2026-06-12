package com.example.hostel.controller;

import com.example.hostel.dto.BookingDTO;
import com.example.hostel.entity.Booking;
import com.example.hostel.service.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> createBooking(@Valid @RequestBody BookingDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.createBooking(dto));
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.getBookingById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Booking>> getBookingsByDateAndRoom(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam String roomNumber) {
        return ResponseEntity.ok(bookingService.getBookingsByDateAndRoom(date, roomNumber));
    }

    @GetMapping("/uncleaned")
    public ResponseEntity<List<Booking>> getUncleanedRooms() {
        return ResponseEntity.ok(bookingService.getUncleanedRooms());
    }

    @PatchMapping("/{id}/mark-cleaned")
    public ResponseEntity<Booking> markAsCleaned(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.markAsCleaned(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}