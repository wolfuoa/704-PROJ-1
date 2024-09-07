package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import javafx.scene.shape.Box;

public class Bottle {

    private int id;
    private String info;

    // Constructor
    public Bottle(int id, String info) {
        this.id = id;
        this.info = info;
    }

    public void addInfo(String info) {
        // Get and format the current date and time
        //LocalDateTime now = LocalDateTime.now();
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //String formattedNow = now.format(formatter);
    	String formattedNow = "testDate";
    		
        this.info = this.info + "\n" + "[" + formattedNow + "] " + info;
    }

    public void testPrint() {
        System.out.println("Log: " + this.info);
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

