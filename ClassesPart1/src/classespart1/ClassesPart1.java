
package classespart1;

import java.util.Scanner;

public class ClassesPart1 {

    public static void main(String[] args) {
        Can limePerrier = new Can("green", 250, 250, "sparkling lime water");
        Scanner keyboard = new Scanner(System.in);
        
        boolean result = true;
        
        while ( result ){
            System.out.println("How many militers do you want to drink of your "
            + limePerrier.getName());
            int mililitersToDrink = Integer.parseInt(keyboard.nextLine());
            result = limePerrier.drink(mililitersToDrink);
        }
        
    }
    
}
