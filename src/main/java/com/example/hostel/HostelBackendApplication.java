package com.example.hostel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.hostel")
public class HostelBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(HostelBackendApplication.class, args);
    }
}
