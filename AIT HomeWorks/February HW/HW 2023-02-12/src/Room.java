import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {

    private int num;
    private RoomType roomType;
    private double area;
    private double priceForNight;
    private RoomStatus roomStatus;
    private Map<LocalDate, RoomStatus> reservedDates = new HashMap<>();

    public Room(int num, RoomType roomType, double area, double priceForNight) {
        this.num = num;
        this.area = area;
        this.priceForNight = priceForNight;
        this.roomType = roomType;
        this.roomStatus = RoomStatus.AVAILABLE;
    }

    public RoomStatus checkRoomStatus(List<LocalDate> desiredDates) {
        if (roomStatus == RoomStatus.UNDER_REPAIR) return RoomStatus.UNDER_REPAIR;
        if (roomStatus == RoomStatus.ON_MAINTENANCE) return RoomStatus.ON_MAINTENANCE;
        for (LocalDate date : desiredDates) {
            if (reservedDates.containsKey(date)) {
                return reservedDates.get(date);
            }
        }
        return RoomStatus.AVAILABLE;
    }

    public void reserveDates(List<LocalDate> dates, RoomStatus roomStatus) {
        for (LocalDate date : dates) {
            reservedDates.put(date, roomStatus);
        }
    }

    public double calculatePrice(List<LocalDate> dates) {
        return priceForNight * dates.size();
    }

    @Override
    public String toString() {
        return num + ". " + roomType + "(" + area + " qm) - " + priceForNight + " €/night";
    }

    public int getNum() {
        return num;
    }

    public double getArea() {
        return area;
    }

    public double getPriceForNight() {
        return priceForNight;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public Map<LocalDate, RoomStatus> getReservedDates() {
        return reservedDates;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }
}
