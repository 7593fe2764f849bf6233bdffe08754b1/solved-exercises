package edu.finki.np.lab4;

public class BinaryTreeSet<T extends Comparable<T>> {
	
	private Node<T> top;
	private int N;
	
	public BinaryTreeSet(){
		N = 0;
		top.setNext(null);
		top.setPrevious(null);
	}
	
	public void addElement(T element){
		Node<T> iterator = top;
		Node<T> node = new Node<T>(element,null);
		node.setPrevious(null);
		if(!contains(element)){
			add(node, iterator);
		}	
	}
		
	public boolean contains(T element){
		Node<T> iterator = top;
		Node<T> theNode = new Node<T>(element, null);
		theNode.setPrevious(null);
		return found(theNode, iterator);
	}
	
	private boolean found(Node<T> element, Node<T> cmp){
		if(cmp.getElement().compareTo(element.getElement())==0){
			return true;
		}
		if(cmp.getElement().compareTo(element.getElement())==-1){
			if(cmp.getPrevious()!=null)
				return found(element, cmp.getPrevious());
			else
				return false;
		}
		if(cmp.getNext()!=null)
			return found(element,cmp.getNext());
		return false;
	}
	
	private void add(Node<T> theNode, Node<T> place){
		if(place.getElement()==null || place==null){
			place = theNode;
			return;
		}
		else
			if(place.getElement().compareTo(theNode.getElement())==1)
				add(theNode, place.getNext());
			else
				add(theNode, place.getPrevious());
	}

}
