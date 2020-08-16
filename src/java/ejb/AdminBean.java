/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Tblachievement;
import entity.Tblcity;
import entity.Tblcomment;
import entity.Tblcomplaint;
import entity.Tbljobcategory;
import entity.Tbljobsubcategory;
import entity.Tblrequirement;
import entity.Tblrequirementbid;
import entity.Tblreview;
import entity.Tblstate;
import entity.Tbluser;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sebatsian
 */
@Stateless
public class AdminBean implements AdminBeanLocal {

     @PersistenceContext(unitName = "Engiworks-ejbPU")
    EntityManager em;
     
       @Override
    public Collection<Tblachievement> getAllAchievement() {
        return em.createNamedQuery("Tblachievement.findAll").getResultList();
    }

    
    //---------------------------------------------------------------------------------- CITY 
    @Override
    public void addCity(String cname,int sid) {
//        Tblcity obja = new Tblcity();
//        Tblstate s = c.getStateId();
//        Tblstate s1 = em.find(Tblstate.class, s.getStateId());
//        Collection<Tblcity> t = s1.getTblcityCollection();
//        obja.setCityName(c.getCityName());
//        obja.setStateId(s1);
//        t.add(obja);
//        em.merge(s1);
//        em.persist(obja);  
        Tblcity cat = new Tblcity();
        Tblstate c = em.find(Tblstate.class, sid);
        cat.setCityName(cname);
        cat.setStateId(new Tblstate(c.getStateId()));
        em.persist(cat);     
        em.merge(c);
        
    }

    @Override
    public Collection<Tblcity> getAllCity() {
        return em.createNamedQuery("Tblcity.findAll").getResultList();
    }

    @Override
    public void deleteCity(int c) {
    try{
        Tblcity city = em.find(Tblcity.class, c);
        em.remove(city);
       }
    catch(Exception ex){ex.getMessage();}
    }
    
        @Override
    public Tblcity getUpdateCity(int cid) {
        return em.find(Tblcity.class, cid);
    }

    @Override
    public void postUpdateCity(int cid, String cn, int stid) {
     Tblcity c = em.find(Tblcity.class, cid);
     Tblstate jc = em.find(Tblstate.class,stid);
     Collection<Tblcity> t = jc.getTblcityCollection();
        c.setStateId(jc);
        c.setCityName(cn);
        em.merge(c);
        t.add(c);
        em.merge(jc);    }
//-------------------------------------------------------------------------------------- Comment 
    @Override
    public Collection<Tblcomment> getAllComment() {
        return em.createNamedQuery("Tblcomment.findAll").getResultList();
    }
//-------------------------------------------------------------------------------------- Compaint 

    @Override
    public Collection<Tblcomplaint> getAllComplaint() {
        return em.createNamedQuery("Tblcomplaint.findAll").getResultList();
    }
     @Override
    public List<Object[]> getUserComplaint(int uid) {
return em.createNativeQuery("SELECT u.userName,c.complaint,c.createdDate FROM tbluser u,tblcomplaint c WHERE u.userId = c.fromUserId  AND c.userId ='"+uid+"'").getResultList();    }
//------------------------------ Complaint block Is Left-------------

   
 //------------------------------------------------------------------------------------ JobCategory 
//    @Override
//    public void addJobCategory(Tbljobcategory jc) {
//        Tbljobcategory objjc = new Tbljobcategory();
//        objjc.setJobCategoryName(jc.getJobCategoryName());
//        em.persist(objjc);
//    }

    @Override
    public void addJobCategory(String jcn) {
        Tbljobcategory cat = new Tbljobcategory();
        cat.setJobCategoryName(jcn);
        em.persist(cat);  
    }
    
    @Override
    public Collection<Tbljobcategory> getAlljobCategory() {
        return em.createNamedQuery("Tbljobcategory.findAll").getResultList();
    }

    @Override
    public Tbljobcategory getUpdateJobCategory(int jcid) {
        Tbljobcategory c = em.find(Tbljobcategory.class, jcid);
        return c;   
    }
    
    @Override
    public void postUpdateCategory(int jcid, String jcn) {
        Tbljobcategory c = em.find(Tbljobcategory.class, jcid);
        c.setJobCategoryId(jcid);
        c.setJobCategoryName(jcn);
        em.merge(c);    
    }

    @Override
    public void deleteJobCategory(int jcid) {
        try{
               Tbljobcategory jc = em.find(Tbljobcategory.class, jcid);
                em.remove(jc);
        }
        catch(Exception ex){ex.getMessage();}
    }
//-------------------------------------------------------------------------------------- JobSubCategory 
//    @Override
//    public void addJobSubCategory(Tbljobsubcategory jc) {
//        Tbljobsubcategory objjsc = new Tbljobsubcategory();
//        Tbljobcategory j = jc.getJobCategoryId();
//        Tbljobcategory j1 = em.find(Tbljobcategory.class,j.getJobCategoryId());
//        Collection<Tbljobsubcategory> t = j1.getTbljobsubcategoryCollection();
//        objjsc.setJobCategoryId(j1);
//        objjsc.setJobSubCategoryName(jc.getJobSubCategoryName());
//        t.add(objjsc);
//        em.merge(j1);
//        em.persist(jc);
//    }
    
    @Override
    public void addJobSubCategory(String jscn, int jcid) {
        Tbljobsubcategory cat = new Tbljobsubcategory();
      System.out.println("JobCatID:"+jcid);
      Tbljobcategory c = em.find(Tbljobcategory.class, jcid);

        cat.setJobSubCategoryName(jscn);
        cat.setJobCategoryId(new Tbljobcategory(c.getJobCategoryId()));
        em.persist(cat);     
        em.merge(c);
    }

    @Override
    public Tbljobsubcategory getUpdateSubCategory(int cid) {
        return em.find(Tbljobsubcategory.class, cid);
    }

//    @Override
//    public void postUpdateJobSubCategory(Tbljobsubcategory jc) {
//        Tbljobsubcategory jsc = em.find(Tbljobsubcategory.class,jc.getJobSubCategoryId());
//        Tbljobcategory j = jc.getJobCategoryId();
//        Tbljobcategory j1 = em.find(Tbljobcategory.class,j.getJobCategoryId());
//        Collection<Tbljobsubcategory> t = j1.getTbljobsubcategoryCollection();
//        jsc.setJobCategoryId(j1);
//        jsc.setJobSubCategoryName(jc.getJobSubCategoryName());
//        t.add(jsc);
//        em.merge(j1);
//        em.merge(jsc);
//    }
    @Override
    public void postUpdateJobSubCategory(int jscid, String jscn, int jcid) {
     Tbljobsubcategory c = em.find(Tbljobsubcategory.class, jscid);
     Tbljobcategory jc = em.find(Tbljobcategory.class,jcid);
     Collection<Tbljobsubcategory> t = jc.getTbljobsubcategoryCollection();
        c.setJobCategoryId(jc);
        c.setJobSubCategoryName(jscn);
        em.merge(c);
        t.add(c);
        em.merge(jc);
            
        
    }
    
    @Override
    public void deleteSubJobCategory(int jscid) {
         try{
               Tbljobsubcategory jc = em.find(Tbljobsubcategory.class, jscid);
               em.remove(jc);
        }
        catch(Exception ex){ex.getMessage();}
    }
    
    @Override
    public Collection<Tbljobsubcategory> getAlljobSubCategory() {
        return em.createNamedQuery("Tbljobsubcategory.findAll").getResultList();
    }
    

   //-------------   block Job Verification is Left  --------------

   
    


//----------------------------------------------------------------------------------- Requirement 
    @Override
    public Collection<Tblrequirement> getAllRequirement() {
        return em.createNamedQuery("Tblrequirement.findAll").getResultList();
    }
    
    public List<Object[]> getUserPostedJob(int uid) {
        return em.createNativeQuery("SELECT u.userName,r.title,r.description,r.budget,r.duration FROM tbluser u,tblrequirement r WHERE u.userId = r.userId  AND r.userId ='"+uid+"'").getResultList();
    }
    
    @Override
    public Object getTotalReq() {
    return em.createNativeQuery("select Count(requirementId) from tblrequirement").getSingleResult();    }
    
//----------------------------------------------------------------------------------- RequirementBid
    @Override
    public Collection<Tblrequirementbid> getAllBid() {
        return em.createNamedQuery("Tblrequirementbid.findAll").getResultList();
    }
    
    @Override
    public List<Object[]> getUserAppliedJob(int uid) {
          return em.createNativeQuery("SELECT u.userName,u.profileImage,r.title,r.budget,r.duration FROM tbluser u,tblrequirement r,tblrequirementbid re WHERE u.userId = r.userId  AND r.requirementId=re.requirementId AND re.userId ='"+uid+"'").getResultList();
    }
    
    @Override
    public List<Object[]> userGotJob(int uid) {
          return em.createNativeQuery("SELECT u.userName,r.title,r.budget,r.duration FROM tbluser u,tblrequirement r,tblbidassigned b WHERE u.userId = r.userId  AND r.requirementId=b.requirementId AND b.userId ='"+uid+"'").getResultList();
    }
    
//----------------------------------------------------------------------------------- Review   
   @Override
    public Collection<Tblreview> getAllReview() {
        return em.createNamedQuery("Tblreview.findAll").getResultList();
//        return em.createNamedQuery("select groupName from tblgroup g,tbluser u,tblusergroup ug where ug.userId = u.userId and ug.groupId = g.groupId and u.userName = ?").getResultList();
//        return em.createNamedQuery("SELECT t FROM Tblreview t WHERE t.reviewId = :reviewId").getResultList();
    }
    
        public List<Object[]> getUserReview(int uid) {
          return em.createNativeQuery("SELECT u.userName,r.review,r.createdDate,r.ratings,re.title FROM tbluser u,tblreview r,tblrequirement re WHERE u.userId = r.fromUserId AND r.requirementId=re.requirementId AND r.toUserId ='"+uid+"'").getResultList();
    }
    
//----------------------------------------------------------------------------------- State    
    @Override
    public void addState(String sname) {
//        Tblstate objs = new Tblstate();
//        objs.setStateName(s.getStateName());
//        em.persist(objs);
        Tblstate s = new Tblstate();
        s.setStateName(sname);
        em.persist(s);
    }

    @Override
    public Collection<Tblstate> getAllState() {
        return em.createNamedQuery("Tblstate.findAll").getResultList();
    } 
    @Override
    public void deleteState(int c) {
          Tblstate state = em.find(Tblstate.class, c);
        em.remove(state);
    } 
    @Override
    public void postUpdateState(int stid, String stn) {
        Tblstate c = em.find(Tblstate.class, stid);
        c.setStateId(stid);
        c.setStateName(stn);
        em.merge(c);    }

    @Override
    public Tblstate getUpdateState(int stid) {
        Tblstate c = em.find(Tblstate.class, stid);
        return c;    
    }
//----------------------------------------------------------------------------------- Users    
//    @Override
//    public Collection<Tblusergroup> getAllUsersData() {
//        return em.createNamedQuery("Tblusergroup.findAll").getResultList();
//    }
     @Override
    public List<Object[]> getAllUsersData() {
          return em.createNativeQuery("SELECT u.userId,userName,gender,cityId,address,email,j.jobCategoryName,u.profileImage,u.status FROM tbluser u,tblusergroup ug,tbljobcategory j WHERE u.userId = ug.userId AND ug.groupId = 2 AND u.jobCategoryId=j.jobCategoryId").getResultList();
//        return em.createNamedQuery("Tblusergroup.findAll").getResultList();
    }

    @Override
    public List<Object[]> getUserInfo(int uid) {
        System.out.println("EJB USERID:"+uid); 
        return em.createNativeQuery("SELECT u.userID,u.userName,u.gender,c.cityName,u.address,u.email,j.jobCategoryName,u.profileImage,r.review,r.createdDate,re.title,re.budget,re.duration,re.description FROM tbluser u,tblusergroup ug,tbljobcategory j,tblcity c,tblreview r ,tblrequirement re WHERE u.userId = ug.userId AND ug.groupId = 2 AND u.jobCategoryId=j.jobCategoryId AND u.cityId = c.cityId AND u.userId = r.fromUserId AND u.userId = re.userId AND u.userId='"+uid+"'").getResultList();
    }
    
    @Override
    public List<Object[]> getSpecificUsersData(int uid) {
          return em.createNativeQuery("SELECT u.userId,u.userName,u.gender,c.cityName,u.address,u.email,j.jobCategoryName,profileImage FROM tbluser u,tblusergroup ug,tbljobcategory j,tblcity c WHERE u.userId = ug.userId AND u.cityId = c.cityId AND ug.groupId = 2 AND u.jobCategoryId=j.jobCategoryId AND u.userId ='"+uid+"'").getResultList();
    }
//    @Override
//    public Tbluser getUserInfo(int uid) {
//        return em.find(Tbluser.class, uid); 
//    }
    

    
    
    //---------------------------------- userSearch
    @Override
    public Collection<Tbluser> searchUser(String uname, String city, String type) {
        String q1 = "Select u.* from Tbluser u ";
        String q2 = " u.userName like '%"+uname+"%' ";
        String q3 = " inner join Tblcity c on u.cityId = c.cityId where c.cityId in(select cityId from Tblcity where cityName like '%"+city+"%') ";
        String q4 = " u.type like '%"+type+"%' ";
        String finalQ=null;
        if(!uname.equals("") && !city.equals("") && !type.equals(""))
        {
            finalQ = q1 + q3 + " and " + q2 + " and " + q4;
        }
        else if(!uname.equals("") && city.equals("") && type.equals(""))
        {
            finalQ = q1 + " where " + q2;
        }
        else if(!uname.equals("") && !city.equals("") && type.equals(""))
        {
            finalQ =  q1 + q3 + " and " + q2;
        }
        else if(!uname.equals("") && city.equals("") && !type.equals(""))
        {
            finalQ = q1 + " where " + q2 + " and " + q4;
        }
        else if(uname.equals("") && !city.equals("") && !type.equals(""))
        {
            finalQ = q1 + q3 + " and " + q4;
        }
        else if(uname.equals("") && !city.equals("") && type.equals(""))
        {
            finalQ = q1 + q3;
        }
        else if(uname.equals("") && city.equals("") && !type.equals(""))
        {
            finalQ = q1 + " where " + q4;
        }
        else
        {
            finalQ = q1;
        }
        Collection<Tbluser> users = em.createNativeQuery(finalQ,Tbluser.class).getResultList();
        return users;

    }

    
    @Override
    public void updateStatus(int rid, int s) {
        Tblreview c = em.find(Tblreview.class, rid);
        c.setReviewId(rid);
        c.setStatus(s);
        em.merge(c);    
    }
    @Override
    public void updateReqStatus(int rid, int s) {
        Tblrequirement c = em.find(Tblrequirement.class, rid);
        c.setRequirementId(rid);
        c.setStatus(s);
        em.merge(c);    
    }
    @Override
    public void updateCStatus(int rid, int s) {
        Tblcomplaint c = em.find(Tblcomplaint.class, rid);
        c.setComplaintId(rid);
        c.setStatus(s);
        em.merge(c);    
    }
    @Override
    public void updateUStatus(int rid, int s) {
        Tbluser c = em.find(Tbluser.class, rid);
        c.setUserId(rid);
        c.setStatus(s);
        em.merge(c);    
    }

    }
