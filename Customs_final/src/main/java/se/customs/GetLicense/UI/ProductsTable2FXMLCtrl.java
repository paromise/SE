/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.customs.GetLicense.UI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import se.customs.LicenseManagement.dao.LicenseDAO;
import se.customs.LicenseManagement.pojo.License;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import se.customs.LicenseManagement.dao.Product2DAO;
import se.customs.LicenseManagement.pojo.Product2;
import se.customs.UIManagement.UIManager;
/**
 *
 * @author parmiss
 */
public class ProductsTable2FXMLCtrl implements Initializable{

    @FXML
        private TextField nameTxtFld;
    
    @FXML
        private TextField maxWeightTxtFld;
    
    
    @FXML
        private TextField CompanyTxtFld;
    
    @FXML
        private TextField maxUnitPriceTxtFld;
    
    @FXML
        private Button addBtn;
    
    @FXML
        private Button exitBtn;
    
    @FXML
        private Label errLabel;
    
    @FXML
        private TextField minUnitPriceTxtFld;
        
    @FXML
    private TableView table;
    
    @FXML
    private TableColumn numCol;
    
    @FXML
    private TableColumn nameCol;
    
   
    @FXML
    private TableColumn maxWeightCol;
    
    @FXML
    private TableColumn companyCol;
    
    
    
    @FXML
    private TableColumn minUnitPriceCol;
    
    @FXML
    private TableColumn maxUnitPriceCol;
    
    Integer id;
    
    private final ObservableList<Product2> data=FXCollections.observableArrayList();
    private Product2DAO product2Dao=new Product2DAO();
    
    public ProductsTable2FXMLCtrl() {
      // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO
        System.out.println("Initializing...");
        
        table.setEditable(true);
        
        numCol.setCellValueFactory(
                new PropertyValueFactory<>("licID"));
        nameCol.setCellValueFactory(
                new PropertyValueFactory<>("name"));
 
        
        maxWeightCol.setCellValueFactory(
                new PropertyValueFactory<>("max_weight"));

        companyCol.setCellValueFactory(
                new PropertyValueFactory<>("company"));
        
        minUnitPriceCol.setCellValueFactory(
                new PropertyValueFactory<>("min_unitPrice"));
        
        maxUnitPriceCol.setCellValueFactory(
                new PropertyValueFactory<>("max_unitPrice"));
        table.setItems(data);
    }
    
    
    public void init_data(int _id) {
        id = _id;
    }
    
    
    @FXML
    public void handleButtonAction(ActionEvent event) {
        Button clickedBtn=(Button) event.getSource();
        String clickedBtnId=(String) clickedBtn.getId();
        
        if (clickedBtnId.equals("addBtn")) {
            
            String name = nameTxtFld.getText();

            String maxWeight = maxWeightTxtFld.getText();

            String company = CompanyTxtFld.getText();

            String maxUnitPrice = maxUnitPriceTxtFld.getText();


            String minUnitPrice = minUnitPriceTxtFld.getText();

            System.out.println(id);
            float maxWeightVal=0;
            int maxUnitPriceVal = 0;
            int minUnitPriceVal = 0;
            boolean hasErr = false;
                    try{
                        if (!maxWeight.equals("")) {
                            maxWeightVal = Float.parseFloat(maxWeight);
                        }
                        else {
                            maxWeightVal = -1;
                        }
                        
                        if (!maxUnitPrice.equals("")) {
                            maxUnitPriceVal = Integer.parseInt(maxUnitPrice);
                        }
                        else {
                            maxUnitPriceVal = -1;
                        }
                        if(!minUnitPrice.equals("")) {
                            minUnitPriceVal = Integer.parseInt(minUnitPrice);
                        }
                        else {
                            minUnitPriceVal = -1;
                        }
                        if (maxUnitPriceVal < minUnitPriceVal && maxUnitPriceVal != -1) {
                            hasErr = true;
                            errLabel.setText("مقدار ماکسیمم باید از مینیمم بیشتر باشد");
                            errLabel.setVisible(true);
                        }

                    }catch(Exception e){
                        errLabel.setText("* مقدار وزن و تعداد و قیمت واحد باید عدد باشد");
                        errLabel.setVisible(true);
                        hasErr = true;
                    }

            if(!hasErr){
                
                Product2 pro=new Product2(name, company, maxWeightVal, minUnitPriceVal, maxUnitPriceVal,id);
                if(product2Dao.addProduct(pro)==null){
                    errLabel.setText("* متاسفانه مشکلی در حین افزودن پیش أمده است");
                    errLabel.setVisible(true);
                    hasErr=true;
                }
                else{
                    errLabel.setVisible(false);
                    data.add(pro);

                    nameTxtFld.clear();

                    maxWeightTxtFld.clear();

                    CompanyTxtFld.clear();

                    maxUnitPriceTxtFld.clear();

                    minUnitPriceTxtFld.clear();
                }
            }
            
        }
        else if(clickedBtnId.equals("exitBtn")){
            Stage stage = (Stage) exitBtn.getScene().getWindow();
            stage.close();
            UIManager.setAppScene("getLicenseScene");
        }
    }
}
