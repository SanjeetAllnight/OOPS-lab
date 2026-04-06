package Exp2;
import java.util.*;
public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows and cols of A: ");
        int r1=sc.nextInt(), c1=sc.nextInt();
        int[][] A=new int[r1][c1];
        System.out.println("Enter matrix A:");
        for(int i=0;i<r1;i++)
            for(int j=0;j<c1;j++)
                A[i][j]=sc.nextInt();

        System.out.print("Enter rows and cols of B: ");
        int r2=sc.nextInt(), c2=sc.nextInt();
        int[][] B=new int[r2][c2];
        System.out.println("Enter matrix B:");
        for(int i=0;i<r2;i++)
            for(int j=0;j<c2;j++)
                B[i][j]=sc.nextInt();

        if(c1!=r2){
            System.out.println("Not compatible");
            return;
        }

        int[][] C=new int[r1][c2];
        for(int i=0;i<r1;i++)
            for(int j=0;j<c2;j++)
                for(int k=0;k<c1;k++)
                    C[i][j]+=A[i][k]*B[k][j];

        System.out.println("Result:");
        for(int[] row:C){
            for(int x:row) System.out.print(x+" ");
            System.out.println();
        }
    }
}
