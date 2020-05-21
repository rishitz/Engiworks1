/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import ejb.UserbeanLocal;
import entity.Tblrequirement;
import entity.Tbluser;
import java.util.Collection;
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
        ul.updateUser(u.getUserId(), u.getUserName(), u.getCityId().getCityId(), u.getAddress(), u.getEmail(),u.getJobCategoryId().getJobCategoryId());
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
}
