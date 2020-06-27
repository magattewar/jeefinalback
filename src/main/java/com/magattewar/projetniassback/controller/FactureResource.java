package com.magattewar.projetniassback.controller;


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
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api")
@Transactional
public class FactureResource {

    private final Logger log = LoggerFactory.getLogger(FactureResource.class);

    private static final String ENTITY_NAME = "testjhipsterFacture";


//    private final FactureRepository factureRepository;
//
//    public FactureResource(FactureRepository factureRepository) {
//        this.factureRepository = factureRepository;
//    }
//
//    /**
//     * {@code POST  /factures} : Create a new facture.
//     *
//     * @param facture the facture to create.
//     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new facture, or with status {@code 400 (Bad Request)} if the facture has already an ID.
//     * @throws URISyntaxException if the Location URI syntax is incorrect.
//     */
//    @PostMapping("/factures")
//    public ResponseEntity<Facture> createFacture(@RequestBody Facture facture) throws URISyntaxException {
//        log.debug("REST request to save Facture : {}", facture);
//        if (facture.getId() != null) {
//            throw new BadRequestAlertException("A new facture cannot already have an ID", ENTITY_NAME, "idexists");
//        }
//        Facture result = factureRepository.save(facture);
//        return ResponseEntity.created(new URI("/api/factures/" + result.getId()))
//            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
//            .body(result);
//    }
//
//    /**
//     * {@code PUT  /factures} : Updates an existing facture.
//     *
//     * @param facture the facture to update.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated facture,
//     * or with status {@code 400 (Bad Request)} if the facture is not valid,
//     * or with status {@code 500 (Internal Server Error)} if the facture couldn't be updated.
//     * @throws URISyntaxException if the Location URI syntax is incorrect.
//     */
//    @PutMapping("/factures")
//    public ResponseEntity<Facture> updateFacture(@RequestBody Facture facture) throws URISyntaxException {
//        log.debug("REST request to update Facture : {}", facture);
//        if (facture.getId() == null) {
//            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
//        }
//        Facture result = factureRepository.save(facture);
//        return ResponseEntity.ok()
//            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, facture.getId().toString()))
//            .body(result);
//    }
//
//    /**
//     * {@code GET  /factures} : get all the factures.
//     *
//     * @param filter the filter of the request.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of factures in body.
//     */
//    @GetMapping("/factures")
//    public List<Facture> getAllFactures(@RequestParam(required = false) String filter) {
//        if ("commande-is-null".equals(filter)) {
//            log.debug("REST request to get all Factures where commande is null");
//            return StreamSupport
//                .stream(factureRepository.findAll().spliterator(), false)
//                .filter(facture -> facture.getCommande() == null)
//                .collect(Collectors.toList());
//        }
//        log.debug("REST request to get all Factures");
//        return factureRepository.findAll();
//    }
//
//    /**
//     * {@code GET  /factures/:id} : get the "id" facture.
//     *
//     * @param id the id of the facture to retrieve.
//     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the facture, or with status {@code 404 (Not Found)}.
//     */
//    @GetMapping("/factures/{id}")
//    public ResponseEntity<Facture> getFacture(@PathVariable Long id) {
//        log.debug("REST request to get Facture : {}", id);
//        Optional<Facture> facture = factureRepository.findById(id);
//        return ResponseUtil.wrapOrNotFound(facture);
//    }
//
//    /**
//     * {@code DELETE  /factures/:id} : delete the "id" facture.
//     *
//     * @param id the id of the facture to delete.
//     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
//     */
//    @DeleteMapping("/factures/{id}")
//    public ResponseEntity<Void> deleteFacture(@PathVariable Long id) {
//        log.debug("REST request to delete Facture : {}", id);
//        factureRepository.deleteById(id);
//        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
//    }
}
