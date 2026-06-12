package com.example.hostel.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Slot slot;

    @Column(nullable = false)
    private String roomNumber;

    @Column(nullable = false)
    private boolean cleaned = false;

    public enum Slot {
        MORNING, AFTERNOON, EVENING
    }
}