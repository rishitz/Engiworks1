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
@Table(name = "tbljobsubcategory")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbljobsubcategory.findAll", query = "SELECT t FROM Tbljobsubcategory t"),
    @NamedQuery(name = "Tbljobsubcategory.findByJobSubCategoryId", query = "SELECT t FROM Tbljobsubcategory t WHERE t.jobSubCategoryId = :jobSubCategoryId"),
    @NamedQuery(name = "Tbljobsubcategory.findByJobSubCategoryName", query = "SELECT t FROM Tbljobsubcategory t WHERE t.jobSubCategoryName = :jobSubCategoryName")})
public class Tbljobsubcategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "jobSubCategoryId")
    private Integer jobSubCategoryId;
    @Basic(optional = false)
    @Column(name = "jobSubCategoryName")
    private String jobSubCategoryName;
    @JoinColumn(name = "jobCategoryId", referencedColumnName = "jobCategoryId")
    @ManyToOne(optional = false)
    private Tbljobcategory jobCategoryId;

    public Tbljobsubcategory() {
    }

    public Tbljobsubcategory(Integer jobSubCategoryId) {
        this.jobSubCategoryId = jobSubCategoryId;
    }

    public Tbljobsubcategory(Integer jobSubCategoryId, String jobSubCategoryName) {
        this.jobSubCategoryId = jobSubCategoryId;
        this.jobSubCategoryName = jobSubCategoryName;
    }

    public Integer getJobSubCategoryId() {
        return jobSubCategoryId;
    }

    public void setJobSubCategoryId(Integer jobSubCategoryId) {
        this.jobSubCategoryId = jobSubCategoryId;
    }

    public String getJobSubCategoryName() {
        return jobSubCategoryName;
    }

    public void setJobSubCategoryName(String jobSubCategoryName) {
        this.jobSubCategoryName = jobSubCategoryName;
    }

    public Tbljobcategory getJobCategoryId() {
        return jobCategoryId;
    }

    public void setJobCategoryId(Tbljobcategory jobCategoryId) {
        this.jobCategoryId = jobCategoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobSubCategoryId != null ? jobSubCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbljobsubcategory)) {
            return false;
        }
        Tbljobsubcategory other = (Tbljobsubcategory) object;
        if ((this.jobSubCategoryId == null && other.jobSubCategoryId != null) || (this.jobSubCategoryId != null && !this.jobSubCategoryId.equals(other.jobSubCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tbljobsubcategory[ jobSubCategoryId=" + jobSubCategoryId + " ]";
    }
    
}
