import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MainTest {

    @Test
    public void testGetListOfStringStartWith_shouldReturnListOfString1() {
        String[] strings = new String[]{"Hello world", "Hello Andy", "Java is the best", "Hell", "Say Hello!", "hello Java", "Hellogen"};
        ArrayList<String> expectedResult = new ArrayList<>();
        expectedResult.add("Hello world");
        expectedResult.add("Hello Andy");
        expectedResult.add("Hellogen");
        ArrayList<String> actualResult = Main.getListOfStringStartWith(strings, "Hello");
        Assertions.assertEquals(expectedResult, actualResult);
    }
    @Test
    public void testGetListOfStringStartWith_shouldReturnListOfString2() {
        String[] strings = new String[]{"Hello world", "Hello Andy", "Java is the best", "Hell", "Say Hello!", "hello Java", "Hellogen"};
        ArrayList<String> expectedResult = new ArrayList<>();
        expectedResult.add("hello Java");
        ArrayList<String> actualResult = Main.getListOfStringStartWith(strings, "hello");
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetListOfStringStartWith_shouldReturnListOfString3() {
        String[] strings = new String[0];
        ArrayList<String> expectedResult = new ArrayList<>();
        ArrayList<String> actualResult = Main.getListOfStringStartWith(strings, "Hello");
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetListOfStringStartWith_shouldReturnListOfString4() {
        ArrayList<String> expectedResult = new ArrayList<>();
        ArrayList<String> actualResult = Main.getListOfStringStartWith(null, "Hello");
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
