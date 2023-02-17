import entity.Order;
import entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {

    public static void splitCsv(List<String> list) {
        Order order = new Order();
        long orderId = order.getId();
        for (String row : list) {
            List<String> splitRow = Utils.splitRow(row);
            if (splitRow != null) {
                System.out.println(createUser(splitRow, orderId));
            } else {
                System.out.println("Can't create User");
            }
        }

    }

    private static List<String> splitRow(String s) {
        String[] split = s.split(";");
        try {
            if (split.length != 8) {
                throw new WrongLengthOfRow();
            }
        } catch (WrongLengthOfRow e) {
            System.out.println("Неверный формат строки");
            return null;
        }
        return new ArrayList<>(Arrays.asList(split));
    }

    private static User createUser(List<String> row, long orderId) {
        String firstName = row.get(0);
        String lastName = row.get(1);
        String address = row.get(2);
        int postCode = Integer.parseInt(row.get(3));
        String phoneNumber = row.get(4);
        return new User(firstName, lastName, address, postCode, phoneNumber, orderId);
    }
}
