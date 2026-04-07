package Exp7;
import java.util.Scanner;
class Bank {
    protected String name;
    public Bank() {
        name = "";
    }
    public Bank(String n) {
        name = n;
    }
    public double getInterestRate() {
        return 0;
    }
    public String toString() {
        return "Bank: " + name;
    }
}
class SBI extends Bank {
    public SBI() { super("SBI"); }
    public double getInterestRate() {
        return 6.5;
    }
}
class HDFC extends Bank {
    public HDFC() { super("HDFC"); }
    public double getInterestRate() {
        return 7.0;
    }
}
class ICICI extends Bank {
    public ICICI() { super("ICICI"); }
    public double getInterestRate() {
        return 7.2;
    }
}
public class BankTest {
    public static void main(String[] args) {
        Bank b1 = new SBI();
        Bank b2 = new HDFC();
        Bank b3 = new ICICI();
        System.out.println(b1 + " Rate: " + b1.getInterestRate());
        System.out.println(b2 + " Rate: " + b2.getInterestRate());
        System.out.println(b3 + " Rate: " + b3.getInterestRate());
    }
}