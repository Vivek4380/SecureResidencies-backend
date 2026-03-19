package com.example.hostel.login.controller;

import com.example.hostel.login.service.AppUserService;
import com.example.hostel.login.entity.ConfirmationToken;
import com.example.hostel.login.service.ConfirmationTokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/registration")
@CrossOrigin(originPatterns = "*")
public class RegistrationConfirmationController {

    private final AppUserService appUserService;
    private final ConfirmationTokenService tokenService;

    public RegistrationConfirmationController(AppUserService appUserService, ConfirmationTokenService tokenService) {
        this.appUserService = appUserService;
        this.tokenService = tokenService;
    }
}
