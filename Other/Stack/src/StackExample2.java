import java.util.Stack;

public class StackExample2 {
    public static void main(String[] args) {

        Stack<String> stack1 = new Stack<>();

        // добавление элементов в стек происходит с помощью метода push() либо add(). Эти методы идентичны
        stack1.push("BWM");
        stack1.push("Audi");
        stack1.push("Porsche");
        stack1.push("Opel");
        System.out.println(stack1);
        // pop() - удаление последнего добавленного элемента из стека
        System.out.println("Удаленный элемент: " + stack1.pop());
        System.out.println(stack1);
        System.out.println("-------------");

        Stack<String> stack2 = new Stack<>();
        //stack2.pop(); // ERROR! применение метода pop() к пустому стеку вызовет EmptyStackException
        // для избежания данной ошибки можно использовать метод isEmpty
        while (!stack1.isEmpty()) {
            System.out.println("Удаленный элемент: " + stack1.pop());
            System.out.println(stack1);
        }
        System.out.println("-------------");

        // peek() - возвращает верхний элемент стека, но не удаляет его
        stack2.push("Sony");
        stack2.push("LG");
        System.out.println("Верхний элемент стека: " + stack2.peek());
        System.out.println(stack2);

    }
}
