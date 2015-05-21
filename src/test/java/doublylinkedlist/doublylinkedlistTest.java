package doublylinkedlist;

import static org.junit.Assert.*;
import doublylinkedlist.*;
import org.junit.Before;
import org.junit.Test;

public class doublylinkedlistTest {
    private DoublyLinkedList<Integer> list;

    @Before
    public void createNewEmptyList() {
	list = new DoublyLinkedList<Integer>();
    }

    @Test
    public void isEmpty() {
	assertTrue(list.isEmpty());
    }

    @Test
    public void isEmptyWithFirstIsFalse() {
	list.insertFirst(4);
	assertFalse(list.isEmpty());
    }

    @Test
    public void isEmptyWithLastIsFalse() {
	list.insertLast(5);
	assertFalse(list.isEmpty());
    }

    @Test
    public void isFirstElement() throws DoublyLinkedListException {
	Integer[] items = { 1, 2, 3, 4, 5 };
	for (Integer item : items) {
	    list.insertLast(item);
	}
	assertEquals((Integer) 1, list.first());
    }

    public void isLasttElement() throws DoublyLinkedListException {
	Integer[] items = { 1, 2, 3, 4, 5 };
	for (Integer item : items) {
	    list.insertLast(item);
	}
	assertEquals((Integer) 5, list.last());
    }

    @Test(expected = DoublyLinkedListException.class)
    public void throwExceptionInFirstElement() throws DoublyLinkedListException {
	list.first();
    }

    @Test(expected = DoublyLinkedListException.class)
    public void throwExceptionInLastElement() throws DoublyLinkedListException {
	list.last();
    }

    @Test
    public void isZeroEmptyList() {
	assertEquals(0, list.size());
    }

    @Test
    public void sizeIsOneInsertItemInEmptyList() {
	list.insertFirst(1);
	assertEquals(1, list.size());
    }

    @Test
    public void sizeIsXInsertXItemsInEmptyList() {
	Integer[] items = { 1, 2, 3, 4, 5 };
	for (Integer item : items) {
	    list.insertLast(item);
	}
	assertEquals(items.length, list.size());
    }

    @Test
    public void insertFirstElement() throws DoublyLinkedListException {
	list.insertFirst(5);
	list.insertFirst(1);
	assertEquals((Integer) 1, list.first());
    }

    @Test
    public void insertLasttElement() throws DoublyLinkedListException {
	list.insertLast(5);
	list.insertLast(1);
	assertEquals((Integer) 1, list.last());
    }

    @Test
    public void insertFirstElementInEmptyList()
	    throws DoublyLinkedListException {
	list.insertFirst(5);
	assertEquals((Integer) 5, list.first());
    }

    @Test
    public void insertLasttElementInEmptyList()
	    throws DoublyLinkedListException {
	list.insertLast(5);
	assertEquals((Integer) 5, list.last());
    }

    @Test(expected = DoublyLinkedListException.class)
    public void throwExceptionInDeleteFirstElement()
	    throws DoublyLinkedListException {
	list.deleteFirst();
    }

    @Test(expected = DoublyLinkedListException.class)
    public void throwExceptionInDeleteLastElement()
	    throws DoublyLinkedListException {
	list.deleteLast();
    }

    @Test
    public void deleteLastElement() throws DoublyLinkedListException {
	list.insertFirst(1);
	list.insertFirst(2);
	list.deleteLast();
	assertEquals((Integer) 2, list.first());
    }

    @Test(expected = DoublyLinkedListException.class)
    public void deleteLastElementEmpty() throws DoublyLinkedListException {
	list.insertFirst(1);
	list.insertFirst(2);
	list.deleteLast();
	list.deleteLast();
	list.deleteLast();
    }

    @Test(expected = DoublyLinkedListException.class)
    public void deleteFirstElement() throws DoublyLinkedListException {
	list.insertFirst(1);
	list.insertFirst(2);
	list.deleteFirst();
	list.deleteFirst();
	list.deleteFirst();
    }

    @Test
    public void deleteLastElementEmptyTrue() throws DoublyLinkedListException {
	list.insertFirst(1);
	list.insertFirst(2);
	list.deleteLast();
	list.deleteLast();
	assertTrue(list.isEmpty());
    }

    @Test
    public void deleteFirstElementTrue() throws DoublyLinkedListException {
	list.insertFirst(1);
	list.insertFirst(2);
	list.deleteFirst();
	list.deleteFirst();
	assertTrue(list.isEmpty());
    }

    @Test
    public void toStringEmptyElement() {
	assertEquals("", list.toString());
    }

    @Test
    public void toStringOneElement() {
	list.insertFirst(1);
	assertEquals("1 ", list.toString());
    }

    @Test
    public void toStringTwoOrMoreElement() {
	list.insertFirst(1);
	list.insertLast(2);
	list.insertLast(3);
	assertEquals("1 2 3 ", list.toString());
    }

    @Test
    public void searchNoFoundinEmptyList() {
	assertFalse(list.search(5));
    }

    @Test
    public void searchNoFoundinOneElementList() {
	list.insertFirst(1);
	assertFalse(list.search(5));
    }

    @Test
    public void searchNoFoundinTwoOrMoreElementList() {
	list.insertFirst(1);
	list.insertFirst(5);
	list.insertLast(8);
	list.insertFirst(20);
	list.insertLast(-8);
	list.insertFirst(-8000);
	assertFalse(list.search(-80000));
    }

    @Test
    public void searchNegativeFoundinTwoOrMoreElementList() {
	list.insertFirst(1);
	list.insertFirst(5);
	list.insertLast(8);
	list.insertFirst(20);
	list.insertLast(-8);
	list.insertFirst(-8000);
	assertTrue(list.search(-8000));
    }

    @Test
    public void searchPositiveFoundinTwoOrMoreElementList() {
	list.insertFirst(1);
	list.insertFirst(5);
	list.insertLast(8);
	list.insertFirst(20);
	list.insertLast(-8);
	list.insertFirst(-8000);
	assertTrue(list.search(20));
    }

    @Test
    public void searchPositiveFoundinOneElementList() {
	list.insertFirst(1);
	assertTrue(list.search(1));
    }

    @Test
    public void searchPositiveFoundinTwoOrMOreFirstElementList() {
	list.insertFirst(1);
	list.insertFirst(5);
	list.insertLast(8);
	list.insertFirst(20);
	list.insertLast(-8);
	list.insertFirst(-8000);
	assertTrue(list.search(1));
    }

    @Test
    public void searchNegativeFoundinTwoOrMOreFirstElementList() {
	list.insertFirst(-1);
	list.insertFirst(5);
	list.insertLast(8);
	list.insertFirst(20);
	list.insertLast(-8);
	list.insertFirst(-8000);
	assertTrue(list.search(-1));
    }

    @Test
    public void searchPositiveFoundinTwoOrMOreLastElementList() {
	list.insertFirst(1);
	list.insertFirst(5);
	list.insertLast(8);
	list.insertFirst(20);
	list.insertLast(-8);
	list.insertFirst(8000);
	assertTrue(list.search(8000));
    }

    @Test
    public void searchNegativeFoundinTwoOrMOreLastElementList() {
	list.insertFirst(-1);
	list.insertFirst(5);
	list.insertLast(8);
	list.insertFirst(20);
	list.insertLast(-8);
	list.insertFirst(-8000);
	assertTrue(list.search(-8000));
    }

    @Test
    public void searchPositiveFoundinTwoOrMOreMidleElementList() {
	list.insertFirst(1);
	list.insertFirst(5);
	list.insertLast(8);
	list.insertFirst(20);
	list.insertLast(-8);
	list.insertFirst(8000);
	assertTrue(list.search(8));
    }

    @Test
    public void searchNegativeFoundinTwoOrMOreMidleElementList() {
	list.insertFirst(-1);
	list.insertFirst(5);
	list.insertLast(8);
	list.insertFirst(20);
	list.insertLast(-8);
	list.insertFirst(-8000);
	assertTrue(list.search(-8));
    }

    @Test
    public void reverseListTwoOrMoreElement() {
	list.insertFirst(-1);
	list.insertFirst(5);
	list.insertLast(8);
	list.insertFirst(20);
	list.insertLast(-8);
	list.insertFirst(-8000);
	list.reverseList();
	assertEquals("-8000 20 5 -1 8 -8 ", list.toString());
    }

    @Test
    public void reverseListOneElement() {
	list.insertFirst(-1);
	list.reverseList();
	assertEquals("-1 ", list.toString());
    }

    @Test
    public void reverseListEmptyElement() {
	list.reverseList();
	assertEquals("", list.toString());
    }

    @Test
    public void insertIndexinEmpty() throws DoublyLinkedListException {
	list.insertIndex(0, (Integer) 20);
	assertEquals("20 ", list.toString());
    }

    @Test
    public void insertIndexinOneElemntFirst() throws DoublyLinkedListException {
	list.insertFirst(5);
	list.insertIndex(0, (Integer) 20);
	assertEquals("20 5 ", list.toString());
    }

    @Test
    public void insertIndexinOneElemntLast() throws DoublyLinkedListException {
	list.insertFirst(5);
	list.insertIndex(1, (Integer) 20);
	assertEquals("5 20 ", list.toString());
    }

    @Test
    public void insertIndexinTwoOrMoreElemntLast()
	    throws DoublyLinkedListException {
	list.insertFirst(5);
	list.insertLast(50);
	list.insertLast(80);
	list.insertIndex(3, (Integer) 20);
	assertEquals("5 50 80 20 ", list.toString());
    }

    @Test
    public void insertIndexinTwoOrMoreElemntFirst()
	    throws DoublyLinkedListException {
	list.insertFirst(5);
	list.insertLast(50);
	list.insertLast(80);
	list.insertIndex(0, (Integer) 20);
	assertEquals("20 5 50 80 ", list.toString());
    }

    @Test
    public void insertIndexinTwoOrMoreElemntMidle()
	    throws DoublyLinkedListException {
	list.insertFirst(5);
	list.insertLast(50);
	list.insertLast(80);
	list.insertIndex(2, (Integer) 20);
	assertEquals("5 50 20 80 ", list.toString());
    }

    @Test(expected = DoublyLinkedListException.class)
    public void insertIndexPositiveElemntInIndexBad()
	    throws DoublyLinkedListException {
	list.insertFirst(5);
	list.insertLast(50);
	list.insertLast(80);
	list.insertIndex(5465, (Integer) 20);
	assertEquals("20 5 50 80 ", list.toString());
    }

    @Test(expected = DoublyLinkedListException.class)
    public void insertIndexNegativeElemntInIndexBad()
	    throws DoublyLinkedListException {
	list.insertFirst(5);
	list.insertLast(50);
	list.insertLast(80);
	list.insertIndex(-5465, (Integer) 20);
	assertEquals("20 5 50 80 ", list.toString());
    }

}
