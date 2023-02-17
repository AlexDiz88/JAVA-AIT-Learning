package Task_1;

import java.util.List;

public class Lesson {
    private final int num;
    private final String theme;
    private final List<Student> presentStudents;

    public Lesson(int num, String theme, List<Student> presentStudents) {
        this.num = num;
        this.theme = theme;
        this.presentStudents = presentStudents;
    }

    @Override
    public String toString() {
        return num + ". " + theme + ": " + presentStudents;
    }

    public int getNumberOfPresentStudents() {
        return presentStudents.size();
    }

    public List<Student> getPresentStudents() {
        return presentStudents;
    }
}
