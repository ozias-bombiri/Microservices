/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackathon.demande.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ozias
 */
@Entity
@Table(name = "message")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m")
    , @NamedQuery(name = "Message.findByIdmessage", query = "SELECT m FROM Message m WHERE m.idmessage = :idmessage")
    , @NamedQuery(name = "Message.findByContenu", query = "SELECT m FROM Message m WHERE m.contenu = :contenu")
    , @NamedQuery(name = "Message.findByDatemessage", query = "SELECT m FROM Message m WHERE m.datemessage = :datemessage")})
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmessage")
    private Integer idmessage;
    @Size(max = 254)
    @Column(name = "contenu")
    private String contenu;
    @Column(name = "datemessage")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datemessage;
    @JoinColumn(name = "iddiscussion", referencedColumnName = "iddiscussion")
    @ManyToOne(optional = false)
    private Discussion iddiscussion;

    public Message() {
    }

    public Message(Integer idmessage) {
        this.idmessage = idmessage;
    }

    public Integer getIdmessage() {
        return idmessage;
    }

    public void setIdmessage(Integer idmessage) {
        this.idmessage = idmessage;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDatemessage() {
        return datemessage;
    }

    public void setDatemessage(Date datemessage) {
        this.datemessage = datemessage;
    }

    public Discussion getIddiscussion() {
        return iddiscussion;
    }

    public void setIddiscussion(Discussion iddiscussion) {
        this.iddiscussion = iddiscussion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmessage != null ? idmessage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Message)) {
            return false;
        }
        Message other = (Message) object;
        if ((this.idmessage == null && other.idmessage != null) || (this.idmessage != null && !this.idmessage.equals(other.idmessage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hackathon.demande.model.Message[ idmessage=" + idmessage + " ]";
    }
    
}
