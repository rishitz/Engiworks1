/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import client.jobClient;
import ejb.UserbeanLocal;
import entity.Tblcity;
import entity.Tbljobcategory;
//import client.userdetailClient;
import entity.Tblrequirement;
import entity.Tbluser;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
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
@Named(value = "jobManagedBean")
@RequestScoped
public class jobManagedBean {

    @EJB
    private UserbeanLocal userbean;
    
     Response res;
    String username;
    String password;
    jobClient jc;
    private String profile;
    Collection<Tblrequirement> job;
    GenericType<Collection<Tblrequirement>> gjob;
    //userdetailClient uc=new userdetailClient();
    private int uid,cid,jid;
    private Part filename;

    public Part getFilename() {
        return filename;
    }

    public void setFilename(Part filename) {
        this.filename = filename;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getJid() {
        return jid;
    }

    public void setJid(int jid) {
        this.jid = jid;
    }
    private String address,email;
     private Collection<Tbljobcategory> jlist;
    private Collection<Tblcity> clist;

    public GenericType<Collection<Tblrequirement>> getGjob() {
        return gjob;
    }

    public void setGjob(GenericType<Collection<Tblrequirement>> gjob) {
        this.gjob = gjob;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Tbljobcategory> getJlist() {
        return jlist;
    }

    public void setJlist(Collection<Tbljobcategory> jlist) {
        this.jlist = jlist;
    }

    public Collection<Tblcity> getClist() {
        return clist;
    }

    public void setClist(Collection<Tblcity> clist) {
        this.clist = clist;
    }
    
    

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public jobClient getJc() {
        return jc;
    }

    public void setJc(jobClient jc) {
        this.jc = jc;
    }

    public Collection<Tblrequirement> getJob() {
        res=jc.alljob(Response.class);
        job=res.readEntity(gjob);
        return job;
    }

    public void setJob(Collection<Tblrequirement> job) {
        this.job = job;
    }
    @PostConstruct
    public void init()
    {
        clist=userbean.getallcity();
        jlist=userbean.getalljob();
    }

    /**
     * Creates a new instance of jobManagedBean
     */
    public jobManagedBean() {
         //System.out.println("Hello BookCDI Bean ");
          HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
       String token="";

       token = request.getSession().getAttribute("token").toString();
       System.out.println("Token="+token);
       
       jc=new jobClient(token);
       job=new ArrayList<Tblrequirement>();
       gjob=new GenericType<Collection<Tblrequirement>>(){};
       
    }
    
    
    public void getuserDetails()
    {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session=req.getSession(false);
        String uname=(String) session.getAttribute("userName");
        System.out.println("session name"+uname);
        Response response=  jc.getUser(Response.class,uname);
        GenericType<Tbluser> us=new GenericType<Tbluser>(){};
        Tbluser u1=response.readEntity(us);
        //session.setAttribute("userId", u1.getUserId());
        System.out.println("session Id"+u1.getUserId());
        //for get Info
        int ud=u1.getUserId();
        Response res=jc.getUserdetails(Response.class,ud+"");
      GenericType<Tbluser> gAdd = new GenericType<Tbluser>(){};
       Tbluser u2=res.readEntity(gAdd);
        this.uid=u2.getUserId();
        username=u2.getUserName();
        email=u2.getEmail();
        cid=u2.getCityId().getCityId();
        jid=u2.getJobCategoryId().getJobCategoryId();
        address=u2.getAddress();
        profile=u2.getProfileImage();
        
        System.out.println("Uid & Name"+uid+username);
        
        
    }   
    public void updateUser()
    {
        String folder="/home/sebatsian/NetBeansProjects/Engiworks1/web/UserSite/ProfilePictures/";
       String f1=null;
        try(InputStream input=filename.getInputStream()){
            f1=filename.getSubmittedFileName();
            Files.copy(input,new File(folder,f1).toPath());           
        }catch(Exception e)
        {
            
        }
        //userbean.updateUser(userName, cid, address, email, jid);
        System.out.println("update Id"+uid);
        Tbluser u=new Tbluser();
        u.setUserId(uid);
        u.setUserName(username);
        u.setEmail(email);
        u.setCityId(new Tblcity(cid));
        u.setJobCategoryId(new Tbljobcategory(jid));
       u.setAddress(address);
       u.setProfileImage(f1);
        jc.updateUser(u);
    }
    
    public List<Object[]> userPostJob()
    {
       //rlist=userbean.userPostJob();
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session=req.getSession(false);
        String uname=(String) session.getAttribute("userName");
        System.out.println("session name"+uname);
        Response response=  jc.getUser(Response.class,uname);
        GenericType<Tbluser> us=new GenericType<Tbluser>(){};
        Tbluser u1=response.readEntity(us);
        int ud=u1.getUserId();
        
         Response resp=jc.getuserJob(Response.class,ud+"");
         List<Object[]> alist=new ArrayList<Object[]>();
         GenericType<List<Object[]>> gAdd = new GenericType<List<Object[]>>(){};
         alist = (List<Object[]>) resp.readEntity(gAdd);
       return alist;
    }
}
