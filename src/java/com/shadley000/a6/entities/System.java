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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "system")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "System.findAll", query = "SELECT s FROM System s")
    , @NamedQuery(name = "System.findById", query = "SELECT s FROM System s WHERE s.id = :id")
    , @NamedQuery(name = "System.findByNname", query = "SELECT s FROM System s WHERE s.nname = :nname")
    , @NamedQuery(name = "System.findByDescription", query = "SELECT s FROM System s WHERE s.description = :description")})
public class System implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 64)
    @Column(name = "NNAME")
    private String nname;
    @Size(max = 256)
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(mappedBy = "idSystem")
    private Collection<Alarmtype> alarmtypeCollection;
    @JoinColumn(name = "ID_INSTALLATION", referencedColumnName = "ID")
    @ManyToOne
    private Installation idInstallation;

    public System() {
    }

    public System(Integer id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Alarmtype> getAlarmtypeCollection() {
        return alarmtypeCollection;
    }

    public void setAlarmtypeCollection(Collection<Alarmtype> alarmtypeCollection) {
        this.alarmtypeCollection = alarmtypeCollection;
    }

    public Installation getIdInstallation() {
        return idInstallation;
    }

    public void setIdInstallation(Installation idInstallation) {
        this.idInstallation = idInstallation;
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
        if (!(object instanceof System)) {
            return false;
        }
        System other = (System) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.shadley000.a6.entities.System[ id=" + id + " ]";
    }
    
}
