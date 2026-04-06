package Exp7;
import java.util.Scanner;
class Product {
    protected String name;
    protected double price;
    public Product() {
        name = "";
        price = 0;
    }
    public Product(String n, double p) {
        name = n;
        price = p;
    }
    public double getDiscount() {
        return 0;
    }
    public String toString() {
        return name + " Price: " + price;
    }
}
class Electronics extends Product {
    public Electronics(String n, double p) {
        super(n, p);
    }
    public double getDiscount() {
        return price * 0.10;
    }
}
class Clothing extends Product {
    public Clothing(String n, double p) {
        super(n, p);
    }
    public double getDiscount() {
        return price * 0.20;
    }
}
public class Q4Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product[] arr = new Product[2];
        System.out.print("Enter electronics name and price: ");
        String en = sc.next();
        double ep = sc.nextDouble();
        arr[0] = new Electronics(en, ep);
        System.out.print("Enter clothing name and price: ");
        String cn = sc.next();
        double cp = sc.nextDouble();
        arr[1] = new Clothing(cn, cp);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
            System.out.println("Discount: " + arr[i].getDiscount());
        }
    }
}