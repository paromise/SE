/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.customs.LicenseManagement.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import se.customs.LicenseManagement.pojo.License;
import se.customs.config.HibernateConnector;

/**
 *
 * @author faeze
 */
public class LicenseDAO {
    public LicenseDAO(){
        
    }
     public List<License> listLicenses() {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from License p");

            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                System.out.println("list " + queryList);
                return (List<License>) queryList;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    public License findLicenseById(Integer id) {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from License l where l.licNum = :id ");
            query.setParameter("id", id);
          

            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                return (License) queryList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    
    public void updateLicense(License lic) {
        Session session = null;
        Transaction tx=null;
        try {
            session = HibernateConnector.getInstance().getSession();
            tx=session.beginTransaction();
            session.saveOrUpdate(lic);
            tx.commit();
            session.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
     public License addLicense(License lic) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            System.out.println("session : "+session);
            transaction = session.beginTransaction();
            session.save(lic);
            transaction.commit();
            return lic;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
    }
     
     public void deleteLicense(Integer id) {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Transaction beginTransaction = session.beginTransaction();
            Query createQuery = session.createQuery("delete from License l where l.licNum = :id ");
            createQuery.setParameter("id", id);
            
            createQuery.executeUpdate();
            
            beginTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
