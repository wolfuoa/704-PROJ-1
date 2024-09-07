package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Bottle {

    private int id;
    private String info;

    // Constructor
    public Bottle(int id, String info) {
        this.id = id;
        
        this.info = info;
        this.info = this.info + "\n" +  "Bottle Identification number: " + this.id;
    }

    public void addInfo(String info) {
        // Get and format the current date and time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String formattedNow = now.format(formatter);
    		
        this.info = this.info + "\n" + "[" + formattedNow + "] " + info;
    }

    public void printLogToConsole() {
        System.out.println(this.info);
    }

    public String getLog() {
        return this.info;
    }

    public void writeLogToFile(String log)
    {
        String workingDirectory = System.getProperty("user.dir");
        Path filePath = Paths.get(workingDirectory, "logfile.txt");
        
        try {
            // Write the log string to the file
            Files.write(filePath, log.getBytes());
            
            System.out.println("Logfile written to working directory: " + filePath.toAbsolutePath());
        } 
        catch (IOException e) 
        {
            System.err.println("An error occurred while writing the file: " + e.getMessage());
        }
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

