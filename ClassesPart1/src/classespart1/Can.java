
package classespart1;

public class Can {
    private String color;
    private int maxVolumeInMililiters;
    private int currentVolumeInMililiters;
    private String name;

    // constructors job is to give instance attributes values

    public Can(String color, int maxVolumeInMililiters, 
            int currentVolumeInMililiters, String name) {
        this.color = color;
        this.maxVolumeInMililiters = maxVolumeInMililiters;
        this.currentVolumeInMililiters = currentVolumeInMililiters;
        this.name = name;
    }
    
    public boolean drink(int mililitersToDrink){
        // checking if it is a valid argument
        if ( mililitersToDrink < 0 || mililitersToDrink > currentVolumeInMililiters){
            return false;
        }
        currentVolumeInMililiters -= mililitersToDrink;
        return true;
    }
    
    
    public String getColor() {
        return color;
    }

    public int getMaxVolumeInMililiters() {
        return maxVolumeInMililiters;
    }

    public int getCurrentVolumeInMililiters() {
        return currentVolumeInMililiters;
    }

    public String getName() {
        return name;
    }
    
    
}
