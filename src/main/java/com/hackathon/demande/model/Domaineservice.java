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
@Table(name = "domaineservice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Domaineservice.findAll", query = "SELECT d FROM Domaineservice d")
    , @NamedQuery(name = "Domaineservice.findByIddomaine", query = "SELECT d FROM Domaineservice d WHERE d.iddomaine = :iddomaine")
    , @NamedQuery(name = "Domaineservice.findByCaracteristique", query = "SELECT d FROM Domaineservice d WHERE d.caracteristique = :caracteristique")})
public class Domaineservice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddomaine")
    private Integer iddomaine;
    @Size(max = 254)
    @Column(name = "caracteristique")
    private String caracteristique;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddomaine")
    private List<Service> serviceList;

    public Domaineservice() {
    }

    public Domaineservice(Integer iddomaine) {
        this.iddomaine = iddomaine;
    }

    public Integer getIddomaine() {
        return iddomaine;
    }

    public void setIddomaine(Integer iddomaine) {
        this.iddomaine = iddomaine;
    }

    public String getCaracteristique() {
        return caracteristique;
    }

    public void setCaracteristique(String caracteristique) {
        this.caracteristique = caracteristique;
    }

    @XmlTransient
    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddomaine != null ? iddomaine.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Domaineservice)) {
            return false;
        }
        Domaineservice other = (Domaineservice) object;
        if ((this.iddomaine == null && other.iddomaine != null) || (this.iddomaine != null && !this.iddomaine.equals(other.iddomaine))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hackathon.demande.model.Domaineservice[ iddomaine=" + iddomaine + " ]";
    }
    
}
