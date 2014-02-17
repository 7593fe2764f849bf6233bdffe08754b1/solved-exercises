package edu.finki.np.lab3;

public class Node<T> {

	private Node<T> next;
	private T element;

	public Node() {
		next = null;
	}

	public Node(T elem, Node<T> n) {
		element = elem;
		next = n;
	}

	public T getElement() {
		return element;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> elem) {
		next = elem;
	}
}
