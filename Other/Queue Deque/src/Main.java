import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

        ArrayDeque<String> fruits = new ArrayDeque<>();
        fruits.push("Apple");
        fruits.push("Orange");
        fruits.push("Banana");
        fruits.push("Lemon");

        // push() - добавить элемент в очередь
        System.out.println("-----push-----");
        fruits.push("Watermelon");
        System.out.println("fruits: " + fruits);

        // pop() - получить и удалить последний элемент очереди
        System.out.println("\n-----pop-----");
        System.out.println(fruits.pop());
        System.out.println("fruits: " + fruits);

        // getFirst() / getLast() - получить первый / последний элемент
        System.out.println("\n-----getFirst() / getLast()-----");
        System.out.println("getFirst:" + fruits.getFirst());
        System.out.println("getLast:" + fruits.getLast());
        System.out.println("fruits: " + fruits);

        // offer() и offerLast() - добавить элемент в конец очереди
        // offerFirst() - добавить элемент в начало очереди
        System.out.println("\n-----offer-----");
        fruits.offer("Cherry");
        fruits.offerLast("Pineapple");
        fruits.offerFirst("Pear");
        System.out.println("fruits: " + fruits);

        PriorityQueue<String> queue = new PriorityQueue<>();
    }
}