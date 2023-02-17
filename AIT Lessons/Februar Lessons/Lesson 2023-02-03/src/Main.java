/*
Дан массив, с указанием пути в виде последовтельных инструкций "NORTH", "SOUTH", "WEST", "EAST".
 Очевидно, что идущие подряд противоположные инструкции {... "NORTH", "SOUTH"....} не имеют полезного
 результата, и  могут быть сокращены. В то время как набор инструкций {"NORTH","SOUTH", "SOUTH"} - вполне
 валидный. Написать метод, который оптимизирует набор инструкций

{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"} -> {"WEST"}
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("NORTH", "WEST", "SOUTH", "EAST", "NORTH", "NORTH", "WEST");
        optimizedPath(list);

    }

    public static List<String> optimizedPath(List<String> path) {
        Map<String, String> map = new HashMap<>();
        map.put("NORTH", "SOUTH");
        map.put("SOUTH", "NORTH");
        map.put("EAST", "WEST");
        map.put("WEST", "EAST");
        Deque<String> stack = new LinkedList<>();
        for (String direction : path) {
            if (map.get(direction).equals(stack.peek())) {
                stack.pop();
            } else {
                stack.push(direction);
            }
        }
        List<String> result = new ArrayList<>(stack);
        Collections.reverse(result);
        return result;
    }
}