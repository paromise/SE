package se.customs.CustomsUndertaker.UI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import javafx.scene.control.TextField;
import se.customs.CustomsUndertaker.pojo.Product;
import se.customs.UIManagement.UIManager;
import se.customs.CustomsUndertaker.service.*;
import se.customs.CustomsUndertaker.dao.*;
import se.customs.CustomsUndertaker.pojo.Declaration;
import se.customs.EconomicMinisRepres.service.LicenseManager;

/**
 * FXML Controller class
 *
 * @author golrokh
 */
public class CUmenuFXMLCtrl implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML    
    private Button newDeclBtn;
    
    @FXML 
    private Button completeDeclBtn;
    
    @FXML
    private TextField declNumTxtFld;
     
    @FXML
    private Label errLabel;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        errLabel.setVisible(false);
    }  
    
    @FXML 
    private void onCompleteDeclAction(ActionEvent event) throws IOException {
        Button clickedBtn=(Button) event.getSource();
        String clickedBtnId=(String) clickedBtn.getId();
        
        String declNumStr=declNumTxtFld.getText();
        
        if(clickedBtnId.equals("completeDeclBtn")){

            DeclManager declManager = new DeclManager();
            
            if(declNumStr.equals("")){
                errLabel.setText("*ابتدا شماره مجوز را وارد کنید");
                errLabel.setVisible(true);
            }
            
            else if(!declManager.isDeclNumValid(Integer.parseInt(declNumStr))){
                errLabel.setText("* شماره اظهارنامه نامعتبر است");
                errLabel.setVisible(true);
            }

            else{
               
                LicenseManager LM=new LicenseManager();
                int declNum = Integer.parseInt(declNumStr);
                ArrayList<String> requiredLicenses=LM.getRequiredLicenses(declNum);
                DeclarationDAO decDao = new DeclarationDAO();
                Declaration decl = decDao.findDeclarationById(declNum);
                UIManager uiManager=new UIManager();
                uiManager.setupShowDeclDetailsPage(((Node) event.getSource()).getScene().getWindow(),declNum);
                
            }
        }        
    }
    
    @FXML 
    private void onNewDeclAction(ActionEvent event) throws IOException {
        Button clickedBtn=(Button) event.getSource();
        String clickedBtnId=(String) clickedBtn.getId();
        if(clickedBtnId.equals("newDeclBtn")){
            try{
                UIManager uiManager=new UIManager();
                uiManager.setupCustomsUndertakerPage(((Node) event.getSource()).getScene().getWindow());
            }
            catch(Exception e){
                System.out.println("Error in loading CustomsUndertakerPage Page");
                e.printStackTrace();
            }
        }
    }

    
}
