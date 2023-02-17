import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> nums1 = List.of(3, 6, 7, 8);
        List<Integer> nums2 = List.of(2, 8, 9, 9, 12, 15);
        System.out.println(method2(nums1, nums2));

    }

    public static List<Integer> method(List<Integer> list1, List<Integer> list2) {
        List<Integer> res = new ArrayList<>(list1);
        res.addAll(list2);
        res.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        return res;
    }

    public static List<Integer> method2(List<Integer> list1, List<Integer> list2) {
        if (list1 == null || list2 == null) return null;
        List<Integer> res = new ArrayList<>();
        int i1 = 0, i2 = 0;
        while (i1 < list1.size() && i2 < list2.size()) {
            res.add(list1.get(i1) < list2.get(i2) ? list1.get(i1++) : list2.get(i2++));
        }
        while (i1 < list1.size()) {
            res.add(list1.get(i1++));
        }
        while (i2 < list2.size()) {
            res.add(list2.get(i2++));
        }
        return res;
    }

}