package com.example.hostel.service;

import com.example.hostel.dto.BookingDTO;
import com.example.hostel.entity.Booking;
import com.example.hostel.exception.ResourceNotFoundException;
import com.example.hostel.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private static final int MAX_BOOKINGS_PER_SLOT = 7;

    private final BookingRepository bookingRepository;

    @Transactional
    public Booking createBooking(BookingDTO dto) {
        if (dto.getDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Cannot create booking for past dates");
        }
        long count = bookingRepository.countByDateAndSlot(dto.getDate(), dto.getSlot());
        if (count >= MAX_BOOKINGS_PER_SLOT) {
            throw new IllegalArgumentException("Slot is full for selected date");
        }
        Booking booking = new Booking();
        booking.setDate(dto.getDate());
        booking.setSlot(dto.getSlot());
        booking.setRoomNumber(dto.getRoomNumber());
        booking.setCleaned(false);
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));
    }

    public List<Booking> getBookingsByDateAndRoom(LocalDate date, String roomNumber) {
        return bookingRepository.findByDateAndRoomNumber(date, roomNumber);
    }

    public List<Booking> getUncleanedRooms() {
        return bookingRepository.findByCleanedFalse();
    }

    @Transactional
    public Booking markAsCleaned(Long id) {
        Booking booking = getBookingById(id);
        booking.setCleaned(true);
        return bookingRepository.save(booking);
    }

    @Transactional
    public void deleteBooking(Long id) {
        Booking booking = getBookingById(id);
        bookingRepository.delete(booking);
    }
}