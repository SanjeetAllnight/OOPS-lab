package Exp4;
import java.util.Scanner;

class Mobile {
    private String brand;
    private String model;
    private double price;

    Mobile(){ brand=""; model=""; price=0; }

    Mobile(String brand,String model,double price){
        this.brand=brand;
        this.model=model;
        this.price=price;
    }

    public double getPrice(){ return price; }

    public String toString(){
        return brand+" "+model+" | "+price;
    }
}

public class MobileTest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter mobiles: ");
        int n=sc.nextInt();
        sc.nextLine();

        Mobile[] m=new Mobile[n];

        for(int i=0;i<n;i++){
            System.out.print("Brand: ");
            String b=sc.nextLine();
            System.out.print("Model: ");
            String mo=sc.nextLine();
            System.out.print("Price: ");
            double p=sc.nextDouble();
            sc.nextLine();
            m[i]=new Mobile(b,mo,p);
        }

        System.out.print("Min price: ");
        double min=sc.nextDouble();
        System.out.print("Max price: ");
        double max=sc.nextDouble();

        System.out.println("In range:");
        for(Mobile x:m)
            if(x.getPrice()>=min && x.getPrice()<=max)
                System.out.println(x);
    }
}