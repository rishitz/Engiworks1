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
@Table(name = "tblMessage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblMessage.findAll", query = "SELECT t FROM TblMessage t"),
    @NamedQuery(name = "TblMessage.findByMessageId", query = "SELECT t FROM TblMessage t WHERE t.messageId = :messageId"),
    @NamedQuery(name = "TblMessage.findByMessage", query = "SELECT t FROM TblMessage t WHERE t.message = :message"),
    @NamedQuery(name = "TblMessage.findByCreatedDate", query = "SELECT t FROM TblMessage t WHERE t.createdDate = :createdDate")})
public class TblMessage implements Serializable {

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
    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "toUserId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private Tbluser toUserId;
    @JoinColumn(name = "fromUserId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private Tbluser fromUserId;
    @JoinColumn(name = "requirementId", referencedColumnName = "requirementId")
    @ManyToOne(optional = false)
    private Tblrequirement requirementId;

    public TblMessage() {
    }

    public TblMessage(Integer messageId) {
        this.messageId = messageId;
    }

    public TblMessage(Integer messageId, String message, Date createdDate) {
        this.messageId = messageId;
        this.message = message;
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

    public Tblrequirement getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(Tblrequirement requirementId) {
        this.requirementId = requirementId;
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
        if (!(object instanceof TblMessage)) {
            return false;
        }
        TblMessage other = (TblMessage) object;
        if ((this.messageId == null && other.messageId != null) || (this.messageId != null && !this.messageId.equals(other.messageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblMessage[ messageId=" + messageId + " ]";
    }
    
}
