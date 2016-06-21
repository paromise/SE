/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.customs.CustomsUndertaker.service;

import se.customs.CustomsUndertaker.dao.DeclarationDAO;
import se.customs.CustomsUndertaker.pojo.Declaration;

/**
 *
 * @author faeze
 */
public class DeclManager {
    private DeclarationDAO declDAO = new DeclarationDAO();
    public DeclManager(){
        
    }
    
    public Declaration getDeclById(int id){
        return declDAO.findDeclarationById(id);
    }
    
    public Float getTotalVal(int id){
       
        return getDeclById(id).getTotalValue();
    }
    
    public void addToTotalVal(Float val,int id){
        
        declDAO.updateDeclaration(getDeclById(id).addTotalValue(val));
    }
    public void withdrawTotalVal(Float val,int id){
        
        declDAO.updateDeclaration(getDeclById(id).withdrawTotalValue(val));
    }
    public void validateDecl(int id){
        declDAO.updateDeclaration(getDeclById(id).validate());
    }
    public boolean isDeclNumValid(int declNum){
        DeclarationDAO dao = new DeclarationDAO();
        Declaration decl = dao.findDeclarationById(declNum);
        if(decl == null)
            return false;
        else
            return true;
    }
    public String getDeclValidity(int declID){
        Declaration decl = declDAO.findDeclarationById(declID);
        return decl.getValidity();
    }
    public void setDeclDate(String newDate,Integer declID){
        Declaration decl = declDAO.findDeclarationById(declID);
        decl.setDeclarationDate(newDate);
        declDAO.updateDeclaration(decl);
    }
}
