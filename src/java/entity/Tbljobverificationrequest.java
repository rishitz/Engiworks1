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
@Table(name = "tbljobverificationrequest")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbljobverificationrequest.findAll", query = "SELECT t FROM Tbljobverificationrequest t"),
    @NamedQuery(name = "Tbljobverificationrequest.findByVerificationRequestId", query = "SELECT t FROM Tbljobverificationrequest t WHERE t.verificationRequestId = :verificationRequestId"),
    @NamedQuery(name = "Tbljobverificationrequest.findByStatus", query = "SELECT t FROM Tbljobverificationrequest t WHERE t.status = :status"),
    @NamedQuery(name = "Tbljobverificationrequest.findByCreatedDate", query = "SELECT t FROM Tbljobverificationrequest t WHERE t.createdDate = :createdDate")})
public class Tbljobverificationrequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VerificationRequestId")
    private Integer verificationRequestId;
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

    public Tbljobverificationrequest() {
    }

    public Tbljobverificationrequest(Integer verificationRequestId) {
        this.verificationRequestId = verificationRequestId;
    }

    public Tbljobverificationrequest(Integer verificationRequestId, int status, Date createdDate) {
        this.verificationRequestId = verificationRequestId;
        this.status = status;
        this.createdDate = createdDate;
    }

    public Integer getVerificationRequestId() {
        return verificationRequestId;
    }

    public void setVerificationRequestId(Integer verificationRequestId) {
        this.verificationRequestId = verificationRequestId;
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
        hash += (verificationRequestId != null ? verificationRequestId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbljobverificationrequest)) {
            return false;
        }
        Tbljobverificationrequest other = (Tbljobverificationrequest) object;
        if ((this.verificationRequestId == null && other.verificationRequestId != null) || (this.verificationRequestId != null && !this.verificationRequestId.equals(other.verificationRequestId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tbljobverificationrequest[ verificationRequestId=" + verificationRequestId + " ]";
    }
    
}
