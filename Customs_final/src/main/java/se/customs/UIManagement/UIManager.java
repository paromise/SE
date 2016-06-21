/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.customs.UIManagement;

import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import se.customs.CustomsUndertaker.UI.ProductsTableFXMLCtrl;
import se.customs.CustomsUndertaker.UI.ShowDeclDetailsFXMLCtrl;
import se.customs.EconomicMinisRepres.UI.AddReqLicTypeFXMLCtrl;
import se.customs.GetLicense.UI.GetLicenseFXMLController;
//import se.customs.EconomicMinisRepres.UI.EditableReqLicsFXMLController;
import se.customs.GetLicense.UI.ProductsTable2FXMLCtrl;
import se.customs.LicenseManagement.UI.LicenseTableFXMLCtrl;
/**
 *
 * @author faeze
 */

public class UIManager extends Application{
    private FlowPane pane1, pane2;
    private static Scene loginScene, customsUndertakerScene, getLicenseScene;
    private static Stage thestage;
    
    public UIManager(){
        
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        thestage=primaryStage;
        
        Platform.setImplicitExit(false);
        //try{
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/fxml/LoginFXML.fxml"));
           
           // Parent productsTabelRoot = FXMLLoader.load(getClass().getResource("/fxml/ProductsTableFXML.fxml"));

        //}
      //  catch(Exception e){
       //     System.out.println("Cannot find fxml files");
      //      System.exit(0);
      //  }
        
        
        
        
    
        
        loginScene = new Scene(loginRoot);
       
       
        
        primaryStage.setTitle("نرم افزار جامع مدیریت گمرک");
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }
    
    public static void setAppScene(String sceneName){
        if(sceneName.equals("login")){
            thestage.setScene(loginScene);
        }
        else if(sceneName.equals("customsUndertaker")){
            thestage.setScene(customsUndertakerScene);
        }
        else if(sceneName.equals("getLicence")) {
            thestage.setScene(getLicenseScene);
        }
    }
    
    public void setupProductsTable(Window existingWindow,int id) throws IOException{
        
   
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ProductsTableFXML.fxml"));
        Stage stage = new Stage();
        // make it modal:
        stage.initModality(Modality.APPLICATION_MODAL);
        // make its owner the existing window:
        stage.initOwner(existingWindow);
        stage.setScene(new Scene((Pane) loader.load()));
        stage.show();
        ProductsTableFXMLCtrl proTableCtrl= loader.<ProductsTableFXMLCtrl>getController();
        proTableCtrl.init_data(id);

    }
    
    public void setupProductsTable2(Window existingWindow, int id) throws IOException{
        
   
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ProductsTable2FXML.fxml"));
        Stage stage = new Stage();
        // make it modal:
        stage.initModality(Modality.APPLICATION_MODAL);
        // make its owner the existing window:
        stage.initOwner(existingWindow);
        stage.setScene(new Scene((Pane) loader.load()));
        stage.show();
        ProductsTable2FXMLCtrl proTableCtrl= loader.<ProductsTable2FXMLCtrl>getController();
        proTableCtrl.init_data(id);

    }
    
    public void setupShowDeclDetailsPage(Window existingWindow, int id) throws IOException{
        
   
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ShowDeclDetailsFXML.fxml"));
        Stage stage = new Stage();
        // make it modal:
        stage.initModality(Modality.APPLICATION_MODAL);
        // make its owner the existing window:
        stage.initOwner(existingWindow);
        stage.setScene(new Scene((Pane) loader.load()));
        stage.show();
        ShowDeclDetailsFXMLCtrl  ShowDeclDetailsCtrl= loader.<ShowDeclDetailsFXMLCtrl>getController();
        ShowDeclDetailsCtrl.init_data(id);

    }
     
    
     public void setupAddLicTypeTable(Window existingWindow, int id) throws IOException{
        
   
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/addReqLicTypeFXML.fxml"));
        Stage stage = new Stage();
        // make it modal:
        stage.initModality(Modality.APPLICATION_MODAL);
        // make its owner the existing window:
        stage.initOwner(existingWindow);
        stage.setScene(new Scene((Pane) loader.load()));
        stage.show();
        AddReqLicTypeFXMLCtrl addLicTypeTableCtrl= loader.<AddReqLicTypeFXMLCtrl>getController();
        addLicTypeTableCtrl.init_data(id);

    }
     
//    public void setupEditableLicTypeTable(Window existingWindow, int id) throws IOException{
//        
//   
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/EditableReqLicsFXML.fxml"));
//        Stage stage = new Stage();
//        // make it modal:
//        stage.initModality(Modality.APPLICATION_MODAL);
//        // make its owner the existing window:
//        stage.initOwner(existingWindow);
//        stage.setScene(new Scene((Pane) loader.load()));
//        stage.show();
//        EditableReqLicsFXMLController  EditableReqLicsFXMLController= loader.< EditableReqLicsFXMLController>getController();
//        EditableReqLicsFXMLController.init_data(id);
//
//    }
    
    
    public void setupCustomsUndertakerPage(Window existingWindow) throws IOException{
        Parent customsUndertakerRoot = FXMLLoader.load(getClass().getResource("/fxml/CustomsUndertakerFXML.fxml"));
        customsUndertakerScene = new Scene(customsUndertakerRoot);
        // Window existingWindow = ((Node) event.getSource()).getScene().getWindow();

        Stage stage = new Stage();
        // make it modal:
        stage.initModality(Modality.APPLICATION_MODAL);
        // make its owner the existing window:
        stage.initOwner(existingWindow);

        stage.setScene(customsUndertakerScene);
        stage.show();
    }
    
    public void setupGetLicensePage(Window existingWindow,String username) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/GetLicenseFXML.fxml"));
        Stage stage = new Stage();
        // make it modal:
        stage.initModality(Modality.APPLICATION_MODAL);
        // make its owner the existing window:
        stage.initOwner(existingWindow);
        stage.setScene(new Scene((Pane) loader.load()));
        stage.show();
        GetLicenseFXMLController GetLicenseCtrl= loader.<GetLicenseFXMLController>getController();
        GetLicenseCtrl.init_data(username);
    }
    
    public void setupLicensesTable(Window existingWindow,ArrayList <String> licTypes,String merchantNatId,Integer declID) throws IOException{
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LicenseTableFXML.fxml"));
        Stage stage = new Stage();
        // make it modal:
        stage.initModality(Modality.APPLICATION_MODAL);
        // make its owner the existing window:
        stage.initOwner(existingWindow);
        stage.setScene(new Scene((Pane) loader.load()));
        stage.show();
        LicenseTableFXMLCtrl licTableCtrl= loader.<LicenseTableFXMLCtrl>getController();
        licTableCtrl.init_data(licTypes,merchantNatId,declID);
   
       
    }
    
    public void setupEconomicMinisRepresPage(Window existingWindow) throws IOException{
        
   
//        Parent EconomicMinisRepresRoot = FXMLLoader.load(getClass().getResource("/fxml/AddRuleFXML.fmxl"));
        Parent EconomicMinisRepresRoot = FXMLLoader.load(getClass().getResource("/fxml/EconomicMinisRepresFXML.fxml"));
        Scene EconomicMinisRepresScene = new Scene(EconomicMinisRepresRoot);
        // Window existingWindow = ((Node) event.getSource()).getScene().getWindow();

        Stage stage = new Stage();
        // make it modal:
        stage.initModality(Modality.APPLICATION_MODAL);
        // make its owner the existing window:
        stage.initOwner(existingWindow);

        stage.setScene(EconomicMinisRepresScene);
        stage.show();
    }
    
    public void setupCUmenuPage(Window existingWindow) throws IOException{
        
//        Parent EconomicMinisRepresRoot = FXMLLoader.load(getClass().getResource("/fxml/AddRuleFXML.fmxl"));
        Parent CUmenuRoot = FXMLLoader.load(getClass().getResource("/fxml/CUmenu.fxml"));
        Scene CUmenuRootScene = new Scene(CUmenuRoot);
        // Window existingWindow = ((Node) event.getSource()).getScene().getWindow();

        Stage stage = new Stage();
        // make it modal:
        stage.initModality(Modality.APPLICATION_MODAL);
        // make its owner the existing window:
        stage.initOwner(existingWindow);

        stage.setScene(CUmenuRootScene);
        stage.show();
    }

    public void setupAddRolePage(Window existingWindow) throws IOException{
        Parent addRoleRoot = FXMLLoader.load(getClass().getResource("/fxml/AddRole.fxml"));

        Stage stage = new Stage();
        // make it modal:
        stage.initModality(Modality.APPLICATION_MODAL);
        // make its owner the existing window:
        stage.initOwner(existingWindow);

        stage.setScene(new Scene(addRoleRoot));
        stage.show();
    }
    
    public void setupAddPrimLicTypePage(Window existingWindow) throws IOException{
        
   
//        Parent EconomicMinisRepresRoot = FXMLLoader.load(getClass().getResource("/fxml/AddRuleFXML.fmxl"));
        Parent AddPrimLicRoot = FXMLLoader.load(getClass().getResource("/fxml/addLicenseTypeFXML.fxml"));
        Scene AddPrimLicScene = new Scene(AddPrimLicRoot);
        // Window existingWindow = ((Node) event.getSource()).getScene().getWindow();

        Stage stage = new Stage();
        // make it modal:
        stage.initModality(Modality.APPLICATION_MODAL);
        // make its owner the existing window:
        stage.initOwner(existingWindow);

        stage.setScene(AddPrimLicScene);
        stage.show();
    }
    

    public void setupAddUserPage(Window existingWindow) throws IOException{
        Parent addRoleRoot = FXMLLoader.load(getClass().getResource("/fxml/AddUser.fxml"));

        Stage stage = new Stage();
        // make it modal:
        stage.initModality(Modality.APPLICATION_MODAL);
        // make its owner the existing window:
        stage.initOwner(existingWindow);

        stage.setScene(new Scene(addRoleRoot));
        stage.show();
    }

     public void setupRuleTable(Window existingWindow) throws IOException{
        
   
        
        Parent RuleTableRoot = FXMLLoader.load(getClass().getResource("/fxml/RuleTableFXML.fxml"));
        Scene RuleTableScene = new Scene(RuleTableRoot);
       

        Stage stage = new Stage();
        // make it modal:
        stage.initModality(Modality.APPLICATION_MODAL);
        // make its owner the existing window:
        stage.initOwner(existingWindow);

        stage.setScene(RuleTableScene);
        stage.show();
    }
     
     public void setupAddRulePage(Window existingWindow) throws IOException{
        
   
        
        Parent AddRuleRoot = FXMLLoader.load(getClass().getResource("/fxml/AddRuleFXML.fxml"));
        Scene AddRuleScene = new Scene(AddRuleRoot);
       

        Stage stage = new Stage();
        // make it modal:
        stage.initModality(Modality.APPLICATION_MODAL);
        // make its owner the existing window:
        stage.initOwner(existingWindow);

        stage.setScene(AddRuleScene);
        stage.show();
    }
  

}
