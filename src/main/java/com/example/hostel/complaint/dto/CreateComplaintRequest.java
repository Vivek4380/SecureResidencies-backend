package com.example.hostel.complaint.dto;

import com.example.hostel.complaint.entity.Complaint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateComplaintRequest(
        @NotNull Complaint.Category category,
        @NotBlank String roomNumber,
        @NotBlank String description
) {}