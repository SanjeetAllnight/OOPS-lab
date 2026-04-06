package Exp6;
abstract class BankAccount {
    protected int accountNumber;
    protected double balance;
    public BankAccount(int a, double b) {
        accountNumber = a;
        balance = b;
    }
    abstract double computeInterest();
    public void displayAccountDetails() {
        System.out.println("Acc: " + accountNumber + " Balance: " + balance);
    }
}
class SavingsAccount extends BankAccount {
    public SavingsAccount(int a, double b) {
        super(a, b);
    }
    double computeInterest() {
        return balance * 0.05;
    }
}
class FixedDepositAccount extends BankAccount {
    public FixedDepositAccount(int a, double b) {
        super(a, b);
    }
    double computeInterest() {
        return balance * 0.07;
    }
}
public class Q4Test {
    public static void main(String[] args) {
        BankAccount b1 = new SavingsAccount(1, 10000);
        BankAccount b2 = new FixedDepositAccount(2, 20000);
        b1.displayAccountDetails();
        System.out.println("Interest: " + b1.computeInterest());
        b2.displayAccountDetails();
        System.out.println("Interest: " + b2.computeInterest());
    }
}