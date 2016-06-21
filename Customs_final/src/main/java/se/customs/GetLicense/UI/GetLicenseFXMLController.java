/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.customs.GetLicense.UI;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import se.customs.LicenseManagement.dao.LicenseDAO;
import se.customs.LicenseManagement.dao.PrimaryLicTypeDAO;
import se.customs.LicenseManagement.pojo.License;
import se.customs.UIManagement.UIManager;
import se.customs.UsersManagement.dao.CustomsUserDAO;

/**
 * FXML Controller class
 *
 * @author paromise
 */
public class GetLicenseFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField nationalIdTxtFld;
    
    @FXML
    private ChoiceBox<String> licTypeChcBox;
      
    @FXML
    private TextField countryTxtFld;
    
    @FXML
    private ChoiceBox<String> transWayChcBox;
    
    @FXML
    private Button submitBtn;
    
    @FXML
    private Button exitBtn;
    
    @FXML
    private Label errLabel;
    
    @FXML
    private Button addProductsBtn;
    
    @FXML
    private TextField dueDateTxtFld;
    
    @FXML
    private DatePicker dueDatePckr;
    
    private final LicenseDAO licDao=new LicenseDAO();
    private final PrimaryLicTypeDAO pltDao=new PrimaryLicTypeDAO();
    private final CustomsUserDAO cuDao=new CustomsUserDAO();
    
    String username;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<String> transportWays =  new ArrayList<String>();
        transportWays.add("havaii");
        transportWays.add("zamini");
        transportWays.add("daryayi");
        ObservableList<String> list = FXCollections.observableArrayList(transportWays);
        transWayChcBox.setItems(list);
        
        
    }    
    
    public void init_data(String _username){
        username=_username;
        String role=cuDao.findRoleById(username);
        ArrayList<String> AllowedLicTypes=(ArrayList<String>) pltDao.findLicTypesByUndertaker(role);
        ObservableList<String> AllowedLicTypesList = FXCollections.observableArrayList(AllowedLicTypes);
        licTypeChcBox.setItems(AllowedLicTypesList);
    }
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Button clickedBtn=(Button) event.getSource();
        String clickedBtnId=(String) clickedBtn.getId();
        String ltype=(String) licTypeChcBox.getValue(); 
        String nationalId=nationalIdTxtFld.getText();
        //String ltype = licenseTypeTxtFld.getText();
        //String dueDate = dueDateTxtFld.getText();
        String country = countryTxtFld.getText();
        
        String dueDate;
        LocalDate mydate = dueDatePckr.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        if (mydate != null) {
           dueDate = formatter.format(mydate);
           //System.out.println(dueDate);
        }
        else{
            dueDate = "";
        }
        
        String transWay=(String) transWayChcBox.getValue();
        
        if(clickedBtnId.equals("submitBtn") || clickedBtnId.equals("addProductsBtn")){
            if(nationalId.equals("") || ltype.equals("")){
               /*myerrLabel.setText("* هیچ یک از فیلدها نمیتواند خالی باشد");
               myerrLabel.setVisible(true);*/
           }
           else{

               try{
                  
                   License lic=licDao.addLicense(new License(nationalId, dueDate, ltype, country, transWay ));
                   if(lic==null){
                       errLabel.setText("*متاسفانه مشکلی هنگام افزودن پیش أمد ");
                       errLabel.setVisible(true);
                   }
                   else{
                       errLabel.setText("*OK");
                       errLabel.setVisible(true);
                   }
                   
                   if(clickedBtnId.equals("addProductsBtn") && lic != null) {
                        UIManager uiManager=new UIManager();
                        uiManager.setupProductsTable2(((Node) event.getSource()).getScene().getWindow(), lic.getLicNum());   
                    }
               }catch(Exception e){
                   e.printStackTrace();
                   //errLabel.setText("* ارزش کل کالاها باید عدد باشد");
                   //errLabel.setVisible(true);
               }
            }
        
            
        }
        
        
        else if(clickedBtnId.equals("exitBtn")){
            Stage stage = (Stage) exitBtn.getScene().getWindow();
            stage.close();
            UIManager.setAppScene("login");
        }
    }
}
