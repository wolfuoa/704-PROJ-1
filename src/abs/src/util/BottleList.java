package util;

import java.util.*;


public class BottleList {

    private List<Bottle> bottleList;

    // Constructor
    public BottleList() {
        this.bottleList = new ArrayList<Bottle>();
    }

    //Add bottles to the lists
    public void addBottle(int iteration, String info) {
        this.bottleList.add(new Bottle(iteration, info));
    }


    public Bottle getBottle(int iteration)
    {
        return this.bottleList.get(iteration);
    }

    public void clean()
    {
        this.bottleList.clear();
    }


    public static void main(String[] args) {

        try {
            System.out.println("start Bottle");
            Thread.sleep(1000); 

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

