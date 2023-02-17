import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String address;
    private List<Booking> clientBookingHistory = new ArrayList<>();

    public Person(String firstName, String lastName, LocalDate dateOfBirth, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public List<LocalDate> notifyDesiredDates(LocalDate checkIn, int accommodationDays) {
        if (checkIn == null || accommodationDays <= 0) return null;
        List<LocalDate> res = new ArrayList<>();
        for (int i = 0; i < accommodationDays; i++) {
            res.add(checkIn.plusDays(i));
        }
        return res;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + dateOfBirth + ", " + address;
    }

    public void printBookingHistory() {
        System.out.println(this + "\nBooking history:");
        for (Booking booking : clientBookingHistory) {
            System.out.println(booking.bookingInfo());
        }
    }

    public List<Booking> getClientBookingHistory() {
        return clientBookingHistory;
    }
}
