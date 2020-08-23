package entity;

import entity.Tblstate;
import entity.Tbluser;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-23T23:22:37")
@StaticMetamodel(Tblcity.class)
public class Tblcity_ { 

    public static volatile SingularAttribute<Tblcity, String> cityName;
    public static volatile SingularAttribute<Tblcity, Tblstate> stateId;
    public static volatile CollectionAttribute<Tblcity, Tbluser> tbluserCollection;
    public static volatile SingularAttribute<Tblcity, Integer> cityId;

}