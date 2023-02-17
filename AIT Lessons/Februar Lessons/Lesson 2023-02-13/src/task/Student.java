package task;

public class Student {
    private String name;
    private int age;
    private int missedClasses;

    public Student(String name, int age, int missedClasses) {
        this.name = name;
        this.age = age;
        this.missedClasses = missedClasses;
    }

    @Override
    public String toString() {
        return name + " (" + age + "), missed:" + missedClasses;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getMissedClasses() {
        return missedClasses;
    }
}
