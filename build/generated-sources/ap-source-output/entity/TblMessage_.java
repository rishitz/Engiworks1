package entity;

import entity.Tblrequirement;
import entity.Tbluser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-13T18:05:04")
@StaticMetamodel(TblMessage.class)
public class TblMessage_ { 

    public static volatile SingularAttribute<TblMessage, Date> createdDate;
    public static volatile SingularAttribute<TblMessage, Tbluser> fromUserId;
    public static volatile SingularAttribute<TblMessage, Integer> messageId;
    public static volatile SingularAttribute<TblMessage, String> message;
    public static volatile SingularAttribute<TblMessage, Tblrequirement> requirementId;
    public static volatile SingularAttribute<TblMessage, Tbluser> toUserId;

}