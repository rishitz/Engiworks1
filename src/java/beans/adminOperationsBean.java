/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import client.AdminJerseyClient;
import client.jobClient;
import entity.Tblcity;
import entity.Tblcomment;
import entity.Tblcomplaint;
import entity.Tbljobcategory;
import entity.Tbljobsubcategory;
import entity.Tblrequirement;
import entity.Tblrequirementbid;
import entity.Tblreview;
import entity.Tblstate;
import entity.Tbluser;
import entity.Tblusergroup;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
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
@Named(value = "adminOperationsBean")
@SessionScoped
public class adminOperationsBean implements Serializable {

    AdminJerseyClient a;
    jobClient jc;
    Response res;
    private int jobCatId;
    private String jobCatName;
    private int jobSubCatId;
    private String jobSubCatName, adminname;
    private int CityId;
    private String CityName;
    private int StateId;
    private String StateName;
    private int UserId;
    private int ReviewId;
    private String UserName;
    private String FromUserName;
    private String Gender;
    private String City;
    private String Email;
    private String Title;
    private float Budget;
    private int Duration;
    private String Description;
    private int messi;

    Collection<Tbljobcategory> clist;
    Collection<Tbljobsubcategory> jsclist;
    Collection<Tblreview> rlist;
    Collection<Tbluser> uselist;
    Collection<Tblcomplaint> complaintlist;
    Collection<Tblcomment> commentlist;
    Collection<Tblrequirementbid> requirmentbidlist;
    Collection<Tblrequirement> requirementlist;
    Collection<Tblusergroup> ulist;
    Collection<Tblcity> sclist;
    Collection<Tblstate> statelist;
    List<Object[]> userlist;
    Object Totalreqlist;
    private Part filename;
    private String profile, Address;

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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Object getTotalreqlist() {
        return Totalreqlist;
    }

    public void setTotalreqlist(Object Totalreqlist) {
        this.Totalreqlist = Totalreqlist;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public int getMessi() {
        return messi;
    }

    public void setMessi(int messi) {
        this.messi = messi;
    }

    public AdminJerseyClient getA() {
        return a;
    }

    public void setA(AdminJerseyClient a) {
        this.a = a;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public int getJobCatId() {
        return jobCatId;
    }

    public void setJobCatId(int jobCatId) {
        this.jobCatId = jobCatId;
    }

    public String getJobCatName() {
        return jobCatName;
    }

    public void setJobCatName(String jobCatName) {
        this.jobCatName = jobCatName;
    }

    public int getJobSubCatId() {
        return jobSubCatId;
    }

    public void setJobSubCatId(int jobSubCatId) {
        this.jobSubCatId = jobSubCatId;
    }

    public String getJobSubCatName() {
        return jobSubCatName;
    }

    public void setJobSubCatName(String jobSubCatName) {
        this.jobSubCatName = jobSubCatName;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String FromUserName) {
        this.FromUserName = FromUserName;
    }

    public int getReviewId() {
        return ReviewId;
    }

    public void setReviewId(int ReviewId) {
        this.ReviewId = ReviewId;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getCityId() {
        return CityId;
    }

    public void setCityId(int CityId) {
        this.CityId = CityId;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String CityName) {
        this.CityName = CityName;
    }

    public int getStateId() {
        return StateId;
    }

    public void setStateId(int StateId) {
        this.StateId = StateId;
    }

    public String getStateName() {
        return StateName;
    }

    public void setStateName(String StateName) {
        this.StateName = StateName;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public float getBudget() {
        return Budget;
    }

    public void setBudget(float Budget) {
        this.Budget = Budget;
    }

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int Duration) {
        this.Duration = Duration;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void clear() {
        jobCatId = 0;
        jobCatName = "";
        jobSubCatName = "";
    }
    //    --------------------------------------------------------------------------JOB CATEGORY

    public Collection<Tbljobcategory> getClist() {
        GenericType gc = new GenericType<Collection<Tbljobcategory>>() {
        };
        res = a.getAlljobCategory(Response.class);
        clist = (ArrayList<Tbljobcategory>) res.readEntity(gc);
        System.out.println(clist);
        return (ArrayList<Tbljobcategory>) clist;
    }

    public void setClist(Collection<Tbljobcategory> clist) {
        this.clist = clist;
    }

    public void addJob() {
        a.addJob(jobCatName);
        clear();
    }

    public String deleteJob(int jid) {
        a.deleteJob(jid + "");
        return "ViewJob.xhtml";
    }

    public String getJob(int jid) {
        //int jid=jobid;
        System.out.println("jobid" + jid);
        Response response = a.getJob(Response.class, jid + "");
        GenericType<Tbljobcategory> gAdd = new GenericType<Tbljobcategory>() {
        };
        Tbljobcategory u2 = response.readEntity(gAdd);
        this.jobCatId = u2.getJobCategoryId();
        jobCatName = u2.getJobCategoryName();
        return "EditJobCategory.xhtml";
    }

    public String updateJob() {
        Tbljobcategory j = new Tbljobcategory();
        j.setJobCategoryId(jobCatId);
        j.setJobCategoryName(jobCatName);
        a.updateJob(j);
        return "ViewJob.xhtml";
    }

//    --------------------------------------------------------------------------JOB SUB CATEGORY
    public void addJobSub() {
        Tbljobsubcategory jc = new Tbljobsubcategory();
        jc.setJobSubCategoryName(jobSubCatName);
        jc.setJobCategoryId(new Tbljobcategory(jobCatId));
        a.addJobSub(jc);
        clear();
    }

    public Collection<Tbljobsubcategory> getJsclist() {
        GenericType gc = new GenericType<Collection<Tbljobsubcategory>>() {
        };
        res = a.getAlljobSubCategory(Response.class);
        jsclist = (ArrayList<Tbljobsubcategory>) res.readEntity(gc);
//        System.out.println(clist);
        return (ArrayList<Tbljobsubcategory>) jsclist;
    }

    public void setJsclist(Collection<Tbljobsubcategory> jsclist) {
        this.jsclist = jsclist;
    }

    public String deleteJobSub(int jid) {
//         a.deleteJob(jid+"");
        a.deleteJobSub(jid + "");
        return "ViewJobSub.xhtml";
    }

    public String getJobSub(int jid) {
        //int jid=jobid;
        System.out.println("jobid" + jid);
        Response response = a.getJobSub(Response.class, jid + "");
        GenericType<Tbljobsubcategory> gAdd = new GenericType<Tbljobsubcategory>() {
        };
        Tbljobsubcategory u2 = response.readEntity(gAdd);
        this.jobSubCatId = u2.getJobSubCategoryId();
        jobSubCatName = u2.getJobSubCategoryName();
        jobCatId = u2.getJobCategoryId().getJobCategoryId();
        return "EditJobSubCategory.xhtml";
    }

    public String updateJobSub() {
        Tbljobsubcategory jc = new Tbljobsubcategory();
        jc.setJobSubCategoryId(jobSubCatId);
        jc.setJobSubCategoryName(jobSubCatName);
        jc.setJobCategoryId(new Tbljobcategory(jobCatId));
        a.updateJobSub(jc);
        return "ViewJobSub.xhtml";
    }
//    --------------------------------------------------------------------------Comment

    public Collection<Tblcomment> getCommentlist() {
        GenericType gc = new GenericType<Collection<Tblcomment>>() {
        };
        res = a.getAllcomment(Response.class);
        commentlist = (ArrayList<Tblcomment>) res.readEntity(gc);
        return (ArrayList<Tblcomment>) commentlist;
    }

    public void setCommentlist(Collection<Tblcomment> commentlist) {
        this.commentlist = commentlist;
    }

//    --------------------------------------------------------------------------Complaint
    public Collection<Tblcomplaint> getComplaintlist() {
        GenericType gc = new GenericType<Collection<Tblcomplaint>>() {
        };
        res = a.getAllcomplaint(Response.class);
        complaintlist = (ArrayList<Tblcomplaint>) res.readEntity(gc);
        return (ArrayList<Tblcomplaint>) complaintlist;
    }

    public void setComplaintlist(Collection<Tblcomplaint> complaintlist) {
        this.complaintlist = complaintlist;
    }

    public void comSatusOnOf(int r, int s) {
        String rid = Integer.toString(r);

        if (s == 1) {
            String stat = Integer.toString(s);
            a.updateCStatus(rid, stat);
        } else {
            String stat = Integer.toString(s);
            a.updateCStatus(rid, stat);
        }
    }

    public List<Object[]> userComplaint() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        Response res1 = a.getUserComplaint(Response.class, request.getSession().getAttribute("xyz").toString());
        List<Object[]> list = new ArrayList<Object[]>();
        GenericType<List<Object[]>> type = new GenericType<List<Object[]>>() {
        };
        list = res1.readEntity(type);
        return list;
    }
//    --------------------------------------------------------------------------Requirement Bid

    public Collection<Tblrequirementbid> getRequirmentbidlist() {
        GenericType gc = new GenericType<Collection<Tblrequirementbid>>() {
        };
        res = a.getAllrequirementbid(Response.class);
        requirmentbidlist = (ArrayList<Tblrequirementbid>) res.readEntity(gc);
        return (ArrayList<Tblrequirementbid>) requirmentbidlist;
    }

    public void setRequirmentbidlist(Collection<Tblrequirementbid> requirmentbidlist) {
        this.requirmentbidlist = requirmentbidlist;
    }

    public List<Object[]> userAppliedJob() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        Response res1 = a.getUserAppliedjob(Response.class, request.getSession().getAttribute("xyz").toString());
        List<Object[]> list = new ArrayList<Object[]>();
        GenericType<List<Object[]>> type = new GenericType<List<Object[]>>() {
        };
        list = res1.readEntity(type);
        return list;
    }

    public List<Object[]> userGotJob() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        Response res1 = a.UserGotjob(Response.class, request.getSession().getAttribute("xyz").toString());
        List<Object[]> list = new ArrayList<Object[]>();
        GenericType<List<Object[]>> type = new GenericType<List<Object[]>>() {
        };
        list = res1.readEntity(type);
        return list;
    }

//    --------------------------------------------------------------------------Review
    public Collection<Tblreview> getRlist() {
        GenericType gc = new GenericType<Collection<Tblreview>>() {
        };
        res = a.getAllreview(Response.class);
        rlist = (ArrayList<Tblreview>) res.readEntity(gc);
        System.out.println(rlist);
        return (ArrayList<Tblreview>) rlist;
    }

    public void setRlist(Collection<Tblreview> rlist) {
        this.rlist = rlist;
    }

    public List<Object[]> userReview() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        Response res1 = a.getUserReview(Response.class, request.getSession().getAttribute("xyz").toString());
        List<Object[]> list = new ArrayList<Object[]>();
        GenericType<List<Object[]>> type = new GenericType<List<Object[]>>() {
        };
        list = res1.readEntity(type);
        return list;
    }

    public void statusOnOf(int r, int s) {
//           System.out.println("review id : "+r);
        String rid = Integer.toString(r);

        if (s == 1) {
//            System.out.println("AAYA");
            String stat = Integer.toString(s);
            a.updateStatus(rid, stat);
        } else {
//            System.out.println("Nahi AAYA");
            String stat = Integer.toString(s);
            a.updateStatus(rid, stat);
        }
    }
//    --------------------------------------------------------------------------Requirement

    public Collection<Tblrequirement> getRequirementlist() {
        GenericType gc = new GenericType<Collection<Tblrequirement>>() {
        };
        res = a.getAllrequirement(Response.class);
        requirementlist = (ArrayList<Tblrequirement>) res.readEntity(gc);
        return (ArrayList<Tblrequirement>) requirementlist;
    }

    public void setRequirementlist(Collection<Tblrequirement> requirementlist) {
        this.requirementlist = requirementlist;
    }

    public List<Object[]> userRequirement() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        Response res1 = a.getUserPostedJob(Response.class, request.getSession().getAttribute("xyz").toString());
        List<Object[]> list = new ArrayList<Object[]>();
        GenericType<List<Object[]>> type = new GenericType<List<Object[]>>() {
        };
        list = res1.readEntity(type);
        return list;
    }

    public void reqSatusOnOf(int r, int s) {
        String rid = Integer.toString(r);

        if (s == 1) {
            String stat = Integer.toString(s);
            a.updateReqStatus(rid, stat);
        } else {
            String stat = Integer.toString(s);
            a.updateReqStatus(rid, stat);
        }
    }

//    --------------------------------------------------------------------------Users
    public Collection<Tblusergroup> getUlist() {
        GenericType gc = new GenericType<Collection<Tblusergroup>>() {
        };
        res = a.getAllUserData(Response.class);
        ulist = (ArrayList<Tblusergroup>) res.readEntity(gc);
        System.out.println(rlist);
        return (ArrayList<Tblusergroup>) ulist;
    }

    public void setUlist(Collection<Tblusergroup> ulist) {
        this.ulist = ulist;
    }

    public List<Object[]> getUserlist() {

        GenericType gc = new GenericType<List<Object[]>>() {
        };
        res = a.getAllUserData(Response.class);
        userlist = (List<Object[]>) res.readEntity(gc);
        return (List<Object[]>) userlist;

    }

    public void setUserlist(List<Object[]> userlist) {
        this.userlist = userlist;
    }

    public Collection<Tbluser> getUselist() {
        GenericType gc = new GenericType<Collection<Tbluser>>() {
        };
        res = a.getAllUserData(Response.class);
        uselist = (ArrayList<Tbluser>) res.readEntity(gc);
        System.out.println(rlist);
        return (ArrayList<Tbluser>) uselist;

    }

    public void setUselist(Collection<Tbluser> uselist) {
        this.uselist = uselist;
    }

    public void userSatusOnOf(int r, int s) {
        String rid = Integer.toString(r);

        if (s == 1) {
            String stat = Integer.toString(s);
            a.updateUStatus(rid, stat);
        } else {
            String stat = Integer.toString(s);
            a.updateUStatus(rid, stat);
        }
    }

    //--------------------------------------------------------------------------USER DETAILS IN CARD
    public List<Object[]> userData() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        Response res1 = a.getSpecificUserInfo(Response.class, request.getSession().getAttribute("xyz").toString());
        List<Object[]> list = new ArrayList<Object[]>();
        GenericType<List<Object[]>> type = new GenericType<List<Object[]>>() {
        };
        list = res1.readEntity(type);
        return list;
    }
    //---------------------------------------------------------------------------POSTED JOB LIST BY USER

    public List<Object[]> userMoreData() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        Response res1 = a.getUserInfo(Response.class, request.getSession().getAttribute("xyz").toString());
        List<Object[]> list = new ArrayList<Object[]>();
        GenericType<List<Object[]>> type = new GenericType<List<Object[]>>() {
        };
        list = res1.readEntity(type);
        return list;
    }

    public String UserInfo(int uid) {
        System.out.print("ADMINBEAN UID:" + uid);
        this.setMessi(uid);
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        request.getSession().setAttribute("xyz", uid);

        return "MoreInfoUser.xhtml";
    }

//    --------------------------------------------------------------------------State       
    public void addState() {
        a.addState(StateName);
        clear();
    }

    public String deleteState(int jid) {
        a.deleteState(jid + "");
        return "ViewState.xhtml";
    }

    public String getState(int sid) {
        //int jid=jobid;
        System.out.println("Stateid" + sid);
        Response response = a.getState(Response.class, sid + "");
        GenericType<Tblstate> gAdd = new GenericType<Tblstate>() {
        };
        Tblstate s = response.readEntity(gAdd);
        this.StateId = s.getStateId();
        StateName = s.getStateName();
        return "EditState.xhtml";
    }

    public String updateState() {
        Tblstate j = new Tblstate();
        j.setStateId(StateId);
        j.setStateName(StateName);
        a.updateState(j);
        return "ViewState.xhtml";
    }

    public Collection<Tblstate> getStatelist() {
        GenericType gc = new GenericType<Collection<Tblstate>>() {
        };
        res = a.getAllState(Response.class);
        statelist = (ArrayList<Tblstate>) res.readEntity(gc);
        return (ArrayList<Tblstate>) statelist;
    }

    public void setStatelist(Collection<Tblstate> statelist) {
        this.statelist = statelist;
    }

//    --------------------------------------------------------------------------City
    public void addCity() {
        Tblcity jc = new Tblcity();
        jc.setCityName(CityName);
        jc.setStateId(new Tblstate(StateId));
        a.addCity(jc);
        clear();
    }

    public String deleteCity(int jid) {
        a.deleteCity(jid + "");
        return "StateCity.xhtml";
    }

    public Collection<Tblcity> getSclist() {
        GenericType gc = new GenericType<Collection<Tblcity>>() {
        };
        res = a.getAllCityData(Response.class);
        sclist = (ArrayList<Tblcity>) res.readEntity(gc);
        return (ArrayList<Tblcity>) sclist;
    }

    public void setSclist(Collection<Tblcity> sclist) {
        this.sclist = sclist;
    }

    public String getCity(int cid) {
        //int jid=jobid;
        System.out.println("Cityid" + cid);
        Response response = a.getCity(Response.class, cid + "");
        GenericType<Tblcity> gAdd = new GenericType<Tblcity>() {
        };
        Tblcity u2 = response.readEntity(gAdd);
        this.CityId = u2.getCityId();
        CityName = u2.getCityName();
        StateId = u2.getStateId().getStateId();
        return "EditCity.xhtml";
    }

    public String updateCity() {
        Tblcity jc = new Tblcity();
        jc.setCityId(CityId);
        jc.setCityName(CityName);
        jc.setStateId(new Tblstate(StateId));
        a.updateCity(jc);
        return "StateCity.xhtml";
    }

    public Object trl() {
        Response re = a.getTotalReq(Response.class);
        GenericType<Object> ltype = new GenericType<Object>() {
        };
        Totalreqlist = re.readEntity(ltype);
        System.out.println("ltype" + ltype.toString());
        return Totalreqlist;
    }

    public Object trbl() {
        Response re = a.getTotalReqBid(Response.class);
        GenericType<Object> ltype = new GenericType<Object>() {
        };
        Totalreqlist = re.readEntity(ltype);
        System.out.println("ltype" + ltype.toString());
        return Totalreqlist;
    }

    public Object tul() {
        Response re = a.getTotalUsers(Response.class);
        GenericType<Object> ltype = new GenericType<Object>() {
        };
        Totalreqlist = re.readEntity(ltype);
        System.out.println("ltype" + ltype.toString());
        return Totalreqlist;
    }

    public Object tjl() {
        Response re = a.getTotalTypes(Response.class);
        GenericType<Object> ltype = new GenericType<Object>() {
        };
        Totalreqlist = re.readEntity(ltype);
        System.out.println("ltype" + ltype.toString());
        return Totalreqlist;
    }

    public void getadminDetails() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//        HttpSession session=req.getSession(false);
        String aname = (String) req.getSession().getAttribute("adminName");
        System.out.println("session name" + aname);
        Response response = jc.getUser(Response.class, aname);
        GenericType<Tbluser> us = new GenericType<Tbluser>() {
        };
        Tbluser u1 = response.readEntity(us);
        int ud = u1.getUserId();

        Response res = a.adminId(Response.class, ud + "");
        GenericType<Tbluser> gAdd = new GenericType<Tbluser>() {
        };
        Tbluser u2 = res.readEntity(gAdd);
        this.UserId = u2.getUserId();
        UserName = u2.getUserName();
        Email = u2.getEmail();
        CityId = u2.getCityId().getCityId();
        jobCatId = u2.getJobCategoryId().getJobCategoryId();
        Address = u2.getAddress();
        profile = u2.getProfileImage();
        jobCatName = u2.getJobCategoryId().getJobCategoryName();
        CityName = u2.getCityId().getCityName();
        Gender = u2.getGender();
        System.out.println("Uid & Name" + UserId + UserName);

    }

    public void updateAdmin() {
//        String folder="/home/sebatsian/NetBeansProjects/Engiworks1/web/UserSite/ProfilePictures/";
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String folder = "/home/sebatsian/NetBeansProjects/Engiworks1/web/UserSite/ProfilePictures/";
        String f1 = null;
        try (InputStream input = filename.getInputStream()) {
            f1 = filename.getSubmittedFileName();
            Files.copy(input, new File(folder, f1).toPath());
        } catch (Exception e) {

        }
        System.out.println("update Id" + UserId);
        System.out.println("name" + UserName);
        Tbluser u = new Tbluser();
        u.setUserId(UserId);
        u.setUserName(UserName);
        request.getSession().setAttribute("adminName", UserName);
        u.setEmail(Email);
        u.setCityId(new Tblcity(CityId));
        u.setJobCategoryId(new Tbljobcategory(jobCatId));
        u.setAddress(Address);
        u.setProfileImage(f1);
        a.updateAdmin(u);
        
        //getadminDetails();

    }

    /**
     * Creates a new instance of adminOperationsBean
     */
    public adminOperationsBean() {
        System.out.println("beans.adminOperationsBean.<init>()");
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        String token = "";

        token = request.getSession().getAttribute("token").toString();
        System.out.println("TokenABC=" + token);
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = req.getSession(false);
        adminname = (String) session.getAttribute("adminName");
        a = new AdminJerseyClient(token);
        jc = new jobClient(token);
        clist = new ArrayList<>();
        sclist = new ArrayList<>();
        rlist = new ArrayList<>();
        uselist = new ArrayList<>();
        ulist = new ArrayList<>();
        userlist = new ArrayList<>();
        jsclist = new ArrayList<>();
        statelist = new ArrayList<>();
    }

}
