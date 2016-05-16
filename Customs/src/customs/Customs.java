/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author faeze
 */
public class Customs extends Application {
   
    FlowPane pane1, pane2;
    public static Scene loginScene, customsUndertakerScene;
    public static Stage thestage;
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        thestage=primaryStage;
        
        Parent loginRoot = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
        Parent customsUndertakerRoot = FXMLLoader.load(getClass().getResource("CustomsUndertakerFXML.fxml"));
        
        
        
    
        
        loginScene = new Scene(loginRoot);
        customsUndertakerScene = new Scene(customsUndertakerRoot);
        
        primaryStage.setTitle("نرم افزار جامع مدیریت گمرک");
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
