import java.time.LocalDate;

public class Booking {

    private Hotel hotel;
    private Room room;
    private LocalDate checkIn;
    private LocalDate checkOut;
    double price;

    public Booking(Hotel hotel, Room room, LocalDate checkIn, LocalDate checkOut, double bookingPrice) {
        this.hotel = hotel;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.price = bookingPrice;
    }

    @Override
    public String toString() {
        return "Hotel " + hotel.getTitle() + ". Room:" + room.getNum() + ", from:" + checkIn + "/to:" + checkOut + ". Total price = " + price + " €";
    }
}
