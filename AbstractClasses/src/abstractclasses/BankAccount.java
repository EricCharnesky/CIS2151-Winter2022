package abstractclasses;

public abstract class BankAccount {

    protected long balanceInCents;

    protected String ownerName;

    public BankAccount(String ownerName) {
        this.ownerName = ownerName;
        balanceInCents = 0;
    }
    
    // similar to an interface method declaration
    public abstract long earnMonthlyInterest();
    
    public boolean deposit(long centsToDeposit){
        if ( centsToDeposit > 0 ){
            balanceInCents += centsToDeposit;
            return true;
        }
        return false;
    }
    
    public boolean withdraw(long centsToWithdraw){
        if ( centsToWithdraw > 0 && balanceInCents >= centsToWithdraw){
            balanceInCents -= centsToWithdraw;
            return true;
        }
        return false;
    }

    public long getBalanceInCents() {
        return balanceInCents;
    }

    public String getOwnerName() {
        return ownerName;
    }

}
