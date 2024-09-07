package org.compsys704;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.RoboticArm;

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
		// Bottle At Position
		case "bottleAtPos0V":
			States.BOTTLE_AT_POS0 = status;
			break;
		case "bottleAtPos1V":
			States.BOTTLE_AT_POS1 = status;
			break;
		case "bottleAtPos2V":
			States.BOTTLE_AT_POS2 = status;
			break;
		case "bottleAtPos3V":
			States.BOTTLE_AT_POS3 = status;
			break;
		case "bottleAtPos4V":
			States.BOTTLE_AT_POS4 = status;
			break;
		case "bottleAtPos5V":
			States.BOTTLE_AT_POS5 = status;
			break;
		case "bottleLeftPos5V":
			States.BOTTLE_LEFT_POS5 = status;
			break;
			
		case "rightArmV":
			//Value Signal
			break;
		case "leftArmV":
			//Value Signal
			break;
		case "liquidLoadedV":
			//Value Signal
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
			System.err.println("Wrong sig name in setSignal : "+signame);
			System.exit(1);
		}
	}
	
	@Override
	public void setValueSignal(boolean status, Object objectData){
		switch(signame){
		case "leftArmV":
			States.LEFT_ARM = status;
			States.LEFT_ARM_OBJECT = (RoboticArm) objectData;
			if (status == true) {
				System.out.println("Viz Left Robotic arm recived status " + States.LEFT_ARM_OBJECT.getArmStatus() + " " + States.LEFT_ARM_OBJECT.getGripperStatus());
			}
			break;
		case "rightArmV":
			States.RIGHT_ARM = status;
			States.RIGHT_ARM_OBJECT = (RoboticArm) objectData;
			if (status == true) {
				System.out.println("Viz Right Robotic arm recived status " + States.RIGHT_ARM_OBJECT.getArmStatus() + " " + States.RIGHT_ARM_OBJECT.getGripperStatus());
			}
			break;
		case "liquidLoadedV":
			States.LIQUID_TO_FILL = (int) objectData; 
			System.out.println("Viz Recieved Liquid LoadedV value signal");
			break;
		default:
			System.out.println("signal + object arrived " + signame);
		}
		
	}
	
	static final List<String> sensorsSignals = Arrays.asList(
//		    "bottleAtPointV",
		    "bottleAtPos0V",
		    "bottleAtPos1V",
		    "bottleAtPos2V",
		    "bottleAtPos3V",
		    "bottleAtPos4V",
		    "bottleAtPos5V",
		    "bottleLeftPos5V",
		    "capBottleCompleteV",
		    "capBottleIncompleteV"
//		    "loadLidCompleteV",
//		    "loadLidIncompleteV",
//		    "fillBottleCompleteV",
//		    "fillBottleIncompleteV"
		);
	
	static final List<String> lidLoaderSignals = Arrays.asList("pusherRetractedE","pusherExtendedE","armAtSourceE","armAtDestE");
	static final List<String> baxterSignals = Arrays.asList("rightArmV", "leftArmV");
	static final List<String> liquidLoaderSignals = Arrays.asList("liquidLoadedV");
	static final List<String> signames = new ArrayList<>();
	
	@Override
	public boolean hasSignal(String sn) {
		signames.addAll(sensorsSignals);
		signames.addAll(lidLoaderSignals);
	    signames.addAll(baxterSignals);
	    signames.addAll(liquidLoaderSignals);
		return signames.contains(sn);
	}

}
