package lab2;

import java.io.*;
import java.util.Scanner;

public class Lab2 {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        try {
            DataOutputStream binaryOutputFile = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("shoppingList.bin")));

            String itemName = "";

            while (!itemName.equalsIgnoreCase("STOP")) {

                System.out.println("Please enter the name of an "
                        + "item to add to your shopping list"
                        + "or STOP to be all done");
                itemName = keyboard.nextLine();

                if (!itemName.equalsIgnoreCase("STOP")) {
                    System.out.println("Please enter the quantity to buy");
                    int quantity = Integer.parseInt(keyboard.nextLine());

                    binaryOutputFile.writeUTF(itemName);
                    binaryOutputFile.writeInt(quantity);
                }
            }

            binaryOutputFile.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }

        File binaryInputFile = new File("shoppingList.bin");

        if (binaryInputFile.exists()) {
            try {

                DataInputStream binaryInput = new DataInputStream(
                        new BufferedInputStream(
                                new FileInputStream(binaryInputFile)));

                while (binaryInput.available() > 0) {
                    String itemName = binaryInput.readUTF();
                    int quantity = binaryInput.readInt();

                    System.out.println(itemName + " : " + quantity);
                }

                binaryInput.close();

            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

}
