package se.customs.EconomicMinisRepres.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import se.customs.EconomicMinisRepres.pojo.Role;
import se.customs.config.HibernateConnector;

public class RoleDAO{
    
        public List<Role> listRole(){
		Session session = null;
		try {
		  session = HibernateConnector.getInstance().getSession();
		  Query query = session.createQuery("from Role r");
		 


		  List queryList = query.list();
		  if (queryList != null && queryList.isEmpty()) {
		      return null;
		  } else {
		      return (List<Role>) queryList;
		  }
		} catch (Exception e) {
		  e.printStackTrace();
		  return null;
		} finally {
		  session.close();
		}
	}
	public ArrayList<String> findRole(String ro){
		Session session = null;
		try {
		  session = HibernateConnector.getInstance().getSession();
		  Query query = session.createQuery("from Role r where r.userRole = :ro ");
		  query.setParameter("ro", ro);


		  List queryList = query.list();
		  if (queryList != null && queryList.isEmpty()) {
		      return null;
		  } else {
		      return (ArrayList<String>) queryList;
		  }
		} catch (Exception e) {
		  e.printStackTrace();
		  return null;
		} finally {
		  session.close();
		}
	}

	public Role addRole(Role role){
		Session session = null;
		Transaction transaction = null;
		try {
		  session = HibernateConnector.getInstance().getSession();
		  System.out.println("session : "+session);
		  transaction = session.beginTransaction();
		  session.save(role);
		  transaction.commit();
		  return role;
		} catch (Exception e) {
		  e.printStackTrace();
		  return null;
		} 
	}
}