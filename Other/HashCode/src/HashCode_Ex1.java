import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCode_Ex1 {
    public static void main(String[] args) {
        Map<Student, Double> map1 = new HashMap<>();
        Student st1 = new Student("Mike", "Scoffield", 5);
        Student st2 = new Student("Nicole", "Kidman", 3);
        Student st3 = new Student("Matthew", "Perry", 2);

        map1.put(st1, 7.4);
        map1.put(st2, 9.2);
        map1.put(st3, 6.7);
        System.out.println(map1);


        Student st4 = new Student("Mike", "Scoffield", 5);
        System.out.println("Student 1 == Student 4: " + st1.equals(st4)); // true при корректном equals

        // если не переписан метод hashCode(), то:
        boolean result = map1.containsKey(st4);
        System.out.println("HashMap contains key st4: " + result); // выдает false даже при корректном @Override equals()!
        // Дело в том, что сравнение ключей в коллекциях HashMap и HashSet происходит по хэшкоду,
        // и если метод hashCode не переопределён, то такое сравнение/поиск будет всегда выдавать false,
        // даже для объектов которые равны между собой по equals, поскольку дефолтный метод hashCode() класса Object,
        // выдает уникальный серийный номер объекта, и возвращает разный hashCode, даже для одинаковых по equals объектов.
        // Если же метод hashCode() переопределен, а метод equals() нет, то такое сравнение тоже будет выдавать false,
        // даже у одинаковых (с точки зрения логики) объектов, так как в коллекциях HashMap и HashSet
        // сначала идет сравнение по hashCode, а затем по equals. Поэтому важно переопределять сразу оба метода!


        System.out.println("-----------------");
        System.out.println("st1 hashcode = " + st1.hashCode()); // у одинаковых объектов всегда одинаковый hashCode
        System.out.println("st2 hashcode = " + st2.hashCode());
        System.out.println("st3 hashcode = " + st3.hashCode());
        System.out.println("st4 hashcode = " + st4.hashCode()); // у одинаковых объектов всегда одинаковый hashCode

        for (Map.Entry<Student, Double> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        Map<Integer, String> map2 = new HashMap<>(16, 0.75f);


    }
}

class Student{
    String name;
    String surname;
    int course;

    public Student(String name, String surname, int course) {
        this.name = name;
        this.surname = surname;
        this.course = course;
    }

    @Override
    public String toString() {
        return name + " " + surname + " (" + course + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course && Objects.equals(name, student.name) && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, course);
    }
}
