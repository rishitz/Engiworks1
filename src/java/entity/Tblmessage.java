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
@Table(name = "tblmessage")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblmessage.findAll", query = "SELECT t FROM Tblmessage t"),
    @NamedQuery(name = "Tblmessage.findByMessageId", query = "SELECT t FROM Tblmessage t WHERE t.messageId = :messageId"),
    @NamedQuery(name = "Tblmessage.findByMessage", query = "SELECT t FROM Tblmessage t WHERE t.message = :message"),
    @NamedQuery(name = "Tblmessage.findByStatus", query = "SELECT t FROM Tblmessage t WHERE t.status = :status"),
    @NamedQuery(name = "Tblmessage.findByCreatedDate", query = "SELECT t FROM Tblmessage t WHERE t.createdDate = :createdDate")})
public class Tblmessage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "messageId")
    private Integer messageId;
    @Basic(optional = false)
    @Column(name = "message")
    private String message;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private Tbluser userId;

    public Tblmessage() {
    }

    public Tblmessage(Integer messageId) {
        this.messageId = messageId;
    }

    public Tblmessage(Integer messageId, String message, int status, Date createdDate) {
        this.messageId = messageId;
        this.message = message;
        this.status = status;
        this.createdDate = createdDate;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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
        hash += (messageId != null ? messageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblmessage)) {
            return false;
        }
        Tblmessage other = (Tblmessage) object;
        if ((this.messageId == null && other.messageId != null) || (this.messageId != null && !this.messageId.equals(other.messageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tblmessage[ messageId=" + messageId + " ]";
    }
    
}
