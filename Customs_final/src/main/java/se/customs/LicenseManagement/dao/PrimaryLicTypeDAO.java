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
import se.customs.LicenseManagement.pojo.PrimaryLicType;
import se.customs.config.HibernateConnector;
import java.lang.String;
/**
 *
 * @author faeze
 */
public class PrimaryLicTypeDAO {
    public PrimaryLicTypeDAO(){
        
    }
     public List<PrimaryLicType> listLicTypes() {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from PrimaryLicType l");

            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                System.out.println("list " + queryList);
                return (List<PrimaryLicType>) queryList;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
     
     public List<String> findLicTypesByUndertaker(String undertaker) {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("select plt.name from PrimaryLicType plt"
                    + " where plt.undertaker=:undertaker");
            query.setParameter("undertaker", undertaker);
            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
               
                return (List<String>) queryList;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    public PrimaryLicType findPrimaryLicTypeById(Integer primLicTypeID) {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from PrimaryLicType l where l.primLicTypeID = :primLicTypeID ");
            query.setParameter("primLicTypeID", primLicTypeID);

            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                return (PrimaryLicType) queryList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    
     public PrimaryLicType findPrimaryLicTypeByName(String name) {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from PrimaryLicType l where l.name = :name ");
            query.setParameter("name", name);

            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                return (PrimaryLicType) queryList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    
    
    
    
    public String findUndertakerByName(String name) {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("select l.undertaker from PrimaryLicType l where l.name = :name ");
            query.setParameter("name", name);
          

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
    
    
    public void updateLicType(PrimaryLicType lic) {
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
    
     public PrimaryLicType addLicType(PrimaryLicType licType) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            System.out.println("session : "+session);
            transaction = session.beginTransaction();
            session.save(licType);
            transaction.commit();
            return licType;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
    }
     
     public void deleteLicType(Integer primLicTypeID) {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Transaction beginTransaction = session.beginTransaction();
            Query createQuery = session.createQuery("delete from PrimaryLicType l"
                    + " where l.primLicTypeID = :primLicTypeID ");
                  
            createQuery.setParameter("primLicTypeID", primLicTypeID);
            
            createQuery.executeUpdate();
            
            beginTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
