/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sebatsian
 */
@Entity
@Table(name = "tbluser")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbluser.findAll", query = "SELECT t FROM Tbluser t"),
    @NamedQuery(name = "Tbluser.findByUserId", query = "SELECT t FROM Tbluser t WHERE t.userId = :userId"),
    @NamedQuery(name = "Tbluser.findByUserName", query = "SELECT t FROM Tbluser t WHERE t.userName = :userName"),
    @NamedQuery(name = "Tbluser.findByGender", query = "SELECT t FROM Tbluser t WHERE t.gender = :gender"),
    @NamedQuery(name = "Tbluser.findByAddress", query = "SELECT t FROM Tbluser t WHERE t.address = :address"),
    @NamedQuery(name = "Tbluser.findByEmail", query = "SELECT t FROM Tbluser t WHERE t.email = :email"),
    @NamedQuery(name = "Tbluser.findByPassword", query = "SELECT t FROM Tbluser t WHERE t.password = :password"),
    @NamedQuery(name = "Tbluser.findByStatus", query = "SELECT t FROM Tbluser t WHERE t.status = :status"),
    @NamedQuery(name = "Tbluser.findByProfileImage", query = "SELECT t FROM Tbluser t WHERE t.profileImage = :profileImage")})
public class Tbluser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userId")
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "userName")
    private String userName;
    @Basic(optional = false)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @Column(name = "profileImage")
    private String profileImage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Tblattachement> tblattachementCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Tblrequirementbid> tblrequirementbidCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Tblusergroup> tblusergroupCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "toUserId")
    private Collection<Tbllikes> tbllikesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromUserId")
    private Collection<Tbllikes> tbllikesCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Tblrequirement> tblrequirementCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Tblcomplaint> tblcomplaintCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "toUserId")
    private Collection<Tblcomplaint> tblcomplaintCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "toUserId")
    private Collection<Tblreview> tblreviewCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromUserId")
    private Collection<Tblreview> tblreviewCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "toUserId")
    private Collection<TblMessage> tblMessageCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromUserId")
    private Collection<TblMessage> tblMessageCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Tblachievement> tblachievementCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Tblbidassigned> tblbidassignedCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromUserId")
    private Collection<Tblnotification> tblnotificationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Tblnotification> tblnotificationCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "toUserId")
    private Collection<Tblcomment> tblcommentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fromUserId")
    private Collection<Tblcomment> tblcommentCollection1;
    @JoinColumn(name = "cityId", referencedColumnName = "cityId")
    @ManyToOne(optional = false)
    private Tblcity cityId;
    @JoinColumn(name = "jobCategoryId", referencedColumnName = "jobCategoryId")
    @ManyToOne(optional = false)
    private Tbljobcategory jobCategoryId;

    public Tbluser() {
    }

    public Tbluser(Integer userId) {
        this.userId = userId;
    }

    public Tbluser(Integer userId, String userName, String gender, String address, String email, String password, int status, String profileImage) {
        this.userId = userId;
        this.userName = userName;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.password = password;
        this.status = status;
        this.profileImage = profileImage;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    @JsonbTransient
    public Collection<Tblattachement> getTblattachementCollection() {
        return tblattachementCollection;
    }

    public void setTblattachementCollection(Collection<Tblattachement> tblattachementCollection) {
        this.tblattachementCollection = tblattachementCollection;
    }

    @JsonbTransient
    public Collection<Tblrequirementbid> getTblrequirementbidCollection() {
        return tblrequirementbidCollection;
    }

    public void setTblrequirementbidCollection(Collection<Tblrequirementbid> tblrequirementbidCollection) {
        this.tblrequirementbidCollection = tblrequirementbidCollection;
    }

    @JsonbTransient
    public Collection<Tblusergroup> getTblusergroupCollection() {
        return tblusergroupCollection;
    }

    public void setTblusergroupCollection(Collection<Tblusergroup> tblusergroupCollection) {
        this.tblusergroupCollection = tblusergroupCollection;
    }

    @JsonbTransient
    public Collection<Tbllikes> getTbllikesCollection() {
        return tbllikesCollection;
    }

    public void setTbllikesCollection(Collection<Tbllikes> tbllikesCollection) {
        this.tbllikesCollection = tbllikesCollection;
    }

    @JsonbTransient
    public Collection<Tbllikes> getTbllikesCollection1() {
        return tbllikesCollection1;
    }

    public void setTbllikesCollection1(Collection<Tbllikes> tbllikesCollection1) {
        this.tbllikesCollection1 = tbllikesCollection1;
    }

    @JsonbTransient
    public Collection<Tblrequirement> getTblrequirementCollection() {
        return tblrequirementCollection;
    }

    public void setTblrequirementCollection(Collection<Tblrequirement> tblrequirementCollection) {
        this.tblrequirementCollection = tblrequirementCollection;
    }

    @JsonbTransient
    public Collection<Tblcomplaint> getTblcomplaintCollection() {
        return tblcomplaintCollection;
    }

    public void setTblcomplaintCollection(Collection<Tblcomplaint> tblcomplaintCollection) {
        this.tblcomplaintCollection = tblcomplaintCollection;
    }

    @JsonbTransient
    public Collection<Tblcomplaint> getTblcomplaintCollection1() {
        return tblcomplaintCollection1;
    }

    public void setTblcomplaintCollection1(Collection<Tblcomplaint> tblcomplaintCollection1) {
        this.tblcomplaintCollection1 = tblcomplaintCollection1;
    }

    @JsonbTransient
    public Collection<Tblreview> getTblreviewCollection() {
        return tblreviewCollection;
    }

    public void setTblreviewCollection(Collection<Tblreview> tblreviewCollection) {
        this.tblreviewCollection = tblreviewCollection;
    }

    @JsonbTransient
    public Collection<Tblreview> getTblreviewCollection1() {
        return tblreviewCollection1;
    }

    public void setTblreviewCollection1(Collection<Tblreview> tblreviewCollection1) {
        this.tblreviewCollection1 = tblreviewCollection1;
    }

    @JsonbTransient
    public Collection<TblMessage> getTblMessageCollection() {
        return tblMessageCollection;
    }

    public void setTblMessageCollection(Collection<TblMessage> tblMessageCollection) {
        this.tblMessageCollection = tblMessageCollection;
    }

    @JsonbTransient
    public Collection<TblMessage> getTblMessageCollection1() {
        return tblMessageCollection1;
    }

    public void setTblMessageCollection1(Collection<TblMessage> tblMessageCollection1) {
        this.tblMessageCollection1 = tblMessageCollection1;
    }

    @JsonbTransient
    public Collection<Tblachievement> getTblachievementCollection() {
        return tblachievementCollection;
    }

    public void setTblachievementCollection(Collection<Tblachievement> tblachievementCollection) {
        this.tblachievementCollection = tblachievementCollection;
    }

    @JsonbTransient
    public Collection<Tblbidassigned> getTblbidassignedCollection() {
        return tblbidassignedCollection;
    }

    public void setTblbidassignedCollection(Collection<Tblbidassigned> tblbidassignedCollection) {
        this.tblbidassignedCollection = tblbidassignedCollection;
    }

    @JsonbTransient
    public Collection<Tblnotification> getTblnotificationCollection() {
        return tblnotificationCollection;
    }

    public void setTblnotificationCollection(Collection<Tblnotification> tblnotificationCollection) {
        this.tblnotificationCollection = tblnotificationCollection;
    }

    @JsonbTransient
    public Collection<Tblnotification> getTblnotificationCollection1() {
        return tblnotificationCollection1;
    }

    public void setTblnotificationCollection1(Collection<Tblnotification> tblnotificationCollection1) {
        this.tblnotificationCollection1 = tblnotificationCollection1;
    }

    @JsonbTransient
    public Collection<Tblcomment> getTblcommentCollection() {
        return tblcommentCollection;
    }

    public void setTblcommentCollection(Collection<Tblcomment> tblcommentCollection) {
        this.tblcommentCollection = tblcommentCollection;
    }

    @JsonbTransient
    public Collection<Tblcomment> getTblcommentCollection1() {
        return tblcommentCollection1;
    }

    public void setTblcommentCollection1(Collection<Tblcomment> tblcommentCollection1) {
        this.tblcommentCollection1 = tblcommentCollection1;
    }

    public Tblcity getCityId() {
        return cityId;
    }

    public void setCityId(Tblcity cityId) {
        this.cityId = cityId;
    }

    public Tbljobcategory getJobCategoryId() {
        return jobCategoryId;
    }

    public void setJobCategoryId(Tbljobcategory jobCategoryId) {
        this.jobCategoryId = jobCategoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbluser)) {
            return false;
        }
        Tbluser other = (Tbluser) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tbluser[ userId=" + userId + " ]";
    }
    
}
