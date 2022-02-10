package abstractclasses;

public class SavingsAccount extends BankAccount {

    private double annualInterestRate;

    public SavingsAccount(String ownerName) {
        super(ownerName);
        annualInterestRate = 0;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        if ( annualInterestRate < 1 && annualInterestRate >= 0 ){
            this.annualInterestRate = annualInterestRate;
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
