import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s1 = "jack";
        String s2 = "john";
        String s3 = "n";

        List<String> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        System.out.println(addBrackets(list));

        System.out.println(toUpperCase(list));
    }

    public static List<String> addBrackets(List<String> list) {
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            resultList.add("(" + list.get(i) + ")");
        }
        return resultList;
    }

    public static List<String> toUpperCase(List<String> list) {
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            resultList.add("(" + list.get(i).substring(0,1).toUpperCase() + list.get(i).substring(1) + ")");
        }
        return resultList;
    }
}