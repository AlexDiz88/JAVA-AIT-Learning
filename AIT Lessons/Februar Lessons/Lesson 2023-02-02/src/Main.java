import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println(unify("*-*", "конь", "лариса", "пулемет"));

    }

    public static String unify(String separator, String... args) {
        String res = "";
        for (int i = 0; i < args.length; i++) {
            if (i != args.length - 1) {
                res += args[i] + separator;
            } else {
                res += args[i];
            }
        }
        return res;
    }
}