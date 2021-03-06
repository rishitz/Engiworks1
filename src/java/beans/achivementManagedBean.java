/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import client.jobClient;
import ejb.UserbeanLocal;
import entity.TblMessage;
import entity.Tblachievement;
import entity.Tblbidassigned;
import entity.Tblcomment;
import entity.Tblcomplaint;
import entity.Tbljobcategory;
import entity.Tbllikes;
import entity.Tblrequirement;
import entity.Tblrequirementbid;
import entity.Tblreview;
import entity.Tbluser;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
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
@SessionScoped
public class achivementManagedBean implements Serializable {

    @EJB
    private UserbeanLocal userbean;
    private int uid, duration, jobId, bdur,userId,ratings,aid,bidderId,achid,asuid,asjid,bidrId,albdid,jid,jobid,jobcid;
    private String title, description,comment,complaint,review,username,email,pdf,rlist,message,achmsg,homejob;
    private Part filename;
    jobClient jc;
    private String jobname;
    List<Object[]> lobj;
    private float budget, bbud;
    private String bdesc;
    private Date edate;
    List<Object[]> jlist;
    List<Object[]> blist;
    List<Object[]> viewblist;
    List<Object[]> bidderlist;
    List<Object[]> userlist;
    List<Object[]> mlist;
    List<Object[]> serachjob;
    List<Object[]> homesearch;
    Collection<Tbljobcategory> jclist;
    
    Object reviewlist;
    Object likelist;
    private String acdescription;
    private int avg=0;

    public String getHomejob() {
        return homejob;
    }

    public void setHomejob(String homejob) {
        this.homejob = homejob;
    }

    public List<Object[]> getHomesearch() {
        return homesearch;
    }

    public void setHomesearch(List<Object[]> homesearch) {
        this.homesearch = homesearch;
    }

    public List<Object[]> getSerachjob() {
        return serachjob;
    }

    public void setSerachjob(List<Object[]> serachjob) {
        this.serachjob = serachjob;
    }

    public int getJobcid() {
        return jobcid;
    }

    public void setJobcid(int jobcid) {
        this.jobcid = jobcid;
    }

    public Collection<Tbljobcategory> getJclist() {
        return jclist;
    }

    public void setJclist(Collection<Tbljobcategory> jclist) {
        this.jclist = jclist;
    }

    public String getAchmsg() {
        return achmsg;
    }

    public void setAchmsg(String achmsg) {
        this.achmsg = achmsg;
    }

    public int getJobid() {
        return jobid;
    }

    public void setJobid(int jobid) {
        this.jobid = jobid;
    }

    public int getJid() {
        return jid;
    }

    public void setJid(int jid) {
        this.jid = jid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Object[]> getMlist() {
        return mlist;
    }

    public void setMlist(List<Object[]> mlist) {
        this.mlist = mlist;
    }

    public List<Object[]> getUserlist() {
        GenericType gc = new GenericType<List<Object[]>>() {
        };
       Response res = jc.getAllUserData(Response.class);
        userlist = (List<Object[]>) res.readEntity(gc);
        return (List<Object[]>) userlist;
    }

    public void setUserlist(List<Object[]> userlist) {
        this.userlist = userlist;
    }
    
    
    public String getRlist() {
        return rlist;
    }

    public void setRlist(String rlist) {
        this.rlist = rlist;
    }

    public int getAlbdid() {
        return albdid;
    }

    public void setAlbdid(int albdid) {
        this.albdid = albdid;
    }

    public int getBidrId() {
        return bidrId;
    }

    public void setBidrId(int bidrId) {
        this.bidrId = bidrId;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public int getAsuid() {
        return asuid;
    }

    public void setAsuid(int asuid) {
        this.asuid = asuid;
    }

    public int getAsjid() {
        return asjid;
    }

    public void setAsjid(int asjid) {
        this.asjid = asjid;
    }

    public Object getLikelist() {
        return likelist;
    }

    public void setLikelist(Object likelist) {
        this.likelist = likelist;
    }

    public int getAchid() {
        return achid;
    }

    public void setAchid(int achid) {
        this.achid = achid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBidderId() {
        return bidderId;
    }

    public void setBidderId(int bidderId) {
        this.bidderId = bidderId;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public Object getReviewlist() {
        return reviewlist;
    }

    public void setReviewlist(Object reviewlist) {
        this.reviewlist = reviewlist;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public List<Object[]> getViewblist() {
        return viewblist;
    }

    public void setViewblist(List<Object[]> viewblist) {
        this.viewblist = viewblist;
    }
    

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAcdescription() {
        return acdescription;
    }

    public void setAcdescription(String acdescription) {
        this.acdescription = acdescription;
    }
    

    public List<Object[]> getBidderlist() {
        return bidderlist;
    }

    public void setBidderlist(List<Object[]> bidderlist) {
        this.bidderlist = bidderlist;
    }
    

    public List<Object[]> getBlist() {
        return blist;
    }

    public void setBlist(List<Object[]> blist) {
        this.blist = blist;
    }

    public List<Object[]> getJlist() {
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
         jlist = (List<Object[]>) resp.readEntity(gAdd);
         
        return jlist;
    }

    public void setJlist(List<Object[]> jlist) {
        this.jlist = jlist;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getEdate() {
        return edate;
    }

    public void setEdate(Date edate) {
        this.edate = edate;
    }

    public int getBdur() {
        return bdur;
    }

    public void setBdur(int bdur) {
        this.bdur = bdur;
    }

    public float getBbud() {
        return bbud;
    }

    public void setBbud(float bbud) {
        this.bbud = bbud;
    }

    public String getBdesc() {
        return bdesc;
    }

    public void setBdesc(String bdesc) {
        this.bdesc = bdesc;
    }

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
        jclist=userbean.getalljob();
        lobj = new ArrayList<Object[]>();
        jlist=new ArrayList<Object[]>();
        blist=new ArrayList<Object[]>();
        bidderlist=new ArrayList<Object[]>();
        reviewlist=new Object();
        likelist=new Object();
        serachjob=new ArrayList<Object[]>();
        homesearch=new ArrayList<Object[]>();
       
//        this.getJobData();
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
        String folder = "/home/sebatsian/NetBeansProjects/Engiworks1/web/UserSite/PDF";
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
        System.out.println("filename"+f1);
       
        
        userbean.addAchivement(ud,title, description, f1);
         title=" ";
        description=" ";
        achmsg="you add achivement";

    }

//    public String homeJob()
//    {
//       
//    }
//    public void getJobData() {
//        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//        HttpSession session = req.getSession(false);
//        String uname = (String) session.getAttribute("userName");
//        System.out.println("session name" + uname);
//        Response response = jc.getUser(Response.class, uname);
//        GenericType<Tbluser> us = new GenericType<Tbluser>() {
//        };
//        Tbluser u1 = response.readEntity(us);
////        int xid = Integer.parseInt(req.getSession(false).getAttribute("jobId").toString());
//        Response res = jc.Viemore(Response.class, xid + "");
//        GenericType<Tblrequirement> gAdd = new GenericType<Tblrequirement>() {
//        };
//        Tblrequirement r1 = res.readEntity(gAdd);
//        uid = u1.getUserId();
//        jobId = xid;
//        jobname = r1.getTitle();
//        description = r1.getDescription();
//        budget = r1.getBudget();
//        duration = r1.getDuration();
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
        Response res = jc.Viemore(Response.class, xid + "");
        GenericType<Tblrequirement> gAdd = new GenericType<Tblrequirement>() {
        };
        Tblrequirement r1 = res.readEntity(gAdd);
        uid = u1.getUserId();
        jobId = xid;
        jobname = r1.getTitle();
        description = r1.getDescription();
        budget = r1.getBudget();
        duration = r1.getDuration();
//        req.getSession(false).setAttribute("jobId",xid);
        return "/UserSite/ViewMore.xhtml?faces-redirect=true";
    }

    public List<Object[]> bidCheck() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = req.getSession(false);
        String uname = (String) session.getAttribute("userName");
        System.out.println("session name" + uname);
        Response response = jc.getUser(Response.class, uname);
        GenericType<Tbluser> us = new GenericType<Tbluser>() {
        };
        Tbluser u1 = response.readEntity(us);
        int userid = u1.getUserId();
        System.out.println("Job Id=" + jobId);
        Response resp = jc.bidcheck(Response.class, userid + "", jobId + "");
        List<Object[]> alist = new ArrayList<Object[]>();
        GenericType<List<Object[]>> rb = new GenericType<List<Object[]>>() {
        };
        alist = resp.readEntity(rb);
        return alist;
    }

    public int getAlistSize() {
        return this.bidCheck().size();
    }

    public String addBid() {
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

        //userbean.addBid(bdesc, bdur, bbud, edate,ud,jobId);
        System.out.println("In bean=job id" + jobId);
        Tblrequirementbid rb = new Tblrequirementbid();
        rb.setBudget(bbud);
        rb.setDescription(bdesc);
        rb.setEndingDate(edate);
        rb.setDuration(bdur);
        rb.setUserId(new Tbluser(ud));
        rb.setRequirementId(new Tblrequirement(jobId));
        jc.addBid(rb);
        bdesc=" ";
        
        return "/UserSite/MyProfile.xhtml?faces-redirect=true";

    }

    public String viewmore(int xid) {

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
        Response res = jc.Viemore(Response.class, xid + "");
        GenericType<Tblrequirement> gAdd = new GenericType<Tblrequirement>() {
        };
        Tblrequirement r1 = res.readEntity(gAdd);
        userId=r1.getUserId().getUserId();
       
        uid = u1.getUserId();
         System.out.println("User Id in bid"+userId);
        jobId = xid;
        jobname = r1.getTitle();
        description = r1.getDescription();
        budget = r1.getBudget();
        duration = r1.getDuration();
        pdf=r1.getPdf();
//        req.getSession(false).setAttribute("jobId",xid);

        return "/UserSite/bidCheck.xhtml?faces-redirect=true";
    }

    
    
    
    public List<Object[]> bidInfo() {
//        Response response = jc.getBidJob(Response.class, jobId+"");
        System.out.println("Bid JobID : "+jobId);
        List<Object[]> list = new ArrayList<Object[]>();
//        GenericType<List<Object[]>> type = new GenericType<List<Object[]>>() {};
        list = userbean.bidInfo(jobId);
        for (Object[] objects : list) {
            asuid=Integer.parseInt(objects[13].toString());
            asjid=Integer.parseInt(objects[17].toString());
            System.out.println("asuid="+asuid+"asjid="+asjid);
            
        }
        
        return list;
    }
    public void bidAssign(int rbid,int usid,int rid)
    {
        System.out.println("bid assign"+usid+"rbid"+rbid);
        Tblbidassigned rb=new Tblbidassigned();
        rb.setUserId(new Tbluser(usid));
        rb.setRequirementBidId(new Tblrequirementbid(rbid));
        rb.setRequirementId(new Tblrequirement(rid));
        
        jc.bidassign(rb);
        
    }
    public void removeBid(int rbid)
    {
        jc.deleteBid(rbid+"");
    }
    public String userPostJob()
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
         jlist = (List<Object[]>) resp.readEntity(gAdd);
         
//         List<Object[]> list = new ArrayList<Object[]>();    
////        GenericType<List<Object[]>> type = new GenericType<List<Object[]>>() {};
//        list = userbean.manageTask(rid);
//        
//        for (Object[] objects : alist) {
//            for (Object[] objects1 : list) {
//                if(Integer.parseInt(objects[0].toString())==Integer.parseInt(objects[0].toString()))
//                {
//                    jlist.add(objects1);
//                 }
//              }          
//           }            
       return "";
    }
    public String manageJob(int rid)           
    {
        System.out.println("Manage Bid in session"+rid);
        
        //System.out.println("Manage job:"+jobId);
        Response resp=jc.manageTask(Response.class,rid+"");
         //List<Object[]> alist=new ArrayList<Object[]>();
         GenericType<List<Object[]>> gAdd = new GenericType<List<Object[]>>(){};
        
        blist =  (List<Object[]>) resp.readEntity(gAdd);
        for (Object[] objects : blist) {
            bidrId=Integer.parseInt(objects[0].toString());
            System.out.println("harryId="+bidrId);
            
        }

        return "/UserSite/Home1.xhtml?faces-redirect=true";
    }
    public String manageBidder(int uid,int rid)           
    {
        System.out.println("Manage Bidder in function"+rid+","+uid);
        //System.out.println("Manage job:"+jobId);
        albdid=uid;
        Response resp=jc.manageBidders(Response.class,uid+"",rid+"");
       Response res=jc.getReviews(Response.class,uid+"");
      
          
        GenericType<List<Object[]>> type = new GenericType<List<Object[]>>() {};
        bidderlist = (List<Object[]>) resp.readEntity(type);
        for (Object[] objects : bidderlist) {
            
            aid=Integer.parseInt(objects[19].toString());
            System.out.println("achid="+aid);
            
        }
         Response re=jc.getLikes(Response.class,aid+"");
         GenericType<Object> ltype = new GenericType<Object>() {};
        
        GenericType<Object> rtype = new GenericType<Object>(){};
        reviewlist = res.readEntity(rtype);
        //int i = Integer. valueOf((String) reviewlist);
        //avg=Integer.parseInt((String)reviewlist);
        //String s=reviewlist.toString();
         
        //System.out.println("rlist====="+ri);
        likelist=re.readEntity(ltype);
        System.out.println("Likes==="+likelist.toString());
        //System.out.println("RList : "+reviewlist.toString());
        //System.out.println("Manage Bidder in function"+rid+","+uid);
        return "/UserSite/manageBidder.xhtml?faces-redirect=true";
    }
    public void Comment(int uid,int aid)
    {
         HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session=req.getSession(false);
        String uname=(String) session.getAttribute("userName");
        System.out.println("session name"+uname);
        Response response=  jc.getUser(Response.class,uname);
        GenericType<Tbluser> us=new GenericType<Tbluser>(){};
        Tbluser u1=response.readEntity(us);
        int ud=u1.getUserId();
        Tblcomment c=new Tblcomment();
        c.setAchievementId(new Tblachievement(aid));
        c.setToUserId(new Tbluser(uid));
        c.setFromUserId(new Tbluser(ud));
        c.setDescription(comment);
        jc.Commnet(c);
        this.comment=" ";
        
        
    }
    
    public String viewBidder(int rid)           
    {
        System.out.println("Manage Bidder"+rid);
         HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        req.getSession().setAttribute("jobid", rid);
        //System.out.println("Manage job:"+jobId);
        Response resp=jc.viewBidder(Response.class,rid+"");
          
        GenericType<List<Object[]>> type = new GenericType<List<Object[]>>() {};
        viewblist = (List<Object[]>) resp.readEntity(type);
        for (Object[] objects : viewblist) {
                bidderId=Integer.parseInt(objects[0].toString());
                jobid=Integer.parseInt(objects[13].toString());
            System.out.println("Bidder Id send"+jobid);
            
        }
          
        return "/UserSite/bidderDetails.xhtml?faces-redirect=true";
    }
     public void Complaint(int uid)
    {
         HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session=req.getSession(false);
        String uname=(String) session.getAttribute("userName");
        System.out.println("session name"+uname);
        Response response=  jc.getUser(Response.class,uname);
        GenericType<Tbluser> us=new GenericType<Tbluser>(){};
        Tbluser u1=response.readEntity(us);
        int ud=u1.getUserId();
        Tblcomplaint c=new Tblcomplaint();
       
        c.setToUserId(new Tbluser(uid));
        c.setUserId(new Tbluser(ud));
        c.setComplaint(complaint);
        jc.Complaint(c);
        
        
    }
     public void Review(int uid,int rid)
    {
         HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session=req.getSession(false);
        String uname=(String) session.getAttribute("userName");
        System.out.println("session name"+uname);
        Response response=  jc.getUser(Response.class,uname);
        GenericType<Tbluser> us=new GenericType<Tbluser>(){};
        Tbluser u1=response.readEntity(us);
        int ud=u1.getUserId();
        
        Tblreview c=new Tblreview();
        System.out.println("review"+review);
        System.out.println("rating"+ratings);
        c.setToUserId(new Tbluser(uid));
        c.setFromUserId(new Tbluser(ud));
        c.setReview(review);
        c.setRatings(ratings);
        
        c.setRequirementId(new Tblrequirement(rid));
        jc.Review(c);        
        this.review=" ";
    }
     public List<Object[]> notification()           
    {
         HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session=req.getSession(false);
        String uname=(String) session.getAttribute("userName");
        System.out.println("session name"+uname);
        Response response=  jc.getUser(Response.class,uname);
        GenericType<Tbluser> us=new GenericType<Tbluser>(){};
        Tbluser u1=response.readEntity(us);
        int ud=u1.getUserId();
        
        //System.out.println("Manage job:"+jobId);
        Response resp=jc.notification(Response.class,ud+"");
           List<Object[]> alist=new ArrayList<Object[]>();
        GenericType<List<Object[]>> type = new GenericType<List<Object[]>>() {};
        alist = (List<Object[]>) resp.readEntity(type);
          
        return alist;
    }
     
      public List<Object[]> checkRe() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = req.getSession(false);
        String uname = (String) session.getAttribute("userName");
        System.out.println("diff" + uname);
        Response response = jc.getUser(Response.class, uname);
        GenericType<Tbluser> us = new GenericType<Tbluser>() {
        };
        Tbluser u1 = response.readEntity(us);
        int userid = u1.getUserId();
       int jid=(int) session.getAttribute("jobid");
          System.out.println("Check jobid"+jid);
        Response resp = jc.checkReviews(Response.class, userid + "", jid + "");
        List<Object[]> alist = new ArrayList<Object[]>();
        GenericType<List<Object[]>> rb = new GenericType<List<Object[]>>() {
        };
        alist = resp.readEntity(rb);
        return alist;
    }

    public int checkreview() {
        return this.checkRe().size();
    }
    
    public void like(int uid,int aid)
    {
         HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session=req.getSession(false);
        String uname=(String) session.getAttribute("userName");
        System.out.println("session name"+uname);
        Response response=  jc.getUser(Response.class,uname);
        GenericType<Tbluser> us=new GenericType<Tbluser>(){};
        Tbluser u1=response.readEntity(us);
        int ud=u1.getUserId();
        System.out.println("In like"+uid+aid);
        Tbllikes l=new Tbllikes();
        l.setFromUserId(new Tbluser(ud));
        l.setToUserId(new Tbluser(uid));
        l.setAchievementId(new Tblachievement(aid));
        jc.Like(l);
        
    }
    public List<Object[]> checklike() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = req.getSession(false);
        String uname = (String) session.getAttribute("userName");
        System.out.println("diff" + uname);
        Response response = jc.getUser(Response.class, uname);
        GenericType<Tbluser> us = new GenericType<Tbluser>() {};
        Tbluser u1 = response.readEntity(us);
        int userid = u1.getUserId();
       //int jid=(int) session.getAttribute("jobid");
          //System.out.println("Check jobid"+jid);
        Response resp = jc.checkLike(Response.class, userid + "", aid + "");
        List<Object[]> alist = new ArrayList<Object[]>();
        GenericType<List<Object[]>> rb = new GenericType<List<Object[]>>() {
        };
        alist = resp.readEntity(rb);
        return alist;
    }

    public int checkl() {
        return this.checklike().size();
    }
    
    public List<Object[]> showReviews() {
//        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//        HttpSession session = req.getSession(false);
//        String uname = (String) session.getAttribute("userName");
//        System.out.println("diff" + uname);
//        Response response = jc.getUser(Response.class, uname);
//        GenericType<Tbluser> us = new GenericType<Tbluser>() {};
//        Tbluser u1 = response.readEntity(us);
//        int userid = u1.getUserId();
//       int jid=(int) session.getAttribute("jobid");
//          System.out.println("Check jobid"+jid);
System.out.println("Bider===="+bidderId);
        Response resp = jc.showReviews(Response.class,bidderId + "");
        List<Object[]> Reviewlist = new ArrayList<Object[]>();
        GenericType<List<Object[]>> rb = new GenericType<List<Object[]>>() {
        };
        Reviewlist = resp.readEntity(rb);
        return Reviewlist;
    }
    
    public List<Object[]> checkBidding() {
        Response resp = jc.checkBid(Response.class, asuid + "", asjid + "");
        List<Object[]> alist = new ArrayList<Object[]>();
        GenericType<List<Object[]>> rb = new GenericType<List<Object[]>>() {
        };
        alist = resp.readEntity(rb);
        return alist;
    }

    public int checkBid() {
        return this.checkBidding().size();
    }
    public List<Object[]> allBidderList()
    {
        System.out.println("Bider===="+bidderId);
        Response resp = jc.showReviews(Response.class,albdid + "");
        List<Object[]> Reviewlist = new ArrayList<Object[]>();
        GenericType<List<Object[]>> rb = new GenericType<List<Object[]>>() {
        };
        Reviewlist = resp.readEntity(rb);
        return Reviewlist;
    }
    public List<Object[]> showEngName()
    {
         System.out.println("BiderYep===="+bidderId);
        Response resp = jc.showEngName(Response.class,bidrId + "");
        List<Object[]> Reviewlist = new ArrayList<Object[]>();
        GenericType<List<Object[]>> rb = new GenericType<List<Object[]>>() {
        };
        Reviewlist = resp.readEntity(rb);
        return Reviewlist;
    }
    public List<Object[]> showBiddetails()
    {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = req.getSession(false);
        String uname = (String) session.getAttribute("userName");
        System.out.println("session name" + uname);
        Response response = jc.getUser(Response.class, uname);
        GenericType<Tbluser> us = new GenericType<Tbluser>() {
        };
        Tbluser u1 = response.readEntity(us);
        int uid=u1.getUserId();
        Response res = jc.showbiddetails(Response.class,uid+"");
        List<Object[]> Reviewlist = new ArrayList<Object[]>();
        GenericType<List<Object[]>> rb = new GenericType<List<Object[]>>() {
        };
        Reviewlist = res.readEntity(rb);
        return Reviewlist;      
        
    }
    
    public String showappliedViewmore(int rid)
    {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = req.getSession(false);
        String uname = (String) session.getAttribute("userName");
        System.out.println("session name" + uname);
        Response response = jc.getUser(Response.class, uname);
        GenericType<Tbluser> us = new GenericType<Tbluser>() {
        };
        Tbluser u1 = response.readEntity(us);
        int uid=u1.getUserId();
        Response res = jc.showAppliedJob(Response.class,uid+"",rid+"");
        List<Object[]> Reviewlist = new ArrayList<Object[]>();
        
       
        
        
        GenericType<List<Object[]>> type = new GenericType<List<Object[]>>() {};
        mlist = (List<Object[]>) res.readEntity(type);
        for (Object[] objects : mlist) {
            jid=Integer.parseInt(objects[22].toString());
            System.out.println("jId="+jid);
            
        }
        return "/UserSite/message.xhtml?faces-redirect=true";     
        
    }
    public void addMessage(int uid,int jid)
    {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = req.getSession(false);
        String uname = (String) session.getAttribute("userName");
        System.out.println("session name" + uname);
        Response response = jc.getUser(Response.class, uname);
        GenericType<Tbluser> us = new GenericType<Tbluser>() {
        };
        Tbluser u1 = response.readEntity(us);
        int ud=u1.getUserId();
        
        TblMessage m=new TblMessage();
        m.setFromUserId(new Tbluser(ud));
        m.setToUserId(new Tbluser(uid));
        m.setMessage(message);
        m.setRequirementId(new Tblrequirement(jid));
        jc.addMessages(m);
        this.message = " ";
        
        
        
        
    }
    
    public List<Object[]> showMessage()
    {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = req.getSession(false);
        String uname = (String) session.getAttribute("userName");
        System.out.println("session name" + uname);
        Response response = jc.getUser(Response.class, uname);
        GenericType<Tbluser> us = new GenericType<Tbluser>() {
        };
        Tbluser u1 = response.readEntity(us);
        int uid=u1.getUserId();
        Response res = jc.showMessages(Response.class,jid+"");
        List<Object[]> Reviewlist = new ArrayList<Object[]>();
        GenericType<List<Object[]>> rb = new GenericType<List<Object[]>>() {
        };
        Reviewlist = res.readEntity(rb);
        
        return Reviewlist;  
        
        
    }
    
    public List<Object[]> showallMessage()
    {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = req.getSession(false);
        String uname = (String) session.getAttribute("userName");
        System.out.println("session name" + uname);
        Response response = jc.getUser(Response.class, uname);
        GenericType<Tbluser> us = new GenericType<Tbluser>() {
        };
        Tbluser u1 = response.readEntity(us);
        int uid=u1.getUserId();
        Response res = jc.showMessages(Response.class,jobid+"");
        List<Object[]> Reviewlist = new ArrayList<Object[]>();
        GenericType<List<Object[]>> rb = new GenericType<List<Object[]>>() {
        };
        Reviewlist = res.readEntity(rb);
        
        return Reviewlist;      
    }
    
    
    
    public String homeJob()
    {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = req.getSession(false);
        String uname = (String) session.getAttribute("userName");
        System.out.println("session name" + uname);
        Response response = jc.getUser(Response.class, uname);
        GenericType<Tbluser> us = new GenericType<Tbluser>() {
        };
        Tbluser u1 = response.readEntity(us);
        int uid=u1.getUserId();
        System.out.println("jobid"+jobcid);
        serachjob.clear();
        homesearch.clear();
        Response res = jc.showHJob(Response.class,uid+"",jobcid+"");
        List<Object[]> Reviewlist = new ArrayList<Object[]>();
        GenericType<List<Object[]>> rb = new GenericType<List<Object[]>>() {
        };
       
        serachjob= (List<Object[]>)res.readEntity(rb);
        
        return "/UserSite/SearchProject.xhtml?faces-redirect=true";   
        
    }
    
    
    public String projectSearch()
    {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = req.getSession(false);
        String uname = (String) session.getAttribute("userName");
        System.out.println("session name" + uname);
        Response response = jc.getUser(Response.class, uname);
        GenericType<Tbluser> us = new GenericType<Tbluser>() {
        };
        Tbluser u1 = response.readEntity(us);
        int uid=u1.getUserId();
        //System.out.println("jobid"+jobcid);
        
        System.out.println("homeJob"+homejob);
        homesearch.clear();
        serachjob.clear();
        Response res = jc.projectSearch(Response.class,homejob,uid+"");
        List<Object[]> Reviewlist = new ArrayList<Object[]>();
        GenericType<List<Object[]>> rb = new GenericType<List<Object[]>>() {
        };
       
       homesearch= (List<Object[]>)res.readEntity(rb);
        
        return "/UserSite/SearchProject.xhtml?faces-redirect=true";   
        
    }
    
    
//     
    
    
}
