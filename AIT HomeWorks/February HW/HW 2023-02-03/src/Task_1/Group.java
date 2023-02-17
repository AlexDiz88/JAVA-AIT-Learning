package Task_1;

import java.util.*;

public class Group {

    private final Set<Student> studentsList = new HashSet<>();

    public void add(Student... students) {
        studentsList.addAll(Arrays.asList(students));
    }

    public int getGroupSize() {
        return studentsList.size();
    }

    public Set<Student> getStudentsList() {
        return studentsList;
    }
}
