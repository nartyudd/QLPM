package com.tcd.pojo;

import com.tcd.pojo.Appointmenthistory;
import com.tcd.pojo.Appointments;
import com.tcd.pojo.Invoices;
import com.tcd.pojo.Prescriptions;
import com.tcd.pojo.Userlogin;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-09T16:58:30")
@StaticMetamodel(Patients.class)
public class Patients_ { 

    public static volatile SingularAttribute<Patients, Date> ngaykhamgannhat;
    public static volatile SingularAttribute<Patients, String> gioitinh;
    public static volatile SingularAttribute<Patients, Integer> patientId;
    public static volatile CollectionAttribute<Patients, Prescriptions> prescriptionsCollection;
    public static volatile SingularAttribute<Patients, Date> ngaysinh;
    public static volatile CollectionAttribute<Patients, Appointmenthistory> appointmenthistoryCollection;
    public static volatile CollectionAttribute<Patients, Invoices> invoicesCollection;
    public static volatile SingularAttribute<Patients, Userlogin> userId;
    public static volatile SingularAttribute<Patients, String> sodienthoai;
    public static volatile SingularAttribute<Patients, String> diachi;
    public static volatile SingularAttribute<Patients, String> hoTen;
    public static volatile SingularAttribute<Patients, String> email;
    public static volatile SingularAttribute<Patients, String> lichsubenhly;
    public static volatile CollectionAttribute<Patients, Appointments> appointmentsCollection;

}