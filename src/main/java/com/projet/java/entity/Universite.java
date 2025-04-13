package com.projet.java.entity;

import jakarta.persistence.*;

@Entity
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniversite;

    private String nomUniversite;

    @OneToOne(cascade = CascadeType.ALL)
    private Foyer foyer;

    // Getters and Setters
}

