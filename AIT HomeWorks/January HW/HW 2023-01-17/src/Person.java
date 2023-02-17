import java.util.Objects;

public class Person {
    private final String name;
    private final int age;
    private final int id;
    private static int count;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = ++count;
    }

    @Override
    public String toString() {
        return id + ". " + name + " (" + age + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
