package Exp5;
import java.util.Scanner;

class StudentAttendance {

    private int total;
    private int present;

    public void markAttendance(boolean p) {
        total++;
        if(p) present++;
    }

    public double calculateAttendancePercentage() {
        if(total == 0) return 0;
        return (present * 100.0) / total;
    }

    public static double calculateClassAttendance(StudentAttendance[] s) {
        double sum = 0;
        for(int i=0;i<s.length;i++)
            sum += s[i].calculateAttendancePercentage();
        return sum / s.length;
    }
}

public class AttendanceTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter students: ");
        int n = sc.nextInt();

        StudentAttendance[] arr = new StudentAttendance[n];

        for(int i=0;i<n;i++) {
            arr[i] = new StudentAttendance();

            System.out.print("Enter total classes for student " + (i+1) + ": ");
            int t = sc.nextInt();

            for(int j=0;j<t;j++) {
                System.out.print("Present? (1/0): ");
                int p = sc.nextInt();
                arr[i].markAttendance(p==1);
            }
        }

        for(int i=0;i<n;i++)
            System.out.println("Student " + (i+1) + ": " + arr[i].calculateAttendancePercentage());

        System.out.println("Class avg: " + StudentAttendance.calculateClassAttendance(arr));
    }
}