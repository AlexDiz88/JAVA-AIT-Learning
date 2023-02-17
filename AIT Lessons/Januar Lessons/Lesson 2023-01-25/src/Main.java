import java.util.*;

public class Main {
    public static void main(String[] args) {

        Car car1 = new Car("Toyota", 1200, "Gasoline");
        Car car2 = new Car("Audi", 800, "Electro");
        Car car3 = new Car("BMW", 1500, "Diesel");
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        Set<Car> hashSet = new HashSet<>();
        List<Car> linkedList = new LinkedList<>(carList);

        hashSet.add(car1);
        hashSet.add(car2);
        hashSet.add(car3);
        carList.get(0).price = 5000;

        System.out.println("ArrayList: " +  carList);
        System.out.println("HashSet: " +  hashSet);
        System.out.println("LinkedList: " + linkedList);

        System.out.println("----------------");
        String s1 = new String("belissimo");
        String s2 = "donna bella";
        List<String> myList = new ArrayList<>();
        myList.add(s1);
        myList.add(s2);
        System.out.println("myList: " + myList);
        s1 = new String(s1 + " wow!");
        System.out.println("myList: " + myList);

        HashSet<String> myHashSet = new HashSet<>(myList);
        System.out.println("myHashSet: " + myHashSet);
    }
}