package classespart2;

public class BankAccount {

    public static final int ROUTING_NUMBER = 123456789;
    // static values are stored at the class level, not the instance level
    private static int nextAccountNumber = 1;   // in real life this would come from a database value
    private long balanceInCents;
    private String ownerName;
    private String type;
    private int number;

    public BankAccount(String type) {
        //this.type = type; // maybe checking if the type is valid
        //balanceInCents = 0;
        //ownerName = ""; // don't leave the deafult or you get null
        this(type, ""); // calls the overloaded constructor
    }

    public BankAccount(String type, String ownerName) {
        this.ownerName = ownerName;
        this.type = type;
        balanceInCents = 0;
        number = nextAccountNumber++;
    }

    public long deposit(double centsToDeposit){
        
        if ( centsToDeposit <= Long.MAX_VALUE) {
            return deposit((long)centsToDeposit);
        }
        
        return 0;
    }
    
    // overload the deposit to make it easy for people to use
    public long deposit(String centsToDeposit) {
        return deposit(Long.parseLong(centsToDeposit));
    }

    public long deposit(long centsToDeposit) {
        if (centsToDeposit > 0) {
            balanceInCents += centsToDeposit;
        }

        return balanceInCents;
    }
    
    // overload withdraw - will ignore any decmial
    public long withdraw(double centsToWithdraw){
        
        // maybe check that the double isn't larger than the max long?
        return withdraw((long)centsToWithdraw);
    }

    // overload the withdraw to make it easy for people to use
    public long withdraw(String centsToWithdraw) {
        return withdraw(Long.parseLong(centsToWithdraw));
    }
    
    public long withdraw(long centsToWithdraw) {
        if (centsToWithdraw > 0 && centsToWithdraw <= balanceInCents) {
            balanceInCents -= centsToWithdraw;

            return centsToWithdraw;
        }

        return 0;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public long getBalanceInCents() {
        return balanceInCents;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }
    
    

}
