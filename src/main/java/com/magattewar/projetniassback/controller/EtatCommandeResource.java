package com.magattewar.projetniassback.controller;

import com.magattewar.projetniassback.model.EtatCommande;
import com.magattewar.projetniassback.repository.EtatCommandeRepository;
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
@RequestMapping("/api/etatcommande")
@Transactional
public class EtatCommandeResource {

    private final Logger log = LoggerFactory.getLogger(EtatCommandeResource.class);

    private static final String ENTITY_NAME = "testjhipsterEtatCommande";


    private final EtatCommandeRepository etatCommandeRepository;

    public EtatCommandeResource(EtatCommandeRepository etatCommandeRepository) {
        this.etatCommandeRepository = etatCommandeRepository;
    }
//
@PostMapping("/etatcommandes")
public List<EtatCommande> createEtatCommande(@RequestBody EtatCommande etatcommande) throws URISyntaxException {
    log.debug("REST request to save EtatCommande : {}", etatcommande);
    etatCommandeRepository.save(etatcommande);
    return etatCommandeRepository.findAll();
}

    @GetMapping("/etatcommandes/all")
    public List<EtatCommande> getAll(){
        return etatCommandeRepository.findAll();
    }


    @PutMapping("/etatcommandes")
    public List<EtatCommande> updateEtatCommande(@RequestBody EtatCommande etatcommande) throws URISyntaxException {
        log.debug("REST request to update EtatCommande : {}", etatcommande);
        if (etatcommande.getId() == null) {

            return etatCommandeRepository.findAll();
        }
        EtatCommande result = etatCommandeRepository.save(etatcommande);
        return etatCommandeRepository.findAll();
    }

    @GetMapping("/etatcommandes/{id}")
    public Optional<EtatCommande> getEtatCommande(@PathVariable Long id) {
        Optional<EtatCommande> etatcommande = etatCommandeRepository.findById(id);
        return etatcommande;
    }

    @DeleteMapping("/etatcommandes/{id}")
    public List<EtatCommande> deleteEtatCommande(@PathVariable Long id) {
        etatCommandeRepository.deleteById(id);
        return etatCommandeRepository.findAll();
    }
}
