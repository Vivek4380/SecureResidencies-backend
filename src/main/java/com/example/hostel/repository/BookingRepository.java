package com.example.hostel.repository;

import com.example.hostel.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByDateAndRoomNumber(LocalDate date, String roomNumber);
    List<Booking> findByCleanedFalse();

    @Query("SELECT COUNT(b) FROM Booking b WHERE b.date = :date AND b.slot = :slot")
    long countByDateAndSlot(@Param("date") LocalDate date, @Param("slot") Booking.Slot slot);
}