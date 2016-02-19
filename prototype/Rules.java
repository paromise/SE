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

public class Rules extends JFrame{
	JLabel startTimeLabel = new JLabel("از تاریخ");
	JLabel endTimeLabel = new JLabel ("تا تاریخ");
	JLabel factoryNameLabel = new JLabel("شرکت");
	JLabel weightRangeLabel = new JLabel("رنج وزن");
       	JLabel quantityRangeLabel = new JLabel("حد تعداد کلی");	
	JLabel wholePriceLabel = new JLabel("رنج قیمت کلی");
	JLabel srcCountryLabel = new JLabel("کشور مبدا");
	JLabel importionWayLabel = new JLabel("نحوه ورود به کشور");
	JLabel quantityLabel = new JLabel("تعداد کالا");
	JLabel licencesLabel = new JLabel("نام مجوز");

	JTextArea  startTimeTxtArea = new JTextArea();
	JTextArea  endTimeTxtArea= new JTextArea ();
	JTextArea  factoryNameTxtArea = new JTextArea();
	JTextArea weightRangeTxtArea = new JTextArea();
       	JTextArea quantityRangeTxtArea = new JTextArea();	
	JTextArea  wholePriceTxtArea= new JTextArea();
	JTextArea  srcCountryTxtArea = new JTextArea();
	JTextArea  importionWayTxtArea = new JTextArea();
	JTextArea  quantityTxtArea = new JTextArea();
	JTextArea licencesTxtArea = new JTextArea();

	JButton submitButton = new JButton("ثبت");
	JButton cancelButton = new JButton("لغو");
	JButton addProductsButton = new JButton ("افزودن");
	JButton addLicencesButton = new JButton("افزودن");

	private String[] importationWayChoices = new String[]{"هوایی","دریایی","زمینی", "فزقی ندارد"} ;
	private JComboBox<String> importionWayBox = new JComboBox<>(importationWayChoices);
	

	public Rules(){
		GroupLayout gl = new GroupLayout(getContentPane());
		getContentPane().setLayout(gl);
		gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);
        setSize(500,500);
        setLocationRelativeTo(null);

        gl.setHorizontalGroup( gl.createSequentialGroup()
        	.addGroup( gl.createParallelGroup(LEADING)
        		.addComponent(addProductsButton)
			.addComponent(addLicencesButton)
        		.addComponent(submitButton)
        	)

        	.addGroup( gl.createParallelGroup(LEADING)
        				.addComponent(startTimeTxtArea)
        				.addComponent(endTimeTxtArea)
        				.addComponent(factoryNameTxtArea)
					.addComponent(weightRangeTxtArea)
					.addComponent(quantityRangeTxtArea)
        				.addComponent(wholePriceTxtArea)
        				.addComponent(srcCountryTxtArea)
        				.addComponent(importionWayBox)
        				.addComponent(quantityTxtArea)
					.addComponent(licencesTxtArea)
        				.addComponent(cancelButton) 
        				)
        	.addGroup( gl.createParallelGroup(LEADING)
        				.addComponent(startTimeLabel)
        				.addComponent(endTimeLabel)
        				.addComponent(factoryNameLabel)
					.addComponent(weightRangeLabel)
					.addComponent(quantityRangeLabel)
        				.addComponent(wholePriceLabel)
        				.addComponent(srcCountryLabel)
        				.addComponent(importionWayLabel)
        				.addComponent(quantityLabel)
					.addComponent(licencesLabel)
        				 )
     
		);

		gl.setVerticalGroup( gl.createSequentialGroup()
			.addGroup( gl.createParallelGroup(BASELINE)
						.addComponent(startTimeLabel)
						.addComponent(startTimeTxtArea) )
			
			.addGroup( gl.createParallelGroup(LEADING)
						.addComponent(endTimeLabel)
						.addComponent(endTimeTxtArea) )

			.addGroup( gl.createParallelGroup(LEADING)
						.addComponent(factoryNameLabel)
						.addComponent(factoryNameTxtArea) )
			
			.addGroup(gl.createParallelGroup(LEADING)
						.addComponent(weightRangeLabel)
						.addComponent(weightRangeTxtArea))
			
			.addGroup(gl.createParallelGroup(LEADING)
						.addComponent(quantityRangeLabel)
						.addComponent(quantityRangeTxtArea))

			.addGroup( gl.createParallelGroup(LEADING)
						.addComponent(wholePriceLabel)
						.addComponent(wholePriceTxtArea) )

			.addGroup( gl.createParallelGroup(LEADING)
						.addComponent(srcCountryLabel)
						.addComponent(srcCountryTxtArea) )

			.addGroup( gl.createParallelGroup(LEADING)
						.addComponent(importionWayLabel)
						.addComponent(importionWayBox) )

			.addGroup( gl.createParallelGroup(LEADING)
						.addComponent(quantityLabel)
						.addComponent(quantityTxtArea)
						.addComponent(addProductsButton) )

			.addGroup (gl.createParallelGroup(LEADING)
						.addComponent(licencesLabel)
						.addComponent(licencesTxtArea)
						.addComponent(addLicencesButton))

			.addGroup( gl.createParallelGroup(LEADING)
						.addComponent(cancelButton)
						.addComponent(submitButton))

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
				String curr = quantityTxtArea.getText();
				if(!curr.equals(""))
        			new ProductsInputPage(Integer.parseInt(quantityTxtArea.getText()) ).setVisible(true);
				quantityTxtArea.replaceRange("", 0, curr.length());
        	}

        });
	
		addLicencesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String curr = licencesTxtArea.getText();
				licencesTxtArea.replaceRange("", 0, curr.length());

			}
		});
		setTitle("فرم افزودن قوانین");
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
                new Rules().setVisible(true);
            }
        });
    }*/
}
