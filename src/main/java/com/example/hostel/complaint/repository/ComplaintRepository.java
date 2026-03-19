package com.example.hostel.complaint.repository;

import com.example.hostel.complaint.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
}