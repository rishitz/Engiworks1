package entity;

import entity.Tblachievement;
import entity.Tbluser;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-07T19:46:16")
@StaticMetamodel(Tblattachement.class)
public class Tblattachement_ { 

    public static volatile SingularAttribute<Tblattachement, String> attachmenet;
    public static volatile SingularAttribute<Tblattachement, Integer> attachementId;
    public static volatile CollectionAttribute<Tblattachement, Tblachievement> tblachievementCollection;
    public static volatile SingularAttribute<Tblattachement, Tbluser> userId;

}