package entity;

import entity.Tblgroup;
import entity.Tbluser;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-24T20:11:31")
@StaticMetamodel(Tblusergroup.class)
public class Tblusergroup_ { 

    public static volatile SingularAttribute<Tblusergroup, Integer> userGroupId;
    public static volatile SingularAttribute<Tblusergroup, Tblgroup> groupId;
    public static volatile SingularAttribute<Tblusergroup, Tbluser> userId;

}