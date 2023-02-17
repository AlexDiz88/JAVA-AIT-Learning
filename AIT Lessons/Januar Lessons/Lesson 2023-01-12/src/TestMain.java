import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

    @Test
    public void test_addBrackets() {
        String s1 = "Jack";
        List<String> testList = new ArrayList<>();
        testList.add(s1);
        List<String> actualList = Main.addBrackets(testList);

        List<String> expectedlist = new ArrayList<>();
        expectedlist.add("(Jack)");

        Assertions.assertEquals(expectedlist, actualList);
    }
}
