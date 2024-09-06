package org.compsys704;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import util.RoboticArm;

public class Canvas extends JPanel {
	BufferedImage arm1;
	BufferedImage arm2;
	BufferedImage p1;
	BufferedImage p2;
	BufferedImage loader;
	BufferedImage cap;
	
	//Machines
	BufferedImage tTStatic;
	BufferedImage lidLoaderStationStatic;
	BufferedImage lidLoaderArmSourceDyn;
	BufferedImage lidLoaderArmDestDyn;
	BufferedImage lidLoaderPusherRetreactedDyn;
	BufferedImage lidLoaderPusherExtendedDyn;
	BufferedImage bottleFillerDoneDyn;
	BufferedImage bottleFillerNotDoneDyn;
	BufferedImage bottleCapperDoneDyn;
	BufferedImage bottleCapperNotDoneDyn;
	
	//Bottles
	BufferedImage emptyBottle;
	BufferedImage liquidFilledBottle;
	BufferedImage completeBottle;
	
	BufferedImage Base; 
	BufferedImage BaxterPickupBase;
		public Canvas(){
		try {
			Base= ImageIO.read(new File("res/static_state.png"));
			BaxterPickupBase =  ImageIO.read(new File("res/Baxter_layouts/Baxter_Remove_Bottle_I.png"));
			
			BufferedImage allBottles = ImageIO.read(new File("res/bottle.png"));
			emptyBottle = allBottles.getSubimage(0, 0, 45, 38);
			liquidFilledBottle = allBottles.getSubimage(0, 38, 45, 38);
			completeBottle = allBottles.getSubimage(0, 76, 45, 36);
			
			BufferedImage lidLoaderArms = ImageIO.read(new File("res/cap_loader/cap_rotating_arm_source_and_destination.png"));
			lidLoaderArmSourceDyn = lidLoaderArms.getSubimage(0, 0, 52, 98);
			lidLoaderArmDestDyn = lidLoaderArms.getSubimage(0, 98, 52, 98);
			
			lidLoaderPusherRetreactedDyn = ImageIO.read(new File("res/cap_loader/cap_puser_use_twice.png"));
			lidLoaderPusherExtendedDyn = ImageIO.read(new File("res/cap_loader/cap_puser_use_twice.png"));
			
			BufferedImage bottleFillers = ImageIO.read(new File("res/bottle_filler_filling_and_not_filling.png"));
			bottleFillerNotDoneDyn = bottleFillers.getSubimage(0, 0, 115, 82);
			bottleFillerDoneDyn = bottleFillers.getSubimage(0, 82, 115, 82);
			
			BufferedImage bottleCappers = ImageIO.read(new File("res/lid_capper_on_and_off.png"));
			bottleCapperNotDoneDyn = bottleCappers.getSubimage(0, 0, 125, 96);
			bottleCapperDoneDyn = bottleCappers.getSubimage(0, 96, 125, 94);
			
			BufferedImage bi = ImageIO.read(new File("res/arm.png"));
			arm1 = bi.getSubimage(0, 0, 64, 256);
			arm2 = bi.getSubimage(71, 0, 48, 256);
			
			loader = ImageIO.read(new File("res/loader.png"));
			bi = ImageIO.read(new File("res/pusher.png"));
			p1 = bi.getSubimage(0, 0, 238, 68);
			p2 = bi.getSubimage(238, 0, 172, 68);
			cap = ImageIO.read(new File("res/cap.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(Base, 0,0, null);
		
		if (States.RIGHT_ARM_OBJECT != null &&
				States.RIGHT_ARM_OBJECT.getArmStatus() == RoboticArm.ArmStatus.ABOVE_REMOVAL_POINT &&
				States.RIGHT_ARM_OBJECT.getGripperStatus() == RoboticArm.GripperStatus.CLOSED) {
			g.drawImage(BaxterPickupBase, 0, 0, null);
		}
		
		if (States.BOTTLE_AT_POS1) {
			g.drawImage(emptyBottle, 355, 320, null);
		}
		if(States.BOTTLE_AT_POS2) {
			g.drawImage(emptyBottle, 360, 280, null);
		}
		if(States.BOTTLE_AT_POS3) {
			g.drawImage(liquidFilledBottle, 400, 265, null);
		}
		if(States.BOTTLE_AT_POS4) {
			g.drawImage(completeBottle, 435, 285, null);
		}
		if(States.BOTTLE_AT_POS5) {
			g.drawImage(completeBottle, 440, 320, null);
		} 
		if(States.BOTTLE_LEFT_POS5) {
			g.drawImage(completeBottle, 485, 320, null);
			
		}
		
		
		//Liquid Filler
		if (States.BOTTLE_FILLED) {
			g.drawImage(bottleFillerDoneDyn, 280, 233, null);
		} else {
			g.drawImage(bottleFillerNotDoneDyn, 280, 233, null);
		}
	
		//Lid Loader
			// Arm
		if (States.ARM_AT_SOURCE) {
			g.drawImage(lidLoaderArmSourceDyn, 395, 115, null);
		} else {
			g.drawImage(lidLoaderArmDestDyn, 395, 195, null);
		}
			// Pusher
		if (States.PUSHER_RETRACTED) {
			g.drawImage(lidLoaderPusherRetreactedDyn, 210, 70, null);
		} else {
			g.drawImage(lidLoaderPusherExtendedDyn, 256, 70, null);
		}
		
		//Liquid Capper
		if (States.BOTTLE_CAPPED) {
			g.drawImage(bottleCapperDoneDyn, 442, 221, null);
		} else {
			g.drawImage(bottleCapperNotDoneDyn, 442, 221, null);
		}
		
		
		
//		g.drawImage(loader, 0, 100, null);
//		
//		if(States.ARM_AT_DEST)
//			g.drawImage(arm1, 0, 0, null);
//		else
//			g.drawImage(arm2, 30, 0, null);
//		
//		if(States.GRIPPED){
//			if(States.ARM_AT_DEST){
//				g.setColor(Color.black);
//				g.fillOval(10, 11, 30, 30);
//				g.setColor(Color.red);
//				g.fillOval(10, 11, 15, 15);
//
//			}
//			else{
//				g.setColor(Color.black);
//				g.fillOval(40, 243, 30, 30);
//				g.setColor(Color.red);
//				g.fillOval(35, 232, 15, 15);
//			}
//			g.setColor(Color.black);
//		}
////		else{
//			if(States.CAP_READY){ // A cap is pushed to the source pos
//				g.setColor(Color.black);
//				g.fillOval(40, 243, 30, 30);
//			}
////		}
//		
//		if(States.PUSHER_RETRACTED){
//			g.drawImage(p1, 90, 225, null);
//			if(!States.MAG_EMPTY){
//				g.setColor(Color.black);
//				g.fillOval(154, 243, 30, 30);
//			}
//		}
//		else{
//			g.drawImage(p2, 90, 225, null);
//		}
//		
//		if(!States.MAG_EMPTY){
//			g.drawImage(cap, 152, 155, null);
//		}
	}
}
