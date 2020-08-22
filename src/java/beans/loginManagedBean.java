/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

//import client.userRestClient;
import entity.Tbluser;
import java.io.Serializable;
import java.util.Set;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import static javax.faces.application.FacesMessage.SEVERITY_ERROR;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.security.enterprise.AuthenticationStatus;
import static javax.security.enterprise.AuthenticationStatus.SEND_CONTINUE;
import javax.security.enterprise.SecurityContext;
import static javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters.withParams;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author sebatsian
 */
@Named(value = "loginManagedBean")
@SessionScoped
public class loginManagedBean implements Serializable{

    /**
     * Creates a new instance of loginManagedBean
     */
     @Inject private SecurityContext sc;
   private String password,userName,message;
   
    private AuthenticationStatus status;
   private Set<String> roles;
   //jobManagedBean jm=new jobManagedBean();
   
   
    //userRestClient uc;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SecurityContext getSc() {
        return sc;
    }

    public void setSc(SecurityContext sc) {
        this.sc = sc;
    }

   

    public AuthenticationStatus getStatus() {
        return status;
    }

    public void setStatus(AuthenticationStatus status) {
        this.status = status;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
   
   

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public loginManagedBean() {
       
    }
    
     public String login()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        try{       
          HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();     
        request.getSession().setAttribute("logged-group", ""); 
        
        Credential credential = new UsernamePasswordCredential(userName, new Password(password));
        AuthenticationStatus status= sc.authenticate(request,response, withParams().credential(credential));
            
        System.out.println("status"+status);                  
       if (status.equals(SEND_CONTINUE)) {
            // Authentication mechanism has send a redirect, should not
            // send anything to response from JSF now. The control will now go into HttpAuthenticationMechanism
            context.responseComplete();
       } 
       
 //      else if (status.equals(SEND_FAILURE)) {
//            message = "Login Failed";
//            System.out.println(message);
//            addError(context, "Authentication failed");
//        }
         //  if(securityContext.isCallerInRole("Admin"))
         System.out.println("In bean");
         if(roles.contains("Admin"))
           {
               System.out.println("In admin");
               request.getSession().setAttribute("adminName",getUserName());
              return "/adminSitePages/Dashboard.xhtml?faces-redirect=true";
           }
        //   else if(securityContext.isCallerInRole("Supervisor"))
       else if(roles.contains("User"))
           {
               System.out.println("In user");
               //   System.out.println(getUserName());
               request.getSession().setAttribute("userName", getUserName());
                //storesession();
                   //System.out.println("beans.loginManagedBean.login()"+getUserName());
                   return "/UserSite/Home.xhtml?faces-redirect=true";
           }
        
       //} return "/admins/AdminPage.jsf";
       
       
        }
        catch (Exception e)
        {
             message = " Either user or password is wrong !!!";
             //System.out.println("error"+message);
              //e.printStackTrace();
        }
//        
      return "/UserSite/Login.xhtml?faces-redirect=true";
    }
     private static void addError(FacesContext context, String message) {
        context = FacesContext.getCurrentInstance();
        context
                .addMessage(
                        null,
                        new FacesMessage(SEVERITY_ERROR, message, null));
    }
     
     public String logout()
    {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse res = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        HttpSession session = req.getSession(false);
        try {
            
                session.invalidate();
                req.logout();
                return "/UserSite/Login.xhtml?faces-redirect=true";
                //res.sendRedirect(req.getContextPath()+"/login.xhtml");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
//    public void storesession()
//    {
//        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//        HttpSession session=req.getSession(false);
//        String uname=(String) session.getAttribute("userName");
//        Response response=uc.setSession(Response.class, uname);
//        GenericType<Tbluser> u=new GenericType<Tbluser>(){};
//        Tbluser u1=response.readEntity(u);
//        session.setAttribute("userId", u1.getUserId());
//        System.out.println("session Id"+u1.getUserId());
//        
//        
//    }
    
}
