package edu.finki.np.lab4;

public class Node<T extends Comparable<T>>{

	private Node<T> next;
	private Node<T> previous;
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

	public void setElement(T element){
		this.element = element;
	}
	
	public Node<T> getNext() {
		return next;
	}
	
	public Node<T> getPrevious() {
		return previous;
	}

	public void setNext(Node<T> elem) {
		next = elem;
	}
	
	public void setPrevious(Node<T> elem) {
		previous = elem;
	}

	@Override
	public boolean equals(Object obj) {
		T elem = (T) obj;
		if(element == elem)
			return true;
		else
			return false;
	}
	
	@Override
	public String toString() {
		return element.toString();
	}

}
