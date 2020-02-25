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
@Table(name = "discussion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Discussion.findAll", query = "SELECT d FROM Discussion d")
    , @NamedQuery(name = "Discussion.findByIddiscussion", query = "SELECT d FROM Discussion d WHERE d.iddiscussion = :iddiscussion")
    , @NamedQuery(name = "Discussion.findByLibelle", query = "SELECT d FROM Discussion d WHERE d.libelle = :libelle")
    , @NamedQuery(name = "Discussion.findByDatediscussion", query = "SELECT d FROM Discussion d WHERE d.datediscussion = :datediscussion")})
public class Discussion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddiscussion")
    private Integer iddiscussion;
    @Size(max = 254)
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "datediscussion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datediscussion;
    @JoinColumn(name = "idplainte", referencedColumnName = "idplainte")
    @ManyToOne(optional = false)
    private Plainte idplainte;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddiscussion")
    private List<Message> messageList;

    public Discussion() {
    }

    public Discussion(Integer iddiscussion) {
        this.iddiscussion = iddiscussion;
    }

    public Integer getIddiscussion() {
        return iddiscussion;
    }

    public void setIddiscussion(Integer iddiscussion) {
        this.iddiscussion = iddiscussion;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Date getDatediscussion() {
        return datediscussion;
    }

    public void setDatediscussion(Date datediscussion) {
        this.datediscussion = datediscussion;
    }

    public Plainte getIdplainte() {
        return idplainte;
    }

    public void setIdplainte(Plainte idplainte) {
        this.idplainte = idplainte;
    }

    @XmlTransient
    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddiscussion != null ? iddiscussion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Discussion)) {
            return false;
        }
        Discussion other = (Discussion) object;
        if ((this.iddiscussion == null && other.iddiscussion != null) || (this.iddiscussion != null && !this.iddiscussion.equals(other.iddiscussion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hackathon.demande.model.Discussion[ iddiscussion=" + iddiscussion + " ]";
    }
    
}
