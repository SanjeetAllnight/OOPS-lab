
class Person {
    String name;
    int age;
    Person (String name , int age){
        this.name=name;
        this.age=age;
    }
    void displayPersonalDetails(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
class Employee extends Person {
    int EmployeeId;
    double salary;
    Employee (String name, int age, int EmployeeId, double salary){
        super(name);
        super(age);
        this.EmployeeId=EmployeeId;
        this.salary=salary;
    }
    void displayEmployeeDetails(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("EmployeeId: " + EmployeeId);
        System.out.println("Salary: " + salary);
    }
}
class ConstructorChaining {
    public static void main (String args []){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        String n=sc.nextLine();

        System.out.println("Enter age: ");
        int a = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter EmployeeId: ");
        int i = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter salary: ");
        double s = sc.nextDouble();
        sc.nextLine();

        Employee emp = new Employee (n,a,i,s);
        emp.displayEmployeeDetails();

        sc.close;
    }
}