/*
Задание 1
Создайте метод, который будет переносить все не-общие элементы из в двух листов в новый set.
(То, что в теории множеств называется симметрическая разность)
Напишите тест JUnit.
Задание 2 (Потворение интерфесов, классов, дженериоков, HashMap)
Релиз 1
Создайте абстрактный класс напиток. Создайте три производных класса: кофе, чай, кола.
Создайте интерфейс Natural.
Пусть только кофе, чай имплементируют этот интерфейс.
Создайте обобщенный класс Bar с полями title, address, и обобщенным(дженерик) полем drinks.
Сделайте ограничения для поля дринкс, оно должно быть ограничено классом Drink и интерфейсом Natural.
Релиз 2
Создайте HashMap, где бар - это ключ, а значение - это рейтинг.
Добавьте в HashMap пары бар-рейтинг, убедитесь, что пары с дублирующимися ключами не добавляются.
Если будут добавляться, подумайте, о чем вы могли забыть…
Релиз 3
Создайте дополнительные поля и методы для интерфесов и классов на ваше усмотрение.
*/

package fromAlisher;

import fromAlisher.drinks.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<String> list1 = List.of("Wolf", "Bird", "Fish", "Dinosaur");
        List<String> list2 = List.of("Wolf", "Bear", "Fish", "Monkey", "Rabbit", "Deer");
        System.out.println(uniqueValues(list1, list2));

        Bar<Drink> bar1 = new Bar<>("Popoyka", "Marksstr.19", new Tea());
        System.out.println(bar1);
    }

    // Задание 1
    public static Set<String> uniqueValues(List<String> list1, List<String> list2) {
        if (list1 == null || list2 == null) return null;
        Set<String> result = new HashSet<>();
        for (String s : list1) {
            if (!list2.contains(s)) {
                result.add(s);
            }
        }
        for (String s : list2) {
            if (!list1.contains(s)) {
                result.add(s);
            }
        }
        return result;
    }
}
