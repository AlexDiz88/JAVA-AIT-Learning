/*
Дан лист из Person (fName, lName, age).
Необходимо получить лист из строк вида (Иванов И., 45) для всех людей, младше заданного возраста.
В рамках данной задачи считаем, что исходный list не содержит значения null.
Необходимо реализовать тесты.
 */

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public static List<Person> personsYoungerThanAge(List<Person> personList, int age) {
        List<Person> resultList = new ArrayList<>();
        if (personList == null || age <= 0) return resultList;
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getAge() < age) {
                resultList.add(personList.get(i));
            }
        }
        return resultList;
    }
}