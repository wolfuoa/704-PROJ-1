package org.compsys704;

import java.util.Arrays;
import java.util.List;

public class LoaderVizWorker extends Worker{

	@Override
	public void setSignal(boolean status) {
//		System.out.println(signame+"  "+status);
		switch(signame){
		case "pusherRetractedE":
			System.out.println("Cpusher Retracted Viz");
			States.PUSHER_RETRACTED = status;
			break;
		case "pusherExtendedE":
			System.out.println("pusher Extended Viz");
			States.PUSHER_EXTENDED = status;
			break;
		case "armAtSourceE":
			States.ARM_AT_SOURCE = status;
			break;
		case "armAtDestE":
			States.ARM_AT_DEST = status;
			break;
		// Capper
		case "capBottleCompleteV":
			System.out.println("Capper Complete Viz");
			States.BOTTLE_CAPPED = status;
			break;			
		//Liquid Filler
			//Lid Loader
		case "liquidFilled":
			States.BOTTLE_FILLED = status;
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
		case "emptyE":
			States.MAG_EMPTY = status;
			break;
		default: 
			System.err.println("Wrong sig name : "+signame);
			System.exit(1);
		}
	}
	
	
	static final List<String> signames = Arrays.asList("capBottleCompleteV", "pusherRetractedE","pusherExtendedE","WPgrippedE","armAtSourceE","armAtDestE","emptyE");
	
	@Override
	public boolean hasSignal(String sn) {
		return signames.contains(sn);
	}

}
