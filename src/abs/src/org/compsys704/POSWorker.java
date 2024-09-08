package org.compsys704;

import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class POSWorker extends Worker{

	@Override
	public void setSignal(boolean status) {
//		System.out.println(signame+"  "+status);
		switch(signame){
		case "orderComplete":
			States.ORDER_COMPLETE = status;
			States.SEND_ORDER_STATUS = true;
			if (status == true) {
				SwingUtilities.invokeLater(() -> {
	                JOptionPane.showMessageDialog(null, 
	                    "Order Complete, You may now send another order for proccessing", 
	                    "Order Complete", 
	                    JOptionPane.INFORMATION_MESSAGE);
	                if (POS.getQueueSize() > 0) {
	                	POS.sendOrderButton.setEnabled(true);
	                }
	            });
			}
		
		case "pusherRetractedE":
			States.PUSHER_RETRACTED = status;
			break;
		case "pusherExtendedE":
			if(!States.MAG_EMPTY && !States.PUSHER_EXTENDED)
				States.CAP_READY = true;
			States.PUSHER_EXTENDED = status;
			break;
		case "WPgrippedE":
			if(States.GRIPPED && States.ARM_AT_SOURCE){
				if(!status)
					States.CAP_READY = true;
			}
			States.GRIPPED = status;
			if(States.GRIPPED && States.ARM_AT_SOURCE){
				States.CAP_READY = false;
			}
			break;
		case "armAtSourceE":
			States.ARM_AT_SOURCE = status;
			break;
		case "armAtDestE":
			States.ARM_AT_DEST = status;
			break;
		case "emptyE":
			States.MAG_EMPTY = status;
			break;
		default: 
			System.err.println("Wrong sig name : "+signame);
			System.exit(1);
		}
	}
	
	@Override
	public void setValueSignal(boolean status, Object objectData){
		switch(signame){
		
		}
	}
	
	
	static final List<String> signames = Arrays.asList("orderComplete");
	
	@Override
	public boolean hasSignal(String sn) {
		return signames.contains(sn);
	}

}
