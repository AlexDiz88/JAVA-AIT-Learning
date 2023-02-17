package Task_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

    @Test
    @DisplayName("on none/some/all lessons were more than X missing students")
    void getListOfLessonsByNumberOfMissingStudents() {
        Student st1 = new Student("Alex");
        Student st2 = new Student("Kirill");
        Student st3 = new Student("Nata");
        Student st4 = new Student("Nikolay");
        Student st5 = new Student("Tina");
        Group cohort21 = new Group();
        cohort21.add(st1, st2, st3, st4, st5);

        Lesson lesson01 = new Lesson(1, "Binary Search", List.of(st2, st3, st5));
        Lesson lesson02 = new Lesson(2, "Iterator", List.of(st1, st2, st3, st4, st5));
        Lesson lesson03 = new Lesson(3, "Hash Set", List.of(st3, st5));
        Lesson lesson04 = new Lesson(4, "String Builder", List.of(st1, st2, st3, st5));
        Lesson lesson05 = new Lesson(5, "Queue", List.of(st3, st4, st5));
        List<Lesson> lessonsList = List.of(lesson01, lesson02, lesson03, lesson04, lesson05);

        List<Lesson> actualResult = Main.getListOfLessonsByNumberOfMissingStudents(cohort21, lessonsList, 1);
        List<Lesson> expectedResult = List.of(lesson01, lesson03, lesson05);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("NULL-Lesson should be ignored")
    void getListOfLessonsByNumberOfMissingStudents2() {
        Student st1 = new Student("Alex");
        Student st2 = new Student("Kirill");
        Student st3 = new Student("Nata");
        Student st4 = new Student("Nikolay");
        Student st5 = new Student("Tina");
        Group cohort21 = new Group();
        cohort21.add(st1, st2, st3, st4, st5);

        Lesson lesson01 = new Lesson(1, "Binary Search", List.of(st2, st3, st5));
        Lesson lesson02 = new Lesson(2, "Iterator", List.of(st1, st2, st3, st4, st5));
        Lesson lesson03 = new Lesson(3, "Hash Set", List.of(st3, st5));
        Lesson lesson04 = new Lesson(4, "String Builder", List.of(st1, st2, st3, st5));
        Lesson lesson05 = new Lesson(5, "Queue", List.of(st3, st4, st5));
        Lesson lesson06 = null;
        List<Lesson> lessonsList = new ArrayList<>();
        lessonsList.add(lesson01);
        lessonsList.add(lesson02);
        lessonsList.add(lesson03);
        lessonsList.add(lesson04);
        lessonsList.add(lesson05);
        lessonsList.add(lesson06);

        List<Lesson> actualResult = Main.getListOfLessonsByNumberOfMissingStudents(cohort21, lessonsList, 1);
        List<Lesson> expectedResult = List.of(lesson01, lesson03, lesson05);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("NULL or Empty Group should return empty List")
    void getListOfLessonsByNumberOfMissingStudents3() {
        Group cohort21 = new Group();
        Group cohort22 = null;
        List<Lesson> lessonsList = List.of(new Lesson(1, "Binary Search", List.of()));

        List<Lesson> actualResult1 = Main.getListOfLessonsByNumberOfMissingStudents(cohort21, lessonsList, 1);
        List<Lesson> actualResult2 = Main.getListOfLessonsByNumberOfMissingStudents(cohort22, lessonsList, 1);
        List<Lesson> expectedResult = new ArrayList<>();

        Assertions.assertEquals(expectedResult, actualResult1, "Empty group error");
        Assertions.assertEquals(expectedResult, actualResult2, "null group error");
    }
}
