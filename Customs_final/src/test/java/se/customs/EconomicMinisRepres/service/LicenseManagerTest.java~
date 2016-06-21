/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.customs.EconomicMinisRepres.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import se.customs.CustomsUndertaker.dao.DeclarationDAO;
import se.customs.CustomsUndertaker.dao.ProductDAO;
import se.customs.CustomsUndertaker.pojo.Declaration;
import se.customs.CustomsUndertaker.pojo.Product;
import se.customs.CustomsUndertaker.service.DeclManager;
import se.customs.EconomicMinisRepres.dao.RuleDAO;
import se.customs.EconomicMinisRepres.pojo.Rule;
import se.customs.LicenseManagement.dao.LicenseDAO;
import se.customs.LicenseManagement.dao.LicenseTypeDAO;
import  se.customs.LicenseManagement.dao.PrimaryLicTypeDAO;
import se.customs.LicenseManagement.dao.Product2DAO;
import se.customs.LicenseManagement.pojo.License;
import se.customs.LicenseManagement.pojo.LicenseType;
import se.customs.LicenseManagement.pojo.PrimaryLicType;
import se.customs.LicenseManagement.pojo.Product2;
/**
 *
 * @author faeze
 */
public class LicenseManagerTest {
    
    public LicenseManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getRequiredLicenses method, of class LicenseManager.
     */
    @org.junit.Test
    public void testGetRequiredLicenses() {
        System.out.println("getRequiredLicenses Test");
        Integer declID = 1;
        LicenseManager instance = new LicenseManager();
        instance.setDeclarationDAO(new DeclarationDAOStub());
        instance.setRuleDAO(new RuleDAOStub());
        instance.setProductDAO(new ProductDAOStub());
        instance.setLicenseTypeDAO(new LicenseTypeDAOStub());
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add("Salamate Mahsule Ghazayi");
        expResult.add("Varedate Faravarde Nafti");
        expResult.add("Salamate Kalaye Felezi1");
        expResult.add("Varedate Kalaye Darmani");
        expResult.add("Jungle Dustan");
        expResult.add("Salamate Heyvan");
        expResult.add("Tabieat");
        ArrayList<String> result = instance.getRequiredLicenses(declID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
    
    @org.junit.Test
    public void testGetRequiredLicenses2() {
        System.out.println("getRequiredLicenses Test2->Amount");
        Integer declID = 1;
        LicenseManager instance = new LicenseManager();
        instance.setDeclarationDAO(new DeclarationDAOStub());
        instance.setRuleDAO(new RuleDAOStub(){
            public List<Rule> listRules() {
                ArrayList<Rule> rules = new ArrayList<Rule>();
                rules.add(new Rule("Felezi",50,10,100,1000,"تعداد","","","",-1));
                rules.add(new  Rule("Felezi",0,10,50,1000,"تعداد","","","",-1));
                
                for(int i=0;i<rules.size();i++){
                    rules.get(i).setRuleID(i);
                }
                return rules;
        }
        });
        instance.setProductDAO(new ProductDAOStub(){
            public ArrayList<Product> findProductsByDeclId(Integer declId){
                ArrayList<Product> prods=new ArrayList<Product>();
               
                prods.add(new Product("Ahan","company1",40,"تعداد",100,1,"Felezi"));
                
                return prods;
            }
        });
        
        instance.setLicenseTypeDAO(new LicenseTypeDAOStub(){
            public List<String> findTypesByRuleId(Integer ruleID) {
                ArrayList<String> types=new ArrayList<String>();
                System.out.println("LicenseTypeDAOStub ruleID: "+ruleID);
                if(ruleID==0){
                    types.add("Varedate Faravarde Felezi Ziad");

                }
                else{
                    types.add("Varedate Faravarde Felezi Kam");
                }

                return types;
            }
        });
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add("Varedate Faravarde Felezi Kam");
        ArrayList<String> result = instance.getRequiredLicenses(declID);
        assertEquals(expResult, result);

    }
    
    @org.junit.Test
    public void testGetRequiredLicenses3() {
        System.out.println("getRequiredLicenses Test3->Amount");
        Integer declID = 1;
        LicenseManager instance = new LicenseManager();
        instance.setDeclarationDAO(new DeclarationDAOStub());
        instance.setRuleDAO(new RuleDAOStub(){
            public List<Rule> listRules() {
                ArrayList<Rule> rules = new ArrayList<Rule>();
                rules.add(new Rule("Felezi",50,10,100,1000,"تعداد","","","",-1));
                rules.add(new  Rule("Felezi",0,10,50,1000,"تعداد","","","",-1));
                
                for(int i=0;i<rules.size();i++){
                    rules.get(i).setRuleID(i);
                }
                return rules;
        }
        });
        instance.setProductDAO(new ProductDAOStub(){
            public ArrayList<Product> findProductsByDeclId(Integer declId){
                ArrayList<Product> prods=new ArrayList<Product>();
               
                prods.add(new Product("Ahan","company1",90,"تعداد",100,1,"Felezi"));
                
                return prods;
            }
        });
        
        instance.setLicenseTypeDAO(new LicenseTypeDAOStub(){
            public List<String> findTypesByRuleId(Integer ruleID) {
                ArrayList<String> types=new ArrayList<String>();
                System.out.println("LicenseTypeDAOStub ruleID: "+ruleID);
                if(ruleID==0){
                    types.add("Varedate Faravarde Felezi Ziad");

                }
                else{
                    types.add("Varedate Faravarde Felezi Kam");
                }

                return types;
            }
        });
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add("Varedate Faravarde Felezi Ziad");
        ArrayList<String> result = instance.getRequiredLicenses(declID);
        assertEquals(expResult, result);

    }

    @org.junit.Test
    public void testGetRequiredLicenses4() {
        System.out.println("getRequiredLicenses Test4->Price");
        Integer declID = 1;
        LicenseManager instance = new LicenseManager();
        instance.setDeclarationDAO(new DeclarationDAOStub());
        instance.setRuleDAO(new RuleDAOStub(){
            public List<Rule> listRules() {
                ArrayList<Rule> rules = new ArrayList<Rule>();
                rules.add(new Rule("Felezi",50,10,100,1000,"تعداد","","","",-1));
                rules.add(new  Rule("Felezi",50,1000,100,2000,"تعداد","","","",-1));
                
                for(int i=0;i<rules.size();i++){
                    rules.get(i).setRuleID(i);
                }
                return rules;
        }
        });
        instance.setProductDAO(new ProductDAOStub(){
            public ArrayList<Product> findProductsByDeclId(Integer declId){
                ArrayList<Product> prods=new ArrayList<Product>();
               
                prods.add(new Product("Ahan","company1",90,"تعداد",100,1,"Felezi"));
                
                return prods;
            }
        });
        
        instance.setLicenseTypeDAO(new LicenseTypeDAOStub(){
            public List<String> findTypesByRuleId(Integer ruleID) {
                ArrayList<String> types=new ArrayList<String>();
                System.out.println("LicenseTypeDAOStub ruleID: "+ruleID);
                if(ruleID==0){
                    types.add("Varedate Faravarde Felezi Arzun");

                }
                else{
                    types.add("Varedate Faravarde Felezi Gerun");
                }

                return types;
            }
        });
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add("Varedate Faravarde Felezi Arzun");
        ArrayList<String> result = instance.getRequiredLicenses(declID);
        assertEquals(expResult, result);

    }
    
    @org.junit.Test
    public void testGetRequiredLicenses5() {
        System.out.println("getRequiredLicenses Test5->Price");
        Integer declID = 1;
        LicenseManager instance = new LicenseManager();
        instance.setDeclarationDAO(new DeclarationDAOStub());
        instance.setRuleDAO(new RuleDAOStub(){
            public List<Rule> listRules() {
                ArrayList<Rule> rules = new ArrayList<Rule>();
                rules.add(new Rule("Felezi",50,10,100,1000,"تعداد","","","",-1));
                rules.add(new  Rule("Felezi",50,1000,100,2000,"تعداد","","","",-1));
                
                for(int i=0;i<rules.size();i++){
                    rules.get(i).setRuleID(i);
                }
                return rules;
        }
        });
        instance.setProductDAO(new ProductDAOStub(){
            public ArrayList<Product> findProductsByDeclId(Integer declId){
                ArrayList<Product> prods=new ArrayList<Product>();
               
                prods.add(new Product("Ahan","company1",90,"تعداد",1500,1,"Felezi"));
                
                return prods;
            }
        });
        
        instance.setLicenseTypeDAO(new LicenseTypeDAOStub(){
            public List<String> findTypesByRuleId(Integer ruleID) {
                ArrayList<String> types=new ArrayList<String>();
                System.out.println("LicenseTypeDAOStub ruleID: "+ruleID);
                if(ruleID==0){
                    types.add("Varedate Faravarde Felezi Arzun");

                }
                else{
                    types.add("Varedate Faravarde Felezi Gerun");
                }

                return types;
            }
        });
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add("Varedate Faravarde Felezi Gerun");
        ArrayList<String> result = instance.getRequiredLicenses(declID);
        assertEquals(expResult, result);

    }
    
    @org.junit.Test
    public void testGetRequiredLicenses6() {
        System.out.println("getRequiredLicenses Test6->Vahedha");
        Integer declID = 1;
        LicenseManager instance = new LicenseManager();
        instance.setDeclarationDAO(new DeclarationDAOStub());
        instance.setRuleDAO(new RuleDAOStub(){
            public List<Rule> listRules() {
                ArrayList<Rule> rules = new ArrayList<Rule>();
                rules.add(new Rule("Felezi",50,10,100,1000,"تعداد","","","",-1));
                rules.add(new  Rule("Felezi",50,10,100,1000,"کیلوگرم","","","",-1));
                rules.add(new  Rule("Felezi",50,10,100,1000,"تن","","","",-1));
                for(int i=0;i<rules.size();i++){
                    rules.get(i).setRuleID(i);
                }
                return rules;
        }
        });
        instance.setProductDAO(new ProductDAOStub(){
            public ArrayList<Product> findProductsByDeclId(Integer declId){
                ArrayList<Product> prods=new ArrayList<Product>();
               
                prods.add(new Product("Ahan","company1",90,"تعداد",500,1,"Felezi"));
                
                return prods;
            }
        });
        
        instance.setLicenseTypeDAO(new LicenseTypeDAOStub(){
            public List<String> findTypesByRuleId(Integer ruleID) {
                ArrayList<String> types=new ArrayList<String>();
                
                if(ruleID==0){
                    types.add("Varedate Faravarde Felezi Tedad");

                }
                else if(ruleID==1){
                    types.add("Varedate Faravarde Felezi Kilogram");

                }
                else {
                    types.add("Varedate Faravarde Felezi Ton");
                }

                return types;
            }
        });
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add("Varedate Faravarde Felezi Tedad");
        ArrayList<String> result = instance.getRequiredLicenses(declID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testGetRequiredLicenses7() {
        System.out.println("getRequiredLicenses Test7->Vahedha");
        Integer declID = 1;
        LicenseManager instance = new LicenseManager();
        instance.setDeclarationDAO(new DeclarationDAOStub());
        instance.setRuleDAO(new RuleDAOStub(){
            public List<Rule> listRules() {
                ArrayList<Rule> rules = new ArrayList<Rule>();
                rules.add(new Rule("Felezi",50,10,100,1000,"تعداد","","","",-1));
                rules.add(new  Rule("Felezi",50,10,100,1000,"کیلوگرم","","","",-1));
                rules.add(new  Rule("Felezi",50,10,100,1000,"تن","","","",-1));
                for(int i=0;i<rules.size();i++){
                    rules.get(i).setRuleID(i);
                }
                return rules;
        }
        });
        instance.setProductDAO(new ProductDAOStub(){
            public ArrayList<Product> findProductsByDeclId(Integer declId){
                ArrayList<Product> prods=new ArrayList<Product>();
               
                prods.add(new Product("Ahan","company1",90,"تن",500,1,"Felezi"));
                
                return prods;
            }
        });
        
        instance.setLicenseTypeDAO(new LicenseTypeDAOStub(){
            public List<String> findTypesByRuleId(Integer ruleID) {
                ArrayList<String> types=new ArrayList<String>();
                
                if(ruleID==0){
                    types.add("Varedate Faravarde Felezi Tedad");

                }
                else if(ruleID==1){
                    types.add("Varedate Faravarde Felezi Kilogram");

                }
                else{
                    types.add("Varedate Faravarde Felezi Ton");
                }

                return types;
            }
        });
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add("Varedate Faravarde Felezi Ton");
        ArrayList<String> result = instance.getRequiredLicenses(declID);
        assertEquals(expResult, result);

    }

    @org.junit.Test
    public void testGetRequiredLicenses8() {
        System.out.println("getRequiredLicenses Test8->Vahedha");
        Integer declID = 1;
        LicenseManager instance = new LicenseManager();
        instance.setDeclarationDAO(new DeclarationDAOStub());
        instance.setRuleDAO(new RuleDAOStub(){
            public List<Rule> listRules() {
                ArrayList<Rule> rules = new ArrayList<Rule>();
                rules.add(new Rule("Felezi",50,10,100,1000,"تعداد","","","",-1));
                rules.add(new  Rule("Felezi",50,10,100,1000,"کیلوگرم","","","",-1));
                rules.add(new  Rule("Felezi",50,10,100,1000,"تن","","","",-1));
                for(int i=0;i<rules.size();i++){
                    rules.get(i).setRuleID(i);
                }
                return rules;
        }
        });
        instance.setProductDAO(new ProductDAOStub(){
            public ArrayList<Product> findProductsByDeclId(Integer declId){
                ArrayList<Product> prods=new ArrayList<Product>();
               
                prods.add(new Product("Ahan","company1",90,"کیلوگرم",500,1,"Felezi"));
                
                return prods;
            }
        });
        
        instance.setLicenseTypeDAO(new LicenseTypeDAOStub(){
            public List<String> findTypesByRuleId(Integer ruleID) {
                ArrayList<String> types=new ArrayList<String>();
                
                if(ruleID==0){
                    types.add("Varedate Faravarde Felezi Tedad");

                }
                else if(ruleID==1){
                    types.add("Varedate Faravarde Felezi Kilogram");

                }
                else{
                    types.add("Varedate Faravarde Felezi Ton");
                }

                return types;
            }
        });
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add("Varedate Faravarde Felezi Kilogram");
        ArrayList<String> result = instance.getRequiredLicenses(declID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    @org.junit.Test
    public void testGetRequiredLicenses9() {
        System.out.println("getRequiredLicenses Test9->Country");
        Integer declID = 1;
        LicenseManager instance = new LicenseManager();
        instance.setDeclarationDAO(new DeclarationDAOStub(){
            public Declaration findDeclarationById(int id){
                return new Declaration("Faeze","Ghasemi","092","112","France","هوایی","running");
            }
        });
        instance.setRuleDAO(new RuleDAOStub(){
            public List<Rule> listRules() {
                ArrayList<Rule> rules = new ArrayList<Rule>();
                rules.add(new Rule("Felezi",50,10,100,1000,"تن","Afghanistan","","",-1));
                rules.add(new  Rule("Felezi",50,10,100,1000,"تن","China","","",-1));
                rules.add(new  Rule("Felezi",50,10,100,1000,"تن","France","","",-1));
                for(int i=0;i<rules.size();i++){
                    rules.get(i).setRuleID(i);
                }
                return rules;
        }
        });
        instance.setProductDAO(new ProductDAOStub(){
            public ArrayList<Product> findProductsByDeclId(Integer declId){
                ArrayList<Product> prods=new ArrayList<Product>();
               
                prods.add(new Product("Ahan","company1",90,"تن",500,1,"Felezi"));
                
                return prods;
            }
        });
        
        instance.setLicenseTypeDAO(new LicenseTypeDAOStub(){
            public List<String> findTypesByRuleId(Integer ruleID) {
                ArrayList<String> types=new ArrayList<String>();
                
                if(ruleID==0){
                    types.add("Varedate Faravarde Felezi Hamsaye");

                }
                else if(ruleID==1){
                    types.add("Varedate Faravarde Felezi Sharghi");

                }
                else{
                    types.add("Varedate Faravarde Felezi Gharbi");
                    types.add("Varedate Faravarde Felezi Europe");
                    types.add("Varedate Faravarde Felezi Ajnabi");
                }

                return types;
            }
        });
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add("Varedate Faravarde Felezi Gharbi");
        expResult.add("Varedate Faravarde Felezi Europe");
        expResult.add("Varedate Faravarde Felezi Ajnabi");
        ArrayList<String> result = instance.getRequiredLicenses(declID);
        assertEquals(expResult, result);

    }
    
    @org.junit.Test
    public void testGetRequiredLicenses10() {
        System.out.println("getRequiredLicenses Test10->TransWay");
        Integer declID = 1;
        LicenseManager instance = new LicenseManager();
        instance.setDeclarationDAO(new DeclarationDAOStub(){
            public Declaration findDeclarationById(int id){
                return new Declaration("Faeze","Ghasemi","092","112","China","دریایی","running");
            }
        });
        instance.setRuleDAO(new RuleDAOStub(){
            public List<Rule> listRules() {
                ArrayList<Rule> rules = new ArrayList<Rule>();
                rules.add(new Rule("Felezi",50,10,100,1000,"تن","China","هوایی","",-1));
                rules.add(new  Rule("Felezi",50,10,100,1000,"تن","China","زمینی","",-1));
                rules.add(new  Rule("Felezi",50,10,100,1000,"تن","China","دریایی","",-1));
                for(int i=0;i<rules.size();i++){
                    rules.get(i).setRuleID(i);
                }
                return rules;
        }
        });
        instance.setProductDAO(new ProductDAOStub(){
            public ArrayList<Product> findProductsByDeclId(Integer declId){
                ArrayList<Product> prods=new ArrayList<Product>();
               
                prods.add(new Product("Ahan","company1",90,"تن",500,1,"Felezi"));
                
                return prods;
            }
        });
        
        instance.setLicenseTypeDAO(new LicenseTypeDAOStub(){
            public List<String> findTypesByRuleId(Integer ruleID) {
                ArrayList<String> types=new ArrayList<String>();
                
                if(ruleID==0){
                    types.add("Varedate Faravarde Felezi Havaii");

                }
                else if(ruleID==1){
                    types.add("Varedate Faravarde Felezi Zamini");

                }
                else{
                    types.add("Varedate Faravarde Felezi Daryayi");
                }

                return types;
            }
        });
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add("Varedate Faravarde Felezi Daryayi");
        
        ArrayList<String> result = instance.getRequiredLicenses(declID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
    @org.junit.Test
    public void testGetRequiredLicenses11() {
        System.out.println("getRequiredLicenses Test11->Typical Rules");
        Integer declID = 1;
        LicenseManager instance = new LicenseManager();
        instance.setDeclarationDAO(new DeclarationDAOStub(){
            public Declaration findDeclarationById(int id){
                return new Declaration("Faeze","Ghasemi","092","112","China","دریایی","running");
            }
        });
        instance.setRuleDAO(new RuleDAOStub(){
            public List<Rule> listRules() {
                ArrayList<Rule> rules = new ArrayList<Rule>();
                rules.add(new  Rule("Felezi",-1,1-1,-1,-1,"","","","",-1));
               
                for(int i=0;i<rules.size();i++){
                    rules.get(i).setRuleID(i);
                }
                return rules;
        }
        });
        instance.setProductDAO(new ProductDAOStub(){
            public ArrayList<Product> findProductsByDeclId(Integer declId){
                ArrayList<Product> prods=new ArrayList<Product>();
               
                prods.add(new Product("Ahan","company1",90,"تن",500,1,"Felezi"));
                
                
                return prods;
            }
        });
        
        instance.setLicenseTypeDAO(new LicenseTypeDAOStub(){
            public List<String> findTypesByRuleId(Integer ruleID) {
                ArrayList<String> types=new ArrayList<String>();
                
                if(ruleID==0){
                    types.add("Varedate Faravarde Felezi Hamejure");

                }
                
                return types;
            }
        });
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add("Varedate Faravarde Felezi Hamejure");
        
        ArrayList<String> result = instance.getRequiredLicenses(declID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
    @org.junit.Test
    public void testGetRequiredLicenses12() {
        System.out.println("getRequiredLicenses Test12->RuleDAO Not Stub");
        Integer declID = 1;
        LicenseManager instance = new LicenseManager();
        instance.setDeclarationDAO(new DeclarationDAOStub(){
            public Declaration findDeclarationById(int id){
                return new Declaration("Faeze","Ghasemi","092","112","China","havaii","running");
            }
        });
        RuleDAO rdao=new RuleDAO();
        
        if(rdao.listRules()==null){
            System.out.println("rdao null!!");
            rdao.addRule(new Rule("Nafti",-1,-1,-1,-1,"","","","",-1));
            rdao.addRule(new  Rule("Felezi",100,100,100000,10000,"Tedad","","","",-1));
            rdao.addRule(new  Rule("Ghalat",-1,-1,-1,-1,"","","","",-1));
            rdao.addRule(new  Rule("Daruii",-1,-1,-1,-1,"","","","",1000));
            rdao.addRule(new  Rule("Felezi",-1,-1,-1,-1,"","China","havaii","",-1));
            rdao.addRule(new  Rule("Felezi",-1,-1,-1,-1,"","China","zamini","",-1));
            rdao.addRule(new  Rule("Felezi",-1,-1,-1,-1,"","France","zamini","",-1));
            rdao.addRule(new  Rule("Heyvanat",-1,-1,-1,-1,"","","","Jungle",-1));
        }
        else
            System.out.println("rdao not null!!");
        
       
        instance.setProductDAO(new ProductDAOStub(){
            public ArrayList<Product> findProductsByDeclId(Integer declId){
                ArrayList<Product> prods=new ArrayList<Product>();
                prods.add(new Product("Berenj","Golestan",1000,"Kilo",1,1,"Ghalat"));
                prods.add(new Product("Benzin","company2",10,"Kilo",1,1,"Nafti"));
                prods.add(new Product("Ahan","company1",1000,"Tedad",1,1,"Felezi"));
                prods.add(new Product("Suzan","company2",100,"Tedad",1,1,"Daruii"));
                prods.add(new Product("Khargush","Jungle",10,"Tedad",1,1,"Heyvanat"));
                return prods;
            }
        });
        instance.setLicenseTypeDAO(new LicenseTypeDAOStub());
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add("Salamate Mahsule Ghazayi");
        expResult.add("Varedate Faravarde Nafti");
        expResult.add("Salamate Kalaye Felezi1");
        expResult.add("Varedate Kalaye Darmani");
        expResult.add("Jungle Dustan");
        expResult.add("Salamate Heyvan");
        expResult.add("Tabieat");
        ArrayList<String> result = instance.getRequiredLicenses(declID);
        assertEquals(expResult, result);
        
    }
    
    @org.junit.Test
    public void testGetRequiredLicenses13() {
        System.out.println("getRequiredLicenses Test13->RuleDAO Not Stub"
                + "+DeclarationDAO Not Stub");
        Declaration decl=new Declaration("Faeze","Ghasemi","092","112","China","havaii","running");
        
        LicenseManager instance = new LicenseManager();
        DeclarationDAO ddao=new DeclarationDAO();
        ddao.addDeclaration(decl);
        Integer declID = decl.getDeclID();
        System.out.println("LMT13/DECLId : "+declID);
        RuleDAO rdao=new RuleDAO();
        
        if(rdao.listRules()==null){
            rdao.addRule(new Rule("Nafti",-1,-1,-1,-1,"","","","",-1));
            rdao.addRule(new  Rule("Felezi",100,100,100000,10000,"Tedad","","","",-1));
            rdao.addRule(new  Rule("Ghalat",-1,-1,-1,-1,"","","","",-1));
            rdao.addRule(new  Rule("Daruii",-1,-1,-1,-1,"","","","",1000));
            rdao.addRule(new  Rule("Felezi",-1,-1,-1,-1,"","China","havaii","",-1));
            rdao.addRule(new  Rule("Felezi",-1,-1,-1,-1,"","China","zamini","",-1));
            rdao.addRule(new  Rule("Felezi",-1,-1,-1,-1,"","France","zamini","",-1));
            rdao.addRule(new  Rule("Heyvanat",-1,-1,-1,-1,"","","","Jungle",-1));
        }
        
        
       
        instance.setProductDAO(new ProductDAOStub(){
            public ArrayList<Product> findProductsByDeclId(Integer declId){
                ArrayList<Product> prods=new ArrayList<Product>();
                prods.add(new Product("Berenj","Golestan",1000,"Kilo",1,1,"Ghalat"));
                prods.add(new Product("Benzin","company2",10,"Kilo",1,1,"Nafti"));
                prods.add(new Product("Ahan","company1",1000,"Tedad",1,1,"Felezi"));
                prods.add(new Product("Suzan","company2",100,"Tedad",1,1,"Daruii"));
                prods.add(new Product("Khargush","Jungle",10,"Tedad",1,1,"Heyvanat"));
                return prods;
            }
        });
        instance.setLicenseTypeDAO(new LicenseTypeDAOStub());
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add("Salamate Mahsule Ghazayi");
        expResult.add("Varedate Faravarde Nafti");
        expResult.add("Salamate Kalaye Felezi1");
        expResult.add("Varedate Kalaye Darmani");
        expResult.add("Jungle Dustan");
        expResult.add("Salamate Heyvan");
        expResult.add("Tabieat");
        ArrayList<String> result = instance.getRequiredLicenses(declID);
        assertEquals(expResult, result);
        
    }
    
    @org.junit.Test
    public void testGetRequiredLicenses14() {
        System.out.println("getRequiredLicenses Test14->RuleDAO Not Stub"
                + "+DeclarationDAO Not Stub + productDAO Not Stub");
        Declaration decl=new Declaration("Faeze","Ghasemi","092","112","China","havaii","running");
        
        LicenseManager instance = new LicenseManager();
        DeclarationDAO ddao=new DeclarationDAO();
        ddao.addDeclaration(decl);
        Integer declID = decl.getDeclID();
 
        RuleDAO rdao=new RuleDAO();
        
        if(rdao.listRules()==null){
            rdao.addRule(new Rule("Nafti",-1,-1,-1,-1,"","","","",-1));
            rdao.addRule(new  Rule("Felezi",100,100,100000,10000,"Tedad","","","",-1));
            rdao.addRule(new  Rule("Ghalat",-1,-1,-1,-1,"","","","",-1));
            rdao.addRule(new  Rule("Daruii",-1,-1,-1,-1,"","","","",1000));
            rdao.addRule(new  Rule("Felezi",-1,-1,-1,-1,"","China","havaii","",-1));
            rdao.addRule(new  Rule("Felezi",-1,-1,-1,-1,"","China","zamini","",-1));
            rdao.addRule(new  Rule("Felezi",-1,-1,-1,-1,"","France","zamini","",-1));
            rdao.addRule(new  Rule("Heyvanat",-1,-1,-1,-1,"","","","Jungle",-1));
        }
        
        
        ProductDAO proDao=new ProductDAO();
        
        proDao.addProduct(new Product("Berenj","Golestan",1000,"Kilo",1,declID,"Ghalat"));
        proDao.addProduct(new Product("Benzin","company2",10,"Kilo",1,declID,"Nafti"));
        proDao.addProduct(new Product("Ahan","company1",1000,"Tedad",1,declID,"Felezi"));
        proDao.addProduct(new Product("Suzan","company2",100,"Tedad",1,declID,"Daruii"));
        proDao.addProduct(new Product("Khargush","Jungle",10,"Tedad",1,declID,"Heyvanat"));
              
        instance.setLicenseTypeDAO(new LicenseTypeDAOStub());
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add("Salamate Mahsule Ghazayi");
        expResult.add("Varedate Faravarde Nafti");
        expResult.add("Salamate Kalaye Felezi1");
        expResult.add("Varedate Kalaye Darmani");
        expResult.add("Jungle Dustan");
        expResult.add("Salamate Heyvan");
        expResult.add("Tabieat");
        ArrayList<String> result = instance.getRequiredLicenses(declID);
        assertEquals(expResult, result);
        
    }
    
  
    
    @org.junit.Test
    public void testGetRequiredLicenses15() {
        System.out.println("getRequiredLicenses Test15->Amount Hade Paiin");
        Integer declID = 1;
        LicenseManager instance = new LicenseManager();
        instance.setDeclarationDAO(new DeclarationDAOStub());
        instance.setRuleDAO(new RuleDAOStub(){
            public List<Rule> listRules() {
                ArrayList<Rule> rules = new ArrayList<Rule>();
                rules.add(new Rule("Felezi",50,10,100,1000,"تعداد","","","",-1));
                rules.add(new  Rule("Felezi",-1,-1,-1,-1,"تعداد","","","",-1));
                
                for(int i=0;i<rules.size();i++){
                    rules.get(i).setRuleID(i);
                }
                return rules;
        }
        });
        instance.setProductDAO(new ProductDAOStub(){
            public ArrayList<Product> findProductsByDeclId(Integer declId){
                ArrayList<Product> prods=new ArrayList<Product>();
               
                prods.add(new Product("Ahan","company1",50,"تعداد",100,1,"Felezi"));
                
                return prods;
            }
        });
        
        instance.setLicenseTypeDAO(new LicenseTypeDAOStub(){
            public List<String> findTypesByRuleId(Integer ruleID) {
                ArrayList<String> types=new ArrayList<String>();
                System.out.println("LicenseTypeDAOStub ruleID: "+ruleID);
                if(ruleID==0){
                    types.add("Varedate Faravarde Felezi Hade Paiin");

                }
                else{
                    types.add("Varedate Faravarde Felezi");
                }

                return types;
            }
        });
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add("Varedate Faravarde Felezi Hade Paiin");
        expResult.add("Varedate Faravarde Felezi");
        ArrayList<String> result = instance.getRequiredLicenses(declID);
        assertEquals(expResult, result);
        
    }
    
        @org.junit.Test
    public void testGetRequiredLicenses16() {
        System.out.println("getRequiredLicenses Test16->Amount Hade Bala");
        Integer declID = 1;
        LicenseManager instance = new LicenseManager();
        instance.setDeclarationDAO(new DeclarationDAOStub());
        instance.setRuleDAO(new RuleDAOStub(){
            public List<Rule> listRules() {
                ArrayList<Rule> rules = new ArrayList<Rule>();
                rules.add(new Rule("Felezi",50,10,100,1000,"تعداد","","","",-1));
                rules.add(new  Rule("Felezi",-1,-1,-1,-1,"تعداد","","","",-1));
                
                for(int i=0;i<rules.size();i++){
                    rules.get(i).setRuleID(i);
                }
                return rules;
        }
        });
        instance.setProductDAO(new ProductDAOStub(){
            public ArrayList<Product> findProductsByDeclId(Integer declId){
                ArrayList<Product> prods=new ArrayList<Product>();
               
                prods.add(new Product("Ahan","company1",100,"تعداد",100,1,"Felezi"));
                
                return prods;
            }
        });
        
        instance.setLicenseTypeDAO(new LicenseTypeDAOStub(){
            public List<String> findTypesByRuleId(Integer ruleID) {
                ArrayList<String> types=new ArrayList<String>();
                System.out.println("LicenseTypeDAOStub ruleID: "+ruleID);
                if(ruleID==0){
                    types.add("Varedate Faravarde Felezi Hade Bala");

                }
                else{
                    types.add("Varedate Faravarde Felezi");
                }

                return types;
            }
        });
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add("Varedate Faravarde Felezi Hade Bala");
        expResult.add("Varedate Faravarde Felezi");
        ArrayList<String> result = instance.getRequiredLicenses(declID);
        assertEquals(expResult, result);
        
    }
    @org.junit.Test
    public void testGetRequiredLicenses17() {
        System.out.println("getRequiredLicenses Test17->Amount Bala Hade Bala");
        Integer declID = 1;
        LicenseManager instance = new LicenseManager();
        instance.setDeclarationDAO(new DeclarationDAOStub());
        instance.setRuleDAO(new RuleDAOStub(){
            public List<Rule> listRules() {
                ArrayList<Rule> rules = new ArrayList<Rule>();
                rules.add(new Rule("Felezi",50,10,100,1000,"تعداد","","","",-1));
                rules.add(new  Rule("Felezi",-1,-1,-1,-1,"تعداد","","","",-1));
                
                for(int i=0;i<rules.size();i++){
                    rules.get(i).setRuleID(i);
                }
                return rules;
        }
        });
        instance.setProductDAO(new ProductDAOStub(){
            public ArrayList<Product> findProductsByDeclId(Integer declId){
                ArrayList<Product> prods=new ArrayList<Product>();
               
                prods.add(new Product("Ahan","company1",10000,"تعداد",100,1,"Felezi"));
                
                return prods;
            }
        });
        
        instance.setLicenseTypeDAO(new LicenseTypeDAOStub(){
            public List<String> findTypesByRuleId(Integer ruleID) {
                ArrayList<String> types=new ArrayList<String>();
                System.out.println("LicenseTypeDAOStub ruleID: "+ruleID);
                if(ruleID==0){
                    types.add("Varedate Faravarde Felezi Bala Hade Bala");

                }
                else{
                    types.add("Varedate Faravarde Felezi");
                }

                return types;
            }
        });
        ArrayList<String> expResult = new ArrayList<String>();
        
        expResult.add("Varedate Faravarde Felezi");
        ArrayList<String> result = instance.getRequiredLicenses(declID);
        assertEquals(expResult, result);
        
    }
    @org.junit.Test
    public void testGetRequiredLicenses18() {
        System.out.println("getRequiredLicenses Test18->Amount Zire Sefr");
        Integer declID = 1;
        LicenseManager instance = new LicenseManager();
        instance.setDeclarationDAO(new DeclarationDAOStub());
        instance.setRuleDAO(new RuleDAOStub(){
            public List<Rule> listRules() {
                ArrayList<Rule> rules = new ArrayList<Rule>();
                rules.add(new Rule("Felezi",50,10,100,1000,"تعداد","","","",-1));
                rules.add(new  Rule("Felezi",-1,-1,-1,-1,"تعداد","","","",-1));
                
                for(int i=0;i<rules.size();i++){
                    rules.get(i).setRuleID(i);
                }
                return rules;
        }
        });
        instance.setProductDAO(new ProductDAOStub(){
            public ArrayList<Product> findProductsByDeclId(Integer declId){
                ArrayList<Product> prods=new ArrayList<Product>();
               
                prods.add(new Product("Ahan","company1",-10,"تعداد",100,1,"Felezi"));
                
                return prods;
            }
        });
        
        instance.setLicenseTypeDAO(new LicenseTypeDAOStub(){
            public List<String> findTypesByRuleId(Integer ruleID) {
                ArrayList<String> types=new ArrayList<String>();
                System.out.println("LicenseTypeDAOStub ruleID: "+ruleID);
                if(ruleID==0){
                    types.add("Varedate Faravarde Felezi Bala Hade Bala");

                }
                else{
                    types.add("Varedate Faravarde Felezi");
                }

                return types;
            }
        });
        ArrayList<String> expResult = null;
        
        
        ArrayList<String> result = instance.getRequiredLicenses(declID);
        assertEquals(expResult, result);
        
    }
    @org.junit.Test
    public void testGetRequiredLicenses19() {
        System.out.println("getRequiredLicenses Test19->Amount Zire Hade Paiin");
        Integer declID = 1;
        LicenseManager instance = new LicenseManager();
        instance.setDeclarationDAO(new DeclarationDAOStub());
        instance.setRuleDAO(new RuleDAOStub(){
            public List<Rule> listRules() {
                ArrayList<Rule> rules = new ArrayList<Rule>();
                rules.add(new Rule("Felezi",50,10,100,1000,"تعداد","","","",-1));
                rules.add(new  Rule("Felezi",-1,-1,-1,-1,"تعداد","","","",-1));
                
                for(int i=0;i<rules.size();i++){
                    rules.get(i).setRuleID(i);
                }
                return rules;
        }
        });
        instance.setProductDAO(new ProductDAOStub(){
            public ArrayList<Product> findProductsByDeclId(Integer declId){
                ArrayList<Product> prods=new ArrayList<Product>();
               
                prods.add(new Product("Ahan","company1",20,"تعداد",100,1,"Felezi"));
                
                return prods;
            }
        });
        
        instance.setLicenseTypeDAO(new LicenseTypeDAOStub(){
            public List<String> findTypesByRuleId(Integer ruleID) {
                ArrayList<String> types=new ArrayList<String>();
                System.out.println("LicenseTypeDAOStub ruleID: "+ruleID);
                if(ruleID==0){
                    types.add("Varedate Faravarde Felezi Zire Hade Paiin");

                }
                else{
                    types.add("Varedate Faravarde Felezi");
                }

                return types;
            }
        });
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add("Varedate Faravarde Felezi");
        
        ArrayList<String> result = instance.getRequiredLicenses(declID);
        assertEquals(expResult, result);
        
    }
    
    @org.junit.Test
    public void testGetRequiredLicenses20() {
        System.out.println("getRequiredLicenses Test20->RuleDAO Not Stub");
        Integer declID = 1;
        LicenseManager instance = new LicenseManager();
        instance.setDeclarationDAO(new DeclarationDAOStub(){
            public Declaration findDeclarationById(int id){
                return new Declaration("Faeze","Ghasemi","092","112","China","havaii","running");
            }
        });
        RuleDAO rdao=new RuleDAO();
        
        if(rdao.listRules()==null){
            rdao.addRule(new Rule("Nafti",-1,-1,-1,-1,"","","","",-1));
            rdao.addRule(new  Rule("Felezi",100,100,100000,10000,"Tedad","","","",-1));
            rdao.addRule(new  Rule("Ghalat",-1,-1,-1,-1,"","","","",-1));
            rdao.addRule(new  Rule("Daruii",-1,-1,-1,-1,"","","","",1000));
            rdao.addRule(new  Rule("Felezi",-1,-1,-1,-1,"","China","havaii","",-1));
            rdao.addRule(new  Rule("Felezi",-1,-1,-1,-1,"","China","zamini","",-1));
            rdao.addRule(new  Rule("Felezi",-1,-1,-1,-1,"","France","zamini","",-1));
            rdao.addRule(new  Rule("Heyvanat",-1,-1,-1,-1,"","","","Jungle",-1));
        }
        
        
       
        instance.setProductDAO(new ProductDAOStub(){
            public ArrayList<Product> findProductsByDeclId(Integer declId){
                ArrayList<Product> prods=new ArrayList<Product>();

                prods.add(new Product("Ahan","company1",1000,"Tedad",1,1,"Felezi"));
                return prods;
            }
        });
        instance.setLicenseTypeDAO(new LicenseTypeDAOStub());
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add("Salamate Kalaye Felezi1");
        ArrayList<String> result = instance.getRequiredLicenses(declID);
        assertEquals(expResult, result);

    }
    
    @org.junit.Test
    public void testGetRequiredLicenses21() {
        System.out.println("getRequiredLicenses Test21->Price Hade Paiin");
        Integer declID = 1;
        LicenseManager instance = new LicenseManager();
        instance.setDeclarationDAO(new DeclarationDAOStub());
        instance.setRuleDAO(new RuleDAOStub(){
            public List<Rule> listRules() {
                ArrayList<Rule> rules = new ArrayList<Rule>();
                rules.add(new Rule("Felezi",50,10,100,1000,"تعداد","","","",-1));
                rules.add(new  Rule("Felezi",-1,-1,-1,-1,"تعداد","","","",-1));
                
                for(int i=0;i<rules.size();i++){
                    rules.get(i).setRuleID(i);
                }
                return rules;
        }
        });
        instance.setProductDAO(new ProductDAOStub(){
            public ArrayList<Product> findProductsByDeclId(Integer declId){
                ArrayList<Product> prods=new ArrayList<Product>();
               
                prods.add(new Product("Ahan","company1",60,"تعداد",10,1,"Felezi"));
                
                return prods;
            }
        });
        
        instance.setLicenseTypeDAO(new LicenseTypeDAOStub(){
            public List<String> findTypesByRuleId(Integer ruleID) {
                ArrayList<String> types=new ArrayList<String>();
                System.out.println("LicenseTypeDAOStub ruleID: "+ruleID);
                if(ruleID==0){
                    types.add("Varedate Faravarde Felezi Price Hade Paiin");

                }
                else{
                    types.add("Varedate Faravarde Felezi");
                }

                return types;
            }
        });
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add("Varedate Faravarde Felezi Price Hade Paiin");
        expResult.add("Varedate Faravarde Felezi");
        ArrayList<String> result = instance.getRequiredLicenses(declID);
        assertEquals(expResult, result);
        
    }
    
    @org.junit.Test
    public void testGetRequiredLicenses22() {
        System.out.println("getRequiredLicenses Test22->Price Hade Bala");
        Integer declID = 1;
        LicenseManager instance = new LicenseManager();
        instance.setDeclarationDAO(new DeclarationDAOStub());
        instance.setRuleDAO(new RuleDAOStub(){
            public List<Rule> listRules() {
                ArrayList<Rule> rules = new ArrayList<Rule>();
                rules.add(new Rule("Felezi",50,10,100,1000,"تعداد","","","",-1));
                rules.add(new  Rule("Felezi",-1,-1,-1,-1,"تعداد","","","",-1));
                
                for(int i=0;i<rules.size();i++){
                    rules.get(i).setRuleID(i);
                }
                return rules;
        }
        });
        instance.setProductDAO(new ProductDAOStub(){
            public ArrayList<Product> findProductsByDeclId(Integer declId){
                ArrayList<Product> prods=new ArrayList<Product>();
               
                prods.add(new Product("Ahan","company1",60,"تعداد",1000,1,"Felezi"));
                
                return prods;
            }
        });
        
        instance.setLicenseTypeDAO(new LicenseTypeDAOStub(){
            public List<String> findTypesByRuleId(Integer ruleID) {
                ArrayList<String> types=new ArrayList<String>();
                System.out.println("LicenseTypeDAOStub ruleID: "+ruleID);
                if(ruleID==0){
                    types.add("Varedate Faravarde Felezi Price Hade Bala");

                }
                else{
                    types.add("Varedate Faravarde Felezi");
                }

                return types;
            }
        });
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add("Varedate Faravarde Felezi Price Hade Bala");
        expResult.add("Varedate Faravarde Felezi");
        ArrayList<String> result = instance.getRequiredLicenses(declID);
        assertEquals(expResult, result);
        
    }
    
    @org.junit.Test
    public void testGetRequiredLicenses23() {
        System.out.println("getRequiredLicenses Test23->Amount Bala Hade Bala");
        Integer declID = 1;
        LicenseManager instance = new LicenseManager();
        instance.setDeclarationDAO(new DeclarationDAOStub());
        instance.setRuleDAO(new RuleDAOStub(){
            public List<Rule> listRules() {
                ArrayList<Rule> rules = new ArrayList<Rule>();
                rules.add(new Rule("Felezi",50,10,100,1000,"تعداد","","","",-1));
                rules.add(new  Rule("Felezi",-1,-1,-1,-1,"تعداد","","","",-1));
                
                for(int i=0;i<rules.size();i++){
                    rules.get(i).setRuleID(i);
                }
                return rules;
        }
        });
        instance.setProductDAO(new ProductDAOStub(){
            public ArrayList<Product> findProductsByDeclId(Integer declId){
                ArrayList<Product> prods=new ArrayList<Product>();
               
                prods.add(new Product("Ahan","company1",60,"تعداد",10000,1,"Felezi"));
                
                return prods;
            }
        });
        
        instance.setLicenseTypeDAO(new LicenseTypeDAOStub(){
            public List<String> findTypesByRuleId(Integer ruleID) {
                ArrayList<String> types=new ArrayList<String>();
                System.out.println("LicenseTypeDAOStub ruleID: "+ruleID);
                if(ruleID==0){
                    types.add("Varedate Faravarde Felezi Price Bala Hade Bala");

                }
                else{
                    types.add("Varedate Faravarde Felezi");
                }

                return types;
            }
        });
        ArrayList<String> expResult = new ArrayList<String>();
        
        expResult.add("Varedate Faravarde Felezi");
        ArrayList<String> result = instance.getRequiredLicenses(declID);
        assertEquals(expResult, result);
        
    }
    @org.junit.Test
    public void testGetRequiredLicenses24() {
        System.out.println("getRequiredLicenses Test24->Price Zire Sefr");
        Integer declID = 1;
        LicenseManager instance = new LicenseManager();
        instance.setDeclarationDAO(new DeclarationDAOStub());
        instance.setRuleDAO(new RuleDAOStub(){
            public List<Rule> listRules() {
                ArrayList<Rule> rules = new ArrayList<Rule>();
                rules.add(new Rule("Felezi",50,10,100,1000,"تعداد","","","",-1));
                rules.add(new  Rule("Felezi",-1,-1,-1,-1,"تعداد","","","",-1));
                
                for(int i=0;i<rules.size();i++){
                    rules.get(i).setRuleID(i);
                }
                return rules;
        }
        });
        instance.setProductDAO(new ProductDAOStub(){
            public ArrayList<Product> findProductsByDeclId(Integer declId){
                ArrayList<Product> prods=new ArrayList<Product>();
               
                prods.add(new Product("Ahan","company1",60,"تعداد",-100,1,"Felezi"));
                
                return prods;
            }
        });
        
        instance.setLicenseTypeDAO(new LicenseTypeDAOStub(){
            public List<String> findTypesByRuleId(Integer ruleID) {
                ArrayList<String> types=new ArrayList<String>();
                System.out.println("LicenseTypeDAOStub ruleID: "+ruleID);
                if(ruleID==0){
                    types.add("Varedate Faravarde Felezi Bala Hade Bala");

                }
                else{
                    types.add("Varedate Faravarde Felezi");
                }

                return types;
            }
        });
        ArrayList<String> expResult = null;
        
        
        ArrayList<String> result = instance.getRequiredLicenses(declID);
        assertEquals(expResult, result);
        
    }
    @org.junit.Test
    public void testGetRequiredLicenses25() {
        System.out.println("getRequiredLicenses Test19->Price Zire Hade Paiin");
        Integer declID = 1;
        LicenseManager instance = new LicenseManager();
        instance.setDeclarationDAO(new DeclarationDAOStub());
        instance.setRuleDAO(new RuleDAOStub(){
            public List<Rule> listRules() {
                ArrayList<Rule> rules = new ArrayList<Rule>();
                rules.add(new Rule("Felezi",50,10,100,1000,"تعداد","","","",-1));
                rules.add(new  Rule("Felezi",-1,-1,-1,-1,"تعداد","","","",-1));
                
                for(int i=0;i<rules.size();i++){
                    rules.get(i).setRuleID(i);
                }
                return rules;
        }
        });
        instance.setProductDAO(new ProductDAOStub(){
            public ArrayList<Product> findProductsByDeclId(Integer declId){
                ArrayList<Product> prods=new ArrayList<Product>();
               
                prods.add(new Product("Ahan","company1",60,"تعداد",5,1,"Felezi"));
                
                return prods;
            }
        });
        
        instance.setLicenseTypeDAO(new LicenseTypeDAOStub(){
            public List<String> findTypesByRuleId(Integer ruleID) {
                ArrayList<String> types=new ArrayList<String>();
                System.out.println("LicenseTypeDAOStub ruleID: "+ruleID);
                if(ruleID==0){
                    types.add("Varedate Faravarde Felezi Price Zire Hade Paiin");

                }
                else{
                    types.add("Varedate Faravarde Felezi");
                }

                return types;
            }
        });
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add("Varedate Faravarde Felezi");
        
        ArrayList<String> result = instance.getRequiredLicenses(declID);
        assertEquals(expResult, result);
        
    }
    
    @org.junit.Test
    public void testGetRequiredLicenses26() {
        System.out.println("getRequiredLicenses Test26->RuleDAO and DeclDAO Not Stub");
        Integer declID = 1;
        LicenseManager instance = new LicenseManager();
        
        DeclarationDAO ddao = new DeclarationDAO();
        if(ddao.findDeclarationById(declID)==null) {/*while???*/
            ddao.addDeclaration(new Declaration("Faeze","Ghasemi","092","112","China","havaii","running"));
        }
        
        RuleDAO rdao=new RuleDAO();
        
        if(rdao.listRules()==null){
            rdao.addRule(new Rule("Nafti",-1,-1,-1,-1,"","","","",-1));
            rdao.addRule(new  Rule("Felezi",100,100,100000,10000,"Tedad","","","",-1));
            rdao.addRule(new  Rule("Ghalat",-1,-1,-1,-1,"","","","",-1));
            rdao.addRule(new  Rule("Daruii",-1,-1,-1,-1,"","","","",1000));
            rdao.addRule(new  Rule("Felezi",-1,-1,-1,-1,"","China","havaii","",-1));
            rdao.addRule(new  Rule("Felezi",-1,-1,-1,-1,"","China","zamini","",-1));
            rdao.addRule(new  Rule("Felezi",-1,-1,-1,-1,"","France","zamini","",-1));
            rdao.addRule(new  Rule("Heyvanat",-1,-1,-1,-1,"","","","Jungle",-1));
        }
        
        
       
        instance.setProductDAO(new ProductDAOStub(){
            public ArrayList<Product> findProductsByDeclId(Integer declId){
                ArrayList<Product> prods=new ArrayList<Product>();
//                prods.add(new Product("Berenj","Golestan",1000,"کیلوگرم",1,1,"Ghalat"));
//                prods.add(new Product("Benzin","company2",10,"کیلوگرم",1,1,"Nafti"));
                prods.add(new Product("Ahan","company1",1000,"Tedad",1,1,"Felezi"));
                return prods;
            }
        });
        instance.setLicenseTypeDAO(new LicenseTypeDAOStub());
        ArrayList<String> expResult = new ArrayList<String>();
//        expResult.add("Salamate Mahsule Ghazayi");
//        expResult.add("Varedate Faravarde Nafti");
        expResult.add("Salamate Kalaye Felezi1");
        ArrayList<String> result = instance.getRequiredLicenses(declID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
    @org.junit.Test
    public void testGetRequiredLicenses27() {
        System.out.println("getRequiredLicenses Test27->RuleDAO, DeclDAO and ProductDAO Not Stub");
        Integer declID = 1;
        LicenseManager instance = new LicenseManager();
        
        DeclarationDAO ddao = new DeclarationDAO();
        if(ddao.findDeclarationById(declID)==null) {/*while???*/
            ddao.addDeclaration(new Declaration("Faeze","Ghasemi","092","112","China","havaii","running"));
        }
        
        RuleDAO rdao=new RuleDAO();
        if(rdao.listRules()==null){
            rdao.addRule(new Rule("Nafti",-1,-1,-1,-1,"","","","",-1));
            rdao.addRule(new  Rule("Felezi",100,100,100000,10000,"Tedad","","","",-1));
            rdao.addRule(new  Rule("Ghalat",-1,-1,-1,-1,"","","","",-1));
            rdao.addRule(new  Rule("Daruii",-1,-1,-1,-1,"","","","",1000));
            rdao.addRule(new  Rule("Felezi",-1,-1,-1,-1,"","China","havaii","",-1));
            rdao.addRule(new  Rule("Felezi",-1,-1,-1,-1,"","China","zamini","",-1));
            rdao.addRule(new  Rule("Felezi",-1,-1,-1,-1,"","France","zamini","",-1));
            rdao.addRule(new  Rule("Heyvanat",-1,-1,-1,-1,"","","","Jungle",-1));
        }
       
        
        ProductDAO pdao = new ProductDAO();
        if(pdao.findProductsByDeclId(declID) == null) {
//            prods.add(new Product("Berenj","Golestan",1000,"کیلوگرم",1,1,"Ghalat"));
//            prods.add(new Product("Benzin","company2",10,"کیلوگرم",1,1,"Nafti"));
              pdao.addProduct(new Product("Ahan","company1",1000,"Tedad",1,1,"Felezi"));
        }
        
        instance.setLicenseTypeDAO(new LicenseTypeDAOStub());
        ArrayList<String> expResult = new ArrayList<String>();
//        expResult.add("Salamate Mahsule Ghazayi");
//        expResult.add("Varedate Faravarde Nafti");
        expResult.add("Salamate Kalaye Felezi1");
        ArrayList<String> result = instance.getRequiredLicenses(declID);
        assertEquals(expResult, result);
    }
    
    @org.junit.Test
    public void testGetRequiredLicenses28() {
        System.out.println("Test 28 :No Stub");
        Integer declID = 1;
        LicenseManager instance = new LicenseManager();
        
        DeclarationDAO ddao = new DeclarationDAO();
        if(ddao.findDeclarationById(declID)==null) {/*while???*/
            ddao.addDeclaration(new Declaration("Faeze","Ghasemi","092","112","China","havaii","running"));
        }
        
        RuleDAO rdao=new RuleDAO();
        if(rdao.listRules()==null){
            rdao.addRule(new Rule("Nafti",-1,-1,-1,-1,"","","","",-1));
            rdao.addRule(new  Rule("Felezi",100,100,100000,10000,"Tedad","","","",-1));
            rdao.addRule(new  Rule("Ghalat",-1,-1,-1,-1,"","","","",-1));
            rdao.addRule(new  Rule("Daruii",-1,-1,-1,-1,"","","","",1000));
            rdao.addRule(new  Rule("Felezi",-1,-1,-1,-1,"","China","havaii","",-1));
            rdao.addRule(new  Rule("Felezi",-1,-1,-1,-1,"","China","zamini","",-1));
            rdao.addRule(new  Rule("Felezi",-1,-1,-1,-1,"","France","zamini","",-1));
            rdao.addRule(new  Rule("Heyvanat",-1,-1,-1,-1,"","","","Jungle",-1));
        }
       
        
        ProductDAO pdao = new ProductDAO();
        if(pdao.findProductsByDeclId(declID) == null) {

              pdao.addProduct(new Product("Ahan","company1",1000,"Tedad",1,1,"Felezi"));
              
        }
        
        LicenseTypeDAO ltdao = new LicenseTypeDAO();
        PrimaryLicTypeDAO pltdao = new PrimaryLicTypeDAO();
        
        if(ltdao.findTypesByRuleId(1) == null) {
            pltdao.addLicType( new PrimaryLicType( "Varedate Faravarde Nafti", "me"));
            pltdao.addLicType( new PrimaryLicType( "Varedate Faravarde Felezi", "me"));
            pltdao.addLicType( new PrimaryLicType( "Salamate Mahsule Ghazayi", "me"));
            pltdao.addLicType( new PrimaryLicType( "Varedate Kalaye Darmani", "me"));
            pltdao.addLicType( new PrimaryLicType( "Salamate Kalaye Felezi1", "me"));
            pltdao.addLicType( new PrimaryLicType( "Salamate Kalaye Felezi2", "me"));
            pltdao.addLicType( new PrimaryLicType( "Salamate Kalaye Felezi3", "me"));
            pltdao.addLicType( new PrimaryLicType( "Jungle Dustan", "me"));
            pltdao.addLicType( new PrimaryLicType( "Salamate Heyvan", "me"));
            pltdao.addLicType( new PrimaryLicType( "Tabieat", "me"));
            ltdao.addLicType(new LicenseType(1,1));
            ltdao.addLicType(new LicenseType(2,2));
            ltdao.addLicType(new LicenseType(3,3));
            ltdao.addLicType(new LicenseType(4,4));
            ltdao.addLicType(new LicenseType(5,5));
            ltdao.addLicType(new LicenseType(6,6));
            ltdao.addLicType(new LicenseType(7,7));
            ltdao.addLicType(new LicenseType(8,8));
            ltdao.addLicType(new LicenseType(8,9));
            ltdao.addLicType(new LicenseType(8,10));
        }
                
        
        
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add("Salamate Kalaye Felezi1");
        ArrayList<String> result = instance.getRequiredLicenses(declID);
        assertEquals(expResult, result);
    }
    
    @org.junit.Test
    public void testGetRequiredLicenses29() {
        System.out.println("getRequiredLicenses Test29->totalVal Had");
        Integer declID = 1;
        LicenseManager instance = new LicenseManager();
        instance.setDeclarationDAO(new DeclarationDAOStub());
        instance.setRuleDAO(new RuleDAOStub(){
            public List<Rule> listRules() {
                ArrayList<Rule> rules = new ArrayList<Rule>();
                rules.add(new Rule("Felezi",50,10,100,1000,"تعداد","","","",1000));
                rules.add(new  Rule("Felezi",-1,-1,-1,-1,"تعداد","","","",-1));
                
                for(int i=0;i<rules.size();i++){
                    rules.get(i).setRuleID(i);
                }
                return rules;
        }
        });
        instance.setProductDAO(new ProductDAOStub(){
            public ArrayList<Product> findProductsByDeclId(Integer declId){
                ArrayList<Product> prods=new ArrayList<Product>();
               
                prods.add(new Product("Ahan","company1",50,"تعداد",20,1,"Felezi"));
                
                return prods;
            }
        });
        
        instance.setLicenseTypeDAO(new LicenseTypeDAOStub(){
            public List<String> findTypesByRuleId(Integer ruleID) {
                ArrayList<String> types=new ArrayList<String>();
                System.out.println("LicenseTypeDAOStub ruleID: "+ruleID);
                if(ruleID==0){
                    types.add("Varedate Faravarde Felezi totalVal Had");

                }
                else{
                    types.add("Varedate Faravarde Felezi");
                }

                return types;
            }
        });
        ArrayList<String> expResult = new ArrayList<String>();
        
        expResult.add("Varedate Faravarde Felezi totalVal Had");
        expResult.add("Varedate Faravarde Felezi");
        ArrayList<String> result = instance.getRequiredLicenses(declID);
        assertEquals(expResult, result);
        
    }
        

    @org.junit.Test
    public void testGetRequiredLicenses31() {
        System.out.println("getRequiredLicenses Test31->totalVal Kamtar az Had");
        Integer declID = 1;
        LicenseManager instance = new LicenseManager();
        instance.setDeclarationDAO(new DeclarationDAOStub());
        instance.setRuleDAO(new RuleDAOStub(){
            public List<Rule> listRules() {
                ArrayList<Rule> rules = new ArrayList<Rule>();
                rules.add(new Rule("Felezi",50,10,100,1000,"تعداد","","","",1000));
                rules.add(new  Rule("Felezi",-1,-1,-1,-1,"تعداد","","","",-1));
                
                for(int i=0;i<rules.size();i++){
                    rules.get(i).setRuleID(i);
                }
                return rules;
        }
        });
        instance.setProductDAO(new ProductDAOStub(){
            public ArrayList<Product> findProductsByDeclId(Integer declId){
                ArrayList<Product> prods=new ArrayList<Product>();
               
                prods.add(new Product("Ahan","company1",20,"تعداد",20,1,"Felezi"));
                
                return prods;
            }
        });
        
        instance.setLicenseTypeDAO(new LicenseTypeDAOStub(){
            public List<String> findTypesByRuleId(Integer ruleID) {
                ArrayList<String> types=new ArrayList<String>();
                System.out.println("LicenseTypeDAOStub ruleID: "+ruleID);
                if(ruleID==0){
                    types.add("Varedate Faravarde Felezi totalVal Bish az Had");

                }
                else{
                    types.add("Varedate Faravarde Felezi");
                }

                return types;
            }
        });
        ArrayList<String> expResult = new ArrayList<String>();
        
        
        expResult.add("Varedate Faravarde Felezi");
        ArrayList<String> result = instance.getRequiredLicenses(declID);
        assertEquals(expResult, result);
        
    }
    

    class RuleDAOStub extends RuleDAO{
    
       
        public List<Rule> listRules() {
            ArrayList<Rule> rules = new ArrayList<Rule>();
            rules.add(new Rule("Nafti",-1,-1,-1,-1,"","","","",-1));
            rules.add(new  Rule("Felezi",100,100,-1,10000,"تعداد","","","",-1));
            rules.add(new  Rule("Ghalat",-1,-1,-1,-1,"","","","",-1));
            rules.add(new  Rule("Daruii",-1,-1,-1,-1,"","","","",-1));
            rules.add(new  Rule("Felezi",-1,-1,-1,-1,"","China","هوایی","",-1));
            rules.add(new  Rule("Felezi",-1,-1,-1,-1,"","China","زمینی","",-1));
            rules.add(new  Rule("Felezi",-1,-1,-1,-1,"","France","زمینی","",-1));
            rules.add(new  Rule("Heyvanat",-1,-1,-1,-1,"","","","Jungle",-1));
            for(int i=0;i<rules.size();i++){
                rules.get(i).setRuleID(i+1);
            }
            return rules;
        }
    }
    
   
    class DeclarationDAOStub extends DeclarationDAO{
        public Declaration findDeclarationById(int id){
            return new Declaration("Faeze","Ghasemi","092","112","China","هوایی","running");
        }
    }
    
    
            
    class ProductDAOStub extends ProductDAO{
        public ArrayList<Product> findProductsByDeclId(Integer declId){
            ArrayList<Product> prods=new ArrayList<Product>();
            prods.add(new Product("Berenj","Golestan",1000,"کیلوگرم",1,1,"Ghalat"));
            prods.add(new Product("Benzin","company2",10,"کیلوگرم",1,1,"Nafti"));
            prods.add(new Product("Ahan","company1",1000,"تعداد",1,1,"Felezi"));
            prods.add(new Product("Suzan","company2",100,"تعداد",1,1,"Daruii"));
            prods.add(new Product("Khargush","Jungle",10,"تعداد",1,1,"Heyvanat"));
            return prods;
        }
    }
    
    class Product2DAOStub extends Product2DAO{
        public ArrayList<Product2> findProductsByLicId(Integer licId){
            ArrayList<Product2> prods = new ArrayList<Product2>();
            prods.add(new Product2("Berenj", "Golestan", (float)1200, 0, 1000, 1));
            return prods;
        }
    }
    
    class LicenseDAOStub extends LicenseDAO {
        public License findLicenseById(Integer licId) {
            return new License("092", "2017.01.01", "Ghalat", "China", "هوایی");
        }
    }
    class LicenseTypeDAOStub extends LicenseTypeDAO{
        public List<String> findTypesByRuleId(Integer ruleID) {
            ArrayList<String> types=new ArrayList<String>();
            System.out.println("LicenseTypeDAOStub ruleID: "+ruleID);
            if(null!=ruleID)switch (ruleID) {
                case 1:
                    types.add("Varedate Faravarde Nafti");
                    break;
                case 2:
                    types.add("Varedate Faravarde Felezi");
                    break;
                case 3:
                    types.add("Salamate Mahsule Ghazayi");
                    break;
                case 4:
                    types.add("Varedate Kalaye Darmani");
                    break;
                case 5:
                    types.add("Salamate Kalaye Felezi1");
                    break;
                case 6:
                    types.add("Salamate Kalaye Felezi2");
                    break;
                case 7:
                    types.add("Salamate Kalaye Felezi3");
                    break;
                case 8:
                    types.add("Jungle Dustan");
                    types.add("Salamate Heyvan");
                    types.add("Tabieat");
                    break;
                
            }
            
            return types;
        } 
    }
    
  

    /**
     * Test of sub_from_license method, of class LicenseManager.
     */
    @Test
    public void testSub_from_license1() {
        System.out.println("sub_from_license1 --> 1 product needs license(license exists)");
        int licNum = 1;
        int declID = 1;
        String nationalId = "092";
        LicenseManager instance = new LicenseManager(){
            public boolean isRequiredLicense(Product prod, Integer licID, Integer declID) {
                if(prod.getName().equals("Berenj"))
                    return true;
                return false;
            }
        };
        instance.setDeclarationDAO(new DeclarationDAOStub());
        instance.setProductDAO(new ProductDAOStub());
        instance.setProduct2DAO(new Product2DAOStub());
        instance.setLicDAO(new LicenseDAOStub());
        ArrayList<Product2> expResult = new ArrayList<Product2>();
        expResult.add(new Product2("Berenj", "Golestan", (float)200, 0, 1000, 1));        
        ArrayList<Product2> result = instance.sub_from_license(licNum, declID, nationalId);
        boolean equal = compare( result,expResult);
        assertEquals(equal, true);
    }
    
    @Test
    public void testSub_from_license2() {
        System.out.println("sub_from_license1 --> 3 products need same license(license exists)");
        int licNum = 1;
        int declID = 1;
        String nationalId = "092";
        LicenseManager instance = new LicenseManager(){
            public boolean isRequiredLicense(Product prod, Integer licID, Integer declID) {
                if(prod.getName().equals("Berenj") || prod.getName().equals("Gandom") || prod.getName().equals("Adas"))
                    return true;
                return false;
            }
        };
        instance.setDeclarationDAO(new DeclarationDAOStub());
        instance.setProductDAO(new ProductDAOStub(){
            public ArrayList<Product> findProductsByDeclId(Integer declId){
                ArrayList<Product> prods=new ArrayList<Product>();
                prods.add(new Product("Berenj","Golestan",1000,"کیلوگرم",1,1,"Ghalat"));
                prods.add(new Product("Gandom","company2",200,"کیلوگرم",1,1,"Ghalat"));
                prods.add(new Product("Adas","company1",300,"کیلوگرم",1,1,"Ghalat"));
                prods.add(new Product("Suzan","company2",100,"تعداد",1,1,"Daruii"));
                prods.add(new Product("Khargush","Jungle",10,"تعداد",1,1,"Heyvanat"));
                return prods;
            }
        });
        instance.setProduct2DAO(new Product2DAOStub(){
            public ArrayList<Product2> findProductsByLicId(Integer licId){
                ArrayList<Product2> prods = new ArrayList<Product2>();
                prods.add(new Product2("Berenj", "Golestan", (float)1200, 0, 1000, 1));
                prods.add(new Product2("Gandom", "company2", (float)800, 0, 2000, 1));
                prods.add(new Product2("Adas", "company1", (float)600, 0, 2000, 1));
                return prods;
            }
        });
        instance.setLicDAO(new LicenseDAOStub());
        ArrayList<Product2> expResult = new ArrayList<Product2>();
        expResult.add(new Product2("Berenj", "Golestan", (float)200, 0, 1000, 1));        
        expResult.add(new Product2("Gandom", "company2", (float)600, 0, 2000, 1));        
        expResult.add(new Product2("Adas", "company1", (float)300, 0, 2000, 1));        
        ArrayList<Product2> result = instance.sub_from_license(licNum, declID, nationalId);
        boolean equal = compare( result,expResult);
        assertEquals(equal, true);
    }
   
    @Test
    public void testSub_from_license3() {
        System.out.println("sub_from_license3 --> 2 product need different licenses(license exists)");
        int licNum = 1;
        int declID = 1;
        String nationalId = "092";
        LicenseManager instance = new LicenseManager(){
            public boolean isRequiredLicense(Product prod, Integer licID, Integer declID) {
                if(prod.getName().equals("Berenj")||prod.getName().equals("Ahan"))
                    return true;
                return false;
            }
        };
        instance.setDeclarationDAO(new DeclarationDAOStub());
        instance.setProductDAO(new ProductDAOStub());
        instance.setProduct2DAO(new Product2DAOStub(){
            public ArrayList<Product2> findProductsByLicId(Integer licId){
                ArrayList<Product2> prods = new ArrayList<Product2>();
                prods.add(new Product2("Berenj", "Golestan", (float)1200, 0, 1000, 1));
                prods.add(new Product2("Ahan", "company1", (float)1400, 0, 2000, 1));                
                return prods;
            }
        });
        instance.setLicDAO(new LicenseDAOStub());
        ArrayList<Product2> expResult = new ArrayList<Product2>();
        expResult.add(new Product2("Berenj", "Golestan", (float)200, 0, 1000, 1));   
        expResult.add(new Product2("Ahan", "company1", (float)400, 0, 1000, 1));        
        ArrayList<Product2> result = instance.sub_from_license(licNum, declID, nationalId);
        boolean equal = compare( result,expResult);
        assertEquals(equal, true);
    }
    
    @Test
    public void testSub_from_license4() {
        System.out.println("sub_from_license4 --> 1 product needs license(license doesnt exists)");
        int licNum = 1;
        int declID = 1;
        String nationalId = "092";
        LicenseManager instance = new LicenseManager(){
            public boolean isRequiredLicense(Product prod, Integer licID, Integer declID) {
                if(prod.getName().equals("Berenj"))
                    return true;
                return false;
            }
        };
        instance.setDeclarationDAO(new DeclarationDAOStub());
        instance.setProductDAO(new ProductDAOStub());
        instance.setProduct2DAO(new Product2DAOStub(){
            public ArrayList<Product2> findProductsByLicId(Integer licId){
                return null;
            }
        });
        instance.setLicDAO(new LicenseDAOStub());
        ArrayList<Product2> expResult = null;
        ArrayList<Product2> result = instance.sub_from_license(licNum, declID, nationalId);
        boolean equal = compare( result,expResult);
        assertEquals(equal, true);
    }

    @Test
    public void testSub_from_license5() {
        System.out.println("sub_from_license5 --> 2 product need different licenses(license exists) Declaration not stub");
        int licNum = 1;
        int declID = 1;
        String nationalId = "092";
        LicenseManager instance = new LicenseManager(){
            public boolean isRequiredLicense(Product prod, Integer licID, Integer declID) {
                if(prod.getName().equals("Berenj")||prod.getName().equals("Ahan"))
                    return true;
                return false;
            }
        };
        
        instance.setProductDAO(new ProductDAOStub());
        instance.setProduct2DAO(new Product2DAOStub(){
            public ArrayList<Product2> findProductsByLicId(Integer licId){
                ArrayList<Product2> prods = new ArrayList<Product2>();
                prods.add(new Product2("Berenj", "Golestan", (float)1200, 0, 1000, 1));
                prods.add(new Product2("Ahan", "company1", (float)1400, 0, 2000, 1));                
                return prods;
            }
        });
        instance.setLicDAO(new LicenseDAOStub());
        ArrayList<Product2> expResult = new ArrayList<Product2>();
        expResult.add(new Product2("Berenj", "Golestan", (float)200, 0, 1000, 1));   
        expResult.add(new Product2("Ahan", "company1", (float)400, 0, 1000, 1));        
        ArrayList<Product2> result = instance.sub_from_license(licNum, declID, nationalId);
        boolean equal = compare( result,expResult);
        assertEquals(equal, true);
    }

    @Test
    public void testSub_from_license6() {
        System.out.println("sub_from_license6 --> 2 product need different licenses(license exists) Declaration not stub");
        int licNum = 1;
        int declID = 1;
        String nationalId = "092";
        LicenseManager instance = new LicenseManager(){
            public boolean isRequiredLicense(Product prod, Integer licID, Integer declID) {
                if(prod.getName().equals("Berenj")||prod.getName().equals("Ahan"))
                    return true;
                return false;
            }
        };
        
        //instance.setProductDAO(new ProductDAOStub());
        instance.setProduct2DAO(new Product2DAOStub(){
            public ArrayList<Product2> findProductsByLicId(Integer licId){
                ArrayList<Product2> prods = new ArrayList<Product2>();
                prods.add(new Product2("Berenj", "Golestan", (float)1200, 0, 1000, 1));
                prods.add(new Product2("Ahan", "company1", (float)1400, 0, 2000, 1));                
                return prods;
            }
        });
        instance.setLicDAO(new LicenseDAOStub());
        ArrayList<Product2> expResult = new ArrayList<Product2>();
        expResult.add(new Product2("Berenj", "Golestan", (float)200, 0, 1000, 1));   
        expResult.add(new Product2("Ahan", "company1", (float)400, 0, 1000, 1));        
        ArrayList<Product2> result = instance.sub_from_license(licNum, declID, nationalId);
        boolean equal = compare( result,expResult);
        assertEquals(equal, true);
    }
    
    private boolean compare(ArrayList<Product2> expResult,ArrayList<Product2> result){
        
        if(expResult==null && result== null ){
            System.out.println("result equals expResult");
            return true;
        }
        if(expResult.size() != result.size()){
            System.out.println("expResult and result differ in size");
            return false;
        }
        for(int i= 0; i<result.size(); i++){
            System.out.println(result.get(i).getName()+" : " + result.get(i).getMax_weight()+" / " +
                    expResult.get(i).getName() + " : " + expResult.get(i).getMax_weight());    
            if(!result.get(i).getName().equals(expResult.get(i).getName()) ||
                !Objects.equals(result.get(i).getMax_weight(), expResult.get(i).getMax_weight())){
                
                System.out.println(result.get(i).getName().equals(expResult.get(i).getName()) + " "
                + (Objects.equals(result.get(i).getMax_weight(), expResult.get(i).getMax_weight())));
                return false;
            }
        }
        System.out.println("result equals expResult");
        return true;
    }
    
}
