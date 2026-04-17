package Exp7;
import java.util.Scanner;

class Bank {
    protected String name;

    public Bank(String n) {
        name = n;
    }

    public double getInterestRate() {
        return 0;
    }

    public String toString() {
        return name;
    }
}

class SBI extends Bank {
    public SBI() { super("SBI"); }
    public double getInterestRate() { return 6.5; }
}

class HDFC extends Bank {
    public HDFC() { super("HDFC"); }
    public double getInterestRate() { return 7.0; }
}

class ICICI extends Bank {
    public ICICI() { super("ICICI"); }
    public double getInterestRate() { return 7.2; }
}

public class BankTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of banks: ");
        int n = sc.nextInt();

        Bank[] arr = new Bank[n];

        for(int i=0;i<n;i++) {
            System.out.print("Choose bank (1-SBI 2-HDFC 3-ICICI): ");
            int ch = sc.nextInt();

            if(ch==1) arr[i] = new SBI();
            else if(ch==2) arr[i] = new HDFC();
            else arr[i] = new ICICI();
        }

        for(int i=0;i<n;i++)
            System.out.println(arr[i] + " Rate: " + arr[i].getInterestRate());
    }
}