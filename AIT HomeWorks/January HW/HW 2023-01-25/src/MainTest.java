import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

    @Test
    public void test_deleteDuplicates() {
        List<Transaction> list = new ArrayList<>();
        list.add(new Transaction(3, new Account("DE_11"), new Account("DE_04"), 400));
        list.add(new Transaction(1, new Account("DE_01"), new Account("DE_02"), 150));
        list.add(new Transaction(2, new Account("DE_05"), new Account("DE_08"), 225));
        List<Transaction> actualResult = Main.deleteDuplicates(list);

        List<Transaction> expectedResult = new ArrayList<>();
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_deleteDuplicates2() {
        List<Transaction> list = new ArrayList<>();
        list.add(new Transaction(3, new Account("DE_11"), new Account("DE_04"), 400));
        list.add(new Transaction(1, new Account("DE_01"), new Account("DE_02"), 150));
        list.add(new Transaction(2, new Account("DE_05"), new Account("DE_08"), 225));
        list.add(new Transaction(2, new Account("DE_05"), new Account("DE_08"), 225));
        List<Transaction> actualResult = Main.deleteDuplicates(list);

        List<Transaction> expectedResult = new ArrayList<>();
        expectedResult.add(new Transaction(102, new Account("DE_08"), new Account("DE_05"), 225));
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_deleteDuplicates3() {
        List<Transaction> list = new ArrayList<>();
        list.add(new Transaction(2, new Account("DE_05"), new Account("DE_08"), 225));
        list.add(new Transaction(2, new Account("DE_05"), new Account("DE_08"), 225));
        list.add(new Transaction(3, new Account("DE_11"), new Account("DE_04"), 400));
        list.add(new Transaction(2, new Account("DE_05"), new Account("DE_08"), 225));
        list.add(new Transaction(2, new Account("DE_05"), new Account("DE_08"), 225));
        list.add(new Transaction(1, new Account("DE_01"), new Account("DE_02"), 150));
        list.add(new Transaction(1, new Account("DE_01"), new Account("DE_02"), 150));
        List<Transaction> actualResult = Main.deleteDuplicates(list);

        List<Transaction> expectedResult = new ArrayList<>();
        expectedResult.add(new Transaction(102, new Account("DE_08"), new Account("DE_05"), 225));
        expectedResult.add(new Transaction(102, new Account("DE_08"), new Account("DE_05"), 225));
        expectedResult.add(new Transaction(102, new Account("DE_08"), new Account("DE_05"), 225));
        expectedResult.add(new Transaction(101, new Account("DE_02"), new Account("DE_01"), 150));
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
