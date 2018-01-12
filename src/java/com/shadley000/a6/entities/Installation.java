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
@Table(name = "installation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Installation.findAll", query = "SELECT i FROM Installation i")
    , @NamedQuery(name = "Installation.findById", query = "SELECT i FROM Installation i WHERE i.id = :id")
    , @NamedQuery(name = "Installation.findByNname", query = "SELECT i FROM Installation i WHERE i.nname = :nname")
    , @NamedQuery(name = "Installation.findByDatadirectory", query = "SELECT i FROM Installation i WHERE i.datadirectory = :datadirectory")
    , @NamedQuery(name = "Installation.findByParsername", query = "SELECT i FROM Installation i WHERE i.parsername = :parsername")})
public class Installation implements Serializable {

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
    @Column(name = "DATADIRECTORY")
    private String datadirectory;
    @Size(max = 64)
    @Column(name = "PARSERNAME")
    private String parsername;
    @OneToMany(mappedBy = "idInstallation")
    private Collection<Alarmtype> alarmtypeCollection;
    @OneToMany(mappedBy = "idInstallation")
    private Collection<Messagetype> messagetypeCollection;
    @OneToMany(mappedBy = "idInstallation")
    private Collection<Userspermissions> userspermissionsCollection;
    @OneToMany(mappedBy = "idInstallation")
    private Collection<Subsystem> subsystemCollection;
    @OneToMany(mappedBy = "idInstallation")
    private Collection<Errorlog> errorlogCollection;
    @OneToMany(mappedBy = "idInstallation")
    private Collection<Alarmfile> alarmfileCollection;
    @OneToMany(mappedBy = "idInstallation")
    private Collection<Priority> priorityCollection;
    @OneToMany(mappedBy = "idInstallation")
    private Collection<Alarmstatus> alarmstatusCollection;
    @OneToMany(mappedBy = "idInstallation")
    private Collection<System> systemCollection;
    @JoinColumn(name = "ID_VENDOR", referencedColumnName = "ID")
    @ManyToOne
    private Vendor idVendor;
    @JoinColumn(name = "ID_SHIP", referencedColumnName = "ID")
    @ManyToOne
    private Ship idShip;
    @JoinColumn(name = "ID_CONTRACTOR", referencedColumnName = "ID")
    @ManyToOne
    private Contractor idContractor;
    @OneToMany(mappedBy = "idInstallation")
    private Collection<Alarmdata> alarmdataCollection;

    public Installation() {
    }

    public Installation(Integer id) {
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

    public String getDatadirectory() {
        return datadirectory;
    }

    public void setDatadirectory(String datadirectory) {
        this.datadirectory = datadirectory;
    }

    public String getParsername() {
        return parsername;
    }

    public void setParsername(String parsername) {
        this.parsername = parsername;
    }

    @XmlTransient
    public Collection<Alarmtype> getAlarmtypeCollection() {
        return alarmtypeCollection;
    }

    public void setAlarmtypeCollection(Collection<Alarmtype> alarmtypeCollection) {
        this.alarmtypeCollection = alarmtypeCollection;
    }

    @XmlTransient
    public Collection<Messagetype> getMessagetypeCollection() {
        return messagetypeCollection;
    }

    public void setMessagetypeCollection(Collection<Messagetype> messagetypeCollection) {
        this.messagetypeCollection = messagetypeCollection;
    }

    @XmlTransient
    public Collection<Userspermissions> getUserspermissionsCollection() {
        return userspermissionsCollection;
    }

    public void setUserspermissionsCollection(Collection<Userspermissions> userspermissionsCollection) {
        this.userspermissionsCollection = userspermissionsCollection;
    }

    @XmlTransient
    public Collection<Subsystem> getSubsystemCollection() {
        return subsystemCollection;
    }

    public void setSubsystemCollection(Collection<Subsystem> subsystemCollection) {
        this.subsystemCollection = subsystemCollection;
    }

    @XmlTransient
    public Collection<Errorlog> getErrorlogCollection() {
        return errorlogCollection;
    }

    public void setErrorlogCollection(Collection<Errorlog> errorlogCollection) {
        this.errorlogCollection = errorlogCollection;
    }

    @XmlTransient
    public Collection<Alarmfile> getAlarmfileCollection() {
        return alarmfileCollection;
    }

    public void setAlarmfileCollection(Collection<Alarmfile> alarmfileCollection) {
        this.alarmfileCollection = alarmfileCollection;
    }

    @XmlTransient
    public Collection<Priority> getPriorityCollection() {
        return priorityCollection;
    }

    public void setPriorityCollection(Collection<Priority> priorityCollection) {
        this.priorityCollection = priorityCollection;
    }

    @XmlTransient
    public Collection<Alarmstatus> getAlarmstatusCollection() {
        return alarmstatusCollection;
    }

    public void setAlarmstatusCollection(Collection<Alarmstatus> alarmstatusCollection) {
        this.alarmstatusCollection = alarmstatusCollection;
    }

    @XmlTransient
    public Collection<System> getSystemCollection() {
        return systemCollection;
    }

    public void setSystemCollection(Collection<System> systemCollection) {
        this.systemCollection = systemCollection;
    }

    public Vendor getIdVendor() {
        return idVendor;
    }

    public void setIdVendor(Vendor idVendor) {
        this.idVendor = idVendor;
    }

    public Ship getIdShip() {
        return idShip;
    }

    public void setIdShip(Ship idShip) {
        this.idShip = idShip;
    }

    public Contractor getIdContractor() {
        return idContractor;
    }

    public void setIdContractor(Contractor idContractor) {
        this.idContractor = idContractor;
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
        if (!(object instanceof Installation)) {
            return false;
        }
        Installation other = (Installation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.shadley000.a6.entities.Installation[ id=" + id + " ]";
    }
    
}
