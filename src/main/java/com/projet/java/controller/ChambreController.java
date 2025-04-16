package com.projet.java.controller;

import com.projet.java.entity.Chambre;
import com.projet.java.service.ChambreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chambres")
@RequiredArgsConstructor
public class ChambreController {
    private final ChambreService chambreService;

    @PostMapping
    public ResponseEntity<Chambre> createChambre(@RequestBody Chambre chambre) {
        try {
            return new ResponseEntity<>(chambreService.saveChambre(chambre), HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Chambre>> getAllChambres() {
        return ResponseEntity.ok(chambreService.getAllChambres());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chambre> getChambreById(@PathVariable Long id) {
        return chambreService.getChambreById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chambre> updateChambre(@PathVariable Long id, @RequestBody Chambre chambre) {
        try {
            if (!chambreService.getChambreById(id).isPresent()) {
                return ResponseEntity.notFound().build();
            }
            chambre.setIdChambre(id);
            return ResponseEntity.ok(chambreService.updateChambre(chambre));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChambre(@PathVariable Long id) {
        if (!chambreService.getChambreById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        chambreService.deleteChambre(id);
        return ResponseEntity.noContent().build();
    }
}