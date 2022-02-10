package abstractclasses;

public class SavingsAccount extends BankAccount {

    // static values don't get set in a constructor
    // shared among all instances of SavingsAccount
    private static double annualInterestRate = 0;

    public SavingsAccount(String ownerName) {
        super(ownerName);
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        if ( annualInterestRate < 1 && annualInterestRate >= 0 ){
            SavingsAccount.annualInterestRate = annualInterestRate;
        }
        
    }

    @Override
    public long earnMonthlyInterest() {
        long interestEarned = 
                (long)Math.floor(balanceInCents * annualInterestRate / 12);
        balanceInCents += interestEarned;
        return interestEarned;    
    }

}
