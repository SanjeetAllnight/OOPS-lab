import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter decimal number (0-255): ");
        int num = sc.nextInt();

        String binary = "";

        if (num == 0) {
            binary = "0";
        } else {
            while (num > 0) {
                binary = (num % 2) + binary;
                num /= 2;
            }
        }

        System.out.println("Binary: " + binary);
    }
}
