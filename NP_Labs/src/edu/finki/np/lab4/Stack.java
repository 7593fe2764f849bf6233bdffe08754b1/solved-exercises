package edu.finki.np.lab4;

import java.util.EmptyStackException;
import edu.finki.np.lab3.Node;

public class Stack<T> {

	private Node<T> top;
	private int N;
	
	public Stack(){
		N = 0;
	}
	
	public void push(T element){
		Node<T> newTop = new Node<T>(element, top);
		top = newTop;
		N++;
	}
	
	public T peek(){
		if(isEmpty())
			throw new EmptyStackException();
		return top.getElement();
	}
	
	public T pop(){
		if(isEmpty())
			throw new EmptyStackException();
		T element = top.getElement();
		top = top.getNext();
		N--;
		return element;
	}
	
	public boolean isEmpty(){
		return N==0;
	}
	
}
