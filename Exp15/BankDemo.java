package Exp15;

class BankAccount {

    private int balance;

    public BankAccount(int balance) {

        this.balance = balance;
    }

    public synchronized void withdraw(String name, int amount) {

        System.out.println(name + " wants to withdraw " + amount);

        if (balance >= amount) {

            balance = balance - amount;

            System.out.println(name + " withdrawn " + amount);

            System.out.println("Remaining Balance: " + balance);
        }

        else {

            System.out.println("Insufficient Balance for " + name);
        }
    }
}

class Customer extends Thread {

    BankAccount account;

    String customerName;

    int amount;

    public Customer(BankAccount account, String customerName, int amount) {

        this.account = account;

        this.customerName = customerName;

        this.amount = amount;
    }

    public void run() {

        account.withdraw(customerName, amount);
    }
}

public class BankDemo {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(1000);

        Customer c1 = new Customer(account, "Rahul", 700);

        Customer c2 = new Customer(account, "Amit", 700);

        c1.start();

        c2.start();
    }
}