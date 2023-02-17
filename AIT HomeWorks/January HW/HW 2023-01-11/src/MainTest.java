import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

    @Test
    public void test_addStrings() {
        String s1 = "I";
        String s2 = "do";
        String s3 = "my";
        String s4 = "homework";

        List<String> testList = new ArrayList<>();
        testList.add(s1);
        testList.add(s2);
        testList.add(s3);
        testList.add(s4);

        String expectedResult = "I do my homework";
        String actualResult = Main.addStrings(testList);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_addStrings2() {
        String s1 = "I";
        String s2 = "do";
        String s3 = null;
        String s4 = "homework";

        List<String> testList = new ArrayList<>();
        testList.add(s1);
        testList.add(s2);
        testList.add(s3);
        testList.add(s4);

        String expectedResult = "I do homework";
        String actualResult = Main.addStrings(testList);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_addStrings3() {
        String s1 = "I";
        String s2 = "do";
        String s3 = "";
        String s4 = "homework";

        List<String> testList = new ArrayList<>();
        testList.add(s1);
        testList.add(s2);
        testList.add(s3);
        testList.add(s4);

        String expectedResult = "I do homework";
        String actualResult = Main.addStrings(testList);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_userToString() {
        User u1 = new User("Joe", "Sakic", 33);

        String actualResult = u1.toString();
        String expectedResult = "Joe Sakic (33)";

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test_changeNames() {
        User testUser = new User("Sakic", "Joe", 33);
        User actualResultUser = Main.changeNames(testUser);

        User expectedResultUser = new User("Joe", "Sakic", 33);

        Assertions.assertEquals(expectedResultUser, actualResultUser);
    }




}
