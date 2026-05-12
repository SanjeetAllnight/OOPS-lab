package Exp11;

import java.util.LinkedList;
import java.util.HashSet;
import java.util.Scanner;

public class linkedlist {

    static class NumberList {

        private LinkedList<Integer> list;

        public NumberList() {
            list = new LinkedList<>();
        }

        public NumberList(LinkedList<Integer> list) {
            this.list = list;
        }

        public void setList(LinkedList<Integer> list) {
            this.list = list;
        }

        public LinkedList<Integer> getList() {
            return list;
        }

        public void removeDuplicates() {

            HashSet<Integer> set = new HashSet<>();

            LinkedList<Integer> newList = new LinkedList<>();

            for (Integer x : list) {

                if (!set.contains(x)) {
                    set.add(x);
                    newList.add(x);
                }
            }

            list = newList;
        }

        public String toString() {
            return "List: " + list;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedList<Integer> l = new LinkedList<>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            l.add(sc.nextInt());
        }

        NumberList obj = new NumberList(l);

        System.out.println("Before: " + obj);

        obj.removeDuplicates();

        System.out.println("After: " + obj);
    }
}