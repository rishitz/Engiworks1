package entity;

import entity.Tbluser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-01T01:07:02")
@StaticMetamodel(Tbljobverificationrequest.class)
public class Tbljobverificationrequest_ { 

    public static volatile SingularAttribute<Tbljobverificationrequest, Date> createdDate;
    public static volatile SingularAttribute<Tbljobverificationrequest, Integer> verificationRequestId;
    public static volatile SingularAttribute<Tbljobverificationrequest, Tbluser> userId;
    public static volatile SingularAttribute<Tbljobverificationrequest, Integer> status;

}