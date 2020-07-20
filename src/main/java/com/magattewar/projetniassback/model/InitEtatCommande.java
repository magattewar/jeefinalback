package com.magattewar.projetniassback.model;

import com.magattewar.projetniassback.repository.EtatCommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitEtatCommande {

    @Autowired
    private final EtatCommandeRepository etatCommandeRepository;

    public InitEtatCommande(EtatCommandeRepository etatCommandeRepository) {
        this.etatCommandeRepository = etatCommandeRepository;
    }

    @PostConstruct
    private void init(){
        etatCommandeRepository.save(new EtatCommande((long) 1,"en preparation"));
        etatCommandeRepository.save(new EtatCommande((long) 2,"attente livraison"));
        etatCommandeRepository.save(new EtatCommande((long) 3,"livre"));
    }
}
