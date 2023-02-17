import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    private static long start;
    private static long finish;

    public static void main(String[] args) {
        startTimer();
        List<Integer> list = new ArrayList<>();
        // some code here to test
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i);
        }
        stopTimer();
        double timeInSeconds = (double)getTime()/1000;
        System.out.println("Время выполнения кода: " + String.format("%.3f", timeInSeconds) + " сек.");
    }

    public static void startTimer() {
        start = System.nanoTime();
    }

    public static void stopTimer() {
        finish = System.nanoTime();
    }

    public static long getTime() {
        long time = finish - start;
        return TimeUnit.NANOSECONDS.toMillis(time);
        //return TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS); // через метод convert()
    }
}