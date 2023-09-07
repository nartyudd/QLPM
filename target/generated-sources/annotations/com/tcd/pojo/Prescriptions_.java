package com.tcd.pojo;

import com.tcd.pojo.Employees;
import com.tcd.pojo.Invoices;
import com.tcd.pojo.Medicine;
import com.tcd.pojo.Patients;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-06T17:44:24")
@StaticMetamodel(Prescriptions.class)
public class Prescriptions_ { 

    public static volatile SingularAttribute<Prescriptions, Integer> prescriptionId;
    public static volatile SingularAttribute<Prescriptions, Date> ngaykedon;
    public static volatile SingularAttribute<Prescriptions, Patients> patientId;
    public static volatile SingularAttribute<Prescriptions, Medicine> medicineId;
    public static volatile CollectionAttribute<Prescriptions, Invoices> invoicesCollection;
    public static volatile SingularAttribute<Prescriptions, Employees> employeesId;

}