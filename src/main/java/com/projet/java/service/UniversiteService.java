package com.projet.java.service;

import com.projet.java.entity.Universite;
import com.projet.java.repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversiteService {

    @Autowired
    private UniversiteRepository universiteRepository;

    public Universite save(Universite u) {
        return universiteRepository.save(u);
    }

    public List<Universite> getAll() {
        return universiteRepository.findAll();
    }

    public void delete(Long id) {
        universiteRepository.deleteById(id);
    }
}