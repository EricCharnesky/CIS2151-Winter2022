
package lab3;

public class Animal {
    
    private String name;
    private String color;
    private double weightInKilograms;
    private String noise;
    private double wasteFactor;

    public Animal(String name, String color, double weightInKilograms, String noise, double wasteFactor) {
        this.name = name;
        this.color = color;
        this.weightInKilograms = weightInKilograms;
        this.noise = noise;
        this.wasteFactor = wasteFactor;
    }
    
    public boolean setFoodWasteFactor(double wasteFactor){
        if ( wasteFactor <= 0 || wasteFactor >= 1 ){
            wasteFactor = .99;
            return false;
        }
        this.wasteFactor = wasteFactor;
        return true;
    }
    
    public double eat(double foodInKilograms){
        double gain = foodInKilograms * ( 1 - wasteFactor );
        weightInKilograms += gain;
        return gain;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public double getWeightInKilograms() {
        return weightInKilograms;
    }

    public String getNoise() {
        return noise;
    }

    public double getWasteFactor() {
        return wasteFactor;
    }
}
