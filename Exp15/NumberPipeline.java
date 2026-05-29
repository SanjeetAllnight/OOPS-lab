package Exp15;

class SharedData {

    int number;

    boolean available = false;

    public synchronized void generate(int num) {

        while (available) {

            try {

                wait();
            }

            catch (InterruptedException e) {

                System.out.println(e);
            }
        }

        number = num;

        available = true;

        notify();
    }

    public synchronized int consume() {

        while (!available) {

            try {

                wait();
            }

            catch (InterruptedException e) {

                System.out.println(e);
            }
        }

        int value = number;

        available = false;

        notify();

        return value;
    }
}

class Generator extends Thread {

    SharedData data;

    public Generator(SharedData data) {

        this.data = data;
    }

    public void run() {

        for (int i = 1; i <= 5; i++) {

            System.out.println("Generated: " + i);

            data.generate(i);
        }
    }
}

class Printer extends Thread {

    SharedData data;

    public Printer(SharedData data) {

        this.data = data;
    }

    public void run() {

        for (int i = 1; i <= 5; i++) {

            int num = data.consume();

            System.out.println("Doubled: " + (num * 2));
        }
    }
}

public class NumberPipeline {

    public static void main(String[] args) {

        SharedData data = new SharedData();

        Generator g = new Generator(data);

        Printer p = new Printer(data);

        g.start();

        p.start();
    }
}