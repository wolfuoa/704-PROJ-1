package org.compsys704;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;

import util.Order;


public class SignalClient implements ActionListener{

	Socket s = new Socket();
	ObjectOutputStream oos = null;
	int port;
	final String ip = "127.0.0.1";
	
	Order posOrder = null;
	Boolean isOrder = false;
	
	String dest;
	
	public SignalClient(int p, String dest){
		this.dest = dest;
		port = p;
		try {
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);;
		}
	}
	
	public SignalClient(int p, String dest, Order order){
		this.dest = dest;
		port = p;
		this.posOrder = order;
		try {
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);;
		}
	}

	public SignalClient(int p, String dest, Boolean isOrder){
		this.dest = dest;
		port = p;
		this.isOrder = isOrder;
		try {
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(s.isClosed()){
				s = new Socket();
				s.connect(new InetSocketAddress(ip, port), 10);
				oos = new ObjectOutputStream(s.getOutputStream());
				oos.writeObject(dest);
				int resp = s.getInputStream().read();
				if(resp < 0)
					throw new ConnectException("Not thru");
			}
			if (isOrder == true) {
				System.out.println("Signal Client Order Sent with Q: " + POS.getCurrentOrder().getQuantity() + "L1: " + POS.getCurrentOrder().getLiquidVolume(1));
				oos.writeObject(new Object[]{true, POS.getCurrentOrder()});
				Thread.sleep(50);
				oos.writeObject(new Object[]{false});
				posOrder = null;
			} else {
				oos.writeObject(new Object[]{true});
				Thread.sleep(50);
				oos.writeObject(new Object[]{false});
			}
		}
		catch (IOException | InterruptedException ee) {
			try {s.close();} catch (IOException e1) {
				e1.printStackTrace();
				System.exit(1);
			}
		}	
	}
}
