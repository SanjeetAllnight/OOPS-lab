package Exp11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class arrayList {

    static class Product {

        private String name;
        private String category;
        private double price;

        public Product() {}

        public Product(String name, String category, double price) {
            this.name = name;
            this.category = category;
            this.price = price;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public String getCategory() {
            return category;
        }

        public double getPrice() {
            return price;
        }

        public String toString() {
            return name + " | " + category + " | " + price;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Product> list = new ArrayList<>();

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter category: ");
            String cat = sc.nextLine();

            System.out.print("Enter price: ");
            double price = sc.nextDouble();
            sc.nextLine();

            Product p = new Product(name, cat, price);

            list.add(p);
        }

        System.out.print("Enter price threshold: ");
        double threshold = sc.nextDouble();

        Iterator<Product> itr = list.iterator();

        while (itr.hasNext()) {

            Product p = itr.next();

            if (p.getPrice() > threshold) {
                itr.remove();
            }
        }

        System.out.println("Remaining Products:");

        for (Product p : list) {
            System.out.println(p);
        }
    }
}