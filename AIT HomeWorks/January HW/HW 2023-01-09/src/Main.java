import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> myList = new ArrayList<>();
        addRandomNumbersToList(myList, 10);
        System.out.println(myList);
    }

    public static int getRandomNumber(int min, int max) {
        return (int) (min + Math.random() * (max - min + 1));
    }

    public static void addRandomNumbersToList(List<Integer> list, int n) {
        for (int i = 0; i < n; i++) {
            int randomNum = getRandomNumber(0, 100);
            for (int j = 0; j <= list.size(); j++) {
                if (list.size() == 0 || randomNum < list.get(j)) {
                    list.add(j, randomNum);
                    break;
                }
                if (j == list.size() - 1) {
                    list.add(randomNum);
                    break;
                }
            }
        }
    }
}