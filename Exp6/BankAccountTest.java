package Exp6;
import java.util.Scanner;

abstract class BankAccount {
    protected int acc;
    protected double balance;

    public BankAccount(int a, double b) {
        acc = a;
        balance = b;
    }

    abstract double computeInterest();

    public void display() {
        System.out.println(acc + " " + balance);
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

public class BankAccountTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of bank accounts: ");
        int n = sc.nextInt();

        BankAccount[] arr = new BankAccount[n];

        for(int i=0;i<n;i++) {
            System.out.print("Enter account type (1-Savings 2-Fixed Deposit): ");
            int type = sc.nextInt();

            System.out.print("Enter acc and balance: ");
            if (type == 1) {
                arr[i] = new SavingsAccount(sc.nextInt(), sc.nextDouble());
            } else {
                arr[i] = new FixedDepositAccount(sc.nextInt(), sc.nextDouble());
            }
        }

        for(int i=0;i<n;i++) {
            arr[i].display();
            System.out.println("Interest: " + arr[i].computeInterest());
        }
    }
}