package entity;

import entity.TblMessage;
import entity.Tblbidassigned;
import entity.Tblrequirementbid;
import entity.Tblreview;
import entity.Tbluser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-24T20:11:31")
@StaticMetamodel(Tblrequirement.class)
public class Tblrequirement_ { 

    public static volatile SingularAttribute<Tblrequirement, String> description;
    public static volatile SingularAttribute<Tblrequirement, String> title;
    public static volatile SingularAttribute<Tblrequirement, Tbluser> userId;
    public static volatile CollectionAttribute<Tblrequirement, Tblrequirementbid> tblrequirementbidCollection;
    public static volatile SingularAttribute<Tblrequirement, Integer> duration;
    public static volatile SingularAttribute<Tblrequirement, Date> createdDate;
    public static volatile SingularAttribute<Tblrequirement, String> pdf;
    public static volatile CollectionAttribute<Tblrequirement, Tblreview> tblreviewCollection;
    public static volatile CollectionAttribute<Tblrequirement, TblMessage> tblMessageCollection;
    public static volatile CollectionAttribute<Tblrequirement, Tblbidassigned> tblbidassignedCollection;
    public static volatile SingularAttribute<Tblrequirement, Integer> requirementId;
    public static volatile SingularAttribute<Tblrequirement, Integer> status;
    public static volatile SingularAttribute<Tblrequirement, Float> budget;

}