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
import javax.persistence.Transient;
import se.customs.CustomsUndertaker.pojo.Declaration;

/**
 *
 * @author faeze
 */


@Entity
@Table(name = "License", catalog = "se")
public class License {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name = "licNum", nullable = false)
    private Integer licNum;
    
    @Column(name = "merchantID", nullable = false)
    private String merchantID;
    
    @Column(name = "dueDate", nullable = false)
    private String dueDate;
    
    @Column(name = "licName", nullable = false)
    private String licName;
    
    @Column(name = "srcCountry")
    private String srcCountry;
    
    @Column(name = "transWay", nullable = false)
    private String transWay;
    
    @Transient
    private String status;


 
    public License(){
        
    }
    

    public License(String merchantID, String dueDate, String licName, String srcCountry, String transWay) {
        this.merchantID = merchantID;
        this.dueDate = dueDate;
        this.licName = licName;
        this.srcCountry = srcCountry;
        this.transWay = transWay;
        this.status="invalid";
    }
    
    
    
    public String getLicName() {
        return licName;
    }

    public void setLicName(String licName) {
        this.licName = licName;
    }
    
    public String getMerchantID() {
        return merchantID;
    }

    public void setMerchantID(String merchantID) {
        this.merchantID = merchantID;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getLicNum() {
        return licNum;
    }

    public void setLicNum(Integer licNum) {
        this.licNum = licNum;
    }
    
    public String getSrcCountry() {
        return srcCountry;
    }
    
    public void setSrcCountry(String srcCountry) {
        this.srcCountry = srcCountry;
    }
    
    public String getTransWay() {
        return transWay;
    }
    
    public void setTransWay(String transWay) {
        this.transWay = transWay;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
       
   
   
   
}