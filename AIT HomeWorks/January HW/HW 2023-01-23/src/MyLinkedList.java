public class MyLinkedList<E> {

    private Node first;
    private Node last;
    private int size;

    public boolean add(E element) {
        Node t = last;
        Node newNode = new Node(t, element, null);
        last = newNode;
        if (t == null) {
            first = newNode;
        } else {
            t.next = newNode;
        }
        size++;
        return true;
    }

    public boolean addFirst(E element) {
        Node t = first;
        Node newNode = new Node(null, element, t);
        first = newNode;
        if (t == null) {
            last = newNode;
        } else {
            t.prev = newNode;
        }
        size++;
        return true;
    }

    public E get(int index) {
        if (index >= 0 && index < size) {
            Node t = first;
            int counter = 0;
            while (t != null) {
                if (index == counter) {
                    return t.element;
                }
                t = t.next;
                counter++;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    public E getFirst() {
        return first.element;
    }

    public E getLast() {
        return last.element;
    }

    @Override
    public String toString() {
        String res = "";
        Node temp = first;
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                res += temp.element;
            } else {
                res += temp.element + ", ";
            }
            temp = temp.next;
        }
        return "[" + res + "]";
    }

    private class Node {
        private Node prev;
        private E element;
        private Node next;

        public Node(Node prev, E element, Node next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }
}

