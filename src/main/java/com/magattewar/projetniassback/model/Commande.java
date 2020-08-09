package com.magattewar.projetniassback.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Commande.
 */
@Entity
@Table(name = "commande")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private String date;

    @Column(name = "annule")
    private boolean annule;

    @OneToOne
    @JoinColumn(unique = true)
    private Facture facture;

    @JsonIgnoreProperties("commandes")
    @ManyToOne
    @JoinColumn(name="etat_id")
    private EtatCommande etat;

    @OneToMany(mappedBy = "commande")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<LigneCommande> lignescommandes = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "commandes", allowSetters = true)
    private Client client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isAnnule() {
        return annule;
    }

    public void setAnnule(boolean annule) {
        this.annule = annule;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public EtatCommande getEtat() {
        return etat;
    }

    public void setEtat(EtatCommande etat) {
        this.etat = etat;
    }

    public Set<LigneCommande> getLignescommandes() {
        return lignescommandes;
    }

    public void setLignescommandes(Set<LigneCommande> lignescommandes) {
        this.lignescommandes = lignescommandes;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Commande(Long id, String date, boolean annule, Facture facture, EtatCommande etat,
            Set<LigneCommande> lignescommandes, Client client) {
        this.id = id;
        this.date = date;
        this.annule = annule;
        this.facture = facture;
        this.etat = etat;
        this.lignescommandes = lignescommandes;
        this.client = client;
    }

    public Commande() {
    }

    // jhipster-needle-entity-add-field - JHipster will add fields here
    

    

    
}
