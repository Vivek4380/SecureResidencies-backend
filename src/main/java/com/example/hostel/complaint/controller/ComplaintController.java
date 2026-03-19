package com.example.hostel.complaint.controller;

import com.example.hostel.complaint.dto.CreateComplaintRequest;
import com.example.hostel.complaint.dto.UpdateStatusRequest;
import com.example.hostel.complaint.entity.Complaint;
import com.example.hostel.complaint.service.ComplaintService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/complaints")
@RequiredArgsConstructor
@CrossOrigin(originPatterns = "*")  // Added explicit CORS annotation
public class ComplaintController {

    private final ComplaintService complaintService;

    @PostMapping("/")
    public ResponseEntity<Complaint> createComplaint(
            @Valid @RequestBody CreateComplaintRequest request
            // TODO: Add @RequestParam MultipartFile image for image upload support in future
    ) {
        log.info("Received complaint creation request - Category: {}, Room: {}, Description: {}",
                request.category(), request.roomNumber(), request.description());
        try {
            Complaint created = complaintService.createComplaint(request);
            log.info("Successfully created complaint with id: {}", created.getId());
            return ResponseEntity.ok(created);
        } catch (Exception e) {
            log.error("Error creating complaint: {}", e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping("/")
    public List<Complaint> getAllComplaints() {
        log.info("Fetching all complaints");
        return complaintService.getAllComplaints();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Complaint> getComplaintById(@PathVariable Long id) {
        log.info("Fetching complaint by id: {}", id);
        return ResponseEntity.ok(complaintService.getComplaintById(id));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Complaint> updateStatus(
            @PathVariable Long id,
            @Valid @RequestBody UpdateStatusRequest request
    ) {
        log.info("Updating status for complaint id {} to {}", id, request.status());
        Complaint updated = complaintService.updateStatus(id, request.status());
        log.info("Updated complaint id {} to status {}", id, updated.getStatus());
        return ResponseEntity.ok(updated);
    }
}
