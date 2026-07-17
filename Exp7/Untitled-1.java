/*Product Billing System: Create a class ProductBill and include the
following:
a. Instance Method
i. calculateTotalPrice(): Returns total = price × quantity.
b. Static Method
i. calculateStoreRevenue(Product[] products): Returns total
revenue of all products.*/

import java.util.Scanner

class Product{
    private String name;
    private double price;
    private int quantity;

    ProductBill ( double price , int quantity ){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }

    double calculateTotalPrice(){
        return price*quantity;
    }

    public static calculateStoreRevenue (Product [] products){
        double total=0;
        for (Profuct p : products){
            total += p.calculateTotalPrice();
        }
        return total;
    }
}
class ProductBill {
    public static void main (String args []){
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of products: ");
        int n=sc.nextInt();
        sc.nextLine();

        Product products [] = new Product [n];

        for (int i =0 ; i<n ; i++){
            System.out.println("Enter Name of the product: ");
            String nameProduct = sc.nextLine();

            System.out.println("Enter Price: ");
            double proceprod= sc.nextDouble();
            sc.nextLine();

            System.out.println("Enter quantity: ");
            int q=nextInt();
            sc.nextLine();

            products[i] = new Product (nameProduct,proceprod,q);
        }

        for (Product p : products){
            System.out.println(p.name + ":" + p.calculateTotalPrice());
        }

        System.out.println("Revenue Total: " + Product.calculateStoreRevenue(products));

        sc.close();

    }
}