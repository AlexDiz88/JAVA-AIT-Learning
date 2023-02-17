/*
Реализовать метод, который "разделит" заданный массив относительно заданного числа, слева все меньшие значения, справа все большие
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExtraTask {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        addNumbersToList(list, 10);
        System.out.println(list);



    }

    public static int getRandomNumber(int min, int max) {
        Random rnd = new Random();
        return rnd.nextInt(5, 10);
        //return (int) (min + Math.random() * (max - min + 1));
    }

    public static void addNumbersToList(List<Integer> list, int size) {
        for (int i = 0; i < size; i++) {
            list.add(getRandomNumber(0, 100));
        }
    }

    public static List<Integer> splitListByValue(List<Integer> list, int index) {
        if (index >= list.size()) return null;
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < list.get(index)) {

            }
        }
        return null;
    }
}
