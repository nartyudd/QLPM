/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tcd.pojo;

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
 * @author duytr
 */
@Entity
@Table(name = "appointmenthistory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Appointmenthistory.findAll", query = "SELECT a FROM Appointmenthistory a"),
    @NamedQuery(name = "Appointmenthistory.findByAppointmenthistoryId", query = "SELECT a FROM Appointmenthistory a WHERE a.appointmenthistoryId = :appointmenthistoryId"),
    @NamedQuery(name = "Appointmenthistory.findByNgaygio", query = "SELECT a FROM Appointmenthistory a WHERE a.ngaygio = :ngaygio"),
    @NamedQuery(name = "Appointmenthistory.findByTrangthai", query = "SELECT a FROM Appointmenthistory a WHERE a.trangthai = :trangthai")})
public class Appointmenthistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "appointmenthistory_id")
    private Integer appointmenthistoryId;
    @Column(name = "ngaygio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaygio;
    @Size(max = 50)
    @Column(name = "trangthai")
    private String trangthai;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @ManyToOne
    private Patients patientId;

    public Appointmenthistory() {
    }

    public Appointmenthistory(Integer appointmenthistoryId) {
        this.appointmenthistoryId = appointmenthistoryId;
    }

    public Integer getAppointmenthistoryId() {
        return appointmenthistoryId;
    }

    public void setAppointmenthistoryId(Integer appointmenthistoryId) {
        this.appointmenthistoryId = appointmenthistoryId;
    }

    public Date getNgaygio() {
        return ngaygio;
    }

    public void setNgaygio(Date ngaygio) {
        this.ngaygio = ngaygio;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public Patients getPatientId() {
        return patientId;
    }

    public void setPatientId(Patients patientId) {
        this.patientId = patientId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appointmenthistoryId != null ? appointmenthistoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appointmenthistory)) {
            return false;
        }
        Appointmenthistory other = (Appointmenthistory) object;
        if ((this.appointmenthistoryId == null && other.appointmenthistoryId != null) || (this.appointmenthistoryId != null && !this.appointmenthistoryId.equals(other.appointmenthistoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tcd.pojo.Appointmenthistory[ appointmenthistoryId=" + appointmenthistoryId + " ]";
    }
    
}
