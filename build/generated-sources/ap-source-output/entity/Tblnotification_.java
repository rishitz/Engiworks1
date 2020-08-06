package entity;

import entity.Tbluser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-06T22:43:05")
@StaticMetamodel(Tblnotification.class)
public class Tblnotification_ { 

    public static volatile SingularAttribute<Tblnotification, String> notification;
    public static volatile SingularAttribute<Tblnotification, Date> createddate;
    public static volatile SingularAttribute<Tblnotification, Tbluser> fromUserId;
    public static volatile SingularAttribute<Tblnotification, Integer> notificationId;
    public static volatile SingularAttribute<Tblnotification, Tbluser> userId;
    public static volatile SingularAttribute<Tblnotification, Integer> status;

}