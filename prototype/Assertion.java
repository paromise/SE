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

public class Assertion extends JFrame{
	JLabel nationalIdentityLabel = new JLabel("شناسه ملی تاجر ");
	JLabel nameLabel = new JLabel ("نام و نام خانوادگی تاجر ");
	JLabel assertDateLabel = new JLabel("تاریخ اظهار");
	JLabel wholePriceLabel = new JLabel("ارزش کلی کالاها به دلار");
	JLabel srcCountryLabel = new JLabel("کشور مبدا");
	JLabel importionWayLabel = new JLabel("نحوه ورود به کشور");
	JLabel quantityLabel = new JLabel("تعداد کالا");
	
	JTextField  nationalIdentityTxtField = new JTextField();
	JTextField  nameTxtField= new JTextField ();
	JTextField  assertDateTxtField = new JTextField();
	JTextField  wholePriceTxtField= new JTextField();
	JTextField  srcCountryTxtField = new JTextField();
	JTextField  importionWayTxtField = new JTextField();
	JTextField  quantityTxtField = new JTextField();

	JButton submitButton = new JButton("ثبت");
	JButton cancelButton = new JButton("لغو");
    JButton addProductsButton = new JButton ("افزودن");
	JButton addLicensesButton = new JButton ("افزودن شماره مجوزها");

	private String[] importationWayChoices = new String[]{"هوایی","دریایی","زمینی"} ;
	private JComboBox<String> importionWayBox = new JComboBox<>(importationWayChoices);
	

	public Assertion(){
		GroupLayout gl = new GroupLayout(getContentPane());
		getContentPane().setLayout(gl);
		gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);
        setSize(500,500);
        setLocationRelativeTo(null);

        gl.setHorizontalGroup( gl.createSequentialGroup()
        	.addGroup( gl.createParallelGroup(LEADING)
        		.addComponent(addProductsButton)
        		.addComponent(submitButton)
        	)

        	.addGroup( gl.createParallelGroup(LEADING)
        				.addComponent(nationalIdentityTxtField)
        				.addComponent(nameTxtField)
        				.addComponent(assertDateTxtField)
        				.addComponent(wholePriceTxtField)
        				.addComponent(srcCountryTxtField)
        				.addComponent(importionWayBox)
        				.addComponent(quantityTxtField)
        				.addComponent(cancelButton) 
                        .addComponent(addLicensesButton)
        				)
        	.addGroup( gl.createParallelGroup(LEADING)
        				.addComponent(nationalIdentityLabel)
        				.addComponent(nameLabel)
        				.addComponent(assertDateLabel)
        				.addComponent(wholePriceLabel)
        				.addComponent(srcCountryLabel)
        				.addComponent(importionWayLabel)
        				.addComponent(quantityLabel)
        				 )
     
		);

		gl.setVerticalGroup( gl.createSequentialGroup()
			.addGroup( gl.createParallelGroup(BASELINE)
						.addComponent(nationalIdentityLabel)
						.addComponent(nationalIdentityTxtField) )
			
			.addGroup( gl.createParallelGroup(LEADING)
						.addComponent(nameLabel)
						.addComponent(nameTxtField) )

			.addGroup( gl.createParallelGroup(LEADING)
						.addComponent(assertDateLabel)
						.addComponent(assertDateTxtField) )

			.addGroup( gl.createParallelGroup(LEADING)
						.addComponent(wholePriceLabel)
						.addComponent(wholePriceTxtField) )

			.addGroup( gl.createParallelGroup(LEADING)
						.addComponent(srcCountryLabel)
						.addComponent(srcCountryTxtField) )

			.addGroup( gl.createParallelGroup(LEADING)
						.addComponent(importionWayLabel)
						.addComponent(importionWayBox) )

			.addGroup( gl.createParallelGroup(LEADING)
						.addComponent(quantityLabel)
						.addComponent(quantityTxtField)
						.addComponent(addProductsButton) )
            .addGroup( gl.createParallelGroup(LEADING)
                        .addComponent(addLicensesButton) )
			.addGroup( gl.createParallelGroup(LEADING)
						.addComponent(cancelButton)
						.addComponent(submitButton) )

		);

		cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                setVisible(false);
                dispose();
                new LoginPage().setVisible(true);
            }
        });

        submitButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent event){
        		System.exit(0);
        	}
        });

        addProductsButton.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent event){
                if(!quantityTxtField.getText().equals(""))
        		  new ProductsInputPage(Integer.parseInt(quantityTxtField.getText()) ).setVisible(true);
        	}

        });

        addLicensesButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                
                  new Licenses().setVisible(true);
            }

        });


		setTitle("فرم اظهار نامه");
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}
	/*public static void main(String args[]) {
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
                new Assertion().setVisible(true);
            }
        });
    }*/
}