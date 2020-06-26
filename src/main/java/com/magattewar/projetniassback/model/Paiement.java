package com.magattewar.projetniassback.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

/**
 * A Paiement.
 */
@Entity
@Table(name = "paiement")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Paiement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private String date;

    @Column(name = "montant")
    private Float montant;

    @ManyToOne
    @JsonIgnoreProperties(value = "paiements", allowSetters = true)
    private Facture facture;

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

    public Paiement date(String date) {
        this.date = date;
        return this;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Float getMontant() {
        return montant;
    }

    public Paiement montant(Float montant) {
        this.montant = montant;
        return this;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public Facture getFacture() {
        return facture;
    }

    public Paiement facture(Facture facture) {
        this.facture = facture;
        return this;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Paiement)) {
            return false;
        }
        return id != null && id.equals(((Paiement) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Paiement{" +
            "id=" + getId() +
            ", date='" + getDate() + "'" +
            ", montant=" + getMontant() +
            "}";
    }
}
