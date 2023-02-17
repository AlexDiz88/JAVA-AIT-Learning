package task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Alisa", 19, 3));
        studentList.add(new Student("Rachel", 18, 4));
        studentList.add(new Student("Rick", 21, 9));
        studentList.add(new Student("Lina", 19, 4));
        studentList.add(new Student("Kira", 18, 6));

        List<Student> sortedList = sortStudents(studentList);
        for (Student student : sortedList) {
            System.out.println(student);
        }

    }
    public static List<Student> sortStudents(List<Student> studentList) {
        System.out.println("Выберите способ сортировки. 1 - по имени, 2 - по возрасту, 3 - по пропущенным урокам");
        Scanner scanner = new Scanner(System.in);
        List<Student> res = new ArrayList<>(studentList);
        switch (scanner.nextLine()) {
            case "1" -> res.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
            case "2" -> res.sort((o1, o2) -> Integer.compare(o1.getAge(), o2.getAge()));
            case "3" -> res.sort((o1, o2) -> Integer.compare(o1.getMissedClasses(), o2.getMissedClasses()));
            default -> res.sort((o1, o2) -> 0);
        }
        return res;
    }
}
