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

    public List<LocalDate> notifyDatesRange(LocalDate checkIn, int daysAccommodation) {
        if (checkIn == null || daysAccommodation <= 0) return null;
        List<LocalDate> desiredDates = new ArrayList<>();
        for (int i = 0; i < daysAccommodation; i++) {
            desiredDates.add(checkIn.plusDays(i));
        }
        return desiredDates;
    }

    public boolean book(Hotel hotel, List<LocalDate> desiredDates, int roomNumber) {
        if (hotel == null || desiredDates == null || desiredDates.isEmpty() || hotel.getRoomByNumber(roomNumber) == null) {
            System.out.println("Ошибка бронирования номера");
            return false;
        }
        Room bookedRoom = hotel.getRoomByNumber(roomNumber);
        RoomStatus roomStatus = bookedRoom.checkRoomStatusForDateRange(desiredDates);
        if (roomStatus == RoomStatus.ON_MAINTENANCE) {
            System.out.println("Бронирование невозможно. Номер находится на тех.обслуживании");
            return false;
        }
        if (roomStatus == RoomStatus.UNDER_REPAIR) {
            System.out.println("Бронирование невозможно. Номер находится на ремонте");
            return false;
        }
        if (roomStatus != RoomStatus.AVAILABLE) {
            System.out.println("Бронирование невозможно. На эти даты номер уже занят");
            return false;
        }
        LocalDate checkIn = desiredDates.get(0);
        LocalDate checkOut = desiredDates.get(desiredDates.size() - 1);
        bookedRoom.reserveRoomForDatesRange(desiredDates);
        double bookingPrice = hotel.calculatePrice(bookedRoom, desiredDates.size());
        clientBookingHistory.add(new Booking(hotel, bookedRoom, checkIn, checkOut, bookingPrice));
        System.out.println("Номер " + bookedRoom.getNum() + " успешно забронирован клиентом: " + firstName + " "
                + lastName + " c " + checkIn + " по " + checkOut);
        return true;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + dateOfBirth;
    }

    public void printClientBookingHistory() {
        for (Booking booking : clientBookingHistory) {
            System.out.println(booking);
        }
    }
}
