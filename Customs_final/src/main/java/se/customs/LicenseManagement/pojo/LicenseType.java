/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.customs.LicenseManagement.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import se.customs.EconomicMinisRepres.pojo.Rule;

/**
 *
 * @author faeze
 */
@Entity
@Table(name = "LicenseType", catalog = "se")
    public class LicenseType implements java.io.Serializable{

    @Id
    @Column(name="ruleID",nullable=false)
    private Integer ruleID;

    @Id
    @Column(name="primLicTypeID",nullable=false)
    private Integer primLicTypeID;

   
    public LicenseType(){
        
    }
   
    public LicenseType(Integer ruleID,Integer primLicTypeID) {
        
        this.ruleID = ruleID;
        this.primLicTypeID=primLicTypeID;
    }
    
   
    public Integer getRuleID() {
        return ruleID;
    }

    public void setRuleID(Integer ruleID) {
        this.ruleID = ruleID;
    }
    
     public Integer getPrimLicTypeID() {
        return primLicTypeID;
    }

    public void setPrimLicTypeID(Integer primLicTypeID) {
        this.primLicTypeID = primLicTypeID;
    }
    
    
    
    @ManyToOne
    @JoinColumn(name="ruleID",referencedColumnName = "ruleID", insertable = false, updatable = false)
    private Rule rule;
    
    @ManyToOne
    @JoinColumn(name="primLicTypeID",referencedColumnName = "primLicTypeID", insertable = false, updatable = false)
    private PrimaryLicType primLicType;
}
