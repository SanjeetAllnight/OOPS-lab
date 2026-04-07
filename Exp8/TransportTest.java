package Exp8;
abstract class Transport {
    abstract void move();
}
abstract class PublicTransport extends Transport {
    abstract double ticketFare();
}
class Bus extends PublicTransport {
    void move() {
        System.out.println("Bus is moving");
    }
    double ticketFare() {
        return 20.0;
    }
}
public class TransportTest {
    public static void main(String[] args) {
        PublicTransport b = new Bus();
        b.move();
        System.out.println("Fare: " + b.ticketFare());
    }
}