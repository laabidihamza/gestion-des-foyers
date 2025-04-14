package com.projet.java.repository;

import com.projet.java.entity.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    boolean existsByNumeroChambre(Long numeroChambre);
}
