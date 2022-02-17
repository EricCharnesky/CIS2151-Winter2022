package customexceptions;

import java.io.*;
import java.util.Scanner;

public class CustomExceptions {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("please enter a number");
        // optional - definitely recommended, but not required
        // inherits from runtimeexception
        try {
            int number = Integer.parseInt(keyboard.nextLine());
        } catch (NumberFormatException ex) {
            System.out.println(ex);
        }
        System.out.println("have a good day");

        Item item = new Item("Coffee", 1, 10);
        try {
            item.setPrice(-1);
        } catch (NegativeArgumentException ex) { // it will be caught here first
            System.out.println(ex);
        } catch (Exception ex) { // this will never run
            System.out.println(ex);
        }

        DataOutputStream binaryOutputFile = null;
        try {
            // checked exceptions must be try/catch OR 'decared to be thrown'
            binaryOutputFile = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("test.txt")));
            binaryOutputFile.writeUTF("Happy Thursday");

        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                if (binaryOutputFile != null) {
                    binaryOutputFile.close();
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        
        // will auto close the input
        try (BufferedReader input = 
                new BufferedReader(new FileReader("test.txt"))) {
            System.out.println(input.readLine());
        } catch ( IOException ex){
            System.out.println(ex);
        } 
    }

}
