/*
Есть лист из BankAccountWithOwner {String IBAN, Person owner;}
нужно написать функцию, которая возвращает мапу, где ключом является Person,
а значением - список его банковских счетов.
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<BankAccountWithOwner> list = new ArrayList<>();
        list.add(new BankAccountWithOwner("DE01", new Person("Vasya")));
        list.add(new BankAccountWithOwner("DE02", new Person("Vasya")));
        list.add(new BankAccountWithOwner("DE03", new Person("Vasya")));
        list.add(new BankAccountWithOwner("DE04", new Person("Petya")));
        list.add(new BankAccountWithOwner("DE05", new Person("Petya")));
        list.add(new BankAccountWithOwner("DE04", new Person("Petya")));
        list.add(new BankAccountWithOwner("DE06", new Person("Masha")));
        list.add(new BankAccountWithOwner("DE07", new Person("Glasha")));
        list.add(new BankAccountWithOwner(null, new Person("Glasha")));
        list.add(new BankAccountWithOwner("DE08", null));

        System.out.println(listOfAccounts(list));
    }

    public static Map<Person, HashSet<String>> listOfAccounts(List<BankAccountWithOwner> list) {
        Map<Person, HashSet<String>> result = new HashMap<>();
        for (BankAccountWithOwner b : list) {
            HashSet<String> ibans = new HashSet<>();
            if (b == null || b.getIban() == null || b.getOwner() == null) {
                System.out.println("Ошибка данных");
                continue;
            }
            if (!result.containsKey(b.getOwner())) {
                result.put(b.getOwner(), ibans);
                ibans.add(b.getIban());
            } else {
                HashSet<String> strings = result.get(b.getOwner());
                strings.add(b.getIban());
            }
        }
        return result;
    }
}