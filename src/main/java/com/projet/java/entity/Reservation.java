package com.projet.java.entity;

import jakarta.persistence.*;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    @ManyToOne
    private Etudiant etudiant;

    @ManyToOne
    private Chambre chambre;

    // Getters and Setters
}
