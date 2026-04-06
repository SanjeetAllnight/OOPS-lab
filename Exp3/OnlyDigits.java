package Exp3;
import java.util.Scanner;

public class OnlyDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        boolean ok = true;

        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                ok = false;
                break;
            }
        }

        System.out.println(ok ? "Only digits" : "Not only digits");
    }
}
