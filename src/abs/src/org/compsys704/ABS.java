package org.compsys704;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import util.Order;

public class ABS extends JFrame {
	private JPanel panel;
	
	public ABS() {
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
		this.add(panel,c);
		c.gridx = 0;
		c.gridy = 1;
		this.add(ss,c);
		
		// Radio buttons
		SignalRadioClient src = new SignalRadioClient(Ports.PORT_LOADER_CONTROLLER, Ports.SIGNAL_Mode);
		JRadioButton mmode = new JRadioButton("Manual");
		mmode.setActionCommand("1");
		mmode.addActionListener(src);
		JRadioButton amode = new JRadioButton("Auto");
		amode.setActionCommand("0");
		amode.addActionListener(src);
		amode.setSelected(true);
		ButtonGroup bg = new ButtonGroup();
		bg.add(mmode);
		bg.add(amode);
		
		JPanel pan = new JPanel(new GridLayout(1, 0));
		pan.add(amode);
		pan.add(mmode);
		c.gridx = 0;
		c.gridy = 2;
		pan.setBorder(BorderFactory.createTitledBorder("Mode selector"));

		// Checkboxes
		JCheckBox pe = new JCheckBox("Break Lid Loader");
		pe.setEnabled(false);
		pe.addItemListener(new SignalCheckBoxClient(Ports.PORT_LOADER_CONTROLLER, Ports.BREAK_LID_LOADER_SIGNAL));
//		JCheckBox pr = new JCheckBox("vacOff");
//		pr.setEnabled(false);
//		pr.addItemListener(new SignalCheckBoxClient(Ports.PORT_LOADER_CONTROLLER, Ports.SIGNAL_VACOFF));
		JCheckBox vo = new JCheckBox("Break Turn Table");
		vo.setEnabled(false);
		vo.addItemListener(new SignalCheckBoxClient(Ports.PORT_ROTARY_TT_CONTROLLER, Ports.BREAK_TT_SIGNAL));

		
		JCheckBox as = new JCheckBox("armSource");
		as.setEnabled(false);
		as.addItemListener(new SignalCheckBoxClient(Ports.PORT_LOADER_CONTROLLER, Ports.SIGNAL_ARM_SOURCE));
		JCheckBox ad = new JCheckBox("armDest");
		ad.setEnabled(false);
		ad.addItemListener(new SignalCheckBoxClient(Ports.PORT_LOADER_CONTROLLER, Ports.SIGNAL_ARM_DEST));

		JPanel pan2 = new JPanel(new GridLayout(2, 2));
		pan2.add(pe);
//		pan2.add(pr);
		pan2.add(vo);
		pan2.add(as);
		pan2.add(ad);
		pan2.setBorder(BorderFactory.createTitledBorder("Manual control"));
		src.setCheckBoxComponent(pan2);

		JPanel pan3 = new JPanel(new GridLayout(0, 2));
		pan3.add(pan);
		pan3.add(pan2);
		c.gridx = 0;
		c.gridy = 2;
		this.add(pan3,c);
		
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
