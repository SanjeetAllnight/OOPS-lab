package Exp6;
class Product {
    protected int productId;
    protected String productName;
    protected double price;
    public Product(int id, String name, double price) {
        this.productId = id;
        this.productName = name;
        this.price = price;
    }
    public void displayProduct() {
        System.out.println("ID: " + productId + " Name: " + productName + " Price: " + price);
    }
}
class ElectronicProduct extends Product {
    private int warrantyPeriod;
    private String brand;
    public ElectronicProduct(int id, String name, double price, int w, String b) {
        super(id, name, price);   // constructor chaining
        this.warrantyPeriod = w;
        this.brand = b;
    }
    public void displayElectronicProduct() {
        super.displayProduct();   // method access using super
        System.out.println("Brand: " + brand + " Warranty: " + warrantyPeriod);
    }
}
public class Q1Test {
    public static void main(String[] args) {
        ElectronicProduct e = new ElectronicProduct(1, "Laptop", 50000, 2, "Dell");
        e.displayElectronicProduct();
    }
}