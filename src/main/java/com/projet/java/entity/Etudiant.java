package com.projet.java.entity;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.Digits;

import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Etudiant {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;

    private String nomEt;
    private String prenomEt;

    @Digits(integer = 8, fraction = 0, message = "CIN must be exactly 8 digits")
    private Long cin;

    private String ecole;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @ManyToMany(mappedBy = "etudiants")
    private List<Reservation> reservations = new ArrayList<>();
}
