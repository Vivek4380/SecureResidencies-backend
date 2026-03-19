package com.example.hostel.complaint.dto;

import com.example.hostel.complaint.entity.Complaint;
import jakarta.validation.constraints.NotNull;

public record UpdateStatusRequest(
        @NotNull Complaint.Status status
) {}
