package com.magattewar.projetniassback.controller;


import com.magattewar.projetniassback.model.LigneCommande;
import com.magattewar.projetniassback.repository.LigneCommandeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lignecommande")
@Transactional
public class LigneCommandeResource {

    private final Logger log = LoggerFactory.getLogger(LigneCommandeResource.class);

    private static final String ENTITY_NAME = "testjhipsterLigneCommande";


    private final LigneCommandeRepository ligneCommandeRepository;

    public LigneCommandeResource(LigneCommandeRepository ligneCommandeRepository) {
        this.ligneCommandeRepository = ligneCommandeRepository;
    }
//
@PostMapping("/lignecommandes")
public List<LigneCommande> createLigneCommande(@RequestBody LigneCommande lignecommande) throws URISyntaxException {
    log.debug("REST request to save LigneCommande : {}", lignecommande);
    ligneCommandeRepository.save(lignecommande);
    return ligneCommandeRepository.findAll();
}

    @GetMapping("/lignecommandes/all")
    public List<LigneCommande> getAll(){
        return ligneCommandeRepository.findAll();
    }


    @PutMapping("/lignecommandes")
    public List<LigneCommande> updateLigneCommande(@RequestBody LigneCommande lignecommande) throws URISyntaxException {
        log.debug("REST request to update LigneCommande : {}", lignecommande);
        if (lignecommande.getId() == null) {

            return ligneCommandeRepository.findAll();
        }
        LigneCommande result = ligneCommandeRepository.save(lignecommande);
        return ligneCommandeRepository.findAll();
    }

    @GetMapping("/lignecommandes/{id}")
    public Optional<LigneCommande> getLigneCommande(@PathVariable Long id) {
        Optional<LigneCommande> lignecommande = ligneCommandeRepository.findById(id);
        return lignecommande;
    }

    @DeleteMapping("/lignecommandes/{id}")
    public List<LigneCommande> deleteLigneCommande(@PathVariable Long id) {
        ligneCommandeRepository.deleteById(id);
        return ligneCommandeRepository.findAll();
    }
}
