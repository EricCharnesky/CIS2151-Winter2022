package lab5;

public class Car implements Drivable {

    private String make;
    private String model;
    private double kilometersPerLiter;
    private double litersInTank;
    private double tankCapacityInLiters;

    public Car(String make, String model, double kilometersPerLiter, double tankCapacityInLiters) {
        this.make = make;
        this.model = model;
        this.kilometersPerLiter = kilometersPerLiter;
        this.tankCapacityInLiters = tankCapacityInLiters;
        litersInTank = tankCapacityInLiters;
    }

    public boolean addGas(double litersToAdd) {
        litersInTank += litersToAdd;

        if (litersInTank > tankCapacityInLiters) {
            litersInTank = tankCapacityInLiters;
            return false;
        }

        return true;

    }

    @Override
    public boolean drive(double kilometersToDrive) {
        double litersNeeded = kilometersToDrive / kilometersPerLiter;
        litersInTank -= litersNeeded;

        if (litersInTank < 0) {
            litersInTank = 0;
            return false;
        }
        
        return true;
    }

    @Override
    public double getKilometersPerLiter() {
        return kilometersPerLiter;
    }

    @Override
    public double getLitersInTank() {
        return litersInTank;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public double getTankCapacityInLiters() {
        return tankCapacityInLiters;
    }
    
    @Override
    public String toString(){
        return make + " " + model;
    }

}
