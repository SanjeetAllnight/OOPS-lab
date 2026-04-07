package Exp6;
final class MathUtility {
    public int square(int n) {
        return n * n;
    }
    public int cube(int n) {
        return n * n * n;
    }
}
public class MathUtilityTest {
    public static void main(String[] args) {
        MathUtility m = new MathUtility();
        System.out.println("Square: " + m.square(5));
        System.out.println("Cube: " + m.cube(3));
    }
}