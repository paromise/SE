/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.customs.EconomicMinisRepres.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import se.customs.EconomicMinisRepres.pojo.Rule;

import se.customs.config.HibernateConnector;
/**
 *
 * @author faeze
 */
public class RuleDAO {
    public List<Rule> listRules() {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from Rule r");

            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                System.out.println("list " + queryList);
                return (List<Rule>) queryList;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
  
    public ArrayList<Rule> findRulesByProdType(String prodType){
       Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from Rule r where r.prodType = :prodType ");
            query.setParameter("prodType", prodType);


            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                return (ArrayList<Rule>) queryList;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }  
    }
    
    public List<String> listProductTypes() {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("select DISTINCT r.prodType from Rule r");

            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                System.out.println("list ProductTypes" + queryList);
                return (List<String>) queryList;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
     
    public Rule findRuleById(Integer ruleID) {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Query query = session.createQuery("from Rule r where r.ruleID = :ruleID ");
            query.setParameter("ruleID", ruleID);


            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                return (Rule) queryList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    
    public void updateRule(Rule rule) {
        Session session = null;
        Transaction tx=null;
        try {
            session = HibernateConnector.getInstance().getSession();
            tx=session.beginTransaction();
           
            session.saveOrUpdate(rule);
            tx.commit();
            session.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
     public Rule addRule(Rule rule) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            System.out.println("session : "+session);
            transaction = session.beginTransaction();
            session.save(rule);
            transaction.commit();
            return rule;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
    }
     
     public void deleteRule(Integer ruleID) {
        Session session = null;
        try {
            session = HibernateConnector.getInstance().getSession();
            Transaction beginTransaction = session.beginTransaction();
            Query createQuery = session.createQuery("delete from Rule r where r.ruleID = :ruleID");
            createQuery.setParameter("ruleID", ruleID);
            
            createQuery.executeUpdate();
            
            beginTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
