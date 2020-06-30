package com.magattewar.projetniassback.controller;

import com.magattewar.projetniassback.model.Produit;
import com.magattewar.projetniassback.repository.ProduitRepository;
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
@RequestMapping("/api/produitressource")
@Transactional
public class ProduitResource {

    private final Logger log = LoggerFactory.getLogger(ProduitResource.class);

    private static final String ENTITY_NAME = "testjhipsterProduit";


    private final ProduitRepository produitRepository;

    public ProduitResource(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }
//
@PostMapping("/produits")
public List<Produit> createProduit(@RequestBody Produit produit) throws URISyntaxException {
    log.debug("REST request to save Produit : {}", produit);
    produitRepository.save(produit);
    return produitRepository.findAll();
}

    @GetMapping("/produits/all")
    public List<Produit> getAll(){
        return produitRepository.findAll();
    }


    @PutMapping("/produits")
    public List<Produit> updateProduit(@RequestBody Produit produit) throws URISyntaxException {
        log.debug("REST request to update Produit : {}", produit);
        if (produit.getId() == null) {

            return produitRepository.findAll();
        }
        Produit result = produitRepository.save(produit);
        return produitRepository.findAll();
    }

    @GetMapping("/produits/{id}")
    public Optional<Produit> getProduit(@PathVariable Long id) {
        Optional<Produit> produit = produitRepository.findById(id);
        return produit;
    }

    @DeleteMapping("/produits/{id}")
    public List<Produit> deleteProduit(@PathVariable Long id) {
        produitRepository.deleteById(id);
        return produitRepository.findAll();
    }
}
