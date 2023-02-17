public class Main {
    public static void main(String[] args) {

        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("Opel");
        myLinkedList.add("Audi");
        myLinkedList.addFirst("BMW");
        myLinkedList.add("Porsche");
        myLinkedList.addFirst("Ferrari");
        System.out.println(myLinkedList);
        System.out.println("size: " + myLinkedList.size());

        int index = 3;
        System.out.println("get by index["+ index + "]: " + myLinkedList.get(index));
        System.out.println("-----------------");

        MyLinkedList<MyClass> list2 = new MyLinkedList<>();
        list2.add(new MyClass("take it", 15));
        list2.add(new MyClass("no doubt", 10.4));
        list2.add(new MyClass("obey", -99));
        System.out.println(list2);
        System.out.println(list2.get(1));


    }
}