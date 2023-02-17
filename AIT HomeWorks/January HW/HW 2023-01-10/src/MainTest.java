import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

    @Test
    public void test_personsYoungerThanAge1() {
        List<Person> personList = new ArrayList<>();
        Person p1 = new Person("Mike", "Modano", 34);
        Person p2 = new Person("Peter", "Forsberg", 27);
        Person p3 = new Person("Joe", "Sakic", 39);
        Person p4 = new Person("Valeriy", "Kamenskih", 31);
        Person p5 = new Person("Pavel", "Bure", 25);
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        personList.add(p5);

        List<Person> expectedList = new ArrayList<>();
        expectedList.add(p2);
        expectedList.add(p5);

        List<Person> actualList = Main.personsYoungerThanAge(personList, 30);
        Assertions.assertEquals(expectedList, actualList);
    }

    @Test
    public void test_personsYoungerThanAge2() {
        List<Person> personList = new ArrayList<>();
        Person p1 = new Person("Mike", "Modano", 34);
        Person p2 = new Person("Peter", "Forsberg", 27);
        personList.add(p1);
        personList.add(p2);

        List<Person> expectedList = new ArrayList<>();
        List<Person> actualList = Main.personsYoungerThanAge(personList, -15);
        Assertions.assertEquals(expectedList, actualList);
    }

    @Test
    public void test_personsYoungerThanAge3() {
        List<Person> personList = null;
        List<Person> expectedList = new ArrayList<>();
        List<Person> actualList = Main.personsYoungerThanAge(personList, 40);
        Assertions.assertEquals(expectedList, actualList);
    }
}
