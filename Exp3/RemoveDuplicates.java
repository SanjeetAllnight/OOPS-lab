package Exp3;

import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (res.indexOf(String.valueOf(c)) == -1) {
                res.append(c);
            }
        }

        System.out.println("Without duplicates: " + res.toString());
    }
}
