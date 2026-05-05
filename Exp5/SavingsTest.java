package Exp5;
import java.util.Scanner;

class SavingsAccount {

    private double balance;
    private static double rate = 5;

    public SavingsAccount(double b) {
        balance = b;
    }

    public double calculateInterest() {
        return balance * rate / 100;
    }

    public static void updateInterestRate(double r) {
        rate = r;
    }
}

public class SavingsTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter accounts: ");
        int n = sc.nextInt();

        SavingsAccount[] arr = new SavingsAccount[n];

        for(int i=0;i<n;i++) {
            System.out.print("Enter balance: ");
            double b = sc.nextDouble();
            arr[i] = new SavingsAccount(b);
        }

        System.out.print("Enter new interest rate: ");
        double r = sc.nextDouble();
        SavingsAccount.updateInterestRate(r);

        for(int i=0;i<n;i++)
            System.out.println("Interest: " + arr[i].calculateInterest());
    }
}