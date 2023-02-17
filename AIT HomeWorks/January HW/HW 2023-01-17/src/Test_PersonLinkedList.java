import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Test_PersonLinkedList {

    @Test
    public void test_addFirst() {
        PersonLinkedList personList = new PersonLinkedList();
        personList.add(new Person("Alex", 21));
        personList.add(new Person("Bob", 22));
        personList.add(new Person("Max", 23));
        personList.add(new Person("Daniel", 24));

        personList.addFirst(new Person("Anna", 20));

        PersonLinkedList expectedPersonList = new PersonLinkedList();
        expectedPersonList.add(new Person("Anna", 20));
        expectedPersonList.add(new Person("Alex", 21));
        expectedPersonList.add(new Person("Bob", 22));
        expectedPersonList.add(new Person("Max", 23));
        expectedPersonList.add(new Person("Daniel", 24));

        Assertions.assertEquals(expectedPersonList.getFirst(), personList.getFirst());
    }

    @Test
    public void test_addFirst2() {
        PersonLinkedList personList = new PersonLinkedList();
        personList.addFirst(new Person("Anna", 20));

        PersonLinkedList expectedPersonList = new PersonLinkedList();
        expectedPersonList.add(new Person("Anna", 20));

        Assertions.assertEquals(expectedPersonList.getFirst(), personList.getFirst());
    }

    @Test
    public void test_size() {
        PersonLinkedList personList = new PersonLinkedList();
        personList.addFirst(new Person("Anna", 20));
        personList.addFirst(new Person("Anna", 20));
        personList.addFirst(new Person("Anna", 20));
        personList.add(new Person("Anna", 20));
        personList.add(new Person("Anna", 20));
        personList.add(new Person("Anna", 20));
        personList.remove(new Person("Anna", 20));
        personList.remove(3);

        int actualSize = personList.size();

        Assertions.assertEquals(4, actualSize);
    }

    @Test
    public void test_getFirst() {
        PersonLinkedList personList = new PersonLinkedList();
        personList.add(new Person("Anna", 20));
        personList.add(new Person("Alex", 21));
        personList.add(new Person("Bob", 22));
        personList.add(new Person("Max", 23));
        Person actualPerson = personList.getFirst();

        Person expectedPerson = new Person("Anna", 20);

        Assertions.assertEquals(expectedPerson, actualPerson);
    }

    @Test
    public void test_getFirst2() {
        PersonLinkedList personList = new PersonLinkedList();
        personList.add(new Person("Anna", 20));
        personList.add(new Person("Alex", 21));
        personList.addFirst(new Person("Bob", 22));
        personList.add(new Person("Max", 23));
        Person actualPerson = personList.getFirst();

        Person expectedPerson = new Person("Bob", 22);

        Assertions.assertEquals(expectedPerson, actualPerson);
    }

    @Test
    public void test_getLast() {
        PersonLinkedList personList = new PersonLinkedList();
        personList.add(new Person("Anna", 20));
        personList.add(new Person("Alex", 21));
        personList.add(new Person("Bob", 22));
        personList.add(new Person("Max", 23));
        Person actualPerson = personList.getLast();

        Person expectedPerson = new Person("Max", 23);

        Assertions.assertEquals(expectedPerson, actualPerson);
    }

    @Test
    public void test_get() {
        PersonLinkedList personList = new PersonLinkedList();
        personList.add(new Person("Anna", 20));
        personList.add(new Person("Alex", 21));
        personList.add(new Person("Bob", 22));
        personList.add(new Person("Max", 23));
        Person actualPerson = personList.get(2);

        Person expectedPerson = new Person("Bob", 22);

        Assertions.assertEquals(expectedPerson, actualPerson);
    }

    @Test
    public void test_get2() {
        PersonLinkedList personList = new PersonLinkedList();
        personList.add(new Person("Anna", 20));
        personList.add(new Person("Alex", 21));
        personList.add(new Person("Bob", 22));
        personList.addFirst(new Person("Max", 23));
        personList.addFirst(new Person("Karl", 24));
        personList.remove(2);
        personList.add(new Person("Kenny", 24));
        Person actualPerson = personList.get(3);

        Person expectedPerson = new Person("Bob", 22);

        Assertions.assertEquals(expectedPerson, actualPerson);
    }

    @Test
    public void test_get3() {
        PersonLinkedList personList = new PersonLinkedList();
        personList.add(new Person("Anna", 20));
        personList.add(new Person("Alex", 21));
        personList.add(new Person("Bob", 22));
        personList.add(new Person("Bob", 22));

        Person actualPerson = personList.get(9999);
        Person actualPerson2 = personList.get(-100500);

        List<Person> actualList = new ArrayList<>();
        actualList.add(actualPerson);
        actualList.add(actualPerson2);
        List<Person> expectedList = new ArrayList<>();
        expectedList.add(null);
        expectedList.add(null);

        Assertions.assertEquals(expectedList, actualList);
    }

    @Test
    public void test_remove() {
        PersonLinkedList personList = new PersonLinkedList();
        personList.add(new Person("Anna", 20));
        personList.add(new Person("Alex", 21));
        personList.add(new Person("Bob", 22));
        personList.add(new Person("Mike", 23));
        personList.remove(2);
        Person actualPerson = personList.get(2);

        Person expectedPerson = new Person("Mike", 23);

        Assertions.assertEquals(expectedPerson, actualPerson);
    }

    @Test
    public void test_remove2() {
        PersonLinkedList personList = new PersonLinkedList();
        personList.add(new Person("Anna", 20));
        personList.add(new Person("Alex", 21));
        personList.add(new Person("Bob", 22));
        personList.add(new Person("Mike", 23));
        Person removedPerson = personList.remove(0);

        Person expectedPerson = new Person("Anna", 20);

        Assertions.assertEquals(expectedPerson, removedPerson);
    }

    @Test
    public void test_remove3() {
        PersonLinkedList personList = new PersonLinkedList();
        personList.add(new Person("Anna", 20));
        personList.add(new Person("Alex", 21));
        personList.add(new Person("Bob", 22));
        personList.add(new Person("Mike", 23));
        boolean result = personList.remove(new Person("Alex", 21));

        Assertions.assertTrue(result);
    }




}
