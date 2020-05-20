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
@Table(name = "tblreview")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblreview.findAll", query = "SELECT t FROM Tblreview t"),
    @NamedQuery(name = "Tblreview.findByReviewId", query = "SELECT t FROM Tblreview t WHERE t.reviewId = :reviewId"),
    @NamedQuery(name = "Tblreview.findByReview", query = "SELECT t FROM Tblreview t WHERE t.review = :review"),
    @NamedQuery(name = "Tblreview.findByCreatedDate", query = "SELECT t FROM Tblreview t WHERE t.createdDate = :createdDate"),
    @NamedQuery(name = "Tblreview.findByStatus", query = "SELECT t FROM Tblreview t WHERE t.status = :status")})
public class Tblreview implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "reviewId")
    private Integer reviewId;
    @Basic(optional = false)
    @Column(name = "review")
    private String review;
    @Basic(optional = false)
    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "toUserId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private Tbluser toUserId;
    @JoinColumn(name = "fromUserId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private Tbluser fromUserId;

    public Tblreview() {
    }

    public Tblreview(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Tblreview(Integer reviewId, String review, Date createdDate, int status) {
        this.reviewId = reviewId;
        this.review = review;
        this.createdDate = createdDate;
        this.status = status;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reviewId != null ? reviewId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblreview)) {
            return false;
        }
        Tblreview other = (Tblreview) object;
        if ((this.reviewId == null && other.reviewId != null) || (this.reviewId != null && !this.reviewId.equals(other.reviewId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tblreview[ reviewId=" + reviewId + " ]";
    }
    
}
