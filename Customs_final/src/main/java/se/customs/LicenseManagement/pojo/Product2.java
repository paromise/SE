/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.customs.LicenseManagement.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 *
 * @author parmiss
 */

@Entity
@Table(name = "Product2", catalog = "se")
public class Product2 implements  java.io.Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name = "proId", nullable = false)
    private Integer proId;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "company", nullable = false)
    private String company;
    
    @Column(name = "max_weight", nullable = false)
    private Float max_weight;
    
     
    @Column(name = "min_unitPrice", nullable = false)
    private Integer min_unitPrice;
    
    @Column(name = "max_unitPrice", nullable = false)
    private Integer max_unitPrice;
    
    @Column(name = "licID", nullable = false)
    private Integer licID;
    
    @ManyToOne
    @JoinColumn(name="licID",referencedColumnName = "licNum", insertable = false, updatable = false)
    private License license;
    
    public Product2(){
    
    }
    
    public Product2(String name, String company, Float max_weight, Integer min_unitPrice, Integer max_unitPrice, Integer licID) {
        this.name = name;
        this.company = company;
        this.max_weight = max_weight;
        this.min_unitPrice = min_unitPrice;
        this.max_unitPrice = max_unitPrice;
        this.licID = licID;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Float getMax_weight() {
        return max_weight;
    }

    public void setMax_weight(Float max_weight) {
        this.max_weight = max_weight;
    }



    public Integer getMin_unitPrice() {
        return min_unitPrice;
    }

    public void setMin_unitPrice(Integer min_unitPrice) {
        this.min_unitPrice = min_unitPrice;
    }

    public Integer getMax_unitPrice() {
        return max_unitPrice;
    }

    public void setMax_unitPrice(Integer max_unitPrice) {
        this.max_unitPrice = max_unitPrice;
    }

    public Integer getLicID() {
        return licID;
    }

    public void setLicID(Integer licID) {
        this.licID = licID;
    }    
}
