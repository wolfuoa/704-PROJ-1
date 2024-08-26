import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class ConveyorController extends ClockDomain{
  public ConveyorController(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal conveyorStep = new Signal("conveyorStep", Signal.INPUT);
  public Signal bottleAtPos1 = new Signal("bottleAtPos1", Signal.INPUT);
  public Signal conveyorStepComplete = new Signal("conveyorStepComplete", Signal.OUTPUT);
  public Signal motConveyorOn = new Signal("motConveyorOn", Signal.OUTPUT);
  private int S5 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S5){
        case 0 : 
          S5=0;
          break RUN;
        
        case 1 : 
          S5=2;
          S5=2;
          motConveyorOn.setPresent();//sysj\conveyor_controller.sysj line: 9, column: 3
          currsigs.addElement(motConveyorOn);
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          if(bottleAtPos1.getprestatus()){//sysj\conveyor_controller.sysj line: 7, column: 8
            System.out.println("Test1");//sysj\conveyor_controller.sysj line: 11, column: 2
            S5=0;
            active[1]=0;
            ends[1]=0;
            S5=0;
            break RUN;
          }
          else {
            motConveyorOn.setPresent();//sysj\conveyor_controller.sysj line: 9, column: 3
            currsigs.addElement(motConveyorOn);
            active[1]=1;
            ends[1]=1;
            break RUN;
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
          conveyorStep.gethook();
          bottleAtPos1.gethook();
          df = true;
        }
        runClockDomain();
      }
      conveyorStep.setpreclear();
      bottleAtPos1.setpreclear();
      conveyorStepComplete.setpreclear();
      motConveyorOn.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = conveyorStep.getStatus() ? conveyorStep.setprepresent() : conveyorStep.setpreclear();
      conveyorStep.setpreval(conveyorStep.getValue());
      conveyorStep.setClear();
      dummyint = bottleAtPos1.getStatus() ? bottleAtPos1.setprepresent() : bottleAtPos1.setpreclear();
      bottleAtPos1.setpreval(bottleAtPos1.getValue());
      bottleAtPos1.setClear();
      conveyorStepComplete.sethook();
      conveyorStepComplete.setClear();
      motConveyorOn.sethook();
      motConveyorOn.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        conveyorStep.gethook();
        bottleAtPos1.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
