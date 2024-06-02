package day3;

public class Account {

    private String name;
    private double balance;
    private double anwalRate;

    public Account(String name, double balance, double anwalRate) {
        this.name = name;
        this.balance = balance;
        this.anwalRate = anwalRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnwalRate() {
        return anwalRate;
    }

    public void setAnwalRate(double anwalRate) {
        this.anwalRate = anwalRate;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
}
