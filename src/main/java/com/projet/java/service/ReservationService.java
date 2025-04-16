package com.projet.java.service;

import com.projet.java.entity.Reservation;
import com.projet.java.repository.ReservationRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;

    // Create
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    // Read
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    // Update
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    // Delete
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}