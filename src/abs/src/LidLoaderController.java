import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class LidLoaderController extends ClockDomain{
  public LidLoaderController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal pusherRetracted = new Signal("pusherRetracted", Signal.INPUT);
  public Signal pusherExtended = new Signal("pusherExtended", Signal.INPUT);
  public Signal WPgripped = new Signal("WPgripped", Signal.INPUT);
  public Signal armAtSource = new Signal("armAtSource", Signal.INPUT);
  public Signal armAtDest = new Signal("armAtDest", Signal.INPUT);
  public Signal empty = new Signal("empty", Signal.INPUT);
  public Signal request = new Signal("request", Signal.INPUT);
  public Signal mode = new Signal("mode", Signal.INPUT);
  public Signal pusherExtendM = new Signal("pusherExtendM", Signal.INPUT);
  public Signal vacOnM = new Signal("vacOnM", Signal.INPUT);
  public Signal armSourceM = new Signal("armSourceM", Signal.INPUT);
  public Signal armDestM = new Signal("armDestM", Signal.INPUT);
  public Signal pusherExtend = new Signal("pusherExtend", Signal.OUTPUT);
  public Signal vacOn = new Signal("vacOn", Signal.OUTPUT);
  public Signal armSource = new Signal("armSource", Signal.OUTPUT);
  public Signal armDest = new Signal("armDest", Signal.OUTPUT);
  private int S200 = 1;
  private int S72 = 1;
  private int S22 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S200){
        case 0 : 
          S200=0;
          break RUN;
        
        case 1 : 
          S200=2;
          S200=2;
          S72=0;
          if(mode.getprestatus()){//sysj\lid_loader_controller.sysj line: 12, column: 12
            if((mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\lid_loader_controller.sysj line: 15, column: 8
              if(!empty.getprestatus()){//sysj\lid_loader_controller.sysj line: 17, column: 14
                if(request.getprestatus()){//sysj\lid_loader_controller.sysj line: 19, column: 15
                  S22=0;
                  armDest.setPresent();//sysj\lid_loader_controller.sysj line: 23, column: 9
                  currsigs.addElement(armDest);
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
                else {
                  S72=1;
                  active[1]=1;
                  ends[1]=1;
                  break RUN;
                }
              }
              else {
                S72=1;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            }
            else {
              if(pusherExtendM.getprestatus()){//sysj\lid_loader_controller.sysj line: 63, column: 14
                pusherExtend.setPresent();//sysj\lid_loader_controller.sysj line: 65, column: 7
                currsigs.addElement(pusherExtend);
                if(vacOnM.getprestatus()){//sysj\lid_loader_controller.sysj line: 68, column: 14
                  vacOn.setPresent();//sysj\lid_loader_controller.sysj line: 70, column: 7
                  currsigs.addElement(vacOn);
                  if(armSourceM.getprestatus()){//sysj\lid_loader_controller.sysj line: 73, column: 14
                    armSource.setPresent();//sysj\lid_loader_controller.sysj line: 75, column: 7
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj\lid_loader_controller.sysj line: 78, column: 14
                      armDest.setPresent();//sysj\lid_loader_controller.sysj line: 80, column: 7
                      currsigs.addElement(armDest);
                      S72=1;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      S72=1;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  }
                  else {
                    if(armDestM.getprestatus()){//sysj\lid_loader_controller.sysj line: 78, column: 14
                      armDest.setPresent();//sysj\lid_loader_controller.sysj line: 80, column: 7
                      currsigs.addElement(armDest);
                      S72=1;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      S72=1;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  }
                }
                else {
                  if(armSourceM.getprestatus()){//sysj\lid_loader_controller.sysj line: 73, column: 14
                    armSource.setPresent();//sysj\lid_loader_controller.sysj line: 75, column: 7
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj\lid_loader_controller.sysj line: 78, column: 14
                      armDest.setPresent();//sysj\lid_loader_controller.sysj line: 80, column: 7
                      currsigs.addElement(armDest);
                      S72=1;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      S72=1;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  }
                  else {
                    if(armDestM.getprestatus()){//sysj\lid_loader_controller.sysj line: 78, column: 14
                      armDest.setPresent();//sysj\lid_loader_controller.sysj line: 80, column: 7
                      currsigs.addElement(armDest);
                      S72=1;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      S72=1;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  }
                }
              }
              else {
                if(vacOnM.getprestatus()){//sysj\lid_loader_controller.sysj line: 68, column: 14
                  vacOn.setPresent();//sysj\lid_loader_controller.sysj line: 70, column: 7
                  currsigs.addElement(vacOn);
                  if(armSourceM.getprestatus()){//sysj\lid_loader_controller.sysj line: 73, column: 14
                    armSource.setPresent();//sysj\lid_loader_controller.sysj line: 75, column: 7
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj\lid_loader_controller.sysj line: 78, column: 14
                      armDest.setPresent();//sysj\lid_loader_controller.sysj line: 80, column: 7
                      currsigs.addElement(armDest);
                      S72=1;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      S72=1;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  }
                  else {
                    if(armDestM.getprestatus()){//sysj\lid_loader_controller.sysj line: 78, column: 14
                      armDest.setPresent();//sysj\lid_loader_controller.sysj line: 80, column: 7
                      currsigs.addElement(armDest);
                      S72=1;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      S72=1;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  }
                }
                else {
                  if(armSourceM.getprestatus()){//sysj\lid_loader_controller.sysj line: 73, column: 14
                    armSource.setPresent();//sysj\lid_loader_controller.sysj line: 75, column: 7
                    currsigs.addElement(armSource);
                    if(armDestM.getprestatus()){//sysj\lid_loader_controller.sysj line: 78, column: 14
                      armDest.setPresent();//sysj\lid_loader_controller.sysj line: 80, column: 7
                      currsigs.addElement(armDest);
                      S72=1;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      S72=1;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  }
                  else {
                    if(armDestM.getprestatus()){//sysj\lid_loader_controller.sysj line: 78, column: 14
                      armDest.setPresent();//sysj\lid_loader_controller.sysj line: 80, column: 7
                      currsigs.addElement(armDest);
                      S72=1;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      S72=1;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  }
                }
              }
            }
          }
          else {
            S72=1;
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          switch(S72){
            case 0 : 
              switch(S22){
                case 0 : 
                  if(armAtDest.getprestatus()){//sysj\lid_loader_controller.sysj line: 21, column: 14
                    S22=1;
                    pusherExtend.setPresent();//sysj\lid_loader_controller.sysj line: 28, column: 9
                    currsigs.addElement(pusherExtend);
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    armDest.setPresent();//sysj\lid_loader_controller.sysj line: 23, column: 9
                    currsigs.addElement(armDest);
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                
                case 1 : 
                  if(pusherExtended.getprestatus()){//sysj\lid_loader_controller.sysj line: 26, column: 14
                    S22=2;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    pusherExtend.setPresent();//sysj\lid_loader_controller.sysj line: 28, column: 9
                    currsigs.addElement(pusherExtend);
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                
                case 2 : 
                  if(pusherRetracted.getprestatus()){//sysj\lid_loader_controller.sysj line: 31, column: 14
                    S22=3;
                    armSource.setPresent();//sysj\lid_loader_controller.sysj line: 38, column: 9
                    currsigs.addElement(armSource);
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                
                case 3 : 
                  if(armAtSource.getprestatus()){//sysj\lid_loader_controller.sysj line: 36, column: 14
                    S22=4;
                    vacOn.setPresent();//sysj\lid_loader_controller.sysj line: 43, column: 9
                    currsigs.addElement(vacOn);
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    armSource.setPresent();//sysj\lid_loader_controller.sysj line: 38, column: 9
                    currsigs.addElement(armSource);
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                
                case 4 : 
                  if(WPgripped.getprestatus()){//sysj\lid_loader_controller.sysj line: 41, column: 14
                    S22=5;
                    armDest.setPresent();//sysj\lid_loader_controller.sysj line: 50, column: 10
                    currsigs.addElement(armDest);
                    vacOn.setPresent();//sysj\lid_loader_controller.sysj line: 51, column: 10
                    currsigs.addElement(vacOn);
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    vacOn.setPresent();//sysj\lid_loader_controller.sysj line: 43, column: 9
                    currsigs.addElement(vacOn);
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                
                case 5 : 
                  if(armAtDest.getprestatus()){//sysj\lid_loader_controller.sysj line: 46, column: 14
                    S72=1;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                  else {
                    armDest.setPresent();//sysj\lid_loader_controller.sysj line: 50, column: 10
                    currsigs.addElement(armDest);
                    vacOn.setPresent();//sysj\lid_loader_controller.sysj line: 51, column: 10
                    currsigs.addElement(vacOn);
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                
              }
              break;
            
            case 1 : 
              S72=1;
              S72=0;
              if(mode.getprestatus()){//sysj\lid_loader_controller.sysj line: 12, column: 12
                if((mode.getpreval() == null ? null : ((Integer)mode.getpreval())) == 0){//sysj\lid_loader_controller.sysj line: 15, column: 8
                  if(!empty.getprestatus()){//sysj\lid_loader_controller.sysj line: 17, column: 14
                    if(request.getprestatus()){//sysj\lid_loader_controller.sysj line: 19, column: 15
                      S22=0;
                      armDest.setPresent();//sysj\lid_loader_controller.sysj line: 23, column: 9
                      currsigs.addElement(armDest);
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                    else {
                      S72=1;
                      active[1]=1;
                      ends[1]=1;
                      break RUN;
                    }
                  }
                  else {
                    S72=1;
                    active[1]=1;
                    ends[1]=1;
                    break RUN;
                  }
                }
                else {
                  if(pusherExtendM.getprestatus()){//sysj\lid_loader_controller.sysj line: 63, column: 14
                    pusherExtend.setPresent();//sysj\lid_loader_controller.sysj line: 65, column: 7
                    currsigs.addElement(pusherExtend);
                    if(vacOnM.getprestatus()){//sysj\lid_loader_controller.sysj line: 68, column: 14
                      vacOn.setPresent();//sysj\lid_loader_controller.sysj line: 70, column: 7
                      currsigs.addElement(vacOn);
                      if(armSourceM.getprestatus()){//sysj\lid_loader_controller.sysj line: 73, column: 14
                        armSource.setPresent();//sysj\lid_loader_controller.sysj line: 75, column: 7
                        currsigs.addElement(armSource);
                        if(armDestM.getprestatus()){//sysj\lid_loader_controller.sysj line: 78, column: 14
                          armDest.setPresent();//sysj\lid_loader_controller.sysj line: 80, column: 7
                          currsigs.addElement(armDest);
                          S72=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          S72=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(armDestM.getprestatus()){//sysj\lid_loader_controller.sysj line: 78, column: 14
                          armDest.setPresent();//sysj\lid_loader_controller.sysj line: 80, column: 7
                          currsigs.addElement(armDest);
                          S72=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          S72=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(armSourceM.getprestatus()){//sysj\lid_loader_controller.sysj line: 73, column: 14
                        armSource.setPresent();//sysj\lid_loader_controller.sysj line: 75, column: 7
                        currsigs.addElement(armSource);
                        if(armDestM.getprestatus()){//sysj\lid_loader_controller.sysj line: 78, column: 14
                          armDest.setPresent();//sysj\lid_loader_controller.sysj line: 80, column: 7
                          currsigs.addElement(armDest);
                          S72=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          S72=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(armDestM.getprestatus()){//sysj\lid_loader_controller.sysj line: 78, column: 14
                          armDest.setPresent();//sysj\lid_loader_controller.sysj line: 80, column: 7
                          currsigs.addElement(armDest);
                          S72=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          S72=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                  }
                  else {
                    if(vacOnM.getprestatus()){//sysj\lid_loader_controller.sysj line: 68, column: 14
                      vacOn.setPresent();//sysj\lid_loader_controller.sysj line: 70, column: 7
                      currsigs.addElement(vacOn);
                      if(armSourceM.getprestatus()){//sysj\lid_loader_controller.sysj line: 73, column: 14
                        armSource.setPresent();//sysj\lid_loader_controller.sysj line: 75, column: 7
                        currsigs.addElement(armSource);
                        if(armDestM.getprestatus()){//sysj\lid_loader_controller.sysj line: 78, column: 14
                          armDest.setPresent();//sysj\lid_loader_controller.sysj line: 80, column: 7
                          currsigs.addElement(armDest);
                          S72=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          S72=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(armDestM.getprestatus()){//sysj\lid_loader_controller.sysj line: 78, column: 14
                          armDest.setPresent();//sysj\lid_loader_controller.sysj line: 80, column: 7
                          currsigs.addElement(armDest);
                          S72=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          S72=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                    else {
                      if(armSourceM.getprestatus()){//sysj\lid_loader_controller.sysj line: 73, column: 14
                        armSource.setPresent();//sysj\lid_loader_controller.sysj line: 75, column: 7
                        currsigs.addElement(armSource);
                        if(armDestM.getprestatus()){//sysj\lid_loader_controller.sysj line: 78, column: 14
                          armDest.setPresent();//sysj\lid_loader_controller.sysj line: 80, column: 7
                          currsigs.addElement(armDest);
                          S72=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          S72=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                      else {
                        if(armDestM.getprestatus()){//sysj\lid_loader_controller.sysj line: 78, column: 14
                          armDest.setPresent();//sysj\lid_loader_controller.sysj line: 80, column: 7
                          currsigs.addElement(armDest);
                          S72=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                        else {
                          S72=1;
                          active[1]=1;
                          ends[1]=1;
                          break RUN;
                        }
                      }
                    }
                  }
                }
              }
              else {
                S72=1;
                active[1]=1;
                ends[1]=1;
                break RUN;
              }
            
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1};
    char [] paused1 = {0, 0};
    char [] suspended1 = {0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
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
          pusherRetracted.gethook();
          pusherExtended.gethook();
          WPgripped.gethook();
          armAtSource.gethook();
          armAtDest.gethook();
          empty.gethook();
          request.gethook();
          mode.gethook();
          pusherExtendM.gethook();
          vacOnM.gethook();
          armSourceM.gethook();
          armDestM.gethook();
          df = true;
        }
        runClockDomain();
      }
      pusherRetracted.setpreclear();
      pusherExtended.setpreclear();
      WPgripped.setpreclear();
      armAtSource.setpreclear();
      armAtDest.setpreclear();
      empty.setpreclear();
      request.setpreclear();
      mode.setpreclear();
      pusherExtendM.setpreclear();
      vacOnM.setpreclear();
      armSourceM.setpreclear();
      armDestM.setpreclear();
      pusherExtend.setpreclear();
      vacOn.setpreclear();
      armSource.setpreclear();
      armDest.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = pusherRetracted.getStatus() ? pusherRetracted.setprepresent() : pusherRetracted.setpreclear();
      pusherRetracted.setpreval(pusherRetracted.getValue());
      pusherRetracted.setClear();
      dummyint = pusherExtended.getStatus() ? pusherExtended.setprepresent() : pusherExtended.setpreclear();
      pusherExtended.setpreval(pusherExtended.getValue());
      pusherExtended.setClear();
      dummyint = WPgripped.getStatus() ? WPgripped.setprepresent() : WPgripped.setpreclear();
      WPgripped.setpreval(WPgripped.getValue());
      WPgripped.setClear();
      dummyint = armAtSource.getStatus() ? armAtSource.setprepresent() : armAtSource.setpreclear();
      armAtSource.setpreval(armAtSource.getValue());
      armAtSource.setClear();
      dummyint = armAtDest.getStatus() ? armAtDest.setprepresent() : armAtDest.setpreclear();
      armAtDest.setpreval(armAtDest.getValue());
      armAtDest.setClear();
      dummyint = empty.getStatus() ? empty.setprepresent() : empty.setpreclear();
      empty.setpreval(empty.getValue());
      empty.setClear();
      dummyint = request.getStatus() ? request.setprepresent() : request.setpreclear();
      request.setpreval(request.getValue());
      request.setClear();
      dummyint = mode.getStatus() ? mode.setprepresent() : mode.setpreclear();
      mode.setpreval(mode.getValue());
      mode.setClear();
      dummyint = pusherExtendM.getStatus() ? pusherExtendM.setprepresent() : pusherExtendM.setpreclear();
      pusherExtendM.setpreval(pusherExtendM.getValue());
      pusherExtendM.setClear();
      dummyint = vacOnM.getStatus() ? vacOnM.setprepresent() : vacOnM.setpreclear();
      vacOnM.setpreval(vacOnM.getValue());
      vacOnM.setClear();
      dummyint = armSourceM.getStatus() ? armSourceM.setprepresent() : armSourceM.setpreclear();
      armSourceM.setpreval(armSourceM.getValue());
      armSourceM.setClear();
      dummyint = armDestM.getStatus() ? armDestM.setprepresent() : armDestM.setpreclear();
      armDestM.setpreval(armDestM.getValue());
      armDestM.setClear();
      pusherExtend.sethook();
      pusherExtend.setClear();
      vacOn.sethook();
      vacOn.setClear();
      armSource.sethook();
      armSource.setClear();
      armDest.sethook();
      armDest.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        pusherRetracted.gethook();
        pusherExtended.gethook();
        WPgripped.gethook();
        armAtSource.gethook();
        armAtDest.gethook();
        empty.gethook();
        request.gethook();
        mode.gethook();
        pusherExtendM.gethook();
        vacOnM.gethook();
        armSourceM.gethook();
        armDestM.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
