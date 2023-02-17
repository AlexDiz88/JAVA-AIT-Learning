import java.util.ArrayList;

public class Minitasks {
    public static void main(String[] args) {

        ArrayList<Integer> myList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            myList.add(getRandomNumber(0, 20));
        }
        System.out.println(myList);
        System.out.println(check(myList));
    }

    public static int getRandomNumber(int min, int max) {
        return (int) (min + Math.random() * (max - min + 1));
    }

    public static boolean check(ArrayList<Integer> list) {
        if (list.size() < 3) return false;
        for (int i = 0; i < list.size()-2; i++) {
            if (list.get(i + 2) == list.get(i + 1) + list.get(i)) {
                return true;
            }
        }
        return false;
    }
}
