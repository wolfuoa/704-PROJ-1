package org.compsys704;

import util.RoboticArm;

public class States {
	
	
	public static volatile boolean GRIPPED = false;
	public static volatile boolean MAG_EMPTY = false;
	
	public static volatile boolean CAP_READY = false;
	
	// Lid Loader
	public static volatile boolean PUSHER_RETRACTED = true;
	public static volatile boolean PUSHER_EXTENDED = !PUSHER_RETRACTED;
	
	public static volatile boolean ARM_AT_DEST = true;
	public static volatile boolean ARM_AT_SOURCE = !ARM_AT_DEST;
	
	// Bottle Filler
	public static volatile boolean BOTTLE_FILLED = false;
	
	//Bottle Capper
	public static volatile boolean BOTTLE_CAPPED = false;
	
	public static volatile boolean BOTTLE_AT_POS1 = false;
	public static volatile boolean BOTTLE_AT_POS2 = false;
	public static volatile boolean BOTTLE_AT_POS3 = false;
	public static volatile boolean BOTTLE_AT_POS4 = false;
	public static volatile boolean BOTTLE_AT_POS5 = false;
	public static volatile boolean BOTTLE_LEFT_POS5 = false;
	
	//Baxter
	public static volatile boolean LEFT_ARM = false;
	public static volatile RoboticArm LEFT_ARM_OBJECT = null;
	public static volatile boolean RIGHT_ARM = false;
	public static volatile RoboticArm RIGHT_ARM_OBJECT = null;

	//POS
	public static volatile boolean ORDER_COMPLETE = false;
}
