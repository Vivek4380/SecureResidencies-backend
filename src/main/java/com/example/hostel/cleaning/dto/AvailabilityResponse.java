package com.example.hostel.cleaning.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AvailabilityResponse {
    private long morningSlots;
    private long afternoonSlots;
    private long eveningSlots;
}