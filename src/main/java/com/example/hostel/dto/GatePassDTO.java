package com.example.hostel.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class GatePassDTO {

    @NotBlank(message = "Visit reason is required")
    private String visitReason;

    @NotBlank(message = "Emergency contact is required")
    private String emergencyContact;

    @NotNull(message = "Leave date is required")
    private LocalDate leaveDate;

    @NotNull(message = "Return date is required")
    private LocalDate returnDate;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Resident email is required")
    private String residentEmail;

    public GatePassDTO() {}

    public String getVisitReason() { return visitReason; }
    public void setVisitReason(String visitReason) { this.visitReason = visitReason; }
    public String getEmergencyContact() { return emergencyContact; }
    public void setEmergencyContact(String emergencyContact) { this.emergencyContact = emergencyContact; }
    public LocalDate getLeaveDate() { return leaveDate; }
    public void setLeaveDate(LocalDate leaveDate) { this.leaveDate = leaveDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }
    public String getResidentEmail() { return residentEmail; }
    public void setResidentEmail(String residentEmail) { this.residentEmail = residentEmail; }
}