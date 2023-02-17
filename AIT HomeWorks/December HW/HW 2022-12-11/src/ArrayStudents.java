public class ArrayStudents {

    int capacity = 10;
    Student[] students = new Student[capacity];
    int size;

    public ArrayStudents(int capacity) {
        students = new Student[capacity];
    }

    public ArrayStudents() {
    }

    public void addStudent(Student student) {
        if (student != null) {
            if (size < capacity) {
                students[size++] = student;
            }
        }
    }

    // 8. Написать метод, который принимает массив строк вида “Иван Иванов”, т.е. имя и фамилия,
    // а в качестве результата возвращает массив объектов типа Student{String firstName, String lastName}
    public ArrayStudents getStudentsByNames(String[] arrayStudents) {
        if (students != null || arrayStudents != null) {
            String[] splittedFullname;
            ArrayStudents result = new ArrayStudents(size);
            int counter = 0;
            for (int i = 0; i < arrayStudents.length; i++) {
                if (arrayStudents[i] != null) {
                    splittedFullname = arrayStudents[i].trim().split(" ", 2);
                    // System.out.println(Arrays.toString(splittedFullname));
                    if (splittedFullname[0].equals(students[i].getFirstName())) {
                        if (splittedFullname[1].equals(students[i].getLastName())) {
                            result.addStudent(students[i]);
                            counter++;
                        }
                    }
                }

            }
            return (counter > 0) ? result : null;
        }
        return null;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < size; i++) {
            result += students[i] + "\n";
        }
        return result;
    }
}
