/*
1. Дан лист объектов (любой, по вашему выбору: Person, Panda, Car и т.д.)
Необходимо реализовать метод void deleteDuplicate(list), которая удаляет повторяющиеся объекты,
при этом сохраняя порядок элементов исходного листа. Решить задачу всеми известными вам способами.

2. Дан лист строк, необходимо получить Map<String,Integer> такой,
что ключом является строка из исходного листа, значением, сколько раз она встречается в листе.
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Cat");
        list.add("Dog");
        list.add("Dog");
        list.add("Dog");
        list.add("Cat");
        list.add("Mouse");
        list.add("Bear");
        list.add("Mouse");
        list.add("Owl");
        list.add("Cat");
        list.add("Cat");

        HashMap<String, Integer> hashMap = countDuplicates(list);
        System.out.println("hashMap: " + hashMap);

        deleteDuplicate(list);
        System.out.println("list: " + list);
    }

    public static HashMap<String, Integer> countDuplicates(List<String> list) {
        HashMap<String, Integer> resultMap = new HashMap<>();
        for (String s : list) {
            if (!resultMap.containsKey(s)) {
                resultMap.put(s, 1);
            } else {
                Integer newValue = resultMap.get(s);
                resultMap.put(s, ++newValue);
            }
        }
        return resultMap;
    }

    // в 2 цикла (первичное решение)
    public static HashMap<String, Integer> countDuplicates2(List<String> list) {
        HashMap<String, Integer> resultMap = new HashMap<>();
        for (String s1 : list) {
            int value = 0;
            for (String s2 : list) {
                if (s2.equals(s1)) {
                    value++;
                }
            }
            resultMap.putIfAbsent(s1, value);
        }
        return resultMap;
    }

    public static void deleteDuplicate(List<String> list) {
        HashSet<String> hashSet = new HashSet<>();
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (!hashSet.add(iterator.next())) {
                iterator.remove();
            }
        }
    }

    // а вот так IDEA подсказала мне улучшить метод
    public static void deleteDuplicate2(List<String> list) {
        HashSet<String> hashSet = new HashSet<>();
        list.removeIf(s -> !hashSet.add(s));
    }
}