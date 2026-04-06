package Exp2;
import java.util.*;
public class StringBinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        String[] arr = new String[n];
        System.out.println("Enter strings:");
        for(int i=0;i<n;i++)
            arr[i] = sc.next();
        Arrays.sort(arr);
        System.out.print("Enter search key: ");
        String key = sc.next();
        int low=0, high=n-1;
        boolean found=false;
        while(low<=high){
            int mid=(low+high)/2;
            int c=arr[mid].compareTo(key);
            if(c==0){ found=true; break; }
            else if(c<0) low=mid+1;
            else high=mid-1;
        }
        System.out.println(found ? "Found" : "Not found");
    }
}
