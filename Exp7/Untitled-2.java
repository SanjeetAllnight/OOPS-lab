/*
Calculator with Overloading: Create a class Calculator and include
the following:
a. Instance Methods:
i. add(int a, int b): Returns sum of two integers.
ii. add(double a, double b): Returns sum of two doubles.
iii. multiply(int a, int b): Returns product of two integers.
iv. multiply(double a, double b): Returns product of two
doubles.
b. Static Method:
i. displayMenu(): Displays calculator options.
*/

import java.util.Scanner;
class Calculator{
    double a;
    double b;

    Calculator (double a, double b){
        this.a=a;
        this.b=b;
    }

    int add (int a , int b){
        return a+b;
    }
    double add (double a , double b){
        return a+b;
    }
    int multiply (int a,int b){
        return a*b;
    }
    double multiply (double a, double b){
        return a*b;
    }
    public static displayMenu(){
        System.out.println("")
    }
}
Class calcidemo {
    public static void main(String args []){
        Scanner sc = new Scanner(System.in);
        Calculator c = new Calculator ();

        Calculator.displayMenu();
        System.out.println("Enter choice: ");
        int e = sc.nextInt();

        switch (e){
            case 1 :

                res1=c.add(a,b)
                break;
            default:
                System.out.println("Invalid Choice!");
        }
        sc.close();
    }
}