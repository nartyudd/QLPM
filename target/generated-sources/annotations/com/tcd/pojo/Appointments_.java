package com.tcd.pojo;

import com.tcd.pojo.Employees;
import com.tcd.pojo.Patients;
import com.tcd.pojo.Servicedetails;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-06T17:44:24")
@StaticMetamodel(Appointments.class)
public class Appointments_ { 

    public static volatile SingularAttribute<Appointments, String> trangthai;
    public static volatile SingularAttribute<Appointments, Patients> patientId;
    public static volatile SingularAttribute<Appointments, Integer> appointmentId;
    public static volatile SingularAttribute<Appointments, Date> ngaygio;
    public static volatile SingularAttribute<Appointments, Employees> employeesId;
    public static volatile CollectionAttribute<Appointments, Servicedetails> servicedetailsCollection;

}