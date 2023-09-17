package com.tcd.pojo;

import com.tcd.pojo.Appointments;
import com.tcd.pojo.Invoices;
import com.tcd.pojo.Services;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-10T23:42:27")
@StaticMetamodel(Servicedetails.class)
public class Servicedetails_ { 

    public static volatile SingularAttribute<Servicedetails, BigDecimal> tongtien;
    public static volatile SingularAttribute<Servicedetails, Integer> servicedetailId;
    public static volatile SingularAttribute<Servicedetails, Appointments> appointmentId;
    public static volatile CollectionAttribute<Servicedetails, Invoices> invoicesCollection;
    public static volatile SingularAttribute<Servicedetails, Integer> soluong;
    public static volatile SingularAttribute<Servicedetails, Services> serviceId;

}