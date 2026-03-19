package com.example.hostel.cleaning.dto;

import com.example.hostel.cleaning.entity.Slot;
import com.example.hostel.cleaning.validation.FutureDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateBookingRequest {
    @NotNull
    @FutureDate
    private LocalDate date;

    @NotNull
    private Slot slot;

    @NotBlank
    private String room;
}
