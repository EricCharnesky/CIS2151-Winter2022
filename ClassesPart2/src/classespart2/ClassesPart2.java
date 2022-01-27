
package classespart2;

public class ClassesPart2 {

    public static void main(String[] args) {
                
        BankAccount savings = new BankAccount("Savings", "Eric");
        
        long result = savings.deposit(Double.MAX_VALUE);
        
        System.out.println("You deposited " + result + " cents!");
        
        System.out.println("Bank account number " + savings.getNumber());
        
        BankAccount checking = new BankAccount("Checking");
        
        System.out.println("Bank account number " + checking.getNumber());
        
        System.out.println("The routing number is: " + BankAccount.ROUTING_NUMBER);
    }
    
}
