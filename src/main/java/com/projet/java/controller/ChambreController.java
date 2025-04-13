package com.projet.java.controller;

import com.projet.java.entity.Chambre;
import com.projet.java.service.ChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chambres")
public class ChambreController {

    @Autowired
    private ChambreService chambreService;

    @PostMapping
    public Chambre addChambre(@RequestBody Chambre chambre) {
        return chambreService.save(chambre);
    }

    @GetMapping
    public List<Chambre> getAllChambres() {
        return chambreService.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteChambre(@PathVariable Long id) {
        chambreService.delete(id);
    }
}
