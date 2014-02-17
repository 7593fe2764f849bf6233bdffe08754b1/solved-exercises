package edu.finki.np.lab3;

import java.util.LinkedList;

public class Queue<T> {

	private Node<T> first;
	private int numElements;

	public Queue() {
		numElements = 0;
		first = new Node<T>();
	}

	public boolean isEmpty() {
		return numElements == 0;
	}

	public void enqueue(T element) {
		Node<T> node = new Node<T>(element,null);
		Node<T> iterator = first;
		while(iterator.getNext()!=null){
			iterator = iterator.getNext();
		}
		iterator.setNext(node);
		numElements++;
	}
	
	public T dequeue() throws EmptyQueueException{
		if(isEmpty())
			throw new EmptyQueueException();
		first = first.getNext();
		numElements--;
		return first.getElement();
	}

	public int count() {
		return numElements;
	}
	
	public T peek() throws EmptyQueueException {
		if(isEmpty())
			throw new EmptyQueueException();
		return first.getNext().getElement();
	}
	
	public T inspect() throws EmptyQueueException {
		if(isEmpty())
			throw new EmptyQueueException();
		Node<T> iterator = first;
		while(iterator.getNext()!=null)
			iterator = iterator.getNext();
		return iterator.getElement();
	}

}
