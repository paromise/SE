/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.customs.CustomsUndertaker.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import se.customs.CustomsUndertaker.pojo.Product;
import se.customs.config.HibernateConnector;
/**
 *
 * @author faeze
 */
public class ProductDAO {
    public List<Product> listProducts() {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from Product p");

            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                System.out.println("list " + queryList);
                return (List<Product>) queryList;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    
    public ArrayList<Product> findProductsByDeclId(Integer declId){
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from Product p where p.DECLID = :declId ");
            query.setParameter("declId", declId);


            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                return (ArrayList<Product>) queryList;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    public Product findProductById(Integer pid) {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from Product p where p.proID = :pid ");
            query.setParameter("pid", pid);


            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                return (Product) queryList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    
    public void updateProduct(Product pro) {
        Session session = null;
        Transaction tx=null;
        try {
            session = HibernateConnector.getInstance().getSession();
            tx=session.beginTransaction();
            session.saveOrUpdate(pro);
            tx.commit();
            session.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
     public Product addProduct(Product pro) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            System.out.println("session : "+session);
            transaction = session.beginTransaction();
            session.save(pro);
            transaction.commit();
            return pro;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
    }
     
     public void deleteProduct(String name,Integer declId,String company) {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Transaction beginTransaction = session.beginTransaction();
            Query createQuery = session.createQuery("delete from Product p where p.name = :name "
                                               + "AND p.DECLID = :declId"
                                               + " AND p.company = :company");
            createQuery.setParameter("name", name);
            createQuery.setParameter("declId",declId);
            createQuery.setParameter("company", company);
            createQuery.executeUpdate();
            
            beginTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
     
    public void deleteProductById(Integer proID) {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Transaction beginTransaction = session.beginTransaction();
            Query createQuery = session.createQuery("delete from Product p where p.proID = :proID");
                                               
            createQuery.setParameter("proID", proID);

            createQuery.executeUpdate();
            
            beginTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    } 
}
