package entity;

import entity.Tbljobcategory;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-14T23:43:03")
@StaticMetamodel(Tbljobsubcategory.class)
public class Tbljobsubcategory_ { 

    public static volatile SingularAttribute<Tbljobsubcategory, String> jobSubCategoryName;
    public static volatile SingularAttribute<Tbljobsubcategory, Tbljobcategory> jobCategoryId;
    public static volatile SingularAttribute<Tbljobsubcategory, Integer> jobSubCategoryId;

}