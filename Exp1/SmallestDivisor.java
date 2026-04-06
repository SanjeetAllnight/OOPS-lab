import java.util.Scanner;

public class SmallestDivisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int num = sc.nextInt();

        if (num <= 1) {
            System.out.println("No divisor other than 1 exists.");
            return;
        }

        for (int i = 2; i <= num; i++) {
            if (num % i == 0) {
                System.out.println("Smallest divisor other than 1: " + i);
                break;
            }
        }
    }
}
