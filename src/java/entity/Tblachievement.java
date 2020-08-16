/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sebatsian
 */
@Entity
@Table(name = "tblachievement")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblachievement.findAll", query = "SELECT t FROM Tblachievement t"),
    @NamedQuery(name = "Tblachievement.findByAchievementId", query = "SELECT t FROM Tblachievement t WHERE t.achievementId = :achievementId"),
    @NamedQuery(name = "Tblachievement.findByTitle", query = "SELECT t FROM Tblachievement t WHERE t.title = :title"),
    @NamedQuery(name = "Tblachievement.findByDescription", query = "SELECT t FROM Tblachievement t WHERE t.description = :description"),
    @NamedQuery(name = "Tblachievement.findByCreatedDate", query = "SELECT t FROM Tblachievement t WHERE t.createdDate = :createdDate")})
public class Tblachievement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "achievementId")
    private Integer achievementId;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "achievementId")
    private Collection<Tbllikes> tbllikesCollection;
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private Tbluser userId;
    @JoinColumn(name = "attechementId", referencedColumnName = "attachementId")
    @ManyToOne(optional = false)
    private Tblattachement attechementId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "achievementId")
    private Collection<Tblcomment> tblcommentCollection;

    public Tblachievement() {
    }

    public Tblachievement(Integer achievementId) {
        this.achievementId = achievementId;
    }

    public Tblachievement(Integer achievementId, String title, String description, Date createdDate) {
        this.achievementId = achievementId;
        this.title = title;
        this.description = description;
        this.createdDate = createdDate;
    }

    public Integer getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Integer achievementId) {
        this.achievementId = achievementId;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @JsonbTransient
    public Collection<Tbllikes> getTbllikesCollection() {
        return tbllikesCollection;
    }

    public void setTbllikesCollection(Collection<Tbllikes> tbllikesCollection) {
        this.tbllikesCollection = tbllikesCollection;
    }

    public Tbluser getUserId() {
        return userId;
    }

    public void setUserId(Tbluser userId) {
        this.userId = userId;
    }

    public Tblattachement getAttechementId() {
        return attechementId;
    }

    public void setAttechementId(Tblattachement attechementId) {
        this.attechementId = attechementId;
    }

    @JsonbTransient
    public Collection<Tblcomment> getTblcommentCollection() {
        return tblcommentCollection;
    }

    public void setTblcommentCollection(Collection<Tblcomment> tblcommentCollection) {
        this.tblcommentCollection = tblcommentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (achievementId != null ? achievementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblachievement)) {
            return false;
        }
        Tblachievement other = (Tblachievement) object;
        if ((this.achievementId == null && other.achievementId != null) || (this.achievementId != null && !this.achievementId.equals(other.achievementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tblachievement[ achievementId=" + achievementId + " ]";
    }
    
}
