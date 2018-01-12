/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadley000.a6.entities;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shadl
 */
@Entity
@Table(name = "errorlog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Errorlog.findAll", query = "SELECT e FROM Errorlog e")
    , @NamedQuery(name = "Errorlog.findById", query = "SELECT e FROM Errorlog e WHERE e.id = :id")
    , @NamedQuery(name = "Errorlog.findByErrorMessage", query = "SELECT e FROM Errorlog e WHERE e.errorMessage = :errorMessage")
    , @NamedQuery(name = "Errorlog.findByOriginalText", query = "SELECT e FROM Errorlog e WHERE e.originalText = :originalText")
    , @NamedQuery(name = "Errorlog.findByLinenumber", query = "SELECT e FROM Errorlog e WHERE e.linenumber = :linenumber")})
public class Errorlog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 512)
    @Column(name = "ERROR_MESSAGE")
    private String errorMessage;
    @Size(max = 512)
    @Column(name = "ORIGINAL_TEXT")
    private String originalText;
    @Column(name = "LINENUMBER")
    private Integer linenumber;
    @JoinColumn(name = "ID_FILE", referencedColumnName = "ID")
    @ManyToOne
    private Alarmfile idFile;
    @JoinColumn(name = "ID_INSTALLATION", referencedColumnName = "ID")
    @ManyToOne
    private Installation idInstallation;

    public Errorlog() {
    }

    public Errorlog(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getOriginalText() {
        return originalText;
    }

    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

    public Integer getLinenumber() {
        return linenumber;
    }

    public void setLinenumber(Integer linenumber) {
        this.linenumber = linenumber;
    }

    public Alarmfile getIdFile() {
        return idFile;
    }

    public void setIdFile(Alarmfile idFile) {
        this.idFile = idFile;
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
        if (!(object instanceof Errorlog)) {
            return false;
        }
        Errorlog other = (Errorlog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.shadley000.a6.entities.Errorlog[ id=" + id + " ]";
    }
    
}
