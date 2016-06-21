/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.customs.EconomicMinisRepres.UI;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import se.customs.EconomicMinisRepres.dao.RoleDAO;
import se.customs.EconomicMinisRepres.pojo.Role;
import se.customs.LicenseManagement.dao.PrimaryLicTypeDAO;
import se.customs.LicenseManagement.pojo.PrimaryLicType;

/**
 * FXML Controller class
 *
 * @author faeze
 */
public class AddLicenseTypeFXMLCtrl implements Initializable {

    /**
     * Initializes the controller class.
     */
     
    
    @FXML
    private TextField licTypeTxtFld;
    
    @FXML
    private ChoiceBox<String> undertakerChcBox;
    
    @FXML
    private Label errLabel;
    
    @FXML
    private TableView licTypeTable;
    
    @FXML
    private TableColumn licTypeCol;
    
    @FXML
    private TableColumn licUndertakerCol;
    
    private PrimaryLicTypeDAO primLicTypeDao = new PrimaryLicTypeDAO();
    private RoleDAO rdao=new RoleDAO();
    private final ObservableList<PrimaryLicType> data=FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        licTypeTable.setEditable(true);
        
        licTypeCol.setCellValueFactory(
                new PropertyValueFactory<PrimaryLicType, String>("name"));
        
        licUndertakerCol.setCellValueFactory(
                new PropertyValueFactory<PrimaryLicType, String>("undertaker"));
        
        licTypeTable.setItems(data);
        
        ArrayList<PrimaryLicType> primLicTypes=(ArrayList<PrimaryLicType>) primLicTypeDao.listLicTypes();
        if(primLicTypes!=null){
            for(PrimaryLicType plt : primLicTypes){
                data.add(plt);
            }
        }
        ArrayList<String> roles=new ArrayList<String>();
        for(Role r: (ArrayList<Role>) rdao.listRole()){
            roles.add(r.getUserRole());
        }
        ObservableList<String> rolesList = FXCollections.observableArrayList(roles);
        undertakerChcBox.setItems(rolesList);
        
        
    }

    @FXML
    public void onAddBtnAction(ActionEvent event) {
        
        String name=licTypeTxtFld.getText();
        String undertaker=undertakerChcBox.getValue();
        String licUndertakerDB="";
        boolean hasErr=false;
        errLabel.setVisible(false);
        
        if(name.equals("") || undertaker.equals("")){
             errLabel.setText("*  هیچ یک از فیلدها نمی تواند خالی باشد");
             errLabel.setVisible(true);
             hasErr=true;
        }
        else if( (licUndertakerDB=primLicTypeDao.findUndertakerByName(name))!=null){
             errLabel.setText("*  مسئول این مجوز قبلا انتخاب شده است: "+licUndertakerDB);
             errLabel.setVisible(true);
             hasErr=true;
        }
        
        else{
            PrimaryLicType licType=new PrimaryLicType(name,undertaker);
            if(primLicTypeDao.addLicType(licType)==null){
                errLabel.setText("* متاسفانه مشکلی در حین افزودن پیش أمده است");
                errLabel.setVisible(true);
                hasErr=true;
            }
            else{
                errLabel.setVisible(false);
                data.add(licType);
            
                licTypeTxtFld.clear();
                
               
            }
        }
    }
    
    @FXML
    public void onDelBtnAction(ActionEvent event) {
        ObservableList<PrimaryLicType> licTypeSelected;
       
        licTypeSelected=licTypeTable.getSelectionModel().getSelectedItems();
        for(PrimaryLicType lt : licTypeSelected){
            System.out.println("LT Name : "+lt.getName());
            data.remove(lt);
            primLicTypeDao.deleteLicType(lt.getPrimLicTypeID());
        }
    }    
    
    
}
