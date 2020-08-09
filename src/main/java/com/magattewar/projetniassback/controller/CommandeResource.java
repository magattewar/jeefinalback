package com.magattewar.projetniassback.controller;

import com.magattewar.projetniassback.model.Commande;
import com.magattewar.projetniassback.model.Facture;
import com.magattewar.projetniassback.model.LigneCommande;
import com.magattewar.projetniassback.repository.CommandeRepository;
import com.magattewar.projetniassback.repository.EtatCommandeRepository;
import com.magattewar.projetniassback.repository.FactureRepository;
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

    @Autowired
    private final FactureRepository factureRepository;
    
    @Autowired
    private final EtatCommandeRepository etatCommandeRepository;

    public CommandeResource(CommandeRepository commandeRepository, LigneCommandeRepository ligneCommandeRepository,
                            EtatCommandeRepository etatCommandeRepository, FactureRepository factureRepository) {
        this.commandeRepository = commandeRepository;
        this.ligneCommandeRepository = ligneCommandeRepository;
        this.etatCommandeRepository = etatCommandeRepository;
        this.factureRepository = factureRepository;
    }


    @PostMapping("/commandes/add")
    public List<Commande> createCommande(@RequestBody Commande commande) throws URISyntaxException {
        log.debug("REST request to save Commande : {}", commande);
        Commande commande1 = commandeRepository.save(commande);
        for (LigneCommande ligneCommande : commande.getLignescommandes()) {
            ligneCommande.setCommande(commande1);
            ligneCommandeRepository.save(ligneCommande);
        }
        return commandeRepository.findAll();
    }

    @PostMapping("/commandes/annuler")
    public List<Commande> annulerCommande(@RequestBody Commande commande) throws URISyntaxException {
        Commande commande1 = commandeRepository.getOne(commande.getId());
        commande1.setAnnule(true);
        commandeRepository.save(commande1);
        return commandeRepository.findAll();
    }

    @GetMapping("/commandes/all")
    public List<Commande> getAll() {
        return commandeRepository.findAll();
    }

    @GetMapping("/commandes/valider/{id}")
    public List<Commande> valider(@PathVariable Long id) {
        Commande commande = commandeRepository.getOne(id);
        commande.setEtat(etatCommandeRepository.findByLibelle("attente livraison"));

        commandeRepository.save(commande);

        return commandeRepository.findAll();
    }

    @GetMapping("/commandes/livrer/{id}")
    public List<Commande> livrer(@PathVariable Long id) {
        Commande commande = commandeRepository.getOne(id);
        commande.setEtat(etatCommandeRepository.findByLibelle("livre"));

        commandeRepository.save(commande);

        return commandeRepository.findAll();
    }


    @PostMapping("/commandes/edit")
    public List<Commande> updateCommande(@RequestBody Commande commande) throws URISyntaxException {
        log.debug("REST request to update Commande : {}", commande);
        if (commande.getId() == null) {

            return commandeRepository.findAll();
        }
        Commande result = commandeRepository.save(commande);
        for (LigneCommande ligneCommande : commande.getLignescommandes()) {
            ligneCommande.setCommande(result);
            ligneCommandeRepository.save(ligneCommande);
        }
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
