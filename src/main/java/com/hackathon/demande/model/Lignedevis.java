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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ozias
 */
@Entity
@Table(name = "lignedevis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lignedevis.findAll", query = "SELECT l FROM Lignedevis l")
    , @NamedQuery(name = "Lignedevis.findByIdlignedevis", query = "SELECT l FROM Lignedevis l WHERE l.idlignedevis = :idlignedevis")
    , @NamedQuery(name = "Lignedevis.findByCout", query = "SELECT l FROM Lignedevis l WHERE l.cout = :cout")})
public class Lignedevis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlignedevis")
    private Integer idlignedevis;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cout")
    private Float cout;
    @JoinColumn(name = "idservice", referencedColumnName = "idservice")
    @ManyToOne(optional = false)
    private Service idservice;
    @JoinColumn(name = "iddevis", referencedColumnName = "iddevis")
    @ManyToOne(optional = false)
    private Devis iddevis;

    public Lignedevis() {
    }

    public Lignedevis(Integer idlignedevis) {
        this.idlignedevis = idlignedevis;
    }

    public Integer getIdlignedevis() {
        return idlignedevis;
    }

    public void setIdlignedevis(Integer idlignedevis) {
        this.idlignedevis = idlignedevis;
    }

    public Float getCout() {
        return cout;
    }

    public void setCout(Float cout) {
        this.cout = cout;
    }

    public Service getIdservice() {
        return idservice;
    }

    public void setIdservice(Service idservice) {
        this.idservice = idservice;
    }

    public Devis getIddevis() {
        return iddevis;
    }

    public void setIddevis(Devis iddevis) {
        this.iddevis = iddevis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlignedevis != null ? idlignedevis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lignedevis)) {
            return false;
        }
        Lignedevis other = (Lignedevis) object;
        if ((this.idlignedevis == null && other.idlignedevis != null) || (this.idlignedevis != null && !this.idlignedevis.equals(other.idlignedevis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hackathon.demande.model.Lignedevis[ idlignedevis=" + idlignedevis + " ]";
    }
    
}
