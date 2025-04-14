package com.projet.java.controller;

import com.projet.java.entity.Bloc;
import com.projet.java.service.BlocService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blocs")
@RequiredArgsConstructor
public class BlocController {
    private final BlocService blocService;

    @PostMapping
    public ResponseEntity<Bloc> createBloc(@RequestBody Bloc bloc) {
        return new ResponseEntity<>(blocService.saveBloc(bloc), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Bloc>> getAllBlocs() {
        return ResponseEntity.ok(blocService.getAllBlocs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bloc> getBlocById(@PathVariable Long id) {
        return blocService.getBlocById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bloc> updateBloc(@PathVariable Long id, @RequestBody Bloc bloc) {
        if (!blocService.getBlocById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        bloc.setIdBloc(id);
        return ResponseEntity.ok(blocService.updateBloc(bloc));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBloc(@PathVariable Long id) {
        if (!blocService.getBlocById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        blocService.deleteBloc(id);
        return ResponseEntity.noContent().build();
    }
}

//@RestController
//@RequestMapping("/blocs")
//public class BlocController {
//
//    @Autowired
//    private BlocService blocService;
//
//    @PostMapping
//    public Bloc addBloc(@RequestBody Bloc bloc) {
//        return blocService.save(bloc);
//    }
//
//    @GetMapping
//    public List<Bloc> getAllBlocs() {
//        return blocService.getAll();
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteBloc(@PathVariable Long id) {
//        blocService.delete(id);
//    }
//}
