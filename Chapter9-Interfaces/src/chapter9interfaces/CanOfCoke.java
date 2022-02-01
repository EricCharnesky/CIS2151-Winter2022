package chapter9interfaces;

public class CanOfCoke implements Drinkable {

    private int currentVolumeInMilliliters;
    private int maxMillilitiers;

    public CanOfCoke() {
        maxMillilitiers = 355;
        currentVolumeInMilliliters = 355;
    }

    @Override
    public boolean drink(int millilitersToDrink) {
        if (millilitersToDrink <= currentVolumeInMilliliters) {
            currentVolumeInMilliliters -= millilitersToDrink;
            return true;
        }
        return false;

    }

    @Override
    public int getCurrentVolumeInMilliliters() {
        return currentVolumeInMilliliters;
    }

    @Override
    public String toString() {
        return "Can of coke";

    }
}
