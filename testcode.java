import java.util.Scanner;

class Innertestcode {
    int innertestcodevar;

    void innertestcodefunction(){

    }
    
}
class Innertestcode2 extends Innertestcode{
    
}



public class testcode {

    static void displayFurys(){
        System.out.println("Fury");
    }

    void displayFury(){
        System.out.println("Fury");
    }
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();

        int [] arr = new int [n];
        for (int i = 0; i<n; i++){
            arr[i]=sc.nextInt();
        }

        String s= "Sanjeet";

        for (int i + s.length() -1; i>=0; i--){
            
        }

        Innertestcode i = new Innertestcode();
        i.innertestcodevar=69;
        i.innertestcodefunction();

        i.displayFury();

        testcode.displayFurys();

        //Overloading is same name but change in no. of parameters/arguements accepted
        


    }
}