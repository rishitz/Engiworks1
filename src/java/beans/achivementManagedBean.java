/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import client.jobClient;
import ejb.UserbeanLocal;
import entity.Tbluser;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author sebatsian
 */
@Named(value = "achivementManagedBean")
@RequestScoped
public class achivementManagedBean {

    @EJB
    private UserbeanLocal userbean;
    private int uid;
   private String title,description;
   private Part filename;
    jobClient jc;

    public UserbeanLocal getUserbean() {
        return userbean;
    }

    public void setUserbean(UserbeanLocal userbean) {
        this.userbean = userbean;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Part getFilename() {
        return filename;
    }

    public void setFilename(Part filename) {
        this.filename = filename;
    }

    public jobClient getJc() {
        return jc;
    }

    public void setJc(jobClient jc) {
        this.jc = jc;
    }

    /**
     * Creates a new instance of achivementManagedBean
     */
    public achivementManagedBean() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
       String token="";
       token = request.getSession().getAttribute("token").toString();
       System.out.println("Token="+token);      
       jc=new jobClient(token);
    }
    
    public void addAchivemnet()
    {
         String folder="/home/sebatsian/NetBeansProjects/Engiworks1/Achivement";
       String f1=null;
        try(InputStream input=filename.getInputStream()){
            f1=filename.getSubmittedFileName();
            Files.copy(input,new File(folder,f1).toPath());           
        }catch(Exception e)
        {
            
        }
        //for userid
         HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session=req.getSession(false);
        String uname=(String) session.getAttribute("userName");
        System.out.println("session name"+uname);
        Response response=  jc.getUser(Response.class,uname);
        GenericType<Tbluser> us=new GenericType<Tbluser>(){};
        Tbluser u1=response.readEntity(us);
        System.out.println("session Id"+u1.getUserId());
        //for get Info
        int ud=u1.getUserId();
        System.out.println("title"+title);
        userbean.addAchivement(ud, title, description, f1);
    }
    
}
