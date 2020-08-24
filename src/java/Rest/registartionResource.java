/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import ejb.UserbeanLocal;
import entity.Tbluser;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author sebatsian
 */
@Path("gen")
//@RequestScoped
@DeclareRoles({"Admin","User"})
public class registartionResource {

    UserbeanLocal userbean = lookupUserbeanLocal();
    //@EJB UserbeanLocal ul;
    

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of registartionResource
     */
    public registartionResource() {
    }

    /**
     * Retrieves representation of an instance of Rest.registartionResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of registartionResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("addUser")
    public void addUser(Tbluser u)
    {
        System.out.println("name"+u.getUserName());
        userbean.addUser(u.getUserName(),u.getGender(),u.getCityId().getCityId(),u.getAddress(),u.getEmail(), u.getPassword(),u.getJobCategoryId().getJobCategoryId(),u.getStatus(),u.getProfileImage());
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("checkDetails/{uname}/{email}")
    public Object checkDetails(@PathParam("uname") String uname,@PathParam("email") String email)
    {
        System.out.println("Uname"+uname+"email:"+email);
        return userbean.checkDetails(uname,email);
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("changePassword")
    public void changePassword(Tbluser u)
    {
        userbean.changePassword(u.getUserId(),u.getPassword());
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("guestJob")
    public List<Object[]> guestJob()
    {
       return userbean.Guestjob();
    }
    
    
    private UserbeanLocal lookupUserbeanLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (UserbeanLocal) c.lookup("java:global/Engiworks1/Userbean!ejb.UserbeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
