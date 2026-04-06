package Exp7;
import java.util.Scanner;
class PaymentProcessor {
    private String user;
    public PaymentProcessor() {
        user = "";
    }
    public PaymentProcessor(String u) {
        user = u;
    }
    public void setUser(String u) { user = u; }
    public String getUser() { return user; }
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Cash");
    }
    public void pay(int amount, String cardType) {
        System.out.println("Paid " + amount + " using " + cardType + " card");
    }
    public void pay(double amount, String wallet) {
        System.out.println("Paid " + amount + " using " + wallet + " wallet");
    }
    public String toString() {
        return "User: " + user;
    }
}
public class Q1Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter user name: ");
        String name = sc.nextLine();
        PaymentProcessor p = new PaymentProcessor(name);
        System.out.print("Enter amount: ");
        int amt = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter card type: ");
        String card = sc.nextLine();
        System.out.print("Enter wallet amount: ");
        double wAmt = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter wallet name: ");
        String wallet = sc.nextLine();
        System.out.println(p);
        p.pay(amt);
        p.pay(amt, card);
        p.pay(wAmt, wallet);
    }
}