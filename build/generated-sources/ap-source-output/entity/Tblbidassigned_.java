package entity;

import entity.Tblrequirementbid;
import entity.Tbluser;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-21T01:18:53")
@StaticMetamodel(Tblbidassigned.class)
public class Tblbidassigned_ { 

    public static volatile SingularAttribute<Tblbidassigned, Integer> bidAssignedId;
    public static volatile SingularAttribute<Tblbidassigned, Tbluser> userId;
    public static volatile SingularAttribute<Tblbidassigned, Tblrequirementbid> requirementBidId;

}