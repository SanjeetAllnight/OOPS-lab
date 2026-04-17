package Exp6;
import java.util.Scanner;

final class MathUtility {

    public int square(int n) {
        return n*n;
    }

    public int cube(int n) {
        return n*n*n;
    }
}

public class MathUtilityTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MathUtility m = new MathUtility();

        System.out.print("Enter number: ");
        int n = sc.nextInt();

        System.out.println("Square: " + m.square(n));
        System.out.println("Cube: " + m.cube(n));
    }
}