package Exp3;  
import java.util.Scanner;

public class StringCompress {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        StringBuilder out = new StringBuilder();
        int count = 1;

        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == s.charAt(i-1)) {
                count++;
            } else {
                out.append(s.charAt(i-1));
                out.append(count);
                count = 1;
            }
        }
        System.out.println("Compressed: " + out.toString());
    }
}
