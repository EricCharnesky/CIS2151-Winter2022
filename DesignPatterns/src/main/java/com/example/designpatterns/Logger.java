package com.example.designpatterns;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static Logger instance;

    private PrintWriter output;

    private Logger(){

        try {
            output = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter("log.txt", true)));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void log(String message){
        // https://www.javatpoint.com/java-get-current-date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        output.println(dtf.format(now) + " - " + message);
        output.flush();
    }

    public static Logger getInstance(){
        if ( instance == null ){
            instance = new Logger();
        }
        return instance;

    }

}
