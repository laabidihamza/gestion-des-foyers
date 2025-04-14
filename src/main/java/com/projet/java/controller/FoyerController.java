package com.projet.java.controller;

import com.projet.java.entity.Foyer;
import com.projet.java.service.FoyerService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foyers")
@RequiredArgsConstructor
public class FoyerController {
    private final FoyerService foyerService;

    @PostMapping
    public ResponseEntity<Foyer> createFoyer(@RequestBody Foyer foyer) {
        return new ResponseEntity<>(foyerService.saveFoyer(foyer), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Foyer>> getAllFoyers() {
        return ResponseEntity.ok(foyerService.getAllFoyers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Foyer> getFoyerById(@PathVariable Long id) {
        return foyerService.getFoyerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Foyer> updateFoyer(@PathVariable Long id, @RequestBody Foyer foyer) {
        if (!foyerService.getFoyerById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        foyer.setIdFoyer(id);
        return ResponseEntity.ok(foyerService.updateFoyer(foyer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoyer(@PathVariable Long id) {
        if (!foyerService.getFoyerById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        foyerService.deleteFoyer(id);
        return ResponseEntity.noContent().build();
    }
}

//@RestController
//@RequestMapping("/foyers")
//public class FoyerController {
//
//    @Autowired
//    private FoyerService foyerService;
//
//    @PostMapping
//    public Foyer addFoyer(@RequestBody Foyer foyer) {
//        return foyerService.save(foyer);
//    }
//
//    @GetMapping
//    public List<Foyer> getAllFoyers() {
//        return foyerService.getAll();
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteFoyer(@PathVariable Long id) {
//        foyerService.delete(id);
//    }
//}
