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
@Table(name = "elementbesoin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Elementbesoin.findAll", query = "SELECT e FROM Elementbesoin e")
    , @NamedQuery(name = "Elementbesoin.findByIdelementbesoin", query = "SELECT e FROM Elementbesoin e WHERE e.idelementbesoin = :idelementbesoin")
    , @NamedQuery(name = "Elementbesoin.findByLibelle", query = "SELECT e FROM Elementbesoin e WHERE e.libelle = :libelle")
    , @NamedQuery(name = "Elementbesoin.findByDescription", query = "SELECT e FROM Elementbesoin e WHERE e.description = :description")})
public class Elementbesoin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idelementbesoin")
    private Integer idelementbesoin;
    @Size(max = 254)
    @Column(name = "libelle")
    private String libelle;
    @Size(max = 254)
    @Column(name = "description")
    private String description;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idelementbesoin")
    private List<Besoin> besoinList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "elementbesoin")
    private List<Ligneelementbesoin> ligneelementbesoinList;

    public Elementbesoin() {
    }

    public Elementbesoin(Integer idelementbesoin) {
        this.idelementbesoin = idelementbesoin;
    }

    public Integer getIdelementbesoin() {
        return idelementbesoin;
    }

    public void setIdelementbesoin(Integer idelementbesoin) {
        this.idelementbesoin = idelementbesoin;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Besoin> getBesoinList() {
        return besoinList;
    }

    public void setBesoinList(List<Besoin> besoinList) {
        this.besoinList = besoinList;
    }

    @XmlTransient
    public List<Ligneelementbesoin> getLigneelementbesoinList() {
        return ligneelementbesoinList;
    }

    public void setLigneelementbesoinList(List<Ligneelementbesoin> ligneelementbesoinList) {
        this.ligneelementbesoinList = ligneelementbesoinList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idelementbesoin != null ? idelementbesoin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Elementbesoin)) {
            return false;
        }
        Elementbesoin other = (Elementbesoin) object;
        if ((this.idelementbesoin == null && other.idelementbesoin != null) || (this.idelementbesoin != null && !this.idelementbesoin.equals(other.idelementbesoin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hackathon.demande.model.Elementbesoin[ idelementbesoin=" + idelementbesoin + " ]";
    }
    
}
