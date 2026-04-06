package Exp5;
class ReportCard {
    private int[] marks;
    public void inputMarks(int[] m) {
        marks = m;
    }
    public char calculateGrade() {
        int sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];
        }
        double avg = sum / marks.length;
        if (avg >= 75) return 'A';
        else if (avg >= 60) return 'B';
        else if (avg >= 50) return 'C';
        else return 'D';
    }
    public static void generateClassReport(ReportCard[] students) {
        System.out.println("Class Report");
        for (int i = 0; i < students.length; i++) {
            System.out.println("Student " + (i+1) + " Grade: " + students[i].calculateGrade());
        }
    }
}
public class ReportTest {
    public static void main(String[] args) {
        ReportCard r1 = new ReportCard();
        ReportCard r2 = new ReportCard();
        int[] m1 = {80, 70, 75};
        int[] m2 = {55, 60, 50};
        r1.inputMarks(m1);
        r2.inputMarks(m2);
        ReportCard[] arr = {r1, r2};
        ReportCard.generateClassReport(arr);
    }
}