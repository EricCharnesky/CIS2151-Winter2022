
package checkingforinterfaces;

public class CheckingForInterfaces {

    public static void main(String[] args) {
        Event party = new Event("Party");
        party.logMessage("Starts at 9pm");
        
        ItemStorage bottlesOfPop = new ItemStorage();
        bottlesOfPop.increaseCount();
        
        Class c = bottlesOfPop.getClass();
        Class[] theInterfaces = c.getInterfaces();
        
        for ( Class implementedInterface : theInterfaces){
            System.out.println(implementedInterface.getName());
            
            if ( implementedInterface == Countable.class ){
                System.out.println("You can count this!");
            }
        }
        
        if ( bottlesOfPop instanceof Countable ){
            Countable countableBottlesOfPop = (Countable)bottlesOfPop;
            countableBottlesOfPop.increaseCount();
        } 
        
    }
    
}
