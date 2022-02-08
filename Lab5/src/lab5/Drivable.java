package lab5;

public interface Drivable {

    boolean drive(double kilometersToDrive );

    double getKilometersPerLiter();

    double getLitersInTank();
    
    @Override
    String toString();
}
