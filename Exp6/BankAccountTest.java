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

        BankAccount[] arr = new BankAccount[2];

        System.out.print("Enter acc and balance (Savings): ");
        arr[0] = new SavingsAccount(sc.nextInt(), sc.nextDouble());

        System.out.print("Enter acc and balance (FD): ");
        arr[1] = new FixedDepositAccount(sc.nextInt(), sc.nextDouble());

        for(int i=0;i<2;i++) {
            arr[i].display();
            System.out.println("Interest: " + arr[i].computeInterest());
        }
    }
}