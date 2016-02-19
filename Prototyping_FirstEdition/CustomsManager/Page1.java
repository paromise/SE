import java.awt.Component;
import javax.swing.*;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import static javax.swing.GroupLayout.Alignment.*;

public class Page1 extends JFrame {

        JTextArea gName = new JTextArea();
        JLabel nameLabel = new JLabel("نام کالا:");
		
		JButton ok = new JButton("بررسی");
		DefaultListModel<String> model = new DefaultListModel<>();
		JList<String> list = new JList<>( model );


	//list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	//list.setSelectedIndex(0);
	//list.setVisibleRowCount(3);        

	JScrollPane listScrollPane = new JScrollPane(list);       

	JScrollPane listPane = new JScrollPane(list);



	public Page1(){
		GroupLayout gl = new GroupLayout(getContentPane());
		getContentPane().setLayout(gl);
		gl.setAutoCreateGaps(true);
	        gl.setAutoCreateContainerGaps(true);
	        setSize(500, 500);
	        setLocationRelativeTo(null);
		
		gl.setHorizontalGroup( gl.createSequentialGroup()
			.addGroup( gl.createParallelGroup( )
				.addComponent(gName)
				.addComponent(ok)
				.addComponent(listPane))
			.addGroup( gl.createParallelGroup( )
				.addComponent(nameLabel))
			);
		

		gl.setVerticalGroup( gl.createParallelGroup()
			.addGroup( gl.createSequentialGroup( )
				.addComponent(gName)
				.addComponent(ok)
				.addComponent(listPane))
				.addGroup( gl.createSequentialGroup( )
					.addComponent(nameLabel))			
			);

		
			ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                model.addElement("مجوز وزات بهداشت");
                model.addElement("مجوز اداره آموزش");
            }
        });

        
		setTitle("Page1");
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
                new Page1().setVisible(true);
            }
        });
    }
}
