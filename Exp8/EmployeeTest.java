package Exp8;
import java.util.Scanner;
abstract class Employee {
    protected String name;
    protected int id;
    public Employee(String n, int i) {
        name = n;
        id = i;
    }
    abstract double calculateSalary();
    public void displayDetails() {
        System.out.println("Name: " + name + " ID: " + id);
    }
}
class Manager extends Employee {
    private double bonus;
    public Manager(String n, int i, double b) {
        super(n, i);
        bonus = b;
    }
    double calculateSalary() {
        return 50000 + bonus;
    }
}
class Developer extends Employee {
    private int hours;
    public Developer(String n, int i, int h) {
        super(n, i);
        hours = h;
    }
    double calculateSalary() {
        return hours * 500;
    }
}
public class EmployeeTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Manager name id bonus: ");
        Employee e1 = new Manager(sc.next(), sc.nextInt(), sc.nextDouble());
        System.out.print("Enter Developer name id hours: ");
        Employee e2 = new Developer(sc.next(), sc.nextInt(), sc.nextInt());
        Employee[] arr = {e1, e2};
        for (int i = 0; i < arr.length; i++) {
            arr[i].displayDetails();
            System.out.println("Salary: " + arr[i].calculateSalary()); // dynamic binding
        }
    }
}