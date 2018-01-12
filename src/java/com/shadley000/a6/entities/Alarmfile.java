/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadley000.a6.entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author shadl
 */
@Entity
@Table(name = "alarmfile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alarmfile.findAll", query = "SELECT a FROM Alarmfile a")
    , @NamedQuery(name = "Alarmfile.findById", query = "SELECT a FROM Alarmfile a WHERE a.id = :id")
    , @NamedQuery(name = "Alarmfile.findByFileName", query = "SELECT a FROM Alarmfile a WHERE a.fileName = :fileName")
    , @NamedQuery(name = "Alarmfile.findByLoadDate", query = "SELECT a FROM Alarmfile a WHERE a.loadDate = :loadDate")
    , @NamedQuery(name = "Alarmfile.findByDataLines", query = "SELECT a FROM Alarmfile a WHERE a.dataLines = :dataLines")
    , @NamedQuery(name = "Alarmfile.findByDataInserted", query = "SELECT a FROM Alarmfile a WHERE a.dataInserted = :dataInserted")
    , @NamedQuery(name = "Alarmfile.findByDataSkipped", query = "SELECT a FROM Alarmfile a WHERE a.dataSkipped = :dataSkipped")
    , @NamedQuery(name = "Alarmfile.findByDataError", query = "SELECT a FROM Alarmfile a WHERE a.dataError = :dataError")})
public class Alarmfile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 128)
    @Column(name = "FILE_NAME")
    private String fileName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOAD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date loadDate;
    @Column(name = "DATA_LINES")
    private Integer dataLines;
    @Column(name = "DATA_INSERTED")
    private Integer dataInserted;
    @Column(name = "DATA_SKIPPED")
    private Integer dataSkipped;
    @Column(name = "DATA_ERROR")
    private Integer dataError;
    @OneToMany(mappedBy = "idFile")
    private Collection<Errorlog> errorlogCollection;
    @JoinColumn(name = "ID_INSTALLATION", referencedColumnName = "ID")
    @ManyToOne
    private Installation idInstallation;
    @OneToMany(mappedBy = "idFile")
    private Collection<Alarmdata> alarmdataCollection;

    public Alarmfile() {
    }

    public Alarmfile(Integer id) {
        this.id = id;
    }

    public Alarmfile(Integer id, Date loadDate) {
        this.id = id;
        this.loadDate = loadDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getLoadDate() {
        return loadDate;
    }

    public void setLoadDate(Date loadDate) {
        this.loadDate = loadDate;
    }

    public Integer getDataLines() {
        return dataLines;
    }

    public void setDataLines(Integer dataLines) {
        this.dataLines = dataLines;
    }

    public Integer getDataInserted() {
        return dataInserted;
    }

    public void setDataInserted(Integer dataInserted) {
        this.dataInserted = dataInserted;
    }

    public Integer getDataSkipped() {
        return dataSkipped;
    }

    public void setDataSkipped(Integer dataSkipped) {
        this.dataSkipped = dataSkipped;
    }

    public Integer getDataError() {
        return dataError;
    }

    public void setDataError(Integer dataError) {
        this.dataError = dataError;
    }

    @XmlTransient
    public Collection<Errorlog> getErrorlogCollection() {
        return errorlogCollection;
    }

    public void setErrorlogCollection(Collection<Errorlog> errorlogCollection) {
        this.errorlogCollection = errorlogCollection;
    }

    public Installation getIdInstallation() {
        return idInstallation;
    }

    public void setIdInstallation(Installation idInstallation) {
        this.idInstallation = idInstallation;
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
        if (!(object instanceof Alarmfile)) {
            return false;
        }
        Alarmfile other = (Alarmfile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.shadley000.a6.entities.Alarmfile[ id=" + id + " ]";
    }
    
}
