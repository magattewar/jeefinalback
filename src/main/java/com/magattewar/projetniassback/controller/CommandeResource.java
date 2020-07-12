package com.magattewar.projetniassback.controller;

import com.magattewar.projetniassback.model.Commande;
import com.magattewar.projetniassback.model.LigneCommande;
import com.magattewar.projetniassback.repository.CommandeRepository;
import com.magattewar.projetniassback.repository.LigneCommandeRepository;
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


@RestController

@CrossOrigin(origins = {"http://localhost:4200", "https://localhost:4200"})
@RequestMapping("/api")
@Transactional
public class CommandeResource {

    private final Logger log = LoggerFactory.getLogger(CommandeResource.class);

    @Autowired
    private final LigneCommandeRepository ligneCommandeRepository;
    @Autowired
    private final CommandeRepository commandeRepository;

    public CommandeResource(CommandeRepository commandeRepository, LigneCommandeRepository ligneCommandeRepository) {
        this.commandeRepository = commandeRepository;
        this.ligneCommandeRepository = ligneCommandeRepository;
    }


    @PostMapping("/commandes/add")
    public List<Commande> createCommande(@RequestBody Commande commande) throws URISyntaxException {
        log.debug("REST request to save Commande : {}", commande);
//        System.out.println("nouvelle Commande");
//        System.out.println(commande.getClient().getTelephone());
        Commande commande1 = commandeRepository.save(commande);
//        System.out.println("id de la commande" + commande1.getId());
        for (LigneCommande ligneCommande : commande.getLignescommandes()) {
            ligneCommande.setCommande(commande1);
            ligneCommandeRepository.save(ligneCommande);
        }
        return commandeRepository.findAll();
    }

    @GetMapping("/commandes/all")
    public List<Commande> getAll() {
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
