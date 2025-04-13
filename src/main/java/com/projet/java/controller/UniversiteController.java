package com.projet.java.controller;

import com.projet.java.entity.Universite;
import com.projet.java.service.UniversiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/universites")
@RequiredArgsConstructor
public class UniversiteController {

    @Autowired
    private UniversiteService universiteService;

    @PostMapping
    public Universite addUniversite(@RequestBody Universite universite) {
        return universiteService.save(universite);
    }

    @GetMapping
    public List<Universite> getAllUniversites() {
        return universiteService.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteUniversite(@PathVariable Long id) {
        universiteService.delete(id);
    }

}