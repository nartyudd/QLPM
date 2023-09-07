package com.tcd.pojo;

import com.tcd.pojo.Medicine;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-06T17:44:24")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile SingularAttribute<Category, Long> id;
    public static volatile CollectionAttribute<Category, Medicine> medicineCollection;
    public static volatile SingularAttribute<Category, String> categoryName;

}