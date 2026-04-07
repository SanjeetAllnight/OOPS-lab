package Exp8;
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
        Payment p1 = new CreditCardPayment();
        Payment p2 = new UPIPayment();
        p1.processPayment();
        p1.generateReceipt();
        p2.processPayment();
        p2.generateReceipt();
    }
}