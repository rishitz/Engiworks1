/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Tblcity;
import entity.Tbljobcategory;
import entity.Tblrequirement;
import entity.Tbluser;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sebatsian
 */
@Local
public interface UserbeanLocal {
    Tbluser storeSession(String userName);
    Collection<Tblrequirement> alljob();
     Collection<Tbljobcategory> getalljob();
     Collection<Tblcity> getallcity();
    void addUser(String userName,String gender,int cityId,String address, String email,String password,int jobCategoryId,int status,String picture);
    public Tbluser user(String uname);
    public Tbluser userDetail(int uid);
    public void updateUser(int uid,String userName, int cityId, String address, String email, int jobCategoryId,String picture);
    public List<Object[]> userPostJob(int uid);
     public void addJob(int uid,String title, String description, float budget, int duration, String pdf);
     void addAchivement(int uid,String title,String description,String attachment);
     List<Object[]> HomeJob(int uid);
     Tblrequirement ViewMore(int rid);
     List<Object[]> bidcheck(int uid,int rid);
     void addBid(String description,int duration,float budget,Date edate,int uid,int rid);
     List<Object[]> bidInfo(int rid);
     void bidassign(int uid,int rbid,int rid);
     void removeBid(int rbid);
     List<Object[]> manageTask(int rid);
     List<Object[]> ManageBidders(int uid,int rid);
     void comment(int uid,int aid,String description,int fromuid);
     List<Object[]> viewBidder(int rid);
     void complaint(int uid,String complaint,int fromuid);
     void review(int uid,String review,int fromuid,int rat,int rid);
     List<Object[]> notification(int uid);
      Object getUserReview(int uid);
     List<Object[]> checkReview(int uid,int rid);
     void like(int touid,int fuid,int aid);
     List<Object[]> checkLike(int uid,int aid);
      List<Object[]> assignJob(int uid);
     List<Object[]> viewAllreviews(int uid);
     List<Object[]> checkDetails(String uname,String email);
     void changePassword(int uid,String password);
     Object getLikes(int aid);
     
     List<Object[]> checkBid(int uid,int jid);
     List<Object[]> showEngname(int uid);
     
     List<Object[]> getAllUsersData();
     List<Object[]> showBidDetails(int uid);
     List<Object[]> AppliedViewMore(int uid,int rid);
     
     void addMessage(int fromuid,int touid,String message,int jid);
     
     List<Object[]> message(int jid);
     
     //SELECT *from tbluser u,tblrequirement r,tblbidassigned b WHERE u.userid=b.userId AND r.requirementId=b.requirementId AND b.requirementId=3 AND b.userId=21
     
     

     
}
