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
@Table(name = "tblrequirement")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblrequirement.findAll", query = "SELECT t FROM Tblrequirement t"),
    @NamedQuery(name = "Tblrequirement.findByRequirementId", query = "SELECT t FROM Tblrequirement t WHERE t.requirementId = :requirementId"),
    @NamedQuery(name = "Tblrequirement.findByTitle", query = "SELECT t FROM Tblrequirement t WHERE t.title = :title"),
    @NamedQuery(name = "Tblrequirement.findByDescription", query = "SELECT t FROM Tblrequirement t WHERE t.description = :description"),
    @NamedQuery(name = "Tblrequirement.findByStatus", query = "SELECT t FROM Tblrequirement t WHERE t.status = :status"),
    @NamedQuery(name = "Tblrequirement.findByCreatedDate", query = "SELECT t FROM Tblrequirement t WHERE t.createdDate = :createdDate"),
    @NamedQuery(name = "Tblrequirement.findByBudget", query = "SELECT t FROM Tblrequirement t WHERE t.budget = :budget"),
    @NamedQuery(name = "Tblrequirement.findByDuration", query = "SELECT t FROM Tblrequirement t WHERE t.duration = :duration"),
    @NamedQuery(name = "Tblrequirement.findByPdf", query = "SELECT t FROM Tblrequirement t WHERE t.pdf = :pdf")})
public class Tblrequirement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "requirementId")
    private Integer requirementId;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @Column(name = "createdDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @Column(name = "budget")
    private float budget;
    @Basic(optional = false)
    @Column(name = "duration")
    private int duration;
    @Basic(optional = false)
    @Column(name = "pdf")
    private String pdf;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requirementId")
    private Collection<Tblrequirementbid> tblrequirementbidCollection;
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private Tbluser userId;

    public Tblrequirement() {
    }

    public Tblrequirement(Integer requirementId) {
        this.requirementId = requirementId;
    }

    public Tblrequirement(Integer requirementId, String title, String description, int status, Date createdDate, float budget, int duration, String pdf) {
        this.requirementId = requirementId;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdDate = createdDate;
        this.budget = budget;
        this.duration = duration;
        this.pdf = pdf;
    }

    public Integer getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(Integer requirementId) {
        this.requirementId = requirementId;
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

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    @JsonbTransient
    public Collection<Tblrequirementbid> getTblrequirementbidCollection() {
        return tblrequirementbidCollection;
    }

    public void setTblrequirementbidCollection(Collection<Tblrequirementbid> tblrequirementbidCollection) {
        this.tblrequirementbidCollection = tblrequirementbidCollection;
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
        hash += (requirementId != null ? requirementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblrequirement)) {
            return false;
        }
        Tblrequirement other = (Tblrequirement) object;
        if ((this.requirementId == null && other.requirementId != null) || (this.requirementId != null && !this.requirementId.equals(other.requirementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tblrequirement[ requirementId=" + requirementId + " ]";
    }
    
}
