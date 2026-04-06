package Exp5;
import java.util.Scanner;
class DistanceConverter {
    public static double kmToMiles(double km) {
        return km * 0.621;
    }
    public static double milesToKm(double miles) {
        return miles * 1.609;
    }
    public void displayConversion(double value) {
        double miles = kmToMiles(value);
        double km = milesToKm(value);
        System.out.println(value + " km = " + miles + " miles");
        System.out.println(value + " miles = " + km + " km");
    }
}
public class DistanceTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value: ");
        double v = sc.nextDouble();
        DistanceConverter d = new DistanceConverter();
        d.displayConversion(v);
    }
}