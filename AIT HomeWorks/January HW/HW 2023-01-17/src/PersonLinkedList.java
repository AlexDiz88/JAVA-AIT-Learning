public class PersonLinkedList {

    private Node first;
    private Node last;
    private int size;

    public Person remove(int index) {
        if (index < 0 && index > size) return null;
        Node temp = first;
        int counter = 0;
        while (temp != null) {
            if (index == counter) {
                if (temp == first) {
                    first.next.prev = null;
                    first = first.next;
                    break;
                }
                if (temp == last) {
                    last.prev.next = null;
                    last.prev = last;
                    break;
                }
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                break;
            }
            temp = temp.next;
            counter++;
        }
        size--;
        return temp.element;
    }

    public boolean remove(Person person) {
        Node temp = first;
        while (temp != null) {
            if (temp.element.equals(person)) {
                if (temp == first) {
                    first.next.prev = null;
                    first = first.next;
                    size--;
                    return true;
                }
                if (temp == last) {
                    last.prev.next = null;
                    last.prev = last;
                    size--;
                    return true;
                }
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                size--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public boolean addFirst(Person person) {
        Node temp = first;
        Node newNode = new Node(null, person, temp);
        first = newNode;
        if (temp == null) {
            last = newNode;
        } else {
            temp.prev = newNode;
        }
        size++;
        return true;
    }

    public boolean add(Person person) {
        Node temp = last;
        Node newNode = new Node(temp, person, null);
        last = newNode;
        if (temp == null) {
            first = newNode;
        } else {
            temp.next = newNode;
        }
        size++;
        return true;
    }

    public String getNode(int index) {
        if (index >= 0 && index <= size) {
            Node temp = first;
            int counter = 0;
            while (temp != null) {
                if (index == 0) {
                    return null + ", " + temp.element + ", " + temp.next.element;
                }
                if (counter == size-1) {
                    return temp.prev.element + ", " + temp.element + ", " + null;
                }
                if (index == counter) {
                    return temp.prev.element + ", " + temp.element + ", " + temp.next.element;
                }
                temp = temp.next;
                counter++;
            }
        }
        return null;
    }

    public Person get(int index) {
        if (index >= 0 && index <= size) {
            Node temp = first;
            int counter = 0;
            while (temp != null) {
                if (index == counter) {
                    return temp.element;
                }
                temp = temp.next;
                counter++;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    public Person getFirst() {
        return first.element;
    }

    public Person getLast() {
        return last.element;
    }

    @Override
    public String toString() {
        String result = "";
        if (size > 0) {
            Node temp = first;
            while (temp != null) {
                if (temp == first) {
                    result += temp.element;
                } else {
                    result += "\n" + temp.element;
                }
                temp = temp.next;
            }
        }
        return result;
    }

    private class Node {
        Node prev;
        Person element;
        Node next;

        public Node(Node prev, Person element, Node next) {
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





