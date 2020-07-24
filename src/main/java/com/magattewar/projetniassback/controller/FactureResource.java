package com.magattewar.projetniassback.controller;


import com.magattewar.projetniassback.model.Facture;
import com.magattewar.projetniassback.repository.FactureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://localhost:4200"})
@RequestMapping("/api")
@Transactional
public class FactureResource {

    private final Logger log = LoggerFactory.getLogger(FactureResource.class);

    private static final String ENTITY_NAME = "testjhipsterFacture";


    @Autowired
    private final FactureRepository factureRepository;

    public FactureResource(FactureRepository factureRepository) {
        this.factureRepository = factureRepository;
    }
//
@PostMapping("/factures/add")
public Facture createFacture(@RequestBody Facture facture) throws URISyntaxException {
    log.debug("REST request to save Facture : {}", facture);
    return factureRepository.save(facture);
}

    @GetMapping("/factures/all")
    public List<Facture> getAll(){
        return factureRepository.findAll();
    }


    @PutMapping("/factures")
    public List<Facture> updateFacture(@RequestBody Facture facture) throws URISyntaxException {
        log.debug("REST request to update Facture : {}", facture);
        if (facture.getId() == null) {

            return factureRepository.findAll();
        }
        Facture result = factureRepository.save(facture);
        return factureRepository.findAll();
    }

    @GetMapping("/factures/{id}")
    public Optional<Facture> getFacture(@PathVariable Long id) {
        Optional<Facture> facture = factureRepository.findById(id);
        return facture;
    }

    @DeleteMapping("/factures/{id}")
    public List<Facture> deleteFacture(@PathVariable Long id) {
        factureRepository.deleteById(id);
        return factureRepository.findAll();
    }
}
