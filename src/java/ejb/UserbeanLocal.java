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
    void addUser(String userName,String gender,int cityId,String address, String email,String password,int jobCategoryId,int status);
    public Tbluser user(String uname);
    public Tbluser userDetail(int uid);
    public void updateUser(int uid,String userName, int cityId, String address, String email, int jobCategoryId);
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
     
}
