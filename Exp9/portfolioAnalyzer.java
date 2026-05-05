package Exp9;
import java.util.Scanner;
interface EquityAnalyzer {
    default double sharpeRatio(double r, double rf, double sd) {
        return (r - rf) / sd;
    }
}
interface DebtAnalyzer {
    default double yieldToMaturity(double fv, double cr, double price, int y) {
        return (fv + cr*y - price) / y;
    }
}
public class portfolioAnalyzer {
    static class MixedPortfolio implements EquityAnalyzer, DebtAnalyzer {
        double er, dr, ew, dw;
        MixedPortfolio(double er, double dr, double ew, double dw) {
            this.er = er;
            this.dr = dr;
            this.ew = ew;
            this.dw = dw;
        }
        void analyze() {
            double total = er*ew + dr*dw;
            double sharpe = sharpeRatio(total, 2.0, 1.5);
            System.out.println("Return: " + total);
            System.out.println("Sharpe: " + sharpe);
            if(Math.abs(ew - 0.5) > 0.05)
                System.out.println("Rebalance needed");
            else
                System.out.println("Balanced");
        }
        public String toString() {
            return "Equity: " + ew + " Debt: " + dw;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Equity return weight: ");
        double er = sc.nextDouble();
        double ew = sc.nextDouble();
        System.out.print("Debt return weight: ");
        double dr = sc.nextDouble();
        double dw = sc.nextDouble();
        MixedPortfolio m = new MixedPortfolio(er, dr, ew, dw);
        System.out.println(m);
        m.analyze();
    }
}