package com.magattewar.projetniassback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

/**
 * A Facture.
 */
@Entity
@Table(name = "facture")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Facture implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private String date;

    @Column(name = "total")
    private float total;

    @Column(name = "tva")
    private float tva;

    @Column(name = "ttc")
    private float ttc;

    @Lob
    @Column(name = "document")
    private byte[] document;


    @Column(name = "document_content_type")
    private String documentContentType;

    @OneToMany(mappedBy = "facture")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Paiement> paiements = new HashSet<>();

    @OneToOne(mappedBy = "facture")
    @JsonIgnore
    private Commande commande;


    

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

    public Facture date(String date) {
        this.date = date;
        return this;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDocumentContentType() {
        return documentContentType;
    }

    public void setDocumentContentType(String documentContentType) {
        this.documentContentType = documentContentType;
    }

    

    public Facture() {
    }

    public byte[] getDocument() {
        return document;
    }

    public void setDocument(byte[] document) {
        this.document = document;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Commande getCommande() {
        return commande;
    }

    public Facture commande(Commande commande) {
        this.commande = commande;
        return this;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Facture)) {
            return false;
        }
        return id != null && id.equals(((Facture) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Facture{" +
            "id=" + getId() +
            ", date='" + getDate() + "'" +
            "}";
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getTva() {
        return tva;
    }

    public void setTva(float tva) {
        this.tva = tva;
    }

    public float getTtc() {
        return ttc;
    }

    public void setTtc(float ttc) {
        this.ttc = ttc;
    }

    public Set<Paiement> getPaiements() {
        return paiements;
    }

    public void setPaiements(Set<Paiement> paiements) {
        this.paiements = paiements;
    }

    public Facture(Long id, String date, float total, float tva, float ttc, byte[] document, String documentContentType,
            Set<Paiement> paiements, Commande commande) {
        this.id = id;
        this.date = date;
        this.total = total;
        this.tva = tva;
        this.ttc = ttc;
        this.document = document;
        this.documentContentType = documentContentType;
        this.paiements = paiements;
        this.commande = commande;
    }

    

}
