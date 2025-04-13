package com.projet.java.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;

    private Long numeroChambre;

    @ManyToOne
    private Bloc bloc;

    @OneToMany(mappedBy = "chambre", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();

    // Getters and Setters
}
