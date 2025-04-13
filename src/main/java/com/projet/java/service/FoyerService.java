package com.projet.java.service;

import com.projet.java.entity.Foyer;
import com.projet.java.repository.FoyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoyerService {

    @Autowired
    private FoyerRepository foyerRepository;

    public Foyer save(Foyer f) {
        return foyerRepository.save(f);
    }

    public List<Foyer> getAll() {
        return foyerRepository.findAll();
    }

    public void delete(Long id) {
        foyerRepository.deleteById(id);
    }
}

