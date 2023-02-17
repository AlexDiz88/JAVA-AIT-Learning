/*
Дан массив строк. Необходимо сформировать лист из строк,
которые начинаются на заданную подстроку.
Учитывать регистр. Массив строк может быть null либо пустым.
Example:
["Hello world", "Hello Andy", "Java is the best", "Hell", "Say Hello!", "hello Java", "Hellogen"]
substr = "Hello"
result = "Hello world", "Hello Andy", "Hellogen"
 */

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[] strings = new String[]{"Hello world", "Hello Andy", "Java is the best", "Hell", "Say Hello!", "hello Java", "Hellogen"};
        String prefix = "Hello";
    }

    public static ArrayList<String> getListOfStringStartWith(String[] strings, String prefix) {
        ArrayList<String> resultList = new ArrayList<>();
        if (strings == null) return resultList;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].startsWith(prefix)) {
                resultList.add(strings[i]);
            }
        }
        return resultList;
    }
}