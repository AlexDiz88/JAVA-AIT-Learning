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

        System.out.println("-----Заказ №1-----");
        Person p1 = new Person("Ron", "Francis", LocalDate.of(1995, 7, 15), "95448, Berlin, Maxstr.78");
        LocalDate checkIn = LocalDate.of(2023, 2, 20);
        List<LocalDate> desiredDates = p1.notifyDatesRange(checkIn, 5);
        List<Room> availableRoomsOnDates = paradise.getAvailableRoomsOnDates(desiredDates);
        List<Room> roomsByType = paradise.getRoomsByType(availableRoomsOnDates, RoomType.APARTMENT);
        System.out.println("Список доступных комнат по запросам клиента на указанные даты:");
        paradise.printRoomsListWithCalculatedPriceForDesiredDates(roomsByType, desiredDates);
        p1.book(paradise, desiredDates, 5);

        System.out.println("\n-----Заказ №2-----");
        Person p2 = new Person("Petr", "Sykora", LocalDate.of(1992, 11, 22), "92456, München, Hauptstr.8");
        LocalDate checkIn2 = LocalDate.of(2023, 2, 14);
        List<LocalDate> desiredDates2 = p2.notifyDatesRange(checkIn2, 8);
        List<Room> availableRoomsOnDates2 = paradise.getAvailableRoomsOnDates(desiredDates2);
        List<Room> roomsByType2 = paradise.getRoomsByType(availableRoomsOnDates2, RoomType.LOW_COST);
        System.out.println("Список доступных комнат по запросам клиента на указанные даты:");
        paradise.printRoomsListWithCalculatedPriceForDesiredDates(roomsByType2, desiredDates2);
        p2.book(paradise, desiredDates2, 16);

        System.out.println("\n-----Заказ №3-----");
        Person p3 = new Person("Valeriy", "Kamenskih", LocalDate.of(1988, 6, 21), "17464, Colorado, MainAvenue 2");
        List<LocalDate> desiredDates3 = p2.notifyDatesRange(checkIn.minusDays(2), 4);
        List<Room> availableRoomsOnDates3 = paradise.getAvailableRoomsOnDates(desiredDates3);
        List<Room> roomsByType3 = paradise.getRoomsByType(availableRoomsOnDates3, RoomType.APARTMENT);
        System.out.println("Список доступных комнат по запросам клиента на указанные даты:");
        paradise.printRoomsListWithCalculatedPriceForDesiredDates(roomsByType3, desiredDates3); // в списке нет номера, занятого первым клиентом
        p3.book(paradise, desiredDates3, 5); //попытка забронировать тот же номер, что у первого клиента (пересечение дат)

        System.out.println("\n-----Заказ №4-----");
        LocalDate checkIn4 = LocalDate.of(2023, 3, 21);
        List<LocalDate> desiredDates4 = p2.notifyDatesRange(checkIn4, 5);
        List<Room> availableRoomsOnDates4 = paradise.getAvailableRoomsOnDates(desiredDates4);
        List<Room> roomsByType4 = paradise.getRoomsByType(availableRoomsOnDates4, RoomType.LUX);
        System.out.println("Список доступных комнат по запросам клиента на указанные даты:");
        paradise.printRoomsListWithCalculatedPriceForDesiredDates(roomsByType4, desiredDates4);
        p2.book(paradise, desiredDates4, 20); // второй заказ от одного клиента


        System.out.println("\n------------Проверка других опций------------");
        paradise.getRoomByNumber(3).setRoomStatus(RoomStatus.ON_MAINTENANCE);
        paradise.getRoomByNumber(12).setRoomStatus(RoomStatus.UNDER_REPAIR);
        List<Room> availableRoomsByType = paradise.getAvailableRoomsByType(paradise.getAllRooms(), RoomType.STANDART); // не показывает комнаты находящиеся на ремонте/тех.обслуживании
        paradise.printRoomsList(availableRoomsByType);
        System.out.println("----------------");
        p2.printClientBookingHistory(); // список всех бронирований от одного клиента
    }
}