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
        System.out.println(name + " " + id);
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

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        Employee[] arr = new Employee[n];

        for(int i=0;i<n;i++) {
            System.out.print("Type (1-Manager 2-Developer): ");
            int t = sc.nextInt();

            System.out.print("Enter name and id: ");
            String name = sc.next();
            int id = sc.nextInt();

            if(t==1) {
                System.out.print("Enter bonus: ");
                double b = sc.nextDouble();
                arr[i] = new Manager(name, id, b);
            } else {
                System.out.print("Enter hours: ");
                int h = sc.nextInt();
                arr[i] = new Developer(name, id, h);
            }
        }
        for(int i=0;i<n;i++) {
            arr[i].displayDetails();
            System.out.println("Salary: " + arr[i].calculateSalary());
        }
    }
}