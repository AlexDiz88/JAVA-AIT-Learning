package Task_2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenericExample <T>{
    public boolean checkCycling3(List<T> list1, List<T> list2) {
        if (list1 == null || list2 == null || list1.size() != list2.size() || list1.isEmpty()) return false;
        Queue<T> queue1 = new LinkedList<>();
        Queue<T> queue2 = new LinkedList<>();
        for (T e : list1) {
            if (queue1.equals(queue2)) return true;
            queue2.offer(queue2.poll());
        }
        return true;
    }
}
