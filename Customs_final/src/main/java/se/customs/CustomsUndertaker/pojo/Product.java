/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.customs.CustomsUndertaker.pojo;


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
/**
 *
 * @author faeze
 */

@Entity
@Table(name = "Product", catalog = "se")
public class Product implements  java.io.Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name="proID", nullable = false)
    private Integer proID;

 
    
    @Column(name = "name", nullable = false)
    private String name;
    
    
    @Column(name = "company", nullable = false)
    private String company;
    
    @Column(name = "amount", nullable = false)
    private Float amount;
    
    @Column(name = "amountUnit", nullable = false)
    private String amountUnit;
    
    @Column(name = "unitPrice", nullable = false)
    private Integer unitPrice;
    
    @Column(name = "type", nullable = false)
    private String type;

    
    
    @Column(name = "DECLID", nullable = false)
    private Integer DECLID;
    
    
    public Product(){
        
    }
    
    public Product(String _name, String _company, float _amount, String _amountUnit,
                    int _unitPrice,Integer _declId,String _type){
        name=_name;
        type = _type;
        company=_company;
        amount=_amount;
        amountUnit=_amountUnit;
        unitPrice=_unitPrice;
        DECLID=_declId;
        
    }
    
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public Integer getProID() {
        return proID;
    }

    public void setProID(Integer proID) {
        this.proID = proID;
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

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getAmountUnit() {
        return amountUnit;
    }

    public void setAmountUnit(String amountUnit) {
        this.amountUnit = amountUnit;
    }

   
    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }
    
     
    public Integer getDECLID() {
        return DECLID;
    }

    public void setDECLID(Integer DECLID) {
        this.DECLID = DECLID;
    }

    
    
   
            
    @ManyToOne
    @JoinColumn(name="DECLID",referencedColumnName = "declID", insertable = false, updatable = false)
    private Declaration declaration;
}
