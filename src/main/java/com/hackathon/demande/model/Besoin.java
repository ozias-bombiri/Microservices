/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackathon.demande.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ozias
 */
@Entity
@Table(name = "besoin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Besoin.findAll", query = "SELECT b FROM Besoin b")
    , @NamedQuery(name = "Besoin.findByIdbesoin", query = "SELECT b FROM Besoin b WHERE b.idbesoin = :idbesoin")
    , @NamedQuery(name = "Besoin.findByValeur", query = "SELECT b FROM Besoin b WHERE b.valeur = :valeur")
    , @NamedQuery(name = "Besoin.findByCommentaire", query = "SELECT b FROM Besoin b WHERE b.commentaire = :commentaire")})
public class Besoin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbesoin")
    private Integer idbesoin;
    @Size(max = 254)
    @Column(name = "valeur")
    private String valeur;
    @Size(max = 254)
    @Column(name = "commentaire")
    private String commentaire;
    @JoinColumn(name = "iddemande", referencedColumnName = "iddemande")
    @ManyToOne(optional = false)
    private Demande iddemande;
    @JoinColumn(name = "idelementbesoin", referencedColumnName = "idelementbesoin")
    @ManyToOne(optional = false)
    private Elementbesoin idelementbesoin;

    public Besoin() {
    }

    public Besoin(Integer idbesoin) {
        this.idbesoin = idbesoin;
    }

    public Integer getIdbesoin() {
        return idbesoin;
    }

    public void setIdbesoin(Integer idbesoin) {
        this.idbesoin = idbesoin;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Demande getIddemande() {
        return iddemande;
    }

    public void setIddemande(Demande iddemande) {
        this.iddemande = iddemande;
    }

    public Elementbesoin getIdelementbesoin() {
        return idelementbesoin;
    }

    public void setIdelementbesoin(Elementbesoin idelementbesoin) {
        this.idelementbesoin = idelementbesoin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbesoin != null ? idbesoin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Besoin)) {
            return false;
        }
        Besoin other = (Besoin) object;
        if ((this.idbesoin == null && other.idbesoin != null) || (this.idbesoin != null && !this.idbesoin.equals(other.idbesoin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hackathon.demande.model.Besoin[ idbesoin=" + idbesoin + " ]";
    }
    
}
