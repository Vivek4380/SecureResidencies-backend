package com.example.hostel.entry_exit_flow.Controller;

import com.example.hostel.entry_exit_flow.Model.GatePass;
import com.example.hostel.entry_exit_flow.Service.GatePassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resident")
public class GatePassController {

    @Autowired
    private GatePassService gatePassService;

    @PostMapping("/gatepass")
    public ResponseEntity<?> createGatePass(
            @RequestParam String residentEmail,
            @RequestBody GatePass gatePass) {
        try {
            gatePass.setResidentEmail(residentEmail);
            GatePass savedGatePass = gatePassService.createGatePass(gatePass);
            return ResponseEntity.ok("Gate pass created successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/gatepass/{passId}/status")
    public ResponseEntity<GatePass> updateGatePassStatus(
            @PathVariable Long passId,
            @RequestParam String status) {
        return ResponseEntity.ok(gatePassService.updateGatePassStatus(passId, status));
    }
}

