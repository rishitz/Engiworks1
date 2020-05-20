/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sebatsian
 */
@Entity
@Table(name = "tblattachement")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblattachement.findAll", query = "SELECT t FROM Tblattachement t"),
    @NamedQuery(name = "Tblattachement.findByAttachementId", query = "SELECT t FROM Tblattachement t WHERE t.attachementId = :attachementId"),
    @NamedQuery(name = "Tblattachement.findByAttachmenet", query = "SELECT t FROM Tblattachement t WHERE t.attachmenet = :attachmenet")})
public class Tblattachement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "attachementId")
    private Integer attachementId;
    @Basic(optional = false)
    @Column(name = "attachmenet")
    private String attachmenet;
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @ManyToOne(optional = false)
    private Tbluser userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "attechementId")
    private Collection<Tblachievement> tblachievementCollection;

    public Tblattachement() {
    }

    public Tblattachement(Integer attachementId) {
        this.attachementId = attachementId;
    }

    public Tblattachement(Integer attachementId, String attachmenet) {
        this.attachementId = attachementId;
        this.attachmenet = attachmenet;
    }

    public Integer getAttachementId() {
        return attachementId;
    }

    public void setAttachementId(Integer attachementId) {
        this.attachementId = attachementId;
    }

    public String getAttachmenet() {
        return attachmenet;
    }

    public void setAttachmenet(String attachmenet) {
        this.attachmenet = attachmenet;
    }

    public Tbluser getUserId() {
        return userId;
    }

    public void setUserId(Tbluser userId) {
        this.userId = userId;
    }

    @JsonbTransient
    public Collection<Tblachievement> getTblachievementCollection() {
        return tblachievementCollection;
    }

    public void setTblachievementCollection(Collection<Tblachievement> tblachievementCollection) {
        this.tblachievementCollection = tblachievementCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (attachementId != null ? attachementId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblattachement)) {
            return false;
        }
        Tblattachement other = (Tblattachement) object;
        if ((this.attachementId == null && other.attachementId != null) || (this.attachementId != null && !this.attachementId.equals(other.attachementId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tblattachement[ attachementId=" + attachementId + " ]";
    }
    
}
