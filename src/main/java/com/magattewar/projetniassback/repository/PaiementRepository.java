package com.magattewar.projetniassback.repository;


import com.magattewar.projetniassback.model.Paiement;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Paiement entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {
}
