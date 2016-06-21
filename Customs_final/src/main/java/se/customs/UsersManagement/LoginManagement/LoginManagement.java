/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.customs.UsersManagement.LoginManagement;

import se.customs.UsersManagement.dao.CustomsUserDAO;
import se.customs.UsersManagement.pojo.CustomsUser;

/**
 *
 * @author faeze
 */
public class LoginManagement {
    CustomsUserDAO customsUserDao = new CustomsUserDAO();
    public boolean is_in_users(String username){
        CustomsUser user =  customsUserDao.findUserById(username);
        return user==null;
    }
    
    public boolean is_authenticated(String username,String passwd){
          
        CustomsUser user =  customsUserDao.findUserById(username);
        if(user==null)
            return false;
        
        if(user.getPassword().equals(passwd)){
            return true;
        }
        else{
            return false;
        }  
    }
    
    public String getRole(String username){
        CustomsUser user =  customsUserDao.findUserById(username);
        return user.getRole();
    }
    
}
