public class Student implements Comparable<Student>{
    String name;
    int age;
    int course;

    public Student(String name, int age, int course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    @Override
    public String toString() {
        return name + " " + age + " (" + course + ")";
    }


    @Override
    public int compareTo(Student o) {
        return name.compareTo(o.name);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getCourse() {
        return course;
    }
}
