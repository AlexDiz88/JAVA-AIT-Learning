import java.util.*;

public class Main {
    public static void main(String[] args) {

        /*
        В TreeSet:
        - как и в любом Set все элементы уникальны (нельзя хранить дубли)
        - НЕ позволяет хранить значения null
        - нет индекса и не сохраняется порядок добавления
        - это SortedSet т.е. элементы хранятся в отсортированном виде (по возрастанию)
        - сравнение элементов (в том числе определение равенства) осуществляется стандартными интерфейсами Comparable, Comparator
        */

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(12);
        treeSet.add(8);
        treeSet.add(1);
        treeSet.add(4);
        System.out.println("treeSet: " + treeSet + "\n");

        // retainAll() - оставляет в коллекции только те элементы, которые встречаются во второй коллекции
        System.out.println("-----retainAll-----");
        List<Integer> listOfNumbers = List.of(1, 2, 3, 4, 5, 7, 8, 9, 10);
        System.out.println("listOfNumbers: " + listOfNumbers);
        treeSet.retainAll(listOfNumbers);
        System.out.println("treeSet после retainAll: " + treeSet + "\n");

        // first() / last() - получение первого/последнего элемента
        System.out.println("-----first/last-----");
        System.out.println("first: " + treeSet.first());
        System.out.println("last: " + treeSet.last() + "\n");

        // lower() / higher() - получение предыдущего/следующего элемента (НЕвключительно)
        System.out.println("-----lower/higher-----");
        System.out.println("lower: " + treeSet.lower(4));
        System.out.println("higher: " + treeSet.higher(4) + "\n");

        // ceiling() - возвращает ближайшее значение справа от элемента, либо сам элемент (если он есть). Если такого элемента нет, возвращает null
        System.out.println("-----ceiling-----");
        Integer ceiling = treeSet.ceiling(4);
        Integer ceiling2 = treeSet.ceiling(6);
        System.out.println("ceiling (сам элемент, если он есть в TreeSet) = " + ceiling);
        System.out.println("ceiling (следующий элемент после указанного, если сам элемент отсутвтвует) = " + ceiling2 + "\n");

        // floor() - возвращает ближайшее значение слева от элемента, либо сам элемент (если он есть). Если такого элемента нет, возвращает null
        System.out.println("-----floor-----");
        System.out.println(treeSet.floor(7) + "\n");

        // descendingSet() - возвращает TreeSet в обратном порядке. Тип NavigableSet либо SortedSet
        System.out.println("-----descendingSet(обратный порядок)-----");
        NavigableSet<Integer> descendingSet = treeSet.descendingSet();
        System.out.println(descendingSet + "\n");


        // ---------------------------------------------------------------------- //
        // headSet() - возвращет view (типа SortedSet) на набор элементов TreeSet от начала до указанного элемента (НЕвключительно)
        // Все изменения в TreeSet отражаются на данном view и наоборот (это относится ко всем подмножествам headSet/tailSet/subSet)
        System.out.println("-----headSet-----");
        SortedSet<Integer> headSet = treeSet.headSet(5);
        System.out.println(headSet);

        // headSet(e, boolean inclusive) - работает аналогично, но ВКЛЮЧАЕТ последний элемент при значении true
        // Также в отличии от обычного метода, может вернуть NavigableSet вместо SortedSet.
        // SortedSet использует методы Set, а NavigableSet методы TreeSet
        System.out.println("-----headSet(boolean inclusive)-----");
        NavigableSet<Integer> headSet2 = treeSet.headSet(5, true);
        System.out.println(headSet2 + "\n");

        // tailSet() - возвращет view (типа SortedSet) на набор элементов TreeSet от указанного элемента (включительно) и до конца
        System.out.println("-----tailSet-----");
        SortedSet<Integer> tailSet = treeSet.tailSet(5);
        System.out.println(tailSet);

        // tailSet(e, boolean inclusive) - можно указать boolean false для исключения указанного элемента
        // Может вернуть NavigableSet вместо SortedSet.
        System.out.println("-----tailSet(boolean inclusive)-----");
        NavigableSet<Integer> tailSet2 = treeSet.tailSet(5, false);
        System.out.println(tailSet2 + "\n");

        // subSet() - возвращает view (типа SortedSet) на набор элементов TreeSet между указанных значений(НЕиндексов!) (последнее НЕвключительно)
        System.out.println("-----subSet-----");
        SortedSet<Integer> subSet = treeSet.subSet(4, 8);
        System.out.println(subSet);

        // subSet(e1, boolean, e2, boolean) - можно указать boolean для каждого значения. true - включать, false - не включать.
        // Может вернуть NavigableSet вместо SortedSet.
        System.out.println("-----subSet(boolean inclusive)-----");
        NavigableSet<Integer> subSet2 = treeSet.subSet(4, false, 8, true);
        System.out.println(subSet2 + "\n");

        // ---------------------------------------------------------------------- //
        // pollFirst() / pollLast() - удаляет первый/последний элемент. Если таких нет - вернёт null
        System.out.println("-----pollFirst/pollLast-----");
        treeSet.pollFirst();
        treeSet.pollLast();
        System.out.println("treeSet после удаления крайних значений:" + treeSet + "\n");

        // ---------------------------------------------------------------------- //
        // добавление собственных классов требует наличие Comparable / Comparator
        System.out.println("-----ownClass(with Comparable)-----");
        TreeSet<Student> studentTreeSet = new TreeSet<>();
        studentTreeSet.add(new Student("Zoya", 17, 1));
        studentTreeSet.add(new Student("Lili", 19, 3));
        studentTreeSet.add(new Student("Mika", 21, 5));
        studentTreeSet.add(new Student("Dina", 18, 2));
        System.out.println(studentTreeSet + "\n");

        // добавление другой коллекции с применением конкретного Comparator происходит в 2 шага:
        // Сначала указываем Comparator у TreeSet, затем используем метод addAll
        System.out.println("-----copyTreeSet(с особым ComparatorByAge)-----");
        TreeSet<Student> studentTreeSetByAge = new TreeSet<>(new ComparatorByAge());
        studentTreeSetByAge.addAll(studentTreeSet);
        System.out.println(studentTreeSetByAge + "\n");

        // comparator() - возвращает ссылку на Comparator, применённый в TreeSet
        // Если в компараторе определить toString(), то вместо ссылки будет нужный текст
        System.out.println("-----comparator-----");
        TreeSet<Student> students1 = new TreeSet<>(new ComparatorByAge());
        Comparator<? super Student> comparator1 = students1.comparator();
        System.out.println(comparator1);
        TreeSet<Student> students2 = new TreeSet<>(new ComparatorByCourse());
        Comparator<? super Student> comparator2 = students2.comparator();
        System.out.println(comparator2 + "\n");

        // Хранение элементов в TreeSet основано на логике работы указанного Comparator (либо Comparable),
        // поэтому получение любых подмножеств с помощью headSet/tailSet/subSet происходит за счёт сравнения по Comparator/Comparable
        // Мы можем создать TreeSet, где наши студенты отсортированы по возрасту (за счет ComparatorByAge),
        // и отобрать множество студентов по нужному нам диапазону, но нужно указать полный объект класса.
        // При этом мы можем указать любые значения в других полях (так как они не играют роли)
        System.out.println("-----subSet by ownClass-----");
        TreeSet<Student> ourStudents = new TreeSet<>(new ComparatorByAge()); // выбираем компаратор
        ourStudents.addAll(studentTreeSet); // добавляем студентов
        Student lowAgeBorder = new Student("", 18, 0); // студент-болванка
        Student highAgeBorder = new Student("", 20, 0); // нас интересует только возраст
        NavigableSet<Student> subSetStudents = ourStudents.subSet(lowAgeBorder, true, highAgeBorder, true);
        System.out.println("All students by 18-20 age: " + subSetStudents + "\n");

        // Если мы не хотим создавать отдельный класс Comparator, то мы можем использовать анонимный класс
        // и сразу же реализовать способ сравнения
        System.out.println("-----anonymous Class for Comparator (by Course)-----");
        TreeSet<Student> experiencedStudents = new TreeSet<>(new Comparator<Student>() {
            @Override // создаем и реализуем анонимный класс и метод compare()
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.getCourse(), o2.getCourse());
            }
        });
        experiencedStudents.addAll(studentTreeSet); // добавляем студентов
        System.out.println(experiencedStudents + "\n");
    }
}