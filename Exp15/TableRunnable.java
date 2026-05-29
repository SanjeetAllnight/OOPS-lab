package Exp15;

class TableThread implements Runnable {

    public void run() {

        for (int i = 1; i <= 10; i++) {

            System.out.println("5 x " + i + " = " + (5 * i));

            try {
                Thread.sleep(500);
            }

            catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class TableRunnable {

    public static void main(String[] args) {

        TableThread obj = new TableThread();

        Thread t = new Thread(obj);

        t.start();

        try {

            t.join();
        }

        catch (InterruptedException e) {

            System.out.println(e);
        }

        System.out.println("Table printed!");
    }
}