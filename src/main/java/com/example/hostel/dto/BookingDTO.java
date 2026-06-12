package com.example.hostel.dto;

import com.example.hostel.entity.Booking;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class BookingDTO {

    @NotNull(message = "Date is required")
    private LocalDate date;

    @NotNull(message = "Slot is required")
    private Booking.Slot slot;

    @NotBlank(message = "Room number is required")
    private String roomNumber;

    public BookingDTO() {}

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public Booking.Slot getSlot() { return slot; }
    public void setSlot(Booking.Slot slot) { this.slot = slot; }
    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }
}