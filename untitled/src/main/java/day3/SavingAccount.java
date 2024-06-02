package day3;

public class SavingAccount extends Account{

    private int limit;

    public SavingAccount(String name, double balance, double anwalRate, int limit) {
        super(name, balance, anwalRate);
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public void withdraw(double amount) {
        double b = getBalance();

        if ( b - amount >= limit)
            super.withdraw(amount);
    }
}
