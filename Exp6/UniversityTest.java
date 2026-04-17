package Exp6;
import java.util.Scanner;

class University {
    protected String uname;
    protected String location;

    public University(String u, String l) {
        uname = u;
        location = l;
    }
}

class Department extends University {
    protected String dname;
    protected int faculty;

    public Department(String u, String l, String d, int f) {
        super(u, l);
        dname = d;
        faculty = f;
    }
}

class Student extends Department {
    private int sid;
    private String course;

    public Student(String u, String l, String d, int f, int id, String c) {
        super(u, l, d, f);
        sid = id;
        course = c;
    }

    public void display() {
        System.out.println(uname + " " + location);
        System.out.println(dname + " " + faculty);
        System.out.println(sid + " " + course);
    }
}

public class UniversityTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter university and location: ");
        String u = sc.next();
        String l = sc.next();

        System.out.print("Enter dept and faculty count: ");
        String d = sc.next();
        int f = sc.nextInt();

        System.out.print("Enter student id and course: ");
        int id = sc.nextInt();
        String c = sc.next();

        Student s = new Student(u, l, d, f, id, c);
        s.display();
    }
}