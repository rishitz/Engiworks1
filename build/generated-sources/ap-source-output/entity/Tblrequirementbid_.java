package entity;

import entity.Tblbidassigned;
import entity.Tblrequirement;
import entity.Tbluser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-24T20:11:31")
@StaticMetamodel(Tblrequirementbid.class)
public class Tblrequirementbid_ { 

    public static volatile SingularAttribute<Tblrequirementbid, Integer> duration;
    public static volatile SingularAttribute<Tblrequirementbid, Date> createdDate;
    public static volatile SingularAttribute<Tblrequirementbid, Date> endingDate;
    public static volatile SingularAttribute<Tblrequirementbid, String> description;
    public static volatile CollectionAttribute<Tblrequirementbid, Tblbidassigned> tblbidassignedCollection;
    public static volatile SingularAttribute<Tblrequirementbid, Tblrequirement> requirementId;
    public static volatile SingularAttribute<Tblrequirementbid, Integer> requirementBidId;
    public static volatile SingularAttribute<Tblrequirementbid, Tbluser> userId;
    public static volatile SingularAttribute<Tblrequirementbid, Float> budget;
    public static volatile SingularAttribute<Tblrequirementbid, Integer> status;

}