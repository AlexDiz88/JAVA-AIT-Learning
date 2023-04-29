/*
Дан список Programmer(String name, String city, List<Task>  tasks).
Каждый программист имеет список задач Task (int Number, String description, String status, int daysInProcessing).
Используя Stream сформировать лист из 5 задач которые дольше всего находятся в работе.

Дана строка вида ключ1:значение1;ключ2:значение2;ключ1:значение2;ключ3:значение1...
Написать метод, который возвращает последнее значение заданного ключа.
Например: "Jack:room 10;Nick:room 20;Jack:room 1;Mike:room3", "Jack" -> "room 1"
Если в строке нет заданного ключа возвращается пустая строка.

*/

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Programmer> programmers = List.of(
                new Programmer("Vasya", "NewYork", List.of(
                        new Task(1, "fix index.html", "high", 9),
                        new Task(2, "test home.html", "low", 7)
                )),
                new Programmer("Kolya", "Paris", List.of(
                        new Task(3, "finish payment.js", "high", 12),
                        new Task(4, "add new features to cart.js", "middle", 2)
                )),
                new Programmer("Petya", "London", List.of(
                        new Task(5, "rework login page", "very low", 0),
                        new Task(4, "add new features to cart.js", "middle", 4)
                ))
                );

        List res = programmers.stream()
                .flatMap(programmer -> programmer.getTasks().stream())
                .sorted((t1,t2)-> t2.getDaysInProcessing() - t1.getDaysInProcessing())
                .limit(5)
                .toList();

        System.out.println(res);

    }
}