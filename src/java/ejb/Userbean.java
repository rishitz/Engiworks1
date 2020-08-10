/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.TblMessage;
import entity.Tblachievement;
import entity.Tblattachement;
import entity.Tblbidassigned;
import entity.Tblcity;
import entity.Tblcomment;
import entity.Tblcomplaint;
import entity.Tblgroup;
import entity.Tbljobcategory;
import entity.Tbllikes;
import entity.Tblnotification;
import entity.Tblrequirement;
import entity.Tblrequirementbid;
import entity.Tblreview;
import entity.Tbluser;
import entity.Tblusergroup;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 *
 * @author sebatsian
 */
@Stateless
public class Userbean implements UserbeanLocal {
    
    @PersistenceContext(unitName = "Engiworks-ejbPU")
    EntityManager em;
     
    @Override
    public Tbluser storeSession(String userName) {
         Tbluser u=(Tbluser)em.createNamedQuery("Tbluser.findByUserName").setParameter("userName",userName).getSingleResult();
        return u;
    }

    @Override
    public Collection<Tblrequirement> alljob() {
        return em.createNamedQuery("Tblrequirement.findAll").getResultList();
    }

    @Override
    public void addUser(String userName, String gender, int cityId, String address, String email, String password, int jobCategoryId, int status,String picture) {
        Tbluser u=new Tbluser();
        Pbkdf2PasswordHashImpl pass = new Pbkdf2PasswordHashImpl();
        u.setUserName(userName);
        u.setGender(gender);
        u.setCityId(new Tblcity(cityId));
        u.setAddress(address);
        u.setEmail(email);
        u.setProfileImage(picture);
        u.setPassword(pass.generate(password.toCharArray()));
        u.setJobCategoryId(new Tbljobcategory(jobCategoryId));
        u.setStatus(status);
        em.persist(u);
        em.flush();
        System.out.println("LastID = "+u.getUserId());
       int lastuid=u.getUserId();
       Tblusergroup ug=new Tblusergroup();
       ug.setUserId(new Tbluser(lastuid));
       ug.setGroupId(new Tblgroup(2));
       em.persist(ug);
       
    }

    @Override
    public Collection<Tbljobcategory> getalljob() {
        Collection<Tbljobcategory> job=em.createNamedQuery("Tbljobcategory.findAll").getResultList();
        return job;
    }

    @Override
    public Collection<Tblcity> getallcity() {
        Collection<Tblcity> city=em.createNamedQuery("Tblcity.findAll").getResultList();
    return city; 
    }

    @Override
    public Tbluser user(String uname) {
//         FacesContext context=FacesContext.getCurrentInstance();
//        String username=(String)context.getExternalContext().getSessionMap().get("userName");
//        System.out.println("uname"+username);
        Tbluser u=(Tbluser)em.createNamedQuery("Tbluser.findByUserName").setParameter("userName",uname).getSingleResult();
        return u;
    }

    @Override
    public void updateUser(int uid, String userName, int cityId, String address, String email, int jobCategoryId,String picture) {
        Tbluser u=em.find(Tbluser.class, uid);
        Tblcity c=em.find(Tblcity.class, cityId);
        Collection<Tbluser> ulist=c.getTbluserCollection();
        Tbljobcategory j=em.find(Tbljobcategory.class, jobCategoryId);
        Collection<Tbluser> jlist=j.getTbluserCollection();
        u.setUserName(userName);
        u.setCityId(c);
        u.setAddress(address);
        u.setEmail(email);
        u.setJobCategoryId(j);
        u.setProfileImage(picture);
        em.merge(u);
        ulist.add(u);
        jlist.add(u);
        em.merge(c);
        em.merge(j);
    }

    @Override
    public Tbluser userDetail(int uid) {
        
         return em.find(Tbluser.class,uid);
    }

    @Override
    public List<Object[]> userPostJob(int uid) {
        return em.createNativeQuery("select * from tblrequirement where userId="+uid).getResultList();
    }

    @Override
    public void addJob(int uid, String title, String description, float budget, int duration, String pdf) {
        Tblrequirement r=new  Tblrequirement();
        //Tbluser u1=user();
        System.out.println("UserID:"+uid);
        Tbluser u2=em.find(Tbluser.class, uid);
        
        r.setUserId(new Tbluser(u2.getUserId()));
        r.setTitle(title);
        r.setDescription(description);
       
        r.setBudget(budget);
        r.setDuration(duration);
        r.setPdf(pdf);
        r.setStatus(1);
        em.persist(r);
        em.merge(u2);
    }

    @Override
    public void addAchivement(int uid, String title, String description, String attachment) {
        Tblachievement ac=new Tblachievement();
        Tblattachement at=new Tblattachement();
        Tbluser u2=em.find(Tbluser.class, uid);
        
        at.setAttachmenet(attachment);
        at.setUserId(new Tbluser(u2.getUserId()));
        em.persist(at);
        em.flush();
        int atid=at.getAttachementId();
        System.out.println("attachment"+atid);
        ac.setAttechementId(new Tblattachement(atid));
        ac.setDescription(description);
        ac.setTitle(title);
        ac.setUserId(new Tbluser(u2.getUserId()));
        em.persist(ac);
        
    }
    
    @Override
    public List<Object[]> HomeJob(int uid) {
         return em.createNativeQuery("select * from tblrequirement where userId!='"+uid +"' LIMIT 3").getResultList();
    }

    @Override
    public Tblrequirement ViewMore(int rid) {
        //Tblrequirement u=(Tblrequirement)em.createNamedQuery("Tblrequirement.findByRequirementId").setParameter("requirementId",rid).getSingleResult();
        System.out.println("RID BEAN : "+rid);
        return em.find(Tblrequirement.class,rid);
         //return u;
    }

    @Override
    public List<Object[]> bidcheck(int uid,int rid) {
        //SELECT * FROM `tblrequirementbid` WHERE userId!='18' AND requirementId!='3'
        System.out.println("uid"+uid+"rid="+rid);
        return em.createNativeQuery("select * from tblrequirementbid where userId='"+uid +"' AND requirementId='"+rid+"' ").getResultList();
    }

    

    @Override
    public void addBid(String description, int duration, float budget, Date edate, int uid, int rid) {
      Tbluser u1=em.find(Tbluser.class,uid);
      Tblrequirement r1=em.find(Tblrequirement.class,rid);
      
      Tblrequirementbid rb=new Tblrequirementbid();
      rb.setBudget(budget);
      rb.setDuration(duration);
      rb.setDescription(description);
      rb.setEndingDate(edate);
      rb.setUserId(new Tbluser(u1.getUserId()));
      rb.setRequirementId(new Tblrequirement(r1.getRequirementId()));
      em.persist(rb);
      
      
    }

    @Override
    public List<Object[]> bidInfo(int rid) {
        //select * from tbluser u,tblrequirementbid r,tblachievement a,tblattachement t where u.userId=r.userId AND a.userId=u.userId AND a.attechementId=t.attachementId AND r.requirementId=2 AND a.userId=20 AND a.attechementId=2
            return em.createNativeQuery("select * from tbluser u,tblrequirementbid r where u.userId=r.userId and r.requirementId="+rid).getResultList();
    }

    @Override
    public void bidassign(int uid, int rbid,int rid) {
        Tbluser u1=em.find(Tbluser.class,uid);
        Tblrequirementbid r1=em.find(Tblrequirementbid.class,rbid);
        Tblrequirement re=em.find(Tblrequirement.class, rid);
        Tblbidassigned ba=new Tblbidassigned();
        ba.setRequirementBidId(new Tblrequirementbid(r1.getRequirementBidId()));
        ba.setUserId(new Tbluser(u1.getUserId()));
        ba.setRequirementId(new Tblrequirement(re.getRequirementId()));
        //Tblrequirement r=new  Tblrequirement();
        re.setStatus(1);
        
        em.persist(ba);
    }

    @Override
    public void removeBid(int rbid) {
        Tblrequirementbid j=em.find(Tblrequirementbid.class, rbid);
        em.remove(j);
    }

    @Override
    public List<Object[]> manageTask(int rid) {
        //Select *FROM tbluser u,tbljobcategory j WHERE u.jobcategoryId=j.jobCategoryId AND u.userId=20
        return em.createNativeQuery("select * from tbluser u,tblrequirementbid r where u.userId=r.userId and r.requirementId="+rid).getResultList();
    }

    @Override
    public List<Object[]> ManageBidders(int uid, int rid) {
       // SELECT * FROM tbluser u,tblbidassigned b WHERE u.userId=b.userId AND b.requirementId=1
        return em.createNativeQuery("select * from tbluser u,tblrequirementbid r,tblachievement a,tblattachement t where u.userId=r.userId AND a.userId=u.userId and a.attechementId=t.attachementId and r.requirementId='"+rid +"' AND a.userId='"+uid +"' ").getResultList();
    }

    @Override
    public void comment(int uid, int aid, String description, int fromuid) {
        Tbluser u1=em.find(Tbluser.class,uid);
        Tbluser u2=em.find(Tbluser.class,fromuid);
        Tblachievement a=em.find(Tblachievement.class,aid);
        Tblcomment c=new Tblcomment();
        Tblnotification n=new Tblnotification();
        n.setNotification("commented "+description+" on achivement");
        c.setDescription(description);
        c.setToUserId(new Tbluser(u1.getUserId()));
        c.setFromUserId(new Tbluser(u2.getUserId()));
        c.setAchievementId(new Tblachievement(a.getAchievementId()));
        em.persist(c);
      
    }

    @Override
    public List<Object[]> viewBidder(int rid) {
        return em.createNativeQuery("SELECT * FROM tbluser u,tblbidassigned b WHERE u.userId=b.userId AND b.requirementId="+rid).getResultList();
    }

    @Override
    public void complaint(int uid, String complaint, int fromuid) {
        Tbluser u1=em.find(Tbluser.class,uid);
        Tbluser u2=em.find(Tbluser.class,fromuid);
        
        Tblcomplaint c=new Tblcomplaint();
         Tblnotification n=new Tblnotification();
       c.setComplaint(complaint);
       n.setNotification("complaint "+complaint);
       n.setUserId(new Tbluser(u1.getUserId()));
       n.setFromUserId(new Tbluser(u2.getUserId()));
        c.setToUserId(new Tbluser(u1.getUserId()));
        c.setUserId(new Tbluser(u2.getUserId()));
        c.setStatus(1);        
        em.persist(c);
    }
    @Override
    public void review(int uid, String review, int fromuid,int rat,int rid) {
        Tbluser u1=em.find(Tbluser.class,uid);
        Tbluser u2=em.find(Tbluser.class,fromuid);
        Tblrequirement r=em.find(Tblrequirement.class,rid);
        
        Tblreview c=new Tblreview();
        Tblnotification n=new Tblnotification();
        n.setUserId(new Tbluser(u1.getUserId()));
        n.setFromUserId(new Tbluser(u2.getUserId()));
        n.setNotification("review "+review);
        n.setStatus(0);
        em.persist(n);
        c.setReview(review);
        c.setRatings(rat);
        c.setToUserId(new Tbluser(u1.getUserId()));
        c.setFromUserId(new Tbluser(u2.getUserId()));
        c.setStatus(1);
        c.setRequirementId(new Tblrequirement(r.getRequirementId()));
        
        em.persist(c);
    }

    @Override
    public List<Object[]> notification(int uid) {
        return em.createNativeQuery("select * from tblnotification n,tbluser u where u.userId=n.fromUserId and n.userId="+uid).getResultList();
    }

    @Override
    public Object getUserReview(int uid) {
        return em.createNativeQuery("select Avg(ratings) from tblreview where toUserId="+uid).getSingleResult();
    }

    @Override
    public List<Object[]> checkReview(int uid, int rid) {        
        return em.createNativeQuery("select * from tblrequirement r,tblreview re where r.requirementId=re.requirementId and re.requirementId='"+rid +"' AND re.fromUserId='"+uid +"' ").getResultList();
    }

    @Override
    public void like(int touid, int fuid, int aid) {
        Tbluser u1=em.find(Tbluser.class,touid);
        Tbluser u2=em.find(Tbluser.class,fuid);
        Tblachievement a=em.find(Tblachievement.class, aid);
        Tbllikes l=new Tbllikes();
        l.setToUserId(new Tbluser(u1.getUserId()));
        l.setFromUserId(new Tbluser(u2.getUserId()));
        l.setAchievementId(new Tblachievement(a.getAchievementId()));
        em.persist(l);      
        
    }

    @Override
    public List<Object[]> checkLike(int uid, int aid) {
        return em.createNativeQuery("select * from tbllikes l,tbluser u where l.fromUserId=u.userId and l.achievementId='"+aid+"' AND l.fromUserId='"+uid+"' ").getResultList();
    }

    @Override
    public List<Object[]> assignJob(int uid) {
        return em.createNativeQuery("select *from tbluser u,tblbidassigned b,tblrequirement r,tbljobcategory j where u.jobcategoryId=j.jobcategoryId AND u.userId=b.userId and b.requirementId=r.requirementId AND b.userId="+uid).getResultList();
    }

    @Override
    public List<Object[]> viewAllreviews(int uid) {
        return em.createNativeQuery("SELECT *FROM tbluser u,tblreview r WHERE r.fromUserId=u.userId AND r.toUserId="+uid).getResultList();
    }

    @Override
    public List<Object[]> checkDetails(String uname, String email) {
        System.out.println("In bean"+uname+email);
        return em.createNativeQuery("select *from tbluser where userName='"+uname+"' and email='"+email+"' ").getResultList();
    }

    @Override
    public void changePassword(int uid, String password) {
        Tbluser u=em.find(Tbluser.class,uid);
        Pbkdf2PasswordHashImpl pass=new Pbkdf2PasswordHashImpl();
        u.setPassword(pass.generate(password.toCharArray()));
        em.merge(u);
    }

    @Override
    public Object getLikes(int aid) {       
       return em.createNativeQuery("SELECT COUNT(likeId) FROM tbllikes where achievementId="+aid).getSingleResult();
    }

    @Override
    public List<Object[]> checkBid(int uid, int jid) {
        return em.createNativeQuery("select * from tblbidassigned where userId='"+uid+"' AND requirementId='"+jid+"' ").getResultList();
    }

    @Override
    public List<Object[]> showEngname(int uid) {
        return em.createNativeQuery("Select *FROM tbluser u,tbljobcategory j WHERE u.jobcategoryId=j.jobCategoryId AND u.userId="+uid).getResultList();
    }
    
     @Override
    public List<Object[]> getAllUsersData() {
          return em.createNativeQuery("SELECT u.userId,userName,gender,cityId,address,email,j.jobCategoryName,u.profileImage FROM tbluser u,tblusergroup ug,tbljobcategory j WHERE u.userId = ug.userId AND ug.groupId = 2 AND u.jobCategoryId=j.jobCategoryId").getResultList();
//        return em.createNamedQuery("Tblusergroup.findAll").getResultList();
    }

    @Override
    public List<Object[]> showBidDetails(int uid) {
        return em.createNativeQuery("SELECT *FROM tblbidassigned b,tblrequirement r WHERE b.requirementId=r.requirementId AND b.userId="+uid).getResultList();
    }

    @Override
    public List<Object[]> AppliedViewMore(int uid,int rid) {
        return em.createNativeQuery("SELECT *from tbluser u,tblrequirement r,tblbidassigned b WHERE u.userid=b.userId AND r.requirementId=b.requirementId AND b.requirementId="+rid+" AND b.userId="+uid).getResultList();
    }

    @Override
    public void addMessage(int fromuid, int touid, String message,int jid) {      
        TblMessage m=new TblMessage();
        Tbluser u1=em.find(Tbluser.class,touid);
        Tbluser u2=em.find(Tbluser.class,fromuid);
        Tblrequirement r=em.find(Tblrequirement.class, jid);
        m.setMessage(message);
        m.setFromUserId(new Tbluser(u2.getUserId()));
        m.setToUserId(new Tbluser(u1.getUserId()));
        m.setRequirementId(new Tblrequirement(r.getRequirementId()));
        em.persist(m);
        
    }

    @Override
    public List<Object[]> message(int jid) {
                       
        return em.createNativeQuery("SELECT * FROM tblMessage m,tbluser u WHERE m.toUserId=u.userId AND m.fromUserId=u.userId AND m.requirementId="+jid).getResultList();
    }
    
    
    
}
