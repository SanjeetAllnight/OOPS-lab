package Exp4;
import java.util.Scanner;

class Patient {
    private int id;
    private String name;
    private double bill;

    Patient(){ id=0; name=""; bill=0; }

    Patient(int id,String name,double bill){
        this.id=id;
        this.name=name;
        this.bill=bill;
    }

    public double getBill(){ return bill; }

    public String toString(){
        return id+" | "+name+" | Bill: "+bill;
    }
}

public class PatientTest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter patients: ");
        int n=sc.nextInt();
        sc.nextLine();

        Patient[] p=new Patient[n];
        double total=0;

        for(int i=0;i<n;i++){
            System.out.print("ID: ");
            int id=sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String name=sc.nextLine();
            System.out.print("Bill: ");
            double b=sc.nextDouble();
            sc.nextLine();

            p[i]=new Patient(id,name,b);
            total+=b;
        }

        System.out.println("Total bill = "+total);
    }
}
