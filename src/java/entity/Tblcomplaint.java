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
@Table(name = "tblcomplaint")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblcomplaint.findAll", query = "SELECT t FROM Tblcomplaint t"),
    @NamedQuery(name = "Tblcomplaint.findByComplaintId", query = "SELECT t FROM Tblcomplaint t WHERE t.complaintId = :complaintId"),
    @NamedQuery(name = "Tblcomplaint.findByComplaint", query = "SELECT t FROM Tblcomplaint t WHERE t.complaint = :complaint"),
    @NamedQuery(name = "Tblcomplaint.findByCreatedDate", query = "SELECT t FROM Tblcomplaint t WHERE t.createdDate = :createdDate"),
    @NamedQuery(name = "Tblcomplaint.findByStatus", query = "SELECT t FROM Tblcomplaint t WHERE t.status = :status")})
public class Tblcomplaint implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "complaintId")
    private Integer complaintId;
    @Basic(optional = false)
    @Column(name = "complaint")
    private String complaint;
    @Basic(optional = false)
    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private Tbluser userId;

    public Tblcomplaint() {
    }

    public Tblcomplaint(Integer complaintId) {
        this.complaintId = complaintId;
    }

    public Tblcomplaint(Integer complaintId, String complaint, Date createdDate, int status) {
        this.complaintId = complaintId;
        this.complaint = complaint;
        this.createdDate = createdDate;
        this.status = status;
    }

    public Integer getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Integer complaintId) {
        this.complaintId = complaintId;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
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

    public Tbluser getUserId() {
        return userId;
    }

    public void setUserId(Tbluser userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (complaintId != null ? complaintId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblcomplaint)) {
            return false;
        }
        Tblcomplaint other = (Tblcomplaint) object;
        if ((this.complaintId == null && other.complaintId != null) || (this.complaintId != null && !this.complaintId.equals(other.complaintId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tblcomplaint[ complaintId=" + complaintId + " ]";
    }
    
}
