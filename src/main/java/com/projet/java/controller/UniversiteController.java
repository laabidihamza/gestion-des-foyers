package com.projet.java.controller;

import com.projet.java.entity.Universite;
import com.projet.java.service.UniversiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/universites")
@RequiredArgsConstructor
public class UniversiteController {
    private final UniversiteService universiteService;

    @PostMapping
    public ResponseEntity<Universite> createUniversite(@RequestBody Universite universite) {
        return new ResponseEntity<>(universiteService.saveUniversite(universite), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Universite>> getAllUniversites() {
        return ResponseEntity.ok(universiteService.getAllUniversites());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Universite> getUniversiteById(@PathVariable Long id) {
        return universiteService.getUniversiteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Universite> updateUniversite(@PathVariable Long id, @RequestBody Universite universite) {
        if (!universiteService.getUniversiteById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        universite.setIdUniversite(id);
        return ResponseEntity.ok(universiteService.updateUniversite(universite));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUniversite(@PathVariable Long id) {
        if (!universiteService.getUniversiteById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        universiteService.deleteUniversite(id);
        return ResponseEntity.noContent().build();
    }
}

//@RestController
//@RequestMapping("/universites")
//@RequiredArgsConstructor
//public class UniversiteController {
//
//    @Autowired
//    private UniversiteService universiteService;
//
//    @PostMapping
//    public Universite addUniversite(@RequestBody Universite universite) {
//        return universiteService.save(universite);
//    }
//
//    @GetMapping
//    public List<Universite> getAllUniversites() {
//        return universiteService.getAll();
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteUniversite(@PathVariable Long id) {
//        universiteService.delete(id);
//    }
//
//}