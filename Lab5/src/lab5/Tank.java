package lab5;

public class Tank implements Drivable {

    private double kilometersPerLiter;
    private double litersInTank;
    private double tankCapacityInLiters;

    public Tank(double kilometersPerLiter, double tankCapacityInLiters) {
        this.kilometersPerLiter = kilometersPerLiter;
        this.tankCapacityInLiters = tankCapacityInLiters;
        litersInTank = tankCapacityInLiters;
    }
    
    @Override
    public String toString(){
        return "Tank!";
    }

    public String smash(String target) {
        return "Tank SMASH " + target;
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

}
