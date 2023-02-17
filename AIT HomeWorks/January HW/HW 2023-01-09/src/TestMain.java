import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

    @Test
    public void listShouldBeSorted() {
        List<Integer> list = new ArrayList<>();
        Main.addRandomNumbersToList(list, 100);
        boolean isSorted = true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                isSorted = false;
                break;
            }
        }
        Assertions.assertTrue(isSorted); // ожидание значения переменной isSorted == true
    }

}
