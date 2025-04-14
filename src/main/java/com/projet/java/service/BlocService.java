package com.projet.java.service;

import com.projet.java.entity.Bloc;
import com.projet.java.repository.BlocRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class BlocService {
    private final BlocRepository blocRepository;

    // Create - When we create a Bloc, we also create its Chambres (cascade is used)
    public Bloc saveBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    // Read
    public List<Bloc> getAllBlocs() {
        return blocRepository.findAll();
    }

    public Optional<Bloc> getBlocById(Long id) {
        return blocRepository.findById(id);
    }

    // Update
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    // Delete - When we delete a Bloc, we also delete its Chambres (cascade is used)
    public void deleteBloc(Long id) {
        blocRepository.deleteById(id);
    }
}

//@Service
//public class BlocService {
//
//    @Autowired
//    private BlocRepository blocRepository;
//
//    public Bloc save(Bloc b) {
//        return blocRepository.save(b);
//    }
//
//    public List<Bloc> getAll() {
//        return blocRepository.findAll();
//    }
//
//    public void delete(Long id) {
//        blocRepository.deleteById(id);
//    }
//}
