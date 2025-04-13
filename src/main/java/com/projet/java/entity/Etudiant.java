package com.projet.java.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;

    private String nomEtudiant;

    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();

    // Getters and Setters
}
