package com.example.morejavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private Coffee coffee;

    private ColorAdjust colorAdjust;

    @FXML
    private Slider brightnessSlider;

    @FXML
    private ImageView cardImageView;

    @FXML
    private Label coffeeLabel;

    @FXML
    private Slider contrastSlider;

    @FXML
    private Button downButton;

    @FXML
    private Slider hueSlider;

    @FXML
    private Button leftButton;

    @FXML
    private Button rightButton;

    @FXML
    private Slider saturationSlider;

    @FXML
    private Button upButton;

    // essentially like a constructor, but it runs AFTER all the javafx stuff has been created
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        coffee = new Coffee(250, 50);
        enableAllButtons();
        colorAdjust = new ColorAdjust();

        Blend blend = new Blend();
        blend.setMode(BlendMode.ADD);
        blend.setTopInput(colorAdjust);
        cardImageView.setEffect(blend);

        // sets it up to run this method when the value changes
        hueSlider.valueProperty().addListener(
                (observable, oldValue, newValue) -> {
                    applyColorAdjust();
                }
        );
        saturationSlider.valueProperty().addListener(
                (observable, oldValue, newValue) -> {
                    applyColorAdjust();
                }
        );
        brightnessSlider.valueProperty().addListener(
                (observable, oldValue, newValue) -> {
                    applyColorAdjust();
                }
        );
        contrastSlider.valueProperty().addListener(
                (observable, oldValue, newValue) -> {
                    applyColorAdjust();
                }
        );

    }

    private void applyColorAdjust(){
        colorAdjust.setHue(hueSlider.getValue());
        colorAdjust.setContrast(contrastSlider.getValue());
        colorAdjust.setBrightness(brightnessSlider.getValue());
        colorAdjust.setSaturation(saturationSlider.getValue());
    }

    @FXML
    void changeCardButtonClicked(ActionEvent event) {
        String url = cardImageView.getImage().getUrl();
        // TODO - Fix this
        if ( url.endsWith("AofSpades.png") ) {
            cardImageView.setImage(new Image("AofHearts.jpg"));
        } else{
            cardImageView.setImage(new Image("AofSpades.png"));
        }

    }

    @FXML
    void downButtonClicked(ActionEvent event) {
        coffee.setCurrentCoffeeInMilliliters(coffee.getCurrentCoffeeInMilliliters() - 1);
        enableAllButtons();

        downButton.setDisable(true);
    }

    @FXML
    void leftButtonClicked(ActionEvent event) {
        enableAllButtons();
        leftButton.setDisable(true);
    }

    @FXML
    void rightButtonClicked(ActionEvent event) {
        enableAllButtons();
        rightButton.setDisable(true);
    }

    @FXML
    void upButtonClicked(ActionEvent event) {
        coffee.setCurrentCoffeeInMilliliters(coffee.getCurrentCoffeeInMilliliters() + 1);

        enableAllButtons();

        upButton.setDisable(true);
    }


    @FXML
    void loadButtonClicked(ActionEvent event) {
        try {
            ObjectInputStream binaryInputFile = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream("save.bin")));
            coffee = (Coffee) binaryInputFile.readObject();
            enableAllButtons();
            binaryInputFile.close();

        } catch (IOException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    void saveButtonClicked(ActionEvent event) {
        try {
            // object output stream for writing serializable classes
            ObjectOutputStream binaryOutputFile = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("save.bin")));
            binaryOutputFile.writeObject(coffee);
            binaryOutputFile.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private void enableAllButtons() {
        upButton.setDisable(false);
        downButton.setDisable(false);
        leftButton.setDisable(false);
        rightButton.setDisable(false);
        coffeeLabel.setText("Coffee: " + coffee.getCurrentCoffeeInMilliliters());
    }
}