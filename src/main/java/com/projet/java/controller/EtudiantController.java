package com.projet.java.controller;

import com.projet.java.entity.Etudiant;
import com.projet.java.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @PostMapping
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.save(etudiant);
    }

    @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteEtudiant(@PathVariable Long id) {
        etudiantService.delete(id);
    }
}
