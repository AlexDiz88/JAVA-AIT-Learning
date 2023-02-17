import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class MainTest {

    @Test
    void listOfAccounts() {
        List<BankAccountWithOwner> list = new ArrayList<>();
        list.add(new BankAccountWithOwner("DE01", new Person("Vasya")));
        list.add(new BankAccountWithOwner("DE02", new Person("Vasya")));
        list.add(new BankAccountWithOwner("DE03", new Person("Vasya")));
        list.add(new BankAccountWithOwner("DE04", new Person("Petya")));
        list.add(new BankAccountWithOwner("DE05", new Person("Petya")));
        list.add(new BankAccountWithOwner("DE06", new Person("Masha")));
        Map<Person, HashSet<String>> actualResult = Main.listOfAccounts(list);

        Map<Person, Set<String>> expectedResult = new HashMap<>();
        Set<String> vasyaIbans = Set.of("DE01", "DE02", "DE03");
        Set<String> petyaIbans = Set.of("DE04", "DE05");
        Set<String> mashaIbans = Set.of("DE06");
        expectedResult.put(new Person("Vasya"), vasyaIbans);
        expectedResult.put(new Person("Petya"), petyaIbans);
        expectedResult.put(new Person("Masha"), mashaIbans);

        Assertions.assertEquals(expectedResult, actualResult);
    }
}
