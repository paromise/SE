/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.customs.UsersManagement.LoginUI;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import se.customs.UIManagement.UIManager;
import se.customs.UsersManagement.LoginManagement.LoginManagement;
import se.customs.UsersManagement.dao.CustomsUserDAO;

/**
 *
 * @author faeze
 */
public class LoginFXMLController  implements Initializable{
   
    @FXML
    private TextField usrname;
    @FXML
    private PasswordField passwd;
    @FXML
    private Button loginBtn;
    @FXML
    private Button registerBtn;
    
    @FXML 
    private Label errLabel;
    
    @FXML
    private Label msgLabel;
    
    LoginManagement loginManagement=new LoginManagement();
   

    public LoginFXMLController() {
       
       
    }
    
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    

    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Button clickedBtn=(Button) event.getSource();
        String clickedBtnId=(String) clickedBtn.getId();
        
        String username=usrname.getText();
        String password=passwd.getText();
        if(username.equals("") || password.equals("") ){
                msgLabel.setVisible(false);
                errLabel.setText("* نام کاربری و رمز عبور نمی تواند خالی باشد");
                errLabel.setVisible(true);
        }
        else{
            if(clickedBtnId.equals("loginBtn")){
           
                if(loginManagement.is_authenticated(username,password)){
                
                   errLabel.setVisible(false);
                  
                    CustomsUserDAO customsUserDao = new CustomsUserDAO();
                    String role = loginManagement.getRole(username);
                   
                    UIManager uiManager=new UIManager();
                    if (role.equals("CustomsUndertaker")) {
                        uiManager.setupCUmenuPage(((Node) event.getSource()).getScene().getWindow());
                    }
                    
                    else if(role.equals("EconomicMinisRepres")){
                        uiManager.setupEconomicMinisRepresPage(((Node) event.getSource()).getScene().getWindow());
                    }
                    else {
                        uiManager.setupGetLicensePage(((Node) event.getSource()).getScene().getWindow(),username);
                    }
                  
                }

                else{
                    msgLabel.setVisible(false);
                    errLabel.setText("*نام کاربری یا رمز عبور اشتباه است");
                    errLabel.setVisible(true);
                }
            }
            /*else if(clickedBtnId.equals("registerBtn")){

                if(is_in_users(username.getText())){
                    msgLabel.setVisible(false);
                    errLabel.setText("*این نام کاربری قبلا توسط فرد دیگری انتخاب شده است");
                    errLabel.setVisible(true);
                }
                else{
                    this.users.put(username.getText(),passwd.getText());
                    errLabel.setVisible(false);
                    msgLabel.setText("ثبت نام شما با موفقیت انجام شد");
                    msgLabel.setVisible(true);
                }

            }*/
        }
        
       
    }
    
}
