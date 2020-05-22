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
}
