import db.MockDb;
import entity.BankAcc;
import entity.Order;
import entity.OrderStatus;
import entity.User;
import mapper.BankAccMapper;
import mapper.UserMapper;
import model.CsvRowModel;
import reader.CsvReader;
import service.BankAccService;
import service.OrderService;
import service.UserService;

import java.util.*;

/**
 * @author Andrej Reutow
 * created on 21.01.2023
 */
public class Main {
    private static final int IBAN_LENGTH = 14;
    private static final String KONTO_NR_KEY = "KontoNr";
    private static final String BANK_ID_KEY = "BankId";
    private static final int KONTO_LENGTH = 8;

    static MockDb mockDb = new MockDb();
    static BankAccService bankAccService = new BankAccService(mockDb);
    static OrderService orderService = new OrderService(mockDb);
    static UserService userService = new UserService(mockDb);

    public static void main(String[] args) {
//        ArrayList<String> file = CsvReader.readFile();
        List<List<String>> files = CsvReader.readFiles();

        String fileName = "File";
        for (List<String> file : files) {
            Order order = new Order();
            orderService.save(order);
            List<CsvRowModel> csvRowsModels = new LinkedList<>();
            for (int rowNumber = 1; rowNumber < file.size() + 1; rowNumber++) {
                String[] columnsOfRowAsArray = file.get(rowNumber - 1).split(";");
//                List<String> columnsOfRow = List.of(columnsOfRowAsArray);
                List<String> columnsOfRow = Arrays.asList(columnsOfRowAsArray);
                ArrayList<String> errors = new ArrayList<>();
                if (columnsOfRow.size() != KONTO_LENGTH) {
                    order.setOrderStatus(OrderStatus.INVALID);
                    errors.add("Line: " + rowNumber + ". Error: Number of columns is not correct");
                    continue;
                }
                CsvRowModel rowModel = new CsvRowModel(columnsOfRow, errors, rowNumber);
                csvRowsModels.add(rowModel);
                if (!errors.isEmpty()) {
                    order.setOrderStatus(OrderStatus.INVALID);
                    continue;
                }
                //todo fix it
                Map<String, Long> kontoDetails = getKontoDetails(rowModel);
                if (!errors.isEmpty() || kontoDetails == null) {
                    order.setOrderStatus(OrderStatus.INVALID);
                    continue;
                }
                Long kontoNr = kontoDetails.get(KONTO_NR_KEY);
                Long bankId = kontoDetails.get(BANK_ID_KEY);
                User user = UserMapper.mapFromCsvModelToUser(rowModel, order);
                order.getUsersByOrder().add(user);
                BankAcc bankAcc = BankAccMapper.mapFromCsvModelToBankAcc(rowModel, user, kontoNr, bankId, order);
                user.addBankAcc(bankAcc);
                order.setOrderStatus(OrderStatus.VALID);
                bankAccService.save(bankAcc);
                userService.save(user);
            }
//            System.out.println("File " + fileName + "_" + order.getId());
//            for (CsvRowModel csvRowsModel : csvRowsModels) {
//                System.out.println(csvRowsModel.printReportMessage());
//            }
        }

        //get all and print Orders
        List<Order> allOrders = getAllOrders();
        for (Order order : allOrders) {
            Map<Order, List<User>> orderListMap = userService.groupAllByOrder(order);
            System.out.printf("Order id '%d' \n", order.getId());
            List<User> userListByOrder = orderListMap.get(order);
            for (User user : userListByOrder) {
                List<BankAcc> bankAccList = user.getBankAccList();
                for (BankAcc bankAcc : bankAccList) {
                    System.out.printf("User %s -> %s \n", user.getFirstName(), bankAcc);
                }
            }
        }

        System.out.println("------------------------");

        // проверка работы метода groupAllByOrder()
        Map<Order, List<User>> orderListMap = userService.groupAllByValidOrders();
        for (Map.Entry<Order, List<User>> entry : orderListMap.entrySet()) {
            System.out.println(entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println(user);
            }
            System.out.println("------------------------");
        }

        // проверка работы метода groupAllByOrderStatus()
        Map<OrderStatus, Map<Order, List<User>>> orderStatusMap = userService.groupAllByOrderStatus();
        System.out.println("*****");
        System.out.println(orderStatusMap);
        System.out.println("*****");
        Set<OrderStatus> orderStatuses = orderStatusMap.keySet();
        for (OrderStatus orderStatus : orderStatuses) {
            System.out.println(orderStatus);
            Map<Order, List<User>> map = orderStatusMap.get(orderStatus);
            Set<Map.Entry<Order, List<User>>> entrySet = map.entrySet();
            for (Map.Entry<Order, List<User>> entry : entrySet) {
                System.out.println(entry.getKey());
                List<User> users = entry.getValue();
                for (User user : users) {
                    System.out.println(user);
                }
            }
            System.out.println("---------");
        }
    }

    private static List<Order> getAllOrders() {
        return orderService.getAll();
    }

    private static Map<String, Long> getKontoDetails(CsvRowModel rowModel) {
        //      iban =  50010094569875
        String ibanAsString = String.valueOf(rowModel.getIban());
        if (ibanAsString.length() != IBAN_LENGTH) {
            List<String> errors = rowModel.getErrors();
            errors.add("LineNr: " + rowModel.getRowNumber() + ". Iban length is not allowed. Expected length: "
                    + IBAN_LENGTH + ", Actually Length: " + ibanAsString.length());
            return null;
        }
        //      ibanAsString =  "50010094569875"
        String kontoNrAsString = ibanAsString.substring(0, KONTO_LENGTH);
        //      ibanAsString    =  "50010094569875"
        //      kontoNrAsString =  "50010094"
        String bankIdAsString = ibanAsString.substring(KONTO_LENGTH);
        //      ibanAsString    =  "50010094569875"
        //      kontoNrAsString =  "50010094"
        //      bankIdAsString =  "569875"

        Long kontoNr = Long.parseLong(kontoNrAsString);
        Long banId = Long.parseLong(bankIdAsString);
        //     long kontoNr =  50010094
        //     long banId =  569875
        Map<String, Long> result = new HashMap<>();
        result.put(KONTO_NR_KEY, kontoNr);
        result.put(BANK_ID_KEY, banId);
        return result;
    }

    private static void printErrors(ArrayList<String> errors) {
        System.out.println(errors);
    }
}


//0	FirstName	User
//1	LastName	User
//2	Address	User
//3	INDEX	User
//4	TEL	User

//5	IBAN	BankAcc
//6	Balance	BankAcc
//7	CREDIT	Tspe        C
