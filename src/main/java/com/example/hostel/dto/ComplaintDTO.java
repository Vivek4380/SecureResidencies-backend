package com.example.hostel.dto;

import com.example.hostel.entity.Complaint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ComplaintDTO {

    @NotNull(message = "Category is required")
    private Complaint.Category category;

    @NotBlank(message = "Room number is required")
    private String roomNumber;

    @NotBlank(message = "Description is required")
    private String description;

    private Complaint.Status status;

    public ComplaintDTO() {}

    public Complaint.Category getCategory() { return category; }
    public void setCategory(Complaint.Category category) { this.category = category; }
    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Complaint.Status getStatus() { return status; }
    public void setStatus(Complaint.Status status) { this.status = status; }
}