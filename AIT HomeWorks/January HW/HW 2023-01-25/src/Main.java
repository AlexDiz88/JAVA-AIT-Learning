/*
Дан List<Transaction> транзакций банковских транзакций Transaction{long id, Account debit, Account credit, double amount}.
Увы при загрузке, часть транзакций в данном списке “задвоилось”. Необходимо сгенерировать список корректирующих транзакций,
для всех “задвоенных” транзакций,  т.е. сгенерировать транзакцию на ту же сумму, но с обратной корреспонденцией счетов.
Не забываем про тесты.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Transaction> list = new ArrayList<>();
        list.add(new Transaction(3, new Account("DE_11"), new Account("DE_04"), 400));
        list.add(new Transaction(1, new Account("DE_01"), new Account("DE_02"), 150));
        list.add(new Transaction(2, new Account("DE_05"), new Account("DE_08"), 225));
        list.add(new Transaction(3, new Account("DE_11"), new Account("DE_04"), 400));
        list.add(new Transaction(1, new Account("DE_01"), new Account("DE_02"), 150));
        list.add(new Transaction(4, new Account("DE_06"), new Account("DE_03"), 640));
        list.add(new Transaction(3, new Account("DE_11"), new Account("DE_04"), 400));

        for (Transaction t : list) {
            System.out.println(t);
        }
        System.out.println("----------------");
        List<Transaction> newList = deleteDuplicates(list);
        for (Transaction t : newList) {
            System.out.println(t);
        }

    }

    public static List<Transaction> deleteDuplicates(List<Transaction> list) {
        List<Transaction> resultList = new ArrayList<>();
        HashSet<Transaction> hashSet = new HashSet<>();
        for (Transaction t : list) {
            if (!hashSet.add(t)) {
                resultList.add(new Transaction(100 + t.getId(), t.getCredit(), t.getDebit(), t.getAmount()));
            }
        }
        return resultList;
    }
}
