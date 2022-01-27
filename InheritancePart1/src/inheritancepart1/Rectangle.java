package inheritancepart1;

// Polygon - parent class, super class, base class
// Rectangle - child class, sub class, derived class
public class Rectangle extends Polygon {

    // required to call the superclass constructor
    public Rectangle() {
        // first line in a subclass construtor is to call the super class constructor

        // if the superclass has a default or no argument constructor, it will get ran automatically
        super(4); // calls Polygon constructor and tell it 4 sides
    }

    @Override // optional, but allows for compiler checking
    public void setSideLength(int sideIndex, int length) {
        if (sideIndex == 0 || sideIndex == 2) {
            super.setSideLength(0, length); // calls the superclass version
            super.setSideLength(2, length);
        } else if (sideIndex == 1 || sideIndex == 3) {
            super.setSideLength(1, length); // calls the superclass version
            super.setSideLength(3, length);
        }
    }
    
    public int getArea(){
        return getSideLength(0) * getSideLength(1);
    }

//    @Override - helps avoid typos
//    public void setSideLenght(int sideIndex, int length){
//        
//    }
}
