package entity;

import entity.Tblcity;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-13T18:05:04")
@StaticMetamodel(Tblstate.class)
public class Tblstate_ { 

    public static volatile SingularAttribute<Tblstate, String> stateName;
    public static volatile CollectionAttribute<Tblstate, Tblcity> tblcityCollection;
    public static volatile SingularAttribute<Tblstate, Integer> stateId;

}