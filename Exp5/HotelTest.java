package Exp5;
class HotelRoom {
    private boolean booked;
    private static int available = 10;   // total rooms
    public HotelRoom() {
        booked = false;
    }
    public void bookRoom() {
        if (!booked && available > 0) {
            booked = true;
            available--;
            System.out.println("Room booked");
        } else {
            System.out.println("Cannot book room");
        }
    }
    public void cancelBooking() {
        if (booked) {
            booked = false;
            available++;
            System.out.println("Booking cancelled");
        } else {
            System.out.println("Room was not booked");
        }
    }
    public static int availableRooms() {
        return available;
    }
}
public class HotelTest {
    public static void main(String[] args) {
        HotelRoom r1 = new HotelRoom();
        HotelRoom r2 = new HotelRoom();
        r1.bookRoom();
        r2.bookRoom();
        System.out.println("Available rooms: " + HotelRoom.availableRooms());
        r1.cancelBooking();
        System.out.println("Available rooms: " + HotelRoom.availableRooms());
    }
}