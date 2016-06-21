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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;
import se.customs.EconomicMinisRepres.dao.RuleDAO;
import se.customs.EconomicMinisRepres.pojo.Rule;
import se.customs.UIManagement.UIManager;



/**
 * FXML Controller class
 *
 * @author faeze
 */
public class RuleTableFXMLCtrl implements Initializable {
    
    @FXML
    private Label errLabel;
    
    @FXML
    private TableView ruleTable;
    
    @FXML
    private TableColumn licNumCol;
    
    @FXML
    private TableColumn prodTypeCol;
    
    @FXML
    private TableColumn minAmountCol;
    
    @FXML
    private TableColumn maxAmountCol;
    
    @FXML
    private TableColumn minValCol;
    
    @FXML
    private TableColumn maxValCol;
    
    @FXML
    private TableColumn srcCountryCol;
    
    @FXML
    private TableColumn companyCol;
    
    @FXML
    private TableColumn transWayCol;
    
    @FXML
    private TableColumn totalValCol;
   
   
    
    
    ObservableList<Rule> data=FXCollections.observableArrayList();
    private RuleDAO ruleDao=new RuleDAO();

    /**
     * Initializes the controller class.
     */
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        errLabel.setVisible(false);
        configTable();
        
    }    
    
    private void configTable(){
        ruleTable.setEditable(true);
        
        
        ArrayList <Rule> rules=(ArrayList <Rule>) ruleDao.listRules();
        if(rules!=null){
            for(Rule r : rules){
               data.add(r);
            } 
        }
        
        
        licNumCol.setCellValueFactory(
                 new PropertyValueFactory<Rule, String>("ruleID"));
       
        prodTypeCol.setCellValueFactory(
                 new PropertyValueFactory<Rule, String>("prodType"));

        minAmountCol.setCellValueFactory(
                 new PropertyValueFactory<Rule, Integer>("minAmount"));

        maxAmountCol.setCellValueFactory(
                 new PropertyValueFactory<Rule, Integer>("maxAmount"));

        minValCol.setCellValueFactory(
                 new PropertyValueFactory<Rule, Integer>("minPrice"));
        
        maxValCol.setCellValueFactory(
                 new PropertyValueFactory<Rule, Integer>("maxPrice"));
       
        srcCountryCol.setCellValueFactory(
                 new PropertyValueFactory<Rule, String>("country"));
        
        transWayCol.setCellValueFactory(
                 new PropertyValueFactory<Rule, String>("transWay"));
        
        companyCol.setCellValueFactory(
                 new PropertyValueFactory<Rule, String>("company"));
        
        totalValCol.setCellValueFactory(
                 new PropertyValueFactory<Rule, String>("totalVal"));
        
        setCellsEditable();

        ruleTable.setItems(data);
        
    }
    private void setCellsEditable(){
       
        //Set Cells Editable
        Callback<TableColumn, TableCell> cellFactory =
              new Callback<TableColumn, TableCell>() {
                  public TableCell call(TableColumn p) {
                      return new EditingCell();
                  }
              };
        minAmountCol.setCellFactory(cellFactory);
        minAmountCol.setOnEditCommit(
              new EventHandler<TableColumn.CellEditEvent<Rule, Integer>>() {
                  @Override public void handle(TableColumn.CellEditEvent<Rule, Integer> t) {
                        Rule r=null;
                        try{  
                            errLabel.setVisible(false);
                            r=((Rule)t.getTableView().getItems().get(
                                    t.getTablePosition().getRow()));
                            r.setMinAmount(t.getNewValue());
                            ruleDao.updateRule((Rule)t.getTableView().getItems().get(
                                    t.getTablePosition().getRow()));
                        }catch(Exception e){
                           
                            errLabel.setText(e.getMessage());
                            errLabel.setVisible(true);
                            t.getTableView().getItems().set(t.getTablePosition().getRow(),r);
                        }
    
                  }
              });
        
        maxAmountCol.setCellFactory(cellFactory);
        maxAmountCol.setOnEditCommit(
              new EventHandler<TableColumn.CellEditEvent<Rule, Integer>>() {
                  @Override public void handle(TableColumn.CellEditEvent<Rule, Integer> t) {
                        Rule r=null;
                        try{  
                            errLabel.setVisible(false);
                            r=(Rule)t.getTableView().getItems().get(
                                    t.getTablePosition().getRow());
                            r.setMaxAmount(t.getNewValue());
                            ruleDao.updateRule(r);
                        }catch(Exception e){
                           
                            errLabel.setText(e.getMessage());
                            errLabel.setVisible(true);
                            t.getTableView().getItems().set(t.getTablePosition().getRow(),r);

                        }
    
                  }
              });
       
        minValCol.setCellFactory(cellFactory);
        minValCol.setOnEditCommit(
              new EventHandler<TableColumn.CellEditEvent<Rule, Integer>>() {
                  @Override public void handle(TableColumn.CellEditEvent<Rule, Integer> t) {
                        Rule r=null;
                        try{  
                            errLabel.setVisible(false);
                            r=(Rule)t.getTableView().getItems().get(
                                    t.getTablePosition().getRow());
                            r.setMaxAmount(t.getNewValue());
                            ruleDao.updateRule(r);
                        }catch(Exception e){
                           
                            errLabel.setText(e.getMessage());
                            errLabel.setVisible(true);
                            t.getTableView().getItems().set(t.getTablePosition().getRow(),r);
                        }
    
                  }
              });
        
        maxValCol.setCellFactory(cellFactory);
        maxValCol.setOnEditCommit(
              new EventHandler<TableColumn.CellEditEvent<Rule, Integer>>() {
                  @Override public void handle(TableColumn.CellEditEvent<Rule, Integer> t) {
                        Rule r=null;
                        try{  
                            errLabel.setVisible(false);
                            r=(Rule)t.getTableView().getItems().get(
                                    t.getTablePosition().getRow());
                            r.setMaxAmount(t.getNewValue());
                            ruleDao.updateRule(r);
                        }catch(Exception e){
                           
                            errLabel.setText(e.getMessage());
                            errLabel.setVisible(true);
                            t.getTableView().getItems().set(t.getTablePosition().getRow(),r);

                        }
    
                  }
              });
        
        totalValCol.setCellFactory(cellFactory);
        totalValCol.setOnEditCommit(
              new EventHandler<TableColumn.CellEditEvent<Rule, Integer>>() {
                  @Override public void handle(TableColumn.CellEditEvent<Rule, Integer> t) {
                        Rule r=null;
                        try{  
                            errLabel.setVisible(false);
                            r=(Rule)t.getTableView().getItems().get(
                                    t.getTablePosition().getRow());
                            r.setTotalVal(t.getNewValue());
                            ruleDao.updateRule(r);
                        }catch(Exception e){
                           
                            errLabel.setText(e.getMessage());
                            errLabel.setVisible(true);
                            t.getTableView().getItems().set(t.getTablePosition().getRow(),r);

                        }
    
                  }
              });
       
        srcCountryCol.setCellFactory(TextFieldTableCell.forTableColumn());
        srcCountryCol.setOnEditCommit(
            new EventHandler<TableColumn.CellEditEvent<Rule, String>>() {
                @Override
                public void handle(TableColumn.CellEditEvent<Rule, String> t) {
                    Rule r=null;
                    try{
                        errLabel.setVisible(false);
                        r=(Rule) t.getTableView()
                                .getItems().get(t.getTablePosition().getRow());
                        r.setCountry(t.getNewValue());
                       
                        ruleDao.updateRule(r);
                    }catch(Exception e){
                        errLabel.setText(e.getMessage());
                        errLabel.setVisible(true);
                        t.getTableView().getItems().set(t.getTablePosition().getRow(),r);

                    }
                    
                }
            }
        );
      
       transWayCol.setCellFactory(TextFieldTableCell.forTableColumn());
        transWayCol.setOnEditCommit(
            new EventHandler<TableColumn.CellEditEvent<Rule, String>>() {
                @Override
                public void handle(TableColumn.CellEditEvent<Rule, String> t) {
                    Rule r=null;
                    try{
                        errLabel.setVisible(false);
                        r=(Rule) t.getTableView()
                                .getItems().get(t.getTablePosition().getRow());
                        r.setTransWay(t.getNewValue());
                        ruleDao.updateRule(r);
                    }catch(Exception e){
                        errLabel.setText(e.getMessage());
                        errLabel.setVisible(true);
                        t.getTableView().getItems().set(t.getTablePosition().getRow(),r);
                                
                    }
                    
                }
            }
        );
       
        companyCol.setCellFactory(TextFieldTableCell.forTableColumn());
        companyCol.setOnEditCommit(
            new EventHandler<TableColumn.CellEditEvent<Rule, String>>() {
                @Override
                public void handle(TableColumn.CellEditEvent<Rule, String> t) {
                    Rule r=null;
                    try{
                        errLabel.setVisible(false);
                        r=(Rule) t.getTableView()
                                .getItems().get(t.getTablePosition().getRow());
                        r.setCompany(t.getNewValue());
                        ruleDao.updateRule(r);
                    }catch(Exception e){
                        errLabel.setText(e.getMessage());
                        errLabel.setVisible(true);
                        t.getTableView().getItems().set(t.getTablePosition().getRow(),r);
                    }
                    
                }
            }
        );
        
    }
    
    class EditingCell extends TableCell<Rule, Integer> {
 
        private TextField textField;

        public EditingCell() {}

        @Override
        public void startEdit() {
            super.startEdit();

            if (textField == null) {
                createTextField();
            }

            setGraphic(textField);
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            textField.selectAll();
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();

            setText(String.valueOf(getItem()));
            setContentDisplay(ContentDisplay.TEXT_ONLY);
        }

        @Override
        public void updateItem(Integer item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (textField != null) {
                        textField.setText(getString());
                    }
                    setGraphic(textField);
                    setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                } else {
                    setText(getString());
                    setContentDisplay(ContentDisplay.TEXT_ONLY);
                }
            }
        }

        private void createTextField() {
            textField = new TextField(getString());
            textField.setMinWidth(this.getWidth() - this.getGraphicTextGap()*2);
            textField.setOnKeyPressed(new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent t) {
                    if (t.getCode() == KeyCode.ENTER) {
                        commitEdit(Integer.parseInt(textField.getText()));
                    } else if (t.getCode() == KeyCode.ESCAPE) {
                        cancelEdit();
                    }
                }
            });
        }
     
        private String getString() {
            return getItem() == null ? "" : getItem().toString();
        }
    }
    
    
    @FXML
    public void onShowLicsBtnAction(ActionEvent event) {
        errLabel.setVisible(false);
        ObservableList<Rule> ruleSelected = ruleTable.getSelectionModel().getSelectedItems();
        for(Rule r : ruleSelected){
            System.out.println("ID : "+r.getRuleID());
            try{
                UIManager uiManager=new UIManager();
                uiManager.setupAddLicTypeTable(((Node) event.getSource()).getScene().getWindow(),r.getRuleID());
            }
            catch(Exception e){
                errLabel.setText("* متاسفانه مشکلی در حین نمایش پیش آمد");
                errLabel.setVisible(true);
            }
        }
       
    }
     
    @FXML
    public void onDelBtnAction(ActionEvent event) {
        System.out.println("delete action");
        ObservableList<Rule> ruleSelected;
       
        ruleSelected=ruleTable.getSelectionModel().getSelectedItems();
        for(Rule r : ruleSelected){
            System.out.println("ID : "+r.getRuleID());
            data.remove(r);
            ruleDao.deleteRule(r.getRuleID());
        }
        
    }
}
