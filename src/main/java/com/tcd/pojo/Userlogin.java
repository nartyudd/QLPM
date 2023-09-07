/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tcd.pojo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "userlogin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userlogin.findAll", query = "SELECT u FROM Userlogin u"),
    @NamedQuery(name = "Userlogin.findByUserloginId", query = "SELECT u FROM Userlogin u WHERE u.userloginId = :userloginId"),
    @NamedQuery(name = "Userlogin.findByUsername", query = "SELECT u FROM Userlogin u WHERE u.username = :username"),
    @NamedQuery(name = "Userlogin.findByPassword", query = "SELECT u FROM Userlogin u WHERE u.password = :password"),
    @NamedQuery(name = "Userlogin.findByAvatar", query = "SELECT u FROM Userlogin u WHERE u.avatar = :avatar"),
    @NamedQuery(name = "Userlogin.findByPermissions", query = "SELECT u FROM Userlogin u WHERE u.permissions = :permissions")})
public class Userlogin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userlogin_id")
    private Long userloginId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    @Size(max = 100)
    @Column(name = "avatar")
    private String avatar;
    @Size(max = 50)
    @Column(name = "permissions")
    private String permissions;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Patients> patientsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Employees> employeesCollection;

    public Userlogin() {
    }

    public Userlogin(Long userloginId) {
        this.userloginId = userloginId;
    }

    public Userlogin(Long userloginId, String username, String password) {
        this.userloginId = userloginId;
        this.username = username;
        this.password = password;
    }

    public Long getUserloginId() {
        return userloginId;
    }

    public void setUserloginId(Long userloginId) {
        this.userloginId = userloginId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    @XmlTransient
    public Collection<Patients> getPatientsCollection() {
        return patientsCollection;
    }

    public void setPatientsCollection(Collection<Patients> patientsCollection) {
        this.patientsCollection = patientsCollection;
    }

    @XmlTransient
    public Collection<Employees> getEmployeesCollection() {
        return employeesCollection;
    }

    public void setEmployeesCollection(Collection<Employees> employeesCollection) {
        this.employeesCollection = employeesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userloginId != null ? userloginId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userlogin)) {
            return false;
        }
        Userlogin other = (Userlogin) object;
        if ((this.userloginId == null && other.userloginId != null) || (this.userloginId != null && !this.userloginId.equals(other.userloginId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tcd.pojo.Userlogin[ userloginId=" + userloginId + " ]";
    }
    
}
