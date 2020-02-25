/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackathon.demande.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ozias
 */
//@JsonIgnoreProperties(ignoreUnknown=true)
@Entity
@Table(name = "demande")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Demande.findAll", query = "SELECT d FROM Demande d")
    , @NamedQuery(name = "Demande.findByIddemande", query = "SELECT d FROM Demande d WHERE d.iddemande = :iddemande")
    , @NamedQuery(name = "Demande.findByLibelle", query = "SELECT d FROM Demande d WHERE d.libelle = :libelle")
    , @NamedQuery(name = "Demande.findByDatesoumission", query = "SELECT d FROM Demande d WHERE d.datesoumission = :datesoumission")
    , @NamedQuery(name = "Demande.findByDatemodification", query = "SELECT d FROM Demande d WHERE d.datemodification = :datemodification")})
public class Demande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddemande")
    private Integer iddemande;
    @Size(max = 254)
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "datesoumission")
    @Temporal(TemporalType.TIMESTAMP)
   // @JsonIgnore
    private Date datesoumission;
    @Column(name = "datemodification")
    @Temporal(TemporalType.TIMESTAMP)
   // @JsonIgnore
    private Date datemodification;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddemande")
    @JsonIgnore
    @XmlTransient
    private List<Besoin> besoinList;
    @JoinColumn(name = "idservice", referencedColumnName = "idservice")
    @ManyToOne(optional = false)
    @XmlTransient
    private Service idservice;
    @JoinColumn(name = "idclient", referencedColumnName = "idclient")
    @ManyToOne(optional = false)
    private Client idclient;
    @JoinColumn(name = "idetatdemande", referencedColumnName = "idetatdemande")
    @ManyToOne(optional = false)
    private Etatdemande idetatdemande;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddemande")
    @JsonIgnore
    private List<Devis> devisList;

    public Demande() {
    }

    public Demande(Integer iddemande) {
        this.iddemande = iddemande;
    }

    public Integer getIddemande() {
        return iddemande;
    }

    public void setIddemande(Integer iddemande) {
        this.iddemande = iddemande;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Date getDatesoumission() {
        return datesoumission;
    }

    public void setDatesoumission(Date datesoumission) {
        this.datesoumission = datesoumission;
    }

    public Date getDatemodification() {
        return datemodification;
    }

    public void setDatemodification(Date datemodification) {
        this.datemodification = datemodification;
    }

    @XmlTransient
    public List<Besoin> getBesoinList() {
        return besoinList;
    }

    public void setBesoinList(List<Besoin> besoinList) {
        this.besoinList = besoinList;
    }

    public Service getIdservice() {
        return idservice;
    }

    public void setIdservice(Service idservice) {
        this.idservice = idservice;
    }

    public Client getIdclient() {
        return idclient;
    }

    public void setIdclient(Client idclient) {
        this.idclient = idclient;
    }

    public Etatdemande getIdetatdemande() {
        return idetatdemande;
    }

    public void setIdetatdemande(Etatdemande idetatdemande) {
        this.idetatdemande = idetatdemande;
    }

    @XmlTransient
    public List<Devis> getDevisList() {
        return devisList;
    }

    public void setDevisList(List<Devis> devisList) {
        this.devisList = devisList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddemande != null ? iddemande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Demande)) {
            return false;
        }
        Demande other = (Demande) object;
        if ((this.iddemande == null && other.iddemande != null) || (this.iddemande != null && !this.iddemande.equals(other.iddemande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        return "Demande {"+
                "id=" + iddemande +
                ", libelle='"+ libelle + '\'' +
                ", date de soumission =" + datesoumission+ '}';
    }
    
}
