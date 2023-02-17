import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private int num;
    private RoomType roomType;
    private double squareArea;
    private double priceForNight;
    private RoomStatus roomStatus;
    private List<LocalDate> reservedOnDates = new ArrayList<>();

    public Room(int num, RoomType roomType, double squareArea, double priceForNight) {
        this.num = num;
        this.roomType = roomType;
        this.squareArea = squareArea;
        this.priceForNight = priceForNight;
        this.roomStatus = RoomStatus.AVAILABLE;
    }

    public RoomStatus checkRoomStatusForDateRange(List<LocalDate> desiredDates) {
        if (roomStatus == RoomStatus.UNDER_REPAIR) return RoomStatus.UNDER_REPAIR;
        if (roomStatus == RoomStatus.ON_MAINTENANCE) return RoomStatus.ON_MAINTENANCE;
        for (LocalDate date : desiredDates) {
            if (reservedOnDates.contains(date)) {
                return RoomStatus.RESERVED;
            }
        }
        return RoomStatus.AVAILABLE;
    }

    public void reserveRoomForDatesRange(List<LocalDate> desiredDates) {
        reservedOnDates.addAll(desiredDates);
    }

    @Override
    public String toString() {
        return num + ". " + roomType + "(" + squareArea + " qm) - " + priceForNight + " €/night";
    }

    public int getNum() {
        return num;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public double getPriceForNight() {
        return priceForNight;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }
}
