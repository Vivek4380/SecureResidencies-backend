package com.example.hostel.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "gate_passes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GatePass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Visit reason is required")
    @Column(nullable = false)
    private String visitReason;

    @NotBlank(message = "Emergency contact is required")
    @Column(nullable = false)
    private String emergencyContact;

    @NotNull(message = "Leave date is required")
    @Column(nullable = false)
    private LocalDate leaveDate;

    @NotNull(message = "Return date is required")
    @Column(nullable = false)
    private LocalDate returnDate;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Resident email is required")
    @Column(nullable = false)
    private String residentEmail;

    @Column(nullable = false)
    private String status = "PENDING";
}