package Exp5;
class SavingsAccount {
    private double balance;
    private static double interestRate = 5;
    public SavingsAccount(double b) {
        balance = b;
    }
    public double calculateInterest() {
        double interest = balance * interestRate / 100;
        return interest;
    }
    public static void updateInterestRate(double newRate) {
        interestRate = newRate;
    }
}
public class SavingsTest {
    public static void main(String[] args) {
        SavingsAccount a1 = new SavingsAccount(1000);
        SavingsAccount a2 = new SavingsAccount(2000);
        System.out.println("Interest a1: " + a1.calculateInterest());
        System.out.println("Interest a2: " + a2.calculateInterest());
        SavingsAccount.updateInterestRate(7);
        System.out.println("After rate change");
        System.out.println("Interest a1: " + a1.calculateInterest());
        System.out.println("Interest a2: " + a2.calculateInterest());
    }
}