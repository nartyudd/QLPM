/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tcd.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "invoices")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invoices.findAll", query = "SELECT i FROM Invoices i"),
    @NamedQuery(name = "Invoices.findByInvoiceId", query = "SELECT i FROM Invoices i WHERE i.invoiceId = :invoiceId"),
    @NamedQuery(name = "Invoices.findByNgayxuathoadon", query = "SELECT i FROM Invoices i WHERE i.ngayxuathoadon = :ngayxuathoadon"),
    @NamedQuery(name = "Invoices.findByTongtienhoadon", query = "SELECT i FROM Invoices i WHERE i.tongtienhoadon = :tongtienhoadon"),
    @NamedQuery(name = "Invoices.findByTrangthaithanhtoan", query = "SELECT i FROM Invoices i WHERE i.trangthaithanhtoan = :trangthaithanhtoan")})
public class Invoices implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "invoice_id")
    private Integer invoiceId;
    @Column(name = "ngayxuathoadon")
    @Temporal(TemporalType.DATE)
    private Date ngayxuathoadon;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tongtienhoadon")
    private BigDecimal tongtienhoadon;
    @Size(max = 50)
    @Column(name = "trangthaithanhtoan")
    private String trangthaithanhtoan;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @ManyToOne
    private Patients patientId;
    @JoinColumn(name = "prescription_id", referencedColumnName = "prescription_id")
    @ManyToOne
    private Prescriptions prescriptionId;
    @JoinColumn(name = "servicedetail_id", referencedColumnName = "servicedetail_id")
    @ManyToOne
    private Servicedetails servicedetailId;

    public Invoices() {
    }

    public Invoices(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Date getNgayxuathoadon() {
        return ngayxuathoadon;
    }

    public void setNgayxuathoadon(Date ngayxuathoadon) {
        this.ngayxuathoadon = ngayxuathoadon;
    }

    public BigDecimal getTongtienhoadon() {
        return tongtienhoadon;
    }

    public void setTongtienhoadon(BigDecimal tongtienhoadon) {
        this.tongtienhoadon = tongtienhoadon;
    }

    public String getTrangthaithanhtoan() {
        return trangthaithanhtoan;
    }

    public void setTrangthaithanhtoan(String trangthaithanhtoan) {
        this.trangthaithanhtoan = trangthaithanhtoan;
    }

    public Patients getPatientId() {
        return patientId;
    }

    public void setPatientId(Patients patientId) {
        this.patientId = patientId;
    }

    public Prescriptions getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Prescriptions prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Servicedetails getServicedetailId() {
        return servicedetailId;
    }

    public void setServicedetailId(Servicedetails servicedetailId) {
        this.servicedetailId = servicedetailId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoiceId != null ? invoiceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoices)) {
            return false;
        }
        Invoices other = (Invoices) object;
        if ((this.invoiceId == null && other.invoiceId != null) || (this.invoiceId != null && !this.invoiceId.equals(other.invoiceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tcd.pojo.Invoices[ invoiceId=" + invoiceId + " ]";
    }
    
}
