package Exp6;
class Employee {
    protected String name;
    protected double basicSalary;
    public Employee(String n, double b) {
        name = n;
        basicSalary = b;
    }
    public double calculateSalary() {
        return basicSalary;
    }
}
class Developer extends Employee {
    public Developer(String n, double b) {
        super(n, b);
    }
    public double calculateSalary() {
        return basicSalary + 5000;
    }
}
class Manager extends Employee {
    public Manager(String n, double b) {
        super(n, b);
    }
    public double calculateSalary() {
        return basicSalary + 10000;
    }
}
class Intern extends Employee {
    public Intern(String n, double b) {
        super(n, b);
    }
    public double calculateSalary() {
        return basicSalary + 2000;
    }
}
public class Q3Test {
    public static void main(String[] args) {
        Employee[] arr = new Employee[3];
        arr[0] = new Developer("A", 30000);
        arr[1] = new Manager("B", 40000);
        arr[2] = new Intern("C", 20000);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].name + " Salary: " + arr[i].calculateSalary());
        }
    }
}