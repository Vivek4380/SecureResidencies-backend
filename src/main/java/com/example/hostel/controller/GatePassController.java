package com.example.hostel.controller;

import com.example.hostel.dto.GatePassDTO;
import com.example.hostel.entity.GatePass;
import com.example.hostel.service.GatePassService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/gatepasses")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class GatePassController {

    private final GatePassService gatePassService;

    @PostMapping
    public ResponseEntity<GatePass> createGatePass(@Valid @RequestBody GatePassDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(gatePassService.createGatePass(dto));
    }

    @GetMapping
    public ResponseEntity<List<GatePass>> getAllGatePasses() {
        return ResponseEntity.ok(gatePassService.getAllGatePasses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GatePass> getGatePassById(@PathVariable Long id) {
        return ResponseEntity.ok(gatePassService.getGatePassById(id));
    }

    @GetMapping("/resident/{email}")
    public ResponseEntity<List<GatePass>> getGatePassesByEmail(@PathVariable String email) {
        return ResponseEntity.ok(gatePassService.getGatePassesByEmail(email));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<GatePass>> getGatePassesByStatus(@PathVariable String status) {
        return ResponseEntity.ok(gatePassService.getGatePassesByStatus(status));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<GatePass> updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return ResponseEntity.ok(gatePassService.updateStatus(id, status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGatePass(@PathVariable Long id) {
        gatePassService.deleteGatePass(id);
        return ResponseEntity.noContent().build();
    }
}