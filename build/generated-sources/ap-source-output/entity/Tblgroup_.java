package entity;

import entity.Tblusergroup;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-12T19:03:26")
@StaticMetamodel(Tblgroup.class)
public class Tblgroup_ { 

    public static volatile SingularAttribute<Tblgroup, String> groupName;
    public static volatile SingularAttribute<Tblgroup, Integer> groupId;
    public static volatile CollectionAttribute<Tblgroup, Tblusergroup> tblusergroupCollection;

}