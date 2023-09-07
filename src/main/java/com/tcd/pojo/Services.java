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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author duytr
 */
@Entity
@Table(name = "services")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Services.findAll", query = "SELECT s FROM Services s"),
    @NamedQuery(name = "Services.findByServiceId", query = "SELECT s FROM Services s WHERE s.serviceId = :serviceId"),
    @NamedQuery(name = "Services.findByTendichvu", query = "SELECT s FROM Services s WHERE s.tendichvu = :tendichvu"),
    @NamedQuery(name = "Services.findByGiadichvu", query = "SELECT s FROM Services s WHERE s.giadichvu = :giadichvu")})
public class Services implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "service_id")
    private Integer serviceId;
    @Size(max = 255)
    @Column(name = "tendichvu")
    private String tendichvu;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "giadichvu")
    private BigDecimal giadichvu;
    @OneToMany(mappedBy = "serviceId")
    private Collection<Servicedetails> servicedetailsCollection;

    public Services() {
    }

    public Services(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getTendichvu() {
        return tendichvu;
    }

    public void setTendichvu(String tendichvu) {
        this.tendichvu = tendichvu;
    }

    public BigDecimal getGiadichvu() {
        return giadichvu;
    }

    public void setGiadichvu(BigDecimal giadichvu) {
        this.giadichvu = giadichvu;
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
        hash += (serviceId != null ? serviceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Services)) {
            return false;
        }
        Services other = (Services) object;
        if ((this.serviceId == null && other.serviceId != null) || (this.serviceId != null && !this.serviceId.equals(other.serviceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tcd.pojo.Services[ serviceId=" + serviceId + " ]";
    }
    
}
