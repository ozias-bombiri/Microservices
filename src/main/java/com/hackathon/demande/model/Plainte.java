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
@Table(name = "plainte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plainte.findAll", query = "SELECT p FROM Plainte p")
    , @NamedQuery(name = "Plainte.findByIdplainte", query = "SELECT p FROM Plainte p WHERE p.idplainte = :idplainte")
    , @NamedQuery(name = "Plainte.findByIddiscussion", query = "SELECT p FROM Plainte p WHERE p.iddiscussion = :iddiscussion")
    , @NamedQuery(name = "Plainte.findByLibelleplainte", query = "SELECT p FROM Plainte p WHERE p.libelleplainte = :libelleplainte")
    , @NamedQuery(name = "Plainte.findByDescription", query = "SELECT p FROM Plainte p WHERE p.description = :description")
    , @NamedQuery(name = "Plainte.findByDateplainte", query = "SELECT p FROM Plainte p WHERE p.dateplainte = :dateplainte")})
public class Plainte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idplainte")
    private Integer idplainte;
    @Column(name = "iddiscussion")
    private Integer iddiscussion;
    @Size(max = 254)
    @Column(name = "libelleplainte")
    private String libelleplainte;
    @Size(max = 254)
    @Column(name = "description")
    private String description;
    @Column(name = "dateplainte")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateplainte;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idplainte")
    private List<Discussion> discussionList;
    @JoinColumn(name = "idclient", referencedColumnName = "idclient")
    @ManyToOne(optional = false)
    private Client idclient;

    public Plainte() {
    }

    public Plainte(Integer idplainte) {
        this.idplainte = idplainte;
    }

    public Integer getIdplainte() {
        return idplainte;
    }

    public void setIdplainte(Integer idplainte) {
        this.idplainte = idplainte;
    }

    public Integer getIddiscussion() {
        return iddiscussion;
    }

    public void setIddiscussion(Integer iddiscussion) {
        this.iddiscussion = iddiscussion;
    }

    public String getLibelleplainte() {
        return libelleplainte;
    }

    public void setLibelleplainte(String libelleplainte) {
        this.libelleplainte = libelleplainte;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateplainte() {
        return dateplainte;
    }

    public void setDateplainte(Date dateplainte) {
        this.dateplainte = dateplainte;
    }

    @XmlTransient
    public List<Discussion> getDiscussionList() {
        return discussionList;
    }

    public void setDiscussionList(List<Discussion> discussionList) {
        this.discussionList = discussionList;
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
        hash += (idplainte != null ? idplainte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plainte)) {
            return false;
        }
        Plainte other = (Plainte) object;
        if ((this.idplainte == null && other.idplainte != null) || (this.idplainte != null && !this.idplainte.equals(other.idplainte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hackathon.demande.model.Plainte[ idplainte=" + idplainte + " ]";
    }
    
}
