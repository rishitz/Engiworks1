/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebatsian
 */
@Entity
@Table(name = "tblbidassigned")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblbidassigned.findAll", query = "SELECT t FROM Tblbidassigned t"),
    @NamedQuery(name = "Tblbidassigned.findByBidAssignedId", query = "SELECT t FROM Tblbidassigned t WHERE t.bidAssignedId = :bidAssignedId")})
public class Tblbidassigned implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bidAssignedId")
    private Integer bidAssignedId;
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private Tbluser userId;
    @JoinColumn(name = "requirementBidId", referencedColumnName = "requirementBidId")
    @ManyToOne(optional = false)
    private Tblrequirementbid requirementBidId;

    public Tblbidassigned() {
    }

    public Tblbidassigned(Integer bidAssignedId) {
        this.bidAssignedId = bidAssignedId;
    }

    public Integer getBidAssignedId() {
        return bidAssignedId;
    }

    public void setBidAssignedId(Integer bidAssignedId) {
        this.bidAssignedId = bidAssignedId;
    }

    public Tbluser getUserId() {
        return userId;
    }

    public void setUserId(Tbluser userId) {
        this.userId = userId;
    }

    public Tblrequirementbid getRequirementBidId() {
        return requirementBidId;
    }

    public void setRequirementBidId(Tblrequirementbid requirementBidId) {
        this.requirementBidId = requirementBidId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bidAssignedId != null ? bidAssignedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblbidassigned)) {
            return false;
        }
        Tblbidassigned other = (Tblbidassigned) object;
        if ((this.bidAssignedId == null && other.bidAssignedId != null) || (this.bidAssignedId != null && !this.bidAssignedId.equals(other.bidAssignedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tblbidassigned[ bidAssignedId=" + bidAssignedId + " ]";
    }
    
}
