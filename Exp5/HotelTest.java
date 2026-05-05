package Exp5;
import java.util.Scanner;

class HotelRoom {

    private boolean booked;
    private static int available = 5;

    public HotelRoom() {
        booked = false;
    }

    public void bookRoom() {
        if (!booked && available > 0) {
            booked = true;
            available--;
            System.out.println("Room booked");
        } else {
            System.out.println("Cannot book");
        }
    }

    public void cancelBooking() {
        if (booked) {
            booked = false;
            available++;
            System.out.println("Cancelled");
        }
    }

    public static int availableRooms() {
        return available;
    }
}

public class HotelTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rooms to create: ");
        int n = sc.nextInt();

        HotelRoom[] arr = new HotelRoom[n];

        for(int i=0;i<n;i++) {
            arr[i] = new HotelRoom();

            System.out.print("Book room " + (i+1) + "? (1/0): ");
            int ch = sc.nextInt();

            if(ch == 1)
                arr[i].bookRoom();
        }

        System.out.println("Available rooms: " + HotelRoom.availableRooms());
    }
}