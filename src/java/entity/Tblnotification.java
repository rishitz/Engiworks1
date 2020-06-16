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
@Table(name = "tblnotification")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblnotification.findAll", query = "SELECT t FROM Tblnotification t"),
    @NamedQuery(name = "Tblnotification.findByNotificationId", query = "SELECT t FROM Tblnotification t WHERE t.notificationId = :notificationId"),
    @NamedQuery(name = "Tblnotification.findByNotification", query = "SELECT t FROM Tblnotification t WHERE t.notification = :notification"),
    @NamedQuery(name = "Tblnotification.findByCreateddate", query = "SELECT t FROM Tblnotification t WHERE t.createddate = :createddate"),
    @NamedQuery(name = "Tblnotification.findByStatus", query = "SELECT t FROM Tblnotification t WHERE t.status = :status")})
public class Tblnotification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "notificationId")
    private Integer notificationId;
    @Basic(optional = false)
    @Column(name = "notification")
    private String notification;
    @Basic(optional = false)
    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createddate;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "fromUserId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private Tbluser fromUserId;
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private Tbluser userId;

    public Tblnotification() {
    }

    public Tblnotification(Integer notificationId) {
        this.notificationId = notificationId;
    }

    public Tblnotification(Integer notificationId, String notification, Date createddate, int status) {
        this.notificationId = notificationId;
        this.notification = notification;
        this.createddate = createddate;
        this.status = status;
    }

    public Integer getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Integer notificationId) {
        this.notificationId = notificationId;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Tbluser getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Tbluser fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Tbluser getUserId() {
        return userId;
    }

    public void setUserId(Tbluser userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notificationId != null ? notificationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblnotification)) {
            return false;
        }
        Tblnotification other = (Tblnotification) object;
        if ((this.notificationId == null && other.notificationId != null) || (this.notificationId != null && !this.notificationId.equals(other.notificationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tblnotification[ notificationId=" + notificationId + " ]";
    }
    
}
