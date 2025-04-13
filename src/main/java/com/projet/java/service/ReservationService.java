package com.projet.java.service;

import com.projet.java.entity.Reservation;
import com.projet.java.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation save(Reservation r) {
        return reservationRepository.save(r);
    }

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    public void delete(Long id) {
        reservationRepository.deleteById(id);
    }
}
