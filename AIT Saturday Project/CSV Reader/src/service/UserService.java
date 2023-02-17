package service;

import db.MockDb;
import entity.Order;
import entity.OrderStatus;
import entity.User;

import java.util.*;

/**
 * @author Andrej Reutow
 * created on 28.01.2023
 */
public class UserService implements IService<User> {

    private MockDb db;

    public UserService(MockDb db) {
        this.db = db;
    }

    @Override
    public void save(User entity) {
        db.persist(entity);
    }

    @Override
    public User get(long id) {
        return db.getUser(id);
    }

    @Override
    public List<User> getAll() {
        return db.getUsers();
    }

    public Map<Order, List<User>> groupAllByOrder(Order order) {
        List<User> users = db.getUsers();
        Map<Order, List<User>> orderMap = new HashMap<>();

        if (order == null || !order.getOrderStatus().equals(OrderStatus.VALID)) {
            orderMap.put(order, new ArrayList<>());
            return orderMap;
        }

        for (User user : users) {
            if (user.getOrder() != null && user.getOrder().equals(order)) {
                List<User> defaultList = orderMap.getOrDefault(order, new ArrayList<>());
                defaultList.add(user);
                orderMap.put(order, defaultList);
            }
        }
        return orderMap;
    }

    //todo сгруппировать список user в HashMap по всем доступным Order.
    // Статус Order (OrderStatus) должен быть строго только OrderStatus.VALID

    // Метод с OrderStatus.INVALID точно такой же, кроме if. Не стал его скидывать.
    // Еще нашел ошибку в логике присваивания статуса для Order. Если в нашем файле первая строка INVALID,
    // а вторая строка VALID, то статус Order будет в итоге VALID, ... и наоборот.
    // Другими словами Order получает статус только по последней строке в файле и игнорирует предыдущие значения.
    public Map<Order, List<User>> groupAllByValidOrders() {
        Map<Order, List<User>> orderMap = new HashMap<>();
        List<Order> allOrders = db.getOrders();
        for (Order order : allOrders) {
            if (order.getOrderStatus() == OrderStatus.VALID) {
                List<User> userListByOrder = orderMap.getOrDefault(order, new ArrayList<>());
                // тут мне не нравится бежать по всей базе юзеров, перебирая каждого и смотреть idOrder к которому он привязан,
                // поэтому я решил что намного эффективнее в entity Order добавить поле List<User> и
                // добавлять их в этот список в Main сразу после создания там entity User, а сюда через геттер просто скопировать весь список.
                userListByOrder.addAll(order.getUsersByOrder());
                orderMap.put(order, userListByOrder);
            }
        }
        return orderMap;
    }

    // в мэпе мэпа в которой лист юзеров :)
    public Map<OrderStatus, Map<Order, List<User>>> groupAllByOrderStatus() {
        Map<OrderStatus, Map<Order, List<User>>> statusMap = new HashMap<>();
        List<Order> allOrders = db.getOrders();
        OrderStatus[] allOrderStatuses = OrderStatus.values();
        for (OrderStatus status : allOrderStatuses) {
            statusMap.put(status, new HashMap<>());
        }
        for (Order order : allOrders) {
            OrderStatus orderStatus = order.getOrderStatus();
            Map<Order, List<User>> orderMap = statusMap.getOrDefault(orderStatus, new HashMap<>());
            List<User> userList = orderMap.getOrDefault(order, new ArrayList<>());
            userList.addAll(order.getUsersByOrder());
            orderMap.put(order, userList);
        }
        return statusMap;
    }
}
