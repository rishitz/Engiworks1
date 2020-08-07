/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import ejb.UserbeanLocal;
import entity.Tblbidassigned;
import entity.Tblcomment;
import entity.Tblcomplaint;
import entity.Tbllikes;
import entity.Tblrequirement;
import entity.Tblrequirementbid;
import entity.Tblreview;
import entity.Tbluser;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
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
@Path("generic")
//@RequestScoped
@DeclareRoles({"Admin","User"})
public class userResource {
    @EJB UserbeanLocal ul;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of userResource
     */
    public userResource() {
    }

    /**
     * Retrieves representation of an instance of Rest.userResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of userResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
   @RolesAllowed("User")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("getAllJob")
    public Collection<Tblrequirement> alljob()
    {
        return ul.alljob();
    }
    
    @RolesAllowed("User")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("getUser/{userName}")
     public Tbluser getUser(@PathParam("userName") String userName)
     {
         return ul.user(userName);
     }
     
    @RolesAllowed("User")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("getuser/{uid}")
    public Tbluser getUserdetails(@PathParam("uid") int uid)
    {
        return ul.userDetail(uid);
    }
    
    @RolesAllowed("User")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("updateUser")
    public void updateUser(Tbluser u)
    {
        ul.updateUser(u.getUserId(), u.getUserName(), u.getCityId().getCityId(), u.getAddress(), u.getEmail(),u.getJobCategoryId().getJobCategoryId(),u.getProfileImage());
    }
    
    @RolesAllowed("User")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("getUserJob/{uid}")
    public List<Object[]> getuserJob(@PathParam("uid") int uid)
    {
        System.out.println("In Rest = "+ul.userPostJob(uid));
        return ul.userPostJob(uid);
    }
    
    @RolesAllowed("User")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("addJob")
    public void addJob(Tblrequirement r)
    {
        ul.addJob(r.getUserId().getUserId(),r.getTitle(),r.getDescription(),r.getBudget(),r.getDuration(),r.getPdf());
      
    }
    
    @RolesAllowed("User")
    @POST
    @Path("addAchivement/{uid}/{attachment}/{title}/{description}")
    public void addAchivement(@PathParam("uid") int uid,@PathParam("attachment") String attachment,@PathParam("title") String title,@PathParam("description") String description)
    {
        ul.addAchivement(uid, title, description, attachment);
    }
    
    @RolesAllowed("User")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("gethomeJob/{uid}")
    public List<Object[]> homeJob(@PathParam("uid") int uid)
    {
        return ul.HomeJob(uid);
    }
    
    @RolesAllowed("User")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("getJob/{rid}")
     public Tblrequirement Viemore(@PathParam("rid") int rid)
     {
         System.out.println("in Rest"+rid);
         return ul.ViewMore(rid);
     }
     
    @RolesAllowed("User")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("getbidcheck/{uid}/{rid}")
    public List<Object[]> bidcheck(@PathParam("uid") int uid,@PathParam("rid") int rid)
    {
        return ul.bidcheck(uid,rid);
    }
    
    @RolesAllowed("User")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("addBid")
    public void addBid(Tblrequirementbid rb)
    {
        ul.addBid(rb.getDescription(),rb.getDuration(), rb.getBudget(), rb.getEndingDate(), rb.getUserId().getUserId(), rb.getRequirementId().getRequirementId());
    }
    
    @RolesAllowed("User")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getBidJob/{rid}")
    public List<Object[]> getBidJob(@PathParam("rid") int rid)
    {
        return ul.bidInfo(rid);
    }
    
    @RolesAllowed("User")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("bidAssign")
    public void bidassign(Tblbidassigned ba)
    {
        ul.bidassign(ba.getUserId().getUserId(), ba.getRequirementBidId().getRequirementBidId(),ba.getRequirementId().getRequirementId());
    }
    
    @RolesAllowed("User")
    @DELETE
    @Path("deleteBid/{rbid}")
    public void deleteBid(@PathParam("rbid") int rbid)
    {
        ul.removeBid(rbid);
    }
    
    @RolesAllowed("User")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("manageTask/{rid}")
    public List<Object[]> manageTask(@PathParam("rid") int rid)
    {
        return ul.manageTask(rid);
    }
    
    @RolesAllowed("User")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("manageBidders/{uid}/{rid}")
    public List<Object[]> manageBidders(@PathParam("uid") int uid,@PathParam("rid") int rid)
    {
        return ul.ManageBidders(uid, rid);
    }
    
    @RolesAllowed("User")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("commnet")
    public void Commnet(Tblcomment c)
    {
        ul.comment(c.getToUserId().getUserId(), c.getAchievementId().getAchievementId(),c.getDescription(), c.getFromUserId().getUserId());
    }
    
    @RolesAllowed("User")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("viewBidder/{rid}")
    public List<Object[]> viewBidder(@PathParam("rid") int rid)
    {
        return ul.viewBidder(rid);
    }
    
    @RolesAllowed("User")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("complaint")
    public void Complaint(Tblcomplaint c)
    {
        ul.complaint(c.getToUserId().getUserId(),c.getComplaint(), c.getUserId().getUserId());
    }
    
    @RolesAllowed("User")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("review")
    public void Review(Tblreview c)
    {
        
        ul.review(c.getToUserId().getUserId(),c.getReview(), c.getFromUserId().getUserId(),c.getRatings(),c.getRequirementId().getRequirementId());
    }
    
    @RolesAllowed("User")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("notification/{uid}")
    public List<Object[]> notification(@PathParam("uid") int uid)
    {
        return ul.notification(uid);
    }
    
    @RolesAllowed("User")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("getreview/{uid}")
    public Object getReviews(@PathParam("uid") int uid)
    {
        return ul.getUserReview(uid);
    }
    
    @RolesAllowed("User")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("checkreview/{uid}/{rid}")
    public List<Object[]> checkReviews(@PathParam("uid") int uid,@PathParam("rid") int rid)
    {
        return ul.checkReview(uid, rid);
    }
    
    @RolesAllowed("User")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("like")
    public void Like(Tbllikes l)
    {
        ul.like(l.getToUserId().getUserId(), l.getFromUserId().getUserId(),l.getAchievementId().getAchievementId());
    }
    
    @RolesAllowed("User")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("checklike/{uid}/{aid}")
    public List<Object[]> checkLike(@PathParam("uid") int uid,@PathParam("aid") int aid)
    {
        return ul.checkLike(uid, aid);
    }
    
    @RolesAllowed("User")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("assignJob/{uid}")
    public List<Object[]> assignJob(@PathParam("uid") int uid)
    {
        return ul.assignJob(uid);
    }
    
    @RolesAllowed("User")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("showReviews/{uid}")
    public List<Object[]> showReviews(@PathParam("uid") int uid)
    {
        return ul.viewAllreviews(uid);
    }
    
    @RolesAllowed("User")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("getLikes/{aid}")
    public Object getLikes(@PathParam("aid") int aid)
    {
        return ul.getLikes(aid);
    }
    
    @RolesAllowed("User")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("checkBid/{uid}/{jid}")
    public List<Object[]> checkBid(@PathParam("uid") int uid,@PathParam("jid") int jid)
    {
        return ul.checkBid(uid, jid);
    }
    
    @RolesAllowed("User")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("showengname/{uid}")
    public List<Object[]> showEngName(@PathParam("uid") int uid)
    {
        return ul.showEngname(uid);
    }
    
    @RolesAllowed({"Admin","User"})
    @GET
    @Path("getAllusrs")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Object[]> getAllUserData(){
        //System.out.println(adminBean.getAllJob());
        return ul.getAllUsersData();
    } 
    @RolesAllowed("User")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("showbiddetails/{uid}")
    public List<Object[]> showbiddetails(@PathParam("uid") int uid)
    {
        return ul.showBidDetails(uid);
    }
    
    
}
