package edu.finki.np.lab4;

import java.util.ArrayList;

public class SortedLinkedList<T extends Comparable<T>> {
	
	private Node<T> leader;
	private Node<T> first;
	private int N;
	private Node<T> placeHolder;
	
	public SortedLinkedList(){
		leader = new Node<T>();
		first = new Node<T>();
		first.setPrevious(leader);
        leader.setNext(first);
        placeHolder = leader.getNext();
        N=0;
	}
	
	
	public boolean contains(T element){
		Node<T> iterator = leader.getNext();
		while(iterator.getNext()!=null){
			if(iterator.getElement().compareTo(element) > 0)
				break;
			if(iterator.getElement().compareTo(element)==0)
				return true;
			iterator = iterator.getNext();
		}
		return false;
	}
	
	public void add(T element){
		if(contains(element))
			return;
		Node<T> iterator = leader.getNext();
		while(iterator.getNext()!=null){
			if(iterator.getElement().compareTo(element) > 0)
				break;
			iterator = iterator.getNext();
		}
		Node<T> newNode = new Node<T>(element, iterator);
		newNode.setPrevious(iterator.getPrevious());
		iterator.getPrevious().setNext(newNode);
		iterator.setPrevious(newNode);
		N++;
		return;
	}
	
	private boolean contains(T element, Node<T> where){
		Node<T> iterator = where;
		while(iterator.getNext()!=null){
			if(iterator.getElement().compareTo(element) > 0)
				break;
			if(iterator.getElement().compareTo(element)==0){
				placeHolder = iterator;
				return true;
			}
			iterator = iterator.getNext();
		}
		return false;
	}

	private void add(T element, Node<T> whereToStart){
		if(contains(element, whereToStart))
			return;
		Node<T> newNode = new Node<T>(element, placeHolder);
		newNode.setPrevious(placeHolder.getPrevious());
		placeHolder.getPrevious().setNext(newNode);
		placeHolder.setPrevious(newNode);
		N++;
		return;
	}
	
    public void addAll(SortedLinkedList<? extends T> a){
    	Node<? extends T> iterator = a.leader.getNext();
		placeHolder = leader.getNext();
    	while(iterator.getNext()!=null){
			add(iterator.getElement(), placeHolder);
			iterator = iterator.getNext();
		}
	}
    
	public boolean containsAll(SortedLinkedList<? extends T> elements){
		Node<? extends T> iterator = elements.leader.getNext();
		placeHolder = leader.getNext();
		while(iterator.getNext()!=null){
			if(contains(iterator.getElement(), placeHolder))
				iterator = iterator.getNext();
			else
				return false;
		}
		return true;
	}

	public boolean remove(T element){
		if(contains(element)){
			Node<T> iterator = leader.getNext();
			while(iterator.getNext()!=null){
				if(iterator.getElement().compareTo(element)==0)
					break;
			}
			iterator.getPrevious().setNext(iterator.getNext());
			iterator.getNext().setPrevious(iterator.getPrevious());
			N--;
			return true;
		}
		return false;
	}

	public boolean isEmpty(){
		return N==0;
	}
	
	public int size(){
		return N;
	}
	
	public ArrayList<T> toArrayList(){
		ArrayList<T> array = new ArrayList<T>();
		Node<T> iterator = leader.getNext();
		while(iterator.getNext()!=null){
			array.add(iterator.getElement());
			iterator = iterator.getNext();
		}
		return array;
	}

}