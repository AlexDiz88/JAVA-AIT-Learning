import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<String> list1 = new ArrayList<>();
        list1.add("Alex");
        list1.add("Nata");
        list1.add("Kirill");
        list1.add("Kirill");
        list1.add("Kirill");
        list1.add("Nikolay");
        List<String> list2 = new ArrayList<>();
        list2.add("Kirill");
        list2.add("Andy");
        list2.add("Nikolay");
        list2.add("Nikolay");
        list2.add("Tina");

        list1.retainAll(list2);
        HashSet<String> hashSet = new HashSet<>(list1);
        List<String> resultList = new ArrayList<>(hashSet);
        System.out.println(resultList);

        Map<Integer, String> map = new HashMap<>();
    }

    public static List<String> retain(List<String> list1, List<String> list2) {
        list1.retainAll(list2);
        HashSet<String> hashSet = new HashSet<>(list1);
        return new ArrayList<>(hashSet);
    }
}