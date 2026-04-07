package Exp8;
interface RemoteControl {
    void turnOn();
}
abstract class Appliance {
    public static void applianceType() {
        System.out.println("Appliance device");
    }
    abstract void operate();
}
class AirConditioner extends Appliance implements RemoteControl {
    public void turnOn() {
        System.out.println("AC turned ON");
    }
    void operate() {
        System.out.println("Cooling started");
    }
}
public class RemoteControlTest {
    public static void main(String[] args) {
        AirConditioner ac = new AirConditioner();
        Appliance.applianceType();  // static method
        ac.turnOn();
        ac.operate();
    }
}