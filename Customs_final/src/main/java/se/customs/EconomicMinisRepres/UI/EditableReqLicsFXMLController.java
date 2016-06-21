///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package se.customs.EconomicMinisRepres.UI;
//
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.ResourceBundle;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Label;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.control.cell.TextFieldTableCell;
//import se.customs.LicenseManagement.dao.LicenseTypeDAO;
//import se.customs.LicenseManagement.pojo.LicenseType;
//
///**
// * FXML Controller class
// *
// * @author faeze
// */
//public class EditableReqLicsFXMLController implements Initializable {
//
//    
//    /**
//     * Initializes the controller class.
//     */
//    @FXML
//    private TextField licTypeTxtFld;
//    
//    @FXML
//    private TextField undertakerTxtFld;
//    
//    @FXML
//    private Label errLabel;
//    
//    @FXML
//    private TableView licTypeTable;
//    
//    @FXML
//    private TableColumn licTypeCol;
//    
//    @FXML
//    private TableColumn licUndertakerCol;
//    
//    
//    
//    private Integer id;
//    
//    private LicenseTypeDAO licTypeDao = new LicenseTypeDAO();
//    
//    private final ObservableList<LicenseType> data=FXCollections.observableArrayList();
//    
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        errLabel.setVisible(false);
//        // TODO
//        licTypeTable.setEditable(true);
//        
//        licTypeCol.setCellValueFactory(
//                new PropertyValueFactory<LicenseType, String>("name"));
//        
//        licUndertakerCol.setCellValueFactory(
//                new PropertyValueFactory<LicenseType, String>("undertaker"));
//        
//       // setCellsEditable();
//        licTypeTable.setItems(data);
//    }    
//    
//    public void init_data(int _id){
//        id=_id;
//        ArrayList<LicenseType> reqLics=(ArrayList<LicenseType>) 
//                                        licTypeDao.findLicenseTypesByRuleId(id);
//        
//        if(reqLics!=null){
//            for(LicenseType licType : reqLics){
//                data.add(licType);
//            }
//        }
//    }
//    
////    private void setCellsEditable(){
////        errLabel.setVisible(false);
////        licTypeCol.setCellFactory(TextFieldTableCell.forTableColumn());
////        licTypeCol.setOnEditCommit(
////            new EventHandler<TableColumn.CellEditEvent<LicenseType, String>>() {
////                @Override
////                public void handle(TableColumn.CellEditEvent<LicenseType, String> t) {
////                    try{
////                        LicenseType lt=(LicenseType) t.getTableView()
////                                .getItems().get(t.getTablePosition().getRow());
////                        boolean hasErr=false;
////                        if(t.getNewValue().equals("")){
////                            errLabel.setText("*  هیچ یک از فیلدها نمی تواند خالی باشد");
////                            errLabel.setVisible(true);
////                            hasErr=true;
////                        }
////                        else if( (licTypeDao.findLicenseById(t.getNewValue(), id))!=null){
////                            errLabel.setText("* این مجوز قبلا افزوده شده است ");
////                            errLabel.setVisible(true);
////                            hasErr=true;
////                        }
////                        if(!hasErr){
////                            lt.setName(t.getNewValue());
////                       
////                            licTypeDao.updateLicType(lt);
////                        }
////                       
////                    }catch(Exception e){
////                        errLabel.setText(e.getMessage());
////                        errLabel.setVisible(true);
////                    }
////                    
////                }
////            }
////        );
////        
////        licUndertakerCol.setCellFactory(TextFieldTableCell.forTableColumn());
////        licUndertakerCol.setOnEditCommit(
////            new EventHandler<TableColumn.CellEditEvent<LicenseType, String>>() {
////                @Override
////                public void handle(TableColumn.CellEditEvent<LicenseType, String> t) {
////                    try{
////                        LicenseType lt=(LicenseType) t.getTableView()
////                                .getItems().get(t.getTablePosition().getRow());
////                        String licUndertakerDB;
////                        boolean hasErr=false;
////                        if(t.getNewValue().equals("")){
////                            errLabel.setText("*  هیچ یک از فیلدها نمی تواند خالی باشد");
////                            errLabel.setVisible(true);
////                            hasErr=true;
////                        }
////                        else if( (licUndertakerDB=licTypeDao.findUndertakerByLicType(lt.getName()))!=null
////                                && !licUndertakerDB.equals(t.getNewValue()) ){
////                            errLabel.setText("*  مسئول این مجوز قبلا انتخاب شده است: "+licUndertakerDB);
////                            errLabel.setVisible(true);
////                            hasErr=true;
////                        }
////                        else if( (licTypeDao.findLicenseById(lt.getName(), id))!=null){
////                            errLabel.setText("* این مجوز قبلا افزوده شده است ");
////                            errLabel.setVisible(true);
////                            hasErr=true;
////                        }
////                        if(!hasErr){
////                            lt.setUndertaker(t.getNewValue());
////                       
////                            licTypeDao.updateLicType(lt);
////                        }
////                        
////                    }catch(Exception e){
////                        errLabel.setText(e.getMessage());
////                        errLabel.setVisible(true);
////                    }
////                    
////                }
////            }
////        );
////    }
//    
//    
//    @FXML
//    public void onDelBtnAction(ActionEvent event) {
//        errLabel.setVisible(false);
//        System.out.println("delete action");
//        ObservableList<LicenseType> ruleSelected;
//       
//        ruleSelected=licTypeTable.getSelectionModel().getSelectedItems();
//        for(LicenseType lt : ruleSelected){
//            System.out.println("ID : "+lt.getName());
//            data.remove(lt);
//            licTypeDao.deleteLicType(lt.getName(),lt.getRuleID());
//        }
//    }
//    
//    @FXML
//    public void onAddBtnAction(ActionEvent event) {
//        errLabel.setVisible(false);
//        String name=licTypeTxtFld.getText();
//        String undertaker=undertakerTxtFld.getText();
//        String licUndertakerDB="";
//        boolean hasErr=false;
//        errLabel.setVisible(false);
//        
//        if(name.equals("") || undertaker.equals("")){
//             errLabel.setText("*  هیچ یک از فیلدها نمی تواند خالی باشد");
//             errLabel.setVisible(true);
//             hasErr=true;
//        }
//        else if( (licUndertakerDB=licTypeDao.findUndertakerByLicType(name))!=null
//                 && !licUndertakerDB.equals(undertaker)){
//             errLabel.setText("*  مسئول این مجوز قبلا انتخاب شده است: "+licUndertakerDB);
//             errLabel.setVisible(true);
//             hasErr=true;
//        }
//        else if( (licTypeDao.findLicenseById(name, id))!=null){
//             errLabel.setText("* این مجوز قبلا افزوده شده است ");
//             errLabel.setVisible(true);
//             hasErr=true;
//        }
//        else{
//            LicenseType licType=new LicenseType(name,undertaker,id);
//            if(licTypeDao.addLicType(licType)==null){
//                errLabel.setText("* متاسفانه مشکلی در حین افزودن پیش أمده است");
//                errLabel.setVisible(true);
//                hasErr=true;
//            }
//            else{
//                errLabel.setVisible(false);
//                data.add(licType);
//            
//                licTypeTxtFld.clear();
//                undertakerTxtFld.clear();
//               
//            }
//        }
//    }
//    
//    
//}
