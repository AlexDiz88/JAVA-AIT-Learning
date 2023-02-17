import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> myList = new ArrayList<>();
        Box<String> box1 = new Box<>("строка1");
        String str = box1.getValue().toUpperCase();
        System.out.println(str);
        Box<Person> p1 = new Box<>(new Person("Bob", 18));
        String personName = p1.getValue().getName();
        System.out.println(personName);
    }
}