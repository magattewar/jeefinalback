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

    @OneToOne
    @JoinColumn(unique = true)
    private Facture facture;

    @OneToOne
    @JoinColumn(unique = true)
    private EtatCommande etat;

    @OneToMany(mappedBy = "commande")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<LigneCommande> lignescommandes = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = "commandes", allowSetters = true)
    private Client client;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public Commande date(String date) {
        this.date = date;
        return this;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Facture getFacture() {
        return facture;
    }

    public Commande facture(Facture facture) {
        this.facture = facture;
        return this;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public EtatCommande getEtat() {
        return etat;
    }

    public Commande etat(EtatCommande etatCommande) {
        this.etat = etatCommande;
        return this;
    }

    public void setEtat(EtatCommande etatCommande) {
        this.etat = etatCommande;
    }

    public Set<LigneCommande> getLignescommandes() {
        return lignescommandes;
    }

    public Commande lignescommandes(Set<LigneCommande> ligneCommandes) {
        this.lignescommandes = ligneCommandes;
        return this;
    }

    public Commande addLignescommandes(LigneCommande ligneCommande) {
        this.lignescommandes.add(ligneCommande);
        ligneCommande.setCommande(this);
        return this;
    }

    public Commande removeLignescommandes(LigneCommande ligneCommande) {
        this.lignescommandes.remove(ligneCommande);
        ligneCommande.setCommande(null);
        return this;
    }

    public void setLignescommandes(Set<LigneCommande> ligneCommandes) {
        this.lignescommandes = ligneCommandes;
    }

    public Client getClient() {
        return client;
    }

    public Commande client(Client client) {
        this.client = client;
        return this;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Commande)) {
            return false;
        }
        return id != null && id.equals(((Commande) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Commande{" +
            "id=" + getId() +
            ", date='" + getDate() + "'" +
            "}";
    }
}
