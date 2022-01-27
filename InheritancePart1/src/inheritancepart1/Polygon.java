
package inheritancepart1;

import java.util.ArrayList;

public class Polygon {
    private int numberOfSides;
    private ArrayList<Integer> sideLengths;

    public Polygon(int numberOfSides) {
        this.numberOfSides = numberOfSides;
        sideLengths = new ArrayList<>(sideLengths); // pre-size the array list
        for ( int sideIndex = 0 ; sideIndex < numberOfSides; sideIndex++ ){
            sideLengths.add(0);
        }
    }
    
    public int getPerimeter(){
        int perimeter = 0;
        
        for ( int length : sideLengths ){
            perimeter += length;
        }
        
        return perimeter;
    }
    
    public void setSideLength(int sideIndex, int length){
        // nothing too defensive needed, it will just crash
        sideLengths.set(sideIndex, length);
    }
    
    public int getNumberOfSides() {
        return numberOfSides;
    }
    
    public int getSideLength(int sideIndex){
        // nothing too defensive needed, it will just crash
        return sideLengths.get(sideIndex);
    }
}
