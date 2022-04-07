package com.example.lab11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private static final int ROCK = 0;
    private static final int PAPER = 1;
    private static final int SCISSORS = 2;
    private Label label;

    @Override
    public void start(Stage stage) throws IOException {

        AnchorPane pane = new AnchorPane();

        label = new Label();
        label.setText("Hello World!");

        VBox vbox = new VBox();
        vbox.getChildren().add(label);
        pane.getChildren().add(vbox);


        Button rockButton = new Button();
        rockButton.setText("Rock");
        rockButton.setOnAction(event -> {
            label.setText("You play rock: ");
            playRockPaperScissors(ROCK);
        });
        vbox.getChildren().add(rockButton);

        Button paperButton = new Button();
        paperButton.setText("Paper");
        paperButton.setOnAction(event -> {
            label.setText("You play paper: ");
            playRockPaperScissors(PAPER);
        });
        vbox.getChildren().add(paperButton);

        Button scissorsButton = new Button();
        scissorsButton.setText("Scissors");
        scissorsButton.setOnAction(event -> {
            label.setText("You play scissors: ");
            playRockPaperScissors(SCISSORS);
        });
        vbox.getChildren().add(scissorsButton);

        Scene scene = new Scene(pane, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    private void playRockPaperScissors(int usersChoice){
        int computerChoice = (int)(Math.random() * 3);

        if ( computerChoice == usersChoice){
            label.setText(label.getText() + "\nTie!");
        } else if ( ( usersChoice == ROCK && computerChoice == PAPER ) ||
                ( usersChoice == PAPER && computerChoice == SCISSORS ) ||
                ( usersChoice == SCISSORS && computerChoice == ROCK ) ){
            label.setText(label.getText() + "\nyou lose!");
        } else {
            label.setText(label.getText() + "\nyou win!");
        }
    }

    public static void main(String[] args) {
        launch();
    }
}