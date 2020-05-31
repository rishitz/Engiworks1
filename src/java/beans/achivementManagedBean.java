/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import client.jobClient;
import ejb.UserbeanLocal;
import entity.Tblrequirement;
import entity.Tblrequirementbid;
import entity.Tbluser;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
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
    private int uid,duration,jobId;
    private String title, description;
    private Part filename;
    jobClient jc;
    private String jobname;
    List<Object[]> lobj;
    private float budget;

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }
    

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public List<Object[]> getLobj() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = req.getSession(false);
        String uname = (String) session.getAttribute("userName");
        System.out.println("session name" + uname);
        Response response = jc.getUser(Response.class, uname);
        GenericType<Tbluser> us = new GenericType<Tbluser>() {
        };
        Tbluser u1 = response.readEntity(us);
        int ud = u1.getUserId();

        Response res = jc.homeJob(Response.class, ud + "");
        GenericType<List<Object[]>> gAdd = new GenericType<List<Object[]>>() {
        };
        lobj = (List<Object[]>) res.readEntity(gAdd);
        return lobj;
    }

    public void setLobj(List<Object[]> lobj) {
        this.lobj = lobj;
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
    @PostConstruct
    public void init() {
        lobj = new ArrayList<Object[]>();
    }

    public achivementManagedBean() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        String token = "";
        token = request.getSession().getAttribute("token").toString();
        System.out.println("Token=" + token);
        jc = new jobClient(token);
    }

    public void addAchivemnet() {
        String folder = "/home/sebatsian/NetBeansProjects/Engiworks1/Achivement";
        String f1 = null;
        try (InputStream input = filename.getInputStream()) {
            f1 = filename.getSubmittedFileName();
            Files.copy(input, new File(folder, f1).toPath());
        } catch (Exception e) {

        }
        //for userid
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = req.getSession(false);
        String uname = (String) session.getAttribute("userName");
        System.out.println("session name" + uname);
        Response response = jc.getUser(Response.class, uname);
        GenericType<Tbluser> us = new GenericType<Tbluser>() {
        };
        Tbluser u1 = response.readEntity(us);
        System.out.println("session Id" + u1.getUserId());
        //for get Info
        int ud = u1.getUserId();
        System.out.println("title" + title);
        userbean.addAchivement(ud, title, description, f1);
    }

//    public String homeJob()
//    {
//       
//    }
    
    public String sample(int xid) {
        
//        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//        request.getSession().setAttribute("Viemorejid", xid);
 HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = req.getSession(false);
        String uname = (String) session.getAttribute("userName");
        System.out.println("session name" + uname);
        Response response = jc.getUser(Response.class, uname);
        GenericType<Tbluser> us = new GenericType<Tbluser>() {
        };
        Tbluser u1 = response.readEntity(us);
        System.out.println("session Id" + u1.getUserId());

        Response res = jc.Viemore(Response.class, xid +"");
        GenericType<Tblrequirement> gAdd = new GenericType<Tblrequirement>() {};
        Tblrequirement r1 = res.readEntity(gAdd);
        uid=u1.getUserId();
        jobId=xid;
        jobname = r1.getTitle();
        description = r1.getDescription();
        budget=r1.getBudget();
        duration=r1.getDuration();
        return "/UserSite/ViewMore.xhtml";
    }
    public List<Object[]> bidCheck()
    {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = req.getSession(false);
        String uname = (String) session.getAttribute("userName");
        System.out.println("session name" + uname);
        Response response = jc.getUser(Response.class, uname);
        GenericType<Tbluser> us = new GenericType<Tbluser>() {};
        Tbluser u1 = response.readEntity(us);
        int userid=u1.getUserId();
        Response resp = jc.Viemore(Response.class,userid+"");
        List<Object[]> alist=new ArrayList<Object[]>();
        GenericType<Tblrequirementbid> rb = new GenericType<Tblrequirementbid>() {};
        alist = (List<Object[]>) resp.readEntity(rb);
        return alist;
        
        
        
    }

   

}
