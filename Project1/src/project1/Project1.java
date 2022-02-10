package project1;

import java.util.ArrayList;

public class Project1 {

    public static void main(String[] args) {

        ArrayList<Space> spaces = new ArrayList<>();
        spaces.add(new Space());
        spaces.add(new DiggableSpace());

        for (Space space : spaces) {

            // right now you can't call Dig because we're only treating it as Space
           
            // from https://nipafx.dev/casting-in-java-8-and-beyond/
            if (space instanceof DiggableSpace) {
                DiggableSpace digableSpace = (DiggableSpace) space;
                // now the dig method is available because we have cast it as the type
                digableSpace.dig();
                System.out.println("You dig it!");
            }else{
                System.out.println("you can't dig it");
            }
        }

    }

}
