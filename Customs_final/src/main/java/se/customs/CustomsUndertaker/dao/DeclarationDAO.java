/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.customs.CustomsUndertaker.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import se.customs.CustomsUndertaker.pojo.Declaration;
import se.customs.UsersManagement.pojo.CustomsUser;
import se.customs.config.HibernateConnector;

/**
 *
 * @author faeze
 */
public class DeclarationDAO {
    public List<Declaration> listDeclaration() {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from CustomsUser u");

            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                System.out.println("list " + queryList);
                return (List<Declaration>) queryList;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    
    public Declaration findDeclarationById(int Id) {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from Declaration d where "
                     + "d.declID = :Id ");
            query.setParameter("Id", Id);
            

            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                return (Declaration) queryList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    
    public void updateDeclaration(Declaration decl) {
        Session session = null;
        Transaction tx=null;
        try {
            session = HibernateConnector.getInstance().getSession();
            tx=session.beginTransaction();
            session.saveOrUpdate(decl);
            tx.commit();
            session.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
     public Declaration addDeclaration(Declaration decl) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            System.out.println("session : "+session);
            transaction = session.beginTransaction();
            session.save(decl);
            transaction.commit();
            return decl;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
    }
     
     public void deleteDeclaration(int id) {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Transaction beginTransaction = session.beginTransaction();
            Query createQuery = session.createQuery("delete from Declaration d where d.declID = :Id ");
                                                     
            createQuery.setParameter("Id", id);
            
            createQuery.executeUpdate();
            beginTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
     
     
}
