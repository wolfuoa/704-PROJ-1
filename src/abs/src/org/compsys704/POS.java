package org.compsys704;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import javafx.scene.shape.Box;
import util.Order;

public class POS extends JFrame {
	private static JSpinner quantitySpinner;
	private static JSlider oneSlider;
	private static JSlider twoSlider;
	private static JSlider threeSlider;
	private static JSlider fourSlider;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;

    private static List<Order> orderQueue = new ArrayList<>();
	
	
	public POS() {
        // Layout System
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Main Header
        JLabel headerLabel = new JLabel("Advantech ABS", JLabel.CENTER);
        headerLabel.setFont(new Font("ARIAL", Font.BOLD, 50));
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(10, 30, 10, 30);  // Add padding around the header
        this.add(headerLabel, c);

        // Create and add header2 directly under headerLabel
        JLabel header2 = new JLabel("Create a Batch Order", JLabel.LEFT);
        header2.setFont(new Font("ARIAL", Font.BOLD, 25));
        header2.setForeground(new Color(120, 66, 245));
        c.gridy = 1;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(10, 10, 0, 10);  // Padding with no bottom margin
        this.add(header2, c);

        // Add a small blank space in the third row
        JPanel blankSpace = new JPanel();
        blankSpace.setPreferredSize(new Dimension(0, 10));
        c.gridy = 2;
        c.weighty = 0;
        this.add(blankSpace, c);

        // Add quantity label
        JLabel quantityLabel = new JLabel("Quantity");
        quantityLabel.setFont(new Font("ARIAL", Font.BOLD, 20));
        c.gridy = 3;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(quantityLabel, c);
        
     // Creating a spinner with an initial value of 1, minimum of 1, maximum of 100, and step size of 1
        quantitySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        c.gridx = 1;
        this.add(quantitySpinner, c);

        // Initialize sliders and labels
        label1 = new JLabel("Liquid 1: 0ml");
        oneSlider = new JSlider(0, 200, 0);
        oneSlider.setPreferredSize(new Dimension(200, 30));  // Set preferred size of the slider
        oneSlider.addChangeListener(e -> updateSliders(oneSlider, label1, 1));

        // Add label1 to the left (first column)
        c.gridy = 4;
        c.gridx = 0;
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.NONE;
        c.weightx = 0;
        c.gridwidth = 1;
        c.insets = new Insets(10, 10, 5, 10);  // Add padding around the label
        this.add(label1, c);

        // Add oneSlider to the right (second column)
        c.gridx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.insets = new Insets(10, 10, 5, 10);  // Add padding around the slider
        this.add(oneSlider, c);

        // Repeat for other sliders and labels
        label2 = new JLabel("Liquid 2: 0ml");
        twoSlider = new JSlider(0, 200, 0);
        twoSlider.setPreferredSize(new Dimension(200, 30));
        twoSlider.addChangeListener(e -> updateSliders(twoSlider, label2, 2));

        c.gridy = 5;
        c.gridx = 0;
        c.fill = GridBagConstraints.NONE;
        c.weightx = 0;
        this.add(label2, c);

        c.gridx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        this.add(twoSlider, c);

        label3 = new JLabel("Liquid 3: 0ml");
        threeSlider = new JSlider(0, 200, 0);
        threeSlider.setPreferredSize(new Dimension(200, 30));
        threeSlider.addChangeListener(e -> updateSliders(threeSlider, label3, 3));

        c.gridy = 6;
        c.gridx = 0;
        c.fill = GridBagConstraints.NONE;
        c.weightx = 0;
        this.add(label3, c);

        c.gridx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        this.add(threeSlider, c);

        label4 = new JLabel("Liquid 4: 0ml");
        fourSlider = new JSlider(0, 200, 0);
        fourSlider.setPreferredSize(new Dimension(200, 30));
        fourSlider.addChangeListener(e -> updateSliders(fourSlider, label4, 4));

        c.gridy = 7;
        c.gridx = 0;
        c.fill = GridBagConstraints.NONE;
        c.weightx = 0;
        this.add(label4, c);

        c.gridx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        this.add(fourSlider, c);
        
        // Create a new button
        JButton submitButton = new JButton("Order");
        // Add an external method as the ActionListener using a lambda expression
        submitButton.addActionListener(e -> {
        	System.out.print("POS order added to queue");
        	orderQueue.add(new Order((int)quantitySpinner.getValue(), oneSlider.getValue(), twoSlider.getValue(), threeSlider.getValue(), fourSlider.getValue()));
        	System.out.println("The size is: " + orderQueue.size());
        });
        
     // Create a new button
        JButton sendOrderButton = new JButton("Make Order");
        // Add an external method as the ActionListener using a lambda expression
        sendOrderButton.addActionListener(new SignalClient(Ports.PORT_MPR, 
        Ports.POS_ORDER_SIGNAL, 
        true
        ));
        
     // Create a new panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 10, 0)); // 1 row, 2 columns, 10px gap between buttons

        // Add buttons to the panel
        buttonPanel.add(submitButton);
        buttonPanel.add(sendOrderButton);

        // Set up the GridBagConstraints for the panel
        c.gridy = 8;
        c.gridx = 0;
        c.gridwidth = 2; // Span across 2 columns
        c.weightx = 1.0; // Take up the full horizontal space
        c.fill = GridBagConstraints.HORIZONTAL; // Stretch the panel horizontally
        c.insets = new Insets(5, 5, 5, 5); // Optional: add padding

        // Add the panel containing buttons to the layout
        this.add(buttonPanel, c);

        this.setTitle("POS");
        this.setSize(500, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
	
	public void updateSliders(JSlider slider, JLabel label, int number) {
		label.setText("Liquid " + number + ": " + slider.getValue() + "%");
	}
	
//	public void submitOrder(ActionEvent e) {
//        Order newOrder = ;
//        new SignalClient(Ports.PORT_MPR, Ports.POS_ORDER_SIGNAL, newOrder);
//        System.out.println("Order Sent");
//        System.out.println(newOrder.getQuantity());
//        System.out.println(newOrder.getLiquidVolume(1));
//    }

    public static Order getCurrentOrder(){
    	Order order = orderQueue.get(0);
    	orderQueue.remove(0);
        return order;

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
