package com.projet.java.service;

import com.projet.java.entity.Etudiant;
import com.projet.java.repository.EtudiantRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class EtudiantService {
    private final EtudiantRepository etudiantRepository;

    // Create
    public Etudiant saveEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    // Read
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    public Optional<Etudiant> getEtudiantById(Long id) {
        return etudiantRepository.findById(id);
    }

    // Update
    public Etudiant updateEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    // Delete
    public void deleteEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }
}

//@Service
//public class EtudiantService {
//
//    @Autowired
//    private EtudiantRepository etudiantRepository;
//
//    public Etudiant save(Etudiant e) {
//        return etudiantRepository.save(e);
//    }
//
//    public List<Etudiant> getAll() {
//        return etudiantRepository.findAll();
//    }
//
//    public void delete(Long id) {
//        etudiantRepository.deleteById(id);
//    }
//}
