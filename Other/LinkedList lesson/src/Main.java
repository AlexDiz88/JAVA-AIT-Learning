public class Main {
    public static void main(String[] args) {

        MyLinkedList myList = new MyLinkedList();

        myList.add("Car");
        myList.add("Bicycle");
        myList.add("Moto");
        myList.add("Truck");

        System.out.println("First element in myList: " + myList.getFirst());
        System.out.println(" Last element in myList: " + myList.getLast());

        System.out.println("---------------");
        myList.addFirst("Ship");
        System.out.println("First element in myList: " + myList.getFirst());
        System.out.println(" Last element in myList: " + myList.getLast());

        System.out.println("---------------");
        myList.add("Airplane");
        System.out.println("First element in myList: " + myList.getFirst());
        System.out.println(" Last element in myList: " + myList.getLast());

        System.out.println("-------print all--------");
        myList.printAll();
        System.out.println("myList size = " + myList.size());
    }
}
