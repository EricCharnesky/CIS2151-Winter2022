package abstractclasses;

import java.util.ArrayList;

public class AbstractClasses {

    public static void main(String[] args) {
        // you can create an instance of an abstract class
        // BankAccount account = new BankAccount("Eric");

        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

        accounts.add(new SavingsAccount("Eric"));
        accounts.add(new CertificateOfDeposit(("Eric"), .05, 12));
    }

}
