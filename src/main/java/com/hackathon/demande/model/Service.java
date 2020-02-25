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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "service")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Service.findAll", query = "SELECT s FROM Service s")
    , @NamedQuery(name = "Service.findByIdservice", query = "SELECT s FROM Service s WHERE s.idservice = :idservice")
    , @NamedQuery(name = "Service.findByDenomination", query = "SELECT s FROM Service s WHERE s.denomination = :denomination")
    , @NamedQuery(name = "Service.findByDescription", query = "SELECT s FROM Service s WHERE s.description = :description")})
public class Service implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idservice")
    private Integer idservice;
    @Size(max = 254)
    @Column(name = "denomination")
    private String denomination;
    @Size(max = 254)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idservice")
    @JsonIgnore
    private List<Lignedevis> lignedevisList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idservice")
    @JsonIgnore
    private List<Demande> demandeList;
    @JoinColumn(name = "iddomaine", referencedColumnName = "iddomaine")
    @ManyToOne(optional = false)
    private Domaineservice iddomaine;

    public Service() {
    }

    public Service(Integer idservice) {
        this.idservice = idservice;
    }

    public Integer getIdservice() {
        return idservice;
    }

    public void setIdservice(Integer idservice) {
        this.idservice = idservice;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Lignedevis> getLignedevisList() {
        return lignedevisList;
    }

    public void setLignedevisList(List<Lignedevis> lignedevisList) {
        this.lignedevisList = lignedevisList;
    }

    @XmlTransient
    public List<Demande> getDemandeList() {
        return demandeList;
    }

    public void setDemandeList(List<Demande> demandeList) {
        this.demandeList = demandeList;
    }

    public Domaineservice getIddomaine() {
        return iddomaine;
    }

    public void setIddomaine(Domaineservice iddomaine) {
        this.iddomaine = iddomaine;
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
        if (!(object instanceof Service)) {
            return false;
        }
        Service other = (Service) object;
        if ((this.idservice == null && other.idservice != null) || (this.idservice != null && !this.idservice.equals(other.idservice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hackathon.demande.model.Service[ idservice=" + idservice + " ]";
    }
    
}
