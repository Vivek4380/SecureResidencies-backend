package com.example.hostel.entry_exit_flow.Service;

import com.example.hostel.entry_exit_flow.Model.GatePass;
import com.example.hostel.entry_exit_flow.Repository.GatePassRepository;
import com.example.hostel.entry_exit_flow.Repository.ResidentRepository;
import com.example.hostel.entry_exit_flow.Model.Resident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GatePassService {

    @Autowired
    private GatePassRepository gatePassRepository;

    @Autowired
    private ResidentRepository residentRepository;

    @Autowired
    private EntryExitEmailService emailService;

    public GatePass createGatePass(GatePass gatePass) {
        GatePass savedPass = gatePassRepository.save(gatePass);

        // Find the resident by email
        Resident resident = residentRepository.findByResidentEmail(gatePass.getResidentEmail())
                .orElse(null);
        if (resident != null) {
            System.out.println("About to send approval mail for resident: " + resident.getResidentEmail());
            emailService.sendApprovalMail(resident);
        } else {
            System.out.println("Resident not found for email: " + gatePass.getResidentEmail());
        }

        return savedPass;
    }

    public List<GatePass> getGatePassesByEmail(String email) {
        return gatePassRepository.findByResidentEmail(email);
    }

    public GatePass getGatePassById(Long id) {
        return gatePassRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gate pass not found"));
    }

    public List<GatePass> getApprovedPasses() {
        return gatePassRepository.findByStatus("APPROVED");
    }

    public List<GatePass> getAllPasses() {
        return gatePassRepository.findAll();
    }

    public GatePass updateGatePassStatus(Long passId, String status) {
        GatePass pass = gatePassRepository.findById(passId)
            .orElseThrow(() -> new RuntimeException("Gate pass not found"));
        pass.setStatus(status);
        return gatePassRepository.save(pass);
    }
}
