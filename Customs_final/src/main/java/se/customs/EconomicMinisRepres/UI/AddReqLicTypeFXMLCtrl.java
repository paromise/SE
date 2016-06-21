/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.customs.EconomicMinisRepres.UI;

import java.net.URL;
import java.util.ArrayList;
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
import se.customs.LicenseManagement.dao.LicenseTypeDAO;
import se.customs.LicenseManagement.dao.PrimaryLicTypeDAO;
import se.customs.LicenseManagement.pojo.LicenseType;
import se.customs.LicenseManagement.pojo.PrimaryLicType;


/**
 * FXML Controller class
 *
 * @author faeze
 */
public class AddReqLicTypeFXMLCtrl implements Initializable {

    /**
     * Initializes the controller class.
     */
    

    
    @FXML
    private ChoiceBox<String> LicTypeChcBox;
    
    @FXML
    private Label errLabel;
    
    @FXML
    private TableView licTypeTable;
    
    @FXML
    private TableColumn licTypeCol;
    
    @FXML
    private TableColumn licUndertakerCol;
    
    private Integer id;
    
    private PrimaryLicTypeDAO primLicTypeDao = new PrimaryLicTypeDAO();
    private LicenseTypeDAO licTypeDao = new LicenseTypeDAO();
    
    private final ObservableList<PrimaryLicType> tableData=FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        licTypeTable.setEditable(true);
        
        licTypeCol.setCellValueFactory(
                new PropertyValueFactory<PrimaryLicType, String>("name"));
        
        licUndertakerCol.setCellValueFactory(
                new PropertyValueFactory<PrimaryLicType, String>("undertaker"));
        
       
        licTypeTable.setItems(tableData);
        
        
        ArrayList<PrimaryLicType> primLicTypes=(ArrayList<PrimaryLicType>) primLicTypeDao.listLicTypes();
        ArrayList<String> licTypeNames=new ArrayList<String>();

        if(primLicTypes!=null){
            for(PrimaryLicType lt : primLicTypes){
                licTypeNames.add(lt.getName());
            }
        }
        ObservableList<String> licTypeNameList = FXCollections.observableArrayList(licTypeNames);
        
        LicTypeChcBox.setItems(licTypeNameList);
        
       
    }    
    
    public void init_data(int _id){
        id=_id;
        
        ArrayList<LicenseType> ruleLicTypes=(ArrayList<LicenseType>) licTypeDao.findLicenseTypesByRuleId(id);
        if(ruleLicTypes!=null){
            for(LicenseType lt: ruleLicTypes){
                tableData.add(primLicTypeDao.findPrimaryLicTypeById(lt.getPrimLicTypeID()));
            }
        }
        
       
    }
    
    @FXML
    public void onAddBtnAction(ActionEvent event) {
        
        String name=LicTypeChcBox.getValue();
        
        
        boolean hasErr=false;
        errLabel.setVisible(false);
        
        if(name.equals("")){
             errLabel.setText("*  هیچ یک از فیلدها نمی تواند خالی باشد");
             errLabel.setVisible(true);
             hasErr=true;
        }
        else if( (licTypeDao.findLicenseById(id,primLicTypeDao.findPrimaryLicTypeByName(name).getPrimLicTypeID()))!=null){
             errLabel.setText("* این نوع مجوز قبلا افزوده شده است ");
             errLabel.setVisible(true);
             hasErr=true;
        }
        else{
            
            LicenseType licType=new LicenseType(id,primLicTypeDao.findPrimaryLicTypeByName(name).getPrimLicTypeID());
            if(licTypeDao.addLicType(licType)==null){
                errLabel.setText("* متاسفانه مشکلی در حین افزودن پیش أمده است");
                errLabel.setVisible(true);
                hasErr=true;
            }
            else{
                errLabel.setVisible(false);
                tableData.add(primLicTypeDao.findPrimaryLicTypeByName(name));
           
               
            }
        }
    }
    
    @FXML
    public void onDelBtnAction(ActionEvent event) {
        ObservableList<PrimaryLicType> licTypeSelected;
       
        licTypeSelected=licTypeTable.getSelectionModel().getSelectedItems();
        for(PrimaryLicType lt : licTypeSelected){
            System.out.println("LT Name : "+lt.getName());
            tableData.remove(lt);
            licTypeDao.deleteLicType(id,lt.getPrimLicTypeID());
        }
    }
    
    
    
    
}
