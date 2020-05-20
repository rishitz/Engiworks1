/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Tblcity;
import entity.Tblgroup;
import entity.Tbljobcategory;
import entity.Tblrequirement;
import entity.Tbluser;
import entity.Tblusergroup;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 *
 * @author sebatsian
 */
@Stateless
public class Userbean implements UserbeanLocal {
    
     @PersistenceContext(unitName = "Engiworks-ejbPU")
    EntityManager em;
     
    @Override
    public Tbluser storeSession(String userName) {
         Tbluser u=(Tbluser)em.createNamedQuery("Tbluser.findByUserName").setParameter("userName",userName).getSingleResult();
        return u;
    }

    @Override
    public Collection<Tblrequirement> alljob() {
        return em.createNamedQuery("Tblrequirement.findAll").getResultList();
    }

    @Override
    public void addUser(String userName, String gender, int cityId, String address, String email, String password, int jobCategoryId, int status) {
        Tbluser u=new Tbluser();
        Pbkdf2PasswordHashImpl pass = new Pbkdf2PasswordHashImpl();
        u.setUserName(userName);
        u.setGender(gender);
        u.setCityId(new Tblcity(cityId));
        u.setAddress(address);
        u.setEmail(email);
        u.setPassword(pass.generate(password.toCharArray()));
        u.setJobCategoryId(new Tbljobcategory(jobCategoryId));
        u.setStatus(status);
        em.persist(u);
        em.flush();
        System.out.println("LastID = "+u.getUserId());
       int lastuid=u.getUserId();
       Tblusergroup ug=new Tblusergroup();
       ug.setUserId(new Tbluser(lastuid));
       ug.setGroupId(new Tblgroup(2));
       em.persist(ug);
       
    }

    @Override
    public Collection<Tbljobcategory> getalljob() {
        Collection<Tbljobcategory> job=em.createNamedQuery("Tbljobcategory.findAll").getResultList();
        return job;
    }

    @Override
    public Collection<Tblcity> getallcity() {
        Collection<Tblcity> city=em.createNamedQuery("Tblcity.findAll").getResultList();
    return city; 
    }

    @Override
    public Tbluser user(String uname) {
//         FacesContext context=FacesContext.getCurrentInstance();
//        String username=(String)context.getExternalContext().getSessionMap().get("userName");
//        System.out.println("uname"+username);
        Tbluser u=(Tbluser)em.createNamedQuery("Tbluser.findByUserName").setParameter("userName",uname).getSingleResult();
        return u;
    }

    @Override
    public void updateUser(int uid, String userName, int cityId, String address, String email, int jobCategoryId) {
        Tbluser u=em.find(Tbluser.class, uid);
        Tblcity c=em.find(Tblcity.class, cityId);
        Collection<Tbluser> ulist=c.getTbluserCollection();
        Tbljobcategory j=em.find(Tbljobcategory.class, jobCategoryId);
        Collection<Tbluser> jlist=j.getTbluserCollection();
        u.setUserName(userName);
        u.setCityId(c);
        u.setAddress(address);
        u.setEmail(email);
        u.setJobCategoryId(j);
        em.merge(u);
        ulist.add(u);
        jlist.add(u);
        em.merge(c);
        em.merge(j);
    }

    @Override
    public Tbluser userDetail(int uid) {
        
         return em.find(Tbluser.class,uid);
    }

    @Override
    public List<Object[]> userPostJob(int uid) {
        return em.createNativeQuery("select * from tblrequirement where userId="+uid).getResultList();
    }
    

}
