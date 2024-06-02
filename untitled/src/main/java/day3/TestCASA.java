package day3;

public class TestCASA {
    public static void main(String[] args) {
        CheckingAccount ca = new CheckingAccount("A", 160, 500);

        SavingAccount sa = new SavingAccount("B",  160, 500, 600);

        System.out.println(ca.getBalance());
        ca.withdraw(6);
        System.out.println(ca.getBalance());

        System.out.println(sa.getBalance());
        sa.withdraw(6);
        System.out.println(sa.getBalance());
    }
}
