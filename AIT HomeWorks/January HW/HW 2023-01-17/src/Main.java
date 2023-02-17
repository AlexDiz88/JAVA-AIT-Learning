/*
Реализовать по образу и подобию написанного в классе MyLinkedList, линкед лист для Person
Добавить метод boolean addFirst(Person person), который позволяет добавить элемент в начало списка пользователей.
Добавить метод Person remove(int index), который возвращает персона по индексу и удаляет его из списка.
Добавить метод boolean remove(Person person), который возвращает true, если заданный персон присутствует в списке и удаляет этого персона.
Иначе метод возвращает false. Не забываем про тесты!.
*/

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        PersonLinkedList personList = new PersonLinkedList();
        personList.add(new Person("Joe", 17));
        personList.add(new Person("Anna", 19));
        personList.add(new Person("Bob", 21));
        personList.add(new Person("Mike", 15));
        System.out.println(personList);
        System.out.println("First = " + personList.getFirst());
        System.out.println("Last = " + personList.getLast());

        System.out.println("----------");
        System.out.println("get by index(1): " + personList.get(1));
        System.out.println("get by index(-100): " + personList.get(-100));

        System.out.println("-----add first-----");
        personList.addFirst(new Person("Peter", 33));
        System.out.println(personList);
        System.out.println("size = " + personList.size());
        System.out.println("get by index(1): " + personList.get(1));

        System.out.println("----------");
        System.out.println("Get Node by index(1) (prev-element-next): " + personList.getNode(1));
        System.out.println("Get Node by index(4) (prev-element-next): " + personList.getNode(4));

        System.out.println("------remove by index(2)------");
        Person removedPerson = personList.remove(2);
        System.out.println(personList);
        System.out.println("Get Node by index(2) (prev-element-next): " + personList.getNode(2));
        System.out.println("Removed Person: " + removedPerson);

        System.out.println("------remove by Person------");
        System.out.println(personList.remove(new Person("Mike", 16)));
        System.out.println(personList.remove(new Person("Mike", 15)));
        System.out.println(personList);

    }
}