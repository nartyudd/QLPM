package com.tcd.pojo;

import com.tcd.pojo.Servicedetails;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-09T16:58:30")
@StaticMetamodel(Services.class)
public class Services_ { 

    public static volatile SingularAttribute<Services, BigDecimal> giadichvu;
    public static volatile SingularAttribute<Services, String> tendichvu;
    public static volatile SingularAttribute<Services, Integer> serviceId;
    public static volatile CollectionAttribute<Services, Servicedetails> servicedetailsCollection;

}