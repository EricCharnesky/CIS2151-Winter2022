
package project1;


public class Space {
    private Tool tool;
    
    public Space(){
        
        if ( (int)(Math.random() * 5) == 2 ){
            tool = new Tool("Hammer");
        }
    }

    public Tool getTool() {
        return tool;
    }
    
    
}
