/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customs;

import static customs.Customs.customsUndertakerScene;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author faeze
 */
public class LoginFXMLController  implements Initializable {
    
    Map <String,String> users;
    @FXML
    private TextField username;
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
    
    @FXML
    private AnchorPane CustomsUndertaker;

    public LoginFXMLController() {
        this.users = new HashMap <> ();
        users.put("CustomsUndertaker","123");
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        Button clickedBtn=(Button) event.getSource();
        String clickedBtnId=(String) clickedBtn.getId();
        
        if(username.getText().equals("") || passwd.getText().equals("") ){
                msgLabel.setVisible(false);
                errLabel.setText("* نام کاربری و رمز عبور نمی تواند خالی باشد");
                errLabel.setVisible(true);
        }
        else{
            if(clickedBtnId.equals("loginBtn")){
           
                if(is_authenticated(username.getText(),passwd.getText())){
                  System.out.println("here");
                   errLabel.setVisible(false);
                   msgLabel.setText("هههه");
                   msgLabel.setVisible(true); 
                   
                   //CustomsUndertaker.getChildren().setAll(FXMLLoader.load(getClass().getResource("CustomsUndertakerFXML.fxml")));
                   Customs.thestage.setScene(customsUndertakerScene);
                }

                else{
                    msgLabel.setVisible(false);
                    errLabel.setText("*نام کاربری یا رمز عبور اشتباه است");
                    errLabel.setVisible(true);
                /*    Alert alert= new Alert(AlertType.ERROR);
                    alert.setTitle("ورود نامعتبر");
                    alert.setContentText("نام کاربری یا رمز عبور اشتباه است");
                    alert.showAndWait();*/
                }
            }
            else if(clickedBtnId.equals("registerBtn")){

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

            }
        }
        
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void print_users(){
        for (String keyVal : users.keySet() ){
            System.out.println(keyVal);
        }
    }
    
    public boolean is_authenticated(String usrname,String passwd){
          
          for (String keyVal : this.users.keySet() ){
              System.out.println(keyVal);
              if(keyVal.equals(usrname)){
                  
                  String pass=users.get(keyVal);
                  System.out.println(pass);
                  if(pass.equals(passwd)){
                      return true;
                  }
                  else{
                      return false;
                  }
              }
          }
          return false;
    }
    
    public boolean is_in_users(String usrname){
          for (String keyVal : users.keySet() ){
              System.out.println(keyVal);
              if(keyVal.equals(usrname)){
                  return true;
              }
          }
          return false;
    }
    
}
