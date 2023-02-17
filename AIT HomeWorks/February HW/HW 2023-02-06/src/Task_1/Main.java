/*
Дано List<List<Integer>> , каждый элемент этого листа - отсортированный лист Integer.
Необходимо объединить все листы в один отсортированный лист.
*/

package Task_1;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<List<Integer>> listsOfNumbers = new ArrayList<>();
        listsOfNumbers.add(List.of(3, 6, 9, 14));
        listsOfNumbers.add(List.of(0, 2, 7, 12, 14, 26, 55));
        listsOfNumbers.add(List.of(1, 6, 19, 34, 55));
        listsOfNumbers.add(List.of(-8, 8, 17, 18, 24, 26, 75));
        System.out.println(combineNums(listsOfNumbers));
        System.out.println(combineNums2(listsOfNumbers));
    }

    public static List<Integer> combineNums(List<List<Integer>> listsOfNumbers) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (List<Integer> list : listsOfNumbers) {
            pq.addAll(list);
        }
        List<Integer> resultList = new ArrayList<>();
        while (!pq.isEmpty()) {
            resultList.add(pq.poll());
        }
        return resultList;
    }

    /**
     * идея в том, что мы создаем отдельный массив с количеством ячеек, равным количеству входящих листов в листе<Integer>
     * в этом массиве мы контролируем индексы каждого листа (когда забираем минимальное значение - то индекс этого листа увеличивается)
     * в итоге получаем моментальную сортировку при добавлении в результирующий лист
     * много ли операций мы экономим по сравнению с пройстейшим добавлением через addAll() + sort()??
     */
    public static List<Integer> combineNums2(List<List<Integer>> listsOfNumbers) {
        List<Integer> resultList = new ArrayList<>();
        int totalSize = 0;
        for (List<Integer> list : listsOfNumbers) {
            totalSize += list.size();
        }
        int[] indexesOfLists = new int[listsOfNumbers.size()];
        int actualIndex;
        while (resultList.size() < totalSize) {
            Integer minValue = Integer.MAX_VALUE;
            int listWithMinValue = 0;
            int listNumber = 0;
            for (List<Integer> list : listsOfNumbers) {
                actualIndex = indexesOfLists[listNumber];
                if (actualIndex == list.size()) {
                    listNumber++;
                    continue;
                }
                Integer actualValue = list.get(actualIndex);
                if (actualValue < minValue) {
                    minValue = actualValue;
                    listWithMinValue = listNumber;
                }
                listNumber++;
            }
            actualIndex = indexesOfLists[listWithMinValue];
            indexesOfLists[listWithMinValue] = actualIndex + 1;
            resultList.add(minValue);
        }
        return resultList;
    }
}