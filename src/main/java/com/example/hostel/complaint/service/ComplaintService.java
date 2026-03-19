package com.example.hostel.complaint.service;

import com.example.hostel.complaint.dto.CreateComplaintRequest;
import com.example.hostel.complaint.entity.Complaint;
import com.example.hostel.complaint.repository.ComplaintRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComplaintService {

    private final ComplaintRepository complaintRepository;

    @Transactional
    public Complaint createComplaint(CreateComplaintRequest request) {
        Complaint complaint = Complaint.builder()
                .category(request.category())
                .roomNumber(request.roomNumber())
                .description(request.description())
                .status(Complaint.Status.PENDING)
                .build();
        return complaintRepository.save(complaint);
    }

    @Transactional(readOnly = true)
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Complaint getComplaintById(Long id) {
        return complaintRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Complaint not found"));
    }

    @Transactional
    public Complaint updateStatus(Long id, Complaint.Status status) {
        Complaint complaint = getComplaintById(id);
        complaint.setStatus(status);
        return complaintRepository.save(complaint);
    }

    @Transactional
    public Complaint markComplaintAsCompleted(Long id) {
        Complaint complaint = getComplaintById(id);
        complaint.setStatus(Complaint.Status.RESOLVED);
        return complaintRepository.save(complaint);
    }
}
