/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackathon.demande.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ozias
 */
@Embeddable
public class LigneelementbesoinPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idelementbesoin")
    private int idelementbesoin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idservice")
    private int idservice;

    public LigneelementbesoinPK() {
    }

    public LigneelementbesoinPK(int idelementbesoin, int idservice) {
        this.idelementbesoin = idelementbesoin;
        this.idservice = idservice;
    }

    public int getIdelementbesoin() {
        return idelementbesoin;
    }

    public void setIdelementbesoin(int idelementbesoin) {
        this.idelementbesoin = idelementbesoin;
    }

    public int getIdservice() {
        return idservice;
    }

    public void setIdservice(int idservice) {
        this.idservice = idservice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idelementbesoin;
        hash += (int) idservice;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LigneelementbesoinPK)) {
            return false;
        }
        LigneelementbesoinPK other = (LigneelementbesoinPK) object;
        if (this.idelementbesoin != other.idelementbesoin) {
            return false;
        }
        if (this.idservice != other.idservice) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hackathon.demande.model.LigneelementbesoinPK[ idelementbesoin=" + idelementbesoin + ", idservice=" + idservice + " ]";
    }
    
}
