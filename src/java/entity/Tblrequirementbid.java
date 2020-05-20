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
@Table(name = "tblrequirementbid")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblrequirementbid.findAll", query = "SELECT t FROM Tblrequirementbid t"),
    @NamedQuery(name = "Tblrequirementbid.findByRequirementBidId", query = "SELECT t FROM Tblrequirementbid t WHERE t.requirementBidId = :requirementBidId"),
    @NamedQuery(name = "Tblrequirementbid.findByDescription", query = "SELECT t FROM Tblrequirementbid t WHERE t.description = :description"),
    @NamedQuery(name = "Tblrequirementbid.findByBudget", query = "SELECT t FROM Tblrequirementbid t WHERE t.budget = :budget"),
    @NamedQuery(name = "Tblrequirementbid.findByUserId", query = "SELECT t FROM Tblrequirementbid t WHERE t.userId = :userId"),
    @NamedQuery(name = "Tblrequirementbid.findByCreatedDate", query = "SELECT t FROM Tblrequirementbid t WHERE t.createdDate = :createdDate"),
    @NamedQuery(name = "Tblrequirementbid.findByStatus", query = "SELECT t FROM Tblrequirementbid t WHERE t.status = :status"),
    @NamedQuery(name = "Tblrequirementbid.findByEndingDate", query = "SELECT t FROM Tblrequirementbid t WHERE t.endingDate = :endingDate"),
    @NamedQuery(name = "Tblrequirementbid.findByDuration", query = "SELECT t FROM Tblrequirementbid t WHERE t.duration = :duration")})
public class Tblrequirementbid implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "requirementBidId")
    private Integer requirementBidId;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "budget")
    private float budget;
    @Basic(optional = false)
    @Column(name = "userId")
    private int userId;
    @Basic(optional = false)
    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @Column(name = "endingDate")
    @Temporal(TemporalType.DATE)
    private Date endingDate;
    @Basic(optional = false)
    @Column(name = "duration")
    private int duration;
    @JoinColumn(name = "requirementId", referencedColumnName = "requirementId")
    @ManyToOne(optional = false)
    private Tblrequirement requirementId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requirementBidId")
    private Collection<Tblbidassigned> tblbidassignedCollection;

    public Tblrequirementbid() {
    }

    public Tblrequirementbid(Integer requirementBidId) {
        this.requirementBidId = requirementBidId;
    }

    public Tblrequirementbid(Integer requirementBidId, String description, float budget, int userId, Date createdDate, int status, Date endingDate, int duration) {
        this.requirementBidId = requirementBidId;
        this.description = description;
        this.budget = budget;
        this.userId = userId;
        this.createdDate = createdDate;
        this.status = status;
        this.endingDate = endingDate;
        this.duration = duration;
    }

    public Integer getRequirementBidId() {
        return requirementBidId;
    }

    public void setRequirementBidId(Integer requirementBidId) {
        this.requirementBidId = requirementBidId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Tblrequirement getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(Tblrequirement requirementId) {
        this.requirementId = requirementId;
    }

    @JsonbTransient
    public Collection<Tblbidassigned> getTblbidassignedCollection() {
        return tblbidassignedCollection;
    }

    public void setTblbidassignedCollection(Collection<Tblbidassigned> tblbidassignedCollection) {
        this.tblbidassignedCollection = tblbidassignedCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requirementBidId != null ? requirementBidId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblrequirementbid)) {
            return false;
        }
        Tblrequirementbid other = (Tblrequirementbid) object;
        if ((this.requirementBidId == null && other.requirementBidId != null) || (this.requirementBidId != null && !this.requirementBidId.equals(other.requirementBidId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tblrequirementbid[ requirementBidId=" + requirementBidId + " ]";
    }
    
}
