package com.projet.java.service;

import com.projet.java.entity.Foyer;
import com.projet.java.repository.FoyerRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class FoyerService {
    private final FoyerRepository foyerRepository;

    // Create
    public Foyer saveFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    // Read
    public List<Foyer> getAllFoyers() {
        return foyerRepository.findAll();
    }

    public Optional<Foyer> getFoyerById(Long id) {
        return foyerRepository.findById(id);
    }

    // Update
    public Foyer updateFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    // Delete
    public void deleteFoyer(Long id) {
        foyerRepository.deleteById(id);
    }
}
