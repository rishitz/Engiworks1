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
import javax.ejb.Local;

/**
 *
 * @author sebatsian
 */
@Local
public interface AdminBeanLocal {
      //--------------------------------------------------------------------------Achievement
        Collection<Tblachievement> getAllAchievement();       
     //-------------------------------------------------------------------------City   
        void addCity(String cname,int sid);
        Collection<Tblcity> getAllCity();
        void deleteCity(int c);
        Tblcity getUpdateCity(int cid);
        void postUpdateCity(int cid,String cn,int stid);
    //--------------------------------------------------------------------------Comment   
        Collection<Tblcomment> getAllComment();
        
    //--------------------------------------------------------------------------Complaint   
        Collection<Tblcomplaint>getAllComplaint();
        List<Object[]> getUserComplaint(int uid);
        public void updateCStatus(int rid,int s);
        
    //--------------------------------------------------------------------------JobCategory
        public void addJobCategory(String jcn);
        Collection<Tbljobcategory> getAlljobCategory();
        public void postUpdateCategory(int jcid,String jcn);
        public Tbljobcategory getUpdateJobCategory(int jcid);
        public void deleteJobCategory(int jcid);
        
    //--------------------------------------------------------------------------JobSubCategory
        public void addJobSubCategory(String jscn,int jcid);
        Tbljobsubcategory getUpdateSubCategory(int cid);
        void postUpdateJobSubCategory(int jscid,String jscn,int jcid); 
        void deleteSubJobCategory(int jscid);
        Collection<Tbljobsubcategory> getAlljobSubCategory();

    
     
    //--------------------------------------------------------------------------Requirement
        Collection<Tblrequirement> getAllRequirement();
        List<Object[]> getUserPostedJob(int uid);
        public void updateReqStatus(int rid,int s);
        
        
    //--------------------------------------------------------------------------RequirementBid
            Collection<Tblrequirementbid> getAllBid();
            List<Object[]> getUserAppliedJob(int uid);
            List<Object[]> userGotJob(int uid);

    //--------------------------------------------------------------------------Review
            Collection<Tblreview> getAllReview();
            List<Object[]> getUserReview(int uid);
            public void updateStatus(int rid,int s);

    //--------------------------------------------------------------------------users
//            Collection<Tblusergroup> getAllUsersData();            
//            public Tbluser getUserInfo(int uid);
             List<Object[]> getAllUsersData(); 
             List<Object[]> getSpecificUsersData(int uid);
//            public Tbluser getUserInfo(int uid);
            List<Object[]> getUserInfo(int uid);
             public void updateUStatus(int rid,int s);
    //--------------------------------------------------------------------------State
        void addState(String sname);
        Collection<Tblstate> getAllState();
        void deleteState(int c);
        public void postUpdateState(int stid,String stn);
        public Tblstate getUpdateState(int stid);
        
        Object getTotalReq();
        Object getTotalUsers();
        Object getTotalBids();
        Object getTotalTypes();
        
        public Tbluser adminDetail(int aid);
    public void updateAdmin(int aid,String userName, int cityId, String address, String email, int jobCategoryId,String picture);
    //UserSearch
        Collection<Tbluser> searchUser(String uname, String city, String type);
}
