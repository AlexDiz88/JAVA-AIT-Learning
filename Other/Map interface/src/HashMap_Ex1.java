import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class HashMap_Ex1 {
    public static void main(String[] args) {

        // коллекция HashMap НЕупорядоченная! Хранение осуществляется по принципу пары "ключ-значение"
        // Все ключи ДОЛЖНЫ быть уникальны
        Map<Integer, String> map1 = new HashMap<>(); // в generic <> указывается два типа данных для пары "ключ-значение"

        // put() - добавление элемента (пары ключ-значение) в HashMap
        map1.put(1111, "Mike Donovan");
        map1.put(2222, "Joe Sakic");
        map1.put(3333, "Peter Forsberg");
        map1.put(4444, "Patrick Roy");
        System.out.println(map1); // видим что порядок элементов случайный
        map1.put(5555, "Patrick Roy"); // в HashMap можно хранить одинаковые значения с разными ключами
        System.out.println(map1);
        map1.put(1111, "Dominick Hasek"); // в HashMap НЕЛЬЗЯ хранить одинаковые ключи! Ключ с новым значением заменяет старое значение!!
        System.out.println(map1);
        map1.put(null, "Roy Fransis"); // в HashMap можно хранить null-ключ
        map1.put(null, "Mike Modano"); // но тоже только один
        System.out.println(map1);
        map1.put(6666, null); // в HashMap можно хранить null-значения в любом количестве
        map1.put(7777, null); // (главное - уникальные ключи для каждого null-значения)
        System.out.println(map1);
        System.out.println("---------------");

        // putIfAbsent() - добавляет элемент, только при условии, что данный ключ еще не был добавлен в HashMap
        map1.putIfAbsent(3333, "Mario Lemieux");
        System.out.println(map1); // добавления не произошло, т.к. ключ 3333 уже есть в коллекции
        System.out.println("---------------");

        // get() - получение значения по ключу (не элемента, а только значения!)
        System.out.println("Значение по ключу: " + map1.get(4444));
        System.out.println("Значение по несуществующему ключу: " + map1.get(123456)); // вернет null
        System.out.println("---------------");

        // remove() - удаление элемента по ключу
        map1.remove(2222);
        System.out.println(map1);
        System.out.println("---------------");

        // containsValue() - проверяет, содержит ли коллекция указанное значение
        System.out.println("Содержит ли коллекция указанное значение: " + map1.containsValue("Peter Forsberg"));
        System.out.println("Содержит ли коллекция указанное значение: " + map1.containsValue("PPPPP FFFFFFFF"));
        // containsKey() - проверяет, содержит ли коллекция указанный ключ
        System.out.println("Содержит ли коллекция указанный ключ: " + map1.containsKey(7777));
        System.out.println("Содержит ли коллекция указанный ключ: " + map1.containsKey(70707));
        System.out.println("---------------");

        // keySet() - возвращает множество всех ключей из HashMap
        System.out.println(map1.keySet());

        // values() - возвращает множество значений из HashMap
        System.out.println(map1.values());
        System.out.println("---------------");

        // типы данных в HashMap могут как совпадать, так и различаться, а также являтся нашими собственными классами
        Map<String, String> map2 = new HashMap<>();
        map2.put("BMW", "x5");
        map2.put("Opel", "Corsa");

        Map<Integer, Student> map3 = new HashMap<>();
        map3.put(1, new Student("Alex"));
        map3.put(2, new Student("Max"));
    }
}

class Student{
    String name;

    public Student(String name) {
        this.name = name;
    }
}
