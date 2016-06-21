/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.customs.EconomicMinisRepres.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import se.customs.UsersManagement.pojo.CustomsUser;

/**
 *
 * @author golrokh
 */

@Entity
@Table(name = "Role", catalog = "se")

public class Role implements Serializable {

    public Role(String userRole) {
        this.userRole = userRole;
    }
    
    public Role(){
    }
    
    @Id
    @Column(name = "userRole", nullable = false)
    private String userRole;

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
    
    
    @OneToMany(mappedBy="ro", cascade = CascadeType.ALL)
    private List<CustomsUser> users;
}
