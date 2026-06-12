package com.example.hostel.service;

import com.example.hostel.dto.ComplaintDTO;
import com.example.hostel.entity.Complaint;
import com.example.hostel.exception.ResourceNotFoundException;
import com.example.hostel.repository.ComplaintRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ComplaintService {

    private final ComplaintRepository complaintRepository;

    @Transactional
    public Complaint createComplaint(ComplaintDTO dto) {
        Complaint complaint = new Complaint();
        complaint.setCategory(dto.getCategory());
        complaint.setRoomNumber(dto.getRoomNumber());
        complaint.setDescription(dto.getDescription());
        complaint.setStatus(Complaint.Status.PENDING);
        return complaintRepository.save(complaint);
    }

    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    public Complaint getComplaintById(Long id) {
        return complaintRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Complaint not found with id: " + id));
    }

    public List<Complaint> getComplaintsByStatus(Complaint.Status status) {
        return complaintRepository.findByStatus(status);
    }

    @Transactional
    public Complaint updateStatus(Long id, Complaint.Status status) {
        Complaint complaint = getComplaintById(id);
        complaint.setStatus(status);
        return complaintRepository.save(complaint);
    }

    @Transactional
    public void deleteComplaint(Long id) {
        Complaint complaint = getComplaintById(id);
        complaintRepository.delete(complaint);
    }
}