package com.magattewar.projetniassback.controller;

import com.mycompany.myapp.domain.EtatCommande;
import com.mycompany.myapp.repository.EtatCommandeRepository;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
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

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.EtatCommande}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class EtatCommandeResource {

    private final Logger log = LoggerFactory.getLogger(EtatCommandeResource.class);

    private static final String ENTITY_NAME = "testjhipsterEtatCommande";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final EtatCommandeRepository etatCommandeRepository;

    public EtatCommandeResource(EtatCommandeRepository etatCommandeRepository) {
        this.etatCommandeRepository = etatCommandeRepository;
    }

    /**
     * {@code POST  /etat-commandes} : Create a new etatCommande.
     *
     * @param etatCommande the etatCommande to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new etatCommande, or with status {@code 400 (Bad Request)} if the etatCommande has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/etat-commandes")
    public ResponseEntity<EtatCommande> createEtatCommande(@RequestBody EtatCommande etatCommande) throws URISyntaxException {
        log.debug("REST request to save EtatCommande : {}", etatCommande);
        if (etatCommande.getId() != null) {
            throw new BadRequestAlertException("A new etatCommande cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EtatCommande result = etatCommandeRepository.save(etatCommande);
        return ResponseEntity.created(new URI("/api/etat-commandes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /etat-commandes} : Updates an existing etatCommande.
     *
     * @param etatCommande the etatCommande to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated etatCommande,
     * or with status {@code 400 (Bad Request)} if the etatCommande is not valid,
     * or with status {@code 500 (Internal Server Error)} if the etatCommande couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/etat-commandes")
    public ResponseEntity<EtatCommande> updateEtatCommande(@RequestBody EtatCommande etatCommande) throws URISyntaxException {
        log.debug("REST request to update EtatCommande : {}", etatCommande);
        if (etatCommande.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        EtatCommande result = etatCommandeRepository.save(etatCommande);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, etatCommande.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /etat-commandes} : get all the etatCommandes.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of etatCommandes in body.
     */
    @GetMapping("/etat-commandes")
    public List<EtatCommande> getAllEtatCommandes() {
        log.debug("REST request to get all EtatCommandes");
        return etatCommandeRepository.findAll();
    }

    /**
     * {@code GET  /etat-commandes/:id} : get the "id" etatCommande.
     *
     * @param id the id of the etatCommande to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the etatCommande, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/etat-commandes/{id}")
    public ResponseEntity<EtatCommande> getEtatCommande(@PathVariable Long id) {
        log.debug("REST request to get EtatCommande : {}", id);
        Optional<EtatCommande> etatCommande = etatCommandeRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(etatCommande);
    }

    /**
     * {@code DELETE  /etat-commandes/:id} : delete the "id" etatCommande.
     *
     * @param id the id of the etatCommande to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/etat-commandes/{id}")
    public ResponseEntity<Void> deleteEtatCommande(@PathVariable Long id) {
        log.debug("REST request to delete EtatCommande : {}", id);
        etatCommandeRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
