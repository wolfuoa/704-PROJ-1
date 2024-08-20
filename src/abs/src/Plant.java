import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;
import run.GUI;//sysj\lid_loader_plant.sysj line: 1, column: 1

public class Plant extends ClockDomain{
  public Plant(String name){super(name);}
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
  private int capcount_thread_6;//sysj\lid_loader_plant.sysj line: 82, column: 3
  private int S1519 = 1;
  private int S246 = 1;
  private int S200 = 1;
  private int S299 = 1;
  private int S253 = 1;
  private int S343 = 1;
  private int S313 = 1;
  private int S308 = 1;
  private int S411 = 1;
  private int S365 = 1;
  private int S347 = 1;
  private int S473 = 1;
  private int S523 = 1;
  private int S481 = 1;
  private int S489 = 1;
  private int S497 = 1;
  private int S505 = 1;
  private int S513 = 1;
  private int S521 = 1;
  
  private int[] ends = new int[14];
  private int[] tdone = new int[14];
  
  public void thread1546(int [] tdone, int [] ends){
        switch(S521){
      case 0 : 
        active[13]=0;
        ends[13]=0;
        tdone[13]=1;
        break;
      
      case 1 : 
        if(empty.getprestatus()){//sysj\lid_loader_plant.sysj line: 110, column: 24
          emptyE.setPresent();//sysj\lid_loader_plant.sysj line: 110, column: 31
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

  public void thread1545(int [] tdone, int [] ends){
        switch(S513){
      case 0 : 
        active[12]=0;
        ends[12]=0;
        tdone[12]=1;
        break;
      
      case 1 : 
        if(armAtDest.getprestatus()){//sysj\lid_loader_plant.sysj line: 108, column: 24
          armAtDestE.setPresent();//sysj\lid_loader_plant.sysj line: 108, column: 35
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

  public void thread1544(int [] tdone, int [] ends){
        switch(S505){
      case 0 : 
        active[11]=0;
        ends[11]=0;
        tdone[11]=1;
        break;
      
      case 1 : 
        if(armAtSource.getprestatus()){//sysj\lid_loader_plant.sysj line: 106, column: 24
          armAtSourceE.setPresent();//sysj\lid_loader_plant.sysj line: 106, column: 37
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

  public void thread1543(int [] tdone, int [] ends){
        switch(S497){
      case 0 : 
        active[10]=0;
        ends[10]=0;
        tdone[10]=1;
        break;
      
      case 1 : 
        if(WPgripped.getprestatus()){//sysj\lid_loader_plant.sysj line: 104, column: 24
          WPgrippedE.setPresent();//sysj\lid_loader_plant.sysj line: 104, column: 35
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

  public void thread1542(int [] tdone, int [] ends){
        switch(S489){
      case 0 : 
        active[9]=0;
        ends[9]=0;
        tdone[9]=1;
        break;
      
      case 1 : 
        if(pusherExtended.getprestatus()){//sysj\lid_loader_plant.sysj line: 102, column: 24
          pusherExtendedE.setPresent();//sysj\lid_loader_plant.sysj line: 102, column: 40
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

  public void thread1541(int [] tdone, int [] ends){
        switch(S481){
      case 0 : 
        active[8]=0;
        ends[8]=0;
        tdone[8]=1;
        break;
      
      case 1 : 
        if(pusherRetracted.getprestatus()){//sysj\lid_loader_plant.sysj line: 100, column: 24
          pusherRetractedE.setPresent();//sysj\lid_loader_plant.sysj line: 100, column: 41
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

  public void thread1540(int [] tdone, int [] ends){
        switch(S523){
      case 0 : 
        active[7]=0;
        ends[7]=0;
        tdone[7]=1;
        break;
      
      case 1 : 
        thread1541(tdone,ends);
        thread1542(tdone,ends);
        thread1543(tdone,ends);
        thread1544(tdone,ends);
        thread1545(tdone,ends);
        thread1546(tdone,ends);
        int biggest1547 = 0;
        if(ends[8]>=biggest1547){
          biggest1547=ends[8];
        }
        if(ends[9]>=biggest1547){
          biggest1547=ends[9];
        }
        if(ends[10]>=biggest1547){
          biggest1547=ends[10];
        }
        if(ends[11]>=biggest1547){
          biggest1547=ends[11];
        }
        if(ends[12]>=biggest1547){
          biggest1547=ends[12];
        }
        if(ends[13]>=biggest1547){
          biggest1547=ends[13];
        }
        if(biggest1547 == 1){
          active[7]=1;
          ends[7]=1;
          tdone[7]=1;
        }
        //FINXME code
        if(biggest1547 == 0){
          S523=0;
          active[7]=0;
          ends[7]=0;
          tdone[7]=1;
        }
        break;
      
    }
  }

  public void thread1539(int [] tdone, int [] ends){
        switch(S473){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(capDec_1.getprestatus()){//sysj\lid_loader_plant.sysj line: 84, column: 12
          if(capcount_thread_6 > 0) {//sysj\lid_loader_plant.sysj line: 85, column: 5
            capcount_thread_6 = capcount_thread_6 - 1;//sysj\lid_loader_plant.sysj line: 86, column: 6
          }
          if(refill.getprestatus()){//sysj\lid_loader_plant.sysj line: 88, column: 12
            capcount_thread_6 = 5;//sysj\lid_loader_plant.sysj line: 89, column: 5
            if(capcount_thread_6 == 0){//sysj\lid_loader_plant.sysj line: 92, column: 8
              empty.setPresent();//sysj\lid_loader_plant.sysj line: 93, column: 6
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
            if(capcount_thread_6 == 0){//sysj\lid_loader_plant.sysj line: 92, column: 8
              empty.setPresent();//sysj\lid_loader_plant.sysj line: 93, column: 6
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
          if(refill.getprestatus()){//sysj\lid_loader_plant.sysj line: 88, column: 12
            capcount_thread_6 = 5;//sysj\lid_loader_plant.sysj line: 89, column: 5
            if(capcount_thread_6 == 0){//sysj\lid_loader_plant.sysj line: 92, column: 8
              empty.setPresent();//sysj\lid_loader_plant.sysj line: 93, column: 6
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
            if(capcount_thread_6 == 0){//sysj\lid_loader_plant.sysj line: 92, column: 8
              empty.setPresent();//sysj\lid_loader_plant.sysj line: 93, column: 6
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

  public void thread1538(int [] tdone, int [] ends){
        switch(S411){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        switch(S365){
          case 0 : 
            if(empty.getprestatus()){//sysj\lid_loader_plant.sysj line: 67, column: 10
              S365=1;
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              switch(S347){
                case 0 : 
                  if(pusherRetracted.getprestatus()){//sysj\lid_loader_plant.sysj line: 69, column: 13
                    S347=1;
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
                  if(pusherExtended.getprestatus()){//sysj\lid_loader_plant.sysj line: 70, column: 13
                    capPos_1.setPresent();//sysj\lid_loader_plant.sysj line: 72, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\lid_loader_plant.sysj line: 72, column: 7
                    S347=2;
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
                  if(pusherRetracted.getprestatus()){//sysj\lid_loader_plant.sysj line: 73, column: 13
                    capDec_1.setPresent();//sysj\lid_loader_plant.sysj line: 74, column: 7
                    currsigs.addElement(capDec_1);
                    S347=0;
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
            if(refill.getprestatus()){//sysj\lid_loader_plant.sysj line: 77, column: 10
              S365=0;
              S347=0;
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

  public void thread1537(int [] tdone, int [] ends){
        switch(S343){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        switch(S313){
          case 0 : 
            switch(S308){
              case 0 : 
                if(!vacOn.getprestatus()){//sysj\lid_loader_plant.sysj line: 47, column: 12
                  S308=1;
                  if(armAtSource.getprestatus()){//sysj\lid_loader_plant.sysj line: 50, column: 14
                    capPos_1.setPresent();//sysj\lid_loader_plant.sysj line: 51, column: 7
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(1);//sysj\lid_loader_plant.sysj line: 51, column: 7
                    S313=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S313=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  WPgripped.setPresent();//sysj\lid_loader_plant.sysj line: 48, column: 7
                  currsigs.addElement(WPgripped);
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
              case 1 : 
                S313=0;
                if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\lid_loader_plant.sysj line: 44, column: 12
                  if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\lid_loader_plant.sysj line: 45, column: 8
                    capPos_1.setPresent();//sysj\lid_loader_plant.sysj line: 46, column: 6
                    currsigs.addElement(capPos_1);
                    capPos_1.setValue(0);//sysj\lid_loader_plant.sysj line: 46, column: 6
                    S308=0;
                    WPgripped.setPresent();//sysj\lid_loader_plant.sysj line: 48, column: 7
                    currsigs.addElement(WPgripped);
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                  else {
                    S313=1;
                    active[4]=1;
                    ends[4]=1;
                    tdone[4]=1;
                  }
                }
                else {
                  S313=1;
                  active[4]=1;
                  ends[4]=1;
                  tdone[4]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S313=1;
            S313=0;
            if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\lid_loader_plant.sysj line: 44, column: 12
              if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\lid_loader_plant.sysj line: 45, column: 8
                capPos_1.setPresent();//sysj\lid_loader_plant.sysj line: 46, column: 6
                currsigs.addElement(capPos_1);
                capPos_1.setValue(0);//sysj\lid_loader_plant.sysj line: 46, column: 6
                S308=0;
                WPgripped.setPresent();//sysj\lid_loader_plant.sysj line: 48, column: 7
                currsigs.addElement(WPgripped);
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
              else {
                S313=1;
                active[4]=1;
                ends[4]=1;
                tdone[4]=1;
              }
            }
            else {
              S313=1;
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread1536(int [] tdone, int [] ends){
        switch(S299){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S253){
          case 0 : 
            if(pusherExtend.getprestatus() && enable.getprestatus()){//sysj\lid_loader_plant.sysj line: 31, column: 10
              S253=1;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              pusherRetracted.setPresent();//sysj\lid_loader_plant.sysj line: 32, column: 5
              currsigs.addElement(pusherRetracted);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\lid_loader_plant.sysj line: 34, column: 10
              S253=2;
              pusherExtended.setPresent();//sysj\lid_loader_plant.sysj line: 36, column: 5
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
            if(!pusherExtend.getprestatus() && enable.getprestatus()){//sysj\lid_loader_plant.sysj line: 35, column: 10
              S253=3;
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              pusherExtended.setPresent();//sysj\lid_loader_plant.sysj line: 36, column: 5
              currsigs.addElement(pusherExtended);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\lid_loader_plant.sysj line: 38, column: 10
              S253=0;
              pusherRetracted.setPresent();//sysj\lid_loader_plant.sysj line: 32, column: 5
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

  public void thread1535(int [] tdone, int [] ends){
        switch(S246){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S200){
          case 0 : 
            if(armSource.getprestatus() && enable.getprestatus()){//sysj\lid_loader_plant.sysj line: 18, column: 10
              S200=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtDest.setPresent();//sysj\lid_loader_plant.sysj line: 19, column: 5
              currsigs.addElement(armAtDest);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 1 : 
            if(!enable.getprestatus()){//sysj\lid_loader_plant.sysj line: 21, column: 10
              S200=2;
              armAtSource.setPresent();//sysj\lid_loader_plant.sysj line: 23, column: 5
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
            if(armDest.getprestatus() && enable.getprestatus()){//sysj\lid_loader_plant.sysj line: 22, column: 10
              S200=3;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            else {
              armAtSource.setPresent();//sysj\lid_loader_plant.sysj line: 23, column: 5
              currsigs.addElement(armAtSource);
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
          case 3 : 
            if(!enable.getprestatus()){//sysj\lid_loader_plant.sysj line: 25, column: 10
              S200=0;
              armAtDest.setPresent();//sysj\lid_loader_plant.sysj line: 19, column: 5
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

  public void thread1532(int [] tdone, int [] ends){
        S521=1;
    if(empty.getprestatus()){//sysj\lid_loader_plant.sysj line: 110, column: 24
      emptyE.setPresent();//sysj\lid_loader_plant.sysj line: 110, column: 31
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

  public void thread1531(int [] tdone, int [] ends){
        S513=1;
    if(armAtDest.getprestatus()){//sysj\lid_loader_plant.sysj line: 108, column: 24
      armAtDestE.setPresent();//sysj\lid_loader_plant.sysj line: 108, column: 35
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

  public void thread1530(int [] tdone, int [] ends){
        S505=1;
    if(armAtSource.getprestatus()){//sysj\lid_loader_plant.sysj line: 106, column: 24
      armAtSourceE.setPresent();//sysj\lid_loader_plant.sysj line: 106, column: 37
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

  public void thread1529(int [] tdone, int [] ends){
        S497=1;
    if(WPgripped.getprestatus()){//sysj\lid_loader_plant.sysj line: 104, column: 24
      WPgrippedE.setPresent();//sysj\lid_loader_plant.sysj line: 104, column: 35
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

  public void thread1528(int [] tdone, int [] ends){
        S489=1;
    if(pusherExtended.getprestatus()){//sysj\lid_loader_plant.sysj line: 102, column: 24
      pusherExtendedE.setPresent();//sysj\lid_loader_plant.sysj line: 102, column: 40
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

  public void thread1527(int [] tdone, int [] ends){
        S481=1;
    if(pusherRetracted.getprestatus()){//sysj\lid_loader_plant.sysj line: 100, column: 24
      pusherRetractedE.setPresent();//sysj\lid_loader_plant.sysj line: 100, column: 41
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

  public void thread1526(int [] tdone, int [] ends){
        S523=1;
    thread1527(tdone,ends);
    thread1528(tdone,ends);
    thread1529(tdone,ends);
    thread1530(tdone,ends);
    thread1531(tdone,ends);
    thread1532(tdone,ends);
    int biggest1533 = 0;
    if(ends[8]>=biggest1533){
      biggest1533=ends[8];
    }
    if(ends[9]>=biggest1533){
      biggest1533=ends[9];
    }
    if(ends[10]>=biggest1533){
      biggest1533=ends[10];
    }
    if(ends[11]>=biggest1533){
      biggest1533=ends[11];
    }
    if(ends[12]>=biggest1533){
      biggest1533=ends[12];
    }
    if(ends[13]>=biggest1533){
      biggest1533=ends[13];
    }
    if(biggest1533 == 1){
      active[7]=1;
      ends[7]=1;
      tdone[7]=1;
    }
  }

  public void thread1525(int [] tdone, int [] ends){
        S473=1;
    capcount_thread_6 = 5;//sysj\lid_loader_plant.sysj line: 82, column: 3
    if(capDec_1.getprestatus()){//sysj\lid_loader_plant.sysj line: 84, column: 12
      if(capcount_thread_6 > 0) {//sysj\lid_loader_plant.sysj line: 85, column: 5
        capcount_thread_6 = capcount_thread_6 - 1;//sysj\lid_loader_plant.sysj line: 86, column: 6
      }
      if(refill.getprestatus()){//sysj\lid_loader_plant.sysj line: 88, column: 12
        capcount_thread_6 = 5;//sysj\lid_loader_plant.sysj line: 89, column: 5
        if(capcount_thread_6 == 0){//sysj\lid_loader_plant.sysj line: 92, column: 8
          empty.setPresent();//sysj\lid_loader_plant.sysj line: 93, column: 6
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
        if(capcount_thread_6 == 0){//sysj\lid_loader_plant.sysj line: 92, column: 8
          empty.setPresent();//sysj\lid_loader_plant.sysj line: 93, column: 6
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
      if(refill.getprestatus()){//sysj\lid_loader_plant.sysj line: 88, column: 12
        capcount_thread_6 = 5;//sysj\lid_loader_plant.sysj line: 89, column: 5
        if(capcount_thread_6 == 0){//sysj\lid_loader_plant.sysj line: 92, column: 8
          empty.setPresent();//sysj\lid_loader_plant.sysj line: 93, column: 6
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
        if(capcount_thread_6 == 0){//sysj\lid_loader_plant.sysj line: 92, column: 8
          empty.setPresent();//sysj\lid_loader_plant.sysj line: 93, column: 6
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

  public void thread1524(int [] tdone, int [] ends){
        S411=1;
    S365=0;
    S347=0;
    active[5]=1;
    ends[5]=1;
    tdone[5]=1;
  }

  public void thread1523(int [] tdone, int [] ends){
        S343=1;
    S313=0;
    if(vacOn.getprestatus() && armAtSource.getprestatus()){//sysj\lid_loader_plant.sysj line: 44, column: 12
      if((Integer)(capPos_1.getpreval() == null ? 0 : ((Integer)capPos_1.getpreval()).intValue()) == 1){//sysj\lid_loader_plant.sysj line: 45, column: 8
        capPos_1.setPresent();//sysj\lid_loader_plant.sysj line: 46, column: 6
        currsigs.addElement(capPos_1);
        capPos_1.setValue(0);//sysj\lid_loader_plant.sysj line: 46, column: 6
        S308=0;
        WPgripped.setPresent();//sysj\lid_loader_plant.sysj line: 48, column: 7
        currsigs.addElement(WPgripped);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        S313=1;
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
    }
    else {
      S313=1;
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread1522(int [] tdone, int [] ends){
        S299=1;
    S253=0;
    pusherRetracted.setPresent();//sysj\lid_loader_plant.sysj line: 32, column: 5
    currsigs.addElement(pusherRetracted);
    active[3]=1;
    ends[3]=1;
    tdone[3]=1;
  }

  public void thread1521(int [] tdone, int [] ends){
        S246=1;
    S200=0;
    armAtDest.setPresent();//sysj\lid_loader_plant.sysj line: 19, column: 5
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
      switch(S1519){
        case 0 : 
          S1519=0;
          break RUN;
        
        case 1 : 
          S1519=2;
          S1519=2;
          new Thread(new GUI()).start();//sysj\lid_loader_plant.sysj line: 11, column: 2
          capDec_1.setClear();//sysj\lid_loader_plant.sysj line: 13, column: 2
          capPos_1.setClear();//sysj\lid_loader_plant.sysj line: 14, column: 2
          capPos_1.setPresent();//sysj\lid_loader_plant.sysj line: 15, column: 2
          currsigs.addElement(capPos_1);
          capPos_1.setValue(0);//sysj\lid_loader_plant.sysj line: 15, column: 2
          thread1521(tdone,ends);
          thread1522(tdone,ends);
          thread1523(tdone,ends);
          thread1524(tdone,ends);
          thread1525(tdone,ends);
          thread1526(tdone,ends);
          int biggest1534 = 0;
          if(ends[2]>=biggest1534){
            biggest1534=ends[2];
          }
          if(ends[3]>=biggest1534){
            biggest1534=ends[3];
          }
          if(ends[4]>=biggest1534){
            biggest1534=ends[4];
          }
          if(ends[5]>=biggest1534){
            biggest1534=ends[5];
          }
          if(ends[6]>=biggest1534){
            biggest1534=ends[6];
          }
          if(ends[7]>=biggest1534){
            biggest1534=ends[7];
          }
          if(biggest1534 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          capDec_1.setClear();//sysj\lid_loader_plant.sysj line: 13, column: 2
          capPos_1.setClear();//sysj\lid_loader_plant.sysj line: 14, column: 2
          thread1535(tdone,ends);
          thread1536(tdone,ends);
          thread1537(tdone,ends);
          thread1538(tdone,ends);
          thread1539(tdone,ends);
          thread1540(tdone,ends);
          int biggest1548 = 0;
          if(ends[2]>=biggest1548){
            biggest1548=ends[2];
          }
          if(ends[3]>=biggest1548){
            biggest1548=ends[3];
          }
          if(ends[4]>=biggest1548){
            biggest1548=ends[4];
          }
          if(ends[5]>=biggest1548){
            biggest1548=ends[5];
          }
          if(ends[6]>=biggest1548){
            biggest1548=ends[6];
          }
          if(ends[7]>=biggest1548){
            biggest1548=ends[7];
          }
          if(biggest1548 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest1548 == 0){
            S1519=0;
            active[1]=0;
            ends[1]=0;
            S1519=0;
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
