/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.customs.CustomsUndertaker.UI;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import se.customs.CustomsUndertaker.dao.ProductDAO;
import se.customs.CustomsUndertaker.service.DeclManager;
import se.customs.CustomsUndertaker.pojo.Product;
import se.customs.EconomicMinisRepres.dao.RuleDAO;
import se.customs.UIManagement.UIManager;


/**
 *
 * @author faeze
 */
public class ProductsTableFXMLCtrl implements Initializable {
    @FXML
    private Button addBtn;
    
    @FXML
    private Button delBtn;
    @FXML
    private TextField nameTxtFld;
    
    
    @FXML
    private TextField amountTxtFld;
    
    @FXML
    private TextField CompanyTxtFld;
    
    @FXML
    private TextField unitPriceTxtFld;
    

    
    @FXML
    private ChoiceBox<String> UnitChcBox;
    
    @FXML
    private ChoiceBox<String> prodTypeChcBox;
   
    @FXML 
    private Label errLabel;
    
    @FXML 
    private Label totalPriceLbl;
    
    @FXML
    private TableView table;
    
    @FXML
    private TableColumn nameCol;
    
    @FXML
    private TableColumn amountCol;
    
    @FXML
    private TableColumn companyCol;
   
    @FXML
    private TableColumn unitPriceCol;
 
    Integer id;
    String declValidity="invalid";
    
    private final ObservableList<Product> data=FXCollections.observableArrayList();
    private ProductDAO productDao=new ProductDAO();
    private RuleDAO ruleDao = new RuleDAO();
    private DeclManager declMng = new DeclManager();
    ArrayList <String> distinctProdTypes=new ArrayList<String>();
    
    /*public ProductsTableFXMLCtrl(String merchantId,String declDate,String srcCountry){
         
        UIManager.setAppScene("productsTabel");
        if(merchantId==null || declDate==null || srcCountry==null){
             errLabel.setText("* ههه");
             errLabel.setVisible(true);
        }
        if(merchantId.equals("") || declDate.equals("") || srcCountry.equals("")){
            errLabel.setText("* هi,i,");
             errLabel.setVisible(true);
        }
        MERCHANTID=merchantId;
        DECLDATE=declDate;
        SRCCOUNTRY=srcCountry;
       
        
        
        
        
        
        
    }*/
    
    public void init_data(int _id){
        id=_id;
        declValidity=declMng.getDeclValidity(id);
        if(declValidity.equals("valid")){
            addBtn.setVisible(false);
            nameTxtFld.setVisible(false);
            amountTxtFld.setVisible(false);
            CompanyTxtFld.setVisible(false);
            unitPriceTxtFld.setVisible(false);
            UnitChcBox.setVisible(false);
            prodTypeChcBox.setVisible(false);
            totalPriceLbl.setVisible(false);
            delBtn.setVisible(false);
         
    
        }
        else{
                distinctProdTypes=(ArrayList <String>) ruleDao.listProductTypes();
                if(distinctProdTypes==null){
                    errLabel.setText("* هیچ نوع کالایی در سیستم ثبت نشده!");
                    addBtn.setDisable(true); 
                    
                }
                else{
                    ObservableList<String> prodTypeList=FXCollections.observableArrayList(distinctProdTypes);
                    prodTypeChcBox.setItems(prodTypeList);
                    

                }

                totalPriceLbl.setText(Float.toString(declMng.getTotalVal(id)));
        }
      
        ArrayList<Product> prods=productDao.findProductsByDeclId(id);
        if(prods!=null){
            System.out.println("ProdTableFXMLCtrl/declID :"+id);
            for(Product p : prods){

                data.add(p);
            }
        }
        else{
            System.out.println("ProdTableFXMLCtrl/declID products"+id+" Null has");
        }
        
    }

    public ProductsTableFXMLCtrl() {
      // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        System.out.println("Initializing...");
        ArrayList<String> units =  new ArrayList<String>();
        units.add("تعداد");
        units.add("کیلوگرم");
        units.add("تن");
        
        
        
       
        ObservableList<String> list = FXCollections.observableArrayList(units);
        
        UnitChcBox.setItems(list);
        table.setEditable(true);
        
        nameCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("name"));
        

        
        amountCol.setCellValueFactory(
                new PropertyValueFactory<Product, Float>("amount"));
        
        
        companyCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("company"));
        
        unitPriceCol.setCellValueFactory(
                new PropertyValueFactory<Product, String>("unitPrice"));
        
        table.setItems(data);
    }    
    
    @FXML
    public void onAddBtnAction(ActionEvent event) {
        Button clickedBtn=(Button) event.getSource();
        String clickedBtnId=(String) clickedBtn.getId();
        
        String name = nameTxtFld.getText();
        String proType = prodTypeChcBox.getValue();
        String amount = amountTxtFld.getText();
        String unit=UnitChcBox.getValue();
        String company=CompanyTxtFld.getText();
        String unitPrice=unitPriceTxtFld.getText();
        
        if(unit==null){
            unit="";
        }
        
        float amountVal=0;
        int numVal=0;
        int unitPriceVal=0;
        
        boolean hasErr=false;
        
     

        if(name.equals("") || amount.equals("")
               || company.equals("") || unitPrice.equals("") || proType.equals("")){
             errLabel.setText("* هیچ یک از فیلدها نمی تواند خالی باشد");
             errLabel.setVisible(true);
             hasErr=true;
        }
        
        else if(!distinctProdTypes.contains(proType)){
            errLabel.setText("* نوع کالای وارد شده معتبر نیست");
            errLabel.setVisible(true);
            hasErr=true;
        }
        else{
                try{
                    amountVal=Float.parseFloat(amount);
                    
                    unitPriceVal=Integer.parseInt(unitPrice);

                }catch(Exception e){
                    errLabel.setText("* مقدار وزن و تعداد و قیمت واحد باید عدد باشد");
                    errLabel.setVisible(true);
                    hasErr=true;
                }
        }
        
        
        
        
        if(!hasErr){
           
            Product pro=new Product(name,company,amountVal,unit
                                ,unitPriceVal,id,proType);
            if(productDao.addProduct(pro)==null){
                errLabel.setText("* متاسفانه مشکلی در حین افزودن پیش أمده است");
                errLabel.setVisible(true);
                hasErr=true;
            }
            else{
                errLabel.setVisible(false);
                data.add(pro);
                declMng.addToTotalVal(unitPriceVal*amountVal, id);
                totalPriceLbl.setText(Float.toString(declMng.getTotalVal(id)));
                nameTxtFld.clear();
                amountTxtFld.clear();
                CompanyTxtFld.clear();
                unitPriceTxtFld.clear();
            }
            
        }
        
        
    }
    
    @FXML
    public void onDelBtnAction(ActionEvent event) {
        ObservableList<Product> prodSelected;
       
        prodSelected=table.getSelectionModel().getSelectedItems();
        for(Product p : prodSelected){
            
            data.remove(p);
            productDao.deleteProductById(p.getProID());
            declMng.withdrawTotalVal(p.getUnitPrice()*p.getAmount(), p.getDECLID());
            totalPriceLbl.setText(Float.toString(declMng.getTotalVal(id)));
            
        }
    }
    
}