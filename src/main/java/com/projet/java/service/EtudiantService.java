package com.projet.java.service;

import com.projet.java.entity.Etudiant;
import com.projet.java.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    public Etudiant save(Etudiant e) {
        return etudiantRepository.save(e);
    }

    public List<Etudiant> getAll() {
        return etudiantRepository.findAll();
    }

    public void delete(Long id) {
        etudiantRepository.deleteById(id);
    }
}
