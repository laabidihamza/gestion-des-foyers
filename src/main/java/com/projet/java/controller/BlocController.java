package com.projet.java.controller;

import com.projet.java.entity.Bloc;
import com.projet.java.service.BlocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blocs")
public class BlocController {

    @Autowired
    private BlocService blocService;

    @PostMapping
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return blocService.save(bloc);
    }

    @GetMapping
    public List<Bloc> getAllBlocs() {
        return blocService.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteBloc(@PathVariable Long id) {
        blocService.delete(id);
    }
}
