package Exp7;
import java.util.Scanner;

class PaymentProcessor {
    private String user;

    public PaymentProcessor() {}

    public PaymentProcessor(String u) {
        user = u;
    }

    public void setUser(String u) { user = u; }
    public String getUser() { return user; }

    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Cash");
    }

    public void pay(int amount, String card) {
        System.out.println("Paid " + amount + " using " + card);
    }

    public void pay(double amount, String wallet) {
        System.out.println("Paid " + amount + " using " + wallet);
    }

    public String toString() {
        return "User: " + user;
    }
}

public class PaymentProcessorTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        PaymentProcessor p = new PaymentProcessor(name);

        System.out.print("Enter cash amount: ");
        int a = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter card type: ");
        String c = sc.nextLine();

        System.out.print("Enter wallet amount: ");
        double w = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter wallet name: ");
        String wn = sc.nextLine();

        System.out.println(p);
        p.pay(a);
        p.pay(a, c);
        p.pay(w, wn);
    }
}