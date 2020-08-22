/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import ejb.AdminBeanLocal;
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
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author sebatsian
 */
@Path("adminmastergeneric")
@DeclareRoles({"Admin","User"})
//@RequestScoped
public class AdminGenericResource {
   @EJB AdminBeanLocal adminBean;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AdminGenericResource
     */
    public AdminGenericResource() {
    }

    /**
     * Retrieves representation of an instance of Rest.AdminGenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of AdminGenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    

//  ----------------------------------------------------------------------------JOB CATEGORY  
    @RolesAllowed({"Admin","User"})
    @POST
    @Path("addJob/{jobname}")
    public void addJob(@PathParam("jobname") String jobName)
    {
        adminBean.addJobCategory(jobName);
    }
    
    @RolesAllowed({"Admin","User"})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getJobd/{jid}")
    public Tbljobcategory getJob(@PathParam("jid") int jid)
    {
        return adminBean.getUpdateJobCategory(jid);
    }
    
    @RolesAllowed({"Admin","User"})
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("updateJob")
    public void updateJob(Tbljobcategory j)
    {
        adminBean.postUpdateCategory(j.getJobCategoryId(),j.getJobCategoryName());
    }
    
    @RolesAllowed({"Admin","User"})
    @DELETE
    @Path("delete/{jid}")
    public void deleteJob(@PathParam("jid") int jid)
    {
        System.out.println("JobId"+jid);
        adminBean.deleteJobCategory(jid);
    }
    
    @RolesAllowed({"Admin","User"})
    @GET
    @Path("getAlljobCategory")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Tbljobcategory> getAlljobCategory(){
        //System.out.println(adminBean.getAllJob());
        return adminBean.getAlljobCategory();
    }
    
    //  ------------------------------------------------------------------------JOB SUB CATEGORY 
//    @RolesAllowed({"Admin","User"})
//    @POST
//    @Path("addJobSub/{jobsubname}/{jobcid}")
//    public void addJobSub(@PathParam("jobsubname") String jobName,@PathParam("jobsubid") int jobcid)
//    {
//        adminBean.addJobSubCategory(jobName,jobcid);
//    }
    @RolesAllowed({"Admin","User"})
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
//    @Path("addJobSub")
    public void addJobSub(Tbljobsubcategory j)
    {
        System.out.println("helllllooooo");
        adminBean.addJobSubCategory(j.getJobSubCategoryName(),j.getJobCategoryId().getJobCategoryId());
    }
    
    @RolesAllowed({"Admin","User"})
    @DELETE
    @Path("deleteJobSub/{jobcid}")
    public void deleteJobSub(@PathParam("jobcid") int jobcid)
    {
        System.out.println("JobId"+jobcid);
        adminBean.deleteSubJobCategory(jobcid);
    }
    
    @RolesAllowed({"Admin","User"})
    @GET
    @Path("getAlljobSubCategory")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Tbljobsubcategory> getAlljobSubCategory(){
        return adminBean.getAlljobSubCategory();
    }
    
    @RolesAllowed({"Admin","User"})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getJobSub/{jid}")
    public Tbljobsubcategory getJobSub(@PathParam("jid") int jid)
    {
        return adminBean.getUpdateSubCategory(jid);
    }
    
    @RolesAllowed({"Admin","User"})
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("updateJobSub")
    public void updateJobSub(Tbljobsubcategory j)
    {
//        adminBean.postUpdateCategory(j.getJobCategoryId(),j.getJobCategoryName());
        adminBean.postUpdateJobSubCategory(j.getJobSubCategoryId(), j.getJobSubCategoryName(), j.getJobCategoryId().getJobCategoryId());
    }

    // -------------------------------------------------------------------------Requirement
    @RolesAllowed({"Admin","User"})
    @GET
    @Path("getAllrequirement")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Tblrequirement> getAllrequirement(){
        return adminBean.getAllRequirement();
    }
    @RolesAllowed({"Admin","User"})
    @POST
    @Path("updateReqStatus/{r}{s}")
//     public void updateStatus(Tblreview r)
    public void updateReqStatus(@PathParam("r")int r ,@PathParam("s")int s)
    {
        adminBean.updateReqStatus(r, s);
//        adminBean.updateStatus(r.getReviewId(), r.getStatus());
    }
    // -------------------------------------------------------------------------Commnet
    @RolesAllowed({"Admin","User"})
    @GET
    @Path("getAllcomment")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Tblcomment> getAllcomment(){
        //System.out.println(adminBean.getAllJob());
        return adminBean.getAllComment();
    }
    // -------------------------------------------------------------------------Complaint
    @RolesAllowed({"Admin","User"})
    @GET
    @Path("getAllcomplaint")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Tblcomplaint> getAllcomplaint(){
        //System.out.println(adminBean.getAllJob());
        return adminBean.getAllComplaint();
    }
    
    @RolesAllowed({"Admin","User"})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getUserComplaint/{uid}")
    public List<Object[]> getUserComplaint(@PathParam("uid") int uid)
    {
        System.out.print("REST  Specific USER ID:"+uid);
        return adminBean.getUserComplaint(uid);
    }
   
    @RolesAllowed({"Admin","User"})
    @POST
    @Path("updateCStatus/{r}{s}")
//     public void updateStatus(Tblreview r)
    public void updateCStatus(@PathParam("r")int r ,@PathParam("s")int s)
    {
        adminBean.updateCStatus(r, s);
//        adminBean.updateStatus(r.getReviewId(), r.getStatus());
    }
    // -------------------------------------------------------------------------RequirementBid
    @RolesAllowed({"Admin","User"})
    @GET
    @Path("getAllrequirementbid")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Tblrequirementbid> getAllrequirementbid(){
        //System.out.println(adminBean.getAllJob());
        return adminBean.getAllBid();
    }    
    
    @RolesAllowed({"Admin","User"})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getUserPostedJob/{uid}")
    public List<Object[]> getUserPostedJob (@PathParam("uid") int uid)
    {
        System.out.print("REST  Specific USER ID:"+uid);
        return adminBean.getUserPostedJob(uid);
    }    
    
    @RolesAllowed({"Admin","User"})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getUserAppliedJob/{uid}")
    public List<Object[]> getUserAppliedjob(@PathParam("uid") int uid)
    {
        System.out.print("REST  Specific USER ID:"+uid);
        return adminBean.getUserAppliedJob(uid);
    }
    
    @RolesAllowed({"Admin","User"})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("UserGotJob/{uid}")
    public List<Object[]> UserGotjob(@PathParam("uid") int uid)
    {
        System.out.print("REST  Specific USER ID:"+uid);
        return adminBean.userGotJob(uid);
    }
    // -------------------------------------------------------------------------Reviews
    @RolesAllowed({"Admin","User"})
    @GET
    @Path("getAllreview")
    @Consumes(MediaType.APPLICATION_JSON)
    public Collection<Tblreview> getAllreview(){
        //System.out.println(adminBean.getAllJob());
        return adminBean.getAllReview();
    }
    
    @RolesAllowed({"Admin","User"})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getUserReview/{uid}")
    public List<Object[]> getUserReview(@PathParam("uid") int uid)
    {
        System.out.print("REST  Specific USER ID:"+uid);
        return adminBean.getUserReview(uid);
    }
    
    @RolesAllowed({"Admin","User"})
    @POST
    @Path("updateStatus/{r}{s}")
    public void updateStatus(@PathParam("r")int r ,@PathParam("s")int s)
    {
        adminBean.updateStatus(r, s);
    }

    // -------------------------------------------------------------------------Users
    @RolesAllowed({"Admin","User"})
    @GET
    @Path("getAllusers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Object[]> getAllUserData(){
        //System.out.println(adminBean.getAllJob());
        return adminBean.getAllUsersData();
    } 
    
    @RolesAllowed({"Admin","User"})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getUserInfo/{uid}")
    public List<Object[]> getUserInfo(@PathParam("uid") int uid)
    {
        System.out.print("REST USER ID:"+uid);
        return adminBean.getUserInfo(uid);
    }
    
    @RolesAllowed({"Admin","User"})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getSpecificUserInfo/{uid}")
    public List<Object[]> getSpecificUserInfo(@PathParam("uid") int uid)
    {
        System.out.print("REST  Specific USER ID:"+uid);
        return adminBean.getSpecificUsersData(uid);
    }
    @RolesAllowed({"Admin","User"})
    @POST
    @Path("updateUStatus/{r}{s}")
    public void updateUStatus(@PathParam("r")int r ,@PathParam("s")int s)
    {
        System.out.println("user ID:"+r+"status"+s);
        adminBean.updateUStatus(r, s);
    }
    // -------------------------------------------------------------------------state
    @RolesAllowed({"Admin","User"})
    @POST
    @Path("addState/{stateName}")
    public void addState(@PathParam("stateName") String stateName)
    {
        adminBean.addState(stateName);
    }
        
    @RolesAllowed({"Admin","User"})
    @DELETE
    @Path("deleteState/{sid}")
    public void deleteState(@PathParam("sid") int sid)
    {
        System.out.println("StateId"+sid);
        adminBean.deleteState(sid);
    } 
    
    @RolesAllowed({"Admin","User"})
    @GET
    @Path("getAllState")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Tblstate> getAllState(){
        //System.out.println(adminBean.getAllJob());
        return adminBean.getAllState();
    }
    
    @RolesAllowed({"Admin","User"})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getState/{sid}")
    public Tblstate getState(@PathParam("sid") int sid)
    {
        return adminBean.getUpdateState(sid);
    }
    
    @RolesAllowed({"Admin","User"})
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("updateState")
    public void updateState(Tblstate j)
    {
        adminBean.postUpdateState(j.getStateId(),j.getStateName());
    }
    // -------------------------------------------------------------------------City
    @RolesAllowed({"Admin","User"})
    @GET
    @Path("getAllcity")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Tblcity> getAllCityData(){
        //System.out.println(adminBean.getAllJob());
        return adminBean.getAllCity();
    }
    
    @RolesAllowed({"Admin","User"})
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("addCity")
    public void addCity(Tblcity j)
    {
        System.out.println("helllllooooo");
        adminBean.addCity(j.getCityName(),j.getStateId().getStateId());
    }
    
    @RolesAllowed({"Admin","User"})
    @DELETE
    @Path("deleteCity/{cid}")
    public void deleteCity(@PathParam("cid") int cid)
    {
        System.out.println("CityId"+cid);
        adminBean.deleteCity(cid);
    }
        @RolesAllowed({"Admin","User"})
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getCity/{cid}")
    public Tblcity getCity(@PathParam("cid") int cid)
    {
        return adminBean.getUpdateCity(cid);
    }
    
    @RolesAllowed({"Admin","User"})
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("updateCity")
    public void updateCity(Tblcity j)
    {
//        adminBean.postUpdateCategory(j.getJobCategoryId(),j.getJobCategoryName());
        adminBean.postUpdateCity(j.getCityId(), j.getCityName(), j.getStateId().getStateId());
    }
    
        @RolesAllowed({"Admin","User"})
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("getTotalReq")
    public Object getTotalReq()
    {
        return adminBean.getTotalReq();
    }
    
    @RolesAllowed({"Admin","User"})
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("getTotalReqBid")
    public Object getTotalReqBid()
    {
        return adminBean.getTotalBids();
    }
    @RolesAllowed({"Admin","User"})
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("getTotalUsers")
    public Object getTotalUsers()
    {
        return adminBean.getTotalUsers();
    }
    @RolesAllowed({"Admin","User"})
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("getTotalTypes")
    public Object getTotalTypes()
    {
        return adminBean.getTotalTypes();
    }
    
    @RolesAllowed({"Admin","User"})
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("adminId/{uid}")
    public Tbluser adminId(@PathParam("uid") int uid)
    {
          return adminBean.adminDetail(uid);
    }
    
    @RolesAllowed({"Admin","User"})
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("updateAdmin")
    public void updateAdmin(Tbluser u)
    {
        adminBean.updateAdmin(u.getUserId(), u.getUserName(),u.getCityId().getCityId(), u.getAddress(),u.getEmail(),u.getJobCategoryId().getJobCategoryId(),u.getProfileImage());
    }
}
