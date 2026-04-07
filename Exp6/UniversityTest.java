package Exp6;
class University {
    protected String universityName;
    protected String location;
    public University(String u, String l) {
        this.universityName = u;
        this.location = l;
    }
}
class Department extends University {
    protected String departmentName;
    protected int facultyCount;
    public Department(String u, String l, String d, int f) {
        super(u, l);
        this.departmentName = d;
        this.facultyCount = f;
    }
}
class Student extends Department {
    private int studentId;
    private String course;
    public Student(String u, String l, String d, int f, int id, String c) {
        super(u, l, d, f);
        this.studentId = id;
        this.course = c;
    }
    public void display() {
        System.out.println(universityName + " " + location);
        System.out.println(departmentName + " Faculty: " + facultyCount);
        System.out.println("ID: " + studentId + " Course: " + course);
    }
}
public class UniversityTest {
    public static void main(String[] args) {
        Student s = new Student("SPPU", "Pune", "Comp", 20, 101, "BE");
        s.display();
    }
}