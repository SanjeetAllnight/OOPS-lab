package Exp4;
import java.util.Scanner;

class Movie {
    private String name;
    private String director;
    private double rating;

    Movie() {
        name = "";
        director = "";
        rating = 0;
    }

    Movie(String name, String director, double rating) {
        this.name = name;
        this.director = director;
        this.rating = rating;
    }

    public void setName(String name) { this.name = name; }
    public void setDirector(String director) { this.director = director; }
    public void setRating(double rating) { this.rating = rating; }

    public double getRating() { return rating; }

    public String toString() {
        return name + " | " + director + " | Rating: " + rating;
    }
}

public class MovieTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of movies: ");
        int n = sc.nextInt();
        sc.nextLine();

        Movie[] m = new Movie[n];

        for(int i=0;i<n;i++) {
            System.out.println("Movie "+(i+1));
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Director: ");
            String dir = sc.nextLine();
            System.out.print("Rating: ");
            double r = sc.nextDouble();
            sc.nextLine();

            m[i] = new Movie(name, dir, r);
        }

        System.out.println("Rating > 4:");
        for(Movie x : m)
            if(x.getRating() > 4)
                System.out.println(x);
            else
                System.out.println("None!");
    }
}
