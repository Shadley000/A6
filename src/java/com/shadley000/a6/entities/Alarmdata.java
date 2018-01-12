/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadley000.a6.entities;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shadl
 */
@Entity
@Table(name = "alarmdata")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alarmdata.findAll", query = "SELECT a FROM Alarmdata a")
    , @NamedQuery(name = "Alarmdata.findById", query = "SELECT a FROM Alarmdata a WHERE a.id = :id")
    , @NamedQuery(name = "Alarmdata.findByAlarmtime", query = "SELECT a FROM Alarmdata a WHERE a.alarmtime = :alarmtime")})
public class Alarmdata implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ALARMTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date alarmtime;
    @JoinColumn(name = "ID_INSTALLATION", referencedColumnName = "ID")
    @ManyToOne
    private Installation idInstallation;
    @JoinColumn(name = "ID_FILE", referencedColumnName = "ID")
    @ManyToOne
    private Alarmfile idFile;
    @JoinColumn(name = "ID_ALARMTYPE", referencedColumnName = "ID")
    @ManyToOne
    private Alarmtype idAlarmtype;
    @JoinColumn(name = "ID_ALARMSTATUS", referencedColumnName = "ID")
    @ManyToOne
    private Alarmstatus idAlarmstatus;

    public Alarmdata() {
    }

    public Alarmdata(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAlarmtime() {
        return alarmtime;
    }

    public void setAlarmtime(Date alarmtime) {
        this.alarmtime = alarmtime;
    }

    public Installation getIdInstallation() {
        return idInstallation;
    }

    public void setIdInstallation(Installation idInstallation) {
        this.idInstallation = idInstallation;
    }

    public Alarmfile getIdFile() {
        return idFile;
    }

    public void setIdFile(Alarmfile idFile) {
        this.idFile = idFile;
    }

    public Alarmtype getIdAlarmtype() {
        return idAlarmtype;
    }

    public void setIdAlarmtype(Alarmtype idAlarmtype) {
        this.idAlarmtype = idAlarmtype;
    }

    public Alarmstatus getIdAlarmstatus() {
        return idAlarmstatus;
    }

    public void setIdAlarmstatus(Alarmstatus idAlarmstatus) {
        this.idAlarmstatus = idAlarmstatus;
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
        if (!(object instanceof Alarmdata)) {
            return false;
        }
        Alarmdata other = (Alarmdata) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.shadley000.a6.entities.Alarmdata[ id=" + id + " ]";
    }
    
}
