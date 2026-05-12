package Exp12;

import java.io.*;
import java.util.*;

public class movieCollection {

    static class Movie {

        private String name;
        private String director;
        private double rating;

        public Movie() {}

        public Movie(String name, String director, double rating) {
            this.name = name;
            this.director = director;
            this.rating = rating;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public String getName() {
            return name;
        }

        public String getDirector() {
            return director;
        }

        public double getRating() {
            return rating;
        }

        public String toString() {
            return name + " | " + director + " | " + rating;
        }
    }

    public static void main(String[] args) {

        File inputFile = new File("movies.txt");
        File outputFile = new File("output_movies.txt");

        ArrayList<Movie> list = new ArrayList<>();

        try {

            if (!inputFile.exists()) {
                System.out.println("Input file not found");
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(inputFile));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                Movie m = new Movie(
                        data[0],
                        data[1],
                        Double.parseDouble(data[2])
                );

                list.add(m);
            }

            br.close();

            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

            for (Movie m : list) {

                if (m.getRating() > 4) {
                    bw.write(m.toString());
                    bw.newLine();
                }
            }

            bw.close();

            System.out.println("Output written to output_movies.txt");

        }

        catch (IOException e) {
            System.out.println("File Error");
        }
    }
}