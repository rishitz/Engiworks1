package entity;

import entity.Tblachievement;
import entity.Tblattachement;
import entity.Tblbidassigned;
import entity.Tblcity;
import entity.Tblcomment;
import entity.Tblcomplaint;
import entity.Tbljobcategory;
import entity.Tbllikes;
import entity.Tblnotification;
import entity.Tblrequirement;
import entity.Tblrequirementbid;
import entity.Tblreview;
import entity.Tblusergroup;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-12T19:03:26")
@StaticMetamodel(Tbluser.class)
public class Tbluser_ { 

    public static volatile SingularAttribute<Tbluser, String> gender;
    public static volatile CollectionAttribute<Tbluser, Tblcomment> tblcommentCollection1;
    public static volatile CollectionAttribute<Tbluser, Tblrequirement> tblrequirementCollection;
    public static volatile CollectionAttribute<Tbluser, Tblreview> tblreviewCollection1;
    public static volatile SingularAttribute<Tbluser, String> profileImage;
    public static volatile CollectionAttribute<Tbluser, Tblachievement> tblachievementCollection;
    public static volatile CollectionAttribute<Tbluser, Tblcomment> tblcommentCollection;
    public static volatile SingularAttribute<Tbluser, Tblcity> cityId;
    public static volatile CollectionAttribute<Tbluser, Tblrequirementbid> tblrequirementbidCollection;
    public static volatile SingularAttribute<Tbluser, String> password;
    public static volatile CollectionAttribute<Tbluser, Tblnotification> tblnotificationCollection1;
    public static volatile CollectionAttribute<Tbluser, Tblcomplaint> tblcomplaintCollection1;
    public static volatile CollectionAttribute<Tbluser, Tblattachement> tblattachementCollection;
    public static volatile SingularAttribute<Tbluser, String> email;
    public static volatile CollectionAttribute<Tbluser, Tblcomplaint> tblcomplaintCollection;
    public static volatile SingularAttribute<Tbluser, String> address;
    public static volatile SingularAttribute<Tbluser, String> userName;
    public static volatile SingularAttribute<Tbluser, Integer> userId;
    public static volatile CollectionAttribute<Tbluser, Tbllikes> tbllikesCollection;
    public static volatile CollectionAttribute<Tbluser, Tblreview> tblreviewCollection;
    public static volatile CollectionAttribute<Tbluser, Tblnotification> tblnotificationCollection;
    public static volatile CollectionAttribute<Tbluser, Tblusergroup> tblusergroupCollection;
    public static volatile CollectionAttribute<Tbluser, Tblbidassigned> tblbidassignedCollection;
    public static volatile SingularAttribute<Tbluser, Tbljobcategory> jobCategoryId;
    public static volatile SingularAttribute<Tbluser, Integer> status;

}