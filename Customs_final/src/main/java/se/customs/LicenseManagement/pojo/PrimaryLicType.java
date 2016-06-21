/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.customs.LicenseManagement.pojo;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author faeze
 */
@Entity
@Table(name = "PrimaryLicType", catalog = "se")
public class PrimaryLicType implements java.io.Serializable{
    

    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name="primLicTypeID", nullable = false)
    private Integer primLicTypeID;
    
   
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "undertaker", nullable = false)
    private String undertaker;
    
     public PrimaryLicType(){
         
     }
    
    public PrimaryLicType(String name, String undertaker) {
        this.name = name;
        this.undertaker = undertaker;
    }

    public Integer getPrimLicTypeID() {
        return primLicTypeID;
    }

    public void setPrimLicTypeID(Integer primLicTypeID) {
        this.primLicTypeID = primLicTypeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUndertaker() {
        return undertaker;
    }

    public void setUndertaker(String undertaker) {
        this.undertaker = undertaker;
    }
    
    @OneToMany(mappedBy="primLicType", cascade = CascadeType.ALL)
    private List<LicenseType> licTypes;
}
