package doublylinkedlist;

public class DoublyLinkedList<T> {
    private static class Node<E> {
	private E element;
	private Node<E> next;
	private Node<E> previous;

	public Node(E element, Node<E> next, Node<E> previous) {
	    this.element = element;
	    this.previous = previous;
	    this.next = next;
	}
    }

    private Node<T> first, last;

    public DoublyLinkedList() {
	this.first = null;
	this.last = null;
    }

    public boolean isEmpty() {
	return this.first == null && this.last == null;
    }

    public T first() {
	return this.first.element;
    }

    public T last() {
	return this.last.element;
    }

    public int size() {
	int i;
	if (this.isEmpty()) {
	    i = 0;
	} else {
	    i = 0;
	    Node<T> aux = first;
	    while (aux != null) {
		aux = aux.next;
		i++;
	    }
	}
	return i;
    }

    public void insertFirst(T elem) {
	if (this.first == null) {
	    this.first = new Node<T>(elem, null, null);
	    last = first;
	} else {
	    Node<T> auxNode = new Node<T>(elem, first, null);
	    first.previous = auxNode;
	    first = auxNode;
	}
    }

    public void insertLast(T elem) {
	if (first == null) {
	    last = new Node<T>(elem, null, null);
	    first = last;
	} else {
	    Node<T> auxNode = new Node<T>(elem, null, last);
	    last.next = auxNode;
	    last = auxNode;
	}
    }

    public void deleteFirst() throws DoublyLinkedListException {
	if (first == null) {
	    throw new DoublyLinkedListException("Node is Empty");
	} else {
	    first = first.next;
	    first.previous = null;
	}
    }

    public void deleteLast() throws DoublyLinkedListException {
	if (first == null) {
	    throw new DoublyLinkedListException("Node is Empty");
	} else {
	    last = last.previous;
	    last.next = null;
	}
    }

    public String toString() {
	Node<T> aux = first;
	String message = "";
	while (aux != null) {
	    message = message + aux.element + " ";
	    aux = aux.next;
	}
	return message;
    }

    public boolean search(T elem) {
	boolean search = false;
	Node<T> aux = first;
	while (!search && aux != null) {
	    if (aux.element.equals(elem)) {
		search = true;
	    } else {
		aux = aux.next;
	    }
	}
	return search;
    }

    public DoublyLinkedList<T> reverseList() {
	DoublyLinkedList<T> list = new DoublyLinkedList<T>();
	Node<T> aux = last;
	while (aux != null) {
	    list.insertLast(aux.element);
	    aux = aux.previous;
	}
	return list;
    }

    public void insertIndex(int index, T elem) throws DoublyLinkedListException {
	if (index>this.size()){
	    throw new DoublyLinkedListException("Incorrect Index");
	}
	if (index == 0) {
	    this.insertFirst(elem);
	} else if (index == this.size()) {
	    this.insertLast(elem);
	} else {
	    int var= index;
	    Node<T> auxcurrent = first;
	    Node<T> auxprevious = null;
	    while (auxcurrent != null && var >0) {
		auxprevious = auxcurrent;
		auxcurrent = auxcurrent.next;
		var--;
	    }
	    Node<T> newNode = new Node<T>(elem, auxcurrent, auxprevious);
	    auxprevious.next = newNode;
	    auxcurrent.previous = newNode;
	}
    }

}
