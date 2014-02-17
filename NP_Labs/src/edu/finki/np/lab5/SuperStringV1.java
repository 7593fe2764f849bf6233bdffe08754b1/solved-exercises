package edu.finki.np.lab5;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class SuperStringV1 {

	private LinkedList<String> elements;
	private Stack<String> lastAdded;
	
	
	public SuperStringV1(){
		elements = new LinkedList<String>();
		lastAdded = new Stack<String>();
	}
	
	public void append(String s){
		elements.addLast(s);
		lastAdded.push(s);
	}
	
	public void insert(String s){
		elements.addFirst(s);
		lastAdded.push(s);
	}
	
	public boolean contains(String s){
		String z = toString();
		return z.contains(s);
	}
	
	public void reverse(){
		LinkedList<String> newList = new LinkedList<String>();
		ListIterator<String> i = elements.listIterator();
		while(i.hasNext()) {
			String s = elements.removeFirst();
			s = rev(s);
			newList.addFirst(s);
		}
		elements = newList;
	}
	
	private String rev(String s){
		StringBuilder sb = new StringBuilder();
		sb.append(s);
		sb = sb.reverse();
		return sb.toString();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String element : elements) {
			sb.append(element);
		}
		return sb.toString();
	}
	
	public void removeLast(int k){
		int i = 0;
		while(i<k){
			String s = lastAdded.pop();
			if(!elements.remove(s))
				elements.remove(rev(s));
			i++;
		}
	}
}
