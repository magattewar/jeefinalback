package com.magattewar.projetniassback.services;

import com.magattewar.projetniassback.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IProduit extends JpaRepository<Produit, Integer> {
    List<Produit> findAll();
    Produit findById(int id);
}
