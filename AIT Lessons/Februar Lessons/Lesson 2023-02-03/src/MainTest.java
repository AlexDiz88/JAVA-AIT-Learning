import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MainTest {

    @Test
    void optimizedPath() {
        List<String> list = List.of("NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST");
        List<String> actualResult = Main.optimizedPath(list);
        List<String> expectedResult = List.of("WEST");
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void optimizedPath_alreadyOptimized() {
        List<String> list = List.of("NORTH", "WEST", "SOUTH", "EAST", "NORTH", "NORTH", "WEST");
        List<String> actualResult = Main.optimizedPath(list);
        List<String> expectedResult = List.of("NORTH", "WEST", "SOUTH", "EAST", "NORTH", "NORTH", "WEST");
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
