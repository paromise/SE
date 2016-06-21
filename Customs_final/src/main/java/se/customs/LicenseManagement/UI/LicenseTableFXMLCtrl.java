/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.customs.LicenseManagement.UI;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import se.customs.EconomicMinisRepres.service.LicenseManager;
import se.customs.LicenseManagement.dao.LicenseDAO;
import se.customs.LicenseManagement.pojo.License;
import se.customs.CustomsUndertaker.service.*;

/**
 *
 * @author faeze
 */
public class LicenseTableFXMLCtrl implements Initializable {
    
   
    @FXML
    private Label errLabel;
    
    @FXML
    private TableView licTable;
    
    @FXML
    private TableColumn nameCol;
    
    @FXML
    private TableColumn numCol;
    
    @FXML    
    private Button submitBtn;
    
    
    String merchantNatId;
    
    Integer declId;
   
    
    final ObservableList<LicenseTableRow> data=FXCollections.observableArrayList();
    private LicenseDAO licDAO=new LicenseDAO();
    private ArrayList<String> requiredLics=null;
    private LicenseManager LicManager=new LicenseManager();
    
    public void init_data(ArrayList<String> _requiredLics,String _merchantNatId,int _id){
        declId=_id;
        merchantNatId=_merchantNatId;
        requiredLics=_requiredLics;
        if(requiredLics!=null){
            for(String str: requiredLics){
                data.add(new LicenseTableRow("",str));
            }
        }
       
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        errLabel.setVisible(false);
        System.out.println("Initializing...");
        licTable.setEditable(true);
        
        
        nameCol.setCellValueFactory(
                new PropertyValueFactory<LicenseTableRow, String>("name"));
        
        numCol.setCellValueFactory(
                new PropertyValueFactory<LicenseTableRow, String>("num"));
        
        numCol.setCellFactory(TextFieldTableCell.forTableColumn());
        numCol.setOnEditCommit(
            new EventHandler<CellEditEvent<LicenseTableRow, String>>() {
                @Override
                public void handle(CellEditEvent<LicenseTableRow, String> t) {
                     errLabel.setVisible(false);
                    try{
                        ((LicenseTableRow) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setNum(t.getNewValue());
                        boolean licValidity=LicManager.check_License_validity(Integer.parseInt(t.getNewValue()),declId,merchantNatId);
                        //boolean licValidity = false;
                        if(!licValidity){
                            errLabel.setText("*مجوز مورد نظر شما اعتبار ندارد");
                            errLabel.setVisible(true);
                        }
                        else{
                            errLabel.setVisible(false);
                        }
                    }catch(Exception e){
                        errLabel.setText("*شماره مجوز باید عدد باشد ");
                        errLabel.setVisible(true);
                    }
                    
                }
            }
        );
        
        licTable.setItems(data);
        
        
    }
    
    @FXML
    public void handleButtonAction(ActionEvent event) {
        Button clickedBtn=(Button) event.getSource();
        String clickedBtnId=(String) clickedBtn.getId();
        
        /*String licName = licNameTxtFld.getText();
        String licNum = licNumTxtFld.getText();
        
        if( licName.equals("") || licNum.equals("") ){
            errLabel.setText("*هیچ یک از فیلدهای ورودی نمی تواند خالی باشد ");
            errLabel.setVisible(true);
        }
        else{
            try{
                 License lic = licDAO.findLicenseById(Integer.parseInt(licNum));
                 if(lic==null){
                    errLabel.setText("*چنین مجوزی وجود ندارد ");
                    errLabel.setVisible(true);
                 }
                 else{
                    errLabel.setVisible(false);
                    LicenseTableRow ltr=new LicenseTableRow(lic.getLicNum(),lic.getLicName());
                    data.add(ltr);
                    licNameTxtFld.clear();
                    licNumTxtFld.clear();
                 }
            }catch(Exception e){
                errLabel.setText("* شماره مجوز باید عدد باشد");
                errLabel.setVisible(true);
            }
           
        }*/
    }
    
    @FXML 
    private void onSubmitBtnAction(ActionEvent event) throws IOException {
       
        boolean allLicValid = true;
        
        for(LicenseTableRow row : data){
            System.out.println("*****rowNum "+row.getNum() );
            if(row.getNum()=="" || !LicManager.check_License_validity(Integer.parseInt(row.getNum()),declId, merchantNatId)){
                allLicValid = false;
                break;
            }
        }
        if(allLicValid){
            for(LicenseTableRow row : data)
                LicManager.sub_from_license(Integer.parseInt(row.getNum()),declId, merchantNatId);
            DeclManager declManager = new DeclManager();
            DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
            Date date = new Date();
            String declDate = dateFormat.format(date);
            declManager.setDeclDate(declDate, declId);
            declManager.validateDecl(declId);
            ((Node) event.getSource()).getScene().getWindow().hide();
            errLabel.setText("اظهارنامه با موفقیت به ثبت رسید ");
            errLabel.setVisible(true);
        }
        else{
            errLabel.setText("*شماره مجوزها معتبر نمی باشد ");
            errLabel.setVisible(true);
        }

    }

    
    
}
