import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hotel {

    private String title;
    private List<Room> rooms = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public Hotel(String title, Room... rooms) {
        this.title = title;
        this.rooms.addAll(Arrays.asList(rooms));
    }

    public Hotel(String title, List<Room> rooms) {
        this.title = title;
        this.rooms = rooms;
    }

    public Booking booking(Person person, int roomNumber, List<LocalDate> desiredDates) {
        if (person == null || roomNumber <= 0 || roomNumber > rooms.size() || desiredDates == null || desiredDates.isEmpty()) {
            System.out.println("Ошибка бронирования");
            return null;
        }
        Room room = getRoomByNumber(roomNumber);
        if (room.getRoomStatus() == RoomStatus.UNDER_REPAIR || room.checkRoomStatus(desiredDates) == RoomStatus.UNDER_REPAIR) {
            System.out.println("Комната на ремонте");
            return null;
        }
        if (room.getRoomStatus() == RoomStatus.ON_MAINTENANCE || room.checkRoomStatus(desiredDates) == RoomStatus.ON_MAINTENANCE) {
            System.out.println("Комната на обслуживании");
            return null;
        }
        if (room.getRoomStatus() == RoomStatus.RESERVED || room.checkRoomStatus(desiredDates) == RoomStatus.RESERVED) {
            System.out.println("Комната уже забронирована");
            return null;
        }
        LocalDate checkIn = desiredDates.get(0);
        LocalDate checkOut = desiredDates.get(desiredDates.size()-1);
        double price = room.calculatePrice(desiredDates);
        room.reserveDates(desiredDates, RoomStatus.RESERVED);
        Booking booking = new Booking(this, room, person, checkIn, checkOut, price);
        this.bookings.add(booking);
        person.getClientBookingHistory().add(booking);
        System.out.println("Бронирование прошло успешно!");
        return booking;
    }

    public List<Room> getListOfRoomsByType(List<Room> roomList, RoomType roomType) {
        List<Room> res = new ArrayList<>();
        for (Room room : roomList) {
            if (room.getRoomType() == roomType) {
                res.add(room);
            }
        }
        return res;
    }

    public List<Room> getListOfFreeRoomsOnDates(List<Room> roomList, List<LocalDate> desiredDates) {
        List<Room> res = new ArrayList<>();
        for (Room room : roomList) {
            if (room.checkRoomStatus(desiredDates) == RoomStatus.AVAILABLE) {
                res.add(room);
            }
        }
        return res;
    }

    public void printListOfRoomsWithPrice(List<Room> roomList, List<LocalDate> desiredDates) {
        for (Room room : roomList) {
            System.out.println(room + ". Total price = " + room.calculatePrice(desiredDates));
        }
    }

    public Room getRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getNum() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        System.out.println("---Welcome to " + title + "!---");
        for (Room room : rooms) {
            System.out.println(room);
        }
        return "";
    }

    public String getTitle() {
        return title;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Booking> getBookings() {
        return bookings;
    }
}
