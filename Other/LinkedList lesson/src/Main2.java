import java.util.LinkedList;

public class Main2 {
    public static void main(String[] args) {
        Student st1 = new Student("Fred", 19);
        Student st2 = new Student("Kurt", 18);
        Student st3 = new Student("Billy", 21);
        Student st4 = new Student("Sam", 19);
        Student st5 = new Student("Lucy", 21);
        LinkedList<Student> linkedList = new LinkedList<>();
        linkedList.add(st1);
        linkedList.add(st2);
        linkedList.add(st3);
        linkedList.add(st4);
        linkedList.add(st5);
        System.out.println("LinkedList = " + linkedList);
        linkedList.offer(st4);
        System.out.println("LinkedList = " + linkedList);
        Student element = linkedList.element();
        System.out.println(element);
        System.out.println("LinkedList = " + linkedList);

    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}