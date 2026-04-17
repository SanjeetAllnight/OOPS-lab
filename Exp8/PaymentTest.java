package Exp8;
import java.util.Scanner;

abstract class Payment {

    abstract void processPayment();

    final void generateReceipt() {
        System.out.println("Receipt generated");
    }
}

class CreditCardPayment extends Payment {
    void processPayment() {
        System.out.println("Paid using Credit Card");
    }
}

class UPIPayment extends Payment {
    void processPayment() {
        System.out.println("Paid using UPI");
    }
}

public class PaymentTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of payments: ");
        int n = sc.nextInt();

        Payment[] arr = new Payment[n];

        for(int i=0;i<n;i++) {
            System.out.print("Type (1-Card 2-UPI): ");
            int t = sc.nextInt();

            if(t==1) arr[i] = new CreditCardPayment();
            else arr[i] = new UPIPayment();
        }

        for(int i=0;i<n;i++) {
            arr[i].processPayment();
            arr[i].generateReceipt();
        }
    }
}