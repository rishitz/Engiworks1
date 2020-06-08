package entity;

import entity.Tblachievement;
import entity.Tbluser;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-08T22:43:29")
@StaticMetamodel(Tbllikes.class)
public class Tbllikes_ { 

    public static volatile SingularAttribute<Tbllikes, Integer> likeId;
    public static volatile SingularAttribute<Tbllikes, Tblachievement> achievementId;
    public static volatile SingularAttribute<Tbllikes, Tbluser> userId;

}