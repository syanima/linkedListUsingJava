public class Node<type> {
    private final type value;
    private Node next;
    private Node previous;

    public Node(type num) {
        this.value = num;
    }

    public void next(Node other) {
        this.next = other;
    }

    public type getValue() {
        return this.value;
    }

    public void previous(Node last) {
        this.previous = last;
    }

    public Node getPrevious() {
        return this.previous;
    }

    public Node getNext() {
        return this.next;
    }
}
