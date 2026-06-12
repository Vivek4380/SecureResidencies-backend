package com.example.hostel.service;

import com.example.hostel.dto.GatePassDTO;
import com.example.hostel.entity.GatePass;
import com.example.hostel.exception.ResourceNotFoundException;
import com.example.hostel.repository.GatePassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GatePassService {

    private final GatePassRepository gatePassRepository;

    @Transactional
    public GatePass createGatePass(GatePassDTO dto) {
        GatePass gatePass = new GatePass();
        gatePass.setVisitReason(dto.getVisitReason());
        gatePass.setEmergencyContact(dto.getEmergencyContact());
        gatePass.setLeaveDate(dto.getLeaveDate());
        gatePass.setReturnDate(dto.getReturnDate());
        gatePass.setResidentEmail(dto.getResidentEmail());
        gatePass.setStatus("PENDING");
        return gatePassRepository.save(gatePass);
    }

    public List<GatePass> getAllGatePasses() {
        return gatePassRepository.findAll();
    }

    public GatePass getGatePassById(Long id) {
        return gatePassRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Gate pass not found with id: " + id));
    }

    public List<GatePass> getGatePassesByEmail(String email) {
        return gatePassRepository.findByResidentEmail(email);
    }

    public List<GatePass> getGatePassesByStatus(String status) {
        return gatePassRepository.findByStatus(status);
    }

    @Transactional
    public GatePass updateStatus(Long id, String status) {
        GatePass gatePass = getGatePassById(id);
        gatePass.setStatus(status);
        return gatePassRepository.save(gatePass);
    }

    @Transactional
    public void deleteGatePass(Long id) {
        GatePass gatePass = getGatePassById(id);
        gatePassRepository.delete(gatePass);
    }
}