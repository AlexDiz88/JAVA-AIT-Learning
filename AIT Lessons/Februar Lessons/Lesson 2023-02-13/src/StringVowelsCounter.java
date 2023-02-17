import java.util.ArrayList;
import java.util.List;

public class StringVowelsCounter implements StringToIntFunction {
    @Override
    public int processing(String s) {
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = Character.toLowerCase(s.charAt(i));
            if (vowels.contains(ch)) counter++;
        }
        return counter;
    }
}
