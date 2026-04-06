package Exp3;
import java.util.Scanner;

public class NumberToWords {

    static String[] ones = {
        "", "One","Two","Three","Four","Five","Six","Seven","Eight","Nine",
        "Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen",
        "Seventeen","Eighteen","Nineteen"
    };

    static String[] tens = {
        "","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number (0-999): ");
        int n = sc.nextInt();

        System.out.println("In words: " + convert(n).trim());
    }

    static String convert(int n) {
        if (n == 0) return "Zero";
        if (n < 20) return ones[n];
        if (n < 100) return tens[n/10] + " " + ones[n%10];
        return ones[n/100] + " Hundred " + convert(n%100);
    }
}