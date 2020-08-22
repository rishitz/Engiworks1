/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import client.jobClient;
import ejb.UserbeanLocal;
import entity.Tblrequirement;
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
@Named(value = "postJobManagedBean")
@RequestScoped
public class postJobManagedBean {

    @EJB
    private UserbeanLocal userbean;
    
    private int uid,duration,jobcid;
    private String title,description,pdf,message;
     private float budget;
   private Part filename;
   jobClient jc;

    public int getJobcid() {
        return jobcid;
    }

    public void setJobcid(int jobcid) {
        this.jobcid = jobcid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public Part getFilename() {
        return filename;
    }

    public void setFilename(Part filename) {
        this.filename = filename;
    }
    

    /**
     * Creates a new instance of postJobManagedBean
     */
    public postJobManagedBean() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
       String token="";

       token = request.getSession().getAttribute("token").toString();
       System.out.println("Token="+token);
       
       jc=new jobClient(token);
    }
    
    public void addJob()
    {
        String folder="/home/sebatsian/NetBeansProjects/Engiworks1/PDF";
       String f1=null;
        try(InputStream input=filename.getInputStream()){
            f1=filename.getSubmittedFileName();
            Files.copy(input,new File(folder,f1).toPath());           
        }catch(Exception e)
        {
            
        }
       // userbean.addJob(title, description, status, budget, duration,f1);
        Tblrequirement r=new Tblrequirement();
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
        System.out.println("rqi"+ud);
        r.setUserId(new Tbluser(ud));
        r.setTitle(title);
        r.setDescription(description);
        r.setBudget(budget);
        r.setDuration(duration);
        
        r.setPdf(f1);
        jc.addJob(r);
        title=" ";
        description=" ";
        message="Successfully add this job";
        
        
        
    }
    public void homejob()
    {
        System.out.println("jobid"+jobcid);

    }
    
    
}
