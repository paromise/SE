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

public class Licenses extends JFrame {
	JLabel licsNameLabel = new JLabel("Name");
	JLabel licsNumLabel = new JLabel("Number");
	JLabel licsValidityLabel = new JLabel("Validity");
	JLabel lic1Label = new JLabel("License 1");
	JLabel lic2Label = new JLabel("License 2");
	JLabel lic3Label = new JLabel("License 3");
	JTextField licNum1TextField = new JTextField();
	JTextField licNum2TextField = new JTextField();
	JTextField licNum3TextField = new JTextField();
	JButton validateLicsButton = new JButton("Validate");
	JButton cancelButton = new JButton("Cancel");
	JTextArea lic1ValidityTxtArea = new JTextArea();
	JTextArea lic2ValidityTxtArea = new JTextArea();
	JTextArea lic3ValidityTxtArea = new JTextArea();
	public Licenses(){
		GroupLayout gl = new GroupLayout(getContentPane());
		getContentPane().setLayout(gl);
		gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);
        setSize(300, 200);
        setLocationRelativeTo(null);
		
		gl.setHorizontalGroup( gl.createSequentialGroup()
			.addGroup( gl.createParallelGroup(LEADING)
						.addComponent(licsNameLabel)
						.addComponent(lic1Label)
						.addComponent(lic2Label)
						.addComponent(lic3Label) )
			.addGroup(	gl.createParallelGroup(LEADING)
						.addComponent(licsNumLabel)
						.addComponent(licNum1TextField)
						.addComponent(licNum2TextField)
						.addComponent(licNum3TextField) 
						.addComponent(validateLicsButton))
			.addGroup(gl.createParallelGroup(LEADING)
						.addComponent(licsValidityLabel)
						.addComponent(lic1ValidityTxtArea)
						.addComponent(lic2ValidityTxtArea)
						.addComponent(lic3ValidityTxtArea)
						.addComponent(cancelButton) )
		);

		gl.setVerticalGroup( gl.createSequentialGroup()
			.addGroup( gl.createParallelGroup(BASELINE)
						.addComponent(licsNameLabel)
						.addComponent(licsNumLabel)
						.addComponent(licsValidityLabel) )
			.addGroup( gl.createParallelGroup(LEADING)
						.addComponent(lic1Label)
						.addComponent(licNum1TextField)
						.addComponent(lic1ValidityTxtArea) )
			.addGroup( gl.createParallelGroup(LEADING)
						.addComponent(lic2Label)
						.addComponent(licNum2TextField)
						.addComponent(lic2ValidityTxtArea) )

			.addGroup( gl.createParallelGroup(LEADING)
						.addComponent(lic3Label)
						.addComponent(licNum3TextField)
						.addComponent(lic3ValidityTxtArea) )
			.addGroup(gl.createParallelGroup(LEADING)
						.addComponent(validateLicsButton)
						.addComponent(cancelButton) )
			);

		cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                setVisible(false);
				dispose();
            }
        });

        validateLicsButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent event){
        		lic1ValidityTxtArea.replaceSelection("Valid");
        		lic1ValidityTxtArea.setForeground(Color.GREEN);
        		lic2ValidityTxtArea.replaceSelection("Expired");
        		lic2ValidityTxtArea.setForeground(Color.RED);
        		lic3ValidityTxtArea.replaceSelection("Not Found");
        		lic3ValidityTxtArea.setForeground(Color.BLUE);

        	}
        });

		setTitle("Licenses");
        pack();
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        WindowListener exitListener = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(null,
                        "Are You Sure to Close this Window?",
                        "Exit Confirmation", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (confirm == JOptionPane.YES_OPTION) {
                    setVisible(false);
                    dispose();
                }
            }
        };
        ((JFrame)this).addWindowListener(exitListener);
        setVisible(true);
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
                new Licenses().setVisible(true);
            }
        });
    }
}