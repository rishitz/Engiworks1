/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import client.jobClient;
import client.registerClient;
//import client.registerClient;
import ejb.UserbeanLocal;
import entity.Tblcity;
import entity.Tbljobcategory;
import entity.Tbluser;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author sebatsian
 */
@Named(value = "registrationManagedBean")
@SessionScoped
public class registrationManagedBean implements Serializable{

    @EJB
    private UserbeanLocal userbean;

    /**
     * Creates a new instance of registrationManagedBean
     */
    
    private int jid,cid,status,uid;
    private String userName,gender,address,email,password,chngpwd,message;
    private Collection<Tbljobcategory> jlist;
    private Collection<Tblcity> clist;
    registerClient rc=new registerClient();
    private Part filename;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getChngpwd() {
        return chngpwd;
    }

    public void setChngpwd(String chngpwd) {
        this.chngpwd = chngpwd;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Part getFilename() {
        return filename;
    }

    public void setFilename(Part filename) {
        this.filename = filename;
    }
    

    public int getJid() {
        return jid;
    }

    public void setJid(int jid) {
        this.jid = jid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    
    public registrationManagedBean() {
    }
    @PostConstruct
    public void init()
    {
        jlist=userbean.getalljob();
        clist=userbean.getallcity();
        
    }
    public String adduser()
    {
         String folder="/home/sebatsian/NetBeansProjects/Engiworks1/web/UserSite/ProfilePictures/";
       String f1=null;
        try(InputStream input=filename.getInputStream()){
            f1=filename.getSubmittedFileName();
            Files.copy(input,new File(folder,f1).toPath());           
        }catch(Exception e)
        {
            
        }
        //userbean.addUser(userName, gender, cid, address, email, password, jid, status);
        System.out.println("username"+userName);
        Tbluser u = new Tbluser();
        u.setUserName(userName);
        u.setGender(gender);
        u.setCityId(new Tblcity(cid));
        u.setAddress(address);
        u.setEmail(email);
        u.setPassword(password);
        u.setJobCategoryId(new Tbljobcategory(jid));
        u.setStatus(status);
        u.setProfileImage(f1);
        rc.addUser(u);
        return "/UserSite/Login.xhtml?faces-redirect=true";
        
    }
     public List<Object[]> checkDetails()
    {
        System.out.println("Username"+userName);
        System.out.println("email"+email);
        Response resp = rc.checkDetails(Response.class, userName, email);
        List<Object[]> alist = new ArrayList<Object[]>();
        GenericType<List<Object[]>> rb = new GenericType<List<Object[]>>() {};
        alist = resp.readEntity(rb);
        for (Object[] objects : alist) {
            System.out.println("In uid"+Integer.parseInt(objects[0].toString()));
            uid=Integer.parseInt(objects[0].toString());
            userName=objects[1].toString();
        }
        return alist;
    }
     public int checkDet()
     {        
         return this.checkDetails().size();
     }
   public void changePass()
   {
       System.out.println("bbye");
       System.out.println("uid===="+uid);
       
       Tbluser u=new Tbluser();
       u.setUserId(uid);
       u.setPassword(chngpwd);
       rc.changePassword(u);
       
       message="SuccessFully changed ps.";
       this.userName=" ";
       this.email=" ";
       
   }
}
