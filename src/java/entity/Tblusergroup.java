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
@Table(name = "tblusergroup")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblusergroup.findAll", query = "SELECT t FROM Tblusergroup t"),
    @NamedQuery(name = "Tblusergroup.findByUserGroupId", query = "SELECT t FROM Tblusergroup t WHERE t.userGroupId = :userGroupId")})
public class Tblusergroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userGroupId")
    private Integer userGroupId;
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private Tbluser userId;
    @JoinColumn(name = "groupId", referencedColumnName = "groupId")
    @ManyToOne(optional = false)
    private Tblgroup groupId;

    public Tblusergroup() {
    }

    public Tblusergroup(Integer userGroupId) {
        this.userGroupId = userGroupId;
    }

    public Integer getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(Integer userGroupId) {
        this.userGroupId = userGroupId;
    }

    public Tbluser getUserId() {
        return userId;
    }

    public void setUserId(Tbluser userId) {
        this.userId = userId;
    }

    public Tblgroup getGroupId() {
        return groupId;
    }

    public void setGroupId(Tblgroup groupId) {
        this.groupId = groupId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userGroupId != null ? userGroupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblusergroup)) {
            return false;
        }
        Tblusergroup other = (Tblusergroup) object;
        if ((this.userGroupId == null && other.userGroupId != null) || (this.userGroupId != null && !this.userGroupId.equals(other.userGroupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tblusergroup[ userGroupId=" + userGroupId + " ]";
    }
    
}
