package com.magattewar.projetniassback.controller;

import com.magattewar.projetniassback.model.Commande;
import com.magattewar.projetniassback.repository.CommandeRepository;
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
@RequestMapping("/api/commande")
@Transactional
public class CommandeResource {

    private final Logger log = LoggerFactory.getLogger(CommandeResource.class);

    private static final String ENTITY_NAME = "testjhipsterCommande";


    private final CommandeRepository commandeRepository;

    public CommandeResource(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }
    @PostMapping("/commandes")
    public List<Commande> createCommande(@RequestBody Commande commande) throws URISyntaxException {
        log.debug("REST request to save Commande : {}", commande);
        commandeRepository.save(commande);
        return commandeRepository.findAll();
    }

    @GetMapping("/commandes/all")
    public List<Commande> getAll(){
        return commandeRepository.findAll();
    }


    @PutMapping("/commandes")
    public List<Commande> updateCommande(@RequestBody Commande commande) throws URISyntaxException {
        log.debug("REST request to update Commande : {}", commande);
        if (commande.getId() == null) {

            return commandeRepository.findAll();
        }
        Commande result = commandeRepository.save(commande);
        return commandeRepository.findAll();
    }

    @GetMapping("/commandes/{id}")
    public Optional<Commande> getCommande(@PathVariable Long id) {
        Optional<Commande> commande = commandeRepository.findById(id);
        return commande;
    }

    @DeleteMapping("/commandes/{id}")
    public List<Commande> deleteCommande(@PathVariable Long id) {
        commandeRepository.deleteById(id);
        return commandeRepository.findAll();
    }
}
