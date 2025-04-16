package com.projet.java.service;

import com.projet.java.entity.Chambre;
import com.projet.java.repository.ChambreRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ChambreService {
    private final ChambreRepository chambreRepository;

    // Create
    public Chambre saveChambre(Chambre chambre) {
        // Check if numeroChambre is unique
        if (chambreRepository.existsByNumeroChambre(chambre.getNumeroChambre())) {
            throw new IllegalArgumentException("Chamber number already exists: " + chambre.getNumeroChambre());
        }
        return chambreRepository.save(chambre);
    }

    // Read
    public List<Chambre> getAllChambres() {
        return chambreRepository.findAll();
    }

    public Optional<Chambre> getChambreById(Long id) {
        return chambreRepository.findById(id);
    }

    // Update
    public Chambre updateChambre(Chambre chambre) {
        // Check if numeroChambre is unique
        Chambre existingChambre = chambreRepository.findById(chambre.getIdChambre())
                .orElseThrow(() -> new IllegalArgumentException("Chamber not found: " + chambre.getIdChambre()));

        if (!existingChambre.getNumeroChambre().equals(chambre.getNumeroChambre()) &&
                chambreRepository.existsByNumeroChambre(chambre.getNumeroChambre())) {
            throw new IllegalArgumentException("Chamber number already exists: " + chambre.getNumeroChambre());
        }

        return chambreRepository.save(chambre);
    }

    // Delete
    public void deleteChambre(Long id) {
        chambreRepository.deleteById(id);
    }
}

