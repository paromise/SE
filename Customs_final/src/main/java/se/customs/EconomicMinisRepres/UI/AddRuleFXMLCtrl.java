/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.customs.EconomicMinisRepres.UI;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
import se.customs.EconomicMinisRepres.dao.RuleDAO;
import se.customs.EconomicMinisRepres.pojo.Rule;
import se.customs.UIManagement.UIManager;

/**
 * FXML Controller class
 *
 * @author faeze
 */
public class AddRuleFXMLCtrl implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button submitFormBtn;
    
    @FXML
    private Button clearFormBtn;
    
    @FXML
    private TextField prodTypeTxtFld;
    
    @FXML
    private TextField totalValTxtFld;
    
    @FXML
    private TextField minAmountTxtFld;
    
    @FXML
    private TextField minPriceTxtFld;
    
    @FXML
    private TextField maxAmountTxtFld;
    
    @FXML
    private TextField maxPriceTxtFld;
    
    @FXML
    private TextField countryTxtFld;
    
    @FXML
    private TextField companyTxtFld;
    
    @FXML
    private ChoiceBox<String> transWayChcBox;
    
    @FXML
    private ChoiceBox<String> UnitChcBox;
    
    @FXML
    private Button addRequiredLicsBtn;
    
    @FXML
    private Label errLabel;
    
    private RuleDAO ruleDao=new RuleDAO();
    
    private Rule rule=null;
    
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<String> units =  new ArrayList<String>();
        units.add("تعداد");
        units.add("کیلوگرم");
        units.add("تن");
        ObservableList<String> list = FXCollections.observableArrayList(units);
        UnitChcBox.setItems(list);
        
        ArrayList<String> transportWays =  new ArrayList<String>();
        transportWays.add("havaii");
        transportWays.add("zamini");
        transportWays.add("daryayi");
        ObservableList<String> transWayList = FXCollections.observableArrayList(transportWays);
        transWayChcBox.setItems(transWayList);
    }    
    
    @FXML
    private void onSubmitAction(ActionEvent event) throws IOException {
   
       
        errLabel.setVisible(false);
        prodTypeTxtFld.clear();
        minAmountTxtFld.clear();
        minPriceTxtFld.clear();
        maxAmountTxtFld.clear();
        maxPriceTxtFld.clear();
        countryTxtFld.clear();
        companyTxtFld.clear();
        prodTypeTxtFld.setDisable(false);
        minAmountTxtFld.setDisable(false);
        minPriceTxtFld.setDisable(false);
        maxAmountTxtFld.setDisable(false);
        maxPriceTxtFld.setDisable(false);
        countryTxtFld.setDisable(false);
        companyTxtFld.setDisable(false);
        addRequiredLicsBtn.setDisable(false);
        rule=null;
    }

    @FXML
    private void onClearAction(ActionEvent event) throws IOException {
        errLabel.setVisible(false);
        prodTypeTxtFld.clear();
        minAmountTxtFld.clear();
        minPriceTxtFld.clear();
        maxAmountTxtFld.clear();
        maxPriceTxtFld.clear();
        countryTxtFld.clear();
        companyTxtFld.clear();
        prodTypeTxtFld.setDisable(false);
        minAmountTxtFld.setDisable(false);
        minPriceTxtFld.setDisable(false);
        maxAmountTxtFld.setDisable(false);
        maxPriceTxtFld.setDisable(false);
        countryTxtFld.setDisable(false);
        companyTxtFld.setDisable(false);
        addRequiredLicsBtn.setDisable(false);
        //roll back in clear form case
        if(rule!=null){
            ruleDao.deleteRule(rule.getRuleID());
            rule=null;
        }
            
    }
    
    @FXML
    private void onAddReqLicsBtn(ActionEvent event) throws IOException {
       
        errLabel.setVisible(false);
        String prodType=prodTypeTxtFld.getText();
        String minAmountStr=minAmountTxtFld.getText();
        String minPriceStr=minPriceTxtFld.getText();
        String maxAmountStr=maxAmountTxtFld.getText();
        String maxPriceStr=maxPriceTxtFld.getText();
        String unit=UnitChcBox.getValue();
        String country=countryTxtFld.getText();
        String totalVal=totalValTxtFld.getText();
        String transWay=transWayChcBox.getValue();
        String company=companyTxtFld.getText();
        if(prodType.equals("")){
            errLabel.setText("* باید ابتدا فرم را پرکنید");
            errLabel.setVisible(true);
        }
        else{
            try{
                Integer minAmount = (minAmountStr.equals("")) ? null : Integer.parseInt(minAmountStr);
                Integer maxAmount = (maxAmountStr.equals("")) ? null : Integer.parseInt(maxAmountStr);
                Integer minPrice = (minPriceStr.equals("")) ? null : Integer.parseInt(minPriceStr);
                Integer maxPrice =(maxPriceStr.equals("")) ? null : Integer.parseInt(maxPriceStr);
                Integer totalPrice= (totalVal.equals("")) ? null : Integer.parseInt(totalVal);
                if( (minAmount!=null && minAmount<0) ||
                    (maxAmount!=null && maxAmount<0) ||
                    (minPrice!=null && minPrice<0)|| 
                    (maxPrice!=null && maxPrice<0)||
                    (totalPrice!=null && totalPrice<0) ){
                    errLabel.setText("* مقادیر محدوده و ارزش کلی نمی توانند منفی باشند");
                    errLabel.setVisible(true);
                }
                else if( ( minAmount!=null || maxAmount!=null )&& unit==null ){

                    errLabel.setText("* لطفا واحد را انتخاب نمایید");
                    errLabel.setVisible(true);

                }
                else{
                        System.out.println("(minAmount) : "+minAmount);
                        minAmount = (minAmount==null) ? -1 : minAmount;
                        maxAmount = (maxAmount==null) ? -1 : maxAmount;
                        minPrice = (minPrice==null) ? -1 : minPrice;
                        maxPrice = (maxPrice==null) ? -1 : maxPrice;
                        totalPrice=(totalPrice==null) ? -1 : totalPrice;
                        if(unit==null){
                            unit="";
                        }
                        if(transWay==null){
                            transWay="";
                        }
                        if(rule==null)
                            rule=ruleDao.addRule(new Rule(prodType,minAmount,minPrice
                                    ,maxAmount,maxPrice,unit,country,transWay,company,totalPrice));
                        
                        if(rule==null){
                            errLabel.setText("* متاسفانه مشکلی در حین افزودن پیش أمده است");
                            errLabel.setVisible(true);

                        }
                        else{
                            UIManager uiManager=new UIManager();
                            uiManager.setupAddLicTypeTable(((Node) event.getSource()).getScene().getWindow(),rule.getRuleID());
                            prodTypeTxtFld.setDisable(true);
                            minAmountTxtFld.setDisable(true);
                            minPriceTxtFld.setDisable(true);
                            maxAmountTxtFld.setDisable(true);
                            maxPriceTxtFld.setDisable(true);
                            
                            countryTxtFld.setDisable(true);
                            companyTxtFld.setDisable(true);
                       }
                }
                
                 
            }
            catch(Exception e){
                errLabel.setText("* محدوده قیمت و مقدار باید عدد باشد");
                errLabel.setVisible(true);
            }
            
            
        }
       
    }
    
    
}
