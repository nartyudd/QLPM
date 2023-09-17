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
import javax.persistence.Lob;
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
 * @author duytr
 */
@Entity
@Table(name = "patients")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patients.findAll", query = "SELECT p FROM Patients p"),
    @NamedQuery(name = "Patients.findByPatientId", query = "SELECT p FROM Patients p WHERE p.patientId = :patientId"),
    @NamedQuery(name = "Patients.findByHoTen", query = "SELECT p FROM Patients p WHERE p.hoTen = :hoTen"),
    @NamedQuery(name = "Patients.findByNgaysinh", query = "SELECT p FROM Patients p WHERE p.ngaysinh = :ngaysinh"),
    @NamedQuery(name = "Patients.findByGioitinh", query = "SELECT p FROM Patients p WHERE p.gioitinh = :gioitinh"),
    @NamedQuery(name = "Patients.findByDiachi", query = "SELECT p FROM Patients p WHERE p.diachi = :diachi"),
    @NamedQuery(name = "Patients.findBySodienthoai", query = "SELECT p FROM Patients p WHERE p.sodienthoai = :sodienthoai"),
    @NamedQuery(name = "Patients.findByEmail", query = "SELECT p FROM Patients p WHERE p.email = :email"),
    @NamedQuery(name = "Patients.findByNgaykhamgannhat", query = "SELECT p FROM Patients p WHERE p.ngaykhamgannhat = :ngaykhamgannhat")})
public class Patients implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "patient_id")
    private Integer patientId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ho_ten")
    private String hoTen;
    @Column(name = "ngaysinh")
    @Temporal(TemporalType.DATE)
    private Date ngaysinh;
    @Size(max = 10)
    @Column(name = "gioitinh")
    private String gioitinh;
    @Size(max = 255)
    @Column(name = "diachi")
    private String diachi;
    @Size(max = 20)
    @Column(name = "sodienthoai")
    private String sodienthoai;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Lob
    @Size(max = 65535)
    @Column(name = "lichsubenhly")
    private String lichsubenhly;
    @Column(name = "ngaykhamgannhat")
    @Temporal(TemporalType.DATE)
    private Date ngaykhamgannhat;
    @OneToMany(mappedBy = "patientId")
    private Collection<Appointments> appointmentsCollection;
    @OneToMany(mappedBy = "patientId")
    private Collection<Invoices> invoicesCollection;
    @OneToMany(mappedBy = "patientId")
    private Collection<Appointmenthistory> appointmenthistoryCollection;
    @OneToMany(mappedBy = "patientId")
    private Collection<Prescriptions> prescriptionsCollection;

    public Patients() {
    }

    public Patients(Integer patientId) {
        this.patientId = patientId;
    }

    public Patients(Integer patientId, String hoTen) {
        this.patientId = patientId;
        this.hoTen = hoTen;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLichsubenhly() {
        return lichsubenhly;
    }

    public void setLichsubenhly(String lichsubenhly) {
        this.lichsubenhly = lichsubenhly;
    }

    public Date getNgaykhamgannhat() {
        return ngaykhamgannhat;
    }

    public void setNgaykhamgannhat(Date ngaykhamgannhat) {
        this.ngaykhamgannhat = ngaykhamgannhat;
    }

    @XmlTransient
    public Collection<Appointments> getAppointmentsCollection() {
        return appointmentsCollection;
    }

    public void setAppointmentsCollection(Collection<Appointments> appointmentsCollection) {
        this.appointmentsCollection = appointmentsCollection;
    }

    @XmlTransient
    public Collection<Invoices> getInvoicesCollection() {
        return invoicesCollection;
    }

    public void setInvoicesCollection(Collection<Invoices> invoicesCollection) {
        this.invoicesCollection = invoicesCollection;
    }

    @XmlTransient
    public Collection<Appointmenthistory> getAppointmenthistoryCollection() {
        return appointmenthistoryCollection;
    }

    public void setAppointmenthistoryCollection(Collection<Appointmenthistory> appointmenthistoryCollection) {
        this.appointmenthistoryCollection = appointmenthistoryCollection;
    }

    @XmlTransient
    public Collection<Prescriptions> getPrescriptionsCollection() {
        return prescriptionsCollection;
    }

    public void setPrescriptionsCollection(Collection<Prescriptions> prescriptionsCollection) {
        this.prescriptionsCollection = prescriptionsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientId != null ? patientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patients)) {
            return false;
        }
        Patients other = (Patients) object;
        if ((this.patientId == null && other.patientId != null) || (this.patientId != null && !this.patientId.equals(other.patientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tcd.pojo.Patients[ patientId=" + patientId + " ]";
    }
    
}
