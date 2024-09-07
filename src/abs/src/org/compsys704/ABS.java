package org.compsys704;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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

import util.Order;

public class ABS extends JFrame {
	private JPanel panel;
	
	public ABS() {
		JLabel headerLabel = new JLabel("Advantech ABS Live", JLabel.CENTER);
        headerLabel.setFont(new Font("ARIAL", Font.BOLD, 50));
		
//		this.setPreferredSize(new Dimension(200, 300));
		panel = new Canvas();
		panel.setPreferredSize(new Dimension(700, 600));
		panel.setBackground(Color.WHITE);
		JButton enable = new JButton("Enable");
		enable.addActionListener(new SignalClient(Ports.PORT_BROADCAST_ENABLE, Ports.ENABLE_SIGNAL));
		JButton refillBtn = new JButton("Refill");
		refillBtn.addActionListener(new SignalClient(Ports.PORT_LOADER_PLANT, Ports.REFILL_SIGNAL));
//		JButton refill = new JButton("B3");
		//refill.addActionListener(new SignalClient(Ports.PORT_ROTARY_TT_CONTROLLER, Ports.BREAK_TT_SIGNAL));

		JCheckBox bllCheckBox = new JCheckBox("Break Lid Loader");
		bllCheckBox.addItemListener(new SignalCheckBoxClient(Ports.PORT_LOADER_CONTROLLER, Ports.BREAK_LID_LOADER_SIGNAL));
//		JCheckBox pr = new JCheckBox("vacOff");
//		pr.setEnabled(false);
//		pr.addItemListener(new SignalCheckBoxClient(Ports.PORT_LOADER_CONTROLLER, Ports.SIGNAL_VACOFF));
		JCheckBox bttCheckBox = new JCheckBox("Break Turn Table");
		bttCheckBox.addItemListener(new SignalCheckBoxClient(Ports.PORT_ROTARY_TT_CONTROLLER, Ports.BREAK_TT_SIGNAL));

		JPanel ss = new JPanel();
		ss.add(enable);
		ss.add(refillBtn);
		ss.add(bllCheckBox);
		ss.add(bttCheckBox);
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		this.add(headerLabel,c);
		c.gridx = 0;
		c.gridy = 1;
		this.add(panel,c);
		c.gridx = 0;
		c.gridy = 2;
		this.add(ss,c);
		
		
		this.setTitle("ABS Live");
		this.setSize(800, 750);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
	}

	public static void main(String[] args) {
		ABS cl = new ABS();
		//cl.pack();
		cl.setVisible(true);
		
		SignalServer<LoaderVizWorker> server = new SignalServer<LoaderVizWorker>(Ports.PORT_LOADER_VIZ, LoaderVizWorker.class);
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
