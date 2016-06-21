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
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import se.customs.CustomsUndertaker.dao.DeclarationDAO;
import se.customs.CustomsUndertaker.dao.ProductDAO;
import se.customs.CustomsUndertaker.pojo.Declaration;
import se.customs.CustomsUndertaker.pojo.Product;
import se.customs.EconomicMinisRepres.service.LicenseManager;
import se.customs.UIManagement.UIManager;

/**
 * FXML Controller class
 *
 * @author faeze
 */
public class CustomsUndertakerFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button addLicensesBtn;
    
    @FXML
    private Button addProductsBtn;
    
    
    @FXML 
    private Button exitBtn;
    
    @FXML
    private TextField nationalIdTxtFld;
    
    
    
    @FXML
    private Label errLabel;
    
    @FXML
    private Label declNumLbl;
    
    @FXML
    private Label declNum;
    
    @FXML
    private TextField nameTxtFld;
    
    @FXML
    private TextField familyTxtFld;
    
    
    @FXML
    private TextField srcCountryTxtFld;
    
    @FXML
    private ChoiceBox<String> transWayChcBox;
    
    private Declaration decl = null;
    
    private final DeclarationDAO declDao=new DeclarationDAO();
    private final ProductDAO productDao=new ProductDAO();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        errLabel.setVisible(false);
        ArrayList<String> transportWays =  new ArrayList<String>();
        transportWays.add("havaii");
        transportWays.add("zamini");
        transportWays.add("daryayi");
        ObservableList<String> list = FXCollections.observableArrayList(transportWays);
        transWayChcBox.setItems(list);
    }    
    
    @FXML 
    private void onAddProdsBtnAction(ActionEvent event) throws IOException {
        
        errLabel.setVisible(false);
        Button clickedBtn=(Button) event.getSource();
        String clickedBtnId=(String) clickedBtn.getId();
        
        String nationalId=nationalIdTxtFld.getText();
        String name=nameTxtFld.getText();
        String family=familyTxtFld.getText();

        String srcCountry=srcCountryTxtFld.getText();
        String transWay=transWayChcBox.getValue();
        
            
        if(transWay==null || nationalId.equals("") || name.equals("")
               || family.equals("")  || srcCountry.equals("")
                ||transWay.equals("")){
           errLabel.setText("* هیچ یک از فیلدها نمیتواند خالی باشد");
           errLabel.setVisible(true);
        }
        else{

           try{
                if(decl==null){
                    DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
                    Date date = new Date();
                    String declDate = dateFormat.format(date);
                    
                    decl=declDao.addDeclaration(new Declaration(name,family
                                                ,nationalId,declDate,srcCountry,transWay,"running"));
                    declNumLbl.setVisible(true);
                    declNum.setText(Integer.toString(decl.getDeclID()));
                    
                }
               if(decl==null){
                   errLabel.setText("*متاسفانه مشکلی هنگام افزودن پیش أمد ");
                   errLabel.setVisible(true);
               }
               else{
                   nationalIdTxtFld.setDisable(true);
                   nameTxtFld.setDisable(true);
                   familyTxtFld.setDisable(true);
                   srcCountryTxtFld.setDisable(true);
                   transWayChcBox.setDisable(true);
                   UIManager uiManager=new UIManager();
                   uiManager.setupProductsTable(((Node) event.getSource()).getScene().getWindow(),decl.getDeclID());
               }


           }catch(Exception e){
               e.printStackTrace();
               errLabel.setText("* ارزش کل کالاها باید عدد باشد");
               errLabel.setVisible(true);
           }
        }

        
    }
    
    @FXML 
    private void onAddLicsBtnAction(ActionEvent event) throws IOException {
        if(decl==null){
                errLabel.setText("* باید ابتدا فرم را پر کرده و کالاهای موردنیاز را اضافه کنید");
                errLabel.setVisible(true);
        }
        else{

           ArrayList<Product> prods=productDao.findProductsByDeclId(decl.getDeclID());
           if(prods==null || prods.size()==0){
               errLabel.setText("* باید ابتدا فرم را پر کرده و کالاهای موردنیاز را اضافه کنید");
               errLabel.setVisible(true);
           }
           else{
               for(Product pro : prods){
               System.out.println(pro.getName());
               }
           LicenseManager LM=new LicenseManager();
           ArrayList<String> requiredLicenses=LM.getRequiredLicenses(decl.getDeclID());
           
           UIManager uiManager=new UIManager();
           ((Node) event.getSource()).getScene().getWindow().hide();
           uiManager.setupLicensesTable(((Node) event.getSource()).getScene().getWindow(),requiredLicenses,decl.getNationalId(),decl.getDeclID());
           }

        }
    }
    
    @FXML 
    private void onClearBtnAction(ActionEvent event) throws IOException {
        nationalIdTxtFld.clear();
        nameTxtFld.clear();
        familyTxtFld.clear();
        srcCountryTxtFld.clear();
        nationalIdTxtFld.setDisable(false);
        nameTxtFld.setDisable(false);
        familyTxtFld.setDisable(false);
        srcCountryTxtFld.setDisable(false);
        transWayChcBox.setDisable(false);
        addProductsBtn.setDisable(false);
        if(decl!=null){
            declDao.deleteDeclaration(decl.getDeclID());
            decl=null;
        }
        
         
    }
    
   
    
}