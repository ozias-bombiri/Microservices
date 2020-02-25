/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackathon.demande.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ozias
 */
@Entity
@Table(name = "devis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Devis.findAll", query = "SELECT d FROM Devis d")
    , @NamedQuery(name = "Devis.findByIddevis", query = "SELECT d FROM Devis d WHERE d.iddevis = :iddevis")
    , @NamedQuery(name = "Devis.findByLibelledevis", query = "SELECT d FROM Devis d WHERE d.libelledevis = :libelledevis")
    , @NamedQuery(name = "Devis.findByDateetablissement", query = "SELECT d FROM Devis d WHERE d.dateetablissement = :dateetablissement")})
public class Devis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddevis")
    private Integer iddevis;
    @Size(max = 254)
    @Column(name = "libelledevis")
    private String libelledevis;
    @Column(name = "dateetablissement")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateetablissement;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddevis")
    @JsonIgnore
    private List<Lignedevis> lignedevisList;
    @JoinColumn(name = "iddemande", referencedColumnName = "iddemande")
    @ManyToOne(optional = false)
    private Demande iddemande;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddevis")
    private List<Serviceapresvente> serviceapresventeList;

    public Devis() {
    }

    public Devis(Integer iddevis) {
        this.iddevis = iddevis;
    }

    public Integer getIddevis() {
        return iddevis;
    }

    public void setIddevis(Integer iddevis) {
        this.iddevis = iddevis;
    }

    public String getLibelledevis() {
        return libelledevis;
    }

    public void setLibelledevis(String libelledevis) {
        this.libelledevis = libelledevis;
    }

    public Date getDateetablissement() {
        return dateetablissement;
    }

    public void setDateetablissement(Date dateetablissement) {
        this.dateetablissement = dateetablissement;
    }

    @XmlTransient
    public List<Lignedevis> getLignedevisList() {
        return lignedevisList;
    }

    public void setLignedevisList(List<Lignedevis> lignedevisList) {
        this.lignedevisList = lignedevisList;
    }

    public Demande getIddemande() {
        return iddemande;
    }

    public void setIddemande(Demande iddemande) {
        this.iddemande = iddemande;
    }

    @XmlTransient
    public List<Serviceapresvente> getServiceapresventeList() {
        return serviceapresventeList;
    }

    public void setServiceapresventeList(List<Serviceapresvente> serviceapresventeList) {
        this.serviceapresventeList = serviceapresventeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddevis != null ? iddevis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Devis)) {
            return false;
        }
        Devis other = (Devis) object;
        if ((this.iddevis == null && other.iddevis != null) || (this.iddevis != null && !this.iddevis.equals(other.iddevis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hackathon.demande.model.Devis[ iddevis=" + iddevis + " ]";
    }
    
}
