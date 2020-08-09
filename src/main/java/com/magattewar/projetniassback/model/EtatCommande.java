package com.magattewar.projetniassback.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * A EtatCommande.
 */
@Entity
@Table(name = "etat_commande")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class EtatCommande implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JsonIgnoreProperties("etat")
    @OneToMany(mappedBy="etat")
    private List<Commande> commandes;

    @Column(name = "libelle")
    private String libelle;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    

    public EtatCommande() {
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public EtatCommande(Long id, List<Commande> commandes, String libelle) {
        this.id = id;
        this.commandes = commandes;
        this.libelle = libelle;
    }



    
}
