package com.example.hostel.warden.controller;

import com.example.hostel.complaint.entity.Complaint;
import com.example.hostel.complaint.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warden/complaints")
public class WardenComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @GetMapping
    public ResponseEntity<List<Complaint>> getAllComplaints() {
        return ResponseEntity.ok(complaintService.getAllComplaints());
    }

    @PostMapping("/{complaintId}/complete")
    public ResponseEntity<Complaint> markComplaintAsCompleted(@PathVariable Long complaintId) {
        return ResponseEntity.ok(complaintService.markComplaintAsCompleted(complaintId));
    }
} 