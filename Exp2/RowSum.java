package Exp2;
import java.util.*;
public class RowSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows and cols: ");
        int r=sc.nextInt(), c=sc.nextInt();
        int[][] M=new int[r][c];
        System.out.println("Enter matrix:");
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                M[i][j]=sc.nextInt();

        for(int i=0;i<r;i++){
            int sum=0;
            for(int j=0;j<c;j++)
                sum+=M[i][j];
            System.out.println("Row "+i+" sum = "+sum);
        }
    }
}
