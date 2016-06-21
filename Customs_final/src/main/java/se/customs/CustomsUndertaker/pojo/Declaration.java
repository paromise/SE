/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.customs.CustomsUndertaker.pojo;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import se.customs.LicenseManagement.pojo.License;
/**
 *
 * @author faeze
 */

@Entity
@Table(name = "Declaration", catalog = "se")
public class Declaration  implements java.io.Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name="declID", nullable = false)
    private Integer declID;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "family", nullable = false)
    private String family;
    
    @Column(name = "nationalId", unique = true ,nullable = false)
    private String nationalId;
    
   
    @Column(name = "declarationDate" ,nullable = false)
    private String declarationDate;
    
    
    @Column(name = "srcCountry",nullable = false)
    private String srcCountry;
    
    @Column(name = "totalValue",nullable = false)
    private float totalValue;
    
    @Column(name = "transWay",nullable = false)
    private String transWay;
    
    @Column(name = "validity",nullable = false)
    private String validity;

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }
    
    
    public Declaration(){
        
    }
     
    public Declaration(String name, String family, String nationalId
                        , String declarationDate
                        , String srcCountry, String transWay, String validity) {
        this.name = name;
        this.family = family;
        this.nationalId = nationalId;
        this.declarationDate = declarationDate;
        this.srcCountry = srcCountry;
        this.transWay = transWay;
        this.totalValue = 0;
        this.validity = validity;
    }

    public Integer getDeclID() {
        return declID;
    }

    public void setDeclID(Integer declID) {
        this.declID = declID;
    }
    
    public String getTransWay() {
        return transWay;
    }

    public void setTransWay(String transWay) {
        this.transWay = transWay;
    }
   

   

    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getDeclarationDate() {
        return declarationDate;
    }

    public void setDeclarationDate(String declarationDate) {
        this.declarationDate = declarationDate;
    }
    
    public Declaration addTotalValue(float val){
        System.out.println("Total Before : "+totalValue+" Val : "+val);
        this.totalValue=this.totalValue+val;
        System.out.println("Total After : "+totalValue);
        return this;
    }
    
    public Declaration withdrawTotalValue(float val){
        System.out.println("Total Before : "+totalValue+" Val : "+val);
        this.totalValue=this.totalValue-val;
        System.out.println("Total After : "+totalValue);
        return this;
    }
    public float getTotalValue() {
         System.out.println("Declaration/getTotalVal :"+this.totalValue);
        return this.totalValue;
    }

    public void setTotalValue(float totalValue) {
        this.totalValue = totalValue;
    }
    
    public String getSrcCountry() {
        return srcCountry;
    }

    public void setSrcCountry(String srcCountry) {
        this.srcCountry = srcCountry;
    }
    
    public Declaration validate(){
        this.validity = "valid";
        return this;
    }
    
    @OneToMany(mappedBy="declaration", cascade = CascadeType.ALL)
    private List<Product> products;

    
}
