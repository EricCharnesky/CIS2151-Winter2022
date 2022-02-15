
package lab6;

import java.io.*;

public class Lab6 {

    public static void main(String[] args) {
        Item coffee = new Item("coffee", 42, .99);
        try{
            // object output stream for writing serializable classes
            ObjectOutputStream binaryOutputFile = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("item2.bin")));
            binaryOutputFile.writeObject(coffee);
            binaryOutputFile.close();
        } catch ( IOException ex ){
            System.out.println(ex);
        }
        
        try{
            ObjectInputStream binaryInputFile = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream("item.bin")));
            Item item = (Item)binaryInputFile.readObject();
            binaryInputFile.close();
            System.out.println(item);
            
        } catch ( IOException ex ){
            System.out.println(ex);
        } catch ( ClassNotFoundException ex ){
            System.out.println(ex);
        }
        
    }
    
}
