package Exp5;
class StudentAttendance {
    private int totalClasses;
    private int presentClasses;
    public StudentAttendance() {
        totalClasses = 0;
        presentClasses = 0;
    }
    public void markAttendance(boolean present) {
        totalClasses++;
        if (present) {
            presentClasses++;
        }
    }
    public double calculateAttendancePercentage() {

        if (totalClasses == 0) return 0;

        return (presentClasses * 100.0) / totalClasses;
    }
    public static double calculateClassAttendance(StudentAttendance[] students) {
        double sum = 0;
        for (int i = 0; i < students.length; i++) {
            sum += students[i].calculateAttendancePercentage();
        }
        return sum / students.length;
    }
}
public class AttendanceTest {
    public static void main(String[] args) {
        StudentAttendance s1 = new StudentAttendance();
        StudentAttendance s2 = new StudentAttendance();
        s1.markAttendance(true);
        s1.markAttendance(true);
        s1.markAttendance(false);
        s2.markAttendance(true);
        s2.markAttendance(false);
        s2.markAttendance(false);
        System.out.println("Student1 %: " + s1.calculateAttendancePercentage());
        System.out.println("Student2 %: " + s2.calculateAttendancePercentage());
        StudentAttendance[] arr = {s1, s2};
        double avg = StudentAttendance.calculateClassAttendance(arr);
        System.out.println("Class average attendance: " + avg);
    }
}