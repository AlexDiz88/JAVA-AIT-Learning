/*
Предположим у нас есть класс Task{int num, String title, String priority}.
Поле priority может принимать следующие значения: “high”  “low”  “the boss said urgently”.
Вам необходимо объединить задачи в очередь, так и написать метод getTask,
чтобы  программист забирал задачи в порядке очереди но, в первую очередь,
задачи “the boss said urgently”, потом “high”, потом “low”. При этом важно,
если есть несколько задач  например, “boss said urgently” они решаются в порядке очереди.
Подсказка: посмотрите код примера PriorityQueue написанный в классе
*/

package Task_2;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        Queue<Task> tasksQueue = new PriorityQueue<>();
        tasksQueue.offer(new Task(1, "Clean room", "low"));
        tasksQueue.offer(new Task(2, "Call to VIP customer", "the boss said urgently"));
        tasksQueue.offer(new Task(3, "Check DB", "high"));
        tasksQueue.offer(new Task(4, "Test server", "the boss said urgently"));
        tasksQueue.offer(new Task(5, "Send an offer to new customers by Email", "high"));
        tasksQueue.offer(new Task(6, "Change cartridges in printers", "low"));

        System.out.println(getTask(tasksQueue));
        System.out.println(getTask(tasksQueue));
        System.out.println(getTask(tasksQueue));
        System.out.println(getTask(tasksQueue));
        System.out.println(getTask(tasksQueue));
        System.out.println(getTask(tasksQueue));
    }
    public static Task getTask(Queue<Task> tasksQueue) {
        return tasksQueue.poll();
    }
}
