package com.projet.java.controller;

import com.projet.java.entity.Etudiant;
import com.projet.java.service.EtudiantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiants")
@RequiredArgsConstructor
public class EtudiantController {
    private final EtudiantService etudiantService;

    @PostMapping
    public ResponseEntity<Etudiant> createEtudiant(@RequestBody Etudiant etudiant) {
        return new ResponseEntity<>(etudiantService.saveEtudiant(etudiant), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Etudiant>> getAllEtudiants() {
        return ResponseEntity.ok(etudiantService.getAllEtudiants());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable Long id) {
        return etudiantService.getEtudiantById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiant) {
        if (!etudiantService.getEtudiantById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        etudiant.setIdEtudiant(id);
        return ResponseEntity.ok(etudiantService.updateEtudiant(etudiant));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable Long id) {
        if (!etudiantService.getEtudiantById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        etudiantService.deleteEtudiant(id);
        return ResponseEntity.noContent().build();
    }
}

//@RestController
//@RequestMapping("/etudiants")
//public class EtudiantController {
//
//    @Autowired
//    private EtudiantService etudiantService;
//
//    @PostMapping
//    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
//        return etudiantService.save(etudiant);
//    }
//
//    @GetMapping
//    public List<Etudiant> getAllEtudiants() {
//        return etudiantService.getAll();
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteEtudiant(@PathVariable Long id) {
//        etudiantService.delete(id);
//    }
//}
