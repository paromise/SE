package se.customs.service;

import se.customs.UsersManagement.dao.CustomsUserDAO;
import se.customs.UsersManagement.pojo.CustomsUser;
import java.util.List;
import se.customs.UIManagement.UIManager;

public class DbOperations {

    CustomsUserDAO customsUserDao = new CustomsUserDAO();


    public CustomsUser createUser() {
        CustomsUser s = new CustomsUser();
        s.setUsername("faee");
        s.setPassword("1234");
        customsUserDao.addUser(s);
        return s;
    }

    public void updateUser(String username) {
        CustomsUser user =  customsUserDao.findUserById(username);
        user.setUsername("online tutorials point");
        customsUserDao.updateUser(user);
        System.out.println("User Updated Success");
    }

    public void deleteUser(String username) {
        customsUserDao.deleteUser(username);
        System.out.println("User Deleted Success");
    }

    public List<CustomsUser> getUserList() {
        return  customsUserDao.listUser();
    }

    public CustomsUser getUser(String username) {
        return customsUserDao.findUserById(username);
    }

}
