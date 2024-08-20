import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class LidLoaderPlant extends ClockDomain{
  public LidLoaderPlant(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal pusherExtend = new Signal("pusherExtend", Signal.INPUT);
  public Signal vacOn = new Signal("vacOn", Signal.INPUT);
  public Signal armSource = new Signal("armSource", Signal.INPUT);
  public Signal armDest = new Signal("armDest", Signal.INPUT);
  public Signal enable = new Signal("enable", Signal.INPUT);
  public Signal refill = new Signal("refill", Signal.INPUT);
  public Signal pusherRetracted = new Signal("pusherRetracted", Signal.OUTPUT);
  public Signal pusherExtended = new Signal("pusherExtended", Signal.OUTPUT);
  public Signal WPgripped = new Signal("WPgripped", Signal.OUTPUT);
  public Signal armAtSource = new Signal("armAtSource", Signal.OUTPUT);
  public Signal armAtDest = new Signal("armAtDest", Signal.OUTPUT);
  public Signal empty = new Signal("empty", Signal.OUTPUT);
  public Signal pusherRetractedE = new Signal("pusherRetractedE", Signal.OUTPUT);
  public Signal pusherExtendedE = new Signal("pusherExtendedE", Signal.OUTPUT);
  public Signal WPgrippedE = new Signal("WPgrippedE", Signal.OUTPUT);
  public Signal armAtSourceE = new Signal("armAtSourceE", Signal.OUTPUT);
  public Signal armAtDestE = new Signal("armAtDestE", Signal.OUTPUT);
  public Signal emptyE = new Signal("emptyE", Signal.OUTPUT);
  private Signal capDec_1;
  private Signal capPos_1;
  private int capcount_thread_6;//sysj\lid_loader_plant.sysj line: 78, column: 3
  private int S865 = 1;
  private int S256 = 1;
  private int S210 = 1;
  private int S309 = 1;
  private int S263 = 1;
  private int S353 = 1;
  private int S323 = 1;
  private int S318 = 1;
  private int S421 = 1;
  private int S375 = 1;
  private int S357 = 1;
  private int S483 = 1;
  private int S533 = 1;
  private int S491 = 1;
  private int S499 = 1;
  private int S507 = 1;
  private int S515 = 1;
  private int S523 = 1;
  private int S531 = 1;
  
  private int[] ends = new int[14];
  private int[] tdone = new int[14];
  
  public void thread892(int [] tdone, int [] ends){
        switch(S531){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        if(empty.getprestatus()){//sysj\lid_loader_plant.sysj line: 106, column: 24
          emptyE.setPresent();//sysj\lid_loader_plant.sysj line: 106, column: 31
          currsigs.addElement(emptyE);
          active[13]=1;
          ends[13]=1;
          tdone[13]=1;
        }
        else {
          active[13]=1;
          ends[13]=1;
          tdone[13]=1;
        }
        break;
      
    }
  }

  public void thread891(int [] tdone, int [] ends){
        switch(S523){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        if(armAtDest.getprestatus()){//sysj\lid_loader_plant.sysj line: 104, column: 24
          armAtDestE.setPresent();//sysj\lid_loader_plant.sysj line: 104, column: 35
          currsigs.addElement(armAtDestE);
          active[12]=1;
          ends[12]=1;
          tdone[12]=1;
        }
        else {
          active[12]=1;
          ends[12]=1;
          tdone[12]=1;
        }
        break;
      
    }
  }

  public void thread890(int [] tdone, int [] ends){
        switch(S515){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        if(armAtSource.getprestatus()){//sysj\lid_loader_plant.sysj line: 102, column: 24
          armAtSourceE.setPresent();//sysj\lid_loader_plant.sysj line: 102, column: 37
          currsigs.addElement(armAtSourceE);
          active[11]=1;
          ends[11]=1;
          tdone[11]=1;
        }
        else {
          active[11]=1;
          ends[11]=1;
          tdone[11]=1;
        }
        break;
      
    }
  }

  public void thread889(int [] tdone, int [] ends){
        switch(S507){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        if(WPgripped.getprestatus()){//sysj\lid_loader_plant.sysj line: 100, column: 24
          WPgrippedE.setPresent();//sysj\lid_loader_plant.sysj line: 100, column: 35
          currsigs.addElement(WPgrippedE);
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
        else {
          active[10]=1;
          ends[10]=1;
          tdone[10]=1;
        }
        break;
      
    }
  }

  public void thread888(int [] tdone, int [] ends){
        switch(S499){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        if(pusherExtended.getprestatus()){//sysj\lid_loader_plant.sysj line: 98, column: 24
          pusherExtendedE.setPresent();//sysj\lid_loader_plant.sysj line: 98, column: 40
          currsigs.addElement(pusherExtendedE);
          active[9]=1;
          ends[9]=1;
          tdone[9]=1;
        }
        else {
          active[9]=1;
          ends[9]=1;
          tdone[9]=1;
        }
        break;
      
    }
  }

  public void thread887(int [] tdone, int [] ends){
        switch(S491){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        if(pusherRetracted.getprestatus()){//sysj\lid_loader_plant.sysj line: 96, column: 24
          pusherRetractedE.setPresent();//sysj\lid_loader_plant.sysj line: 96, column: 41
          currsigs.addElement(pusherRetractedE);
          active[8]=1;
          ends[8]=1;
          tdone[8]=1;
        }
        else {
          active[8]=1;
          ends[8]=1;
          tdone[8]=1;
        }
        break;
      
    }
  }

  public void thread886(int [] tdone, int [] ends){
        switch(S533){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        thread887(tdone,ends);
        thread888(tdone,ends);
        thread889(tdone,ends);
        thread890(tdone,ends);
        thread891(tdone,ends);
        thread892(tdone,ends);
        int biggest893 = 0;
        if(ends[8]>=biggest893){
          biggest893=ends[8];
        }
        if(ends[9]>=biggest893){
          biggest893=ends[9];
        }
        if(ends[10]>=biggest893){
          biggest893=ends[10];
        }
        if(ends[11]>=biggest893){
          biggest893=ends[11];
        }
        if(ends[12]>=biggest893){
          biggest893=ends[12];
        }
        if(ends[13]>=biggest893){
          biggest893=ends[13];
        }
        if(biggest893 == 1){
          active[7]=1;
          ends[7]=1;
          tdone[7]=1;
        }
        //FINXME code
        if(biggest893 == 0){
          S533=0;
          active[7]=0;
          ends[7]=0;
          tdone[7]=1;
        }
        break;
      
    }
  }

  public void thread885(int [] tdone, int [] ends){
        switch(S483){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(capDec_1.getprestatus()){//sysj\lid_loader_plant.sysj line: 80, column: 12
          if(capcount_thread_6 > 0) {//sysj\lid_loader_plant.sysj line: 81, column: 5
            capcount_thread_6 = capcount_thread_6 - 1;//sysj\lid_loader_plant.sysj line: 82, column: 6
          }
          if(refill.getprestatus()){//sysj\lid_loader_plant.sysj line: 84, column: 12
            capcount_thread_6 = 5;//sysj\lid_loader_plant.sysj line: 85, column: 5
            if(capcount_thread_6 == 0){//sysj\lid_loader_plant.sysj line: 88, column: 8
              empty.setPresent();//sysj\lid_loader_plant.sysj line: 89, column: 6
              currsigs.addElement(empty);
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
          }
          else {
            if(capcount_thread_6 == 0){//sysj\lid_loader_plant.sysj line: 88, column: 8
              empty.setPresent();//sysj\lid_loader_plant.sysj line: 89, column: 6
              currsigs.addElement(empty);
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
          }
        }
        else {
          if(refill.getprestatus()){//sysj\lid_loader_plant.sysj line: 84, column: 12
            capcount_thread_6 = 5;//sysj\lid_loader_plant.sysj line: 85, column: 5
            if(capcount_thread_6 == 0){//sysj\lid_loader_plant.sysj line: 88, column: 8
              empty.setPresent();//sysj\lid_loader_plant.sysj line: 89, column: 6
              currsigs.addElement(empty);
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
          }
          else {
            if(capcount_thread_6 == 0){//sysj\lid_loader_plant.sysj line: 88, column: 8
              empty.setPresent();//sysj\lid_loader_plant.sysj line: 89, column: 6
              currsigs.addElement(empty);
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
          }
        }
        break;
      
    }
  }

  public void thread884(int [] tdone, int [] ends){
        switch(S421){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S375){
          case 0 : 
            if(empty.getprestatus()){//sysj\lid_loader_plant.sysj line: 63, column: 10
              S375=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              switch(S357){
                case 0 : 
                  if(pusherRetracted.getprestatus()){//sysj\lid_loader_plant.sysj line: 65, column: 13
                    S357=1;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  break;
                
                case 1 : 
                  if(pusherExtended.getprestatus()){//sysj\lid_loader_plant.sysj line: 66, column: 13
                    capPos_1.setPresent();//sysj\lid_loader_plant.sysj line: 68, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\lid_loader_plant.sysj line: 68, column: 7
                    S357=2;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  break;
                
                case 2 : 
                  if(pusherRetracted.getprestatus()){//sysj\lid_loader_plant.sysj line: 69, column: 13
                    capDec_1.setPresent();//sysj\lid_loader_plant.sysj line: 70, column: 7
                    currsigs.addElement(capDec_1);
                    S357=0;
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  else {
                    active[5]=1;
                    ends[5]=1;
                    tdone[5]=1;
                  }
                  break;
                
              }
            }
            break;
          
          case 1 : 
            if(refill.getprestatus()){//sysj\lid_loader_plant.sysj line: 73, column: 10
              S375=0;
              S357=0;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread883(int [] tdone, int [] ends){
        switch(S353){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S323){
          case 0 : 
            switch(S318){
              case 0 : 
                if(!vacOn.getprestatus()){//sysj\lid_loader_plant.sysj line: 43, column: 12
                  S318=1;
                  if(armAtSource.getprestatus()){//sysj\lid_loader_plant.sysj line: 46, column: 14
                    capPos_1.setPresent();//sysj\lid_loader_plant.sysj line: 47, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\lid_loader_plant.sysj line: 47, column: 7
                    S323=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S323=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  WPgripped.setPresent();//sysj\lid_loader_plant.sysj line: 44, column: 7
                  currsigs.addElement(WPgripped);
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
              case 1 : 
                S323=0;
                if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\lid_loader_plant.sysj line: 40, column: 12
                  if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\lid_loader_plant.sysj line: 41, column: 8
                    capPos_1.setPresent();//sysj\lid_loader_plant.sysj line: 42, column: 6
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(0);//sysj\lid_loader_plant.sysj line: 42, column: 6
                    S318=0;
                    WPgripped.setPresent();//sysj\lid_loader_plant.sysj line: 44, column: 7
                    currsigs.addElement(WPgripped);
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S323=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  S323=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S323=1;
            S323=0;
            if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\lid_loader_plant.sysj line: 40, column: 12
              if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\lid_loader_plant.sysj line: 41, column: 8
                capPos_1.setPresent();//sysj\lid_loader_plant.sysj line: 42, column: 6
                currsigs.addElement(capPos_1);
                capPos_1.setValue(0);//sysj\lid_loader_plant.sysj line: 42, column: 6
                S318=0;
                WPgripped.setPresent();//sysj\lid_loader_plant.sysj line: 44, column: 7
                currsigs.addElement(WPgripped);
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S323=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              S323=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread882(int [] tdone, int [] ends){
        switch(S309){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S263){
          case 0 : 
            if(pusherExtend.getprestatus() && enable.getprestatus()){//sysj\lid_loader_plant.sysj line: 27, column: 10
              S263=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              pusherRetracted.setPresent();//sysj\lid_loader_plant.sysj line: 28, column: 5
              currsigs.addElement(pusherRetracted);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\lid_loader_plant.sysj line: 30, column: 10
              S263=2;
              pusherExtended.setPresent();//sysj\lid_loader_plant.sysj line: 32, column: 5
              currsigs.addElement(pusherExtended);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 2 : 
            if(!pusherExtend.getprestatus() && enable.getprestatus()){//sysj\lid_loader_plant.sysj line: 31, column: 10
              S263=3;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              pusherExtended.setPresent();//sysj\lid_loader_plant.sysj line: 32, column: 5
              currsigs.addElement(pusherExtended);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\lid_loader_plant.sysj line: 34, column: 10
              S263=0;
              pusherRetracted.setPresent();//sysj\lid_loader_plant.sysj line: 28, column: 5
              currsigs.addElement(pusherRetracted);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread881(int [] tdone, int [] ends){
        switch(S256){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S210){
          case 0 : 
            if(armSource.getprestatus() && enable.getprestatus()){//sysj\lid_loader_plant.sysj line: 14, column: 10
              S210=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtDest.setPresent();//sysj\lid_loader_plant.sysj line: 15, column: 5
              currsigs.addElement(armAtDest);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\lid_loader_plant.sysj line: 17, column: 10
              S210=2;
              armAtSource.setPresent();//sysj\lid_loader_plant.sysj line: 19, column: 5
              currsigs.addElement(armAtSource);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 2 : 
            if(armDest.getprestatus() && enable.getprestatus()){//sysj\lid_loader_plant.sysj line: 18, column: 10
              S210=3;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtSource.setPresent();//sysj\lid_loader_plant.sysj line: 19, column: 5
              currsigs.addElement(armAtSource);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\lid_loader_plant.sysj line: 21, column: 10
              S210=0;
              armAtDest.setPresent();//sysj\lid_loader_plant.sysj line: 15, column: 5
              currsigs.addElement(armAtDest);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread878(int [] tdone, int [] ends){
        S531=1;
    if(empty.getprestatus()){//sysj\lid_loader_plant.sysj line: 106, column: 24
      emptyE.setPresent();//sysj\lid_loader_plant.sysj line: 106, column: 31
      currsigs.addElement(emptyE);
      active[13]=1;
      ends[13]=1;
      tdone[13]=1;
    }
    else {
      active[13]=1;
      ends[13]=1;
      tdone[13]=1;
    }
  }

  public void thread877(int [] tdone, int [] ends){
        S523=1;
    if(armAtDest.getprestatus()){//sysj\lid_loader_plant.sysj line: 104, column: 24
      armAtDestE.setPresent();//sysj\lid_loader_plant.sysj line: 104, column: 35
      currsigs.addElement(armAtDestE);
      active[12]=1;
      ends[12]=1;
      tdone[12]=1;
    }
    else {
      active[12]=1;
      ends[12]=1;
      tdone[12]=1;
    }
  }

  public void thread876(int [] tdone, int [] ends){
        S515=1;
    if(armAtSource.getprestatus()){//sysj\lid_loader_plant.sysj line: 102, column: 24
      armAtSourceE.setPresent();//sysj\lid_loader_plant.sysj line: 102, column: 37
      currsigs.addElement(armAtSourceE);
      active[11]=1;
      ends[11]=1;
      tdone[11]=1;
    }
    else {
      active[11]=1;
      ends[11]=1;
      tdone[11]=1;
    }
  }

  public void thread875(int [] tdone, int [] ends){
        S507=1;
    if(WPgripped.getprestatus()){//sysj\lid_loader_plant.sysj line: 100, column: 24
      WPgrippedE.setPresent();//sysj\lid_loader_plant.sysj line: 100, column: 35
      currsigs.addElement(WPgrippedE);
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
    else {
      active[10]=1;
      ends[10]=1;
      tdone[10]=1;
    }
  }

  public void thread874(int [] tdone, int [] ends){
        S499=1;
    if(pusherExtended.getprestatus()){//sysj\lid_loader_plant.sysj line: 98, column: 24
      pusherExtendedE.setPresent();//sysj\lid_loader_plant.sysj line: 98, column: 40
      currsigs.addElement(pusherExtendedE);
      active[9]=1;
      ends[9]=1;
      tdone[9]=1;
    }
    else {
      active[9]=1;
      ends[9]=1;
      tdone[9]=1;
    }
  }

  public void thread873(int [] tdone, int [] ends){
        S491=1;
    if(pusherRetracted.getprestatus()){//sysj\lid_loader_plant.sysj line: 96, column: 24
      pusherRetractedE.setPresent();//sysj\lid_loader_plant.sysj line: 96, column: 41
      currsigs.addElement(pusherRetractedE);
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
    else {
      active[8]=1;
      ends[8]=1;
      tdone[8]=1;
    }
  }

  public void thread872(int [] tdone, int [] ends){
        S533=1;
    thread873(tdone,ends);
    thread874(tdone,ends);
    thread875(tdone,ends);
    thread876(tdone,ends);
    thread877(tdone,ends);
    thread878(tdone,ends);
    int biggest879 = 0;
    if(ends[8]>=biggest879){
      biggest879=ends[8];
    }
    if(ends[9]>=biggest879){
      biggest879=ends[9];
    }
    if(ends[10]>=biggest879){
      biggest879=ends[10];
    }
    if(ends[11]>=biggest879){
      biggest879=ends[11];
    }
    if(ends[12]>=biggest879){
      biggest879=ends[12];
    }
    if(ends[13]>=biggest879){
      biggest879=ends[13];
    }
    if(biggest879 == 1){
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
  }

  public void thread871(int [] tdone, int [] ends){
        S483=1;
    capcount_thread_6 = 5;//sysj\lid_loader_plant.sysj line: 78, column: 3
    if(capDec_1.getprestatus()){//sysj\lid_loader_plant.sysj line: 80, column: 12
      if(capcount_thread_6 > 0) {//sysj\lid_loader_plant.sysj line: 81, column: 5
        capcount_thread_6 = capcount_thread_6 - 1;//sysj\lid_loader_plant.sysj line: 82, column: 6
      }
      if(refill.getprestatus()){//sysj\lid_loader_plant.sysj line: 84, column: 12
        capcount_thread_6 = 5;//sysj\lid_loader_plant.sysj line: 85, column: 5
        if(capcount_thread_6 == 0){//sysj\lid_loader_plant.sysj line: 88, column: 8
          empty.setPresent();//sysj\lid_loader_plant.sysj line: 89, column: 6
          currsigs.addElement(empty);
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
        else {
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
      }
      else {
        if(capcount_thread_6 == 0){//sysj\lid_loader_plant.sysj line: 88, column: 8
          empty.setPresent();//sysj\lid_loader_plant.sysj line: 89, column: 6
          currsigs.addElement(empty);
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
        else {
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
      }
    }
    else {
      if(refill.getprestatus()){//sysj\lid_loader_plant.sysj line: 84, column: 12
        capcount_thread_6 = 5;//sysj\lid_loader_plant.sysj line: 85, column: 5
        if(capcount_thread_6 == 0){//sysj\lid_loader_plant.sysj line: 88, column: 8
          empty.setPresent();//sysj\lid_loader_plant.sysj line: 89, column: 6
          currsigs.addElement(empty);
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
        else {
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
      }
      else {
        if(capcount_thread_6 == 0){//sysj\lid_loader_plant.sysj line: 88, column: 8
          empty.setPresent();//sysj\lid_loader_plant.sysj line: 89, column: 6
          currsigs.addElement(empty);
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
        else {
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
      }
    }
  }

  public void thread870(int [] tdone, int [] ends){
        S421=1;
    S375=0;
    S357=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread869(int [] tdone, int [] ends){
        S353=1;
    S323=0;
    if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\lid_loader_plant.sysj line: 40, column: 12
      if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\lid_loader_plant.sysj line: 41, column: 8
        capPos_1.setPresent();//sysj\lid_loader_plant.sysj line: 42, column: 6
        currsigs.addElement(capPos_1);
        capPos_1.setValue(0);//sysj\lid_loader_plant.sysj line: 42, column: 6
        S318=0;
        WPgripped.setPresent();//sysj\lid_loader_plant.sysj line: 44, column: 7
        currsigs.addElement(WPgripped);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S323=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
    }
    else {
      S323=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread868(int [] tdone, int [] ends){
        S309=1;
    S263=0;
    pusherRetracted.setPresent();//sysj\lid_loader_plant.sysj line: 28, column: 5
    currsigs.addElement(pusherRetracted);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread867(int [] tdone, int [] ends){
        S256=1;
    S210=0;
    armAtDest.setPresent();//sysj\lid_loader_plant.sysj line: 15, column: 5
    currsigs.addElement(armAtDest);
    active[2]=1;
    ends[2]=1;
    tdone[2]=1;
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S865){
        case 0 : 
          S865=0;
          break RUN;
        
        case 1 : 
          S865=2;
          S865=2;
          capDec_1.setClear();//sysj\lid_loader_plant.sysj line: 9, column: 2
          capPos_1.setClear();//sysj\lid_loader_plant.sysj line: 10, column: 2
          capPos_1.setPresent();//sysj\lid_loader_plant.sysj line: 11, column: 2
          currsigs.addElement(capPos_1);
          capPos_1.setValue(0);//sysj\lid_loader_plant.sysj line: 11, column: 2
          thread867(tdone,ends);
          thread868(tdone,ends);
          thread869(tdone,ends);
          thread870(tdone,ends);
          thread871(tdone,ends);
          thread872(tdone,ends);
          int biggest880 = 0;
          if(ends[2]>=biggest880){
            biggest880=ends[2];
          }
          if(ends[3]>=biggest880){
            biggest880=ends[3];
          }
          if(ends[4]>=biggest880){
            biggest880=ends[4];
          }
          if(ends[5]>=biggest880){
            biggest880=ends[5];
          }
          if(ends[6]>=biggest880){
            biggest880=ends[6];
          }
          if(ends[7]>=biggest880){
            biggest880=ends[7];
          }
          if(biggest880 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          capDec_1.setClear();//sysj\lid_loader_plant.sysj line: 9, column: 2
          capPos_1.setClear();//sysj\lid_loader_plant.sysj line: 10, column: 2
          thread881(tdone,ends);
          thread882(tdone,ends);
          thread883(tdone,ends);
          thread884(tdone,ends);
          thread885(tdone,ends);
          thread886(tdone,ends);
          int biggest894 = 0;
          if(ends[2]>=biggest894){
            biggest894=ends[2];
          }
          if(ends[3]>=biggest894){
            biggest894=ends[3];
          }
          if(ends[4]>=biggest894){
            biggest894=ends[4];
          }
          if(ends[5]>=biggest894){
            biggest894=ends[5];
          }
          if(ends[6]>=biggest894){
            biggest894=ends[6];
          }
          if(ends[7]>=biggest894){
            biggest894=ends[7];
          }
          if(biggest894 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest894 == 0){
            S865=0;
            active[1]=0;
            ends[1]=0;
            S865=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    capDec_1 = new Signal();
    capPos_1 = new Signal();
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[1] != 0){
      int index = 1;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        if(!df){
          pusherExtend.gethook();
          vacOn.gethook();
          armSource.gethook();
          armDest.gethook();
          enable.gethook();
          refill.gethook();
          df = true;
        }
        runClockDomain();
      }
      pusherExtend.setpreclear();
      vacOn.setpreclear();
      armSource.setpreclear();
      armDest.setpreclear();
      enable.setpreclear();
      refill.setpreclear();
      pusherRetracted.setpreclear();
      pusherExtended.setpreclear();
      WPgripped.setpreclear();
      armAtSource.setpreclear();
      armAtDest.setpreclear();
      empty.setpreclear();
      pusherRetractedE.setpreclear();
      pusherExtendedE.setpreclear();
      WPgrippedE.setpreclear();
      armAtSourceE.setpreclear();
      armAtDestE.setpreclear();
      emptyE.setpreclear();
      capDec_1.setpreclear();
      capPos_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = pusherExtend.getStatus() ? pusherExtend.setprepresent() : pusherExtend.setpreclear();
      pusherExtend.setpreval(pusherExtend.getValue());
      pusherExtend.setClear();
      dummyint = vacOn.getStatus() ? vacOn.setprepresent() : vacOn.setpreclear();
      vacOn.setpreval(vacOn.getValue());
      vacOn.setClear();
      dummyint = armSource.getStatus() ? armSource.setprepresent() : armSource.setpreclear();
      armSource.setpreval(armSource.getValue());
      armSource.setClear();
      dummyint = armDest.getStatus() ? armDest.setprepresent() : armDest.setpreclear();
      armDest.setpreval(armDest.getValue());
      armDest.setClear();
      dummyint = enable.getStatus() ? enable.setprepresent() : enable.setpreclear();
      enable.setpreval(enable.getValue());
      enable.setClear();
      dummyint = refill.getStatus() ? refill.setprepresent() : refill.setpreclear();
      refill.setpreval(refill.getValue());
      refill.setClear();
      pusherRetracted.sethook();
      pusherRetracted.setClear();
      pusherExtended.sethook();
      pusherExtended.setClear();
      WPgripped.sethook();
      WPgripped.setClear();
      armAtSource.sethook();
      armAtSource.setClear();
      armAtDest.sethook();
      armAtDest.setClear();
      empty.sethook();
      empty.setClear();
      pusherRetractedE.sethook();
      pusherRetractedE.setClear();
      pusherExtendedE.sethook();
      pusherExtendedE.setClear();
      WPgrippedE.sethook();
      WPgrippedE.setClear();
      armAtSourceE.sethook();
      armAtSourceE.setClear();
      armAtDestE.sethook();
      armAtDestE.setClear();
      emptyE.sethook();
      emptyE.setClear();
      capDec_1.setClear();
      capPos_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        pusherExtend.gethook();
        vacOn.gethook();
        armSource.gethook();
        armDest.gethook();
        enable.gethook();
        refill.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
