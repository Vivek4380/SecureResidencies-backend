package com.example.hostel.login.controller;

import com.example.hostel.login.entity.AppUser;
import com.example.hostel.login.service.AppUserService;
import com.example.hostel.login.dto.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
@RequiredArgsConstructor
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final AppUserService appUserService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Authenticate the user
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    )
            );

            // Fetch the authenticated user details
            AppUser user = appUserService.findUserByEmail(loginRequest.getEmail());

            // Return success response (could be user DTO or JWT token)
            return ResponseEntity.ok("Login successful");

        } catch (Exception e) {
            // Log the exception for debugging
            e.printStackTrace();

            // Return unauthorized status with error message
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Login failed: " + e.getMessage());
        }
    }
}
