package com.example.hostel.entry_exit_flow.Repository;

import com.example.hostel.entry_exit_flow.Model.GatePass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GatePassRepository extends JpaRepository<GatePass, Long> {
    List<GatePass> findByResidentEmail(String email);
    List<GatePass> findByStatus(String status);
}

