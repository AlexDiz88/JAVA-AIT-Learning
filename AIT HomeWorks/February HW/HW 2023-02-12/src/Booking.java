import java.time.LocalDate;

public class Booking {

    private Hotel hotel;
    private Room room;

    private Person person;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private double price;

    public Booking(Hotel hotel, Room room, Person person, LocalDate checkIn, LocalDate checkOut, double price) {
        this.hotel = hotel;
        this.room = room;
        this.person = person;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Hotel " + hotel.getTitle() + ". Room:" + room.getNum() + ", from:" + checkIn + "/to:" + checkOut + ". Total price = " + price + " €. " + "Client: " + person;
    }

    public String bookingInfo() {
        return "Hotel " + hotel.getTitle() + ". Room:" + room.getNum() + ", from:" + checkIn + "/to:" + checkOut + ". Total price = " + price + " €.";
    }
}
