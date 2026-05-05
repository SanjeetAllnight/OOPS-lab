package Exp10;
import java.util.Scanner;
public class arrayChecker {
    static class ArrayChecker {
        private int[] marks = new int[5];
        public ArrayChecker(int[] m) {
            for(int i=0;i<5;i++)
                marks[i] = m[i];
        }
        public int getMark(int index) {
            return marks[index]; 
        }
        public String toString() {
            String s = "Marks: ";
            for(int i=0;i<marks.length;i++)
                s += marks[i] + " ";
            return s;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] m = new int[5];
        System.out.println("Enter 5 marks:");
        for(int i=0;i<5;i++)
            m[i] = sc.nextInt();
        ArrayChecker obj = new ArrayChecker(m);
        System.out.println(obj);
        System.out.print("Enter index: ");
        int index = sc.nextInt();
        try {
            int mark = obj.getMark(index);
            System.out.println("Mark: " + mark);
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index " + index + " is out of bounds. Valid range is 0 to 4");
        }
        finally {
            System.out.println("Lookup complete");
        }
    }
}