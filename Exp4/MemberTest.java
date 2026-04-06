package Exp4;
import java.util.Scanner;

class Member {
    private int id;
    private String name;
    private int books;

    Member() { id=0; name=""; books=0; }

    Member(int id,String name,int books){
        this.id=id;
        this.name=name;
        this.books=books;
    }

    public int getBooks(){ return books; }

    public String toString(){
        return id+" | "+name+" | Books: "+books;
    }
}

public class MemberTest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter members: ");
        int n=sc.nextInt();
        sc.nextLine();

        Member[] a=new Member[n];

        for(int i=0;i<n;i++){
            System.out.print("ID: ");
            int id=sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String name=sc.nextLine();
            System.out.print("Books issued: ");
            int b=sc.nextInt();
            sc.nextLine();
            a[i]=new Member(id,name,b);
        }

        System.out.println("Books > 3:");
        for(Member m:a)
            if(m.getBooks()>3)
                System.out.println(m);
    }
}
