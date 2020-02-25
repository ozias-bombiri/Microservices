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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ozias
 */
@Entity
@Table(name = "responsable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Responsable.findAll", query = "SELECT r FROM Responsable r")
    , @NamedQuery(name = "Responsable.findByIdresponsable", query = "SELECT r FROM Responsable r WHERE r.idresponsable = :idresponsable")
    , @NamedQuery(name = "Responsable.findByType", query = "SELECT r FROM Responsable r WHERE r.type = :type")
    , @NamedQuery(name = "Responsable.findByNom", query = "SELECT r FROM Responsable r WHERE r.nom = :nom")
    , @NamedQuery(name = "Responsable.findByPrenom", query = "SELECT r FROM Responsable r WHERE r.prenom = :prenom")
    , @NamedQuery(name = "Responsable.findByTelephone", query = "SELECT r FROM Responsable r WHERE r.telephone = :telephone")
    , @NamedQuery(name = "Responsable.findByEmail", query = "SELECT r FROM Responsable r WHERE r.email = :email")})
public class Responsable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idresponsable")
    private Integer idresponsable;
    @Size(max = 254)
    @Column(name = "type")
    private String type;
    @Size(max = 254)
    @Column(name = "nom")
    private String nom;
    @Size(max = 254)
    @Column(name = "prenom")
    private String prenom;
    @Size(max = 254)
    @Column(name = "telephone")
    private String telephone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 254)
    @Column(name = "email")
    private String email;
    @JoinColumn(name = "idclient", referencedColumnName = "idclient")
    @ManyToOne(optional = false)
    private Client idclient;

    public Responsable() {
    }

    public Responsable(Integer idresponsable) {
        this.idresponsable = idresponsable;
    }

    public Integer getIdresponsable() {
        return idresponsable;
    }

    public void setIdresponsable(Integer idresponsable) {
        this.idresponsable = idresponsable;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Client getIdclient() {
        return idclient;
    }

    public void setIdclient(Client idclient) {
        this.idclient = idclient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idresponsable != null ? idresponsable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Responsable)) {
            return false;
        }
        Responsable other = (Responsable) object;
        if ((this.idresponsable == null && other.idresponsable != null) || (this.idresponsable != null && !this.idresponsable.equals(other.idresponsable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hackathon.demande.model.Responsable[ idresponsable=" + idresponsable + " ]";
    }
    
}
