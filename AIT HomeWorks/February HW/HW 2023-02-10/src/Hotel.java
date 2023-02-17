import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hotel {

    private String title;
    private List<Room> rooms = new ArrayList<>();

    public Hotel(String title, Room... rooms) {
        this.title = title;
        this.rooms.addAll(Arrays.asList(rooms));
    }

    public List<Room> getAvailableRoomsOnDates(List<LocalDate> desiredDates) {
        List<Room> freeRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.checkRoomStatusForDateRange(desiredDates) == RoomStatus.AVAILABLE) {
                freeRooms.add(room);
            }
        }
        return freeRooms;
    }

    public List<Room> getRoomsByType(List<Room> rooms, RoomType roomType) {
        List<Room> roomsByType = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getRoomType() == roomType) {
                roomsByType.add(room);
            }
        }
        return roomsByType;
    }

    public List<Room> getAvailableRoomsByType(List<Room> rooms, RoomType roomType) {
        List<Room> availableRoomsByType = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getRoomStatus() == RoomStatus.AVAILABLE && room.getRoomType() == roomType) {
                availableRoomsByType.add(room);
            }
        }
        return availableRoomsByType;
    }

    public void printRoomsListWithCalculatedPriceForDesiredDates(List<Room> rooms, List<LocalDate> desiredDates) {
        for (Room room : rooms) {
            System.out.println(room + ". Total price = " + calculatePrice(room, desiredDates.size()));
        }
    }

    public double calculatePrice(Room room, int totalDays) {
        return room.getPriceForNight() * totalDays;
    }

    public Room getRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getNum() == roomNumber) return room;
        }
        return null;
    }

    @Override
    public String toString() {
        System.out.println("---Welcome to the Hotel " + title + "---");
        printAllRooms();
        return "";
    }

    public void printAllRooms() {
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    public void printRoomsList(List<Room> rooms) {
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    public String getTitle() {
        return title;
    }

    public void addNewRoomsToHotel(Room... rooms) {
        this.rooms.addAll(Arrays.asList(rooms));
    }

    public List<Room> getAllRooms() {
        return rooms;
    }
}
