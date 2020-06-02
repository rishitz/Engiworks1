package entity;

import entity.Tblattachement;
import entity.Tblcomment;
import entity.Tbllikes;
import entity.Tbluser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-02T16:42:20")
@StaticMetamodel(Tblachievement.class)
public class Tblachievement_ { 

    public static volatile SingularAttribute<Tblachievement, Date> createdDate;
    public static volatile SingularAttribute<Tblachievement, Integer> achievementId;
    public static volatile SingularAttribute<Tblachievement, String> description;
    public static volatile CollectionAttribute<Tblachievement, Tblcomment> tblcommentCollection;
    public static volatile SingularAttribute<Tblachievement, String> title;
    public static volatile CollectionAttribute<Tblachievement, Tbllikes> tbllikesCollection;
    public static volatile SingularAttribute<Tblachievement, Tbluser> userId;
    public static volatile SingularAttribute<Tblachievement, Tblattachement> attechementId;

}