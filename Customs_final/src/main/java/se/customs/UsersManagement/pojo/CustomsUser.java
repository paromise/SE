package se.customs.UsersManagement.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import se.customs.EconomicMinisRepres.pojo.Role;

@Entity
@Table(name = "CustomsUser", catalog = "se"
)
public class CustomsUser implements java.io.Serializable{



  
    @Id
    @Column(name = "username", unique = true, nullable = false)
    private String username;
    @Column(name = "password", length = 50, nullable = false)
    private String password;
    @Column(name = "role", length = 50, nullable = false)
    private String role;
    
    public CustomsUser() {
    }

    public CustomsUser(String username, String password, String role){
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRole() {
        return role;
    }
    

    public void setRole(String role) {
        this.role = role;
    }
    
    @ManyToOne
    @JoinColumn(name = "role",referencedColumnName = "userRole",insertable=false,updatable=false)
    private Role ro;
    
   
}
