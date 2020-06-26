package com.magattewar.projetniassback.controller;

import com.magattewar.projetniassback.model.Produit;
import com.magattewar.projetniassback.services.IProduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("hasAuthority('ROLE_SECRETAIRE') or hasAuthority('ROLE_MEDECIN')")
@CrossOrigin(origins = {"http://localhost:4200", "https://localhost:4200"})
@RestController
@RequestMapping("/api/produit")
public class ProduitController {

    @Autowired
    private IProduit iProduit;

    @GetMapping("/getall")
    List<Produit> getProduits(){
        return iProduit.findAll();
    }
    @GetMapping("/")
    List<Produit> getProduits2(){
        return iProduit.findAll();
    }

    @GetMapping("/getone/{id}")
    Produit getProduitById(@PathVariable int id){
        return iProduit.getOne(id);
    }

    @DeleteMapping("/delete/{id}")
    List<Produit> deleteProduit(@PathVariable int id){
        iProduit.delete(iProduit.getOne(id));
        return iProduit.findAll();
    }

    @PostMapping("/add")
    List<Produit> addProduit(@RequestBody Produit produit){
        iProduit.save(produit);
        return iProduit.findAll();
    }
    @PutMapping("/edit")
    List<Produit> editProduit(@RequestBody Produit produit){
        // Produit p = iProduit.findById(produit.getId());
        // p.setQuantite(produit.getQuantite());
        // p.setPrixUnitaire(produit.getPrixUnitaire());
        // p.setRef(produit.getRef());
        iProduit.save(produit);
        return iProduit.findAll();
    }






}
