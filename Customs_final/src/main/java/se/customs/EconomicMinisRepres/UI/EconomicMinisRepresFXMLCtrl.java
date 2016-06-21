/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.customs.EconomicMinisRepres.UI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import se.customs.EconomicMinisRepres.dao.RuleDAO;
import se.customs.EconomicMinisRepres.pojo.Rule;
import se.customs.UIManagement.UIManager;

/**
 *
 * @author faeze
 */
public class EconomicMinisRepresFXMLCtrl implements Initializable {
     
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
    @FXML
    public void onAddRuleBtnAction(ActionEvent event) {
        try{
            UIManager uiManager=new UIManager();
            uiManager.setupAddRulePage(((Node) event.getSource()).getScene().getWindow());
        }
        catch(Exception e){
            System.out.println("Error in loading addRule Page");
        }
                  
    }
    
    @FXML
    public void onEditRulesBtnAction(ActionEvent event) {
       try{
            UIManager uiManager=new UIManager();
            uiManager.setupRuleTable(((Node) event.getSource()).getScene().getWindow());
        }
        catch(Exception e){
            System.out.println("Error in loading EditRules Page");
        }
        
    }
    @FXML
    public void onAddPrimLicTypeAction(ActionEvent event) {
       try{
            UIManager uiManager=new UIManager();
            uiManager.setupAddPrimLicTypePage(((Node) event.getSource()).getScene().getWindow());
        }
        catch(Exception e){
            System.out.println("Error in loading AddPrimLic Page");
        }
        
    }

    @FXML
    public void onAddRoleBtnAction(ActionEvent event) {
        try{
            UIManager uiManager=new UIManager();
            uiManager.setupAddRolePage(((Node) event.getSource()).getScene().getWindow());
        }
        catch(Exception e){
            System.out.println("Error in loading CustomsUndertakerPage Page");
        }
    }
    
    @FXML
    public void onAddUserBtnAction(ActionEvent event) {
        try{
            UIManager uiManager=new UIManager();
            uiManager.setupAddUserPage(((Node) event.getSource()).getScene().getWindow());
        }
        catch(Exception e){
            System.out.println("Error in loading AddUserPage Page");
        }
    }
    
}