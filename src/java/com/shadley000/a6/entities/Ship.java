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
@Table(name = "ship")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ship.findAll", query = "SELECT s FROM Ship s")
    , @NamedQuery(name = "Ship.findById", query = "SELECT s FROM Ship s WHERE s.id = :id")
    , @NamedQuery(name = "Ship.findByNname", query = "SELECT s FROM Ship s WHERE s.nname = :nname")
    , @NamedQuery(name = "Ship.findByLogo", query = "SELECT s FROM Ship s WHERE s.logo = :logo")})
public class Ship implements Serializable {

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
    @OneToMany(mappedBy = "idShip")
    private Collection<Installation> installationCollection;

    public Ship() {
    }

    public Ship(Integer id) {
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
        if (!(object instanceof Ship)) {
            return false;
        }
        Ship other = (Ship) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.shadley000.a6.entities.Ship[ id=" + id + " ]";
    }
    
}
