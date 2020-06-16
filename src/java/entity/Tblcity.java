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
@Table(name = "tblcity")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblcity.findAll", query = "SELECT t FROM Tblcity t"),
    @NamedQuery(name = "Tblcity.findByCityId", query = "SELECT t FROM Tblcity t WHERE t.cityId = :cityId"),
    @NamedQuery(name = "Tblcity.findByCityName", query = "SELECT t FROM Tblcity t WHERE t.cityName = :cityName")})
public class Tblcity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cityId")
    private Integer cityId;
    @Basic(optional = false)
    @Column(name = "cityName")
    private String cityName;
    @JoinColumn(name = "stateId", referencedColumnName = "stateId")
    @ManyToOne(optional = false)
    private Tblstate stateId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityId")
    private Collection<Tbluser> tbluserCollection;

    public Tblcity() {
    }

    public Tblcity(Integer cityId) {
        this.cityId = cityId;
    }

    public Tblcity(Integer cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Tblstate getStateId() {
        return stateId;
    }

    public void setStateId(Tblstate stateId) {
        this.stateId = stateId;
    }

    @JsonbTransient
    public Collection<Tbluser> getTbluserCollection() {
        return tbluserCollection;
    }

    public void setTbluserCollection(Collection<Tbluser> tbluserCollection) {
        this.tbluserCollection = tbluserCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cityId != null ? cityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblcity)) {
            return false;
        }
        Tblcity other = (Tblcity) object;
        if ((this.cityId == null && other.cityId != null) || (this.cityId != null && !this.cityId.equals(other.cityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tblcity[ cityId=" + cityId + " ]";
    }
    
}
