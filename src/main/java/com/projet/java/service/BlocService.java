package com.projet.java.service;

import com.projet.java.entity.Bloc;
import com.projet.java.repository.BlocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlocService {

    @Autowired
    private BlocRepository blocRepository;

    public Bloc save(Bloc b) {
        return blocRepository.save(b);
    }

    public List<Bloc> getAll() {
        return blocRepository.findAll();
    }

    public void delete(Long id) {
        blocRepository.deleteById(id);
    }
}
