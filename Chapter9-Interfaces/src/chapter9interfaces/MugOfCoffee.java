
package chapter9interfaces;

public class MugOfCoffee implements Drinkable {
    
    
    private int currentVolumeInMilliliters;
    private int maxMillilitiers;
    
    public MugOfCoffee(){
        maxMillilitiers = 500;
        currentVolumeInMilliliters = 500;
    }
    
    @Override
    public boolean drink(int millilitersToDrink) {
        if ( millilitersToDrink <= currentVolumeInMilliliters ){
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
    public String toString(){
        return "Mug of coffee";
    }
    
}
