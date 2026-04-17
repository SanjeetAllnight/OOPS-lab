package Exp6;
import java.util.Scanner;

class Employee {
    protected String name;
    protected double salary;

    public Employee(String n, double s) {
        name = n;
        salary = s;
    }

    public double calculateSalary() {
        return salary;
    }
}

class Developer extends Employee {
    public Developer(String n, double s) {
        super(n, s);
    }

    public double calculateSalary() {
        return salary + 5000;
    }
}

class Manager extends Employee {
    public Manager(String n, double s) {
        super(n, s);
    }

    public double calculateSalary() {
        return salary + 10000;
    }
}

class Intern extends Employee {
    public Intern(String n, double s) {
        super(n, s);
    }

    public double calculateSalary() {
        return salary + 2000;
    }
}

public class EmployeeTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        Employee[] arr = new Employee[n];

        for(int i=0;i<n;i++) {
            System.out.print("Type (1-Dev 2-Man 3-Intern): ");
            int t = sc.nextInt();

            System.out.print("Enter name and base salary: ");
            String name = sc.next();
            double sal = sc.nextDouble();

            if(t==1) arr[i] = new Developer(name, sal);
            else if(t==2) arr[i] = new Manager(name, sal);
            else arr[i] = new Intern(name, sal);
        }

        for(int i=0;i<n;i++) {
            System.out.println(arr[i].name + " Salary: " + arr[i].calculateSalary());
        }
    }
}