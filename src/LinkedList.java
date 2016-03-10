import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<type> {
    private int length;
    private Node head;
    private Node tail;


    public LinkedList() {
        this.length = 0;
    }

    public void add(type ele) {
        Node<type> e = new Node<>(ele);
        if (this.length == 0)
            this.head = this.tail = e;
        else {
            Node last = this.tail;
            this.tail.next(e);
            e.previous(last);
            this.tail = e;
        }
        this.length++;
    }

    public int getLength() {
        return this.length;
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

    public Object findAt(int index) {
        Node element = this.head;
        Object result = null;
        if(index < this.length) {
            for (int i = 0; i < this.length; i++) {
                if (index == i) result = element.getValue();
                element = element.getNext();
            }
            return result;
        }
        throw new NoSuchElementException("Element not found");
    }

    public Iterator Iterator() {
        return new Iterator<type>(this);
    }

    public void moveHead(Node next) {
        this.head = next;
    }

    public void decrementLength() {
        this.length--;
    }
}
