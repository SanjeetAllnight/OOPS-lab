package Exp4;
import java.util.Scanner;

class Car {
    private String model;
    private double price;
    private double mileage;

    Car() { model=""; price=0; mileage=0; }

    Car(String model, double price, double mileage) {
        this.model=model;
        this.price=price;
        this.mileage=mileage;
    }

    public double getPrice() { return price; }

    public String toString() {
        return model+" | Price: "+price+" | Mileage: "+mileage;
    }
}

public class CarTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cars: ");
        int n = sc.nextInt();
        sc.nextLine();

        Car[] arr = new Car[n];

        for(int i=0;i<n;i++){
            System.out.print("Model: ");
            String m=sc.nextLine();
            System.out.print("Price: ");
            double p=sc.nextDouble();
            System.out.print("Mileage: ");
            double mil=sc.nextDouble();
            sc.nextLine();
            arr[i]=new Car(m,p,mil);
        }

        Car max = arr[0];
        for(Car c:arr)
            if(c.getPrice()>max.getPrice())
                max=c;

        System.out.println("Most expensive:");
        System.out.println(max);
    }
}
