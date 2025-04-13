package com.projet.java.controller;

import com.projet.java.entity.Reservation;
import com.projet.java.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.delete(id);
    }
}
