package com.example.threadexamples;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class HelloController {

    @FXML
    private Label leftLabel;
    @FXML
    private Button leftButton;
    @FXML
    private Button rightButton;
    @FXML
    private Label rightLabel;

    @FXML
    public void buttonClick(ActionEvent actionEvent) {
        if (actionEvent.getSource() == leftButton) {

            ArrayList<ThreadExample> threads = new ArrayList<>();

            for ( int startValue = 1; startValue<1_000_000; startValue += 10_000){
                ThreadExample primeCounterThread = new ThreadExample(startValue, startValue+9_999);
                primeCounterThread.start();
                threads.add(primeCounterThread);
            }


            int totalPrimes = 0;

            try{
                for ( ThreadExample thread : threads){
                    thread.join();
                    totalPrimes += thread.getPrimeCount();
                }
            } catch ( Exception ex){
                System.out.println(ex);
            }
            leftLabel.setText("Primes: " + totalPrimes);
            rightLabel.setText("Primes caluclated in static prime counter: "+ PrimeCounter.PrimeCount);


        } else if (actionEvent.getSource() == rightButton) {
            rightLabel.setText("Right button clicked!");
        }
    }
}