/*
1) Реализовать метод, который добавляет в List<Integer> 1000000 целых чисел.
2) Реализовать метод, который добавляет в List<Integer> 1000000 целых чисел,
но каждое следующее значение должно добавляться в случайную позицию листа.
*/

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {

        private static long start;
        private static long finish;

    public static void main(String[] args) {

        startTimer();
        //List<Integer> list1 = new ArrayList<>();
        List<Integer> list1 = new LinkedList<>();

        addOneMillionNumbersToRandomPosition(list1);
        //addOneMillionNumbers(list1);

//        int counter = 1;
//        for (Integer i : list1) {
//            System.out.println(counter + "." + i);
//            counter++;
//        }
        stopTimer();
        System.out.println(getTime());
        System.out.println("Done!");


        // время выполнения методов на моём ПК без вывода значений в консоль (с выводом в консоль):

        // ArrayList<>() -                  addOneMillionNumbers() -  2 секунды (5 секунд)
        // ArrayList<>() -  addOneMillionNumbersToRandomPosition() - 43 секунды (45 секунд)

        // LinkedList<>() -                 addOneMillionNumbers() -  2 секунды (5 секунд)
        // LinkedList<>() - addOneMillionNumbersToRandomPosition() - более 10 минут

        // если в ArrayList задать InitialCapacity = 1'000'000, то это никак не влияет на скорость выполнения (также ~45 сек.)

    }

    public static void startTimer() {
        start = System.nanoTime();
    }

    public static void stopTimer() {
        finish = System.nanoTime();
    }

    public static long getTime() {
        long time = finish - start;
        //return time;
        return TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS);
    }

    public static void addOneMillionNumbers(List<Integer> list) {
        for (int i = 0; i < 1_000_00; i++) {
            list.add(getRandomNumber());
        }
    }

    public static void addOneMillionNumbersToRandomPosition(List<Integer> list) {
        for (int i = 0; i < 1_000_00; i++) {
            if (list.size() == 0) {
                list.add(getRandomNumber());
            } else {
                list.add(getRandomPosition(0, list.size()), getRandomNumber());
            }
        }
    }

    public static int getRandomPosition(int min, int max) {
        Random random = new Random();
        return random.nextInt(min, max);
    }

    public static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}