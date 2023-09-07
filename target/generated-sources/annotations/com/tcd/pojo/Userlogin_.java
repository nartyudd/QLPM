package com.tcd.pojo;

import com.tcd.pojo.Employees;
import com.tcd.pojo.Patients;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-06T17:44:24")
@StaticMetamodel(Userlogin.class)
public class Userlogin_ { 

    public static volatile CollectionAttribute<Userlogin, Employees> employeesCollection;
    public static volatile SingularAttribute<Userlogin, String> password;
    public static volatile SingularAttribute<Userlogin, String> permissions;
    public static volatile SingularAttribute<Userlogin, Long> userloginId;
    public static volatile SingularAttribute<Userlogin, String> avatar;
    public static volatile CollectionAttribute<Userlogin, Patients> patientsCollection;
    public static volatile SingularAttribute<Userlogin, String> username;

}