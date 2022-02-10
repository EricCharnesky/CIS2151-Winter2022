package abstractclasses;

public class CertificateOfDeposit extends BankAccount {

    private double annualInterestRate;
    private int termInMonths;
    private int monthsOfInterestEarned;

    public CertificateOfDeposit(String ownerName,
            double annualInterestRate, int termInMonths) {
        super(ownerName);
        this.annualInterestRate = annualInterestRate;
        this.termInMonths = termInMonths;
        monthsOfInterestEarned = 0;
    }
    
    @Override
    public boolean deposit(long centsToDeposit){
        return false;
    }
    
    @Override
    public boolean withdraw(long centsToWithdraw){
        if ( monthsOfInterestEarned == termInMonths){
            balanceInCents = 0;
        }
        return false;
    }

    @Override
    public long earnMonthlyInterest() {
        if (monthsOfInterestEarned < termInMonths) {
            long interestEarned
                    = (long) Math.floor(balanceInCents * annualInterestRate / 12);
            balanceInCents += interestEarned;
            monthsOfInterestEarned++;
            return interestEarned;
        }
        return 0;
    }

}
