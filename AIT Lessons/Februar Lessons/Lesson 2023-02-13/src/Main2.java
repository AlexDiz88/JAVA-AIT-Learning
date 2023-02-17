import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("Lambda Lesson");

        List<String> stringList = List.of("banana", "bob", "c");
        List<String> stringList2 = new ArrayList<>();
        stringList2.add("ba na na");
        stringList2.add("bob");
        stringList2.add(null);
        stringList2.add("");
        stringList2.add("daw adw");
        System.out.println(stringProcessing(stringList, new StringLengthFunction()));


    }

    public static List<Integer> stringProcessing(List<String> stringList, StringToIntFunction function) {
        List<Integer> intList = new ArrayList<>();
        for (String s : stringList) {
            intList.add(function.processing(s));
        }
        return intList;
    }

}