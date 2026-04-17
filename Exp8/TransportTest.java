package Exp8;
import java.util.Scanner;

abstract class Transport {
    abstract void move();
}

abstract class PublicTransport extends Transport {
    abstract double ticketFare();
}

class Bus extends PublicTransport {

    double fare;

    public Bus(double f) {
        fare = f;
    }

    void move() {
        System.out.println("Bus moving");
    }

    double ticketFare() {
        return fare;
    }
}

public class TransportTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter fare: ");
        double f = sc.nextDouble();

        PublicTransport b = new Bus(f);

        b.move();
        System.out.println("Fare: " + b.ticketFare());
    }
}