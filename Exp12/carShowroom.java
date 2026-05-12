package Exp12;

import java.io.*;
import java.util.*;

public class carShowroom {

    static class Car {

        private String model;
        private double price;
        private double mileage;

        public Car() {}

        public Car(String model, double price, double mileage) {
            this.model = model;
            this.price = price;
            this.mileage = mileage;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setMileage(double mileage) {
            this.mileage = mileage;
        }

        public String getModel() {
            return model;
        }

        public double getPrice() {
            return price;
        }

        public double getMileage() {
            return mileage;
        }

        public String toString() {
            return model + " | " + price + " | " + mileage;
        }
    }

    public static void main(String[] args) {

        File inputFile = new File("cars.txt");
        File outputFile = new File("output_cars.txt");

        ArrayList<Car> list = new ArrayList<>();

        try {

            if (!inputFile.exists()) {
                System.out.println("Input file not found");
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(inputFile));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                Car c = new Car(
                        data[0],
                        Double.parseDouble(data[1]),
                        Double.parseDouble(data[2])
                );

                list.add(c);
            }

            br.close();

            Car max = list.get(0);

            for (Car c : list) {

                if (c.getPrice() > max.getPrice()) {
                    max = c;
                }
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

            bw.write("Most Expensive Car:");
            bw.newLine();
            bw.write(max.toString());

            bw.close();

            System.out.println("Output written to output_cars.txt");

        }

        catch (IOException e) {
            System.out.println("File Error");
        }
    }
}