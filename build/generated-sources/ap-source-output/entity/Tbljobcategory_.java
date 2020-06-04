package entity;

import entity.Tbljobsubcategory;
import entity.Tbluser;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-05T00:40:49")
@StaticMetamodel(Tbljobcategory.class)
public class Tbljobcategory_ { 

    public static volatile CollectionAttribute<Tbljobcategory, Tbljobsubcategory> tbljobsubcategoryCollection;
    public static volatile CollectionAttribute<Tbljobcategory, Tbluser> tbluserCollection;
    public static volatile SingularAttribute<Tbljobcategory, Integer> jobCategoryId;
    public static volatile SingularAttribute<Tbljobcategory, String> jobCategoryName;

}