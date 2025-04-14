package com.projet.java.service;

import com.projet.java.entity.Universite;
import com.projet.java.repository.UniversiteRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UniversiteService {
    private final UniversiteRepository universiteRepository;

    // Create - When we create a University, we also create its Foyer (cascade is used)
    public Universite saveUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    // Read
    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }

    public Optional<Universite> getUniversiteById(Long id) {
        return universiteRepository.findById(id);
    }

    // Update
    public Universite updateUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    // Delete - When we delete a University, we also delete its Foyer (cascade is used)
    public void deleteUniversite(Long id) {
        universiteRepository.deleteById(id);
    }
}

//@Service
//public class UniversiteService {
//
//    @Autowired
//    private UniversiteRepository universiteRepository;
//
//    public Universite save(Universite u) {
//        return universiteRepository.save(u);
//    }
//
//    public List<Universite> getAll() {
//        return universiteRepository.findAll();
//    }
//
//    public void delete(Long id) {
//        universiteRepository.deleteById(id);
//    }
