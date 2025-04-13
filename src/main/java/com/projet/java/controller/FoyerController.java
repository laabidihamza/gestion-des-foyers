package com.projet.java.controller;

import com.projet.java.entity.Foyer;
import com.projet.java.service.FoyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foyers")
public class FoyerController {

    @Autowired
    private FoyerService foyerService;

    @PostMapping
    public Foyer addFoyer(@RequestBody Foyer foyer) {
        return foyerService.save(foyer);
    }

    @GetMapping
    public List<Foyer> getAllFoyers() {
        return foyerService.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteFoyer(@PathVariable Long id) {
        foyerService.delete(id);
    }
}
