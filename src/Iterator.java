
public class Iterator<type> {
    private int nextCursor;
    private final LinkedList<type> list;
    private int hasNextCursor;

    public Iterator(LinkedList<type> list) {
        this.list = list;
        this.hasNextCursor = 0;
        this.nextCursor = 0;
    }

    public boolean hasNext() {
        boolean result = this.hasNextCursor < list.getLength();
        this.hasNextCursor++;
        return result;
    }

    public Object next() {
        nextCursor++;
        return list.findAt(nextCursor - 1);
    }

    public void remove() {
        Node previousElement = list.getHead();
        Node currentElement;
        if (nextCursor == 0)
            list.moveHead(previousElement.getNext());
        else
            for (int i = 0; i < nextCursor; i++) {
                if (nextCursor - 1 == i)
                    break;
                previousElement = previousElement.getNext();
            }
        currentElement = previousElement.getNext();
        previousElement.next(currentElement.getNext());
        currentElement.getNext().previous(previousElement);
        list.decrementLength();
    }
}
