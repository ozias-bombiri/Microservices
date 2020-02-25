/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackathon.demande.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ozias
 */
@Entity
@Table(name = "ligneelementbesoin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ligneelementbesoin.findAll", query = "SELECT l FROM Ligneelementbesoin l")
    , @NamedQuery(name = "Ligneelementbesoin.findByIdelementbesoin", query = "SELECT l FROM Ligneelementbesoin l WHERE l.ligneelementbesoinPK.idelementbesoin = :idelementbesoin")
    , @NamedQuery(name = "Ligneelementbesoin.findByIdservice", query = "SELECT l FROM Ligneelementbesoin l WHERE l.ligneelementbesoinPK.idservice = :idservice")})
public class Ligneelementbesoin implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LigneelementbesoinPK ligneelementbesoinPK;
    @JoinColumn(name = "idelementbesoin", referencedColumnName = "idelementbesoin", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Elementbesoin elementbesoin;

    public Ligneelementbesoin() {
    }

    public Ligneelementbesoin(LigneelementbesoinPK ligneelementbesoinPK) {
        this.ligneelementbesoinPK = ligneelementbesoinPK;
    }

    public Ligneelementbesoin(int idelementbesoin, int idservice) {
        this.ligneelementbesoinPK = new LigneelementbesoinPK(idelementbesoin, idservice);
    }

    public LigneelementbesoinPK getLigneelementbesoinPK() {
        return ligneelementbesoinPK;
    }

    public void setLigneelementbesoinPK(LigneelementbesoinPK ligneelementbesoinPK) {
        this.ligneelementbesoinPK = ligneelementbesoinPK;
    }

    public Elementbesoin getElementbesoin() {
        return elementbesoin;
    }

    public void setElementbesoin(Elementbesoin elementbesoin) {
        this.elementbesoin = elementbesoin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ligneelementbesoinPK != null ? ligneelementbesoinPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ligneelementbesoin)) {
            return false;
        }
        Ligneelementbesoin other = (Ligneelementbesoin) object;
        if ((this.ligneelementbesoinPK == null && other.ligneelementbesoinPK != null) || (this.ligneelementbesoinPK != null && !this.ligneelementbesoinPK.equals(other.ligneelementbesoinPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hackathon.demande.model.Ligneelementbesoin[ ligneelementbesoinPK=" + ligneelementbesoinPK + " ]";
    }
    
}
