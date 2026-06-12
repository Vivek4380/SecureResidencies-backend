package com.example.hostel.repository;

import com.example.hostel.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    List<Complaint> findByStatus(Complaint.Status status);
    List<Complaint> findByRoomNumber(String roomNumber);
}