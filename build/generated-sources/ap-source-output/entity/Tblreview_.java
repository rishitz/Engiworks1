package entity;

import entity.Tbluser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-01T01:07:02")
@StaticMetamodel(Tblreview.class)
public class Tblreview_ { 

    public static volatile SingularAttribute<Tblreview, Date> createdDate;
    public static volatile SingularAttribute<Tblreview, String> review;
    public static volatile SingularAttribute<Tblreview, Tbluser> fromUserId;
    public static volatile SingularAttribute<Tblreview, Integer> reviewId;
    public static volatile SingularAttribute<Tblreview, Tbluser> toUserId;
    public static volatile SingularAttribute<Tblreview, Integer> status;

}