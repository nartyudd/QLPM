/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tcd.pojo;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author duytr
 */
@Entity
@Table(name = "employees")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e"),
    @NamedQuery(name = "Employees.findByEmployeesId", query = "SELECT e FROM Employees e WHERE e.employeesId = :employeesId"),
    @NamedQuery(name = "Employees.findByTennhanvien", query = "SELECT e FROM Employees e WHERE e.tennhanvien = :tennhanvien"),
    @NamedQuery(name = "Employees.findByVitricongviec", query = "SELECT e FROM Employees e WHERE e.vitricongviec = :vitricongviec"),
    @NamedQuery(name = "Employees.findBySodienthoai", query = "SELECT e FROM Employees e WHERE e.sodienthoai = :sodienthoai"),
    @NamedQuery(name = "Employees.findByEmail", query = "SELECT e FROM Employees e WHERE e.email = :email"),
    @NamedQuery(name = "Employees.findByRole", query = "SELECT e FROM Employees e WHERE e.role = :role")})
public class Employees implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "employees_id")
    private Integer employeesId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tennhanvien")
    private String tennhanvien;
    @Size(max = 255)
    @Column(name = "vitricongviec")
    private String vitricongviec;
    @Size(max = 20)
    @Column(name = "sodienthoai")
    private String sodienthoai;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 100)
    @Column(name = "role")
    private String role;
    @OneToMany(mappedBy = "employeesId")
    private Collection<Appointments> appointmentsCollection;
    @OneToMany(mappedBy = "employeesId")
    private Collection<Prescriptions> prescriptionsCollection;

    public Employees() {
    }

    public Employees(Integer employeesId) {
        this.employeesId = employeesId;
    }

    public Employees(Integer employeesId, String tennhanvien) {
        this.employeesId = employeesId;
        this.tennhanvien = tennhanvien;
    }

    public Integer getEmployeesId() {
        return employeesId;
    }

    public void setEmployeesId(Integer employeesId) {
        this.employeesId = employeesId;
    }

    public String getTennhanvien() {
        return tennhanvien;
    }

    public void setTennhanvien(String tennhanvien) {
        this.tennhanvien = tennhanvien;
    }

    public String getVitricongviec() {
        return vitricongviec;
    }

    public void setVitricongviec(String vitricongviec) {
        this.vitricongviec = vitricongviec;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @XmlTransient
    public Collection<Appointments> getAppointmentsCollection() {
        return appointmentsCollection;
    }

    public void setAppointmentsCollection(Collection<Appointments> appointmentsCollection) {
        this.appointmentsCollection = appointmentsCollection;
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
        hash += (employeesId != null ? employeesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employees)) {
            return false;
        }
        Employees other = (Employees) object;
        if ((this.employeesId == null && other.employeesId != null) || (this.employeesId != null && !this.employeesId.equals(other.employeesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tcd.pojo.Employees[ employeesId=" + employeesId + " ]";
    }
    
}
