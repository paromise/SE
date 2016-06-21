/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.customs.CustomsUndertaker.UI;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import se.customs.CustomsUndertaker.dao.DeclarationDAO;
import se.customs.CustomsUndertaker.pojo.Declaration;
import se.customs.CustomsUndertaker.service.DeclManager;
import se.customs.EconomicMinisRepres.service.LicenseManager;
import se.customs.UIManagement.UIManager;

/**
 * FXML Controller class
 *
 * @author faeze
 */
public class ShowDeclDetailsFXMLCtrl implements Initializable {

    @FXML
    private Label natIDLbl;
    
    @FXML
    private Label nameLbl;
    
    @FXML
    private Label familyLbl;
    
    @FXML
    private Label declDateLbl;
    
    @FXML
    private Label srcCountryLbl;
    
    @FXML
    private Label transWayLbl;
    
    @FXML
    private Button showProdsBtn;
        
    @FXML
    private Button completeBtn;
        
    @FXML
    private Button delDeclBtn;
    
    
    /**
     * Initializes the controller class.
     */
    private DeclarationDAO declDao=new DeclarationDAO();
    Integer declID;
    Declaration decl=null;
    private DeclManager declMng = new DeclManager();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
    public void init_data(int _id){
        declID=_id;
        decl=declDao.findDeclarationById(declID);
        String validity=declMng.getDeclValidity(declID);
        if(validity.equals("valid")){
            completeBtn.setVisible(false);
        }
        natIDLbl.setText(decl.getNationalId());
        nameLbl.setText(decl.getName());
        familyLbl.setText(decl.getFamily());
        declDateLbl.setText(decl.getDeclarationDate());
        srcCountryLbl.setText(decl.getSrcCountry());
        transWayLbl.setText(decl.getTransWay());
    }
    
    
    @FXML 
    private void onShowProdsBtnAction(ActionEvent event) throws IOException {
        UIManager uiManager=new UIManager();
        uiManager.setupProductsTable(((Node) event.getSource()).getScene().getWindow(),declID);
    }
    
    @FXML 
    private void onCompleteBtnAction(ActionEvent event) throws IOException {
        LicenseManager LM=new LicenseManager();
        ArrayList<String> requiredLicenses=LM.getRequiredLicenses(decl.getDeclID());
        UIManager uiManager=new UIManager();
       
        ((Node) event.getSource()).getScene().getWindow().hide();
        uiManager.setupLicensesTable(((Node) event.getSource()).getScene().getWindow(),requiredLicenses,decl.getNationalId(),decl.getDeclID());
    }
    
    @FXML 
    private void onDelBtnAction(ActionEvent event) throws IOException {
        declDao.deleteDeclaration(declID);
        ((Node) event.getSource()).getScene().getWindow().hide();
    }
    
}
