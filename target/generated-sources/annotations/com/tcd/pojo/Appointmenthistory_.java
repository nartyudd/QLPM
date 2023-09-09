package com.tcd.pojo;

import com.tcd.pojo.Patients;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-09T16:58:30")
@StaticMetamodel(Appointmenthistory.class)
public class Appointmenthistory_ { 

    public static volatile SingularAttribute<Appointmenthistory, String> trangthai;
    public static volatile SingularAttribute<Appointmenthistory, Patients> patientId;
    public static volatile SingularAttribute<Appointmenthistory, Integer> appointmenthistoryId;
    public static volatile SingularAttribute<Appointmenthistory, Date> ngaygio;

}