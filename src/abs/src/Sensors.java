import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class Sensors extends ClockDomain{
  public Sensors(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal conveyorPlantOn = new Signal("conveyorPlantOn", Signal.INPUT);
  public Signal bottleAtPos1 = new Signal("bottleAtPos1", Signal.OUTPUT);
  private int S953 = 1;
  
  private int[] ends = new int[2];
  private int[] tdone = new int[2];
  
  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S953){
        case 0 : 
          S953=0;
          break RUN;
        
        case 1 : 
          S953=2;
          S953=2;
          System.out.println("Test2");//sysj\sensors.sysj line: 8, column: 2
          active[1]=1;
          ends[1]=1;
          break RUN;
        
        case 2 : 
          if(conveyorPlantOn.getprestatus()){//sysj\sensors.sysj line: 13, column: 10
            System.out.println("Test3");//sysj\sensors.sysj line: 14, column: 4
            if(true){//sysj\sensors.sysj line: 15, column: 9
              bottleAtPos1.setPresent();//sysj\sensors.sysj line: 17, column: 5
              currsigs.addElement(bottleAtPos1);
              System.out.println("Test");//sysj\sensors.sysj line: 18, column: 5
              active[1]=1;
              ends[1]=1;
              break RUN;
            }
            else {
              active[1]=1;
              ends[1]=1;
              break RUN;
            }
          }
          else {
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
          conveyorPlantOn.gethook();
          df = true;
        }
        runClockDomain();
      }
      conveyorPlantOn.setpreclear();
      bottleAtPos1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = conveyorPlantOn.getStatus() ? conveyorPlantOn.setprepresent() : conveyorPlantOn.setpreclear();
      conveyorPlantOn.setpreval(conveyorPlantOn.getValue());
      conveyorPlantOn.setClear();
      bottleAtPos1.sethook();
      bottleAtPos1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        conveyorPlantOn.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
