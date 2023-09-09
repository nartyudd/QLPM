package com.tcd.pojo;

import com.tcd.pojo.Patients;
import com.tcd.pojo.Prescriptions;
import com.tcd.pojo.Servicedetails;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-09T16:58:30")
@StaticMetamodel(Invoices.class)
public class Invoices_ { 

    public static volatile SingularAttribute<Invoices, String> trangthaithanhtoan;
    public static volatile SingularAttribute<Invoices, Prescriptions> prescriptionId;
    public static volatile SingularAttribute<Invoices, Servicedetails> servicedetailId;
    public static volatile SingularAttribute<Invoices, Patients> patientId;
    public static volatile SingularAttribute<Invoices, Integer> invoiceId;
    public static volatile SingularAttribute<Invoices, Date> ngayxuathoadon;
    public static volatile SingularAttribute<Invoices, BigDecimal> tongtienhoadon;

}