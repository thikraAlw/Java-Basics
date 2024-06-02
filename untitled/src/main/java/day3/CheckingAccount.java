package day3;

public class CheckingAccount extends Account{

    public CheckingAccount(String name, double balance, double anwalRate) {
        super(name, balance, anwalRate);
    }

    @Override
    public void withdraw(double amount) {

       double b = getBalance();

       if ( b - amount >= 0)
           super.withdraw(amount);
    }
}
