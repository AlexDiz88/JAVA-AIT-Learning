/*
Дан список студентов группы. Дан список занятий Lesson {int num, String theme, List<Student> students},
т.е. номер занятия, тема и список присутствующих студентов.
- Необходимо получить список занятий, где количество прогульщиков было больше заданного числа
- Необходимо получить список “прогульщиков” отсортированный по количеству прогулов
*/
package Task_1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Student st1 = new Student("Alex");
        Student st2 = new Student("Kirill");
        Student st3 = new Student("Nata");
        Student st4 = new Student("Nikolay");
        Student st5 = new Student("Tina");
        Group cohort21 = new Group();
        cohort21.add(st1, st2, st3, st4, st5);

        Lesson lesson01 = new Lesson(1, "Binary Search", List.of(st2, st3, st5));
        Lesson lesson02 = new Lesson(2, "Generics", List.of(st1, st2, st3, st4, st5));
        Lesson lesson03 = new Lesson(3, "Inheritance", List.of(st3, st5));
        Lesson lesson04 = new Lesson(4, "String Builder", List.of(st1, st2, st3, st5));
        Lesson lesson05 = new Lesson(5, "Polymorphism", List.of(st3, st4));
        List<Lesson> lessonsList = List.of(lesson01, lesson02, lesson03, lesson04, lesson05);

        System.out.println(getListOfLessonsByNumberOfMissingStudents(cohort21, lessonsList, 2));
        System.out.println("--------------");
        System.out.println(getListOfTruants(cohort21, lessonsList));
    }

    public static List<Lesson> getListOfLessonsByNumberOfMissingStudents(Group group, List<Lesson> lessonsList, int missingStudentsMoreThan) {
        List<Lesson> result = new ArrayList<>();
        if (group == null || lessonsList == null) return result;
        for (Lesson lesson : lessonsList) {
            if (lesson != null) {
                if ((group.getGroupSize() - lesson.getNumberOfPresentStudents()) > missingStudentsMoreThan) {
                    result.add(lesson);
                }
            }
        }
        return result;
    }

    public static List<Map.Entry<Student, Integer>> getListOfTruants(Group group, List<Lesson> lessonsList) {
        HashMap<Student, Integer> truants = new HashMap<>();
        for (Lesson lesson : lessonsList) {
            for (Student student : group.getStudentsList()) {
                if (!lesson.getPresentStudents().contains(student)) {
                    truants.put(student, truants.getOrDefault(student, 0) + 1);
                }
            }
        }
        List<Map.Entry<Student, Integer>> res = new ArrayList<>(truants.entrySet());
        res.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        return res;
    }
}