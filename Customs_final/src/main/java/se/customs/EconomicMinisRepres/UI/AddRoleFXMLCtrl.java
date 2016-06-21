/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.customs.EconomicMinisRepres.UI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.control.*;
import se.customs.EconomicMinisRepres.dao.RoleDAO;
import se.customs.EconomicMinisRepres.pojo.Role;
import se.customs.UIManagement.UIManager;

/**
 * FXML Controller class
 *
 * @author golrokh
 */
public class AddRoleFXMLCtrl implements Initializable {
   
    @FXML
    private TextField addRoleTxtFld;

    @FXML
    private Button addRoleBtn;

    @FXML
    private Label errLabel;
    
    private final RoleDAO dao = new RoleDAO();

    /**
     * Initializes the controller class.
     */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		errLabel.setVisible(false);
    	}
    	
	@FXML
	public void handleButtonAction(ActionEvent event) throws IOException {
        Button clickedBtn=(Button) event.getSource();
        String clickedBtnId=(String) clickedBtn.getId();
        
        String role = addRoleTxtFld.getText();

        if(clickedBtnId.equals("addRoleBtn")){
            if(role.equals("")){
                    errLabel.setText("* ابتدا نقش جدید را وارد کنید");
                    errLabel.setVisible(true);
            }
            else if(dao.findRole(role) != null){
                    errLabel.setText("این نقش در حال حاضر وجود دارد");
                    errLabel.setVisible(true);
            }
            else{
                    dao.addRole(new Role(role));
            }

            addRoleTxtFld.clear();
            addRoleTxtFld.setDisable(false);

        }
    }    

}
