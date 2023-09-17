package com.tcd.pojo;

import com.tcd.pojo.Appointments;
import com.tcd.pojo.Prescriptions;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-10T23:42:27")
@StaticMetamodel(Employees.class)
public class Employees_ { 

    public static volatile SingularAttribute<Employees, String> sodienthoai;
    public static volatile SingularAttribute<Employees, String> role;
    public static volatile SingularAttribute<Employees, String> vitricongviec;
    public static volatile SingularAttribute<Employees, String> tennhanvien;
    public static volatile CollectionAttribute<Employees, Prescriptions> prescriptionsCollection;
    public static volatile SingularAttribute<Employees, Integer> employeesId;
    public static volatile SingularAttribute<Employees, String> email;
    public static volatile CollectionAttribute<Employees, Appointments> appointmentsCollection;

}