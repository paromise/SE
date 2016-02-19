import java.awt.Component;
import javax.swing.*;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.io.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
	
import static javax.swing.GroupLayout.Alignment.*;

public class LoginPage extends JFrame{
	JLabel usernameLabel = new JLabel("نام کاربری ");
	JLabel passwordLabel = new JLabel ("رمز عبور ");
	JLabel pageLabel = new JLabel("نوع صفحه");
	
	
	JTextField  usernameTxtField = new JTextField();
	JTextField  passwordTxtField= new JTextField ();
	JTextField  pageTxtField = new JTextField();
	

	JButton submitButton = new JButton("ورود");
	JButton cancelButton = new JButton("لغو");
   

	private String[] pageChoices = new String[]{"مسئول گمرک","نماینده اقتصاد","نماینده وزابتخانه","مجوزهای مورد نیاز"} ;
	private JComboBox<String> pageChoicesBox = new JComboBox<>(pageChoices);
	

	public LoginPage(){
		GroupLayout gl = new GroupLayout(getContentPane());
		getContentPane().setLayout(gl);
		gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);
        setSize(500,500);
        setLocationRelativeTo(null);

        gl.setHorizontalGroup( gl.createSequentialGroup()
        	.addGroup( gl.createParallelGroup(LEADING)
	        			.addComponent(usernameLabel)
		        		.addComponent(passwordLabel)
		        		.addComponent(pageLabel)
		        		.addComponent(submitButton)
        	)

        	.addGroup( gl.createParallelGroup(LEADING)
        				.addComponent(usernameTxtField)
        				.addComponent(passwordTxtField)
        				.addComponent(pageChoicesBox)
        				.addComponent(cancelButton)
        				)
     
		);

		gl.setVerticalGroup( gl.createSequentialGroup()
			.addGroup( gl.createParallelGroup(BASELINE)
						.addComponent(usernameLabel)
						.addComponent(usernameTxtField) )
			
			.addGroup( gl.createParallelGroup(LEADING)
						.addComponent(passwordLabel)
						.addComponent(passwordTxtField) )

			.addGroup( gl.createParallelGroup(LEADING)
						.addComponent(pageLabel)
						.addComponent(pageChoicesBox) )

			.addGroup( gl.createParallelGroup(LEADING)
						.addComponent(submitButton)
						.addComponent(cancelButton) )


		);

		cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        submitButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent event){
        		String selectedPage = (String) pageChoicesBox.getSelectedItem();
        		if(selectedPage.equals("مسئول گمرک"))
        		{
        			setVisible(false);
        			dispose();
        			new Assertion().setVisible(true);
        		}
 
        		else if(selectedPage.equals("نماینده اقتصاد"))
        		{
        			setVisible(false);
        			dispose();
        			new Rules().setVisible(true);
        		}

        		else if(selectedPage.equals("نماینده وزابتخانه"))
        		{
        			setVisible(false);
        			dispose();
        			new MinistriesAgentsPage().setVisible(true);
        		}
        		else if(selectedPage.equals("مجوزهای مورد نیاز"))
        		{
        			setVisible(false);
        			dispose();
        			new Page1().setVisible(true);
        		}
        		
        		
        	}
        });

    


		setTitle("صفحه ورود");
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}
	public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(
                                  "javax.swing.plaf.metal.MetalLookAndFeel");
                                //  "com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                                //UIManager.getCrossPlatformLookAndFeelClassName());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                new LoginPage().setVisible(true);
            }
        });
    }
}