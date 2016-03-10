import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class LinkedListTest {
    @Test
    public void testListShouldAddAnElement() throws Exception {
        LinkedList<Integer> l = new LinkedList<>();
        l.add(5);
        assertEquals(1, l.getLength());
    }

    @Test
    public void testListHeadShouldBeTheFirstElement() throws Exception {
        LinkedList<Integer> l = new LinkedList<>();
        l.add(1);
        assertEquals(1, l.getHead().getValue());
    }

    @Test
    public void testListTailShouldBeTheFirstElementIfOneElementExist() throws Exception {
        LinkedList<Integer> l = new LinkedList<>();
        l.add(45);
        assertEquals(45, l.getTail().getValue());
    }

    @Test
    public void testListTailShouldPointToTheLastElementAndHeadToTheFirstElement() throws Exception {
        LinkedList<Integer> l = new LinkedList<>();
        l.add(45);
        l.add(10);
        assertEquals(10, l.getTail().getValue());
        assertEquals(45, l.getHead().getValue());
    }

    @Test
    public void testCurrentElementPreviousShouldBeTheLastElement() throws Exception {
        LinkedList<Integer> l = new LinkedList<>();
        l.add(45);
        l.add(10);
        assertEquals(45, l.getTail().getPrevious().getValue());
    }

    @Test
    public void testFirstElementNextShouldBeTheCurrentElement() throws Exception {
        LinkedList<Integer> l = new LinkedList<>();
        l.add(45);
        l.add(10);
        assertEquals(10, l.getHead().getNext().getValue());
    }

    @Test
    public void testShouldGiveTheElementCorrespondingToTheIndex() throws Exception {
        LinkedList<Integer> l = new LinkedList<>();
        l.add(45);
        l.add(10);
        l.add(23);
        assertEquals(23, l.findAt(2));
        assertEquals(45, l.findAt(0));
    }

    @Test
    public void testShouldGiveZeroIfElementDoesNotExistForIndex() throws Exception {
        LinkedList<Integer> l = new LinkedList<>();
        l.add(45);
        l.add(10);
        l.add(23);
        try {
            assertEquals("", l.findAt(6));
        } catch (NoSuchElementException e) {
            assertEquals("Element not found", e.getMessage());
        }
    }

    @Test
    public void testLinkedListShouldWorkForDifferentDataType() throws Exception {
        LinkedList<String> l = new LinkedList<>();
        l.add("a");
        l.add("b");
        l.add("c");
        assertEquals("a", l.getHead().getValue());
        assertEquals("b", l.findAt(1));
    }

    @Test
    public void testLinkedListShouldWorkForDifferentDataTypeLikeDouble() throws Exception {
        LinkedList<Double> l = new LinkedList<>();
        l.add(123.12);
        l.add(12.1);
        l.add(0.0);
        assertEquals(123.12, l.getHead().getValue());
        assertEquals(0.0, l.findAt(2));
    }

    @Test
    public void testLinkedListShouldWorkForDifferentDataTypeLikeChar() throws Exception {
        LinkedList<Character> l = new LinkedList<>();
        l.add('z');
        l.add('x');
        l.add('c');
        assertEquals('z', l.getHead().getValue());
        assertEquals('c', l.getTail().getValue());
        assertEquals('x', l.findAt(1));
    }

    @Test
    public void hasNextShouldGiveTrueOrFlaseBasedOntheOccuranceOfElements() throws Exception {
        LinkedList<String> l = new LinkedList<>();
        l.add("hello");
        l.add("world");
        Iterator itr = l.Iterator();
        assertTrue(itr.hasNext());
        assertTrue(itr.hasNext());
        assertFalse(itr.hasNext());
    }

    @Test
    public void nextShouldGiveTheElements() throws Exception {
        LinkedList<String> l = new LinkedList<>();
        l.add("hello");
        l.add("world");
        Iterator itr = l.Iterator();
        assertEquals("hello", itr.next());
        assertEquals("world", itr.next());
    }

    @Test
    public void nextShouldThrowExceptionWhenNextElementIsNotFound() throws Exception {
        LinkedList<String> l = new LinkedList<>();
        l.add("hello");
        l.add("world");
        Iterator itr = l.Iterator();
        assertEquals("hello", itr.next());
        assertEquals("world", itr.next());
        try {
            assertEquals("", itr.next());
        } catch (NoSuchElementException e) {
            assertEquals("Element not found", e.getMessage());
        }
    }

    @Test
    public void removeShouldRemoveTheCurrentElement() throws Exception {
        LinkedList<String> l = new LinkedList<>();
        l.add("a");
        l.add("b");
        l.add("c");
        Iterator itr = l.Iterator();
        itr.next();
        itr.remove();
        assertEquals("a", l.findAt(0));
        assertEquals("c", l.findAt(1));
    }

    @Test
    public void headShouldPointToTheNextElementIfWeRemoveFirstElement() throws Exception {
        LinkedList<String> l = new LinkedList<>();
        l.add("a");
        l.add("b");
        l.add("c");
        Iterator itr = l.Iterator();
        itr.remove();
        assertEquals("b", l.getHead().getValue());
        assertEquals("b", l.findAt(0));
        assertEquals("c", l.findAt(1));
    }
}

