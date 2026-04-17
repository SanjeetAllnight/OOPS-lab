package Exp5;
import java.util.Scanner;

class ReportCard {

    private int[] marks;

    public void inputMarks(int[] m) {
        marks = m;
    }

    public char calculateGrade() {
        int sum = 0;

        for(int i=0;i<marks.length;i++)
            sum += marks[i];

        double avg = sum / marks.length;

        if(avg >= 75) return 'A';
        else if(avg >= 60) return 'B';
        else if(avg >= 50) return 'C';
        else return 'D';
    }

    public static void generateClassReport(ReportCard[] r) {
        for(int i=0;i<r.length;i++)
            System.out.println("Student " + (i+1) + " Grade: " + r[i].calculateGrade());
    }
}

public class ReportTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter students: ");
        int n = sc.nextInt();

        ReportCard[] arr = new ReportCard[n];

        for(int i=0;i<n;i++) {
            arr[i] = new ReportCard();

            System.out.print("Enter subjects: ");
            int s = sc.nextInt();

            int[] m = new int[s];

            for(int j=0;j<s;j++) {
                System.out.print("Enter mark: ");
                m[j] = sc.nextInt();
            }

            arr[i].inputMarks(m);
        }

        ReportCard.generateClassReport(arr);
    }
}