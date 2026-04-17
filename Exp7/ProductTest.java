package Exp7;
import java.util.Scanner;

class Product {
    protected String name;
    protected double price;

    public Product(String n, double p) {
        name = n;
        price = p;
    }

    public double getDiscount() {
        return 0;
    }

    public String toString() {
        return name + " " + price;
    }
}

class Electronics extends Product {
    public Electronics(String n, double p) {
        super(n,p);
    }

    public double getDiscount() {
        return price * 0.10;
    }
}

class Clothing extends Product {
    public Clothing(String n, double p) {
        super(n,p);
    }

    public double getDiscount() {
        return price * 0.20;
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine();

        Product[] arr = new Product[n];

        for(int i=0;i<n;i++) {
            System.out.print("Type (1-Electronics 2-Clothing): ");
            int t = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter price: ");
            double price = sc.nextDouble();

            if(t==1) arr[i] = new Electronics(name, price);
            else arr[i] = new Clothing(name, price);
        }

        for(int i=0;i<n;i++) {
            System.out.println(arr[i]);
            System.out.println("Discount: " + arr[i].getDiscount());
        }
    }
}