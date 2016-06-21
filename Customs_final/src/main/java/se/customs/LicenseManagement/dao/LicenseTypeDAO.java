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
import se.customs.LicenseManagement.pojo.LicenseType;
import se.customs.config.HibernateConnector;
import java.lang.String;
/**
 *
 * @author faeze
 */
public class LicenseTypeDAO {
    public LicenseTypeDAO(){
        
    }
     public List<LicenseType> listLicTypes() {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from LicenseType l");

            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                System.out.println("list " + queryList);
                return (List<LicenseType>) queryList;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    public LicenseType findLicenseById(Integer ruleID,Integer primLicTypeID) {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from LicenseType l where l.ruleID = :ruleID "
                    + " and l.primLicTypeID= :primLicTypeID ");
            query.setParameter("ruleID", ruleID);
            query.setParameter("primLicTypeID", primLicTypeID);

            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                return (LicenseType) queryList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    
    public List<String> findTypesByRuleId(Integer ruleID) {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("select plt.name from LicenseType lt"
                    + ",PrimaryLicType plt where lt.ruleID = :ruleID "
                    + "and lt.primLicTypeID=plt.primLicTypeID ");
            query.setParameter("ruleID", ruleID);
          

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
    
    public List<LicenseType> findLicenseTypesByRuleId(Integer ruleID) {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            System.out.println("LTDAO ID:"+ruleID);
            Query query = session.createQuery("from LicenseType l where l.ruleID = :ruleID ");
            query.setParameter("ruleID", ruleID);
          

            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                return (List<LicenseType>) queryList;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    
    public void updateLicType(LicenseType lic) {
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
    
     public LicenseType addLicType(LicenseType licType) {
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
     
     public void deleteLicType(Integer ruleID,Integer primLicTypeID) {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Transaction beginTransaction = session.beginTransaction();
            Query createQuery = session.createQuery("delete from LicenseType l where l.ruleID = :ruleID "
                    + "and l.primLicTypeID= :primLicTypeID");
            createQuery.setParameter("ruleID", ruleID);
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
