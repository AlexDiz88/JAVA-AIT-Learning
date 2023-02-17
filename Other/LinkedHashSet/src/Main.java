import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // удаляет дубли, сохраняя порядок
        Set<String> set1 = new LinkedHashSet<>();
        set1.add("s1");
        set1.add("s3");
        set1.add("s4");
        set1.add("s1");
        set1.add("s1");
        set1.add("s2");
        set1.add("s2");
        set1.add("s2");
        System.out.println(set1);
        PriorityQueue<String> pq = new PriorityQueue<>();



    }
}