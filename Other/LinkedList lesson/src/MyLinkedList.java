public class MyLinkedList {
    private Node first;
    private Node last;


    public void add(String element) {
        Node temp = last;
        Node newNode = new Node(temp, element, null);
        last = newNode;
        if (temp == null) {
            first = newNode;
        } else {
            temp.next = newNode;
        }
    }

    public String getFirst() {
        return first.value;
    }

    public String getLast() {
        return last.value;
    }

    public void addFirst(String element) {
        first = new Node(null, element, first);
    }

    public void printAll() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public int size() {
        Node temp = first;
        int counter = 0;
        while (temp != null) {
            counter++;
            temp = temp.next;
        }
        return counter;
    }

    private class Node {
        private String value;
        private Node prev;
        private Node next;

        public Node(Node prev, String element, Node next) {
            this.value = element;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return value;
        }
    }
}
