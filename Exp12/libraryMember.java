package Exp12;

import java.io.*;
import java.util.*;

public class libraryMember {

    static class Member {

        private int memberId;
        private String name;
        private int booksIssued;

        public Member() {}

        public Member(int memberId, String name, int booksIssued) {
            this.memberId = memberId;
            this.name = name;
            this.booksIssued = booksIssued;
        }

        public void setMemberId(int memberId) {
            this.memberId = memberId;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setBooksIssued(int booksIssued) {
            this.booksIssued = booksIssued;
        }

        public int getMemberId() {
            return memberId;
        }

        public String getName() {
            return name;
        }

        public int getBooksIssued() {
            return booksIssued;
        }

        public String toString() {
            return memberId + " | " + name + " | " + booksIssued;
        }
    }

    public static void main(String[] args) {

        File inputFile = new File("members.txt");
        File outputFile = new File("output_members.txt");

        ArrayList<Member> list = new ArrayList<>();

        try {

            if (!inputFile.exists()) {
                System.out.println("Input file not found");
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(inputFile));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                Member m = new Member(
                        Integer.parseInt(data[0]),
                        data[1],
                        Integer.parseInt(data[2])
                );

                list.add(m);
            }

            br.close();

            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

            for (Member m : list) {

                if (m.getBooksIssued() > 3) {
                    bw.write(m.toString());
                    bw.newLine();
                }
            }

            bw.close();

            System.out.println("Output written to output_members.txt");

        }

        catch (IOException e) {
            System.out.println("File Error");
        }
    }
}