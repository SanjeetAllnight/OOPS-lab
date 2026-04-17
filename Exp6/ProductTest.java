package Exp6;
import java.util.Scanner;

class Product {
    protected int productId;
    protected String productName;
    protected double price;

    public Product(int id, String name, double price) {
        productId = id;
        productName = name;
        this.price = price;
    }

    public void displayProduct() {
        System.out.println(productId + " " + productName + " " + price);
    }
}

class ElectronicProduct extends Product {
    private int warranty;
    private String brand;

    public ElectronicProduct(int id, String name, double price, int w, String b) {
        super(id, name, price);
        warranty = w;
        brand = b;
    }

    public void displayElectronicProduct() {
        super.displayProduct();
        System.out.println("Brand: " + brand + " Warranty: " + warranty);
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter id name price: ");
        int id = sc.nextInt();
        String name = sc.next();
        double price = sc.nextDouble();

        System.out.print("Enter warranty and brand: ");
        int w = sc.nextInt();
        String b = sc.next();

        ElectronicProduct e = new ElectronicProduct(id, name, price, w, b);
        e.displayElectronicProduct();
    }
}