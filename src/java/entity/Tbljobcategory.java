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
@Table(name = "tbljobcategory")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbljobcategory.findAll", query = "SELECT t FROM Tbljobcategory t"),
    @NamedQuery(name = "Tbljobcategory.findByJobCategoryId", query = "SELECT t FROM Tbljobcategory t WHERE t.jobCategoryId = :jobCategoryId"),
    @NamedQuery(name = "Tbljobcategory.findByJobCategoryName", query = "SELECT t FROM Tbljobcategory t WHERE t.jobCategoryName = :jobCategoryName")})
public class Tbljobcategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "jobCategoryId")
    private Integer jobCategoryId;
    @Basic(optional = false)
    @Column(name = "jobCategoryName")
    private String jobCategoryName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobCategoryId")
    private Collection<Tbljobsubcategory> tbljobsubcategoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobCategoryId")
    private Collection<Tbluser> tbluserCollection;

    public Tbljobcategory() {
    }

    public Tbljobcategory(Integer jobCategoryId) {
        this.jobCategoryId = jobCategoryId;
    }

    public Tbljobcategory(Integer jobCategoryId, String jobCategoryName) {
        this.jobCategoryId = jobCategoryId;
        this.jobCategoryName = jobCategoryName;
    }

    public Integer getJobCategoryId() {
        return jobCategoryId;
    }

    public void setJobCategoryId(Integer jobCategoryId) {
        this.jobCategoryId = jobCategoryId;
    }

    public String getJobCategoryName() {
        return jobCategoryName;
    }

    public void setJobCategoryName(String jobCategoryName) {
        this.jobCategoryName = jobCategoryName;
    }

    @JsonbTransient
    public Collection<Tbljobsubcategory> getTbljobsubcategoryCollection() {
        return tbljobsubcategoryCollection;
    }

    public void setTbljobsubcategoryCollection(Collection<Tbljobsubcategory> tbljobsubcategoryCollection) {
        this.tbljobsubcategoryCollection = tbljobsubcategoryCollection;
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
        hash += (jobCategoryId != null ? jobCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbljobcategory)) {
            return false;
        }
        Tbljobcategory other = (Tbljobcategory) object;
        if ((this.jobCategoryId == null && other.jobCategoryId != null) || (this.jobCategoryId != null && !this.jobCategoryId.equals(other.jobCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tbljobcategory[ jobCategoryId=" + jobCategoryId + " ]";
    }
    
}
