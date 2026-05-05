package Exp9;
import java.util.Scanner;
interface Transactable {
    void deposit(double amt);
    void withdraw(double amt);
    default double transactionFee(double amt) {
        return amt * 0.002;
    }
}
interface Investable extends Transactable {
    void allocateFunds(double amt, String asset);
    default double expectedReturn(double p, double r, int y) {
        return p * Math.pow(1 + r/4, 4*y);
    }
}
interface RetirementInvestable extends Investable {
    double calculateMaturityValue(int y);
    default double inflationAdjustedValue(double fv, double inf, int y) {
        return fv / Math.pow(1 + inf, y);
    }
}
interface Auditable {
    default int generateRiskScore(double v, int m) {
        int s = (int)(v*40 + m*15);
        return Math.min(s, 100);
    }
}
interface RegulatoryCompliant extends Auditable {
    void submitComplianceReport();
    default double penaltyForNonCompliance(double val) {
        return val * 0.035;
    }
}
public class bankingInvestment {
    static class Account {
        protected int acc;
        protected String name;
        protected double balance;
        Account(int a, String n, double b) {
            acc = a; name = n; balance = b;
        }
        public String toString() {
            return acc + " " + name + " " + balance;
        }
    }
    static class InvestmentAccount extends Account implements Investable {
        InvestmentAccount(int a, String n, double b) {
            super(a,n,b);
        }
        public void deposit(double amt) {
            balance += amt;
        }
        public void withdraw(double amt) {
            if(balance >= amt) balance -= amt;
        }
        public void allocateFunds(double amt, String asset) {
            System.out.println("Allocated " + amt + " to " + asset);
        }
    }
    static class PensionFundAccount extends InvestmentAccount 
        implements RetirementInvestable, RegulatoryCompliant {
        PensionFundAccount(int a, String n, double b) {
            super(a,n,b);
        }
        public double calculateMaturityValue(int y) {
            return balance * Math.pow(1.05, y);
        }
        public void submitComplianceReport() {
            System.out.println("Compliance Submitted");
        }
        public double transactionFee(double amt) {
            return amt * 0.0005;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter acc, name, balance: ");
        int a = sc.nextInt();
        String n = sc.next();
        double b = sc.nextDouble();
        PensionFundAccount p = new PensionFundAccount(a,n,b);
        System.out.print("Deposit amount: ");
        double d = sc.nextDouble();
        p.deposit(d);
        System.out.print("Withdraw amount: ");
        double w = sc.nextDouble();
        p.withdraw(w);
        System.out.print("Years for maturity: ");
        int y = sc.nextInt();
        double mv = p.calculateMaturityValue(y);
        System.out.println(p);
        System.out.println("Maturity: " + mv);
        int risk = p.generateRiskScore(1.5, 2);
        System.out.println("Risk: " + risk);
        if(risk > 70)
            System.out.println("Penalty: " + p.penaltyForNonCompliance(mv));
        p.submitComplianceReport();
    }
}