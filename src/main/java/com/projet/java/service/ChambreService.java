package com.projet.java.service;

import com.projet.java.entity.Chambre;
import com.projet.java.repository.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChambreService {

    @Autowired
    private ChambreRepository chambreRepository;

    public Chambre save(Chambre c) {
        return chambreRepository.save(c);
    }

    public List<Chambre> getAll() {
        return chambreRepository.findAll();
    }

    public void delete(Long id) {
        chambreRepository.deleteById(id);
    }
}
