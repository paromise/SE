package se.customs.UsersManagement.dao;

import java.util.ArrayList;
import se.customs.config.HibernateConnector;
import se.customs.UsersManagement.pojo.CustomsUser;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import se.customs.EconomicMinisRepres.dao.RoleDAO;
import se.customs.EconomicMinisRepres.pojo.Role;

/**
 *
 * @author faeze
 */
public class CustomsUserDAO {
    public CustomsUserDAO(){
        
        CustomsUser user = this.findUserById("CU");
        RoleDAO rdao=new RoleDAO();
        ArrayList<Role> role=(ArrayList<Role>) rdao.listRole();
        if(role==null){
            rdao.addRole(new Role("CustomsUndertaker"));
            rdao.addRole(new Role("EconomicMinisRepres"));
            rdao.addRole(new Role("LicenseUndertaker"));
        }
        if(user==null){
            this.addUser(new CustomsUser("CU", "123", "CustomsUndertaker"));
            this.addUser(new CustomsUser("EMR", "123", "EconomicMinisRepres"));
            this.addUser(new CustomsUser("LU", "234", "LicenseUndertaker"));
        }
       
        
    }
    public List<CustomsUser> listUser() {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from CustomsUser u");

            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                System.out.println("list " + queryList);
                return (List<CustomsUser>) queryList;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public CustomsUser findUserById(String username) {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from CustomsUser u where u.username = :username");
            query.setParameter("username", username);

            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                return (CustomsUser) queryList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    
    public String findRoleById(String username) {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("select u.role from CustomsUser u "
                    + "where u.username = :username");
            query.setParameter("username", username);

            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                return (String) queryList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public void updateUser(CustomsUser user) {
        Session session = null;
        Transaction tx=null;
        try {
            session = HibernateConnector.getInstance().getSession();
            tx=session.beginTransaction();
            session.saveOrUpdate(user);
            tx.commit();
            session.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public CustomsUser addUser(CustomsUser user) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            System.out.println("session : "+session);
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
    }

    public void deleteUser(String username) {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Transaction beginTransaction = session.beginTransaction();
            Query createQuery = session.createQuery("delete from CustomsUser u where u.username =:username");
            createQuery.setParameter("username",username);
            createQuery.executeUpdate();
            beginTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
