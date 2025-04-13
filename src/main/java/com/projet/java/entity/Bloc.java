package com.projet.java.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;

    private String nomBloc;

    @ManyToOne
    private Foyer foyer;

    @OneToMany(mappedBy = "bloc", cascade = CascadeType.ALL)
    private List<Chambre> chambres = new ArrayList<>();

    // Getters and Setters
}
