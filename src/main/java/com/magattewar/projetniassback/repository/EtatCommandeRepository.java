package com.magattewar.projetniassback.repository;


import com.magattewar.projetniassback.model.EtatCommande;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the EtatCommande entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EtatCommandeRepository extends JpaRepository<EtatCommande, Long> {
}
