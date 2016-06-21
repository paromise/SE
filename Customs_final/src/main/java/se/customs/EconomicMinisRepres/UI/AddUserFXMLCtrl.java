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
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import se.customs.EconomicMinisRepres.dao.RoleDAO;
import se.customs.EconomicMinisRepres.dao.RuleDAO;
import se.customs.EconomicMinisRepres.pojo.Role;
import se.customs.UIManagement.UIManager;
import se.customs.UsersManagement.dao.CustomsUserDAO;
import se.customs.UsersManagement.pojo.CustomsUser;

/**
 * FXML Controller class
 *
 * @author golrokh
 */
public class AddUserFXMLCtrl implements Initializable {
   
    @FXML
    private TextField userNameTxtFld;
    
    @FXML
    private PasswordField passwordFld;
    
    
    
    @FXML
    private ChoiceBox<String> rolesChcBox;
    
    @FXML
    private Button addUserBtn;
    
    @FXML
    private Label errLabel;
    
    

   	private final CustomsUserDAO dao = new CustomsUserDAO();
        private RoleDAO rdao=new RoleDAO();
    /**
     * Initializes the controller class.
     */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		errLabel.setVisible(false);
                ArrayList<String> roles=new ArrayList<String>();
                for(Role r: (ArrayList<Role>) rdao.listRole()){
                    roles.add(r.getUserRole());
                }
                ObservableList<String> rolesList = FXCollections.observableArrayList(roles);
                rolesChcBox.setItems(rolesList);
    	}
    	
	@FXML
	public void handleButtonAction(ActionEvent event) throws IOException {
        Button clickedBtn=(Button) event.getSource();
        String clickedBtnId=(String) clickedBtn.getId();
        
        String userName = userNameTxtFld.getText();
        String password = passwordFld.getText();
        String role = rolesChcBox.getValue();

        if(clickedBtnId.equals("addUserBtn")){
        		if(userName.equals("") || password.equals("")){
        			errLabel.setText("* تمام فیلد ها باید پر شوند");
        			errLabel.setVisible(true);
        		}
        		else if(dao.findUserById(userName) != null){
        			errLabel.setText("این نام کاربری در حال حاضر وجود دارد");
        			errLabel.setVisible(true);
        		}
        		else{
                            try{
                                dao.addUser(new CustomsUser(userName, password, role));
 
                            }
                            catch(Exception e){
                                errLabel.setText("این نقش وجود ندارد");
        			errLabel.setVisible(true);
                            }
        		}

        		userNameTxtFld.clear();
                        passwordFld.clear();
                        
        		userNameTxtFld.setDisable(false);
        		passwordFld.setDisable(false);
                        

        }
        
    }      

}
