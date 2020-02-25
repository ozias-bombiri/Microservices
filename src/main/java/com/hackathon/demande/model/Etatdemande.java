/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackathon.demande.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ozias
 */
@Entity
@Table(name = "etatdemande")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etatdemande.findAll", query = "SELECT e FROM Etatdemande e")
    , @NamedQuery(name = "Etatdemande.findByIdetatdemande", query = "SELECT e FROM Etatdemande e WHERE e.idetatdemande = :idetatdemande")
    , @NamedQuery(name = "Etatdemande.findByEtat", query = "SELECT e FROM Etatdemande e WHERE e.etat = :etat")})
public class Etatdemande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idetatdemande")
    private Integer idetatdemande;
    @Size(max = 254)
    @Column(name = "etat")
    private String etat;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idetatdemande")
    private List<Demande> demandeList;

    public Etatdemande() {
    }

    public Etatdemande(Integer idetatdemande) {
        this.idetatdemande = idetatdemande;
    }

    public Integer getIdetatdemande() {
        return idetatdemande;
    }

    public void setIdetatdemande(Integer idetatdemande) {
        this.idetatdemande = idetatdemande;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @XmlTransient
    public List<Demande> getDemandeList() {
        return demandeList;
    }

    public void setDemandeList(List<Demande> demandeList) {
        this.demandeList = demandeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idetatdemande != null ? idetatdemande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etatdemande)) {
            return false;
        }
        Etatdemande other = (Etatdemande) object;
        if ((this.idetatdemande == null && other.idetatdemande != null) || (this.idetatdemande != null && !this.idetatdemande.equals(other.idetatdemande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hackathon.demande.model.Etatdemande[ idetatdemande=" + idetatdemande + " ]";
    }
    
}
