package com.magattewar.projetniassback.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

/**
 * A Produit.
 */
@Entity
@Table(name = "produit")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Produit implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reference")
    private String reference;

    @Column(name = "quantite")
    private Integer quantite;

    @Column(name = "prix_normal")
    private Float prixNormal;

    @Column(name = "prix_minimum")
    private Float prixMinimum;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public Produit reference(String reference) {
        this.reference = reference;
        return this;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public Produit quantite(Integer quantite) {
        this.quantite = quantite;
        return this;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Float getPrixNormal() {
        return prixNormal;
    }

    public Produit prixNormal(Float prixNormal) {
        this.prixNormal = prixNormal;
        return this;
    }

    public void setPrixNormal(Float prixNormal) {
        this.prixNormal = prixNormal;
    }

    public Float getPrixMinimum() {
        return prixMinimum;
    }

    public Produit prixMinimum(Float prixMinimum) {
        this.prixMinimum = prixMinimum;
        return this;
    }

    public void setPrixMinimum(Float prixMinimum) {
        this.prixMinimum = prixMinimum;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Produit)) {
            return false;
        }
        return id != null && id.equals(((Produit) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Produit{" +
            "id=" + getId() +
            ", reference='" + getReference() + "'" +
            ", quantite=" + getQuantite() +
            ", prixNormal=" + getPrixNormal() +
            ", prixMinimum=" + getPrixMinimum() +
            "}";
    }
}
