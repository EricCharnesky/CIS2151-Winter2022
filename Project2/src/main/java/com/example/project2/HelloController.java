package com.example.project2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import project1.*;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    Player player;

    @FXML
    private Label descriptionLabel;
    @FXML
    private Button leftButton;
    @FXML
    private Button upButton;
    @FXML
    private Button downButton;
    @FXML
    private Button rightButton;
    @FXML
    private Label toolsLabel;
    @FXML
    private Button pickupToolButton;
    @FXML
    private Button buildButton;
    @FXML
    private Button digButton;
    @FXML
    private Button chopButton;
    @FXML
    private Button loadButton;
    @FXML
    private Button saveButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        player = new Player();
        updateDisplay();
    }


    @FXML
    public void upButtonClick(ActionEvent actionEvent) {
        player.goUp();
        updateDisplay();
    }

    @FXML
    public void rightButtonClick(ActionEvent actionEvent) {
        player.goRight();
        updateDisplay();
    }

    @FXML
    public void downButtonClick(ActionEvent actionEvent) {
        player.goDown();
        updateDisplay();
    }

    @FXML
    public void leftButtonClick(ActionEvent actionEvent) {
        player.goLeft();
        updateDisplay();
    }

    public void updateDisplay() {
        descriptionLabel.setText(player.getCurrentSpace().getDescription());
        String toolList = "Tools:\n";
        for ( Tool tool : player.getTools() ){
            toolList += tool.getName() + "\n";
        }
        toolsLabel.setText(toolList);
        upButton.setDisable(!player.canGoUp());
        rightButton.setDisable(!player.canGoRight());
        downButton.setDisable(!player.canGoDown());
        leftButton.setDisable(!player.canGoLeft());

        pickupToolButton.setDisable( player.getCurrentSpace().getTool() == null );

        digButton.setDisable(!player.canDigInCurrentSpace());
        chopButton.setDisable(!player.canChopInCurrentSpace());
        buildButton.setDisable(!player.canBuildInCurrentSpace());
    }

    @FXML
    public void chopButtonClicked(ActionEvent actionEvent) {
        player.chopInCurrentSpace();
        updateDisplay();
    }

    @FXML
    public void buildButtonClicked(ActionEvent actionEvent) {
        player.buildInCurrentSpace();
        updateDisplay();
    }

    @FXML
    public void digButtonClicked(ActionEvent actionEvent) {
        player.digInCurrentSpace();
        updateDisplay();
    }

    @FXML
    public void pickupToolButtonClicked(ActionEvent actionEvent) {
        player.addTool( player.getCurrentSpace().takeTool() );
        updateDisplay();
    }

    @FXML
    public void saveButtonClicked(ActionEvent actionEvent) {
        try {
            // object output stream for writing serializable classes
            ObjectOutputStream binaryOutputFile = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("save.bin")));
            binaryOutputFile.writeObject(player);
            binaryOutputFile.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    public void loadButtonClicked(ActionEvent actionEvent) {
        Player oldPlayer = player;
        try {
            ObjectInputStream binaryInputFile = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream("save.bin")));
            player = (Player) binaryInputFile.readObject();
            updateDisplay();
            binaryInputFile.close();

        } catch (IOException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }
}