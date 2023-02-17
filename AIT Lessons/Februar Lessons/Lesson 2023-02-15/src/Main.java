/*
Дан список банковских транзакций (Account debit, Account credit, amount),
класс Account(IBAN, Person) - банковский счет.
Необходимо реализовать метод который сортирует транзакции по сумме (по возрастанию, по убыванию),
по номеру счета дебита, по номеру счета кредита,
по имени персона в счете по дебету, по имени персона в счете по кредиту
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Transaction tr1 = new Transaction(new Account("DE01", new Person("Bob")), new Account("DE02", new Person("Mike")), 145);
        Transaction tr2 = new Transaction(new Account("DE02", new Person("Mike")), new Account("DE03", new Person("Jack")), 310);
        Transaction tr3 = new Transaction(new Account("DE04", new Person("John")), new Account("DE01", new Person("Bob")), 586);
        List<Transaction> list = List.of(tr1, tr2, tr3);

        System.out.println(sortTransaction(list, (t1, t2) -> Double.compare(t1.getAmount(), t2.getAmount()))); // по сумме
        System.out.println("--------------");
        System.out.println(sortTransaction(list, (t1, t2) -> Double.compare(t2.getAmount(), t1.getAmount()))); // по сумме в обратном порядке
        System.out.println("--------------");
        System.out.println(sortTransaction(list, (t1, t2) -> t1.getDebit().getIban().compareTo(t2.getDebit().getIban()))); // по номеру дебета
        System.out.println("--------------");
        System.out.println(sortTransaction(list, (t1, t2) -> t1.getCredit().getIban().compareTo(t2.getCredit().getIban()))); // по номеру кредита
        System.out.println("--------------");
        System.out.println(sortTransaction(list, (t1, t2) -> t1.getDebit().getPerson().getName().compareTo(t2.getDebit().getPerson().getName()))); // по имени персона в счете по дебету
        System.out.println("--------------");
        System.out.println(sortTransaction(list, (t1, t2) -> t1.getCredit().getPerson().getName().compareTo(t2.getCredit().getPerson().getName()))); // по имени персона в счете по кредиту
        System.out.println("--------------");

    }

    public static List<Transaction> sortTransaction(List<Transaction> transactions, Comparator<Transaction> c) {
        List<Transaction> result = new ArrayList<>(transactions);
        result.sort(c);
        return result;
    }
}