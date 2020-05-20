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
@Table(name = "tbllikes")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbllikes.findAll", query = "SELECT t FROM Tbllikes t"),
    @NamedQuery(name = "Tbllikes.findByLikeId", query = "SELECT t FROM Tbllikes t WHERE t.likeId = :likeId")})
public class Tbllikes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "likeId")
    private Integer likeId;
    @JoinColumn(name = "achievementId", referencedColumnName = "achievementId")
    @ManyToOne(optional = false)
    private Tblachievement achievementId;
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private Tbluser userId;

    public Tbllikes() {
    }

    public Tbllikes(Integer likeId) {
        this.likeId = likeId;
    }

    public Integer getLikeId() {
        return likeId;
    }

    public void setLikeId(Integer likeId) {
        this.likeId = likeId;
    }

    public Tblachievement getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Tblachievement achievementId) {
        this.achievementId = achievementId;
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
        hash += (likeId != null ? likeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbllikes)) {
            return false;
        }
        Tbllikes other = (Tbllikes) object;
        if ((this.likeId == null && other.likeId != null) || (this.likeId != null && !this.likeId.equals(other.likeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tbllikes[ likeId=" + likeId + " ]";
    }
    
}
