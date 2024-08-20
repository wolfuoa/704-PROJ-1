package org.compsys704;

public class Ports {
	public static final String REQUEST_SIGNAL = "LidLoaderControllerCD.request";
	public static final String REFILL_SIGNAL = "LidLoaderPlantCD.refill";
	public static final String ENABLE_SIGNAL = "LidLoaderPlantCD.enable";
	public static final int PORT_LOADER_PLANT = 10001;
	public static final int PORT_LOADER_CONTROLLER = 10000;
	public static final int PORT_LOADER_VIZ = 20000;
	
	// Manual 
	public static final String SIGNAL_PUSHER_EXTEND   = "LidLoaderControllerCD.pusherExtendM";
//	public static final String SIGNAL_VACOFF          = "LidLoaderControllerCD.vacOffM";
	public static final String SIGNAL_VACON           = "LidLoaderControllerCD.vacOnM";
	public static final String SIGNAL_ARM_SOURCE      = "LidLoaderControllerCD.armSourceM";
	public static final String SIGNAL_ARM_DEST        = "LidLoaderControllerCD.armDestM";
	public static final String SIGNAL_Mode            = "LidLoaderControllerCD.mode";
}
