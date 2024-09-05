package org.compsys704;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import javafx.scene.shape.Box;

public class POS extends JFrame {
	private JPanel panel;
	
	public POS() {
//		this.setPreferredSize(new Dimension(200, 300));
		 
		// Layout System
	    this.setLayout(new GridBagLayout());
	    GridBagConstraints c = new GridBagConstraints();
	    
	    // Main Header
	    JLabel headerLabel = new JLabel("Advantech ABS", JLabel.CENTER);
	    headerLabel.setFont(new Font("ARIAL", Font.BOLD, 50));
	    c.gridx = 0;  // First column
	    c.gridy = 0;  // First row
	    c.gridwidth = 2;  // Span two columns if necessary
	    c.anchor = GridBagConstraints.CENTER;  // Center the label
	    this.add(headerLabel, c);

	    // Create and add header2 directly under headerLabel
	    JLabel header2 = new JLabel("Create a Batch Order", JLabel.LEFT);
	    header2.setFont(new Font("ARIAL", Font.BOLD, 25));
	    header2.setForeground(new Color(120, 66, 245));
	    c.gridy = 1;  // Second row
	    c.gridwidth = 2;  // Span across two columns
	    c.anchor = GridBagConstraints.WEST;  // Align to the left
	    c.fill = GridBagConstraints.HORIZONTAL;  // Fill horizontally to the left
	    this.add(header2, c);
	    
	    // Add a small blank space in the third row
	    JPanel blankSpace = new JPanel();
	    blankSpace.setPreferredSize(new java.awt.Dimension(0, 10));  // 10 pixels tall, 0 width
	    c.gridy = 2;  // Third row
	    c.weighty = 0;  // No extra vertical space allocated
	    this.add(blankSpace, c);
	    
	    // Create and add header2 directly under headerLabel
	    JLabel quantityLabel = new JLabel("Quantity:", JLabel.LEFT);
	    quantityLabel.setFont(new Font("ARIAL", Font.BOLD, 20));
	    c.gridy = 3;  // Second row
	    c.gridwidth = 2;  // Span across two columns
	    c.anchor = GridBagConstraints.WEST;  // Align to the left
	    c.fill = GridBagConstraints.HORIZONTAL;  // Fill horizontally to the left
	    this.add(quantityLabel, c);
	    
	    
	    // Add other components like buttons, panels, etc.
	    // Example: adding a panel with buttons
	    JButton enable = new JButton("enable");
	    enable.addActionListener(new SignalClient(Ports.PORT_LOADER_PLANT, Ports.ENABLE_SIGNAL));
	    JButton request = new JButton("request");
	    request.addActionListener(new SignalClient(Ports.PORT_LOADER_CONTROLLER, Ports.REQUEST_SIGNAL));
	    JButton refill = new JButton("refill");
	    refill.addActionListener(new SignalClient(Ports.PORT_LOADER_PLANT, Ports.REFILL_SIGNAL));

	    JPanel ss = new JPanel();
	    ss.add(enable);
	    ss.add(request);
	    ss.add(refill);

	    c.gridy = 4;  // Third row
	    c.gridwidth = 1;  // Reset to single column width
	    this.add(ss, c);
		
		
		this.setTitle("POS");
		this.setSize(400, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	public static void main(String[] args) {
		POS cl = new POS();
		//cl.pack();
		cl.setVisible(true);
		
		SignalServer<POSWorker> server = new SignalServer<POSWorker>(Ports.PORT_LOADER_POS, POSWorker.class);
		new Thread(server).start();
		while(true){
			try {
				cl.repaint();
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
