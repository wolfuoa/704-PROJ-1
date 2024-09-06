package org.compsys704;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoaderVizWorker extends Worker{

	@Override
	public void setSignal(boolean status) {
//		System.out.println(signame+"  "+status);
		switch(signame){
		case "pusherRetractedE":
			if (status == true) {
				System.out.println("pusher Retracted true Viz");
			}
			States.PUSHER_RETRACTED = status;
			break;
		case "pusherExtendedE":
			if (status == true) {
				System.out.println("pusher Extended true Viz");
			}
			States.PUSHER_EXTENDED = status;
			break;
		case "armAtSourceE":
			System.out.println("armAtSource Viz");
			States.ARM_AT_SOURCE = status;
			break;
		case "armAtDestE":
			System.out.println("armAtDest Viz");
			States.ARM_AT_DEST = status;
			break;
		// Capper
		case "capBottleCompleteV":
			System.out.println("Capper Complete Viz");
			States.BOTTLE_CAPPED = status;
			break;
		case "capBottleIncompleteV":
			break;	
		//Liquid Filler
			//Lid Loader
		case "liquidFilled":
			States.BOTTLE_FILLED = status;
			break;	
		case "bottleAtPos1V":
			States.BOTTLE_AT_POS1 = status;
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
	
	@Override
	public void setValueSignal(boolean status, Object objectData){
		switch(signame){
		default:
			System.out.println("signal + object arrived " + signame);
		}
		
	}
	
	static final List<String> sensorsSignals = Arrays.asList(
//		    "bottleAtPointV",
//		    "bottleAtPos0V",
		    "bottleAtPos1V",
//		    "bottleAtPos2V",
//		    "bottleAtPos3V",
//		    "bottleAtPos4V",
//		    "bottleAtPos5V",
//		    "bottleLeftPos5V",
		    "capBottleCompleteV",
		    "capBottleIncompleteV"
//		    "loadLidCompleteV",
//		    "loadLidIncompleteV",
//		    "fillBottleCompleteV",
//		    "fillBottleIncompleteV"
		);
	
	static final List<String> lidLoaderSignals = Arrays.asList("pusherRetractedE","pusherExtendedE","armAtSourceE","armAtDestE");
	static final List<String> baxterSignals = Arrays.asList("rightArmV");
	static final List<String> signames = new ArrayList<>();
	
	@Override
	public boolean hasSignal(String sn) {
		signames.addAll(sensorsSignals);
		signames.addAll(lidLoaderSignals);
	    signames.addAll(baxterSignals);
		return signames.contains(sn);
	}

}
