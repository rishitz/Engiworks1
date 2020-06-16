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
@Table(name = "tblstate")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblstate.findAll", query = "SELECT t FROM Tblstate t"),
    @NamedQuery(name = "Tblstate.findByStateId", query = "SELECT t FROM Tblstate t WHERE t.stateId = :stateId"),
    @NamedQuery(name = "Tblstate.findByStateName", query = "SELECT t FROM Tblstate t WHERE t.stateName = :stateName")})
public class Tblstate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stateId")
    private Integer stateId;
    @Basic(optional = false)
    @Column(name = "stateName")
    private String stateName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateId")
    private Collection<Tblcity> tblcityCollection;

    public Tblstate() {
    }

    public Tblstate(Integer stateId) {
        this.stateId = stateId;
    }

    public Tblstate(Integer stateId, String stateName) {
        this.stateId = stateId;
        this.stateName = stateName;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @JsonbTransient
    public Collection<Tblcity> getTblcityCollection() {
        return tblcityCollection;
    }

    public void setTblcityCollection(Collection<Tblcity> tblcityCollection) {
        this.tblcityCollection = tblcityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stateId != null ? stateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblstate)) {
            return false;
        }
        Tblstate other = (Tblstate) object;
        if ((this.stateId == null && other.stateId != null) || (this.stateId != null && !this.stateId.equals(other.stateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tblstate[ stateId=" + stateId + " ]";
    }
    
}
