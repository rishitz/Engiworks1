package entity;

import entity.Tbluser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-05T00:40:49")
@StaticMetamodel(Tblmessage.class)
public class Tblmessage_ { 

    public static volatile SingularAttribute<Tblmessage, Date> createdDate;
    public static volatile SingularAttribute<Tblmessage, Integer> messageId;
    public static volatile SingularAttribute<Tblmessage, String> message;
    public static volatile SingularAttribute<Tblmessage, Tbluser> userId;
    public static volatile SingularAttribute<Tblmessage, Integer> status;

}