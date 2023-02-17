import java.util.ArrayList;

public class IteratorExample {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Mike");
        arrayList1.add("Jenny");
        arrayList1.add("John");
        arrayList1.add("Andrew");
        arrayList1.add("Jenny");
        arrayList1.add("Ashley");
        arrayList1.add("Jenny");
        arrayList1.add("Jenny");

        java.util.Iterator<String> iterator = arrayList1.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        iterator = arrayList1.iterator(); // iterator необходимо обновлять (сбрасывать позицию), иначе он останется в конце list
        while (iterator.hasNext()) {
            if (iterator.next().equals("Jenny")) {
                iterator.remove();
            }
        }
        System.out.println(arrayList1);

    }
}