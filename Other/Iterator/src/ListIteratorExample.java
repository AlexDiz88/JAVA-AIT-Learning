import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorExample {
    public static void main(String[] args) {
        String str = "madam";
        List<Character> list = new LinkedList<>();
        for (char ch : str.toCharArray()) {
            list.add(ch);
        }
        System.out.println(list);

        // в отличии от простого iterator, ListIterator имеет несколько дополнительных методов
        ListIterator<Character> iterator = list.listIterator(); // по умолчанию стартовая позиция - начало листа
        ListIterator<Character> reverseIterator = list.listIterator(list.size()); // в скобках можно указать начальную позицию
        boolean isPalindrome = true;
        while (iterator.hasNext() && reverseIterator.hasPrevious()) {
            if (iterator.next() != reverseIterator.previous()) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println((isPalindrome)? "Palindrome": "NOT Palindrome");

        iterator = list.listIterator(); // обновляем позицию iterator на начало list
        iterator.next();
        iterator.next();
        iterator.set('g'); // заменяет элемент, полученный из метода .next() / .previous(), на указанный в скобках
        System.out.println(list);
    }


}
