import java.util.Scanner;
abstract class Product {
    String name;
    double price;
    Product (String name, double price){
        this.name=name;
        this.price=price;
    }
    abstract String getCategory ();
}

class GroceryProduct extends Product {
    String category;

    GroceryProduct (String name, double price, String category){
     super(name,price);
     this.category=category;   
    }

    @Override
    String getCategory(){
        return category;
    }

    public static double getTotalCost ( GroceryProduct products[]){
        double totalCost =0;
        for (Product p: products){
            totalCost += p.price();
        }
        return totalCost;
    }

    public String formatName (GroceryProduct products[]) {
        for (GroceryProduct p : products){
            String firstChar = Character.toUpperCase(p.name.substring(0));
            String formattedName = firstChar + p.name.substring(1);
            return formattedName;
        }
    }    

    void budgetCheck (double budget){
        if (Product.getTotalCost() > budget){
            System.out.println("Over Budget!");
        }
        else{
            System.out.println("In Budget!");
        }
    }
}

class Shop {
    public static void main (String args []){
        Scanner sc = new Scanner (System.in);

        System.out.print("Enter number of products");
        int n=sc.nextInt();
        sc.nextLine();

        Product products [] = new GroceryProduct [n];

        for (int i = 0; i<n ; i++){
            System.out.println("Enter name of the product: ");
            String n = sc.nextLine();

            System.out.println("Enter price: ");
            double p = sc.nextDouble;
            sc.nextLine();

            System.out.println("Enter Category: ");
            String c = sc.nextLine();

            GroceryProduct[i] = new GroceryProduct (n,p,c);
        }

        formatname(products);

        for (GroceryProduct p : products){
            System.out.println("Name: " + p.name+ 
                ", Price: " + p.price +
                ", Category: " + p.getCategory()
            );
        }

        System.out.println("Enter budget: ");
        double b = sc.nextDouble();

        budgetCheck(b);
    }
}