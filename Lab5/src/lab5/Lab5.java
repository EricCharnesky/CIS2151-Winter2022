package lab5;

import java.util.ArrayList;

public class Lab5 {

    public static void main(String[] args) {
        Car transit = new Car("Ford", "Transit", 4.8, 100);
        Tank m1 = new Tank(.25, 400);

        
        ArrayList<Drivable> vehicles = new ArrayList<>();
        vehicles.add(m1);
        vehicles.add(transit);
        
        for ( Drivable vehicle : vehicles){
            while (vehicle.drive(1)){
                System.out.println("Driving 1 km in " + vehicle.toString());
            }
        }
        
        
        while (transit.drive(1)) {
            System.out.println("Driving the " + transit.getModel() + " 1 km!");
        }

        while (m1.drive(1)) {
            System.out.println(m1.smash("pumpkin") + " for 1 km!");
        }
        
        

    }

}
