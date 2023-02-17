import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // естественный порядок сортировки с помощью класса Collections для листов типа Integer, String итд.
        List<String> list1 = new ArrayList<>();
        list1.add("Max");
        list1.add("Alex");
        list1.add("Masha");
        list1.add("petr");
        System.out.println("До сортировки: " + list1);
        Collections.sort(list1);
        System.out.println("После сортировки: " + list1);
        System.out.println("-----------------");

        // естественный порядок сортировки с помощью класса Arrays для любых массивов
        int[] myArray = new int[]{6, 0, -13, 11, -54, 5, 11, 32, -2};
        System.out.println("До сортировки: " + Arrays.toString(myArray));
        Arrays.sort(myArray);
        System.out.println("После сортировки: " + Arrays.toString(myArray));
        System.out.println("-----------------");

        // имлементируем интерфейс Comparable<T>
        // и делаем @Override метода compareTo(), реализуя натуральный порядок по полю "id".
        List<Employee> list2 = new ArrayList<>();
        Employee emp1 = new Employee(185, "Joe", "Francise", 2300);
        Employee emp2 = new Employee(129, "Mario", "Lemieux", 3500);
        Employee emp3 = new Employee(113, "Martin", "Brodeur", 3240);
        list2.add(emp1);
        list2.add(emp2);
        list2.add(emp3);
        System.out.println("До сортировки: " + list2);
        // Collections.sort(list2); // компилятор тут выдаст ошибку, если в классе (объекты которого мы сравнивниваем)
        // не прописан метод compareTo(), либо не имплементирован интерфейс Comparable<ClassName>
        // При этом для класса Arrays ошибки компилятора не будет. Вместо неё мы получим RuntimeException при запуске
        // Arrays.sort(new Employee[]{emp1, emp2, emp3});
        System.out.println("После сортировки: " + list2);
        System.out.println("-----------------");

        //-------------------------------------------------------------------------------//
        // сравнение с помощью объектов Comparator. На каждое поле класса можно создать класс Comparator,
        // и указывать его в качестве параметра метода sort() для листа
        List<Employee> list3 = new ArrayList<>();
        list3.add(new Employee(14, "Lionel", "Messi", 999));
        list3.add(new Employee(12, "Karim", "Benzema", 888));
        list3.add(new Employee(13, "Mario", "Götze", 777));
        System.out.println("До сортировки: " + list3);
        list3.sort(new idComparator());
        System.out.println("После сортировки по id: " + list3);
        list3.sort(new firstNameComparator());
        System.out.println("После сортировки по firstName: " + list3);
        list3.sort(new lastNameComparator());
        System.out.println("После сортировки по lastName: " + list3);
        list3.sort(new salaryComparator());
        System.out.println("После сортировки по salary: " + list3);
    }
}