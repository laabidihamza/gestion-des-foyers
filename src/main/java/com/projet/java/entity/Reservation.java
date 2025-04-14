package com.projet.java.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    @Temporal(TemporalType.DATE)
    private Date anneeUniversitaire;

    private Boolean estValide;

//    @ManyToOne
//    private Etudiant etudiant;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "reservation_etudiant",
            joinColumns = @JoinColumn(name = "idReservation"),
            inverseJoinColumns = @JoinColumn(name = "idEtudiant")
    )
    private List<Etudiant> etudiants = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "idChambre")
    private Chambre chambre;
}
