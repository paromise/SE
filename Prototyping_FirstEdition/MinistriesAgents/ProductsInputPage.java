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

public class ProductsInputPage extends JFrame{
	private static  int num_of_rows;
	private	JPanel		topPanel;
	private	JTable		table;
	private	JScrollPane scrollPane;
	public ProductsInputPage(int rowsNum){
	
 		num_of_rows= rowsNum;
        
		setTitle( "Products Table" );
		setSize( 300, 1000 );
		setBackground( Color.gray );
		setLocationRelativeTo(null);


		// Create a panel to hold all other components
		topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );

		String [][] rows=new String[num_of_rows][5];

		String columnNames[] = {"قیمت واحد کالا به دلار","تعداد کالا","وزن کالا", "شرکت تولید کننده کالا","نام کالا" };
		table = new JTable(rows,columnNames);
		scrollPane = new JScrollPane( table );
		topPanel.add( scrollPane, BorderLayout.CENTER );

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


}