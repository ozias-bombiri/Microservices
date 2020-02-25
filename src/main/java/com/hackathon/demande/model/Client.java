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
@Table(name = "client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")
    , @NamedQuery(name = "Client.findByIdclient", query = "SELECT c FROM Client c WHERE c.idclient = :idclient")
    , @NamedQuery(name = "Client.findByDenomination", query = "SELECT c FROM Client c WHERE c.denomination = :denomination")
    , @NamedQuery(name = "Client.findByEmail", query = "SELECT c FROM Client c WHERE c.email = :email")
    , @NamedQuery(name = "Client.findByStatut", query = "SELECT c FROM Client c WHERE c.statut = :statut")
    , @NamedQuery(name = "Client.findByTelephone", query = "SELECT c FROM Client c WHERE c.telephone = :telephone")
    , @NamedQuery(name = "Client.findByVille", query = "SELECT c FROM Client c WHERE c.ville = :ville")
    , @NamedQuery(name = "Client.findByProvince", query = "SELECT c FROM Client c WHERE c.province = :province")
    , @NamedQuery(name = "Client.findByRegion", query = "SELECT c FROM Client c WHERE c.region = :region")
    , @NamedQuery(name = "Client.findByLocalisation", query = "SELECT c FROM Client c WHERE c.localisation = :localisation")
    , @NamedQuery(name = "Client.findByDatecreation", query = "SELECT c FROM Client c WHERE c.datecreation = :datecreation")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idclient")
    private Integer idclient;
    @Size(max = 254)
    @Column(name = "denomination")
    private String denomination;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 254)
    @Column(name = "email")
    private String email;
    @Size(max = 254)
    @Column(name = "statut")
    private String statut;
    @Size(max = 254)
    @Column(name = "telephone")
    private String telephone;
    @Size(max = 254)
    @Column(name = "ville")
    private String ville;
    @Size(max = 254)
    @Column(name = "province")
    private String province;
    @Size(max = 254)
    @Column(name = "region")
    private String region;
    @Size(max = 254)
    @Column(name = "localisation")
    private String localisation;
    @Column(name = "datecreation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreation;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idclient")
    private List<Responsable> responsableList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idclient")
    private List<Demande> demandeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idclient")
    @JsonIgnore
    private List<Plainte> plainteList;
    @JoinColumn(name = "idcompte", referencedColumnName = "idcompte")
    @ManyToOne
    @JsonIgnore
    private Compte idcompte;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idclient")
    @JsonIgnore
    private List<Compte> compteList;

    public Client() {
    }

    public Client(Integer idclient) {
        this.idclient = idclient;
    }

    public Integer getIdclient() {
        return idclient;
    }

    public void setIdclient(Integer idclient) {
        this.idclient = idclient;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    @XmlTransient
    public List<Responsable> getResponsableList() {
        return responsableList;
    }

    public void setResponsableList(List<Responsable> responsableList) {
        this.responsableList = responsableList;
    }

    @XmlTransient
    public List<Demande> getDemandeList() {
        return demandeList;
    }

    public void setDemandeList(List<Demande> demandeList) {
        this.demandeList = demandeList;
    }

    @XmlTransient
    public List<Plainte> getPlainteList() {
        return plainteList;
    }

    public void setPlainteList(List<Plainte> plainteList) {
        this.plainteList = plainteList;
    }

    public Compte getIdcompte() {
        return idcompte;
    }

    public void setIdcompte(Compte idcompte) {
        this.idcompte = idcompte;
    }

    @XmlTransient
    public List<Compte> getCompteList() {
        return compteList;
    }

    public void setCompteList(List<Compte> compteList) {
        this.compteList = compteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclient != null ? idclient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.idclient == null && other.idclient != null) || (this.idclient != null && !this.idclient.equals(other.idclient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hackathon.demande.model.Client[ idclient=" + idclient + " ]";
    }
    
}
