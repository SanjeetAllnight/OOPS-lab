package Exp11;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Vector;

public class vectorFrequency {

    static class Student {

        private String name;
        private char grade;

        public Student() {}

        public Student(String name, char grade) {
            this.name = name;
            this.grade = grade;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setGrade(char grade) {
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public char getGrade() {
            return grade;
        }

        public String toString() {
            return name + " | " + grade;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Vector<Student> vec = new Vector<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter grade: ");
            char grade = sc.next().charAt(0);
            sc.nextLine();

            Student s = new Student(name, grade);

            vec.add(s);
        }

        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        for (Student s : vec) {

            char g = s.getGrade();

            if (map.containsKey(g)) {
                map.put(g, map.get(g) + 1);
            }

            else {
                map.put(g, 1);
            }
        }

        System.out.println("Grade Summary:");

        for (Character g : map.keySet()) {
            System.out.println(g + " -> " + map.get(g));
        }
    }
}