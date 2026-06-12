package com.example.hostel.repository;

import com.example.hostel.entity.GatePass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GatePassRepository extends JpaRepository<GatePass, Long> {
    List<GatePass> findByResidentEmail(String residentEmail);
    List<GatePass> findByStatus(String status);
}