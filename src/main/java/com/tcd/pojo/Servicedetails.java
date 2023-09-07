/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tcd.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author duytr
 */
@Entity
@Table(name = "servicedetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicedetails.findAll", query = "SELECT s FROM Servicedetails s"),
    @NamedQuery(name = "Servicedetails.findByServicedetailId", query = "SELECT s FROM Servicedetails s WHERE s.servicedetailId = :servicedetailId"),
    @NamedQuery(name = "Servicedetails.findBySoluong", query = "SELECT s FROM Servicedetails s WHERE s.soluong = :soluong"),
    @NamedQuery(name = "Servicedetails.findByTongtien", query = "SELECT s FROM Servicedetails s WHERE s.tongtien = :tongtien")})
public class Servicedetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "servicedetail_id")
    private Integer servicedetailId;
    @Column(name = "soluong")
    private Integer soluong;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tongtien")
    private BigDecimal tongtien;
    @JoinColumn(name = "appointment_id", referencedColumnName = "appointment_id")
    @ManyToOne
    private Appointments appointmentId;
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    @ManyToOne
    private Services serviceId;
    @OneToMany(mappedBy = "servicedetailId")
    private Collection<Invoices> invoicesCollection;

    public Servicedetails() {
    }

    public Servicedetails(Integer servicedetailId) {
        this.servicedetailId = servicedetailId;
    }

    public Integer getServicedetailId() {
        return servicedetailId;
    }

    public void setServicedetailId(Integer servicedetailId) {
        this.servicedetailId = servicedetailId;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    public BigDecimal getTongtien() {
        return tongtien;
    }

    public void setTongtien(BigDecimal tongtien) {
        this.tongtien = tongtien;
    }

    public Appointments getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Appointments appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Services getServiceId() {
        return serviceId;
    }

    public void setServiceId(Services serviceId) {
        this.serviceId = serviceId;
    }

    @XmlTransient
    public Collection<Invoices> getInvoicesCollection() {
        return invoicesCollection;
    }

    public void setInvoicesCollection(Collection<Invoices> invoicesCollection) {
        this.invoicesCollection = invoicesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (servicedetailId != null ? servicedetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicedetails)) {
            return false;
        }
        Servicedetails other = (Servicedetails) object;
        if ((this.servicedetailId == null && other.servicedetailId != null) || (this.servicedetailId != null && !this.servicedetailId.equals(other.servicedetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tcd.pojo.Servicedetails[ servicedetailId=" + servicedetailId + " ]";
    }
    
}
