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
@Table(name = "alarmtype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alarmtype.findAll", query = "SELECT a FROM Alarmtype a")
    , @NamedQuery(name = "Alarmtype.findById", query = "SELECT a FROM Alarmtype a WHERE a.id = :id")
    , @NamedQuery(name = "Alarmtype.findByTagname", query = "SELECT a FROM Alarmtype a WHERE a.tagname = :tagname")
    , @NamedQuery(name = "Alarmtype.findByDescription", query = "SELECT a FROM Alarmtype a WHERE a.description = :description")})
public class Alarmtype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 32)
    @Column(name = "TAGNAME")
    private String tagname;
    @Size(max = 256)
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinColumn(name = "ID_INSTALLATION", referencedColumnName = "ID")
    @ManyToOne
    private Installation idInstallation;
    @JoinColumn(name = "ID_SYSTEM", referencedColumnName = "ID")
    @ManyToOne
    private System idSystem;
    @JoinColumn(name = "ID_SUBSYSTEM", referencedColumnName = "ID")
    @ManyToOne
    private Subsystem idSubsystem;
    @JoinColumn(name = "ID_MESSAGETYPE", referencedColumnName = "ID")
    @ManyToOne
    private Messagetype idMessagetype;
    @JoinColumn(name = "ID_PRIORITY", referencedColumnName = "ID")
    @ManyToOne
    private Priority idPriority;
    @OneToMany(mappedBy = "idAlarmtype")
    private Collection<Alarmdata> alarmdataCollection;

    public Alarmtype() {
    }

    public Alarmtype(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Installation getIdInstallation() {
        return idInstallation;
    }

    public void setIdInstallation(Installation idInstallation) {
        this.idInstallation = idInstallation;
    }

    public System getIdSystem() {
        return idSystem;
    }

    public void setIdSystem(System idSystem) {
        this.idSystem = idSystem;
    }

    public Subsystem getIdSubsystem() {
        return idSubsystem;
    }

    public void setIdSubsystem(Subsystem idSubsystem) {
        this.idSubsystem = idSubsystem;
    }

    public Messagetype getIdMessagetype() {
        return idMessagetype;
    }

    public void setIdMessagetype(Messagetype idMessagetype) {
        this.idMessagetype = idMessagetype;
    }

    public Priority getIdPriority() {
        return idPriority;
    }

    public void setIdPriority(Priority idPriority) {
        this.idPriority = idPriority;
    }

    @XmlTransient
    public Collection<Alarmdata> getAlarmdataCollection() {
        return alarmdataCollection;
    }

    public void setAlarmdataCollection(Collection<Alarmdata> alarmdataCollection) {
        this.alarmdataCollection = alarmdataCollection;
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
        if (!(object instanceof Alarmtype)) {
            return false;
        }
        Alarmtype other = (Alarmtype) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.shadley000.a6.entities.Alarmtype[ id=" + id + " ]";
    }
    
}
