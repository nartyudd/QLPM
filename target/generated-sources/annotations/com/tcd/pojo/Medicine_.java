package com.tcd.pojo;

import com.tcd.pojo.Category;
import com.tcd.pojo.Prescriptions;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-06T17:44:24")
@StaticMetamodel(Medicine.class)
public class Medicine_ { 

    public static volatile SingularAttribute<Medicine, BigDecimal> unitPrice;
    public static volatile SingularAttribute<Medicine, String> image;
    public static volatile SingularAttribute<Medicine, Date> createdAt;
    public static volatile CollectionAttribute<Medicine, Prescriptions> prescriptionsCollection;
    public static volatile SingularAttribute<Medicine, String> description;
    public static volatile SingularAttribute<Medicine, Integer> id;
    public static volatile SingularAttribute<Medicine, Boolean> isActive;
    public static volatile SingularAttribute<Medicine, String> medicineName;
    public static volatile SingularAttribute<Medicine, Category> categoryId;
    public static volatile SingularAttribute<Medicine, String> manufacturer;
    public static volatile SingularAttribute<Medicine, Date> updatedAt;

}