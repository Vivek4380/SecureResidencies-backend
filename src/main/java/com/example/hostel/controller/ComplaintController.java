package com.example.hostel.controller;

import com.example.hostel.dto.ComplaintDTO;
import com.example.hostel.entity.Complaint;
import com.example.hostel.service.ComplaintService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/complaints")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ComplaintController {

    private final ComplaintService complaintService;

    @PostMapping
    public ResponseEntity<Complaint> createComplaint(@Valid @RequestBody ComplaintDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(complaintService.createComplaint(dto));
    }

    @GetMapping
    public ResponseEntity<List<Complaint>> getAllComplaints() {
        return ResponseEntity.ok(complaintService.getAllComplaints());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Complaint> getComplaintById(@PathVariable Long id) {
        return ResponseEntity.ok(complaintService.getComplaintById(id));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Complaint>> getComplaintsByStatus(@PathVariable Complaint.Status status) {
        return ResponseEntity.ok(complaintService.getComplaintsByStatus(status));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Complaint> updateStatus(
            @PathVariable Long id,
            @RequestParam Complaint.Status status) {
        return ResponseEntity.ok(complaintService.updateStatus(id, status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComplaint(@PathVariable Long id) {
        complaintService.deleteComplaint(id);
        return ResponseEntity.noContent().build();
    }
}