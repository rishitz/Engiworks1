/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebatsian
 */
@Entity
@Table(name = "tblcomment")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblcomment.findAll", query = "SELECT t FROM Tblcomment t"),
    @NamedQuery(name = "Tblcomment.findByCommentId", query = "SELECT t FROM Tblcomment t WHERE t.commentId = :commentId"),
    @NamedQuery(name = "Tblcomment.findByDescription", query = "SELECT t FROM Tblcomment t WHERE t.description = :description"),
    @NamedQuery(name = "Tblcomment.findByCreatedDate", query = "SELECT t FROM Tblcomment t WHERE t.createdDate = :createdDate")})
public class Tblcomment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "commentId")
    private Integer commentId;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "toUserId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private Tbluser toUserId;
    @JoinColumn(name = "fromUserId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private Tbluser fromUserId;
    @JoinColumn(name = "achievementId", referencedColumnName = "achievementId")
    @ManyToOne(optional = false)
    private Tblachievement achievementId;

    public Tblcomment() {
    }

    public Tblcomment(Integer commentId) {
        this.commentId = commentId;
    }

    public Tblcomment(Integer commentId, String description, Date createdDate) {
        this.commentId = commentId;
        this.description = description;
        this.createdDate = createdDate;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
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

    public Tbluser getToUserId() {
        return toUserId;
    }

    public void setToUserId(Tbluser toUserId) {
        this.toUserId = toUserId;
    }

    public Tbluser getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Tbluser fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Tblachievement getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Tblachievement achievementId) {
        this.achievementId = achievementId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commentId != null ? commentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblcomment)) {
            return false;
        }
        Tblcomment other = (Tblcomment) object;
        if ((this.commentId == null && other.commentId != null) || (this.commentId != null && !this.commentId.equals(other.commentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tblcomment[ commentId=" + commentId + " ]";
    }
    
}
