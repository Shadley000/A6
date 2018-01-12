/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadley000.a6.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
 * @author shadl
 */
@Entity
@Table(name = "contractor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contractor.findAll", query = "SELECT c FROM Contractor c")
    , @NamedQuery(name = "Contractor.findById", query = "SELECT c FROM Contractor c WHERE c.id = :id")
    , @NamedQuery(name = "Contractor.findByNname", query = "SELECT c FROM Contractor c WHERE c.nname = :nname")
    , @NamedQuery(name = "Contractor.findByLogo", query = "SELECT c FROM Contractor c WHERE c.logo = :logo")})
public class Contractor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 64)
    @Column(name = "NNAME")
    private String nname;
    @Size(max = 128)
    @Column(name = "LOGO")
    private String logo;
    @OneToMany(mappedBy = "idContractor")
    private Collection<Installation> installationCollection;

    public Contractor() {
    }

    public Contractor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNname() {
        return nname;
    }

    public void setNname(String nname) {
        this.nname = nname;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @XmlTransient
    public Collection<Installation> getInstallationCollection() {
        return installationCollection;
    }

    public void setInstallationCollection(Collection<Installation> installationCollection) {
        this.installationCollection = installationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contractor)) {
            return false;
        }
        Contractor other = (Contractor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.shadley000.a6.entities.Contractor[ id=" + id + " ]";
    }
    
}
