package Exp8;
import java.util.Scanner;

interface RemoteControl {
    void turnOn();
}

abstract class Appliance {

    public static void applianceType() {
        System.out.println("Appliance");
    }

    abstract void operate();
}

class AirConditioner extends Appliance implements RemoteControl {

    String mode;

    public AirConditioner(String m) {
        mode = m;
    }

    public void turnOn() {
        System.out.println("AC ON");
    }

    void operate() {
        System.out.println("Mode: " + mode);
    }
}

public class RemoteControlTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter mode: ");
        String m = sc.next();

        AirConditioner ac = new AirConditioner(m);

        Appliance.applianceType();
        ac.turnOn();
        ac.operate();
    }
}