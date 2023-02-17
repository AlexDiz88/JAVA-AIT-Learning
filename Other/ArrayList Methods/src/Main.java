import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Student st1 = new Student("Vasya", 'm', 19, 4.12);
        Student st2 = new Student("Kolya", 'm', 21, 3.00);
        Student st3 = new Student("Masha", 'f', 20, 2.98);
        Student st4 = new Student("Anna", 'f', 19, 4.08);
        Student st5 = new Student("Boris", 'm', 21, 3.62);

        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(st1);
        studentList.add(st2);
        studentList.add(st3);
        studentList.add(st4);
        studentList.add(2, st5); // добавление на указанный индекс

        Student st6 = new Student("Masha", 'f', 20, 2.98);
        studentList.remove(st6); // без переписанного метода equals не происходит удаления по объекту, так как сравниваются только ссылки
        for (Student st : studentList) {
            System.out.println(st);
        }
        System.out.println("-".repeat(21));


        Student st7 = new Student("Vasya", 'm', 19, 4.12);
        Student st8 = new Student("Max", 'm', 18, 2.19);
        Student st9 = new Student("Sweta", 'f', 18, 3.46);
        ArrayList<Student> newStudentlist = new ArrayList<>();
        newStudentlist.add(st7);
        newStudentlist.add(st8);
        newStudentlist.add(st9);
        for (Student st : newStudentlist) {
            System.out.println(st);
        }
        System.out.println("-".repeat(21));

        //----------------------------------------------------------------------------------//
        // addAll
        studentList.addAll(3, newStudentlist); // добавление списка возможно также с указанного индекса
        for (Student st : studentList) {
            System.out.println(st);
        }

        //----------------------------------------------------------------------------------//
        // indexOf, lastIndexOf
        System.out.println("-".repeat(21));
        Student st10 = new Student("Vasya", 'm', 19, 4.12);
        int index1 = studentList.indexOf(st10);// корректно работает только при override equals
        System.out.println(index1);
        int index2 = studentList.lastIndexOf(st10);
        System.out.println(index2);
        System.out.println("-".repeat(21));

        //----------------------------------------------------------------------------------//
        // size, isEmpty, clear, contains
        System.out.println("size: " + studentList.size()); // общее фактическое кол-во элементов, длина list (не capacity!)
        System.out.println("list is empty?: " + studentList.isEmpty()); // проверка на "пустоту" листа
        newStudentlist.clear(); // очистка list
        System.out.println("size: " + newStudentlist.size());
        System.out.println("list is empty after clear()?: " + newStudentlist.isEmpty());
        Student st11 = new Student("Sweta", 'f', 18, 3.46);
        System.out.println("contains?:" + studentList.contains(st11)); // проверка на содержание объекта в list (при корректном equals)


    }
}

class Student {
    private String name;
    private char sex;
    private int age;
    private double avgGrade;

    public Student(String name, char sex, int age, double avgGrade) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        //String sex = (this.sex == 'm') ? "male" : "female";
        return String.format("%-5s <%s> (%2d) [%3.2f]", name, sex, age, avgGrade);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return sex == student.sex && age == student.age && Double.compare(student.avgGrade, avgGrade) == 0 && Objects.equals(name, student.name);
    }
}