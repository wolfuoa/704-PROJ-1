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
	BufferedImage lidLoaderArmUP;
	BufferedImage lidLoaderArmDOWN;
	BufferedImage lidLoaderPusherRetreactedDyn;
	BufferedImage lidLoaderPusherExtendedDyn;
	BufferedImage bottleCapperDoneDyn;
	BufferedImage bottleCapperNotDoneDyn;
	
	BufferedImage L1;
	BufferedImage L2;
	BufferedImage L3;
	BufferedImage L4;
	
	//Bottles
	BufferedImage emptyBottle;
	BufferedImage liquidFilledBottle;
	BufferedImage completeBottle;
	BufferedImage bottleCap;
	
	BufferedImage Base; 
	BufferedImage BaxterRemoveI;
	BufferedImage BaxterRemoveF;
	BufferedImage BaxterPlaceTTF;
	BufferedImage BaxterSpinTTO;
	BufferedImage BaxterSpinTTOAndPlacePos1;
	BufferedImage BaxterLoadLidNoOtherEventI;
	BufferedImage BaxterLoadLidNoOtherEventF;
	BufferedImage BaxterLoadLidFRemoveFromConvF;
	
	int counter = 0;
	Boolean cappingAnimation = false;
		public Canvas(){
		try {
			
			/*----------------------------------Baxter Layouts------------------------------------------------*/
			Base= ImageIO.read(new File("res/static_state.png"));
			BaxterRemoveI =  ImageIO.read(new File("res/Baxter_layouts/Baxter_Remove_Bottle_I.png"));
			BaxterRemoveF =  ImageIO.read(new File("res/Baxter_layouts/Baxter_Remove_Bottle_F.png"));
			BaxterPlaceTTF =  ImageIO.read(new File("res/Baxter_layouts/Baxter_place_Bottle.png"));
			BaxterSpinTTO =  ImageIO.read(new File("res/Baxter_layouts/B_Rotate_EB_I.png"));
			BaxterSpinTTOAndPlacePos1 = ImageIO.read(new File("res/Baxter_layouts/B_Rotate_EB_F.png"));
			BaxterLoadLidNoOtherEventI = ImageIO.read(new File("res/Baxter_layouts/B_LLoader_General_I.png"));
			BaxterLoadLidNoOtherEventF = ImageIO.read(new File("res/Baxter_layouts/B_LLoader_General_F.png"));
			BaxterLoadLidFRemoveFromConvF = ImageIO.read(new File("res/Baxter_layouts/B_LLoader_Remove_from_Conv_FF.png"));
			
			
			/*----------------------------------Baxter Layouts END---------------------------------------------*/
	
			BufferedImage allBottles = ImageIO.read(new File("res/bottle.png"));
			emptyBottle = allBottles.getSubimage(0, 0, 45, 38);
			liquidFilledBottle = allBottles.getSubimage(0, 38, 45, 38);
			completeBottle = allBottles.getSubimage(0, 76, 45, 36);
			bottleCap = allBottles.getSubimage(0, 115, 45, 17);
			
			BufferedImage lidLoaderArms = ImageIO.read(new File("res/cap_loader/cap_rotating_arm_source_and_destination.png"));
			lidLoaderArmUP = lidLoaderArms.getSubimage(0, 0, 52, 98);
			lidLoaderArmDOWN = lidLoaderArms.getSubimage(0, 98, 52, 98);
			
			lidLoaderPusherRetreactedDyn = ImageIO.read(new File("res/cap_loader/cap_puser_use_twice.png"));
			lidLoaderPusherExtendedDyn = ImageIO.read(new File("res/cap_loader/cap_puser_use_twice.png"));
			
			//liquid Filler
			BufferedImage bottleFillers = ImageIO.read(new File("res/bottle_filler_filling_and_not_filling.png"));
			L1 = bottleFillers.getSubimage(0, 0, 115, 77);
			L2 = bottleFillers.getSubimage(0, 76, 115, 77);
			L3 = bottleFillers.getSubimage(0, 153, 115, 76);
			L4 = bottleFillers.getSubimage(0, 229, 115, 77);
			
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
		
		//Baxter Place on Conveyor
		if (States.LEFT_ARM &&
				States.LEFT_ARM_OBJECT != null &&
				(States.LEFT_ARM_OBJECT.getArmStatus() == RoboticArm.ArmStatus.ON_COLLECTION_POINT 
				||
				States.LEFT_ARM_OBJECT.getArmStatus() == RoboticArm.ArmStatus.ABOVE_COLLECTION_POINT
				)){
			g.drawImage(BaxterPlaceTTF, 0, 0, null);
		}
		if (States.BOTTLE_AT_POS0) {
			g.drawImage(emptyBottle, 318, 320, null);
		} 
		
		//Baxter Remove From Conveyor
		if(States.BOTTLE_LEFT_POS5) {
			g.drawImage(completeBottle, 490, 320, null);
			
		}
		if (States.RIGHT_ARM_OBJECT != null &&
				(States.RIGHT_ARM_OBJECT.getArmStatus() == RoboticArm.ArmStatus.ABOVE_REMOVAL_POINT
				||
				States.RIGHT_ARM_OBJECT.getArmStatus() == RoboticArm.ArmStatus.ON_REMOVAL_POINT
				)){
			g.drawImage(BaxterRemoveI, 0, 0, null);
		}
			// Moving item away from conveyor
		if (States.RIGHT_ARM_OBJECT != null &&
				(States.RIGHT_ARM_OBJECT.getArmStatus() == RoboticArm.ArmStatus.ABOVE_PACKAGE
				||
				States.RIGHT_ARM_OBJECT.getArmStatus() == RoboticArm.ArmStatus.ON_PACKAGE
				)){
			g.drawImage(BaxterRemoveF, 0, 0, null);
		}
		
		//3.)
		//Baxter turntable fault tolerance mode
		if (States.RIGHT_ARM_OBJECT != null &&
				(States.RIGHT_ARM_OBJECT.getArmStatus() == RoboticArm.ArmStatus.ABOVE_ROTARY_TURNTABLE
				||
				States.RIGHT_ARM_OBJECT.getArmStatus() == RoboticArm.ArmStatus.ON_ROTARY_TURNTABLE
				)){
			g.drawImage(BaxterSpinTTO, 0, 0, null);
		}
		
		//4.)
		//Capped Bottle and liquid filler must be placed here to show that Baxter is using hte faul tolerance mode
		//Only works if armAtDest Works
		if(States.BOTTLE_AT_POS3 || cappingAnimation) {
			g.drawImage(liquidFilledBottle, 400, 265, null);
			cappingAnimation = true;
		} 
		
		if (States.LID_LOADED) {
			cappingAnimation = false;
		}
		
		if(States.BOTTLE_AT_POS2) {
			g.drawImage(emptyBottle, 360, 280, null);
		}
		
		
		// Liquid Filler
		if (States.LIQUID_TO_FILL == 0) {
			g.drawImage(L1, 280, 240, null);
		} else if (States.LIQUID_TO_FILL == 1) {
			g.drawImage(L2, 280, 240, null);
		} else if (States.LIQUID_TO_FILL == 2) {
			g.drawImage(L3, 280, 240, null);
		}else if (States.LIQUID_TO_FILL == 3) {
				g.drawImage(L4, 280, 240, null);
		}
		//5. )
		//Baxter Lid loading ONLY Initial
		if (States.LEFT_ARM &&
				States.LEFT_ARM_OBJECT != null &&
				(States.LEFT_ARM_OBJECT.getArmStatus() == RoboticArm.ArmStatus.ON_LID_SURPLUS
				||
				States.LEFT_ARM_OBJECT.getArmStatus() == RoboticArm.ArmStatus.ABOVE_LID_SURPLUS
				)){
			g.drawImage(BaxterLoadLidNoOtherEventI, 0, 0, null);
		}
		
		// Baxter Lid Loading ONLY Final
		if (States.LEFT_ARM &&
				States.LEFT_ARM_OBJECT != null &&
				(States.LEFT_ARM_OBJECT.getArmStatus() == RoboticArm.ArmStatus.ON_POSITION_THREE
				||
				States.LEFT_ARM_OBJECT.getArmStatus() == RoboticArm.ArmStatus.ABOVE_POSITION_THREE
				)){
			g.drawImage(BaxterLoadLidNoOtherEventF, 0, 0, null);
		}
		
		// ----------- Baxter both arm actions modes ----------------------------------
		//Baxter turntable fault and placing at pos1
		if (States.RIGHT_ARM_OBJECT != null &&
				((States.RIGHT_ARM_OBJECT.getArmStatus() == RoboticArm.ArmStatus.ABOVE_ROTARY_TURNTABLE
				||
				States.RIGHT_ARM_OBJECT.getArmStatus() == RoboticArm.ArmStatus.ON_ROTARY_TURNTABLE
				))
				&&
				((States.LEFT_ARM_OBJECT.getArmStatus() == RoboticArm.ArmStatus.ON_COLLECTION_POINT 
				||
				States.LEFT_ARM_OBJECT.getArmStatus() == RoboticArm.ArmStatus.ABOVE_COLLECTION_POINT
				))
				){
			g.drawImage(BaxterSpinTTOAndPlacePos1, 0, 0, null);
		}
		
		//Baxter Load Lid Plus remove from item from converyor
		if (States.RIGHT_ARM_OBJECT != null &&
				((States.RIGHT_ARM_OBJECT.getArmStatus() == RoboticArm.ArmStatus.ON_PACKAGE
				||
				States.RIGHT_ARM_OBJECT.getArmStatus() == RoboticArm.ArmStatus.ABOVE_PACKAGE
				))
				&&
				((States.LEFT_ARM_OBJECT.getArmStatus() == RoboticArm.ArmStatus.ON_POSITION_THREE
				||
				States.LEFT_ARM_OBJECT.getArmStatus() == RoboticArm.ArmStatus.ABOVE_POSITION_THREE
				))
				){
			g.drawImage(BaxterLoadLidFRemoveFromConvF, 0, 0, null);
		}
		
		
		
		
		/****************************************BAXTER FINISHED *****************************************************/
		if (States.BOTTLE_AT_POS1) {
			g.drawImage(emptyBottle, 355, 320, null);
		} 
		if(States.BOTTLE_AT_POS4) {
			g.drawImage(completeBottle, 435, 285, null);
		}
		if(States.BOTTLE_AT_POS5) {
			g.drawImage(completeBottle, 440, 320, null);
		} 
		
		
		//Liquid Filler
//		if (States.BOTTLE_FILLED) {
//			g.drawImage(bottleFillerDoneDyn, 280, 233, null);
//		} else {
//			g.drawImage(bottleFillerNotDoneDyn, 280, 233, null);
//		}
		
	
		//Lid Loader
		//cap
		if (counter == 0 && States.PUSHER_EXTENDED) {
			counter++;
		}
		else if (counter == 0) {
			g.drawImage(bottleCap, 360, 115, null);
		}
		else if (counter == 1 && States.ARM_AT_UP) {
			counter++;
		}
		else if (counter == 1){
			g.drawImage(bottleCap, 410, 115, null);
		}  else if (counter == 2 && States.ARM_AT_DOWN) {
			g.drawImage(bottleCap, 360, 115, null);
		} 
		else if (counter == 2) {
			g.drawImage(bottleCap, 410, 115, null);
		} 
			// Arm
		if (States.ARM_AT_UP) {
			g.drawImage(lidLoaderArmUP, 395, 115, null);
		} else {
			g.drawImage(lidLoaderArmDOWN, 395, 195, null);
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
		
	}
}
