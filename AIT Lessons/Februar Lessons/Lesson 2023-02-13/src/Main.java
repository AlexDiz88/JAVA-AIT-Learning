import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Lambda Lesson");

        List<String> stringList = List.of("banana", "bob", "c");
        List<String> stringList2 = new ArrayList<>();
        stringList2.add("ba na na");
        stringList2.add("bob");
        stringList2.add(null);
        stringList2.add("");
        stringList2.add("daw adw");
        System.out.println(strLength(stringList));
        System.out.println(countVowels(stringList));
        System.out.println(countWords(stringList2));
    }
    public static List<Integer> strLength(List<String> stringList) {
        List<Integer> intList = new ArrayList<>();
        for (String s : stringList) {
            intList.add(s.length());
        }
        return intList;
    }

    public static List<Integer> countVowels(List<String> stringList) {
        List<Integer> vowelList = new ArrayList<>();
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
        for (String s : stringList) {
            int counter = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = Character.toLowerCase(s.charAt(i));
                if (vowels.contains(ch)) counter++;
            }
            vowelList.add(counter);
        }
        return vowelList;
    }

    public static List<Integer> countWords(List<String> stringList) {
        List<Integer> res = new ArrayList<>();
        if (stringList==null) return res;
        for (String s : stringList) {
            if (s==null || s.isBlank()) {
                res.add(0);
                continue;
            }
            res.add(s.split(" ").length);
        }
        return res;
    }

    public static List<Integer> stringToIntegerOfVowelsMy(List<String> listOfString) {
        List<Integer> res = new ArrayList<>();
        for (String s : listOfString) {
            int counter = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.valueOf(s.charAt(i)).equalsIgnoreCase("a") ||
                        s.valueOf(i).equalsIgnoreCase("e") ||
                        s.valueOf(i).equalsIgnoreCase("i") ||
                        s.valueOf(i).equalsIgnoreCase("o") ||
                        s.valueOf(i).equalsIgnoreCase("u")) {
                    counter++;
                }
            }
            res.add(counter);
        }
        return res;
    }

}