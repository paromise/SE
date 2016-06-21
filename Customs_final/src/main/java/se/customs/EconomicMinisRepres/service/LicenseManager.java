/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.customs.EconomicMinisRepres.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import se.customs.CustomsUndertaker.dao.DeclarationDAO;
import se.customs.CustomsUndertaker.dao.ProductDAO;
import se.customs.CustomsUndertaker.pojo.Declaration;
import se.customs.CustomsUndertaker.pojo.Product;
import se.customs.EconomicMinisRepres.dao.RuleDAO;
import se.customs.EconomicMinisRepres.pojo.Rule;
import se.customs.LicenseManagement.dao.LicenseDAO;
import se.customs.LicenseManagement.dao.LicenseTypeDAO;
import se.customs.LicenseManagement.pojo.License;
import se.customs.LicenseManagement.pojo.Product2;
import se.customs.LicenseManagement.dao.Product2DAO;

/**
 *
 * @author faeze
 */
public class LicenseManager {
    private RuleDAO ruleDao = new RuleDAO();

    public RuleDAO getRuleDAO() {
        return ruleDao;
    }

    public void setRuleDAO(RuleDAO ruleDao) {
        this.ruleDao = ruleDao;
    }
    private LicenseDAO licDAO=new LicenseDAO();

    public LicenseDAO getLicDAO() {
        return licDAO;
    }

    public void setLicDAO(LicenseDAO licDAO) {
        this.licDAO = licDAO;
    }
    private LicenseTypeDAO licTypeDao = new LicenseTypeDAO();
    private ProductDAO proDao = new ProductDAO();
    private DeclarationDAO declDAO=new DeclarationDAO();

    public LicenseTypeDAO getLicenseTypeDAO() {
        return licTypeDao;
    }

    public void setLicenseTypeDAO(LicenseTypeDAO licTypeDao) {
        this.licTypeDao = licTypeDao;
    }

    public ProductDAO getProductDAO() {
        return proDao;
    }

    public void setProductDAO(ProductDAO proDao) {
        this.proDao = proDao;
    }

    public DeclarationDAO getDeclarationDAO() {
        return declDAO;
    }

    public void setDeclarationDAO(DeclarationDAO declDAO) {
        this.declDAO = declDAO;
    }
    
    
    private Product2DAO pro2Dao = new Product2DAO();

    public Product2DAO getProduct2DAO() {
        return pro2Dao;
    }

    public void setProduct2DAO(Product2DAO pro2Dao) {
        this.pro2Dao = pro2Dao;
    }
    public LicenseManager(){
        
    }
    
    public boolean isRequiredLicense(Product prod, Integer licID, Integer declID) {
        ArrayList<Rule> rules=(ArrayList<Rule>) ruleDao.listRules();
        Declaration decl=declDAO.findDeclarationById(declID);
        License lic=licDAO.findLicenseById(licID);
        String licType = lic.getLicName();
        for(Rule rule: rules){
//               System.out.println("^^^^^^^^^^^^^");
//               System.out.println(" Type:"+rule.getProdType()+" Vs. "+prod.getType());
//               System.out.println(" SrcCountry:"+rule.getCountry()+" Vs. "+decl.getSrcCountry());
//               System.out.println(" TransWay:"+rule.getTransWay()+" Vs. "+decl.getTransWay());
//               System.out.println(" Company:"+rule.getCompany()+" Vs. "+prod.getCompany());
//               System.out.println("^^^^^^^^^^^^^");
                System.out.println(decl.getTotalValue()<=rule.getTotalVal());
                System.out.println(decl.getTotalValue());
                System.out.println(rule.getTotalVal());
               if( rule.getProdType().equals(prod.getType()) &&
                    (decl.getSrcCountry().equals(rule.getCountry())
                       || rule.getCountry().equals("")) 
                       && (decl.getTransWay().equals(rule.getTransWay())
                            || rule.getTransWay().equals(""))
                       && (decl.getTotalValue()<=rule.getTotalVal())){
                   
                   if(prod.getAmount()>=rule.getMinAmount() && 
                           prod.getAmount()<=rule.getMaxAmount() && 
                           (prod.getAmountUnit().equals(rule.getUnit())
                            || rule.getUnit().equals(""))){
                       
                       if(prod.getUnitPrice() >= rule.getMinPrice()
                               && prod.getUnitPrice() <= rule.getMaxPrice()){
                           
                           if(prod.getCompany().equals(rule.getCompany()) 
                                   || rule.getCompany().equals("")){
                              
                               ArrayList<String> lics=(ArrayList<String>) licTypeDao.findTypesByRuleId(rule.getRuleID());
                               for (String licT:lics) {
                                   if (licType.equals(licT)) {
                                       return true;
                                   }
                               }
                           }
                        }
                    }
                }
            }
        return false;
    }
    
    public ArrayList<String> getRequiredLicenses(Integer declID){
        
        ArrayList<String> reqLics = new ArrayList<String>();
        
        ArrayList<Product> prods=proDao.findProductsByDeclId(declID);
        if(prods==null)
            prods=new ArrayList<Product>();
        Declaration decl=declDAO.findDeclarationById(declID);
        ArrayList<Rule> rules=(ArrayList<Rule>) ruleDao.listRules();
        for(Product prod : prods){
           if(rules != null) {
                for(Rule rule: rules){
     //               System.out.println("^^^^^^^^^^^^^");
     //               System.out.println(" Type:"+rule.getProdType()+" Vs. "+prod.getType());
     //               System.out.println(" SrcCountry:"+rule.getCountry()+" Vs. "+decl.getSrcCountry());
     //               System.out.println(" TransWay:"+rule.getTransWay()+" Vs. "+decl.getTransWay());
     //               System.out.println(" Company:"+rule.getCompany()+" Vs. "+prod.getCompany());
     //               System.out.println("^^^^^^^^^^^^^");
                    if( rule.getProdType().equals(prod.getType()) &&
                         (decl.getSrcCountry().equals(rule.getCountry())
                            || rule.getCountry().equals("")) 
                            && (decl.getTransWay().equals(rule.getTransWay())
                                 || rule.getTransWay().equals(""))
                            && (rule.getTotalVal()>=decl.getTotalValue() )){

                        if(prod.getAmount()>=rule.getMinAmount() && 
                                prod.getAmount()<=rule.getMaxAmount() && 
                                (prod.getAmountUnit().equals(rule.getUnit())
                                 || rule.getUnit().equals(""))){

                            if(prod.getUnitPrice() >= rule.getMinPrice()
                                    && prod.getUnitPrice() <= rule.getMaxPrice()){

                                if(prod.getCompany().equals(rule.getCompany()) 
                                        || rule.getCompany().equals("")){

                                    ArrayList<String> lics=(ArrayList<String>) licTypeDao.findTypesByRuleId(rule.getRuleID());
                                    reqLics.addAll(lics);
                                }
                             }
                         }
                     }
                 }
            } 
        }
        if(reqLics.size()==0)
            return null;
        else
            return reqLics;
        
    }
    
    
    public boolean check_License_validity(int licNum, int declID, String nationalId){
        System.out.println("check_License_validit "+licNum);
        String proName;
        double weight; 
        int count, uPrice;
        ArrayList<Product> prods=proDao.findProductsByDeclId(declID);
        License lic = licDAO.findLicenseById(licNum);
        Declaration declr = declDAO.findDeclarationById(declID);
        
        String dueDate="";
        DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        Date date = new Date();
        String cuTime = dateFormat.format(date);
        boolean found = false;
        if (lic != null){ 
            dueDate = lic.getDueDate();
            ArrayList<Product2> prods2 = pro2Dao.findProductsByLicId(licNum);
            for (Product prod: prods){
                
                    System.out.println("finding" + prod.getName());
                if(isRequiredLicense(prod, licNum,declID)) {
                    System.out.println("is required finding" + prod.getName());
                    proName = prod.getName();
                    weight = prod.getAmount();
                    uPrice = prod.getUnitPrice();
                    for (Product2 prod2 : prods2 ) {
                        System.out.println(prod2.getName());
                        if (prod2.getName().equals(proName)) {
                            found = true;
                            System.out.println("found"+prod2.getName());
                            if ((prod2.getMax_unitPrice() != -1 && uPrice > prod2.getMax_unitPrice()) ||
                                (prod2.getMax_weight() != -1 && weight > prod2.getMax_weight()) ||
                                (prod2.getMin_unitPrice() != -1 && uPrice < prod2.getMin_unitPrice())) 
                            {
                                return false;
                            }
                        }
                    }
                    if(!found) {
                        return false;
                    }
                }
            }   
        }
         if(found && (lic.getSrcCountry() == "" || lic.getSrcCountry().equals(declr.getSrcCountry())) && 
                 (lic.getTransWay() == "" || lic.getTransWay().equals(declr.getTransWay())) &&
                 lic.getMerchantID().equals(nationalId) && dueDate.compareTo(cuTime) > 0){
             return true;
        }
         return false;
    }
    
    public ArrayList<Product2> sub_from_license(int licNum, int declID, String nationalId){
        String proName;
        double weight; 
        int count, uPrice;
        ArrayList<Product> prods=proDao.findProductsByDeclId(declID);
        License lic = licDAO.findLicenseById(licNum);
        
        
        String dueDate="";
        DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        Date date = new Date();
        String cuTime = dateFormat.format(date);
        ArrayList<Product2> prods2 = pro2Dao.findProductsByLicId(licNum);
        boolean found = false;
        if (lic != null){ 
            dueDate = lic.getDueDate();
            for (Product prod: prods){
                
                    System.out.println("finding" + prod.getName());
                if(isRequiredLicense(prod, licNum,declID)) {
                    System.out.println("is required finding" + prod.getName());
                    proName = prod.getName();
                    weight = prod.getAmount();
                    uPrice = prod.getUnitPrice();
                    if(prods2!= null)
                        for (Product2 prod2 : prods2 ) {
                            System.out.println(prod2.getName());
                            if (prod2.getName().equals(proName)) {
                                found = true;
                                System.out.println("found"+prod2.getName());
                                prod2.setMax_weight(prod2.getMax_weight() - prod.getAmount());
                                pro2Dao.updateProduct(prod2);
                            }
                        }
                    if(!found) {
                        return prods2;
                    }
                }
            }   
        }
        /* if(found && lic.getMerchantID().equals(nationalId) && dueDate.compareTo(cuTime) > 0){
             return true;
        }
         return false;*/
        return prods2;
    }


}