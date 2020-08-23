package entity;

import entity.Tblachievement;
import entity.Tbluser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-23T23:22:37")
@StaticMetamodel(Tblcomment.class)
public class Tblcomment_ { 

    public static volatile SingularAttribute<Tblcomment, Date> createdDate;
    public static volatile SingularAttribute<Tblcomment, Tbluser> fromUserId;
    public static volatile SingularAttribute<Tblcomment, Integer> commentId;
    public static volatile SingularAttribute<Tblcomment, String> description;
    public static volatile SingularAttribute<Tblcomment, Tblachievement> achievementId;
    public static volatile SingularAttribute<Tblcomment, Tbluser> toUserId;

}