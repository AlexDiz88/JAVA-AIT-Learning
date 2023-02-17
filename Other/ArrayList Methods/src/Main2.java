import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("A");
        StringBuilder sb2 = new StringBuilder("B");
        StringBuilder sb3 = new StringBuilder("C");
        StringBuilder sb4 = new StringBuilder("D");
        StringBuilder sb5 = new StringBuilder("E");
        StringBuilder[] myArray = {sb1, sb2, sb3, sb4, sb5};

        // append()
        sb1.append("lex"); // добавляет текст к существующему (для StringBuilder, т.к. он мутабелен)
        System.out.println(sb1);

        //----------------------------------------------------------------------------------//
        // Arrays.asList(),
        List<StringBuilder> list = Arrays.asList(myArray);
        System.out.println(list); // связан с myArray, длина измениться не может
//      list.add(new StringBuilder("F")); // ERROR! UnsupportedOperationException
//      System.out.println(list);

        // все изменения с myArray влияют и на list
        myArray[0] = new StringBuilder("Max");
        System.out.println(list);
        System.out.println("-".repeat(21));

        //----------------------------------------------------------------------------------//
        // retainAll, removeAll, containsAll
        ArrayList<String> stringArrayList1 = new ArrayList<>();
        stringArrayList1.add("Alex");
        stringArrayList1.add("Boris");
        stringArrayList1.add("Denis");
        stringArrayList1.add("Serj");
        stringArrayList1.add("Max");
        System.out.println(stringArrayList1);

        ArrayList<String> stringArrayList2 = new ArrayList<>();
        stringArrayList2.add("Denis");
        stringArrayList2.add("Serj");
        stringArrayList2.add("Igor");
        System.out.println(stringArrayList2);

        boolean containsAll = stringArrayList1.containsAll(stringArrayList2); // проверяет, содержит ли 1й лист все элементы 2го листа.
        System.out.println("содержит ли 1й лист все элементы 2го листа? = " + containsAll);

        stringArrayList1.retainAll(stringArrayList2); // оставляет в листе только элементы которые есть во 2ом листе
        System.out.println(stringArrayList1);

        stringArrayList1.removeAll(stringArrayList2); // удаляет все найденные элементы. Если элемент не найден, ничего не произойдет
        System.out.println(stringArrayList1);
        System.out.println("-".repeat(21));

        //----------------------------------------------------------------------------------//
        // subList (int fromIndex, int toIndex) --> List<E> - view на отрывок list. Это НЕ создание новой сущности(листа)!
        ArrayList<String> stringArrayList3 = new ArrayList<>();
        stringArrayList3.add("Mike");
        stringArrayList3.add("John");
        stringArrayList3.add("Andrew");
        stringArrayList3.add("Jenny");
        stringArrayList3.add("Ashley");
        System.out.println("ArrayList3 = " + stringArrayList3);
        List<String> subList = stringArrayList3.subList(1, 4);// последний индекс НЕвключительно (как всегда)
        System.out.println("subList = " + subList);
        System.out.println("-".repeat(21));

        // все изменения в subList отражаются на родительском list (это доказывает, что эти lists общая сущность)
        subList.add("KARL");
        System.out.println("subList after adding to subList = " + subList);
        System.out.println("ArrayList3 after adding to subList = " + stringArrayList3);

        // при этом если добавить в родительский лист новый элемент,
        // то старый subList view больше работать не будет и выдаст ошибку
        stringArrayList3.add("---Bob---");
        // System.out.println("subList after adding to ArrayList3 = " + subList); // ERROR! ConcurrentModificationException
        System.out.println("ArrayList3 = " + stringArrayList3);
        System.out.println("-".repeat(21));

        //----------------------------------------------------------------------------------//
        // toArray(Type[] arr) --> Type[]
        String[] myArray2 = stringArrayList3.toArray(new String[0]);
        // если указать длину *больше* кол-ва реальных элементов, то лишние ячейки массива будут заполнены null.
        // если указать длину *меньше* кол-ва реальных элементов, то JAVA сама создаст массив нужного размера,
        // поэтому чаще всего пишут toArray(new Type[0]);
        for (String str : myArray2) {
            System.out.println(str);
        }
        System.out.println("-".repeat(21));

        //----------------------------------------------------------------------------------//
        // List.of(E ... elements) --> List<E> - неизменяемый list
        // List.copyOf(Collection <E> c) --> List<E> - неизменяемый list
        List<Integer> list3 = List.of(3, 8, 12); // НЕ могут содержать null
        System.out.println(list3);
        // list3.add(7); // ERROR! UnsupportedOperationException (т.к. данный list неизменяемый)
        List<String> list4 = List.copyOf(stringArrayList2); // получаем неизменяемую копию list
        System.out.println(list4);

    }
}
