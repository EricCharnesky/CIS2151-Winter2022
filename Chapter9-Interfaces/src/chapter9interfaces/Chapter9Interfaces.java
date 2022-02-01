package chapter9interfaces;

import java.util.ArrayList;

public class Chapter9Interfaces {

    public static void main(String[] args) {
        
        CanOfCoke coke = new CanOfCoke();
        
        // https://www.eg.bucknell.edu/~mead/Java-tutorial/reflect/class/getInterfaces.html
        Class c = coke.getClass();
        Class[] theInterfaces = c.getInterfaces();
        
        for ( Class implementedInterface : theInterfaces){
            System.out.println(implementedInterface.getName());
            
            if ( implementedInterface == Drinkable.class ){
                System.out.println("You can chug this!");
            }
        }
        
        
        ArrayList<Drinkable> beverages = new ArrayList<>();

        beverages.add(new CanOfCoke());
        beverages.add(new MugOfCoffee());

        for (Drinkable beverage : beverages) {
            chug(beverage);
        }

    }

    public static void chug(Drinkable beverage) {
        while (beverage.getCurrentVolumeInMilliliters() > 0) {
            int randomMililitersToDrink = (int) (Math.random() * 50 + 1);
            if (beverage.drink(randomMililitersToDrink)) {
                System.out.println("Drank " + randomMililitersToDrink
                        + " mililiters of " + beverage.toString());
            }
        }

    }

}
