package com.example.hostel.warden.controller;

import com.example.hostel.entry_exit_flow.Model.GatePass;
import com.example.hostel.entry_exit_flow.Service.GatePassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warden/passes")
public class WardenPassController {

    @Autowired
    private GatePassService gatePassService;

    @GetMapping("/approved")
    public ResponseEntity<List<GatePass>> getApprovedPasses() {
        return ResponseEntity.ok(gatePassService.getApprovedPasses());
    }

    @GetMapping
    public ResponseEntity<List<GatePass>> getAllPasses() {
        return ResponseEntity.ok(gatePassService.getAllPasses());
    }
} 