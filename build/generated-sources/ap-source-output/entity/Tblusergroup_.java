package entity;

import entity.Tblgroup;
import entity.Tbluser;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-22T01:35:13")
@StaticMetamodel(Tblusergroup.class)
public class Tblusergroup_ { 

    public static volatile SingularAttribute<Tblusergroup, Integer> userGroupId;
    public static volatile SingularAttribute<Tblusergroup, Tblgroup> groupId;
    public static volatile SingularAttribute<Tblusergroup, Tbluser> userId;

}