/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.customs.EconomicMinisRepres.pojo;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import se.customs.LicenseManagement.pojo.LicenseType;

/**
 *
 * @author faeze
 */
@Entity
@Table(name = "Rule", catalog = "se")

public class Rule implements java.io.Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name="ruleID", nullable = false)
    private Integer ruleID;
    
    @Column(name = "prodType", nullable = false)
    private String prodType;
    
    @Column(name = "minAmount")
    private Integer minAmount;

    @Column(name = "minPrice")
    private Integer minPrice;
    
    @Column(name = "maxAmount")
    private Integer maxAmount;
    
    @Column(name = "maxPrice")
    private Integer maxPrice;
    
    @Column(name = "unit")
    private String unit;
    
    @Column(name = "country")
    private String country;   
   
    @Column(name = "transWay")
    private String transWay;
    
    @Column(name = "company")
    private String company;

    @Column(name = "totalVal")
    private Integer totalVal;

    

    public Rule(){
        
    }

    public Rule( String prodType, Integer minAmount, Integer minPrice
            , Integer maxAmount, Integer maxPrice, String unit,
                String country, String transWay, String company,Integer totalVal) {
        
      
        this.prodType = prodType;
        this.minAmount = (minAmount==-1) ? 0 : minAmount;
        this.minPrice = (minPrice==-1) ? 0 : minPrice;
        this.maxAmount = (maxAmount==-1) ? Integer.MAX_VALUE : maxAmount;
        this.maxPrice = (maxPrice==-1) ? Integer.MAX_VALUE : maxPrice;
        this.unit = unit;
        this.country=country;
        this.transWay=transWay;
        this.company=company;
        this.totalVal=(totalVal==-1) ? Integer.MAX_VALUE : totalVal;
        
    }
    
    public Integer getRuleID() {
        return ruleID;
    }

    public void setRuleID(Integer ruleID) {
        this.ruleID = ruleID;
    }

    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public Integer getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Integer minAmount) throws Exception {
        if(minAmount<0){
            throw new Exception("این مقدار نمی تواند منفی باشد*‌");
        }
        else
            this.minAmount = minAmount;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) throws Exception {
        if(minPrice<0){
            throw new Exception("این مقدار نمی تواند منفی باشد*‌");
        }
        else
            this.minPrice = minPrice;
    }

    public Integer getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Integer maxAmount) throws Exception {
        if(maxAmount<0){
            throw new Exception("این مقدار نمی تواند منفی باشد*‌");
        }
        else
            this.maxAmount = maxAmount;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) throws Exception {
        if(maxPrice<0){
            throw new Exception("این مقدار نمی تواند منفی باشد*‌");
        }
        else
            this.maxPrice = maxPrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTransWay() {
        return transWay;
    }

    public void setTransWay(String transWay) throws Exception{
        if(!(transWay.equals("zamini") || transWay.equals("havaii")
                || transWay.equals("daryayi")))
            throw new Exception("*نوع انتقال وارد شده معتبر نمی باشد");
        else
            this.transWay = transWay;
    }
    
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
   
    public Integer getTotalVal() {
         return totalVal;
    }

    public void setTotalVal(Integer totalVal) throws Exception {
        if(totalVal<0){
            throw new Exception("این مقدار نمی تواند منفی باشد*‌");
        }
        else
            this.totalVal = totalVal;
        
    }
    
    
    @OneToMany(mappedBy="rule", cascade = CascadeType.ALL)
    private List<LicenseType> licTypes;

    
}
