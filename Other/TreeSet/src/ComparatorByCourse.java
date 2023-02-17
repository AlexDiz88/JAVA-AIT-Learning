import java.util.Comparator;

public class ComparatorByCourse implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getCourse(), o2.getCourse());
    }

    @Override
    public String toString() {
        return "Этот Comparator сортирует студентов по учебному курсу";
    }
}
