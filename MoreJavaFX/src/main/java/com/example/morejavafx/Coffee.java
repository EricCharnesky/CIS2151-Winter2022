package com.example.morejavafx;

import java.io.Serializable;

public class Coffee implements Serializable {
    private int mugSizeInMilliliters;
    private int currentCoffeeInMilliliters;

    public Coffee(int mugSizeInMilliliters, int currentCoffeeInMilliliters) {
        this.mugSizeInMilliliters = mugSizeInMilliliters;
        this.currentCoffeeInMilliliters = currentCoffeeInMilliliters;
    }

    public int getMugSizeInMilliliters() {
        return mugSizeInMilliliters;
    }

    public void setMugSizeInMilliliters(int mugSizeInMilliliters) {
        this.mugSizeInMilliliters = mugSizeInMilliliters;
    }

    public int getCurrentCoffeeInMilliliters() {
        return currentCoffeeInMilliliters;
    }

    public void setCurrentCoffeeInMilliliters(int currentCoffeeInMilliliters) {
        this.currentCoffeeInMilliliters = currentCoffeeInMilliliters;
    }
}
