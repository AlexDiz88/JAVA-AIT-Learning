package Task_2;

import java.util.Objects;

public class Task implements Comparable<Task> {
    private final int num;
    private final String title;
    private final String priority;

    public Task(int num, String title, String priority) {
        this.num = num;
        this.title = title;
        this.priority = priority;
    }

    private int getPriorityLevel() {
        if (priority.equals("the boss said urgently")) return 3;
        if (priority.equals("high")) return 2;
        if (priority.equals("low")) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return num + ". " + title + " (" + priority + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return num == task.num && Objects.equals(title, task.title) && Objects.equals(priority, task.priority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, title, priority);
    }

    @Override
    public int compareTo(Task o) {
        if (getPriorityLevel() < o.getPriorityLevel()) return 1;
        if (getPriorityLevel() > o.getPriorityLevel()) return -1;
        return Integer.compare(this.num, o.num);
    }
}
