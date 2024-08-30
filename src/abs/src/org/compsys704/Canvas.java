package org.compsys704;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Canvas extends JPanel {
	BufferedImage arm1;
	BufferedImage arm2;
	BufferedImage p1;
	BufferedImage p2;
	BufferedImage loader;
	BufferedImage cap;

	BufferedImage tTStatic;
	BufferedImage lidLoaderStationStatic;
	BufferedImage lidLoaderArmSourceDyn;
	BufferedImage lidLoaderArmDestDyn;
	BufferedImage lidLoaderPusherRetreactedDyn;
	BufferedImage lidLoaderPusherExtendedDyn;
	BufferedImage bottleFillerDoneDyn;
	BufferedImage bottleFillerNotDoneDyn;
	
	BufferedImage Base; 
	
	public Canvas(){
		try {
			Base= ImageIO.read(new File("res/static_state.png"));
			
			
			BufferedImage lidLoaderArms = ImageIO.read(new File("res/cap_loader/cap_rotating_arm_source_and_destination.png"));
			lidLoaderArmSourceDyn = lidLoaderArms.getSubimage(0, 0, 72, 140);
			lidLoaderArmDestDyn = lidLoaderArms.getSubimage(0, 140, 72, 140);
			
			lidLoaderPusherRetreactedDyn = ImageIO.read(new File("res/cap_loader/cap_puser_use_twice.png"));
			lidLoaderPusherExtendedDyn = ImageIO.read(new File("res/cap_loader/cap_puser_use_twice.png"));
			
			BufferedImage bottleFillers = ImageIO.read(new File("res/bottle_filler_filling_and_not_filling.png"));
			bottleFillerNotDoneDyn = bottleFillers.getSubimage(0, 0, 146, 94);
			bottleFillerDoneDyn = bottleFillers.getSubimage(0, 98, 146, 98);
			
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
		
		//Liquid Filler
		if (States.BOTTLE_FILLED) {
			g.drawImage(bottleFillerDoneDyn, 225, 225, null);
		} else {
			g.drawImage(bottleFillerNotDoneDyn, 225, 225, null);
		}
	
		//Lid Loader
			// Arm
		if (States.ARM_AT_SOURCE) {
			g.drawImage(lidLoaderArmSourceDyn, 355, 80, null);
		} else {
			g.drawImage(lidLoaderArmDestDyn, 355, 172, null);
		}
			// Pusher
		if (States.PUSHER_RETRACTED) {
			g.drawImage(lidLoaderPusherRetreactedDyn, 173, 45, null);
		} else {
			g.drawImage(lidLoaderPusherExtendedDyn, 225, 45, null);
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
