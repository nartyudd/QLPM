/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tcd.pojo;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author duytr
 */
@Entity
@Table(name = "appointments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Appointments.findAll", query = "SELECT a FROM Appointments a"),
    @NamedQuery(name = "Appointments.findByAppointmentId", query = "SELECT a FROM Appointments a WHERE a.appointmentId = :appointmentId"),
    @NamedQuery(name = "Appointments.findByNgaygio", query = "SELECT a FROM Appointments a WHERE a.ngaygio = :ngaygio"),
    @NamedQuery(name = "Appointments.findByTrangthai", query = "SELECT a FROM Appointments a WHERE a.trangthai = :trangthai")})
public class Appointments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "appointment_id")
    private Integer appointmentId;
    @Column(name = "ngaygio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaygio;
    @Size(max = 50)
    @Column(name = "trangthai")
    private String trangthai;
    @JoinColumn(name = "employees_id", referencedColumnName = "employees_id")
    @ManyToOne
    private Employees employeesId;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @ManyToOne
    private Patients patientId;
    @OneToMany(mappedBy = "appointmentId")
    private Collection<Servicedetails> servicedetailsCollection;

    public Appointments() {
    }

    public Appointments(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
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

    public Employees getEmployeesId() {
        return employeesId;
    }

    public void setEmployeesId(Employees employeesId) {
        this.employeesId = employeesId;
    }

    public Patients getPatientId() {
        return patientId;
    }

    public void setPatientId(Patients patientId) {
        this.patientId = patientId;
    }

    @XmlTransient
    public Collection<Servicedetails> getServicedetailsCollection() {
        return servicedetailsCollection;
    }

    public void setServicedetailsCollection(Collection<Servicedetails> servicedetailsCollection) {
        this.servicedetailsCollection = servicedetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appointmentId != null ? appointmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appointments)) {
            return false;
        }
        Appointments other = (Appointments) object;
        if ((this.appointmentId == null && other.appointmentId != null) || (this.appointmentId != null && !this.appointmentId.equals(other.appointmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tcd.pojo.Appointments[ appointmentId=" + appointmentId + " ]";
    }
    
}
