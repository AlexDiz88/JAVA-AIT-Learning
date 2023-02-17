import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Hotel paradise = new Hotel("Paradise",
                new Room(1, RoomType.LOW_COST, 16.6, 43),
                new Room(2, RoomType.STANDART, 21.2, 61),
                new Room(3, RoomType.STANDART, 22.6, 64),
                new Room(4, RoomType.LOW_COST, 18.2, 41),
                new Room(5, RoomType.APARTMENT, 33.0, 96),
                new Room(6, RoomType.LUX, 82.0, 440),
                new Room(7, RoomType.SUIT, 35.5, 125),
                new Room(8, RoomType.LOW_COST, 12.5, 35),
                new Room(9, RoomType.APARTMENT, 36.6, 105),
                new Room(10, RoomType.STANDART, 18.5, 54),
                new Room(11, RoomType.STUDIO, 29.0, 80),
                new Room(12, RoomType.STANDART, 23.3, 68),
                new Room(13, RoomType.LOW_COST, 14.7, 39),
                new Room(14, RoomType.STANDART, 20.0, 60),
                new Room(15, RoomType.SUIT, 44.1, 142),
                new Room(16, RoomType.LOW_COST, 19.1, 48),
                new Room(17, RoomType.STUDIO, 26.5, 71),
                new Room(18, RoomType.APARTMENT, 30.9, 88),
                new Room(19, RoomType.STUDIO, 32.8, 88),
                new Room(20, RoomType.LUX, 67.0, 315)
                );

        System.out.println("-----Заказ 1-----");

        // запрос клиента и его данные
        Person p1 = new Person("Pavel", "Bure", LocalDate.of(1985, 2, 11), "Berlin, MainStr.4");
        RoomType wishRoomType = RoomType.STANDART;
        LocalDate checkIn = LocalDate.of(2023,2,14);
        int accommodationDays = 7;

        // обработка запроса
        List<LocalDate> desiredDates = p1.notifyDesiredDates(checkIn, accommodationDays);
        List<Room> allRooms = paradise.getRooms();
        List<Room> standardRooms = paradise.getListOfRoomsByType(allRooms, wishRoomType);
        List<Room> listOfFreeRooms = paradise.getListOfFreeRoomsOnDates(standardRooms, desiredDates);

        // выдача доступных результатов с окончательной ценой
        paradise.printListOfRoomsWithPrice(listOfFreeRooms, desiredDates);

        // бронирование на основе выбора клиента
        System.out.println(paradise.booking(p1, 12, desiredDates));

        // второе брониование от того же клиента на другие даты
        List<LocalDate> desiredDates2 = p1.notifyDesiredDates(checkIn.plusDays(56), accommodationDays);
        System.out.println(paradise.booking(p1, 16, desiredDates2));

        System.out.println("\n-----неудачные попытки бронирования (по разным причинам)-----");
        allRooms.get(5).setRoomStatus(RoomStatus.UNDER_REPAIR); // бессрочный ремонт (неизвестны даты завершения ремонта)
        paradise.booking(p1, 6, desiredDates);
        allRooms.get(8).reserveDates(desiredDates, RoomStatus.ON_MAINTENANCE); // обслуживание комнаты на указанные даты делает бронирование недоступным
        paradise.booking(p1, 9, desiredDates);
        paradise.booking(p1, 12, desiredDates); // уже занятая комната на такие же даты

        System.out.println("\n-----история бронирований по клиенту-----");
        p1.printBookingHistory();
    }
}