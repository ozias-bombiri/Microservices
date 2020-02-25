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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ozias
 */
@Entity
@Table(name = "serviceapresvente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Serviceapresvente.findAll", query = "SELECT s FROM Serviceapresvente s")
    , @NamedQuery(name = "Serviceapresvente.findByIdservice", query = "SELECT s FROM Serviceapresvente s WHERE s.idservice = :idservice")
    , @NamedQuery(name = "Serviceapresvente.findByIdclient", query = "SELECT s FROM Serviceapresvente s WHERE s.idclient = :idclient")
    , @NamedQuery(name = "Serviceapresvente.findByLibelleservice", query = "SELECT s FROM Serviceapresvente s WHERE s.libelleservice = :libelleservice")
    , @NamedQuery(name = "Serviceapresvente.findByIntituleservice", query = "SELECT s FROM Serviceapresvente s WHERE s.intituleservice = :intituleservice")})
public class Serviceapresvente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idservice")
    private Integer idservice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idclient")
    private int idclient;
    @Size(max = 254)
    @Column(name = "libelleservice")
    private String libelleservice;
    @Size(max = 254)
    @Column(name = "intituleservice")
    private String intituleservice;
    @JoinColumn(name = "iddevis", referencedColumnName = "iddevis")
    @ManyToOne(optional = false)
    private Devis iddevis;

    public Serviceapresvente() {
    }

    public Serviceapresvente(Integer idservice) {
        this.idservice = idservice;
    }

    public Serviceapresvente(Integer idservice, int idclient) {
        this.idservice = idservice;
        this.idclient = idclient;
    }

    public Integer getIdservice() {
        return idservice;
    }

    public void setIdservice(Integer idservice) {
        this.idservice = idservice;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public String getLibelleservice() {
        return libelleservice;
    }

    public void setLibelleservice(String libelleservice) {
        this.libelleservice = libelleservice;
    }

    public String getIntituleservice() {
        return intituleservice;
    }

    public void setIntituleservice(String intituleservice) {
        this.intituleservice = intituleservice;
    }

    public Devis getIddevis() {
        return iddevis;
    }

    public void setIddevis(Devis iddevis) {
        this.iddevis = iddevis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idservice != null ? idservice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Serviceapresvente)) {
            return false;
        }
        Serviceapresvente other = (Serviceapresvente) object;
        if ((this.idservice == null && other.idservice != null) || (this.idservice != null && !this.idservice.equals(other.idservice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hackathon.demande.model.Serviceapresvente[ idservice=" + idservice + " ]";
    }
    
}
