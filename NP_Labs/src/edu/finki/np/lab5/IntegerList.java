package edu.finki.np.lab5;

import java.util.Iterator;
import java.util.LinkedList;

public class IntegerList {

	private LinkedList<Integer> elements;
	
	public IntegerList(){
		elements = new LinkedList<>();
	}
		
	public IntegerList(Integer[] numbers){
		elements = new LinkedList<>();
		for (Integer integer : numbers) {
			elements.add(integer);
		}
	}
	
	public void add(int elem, int idx){
		if(idx>elements.size()-1){
			while(elements.size()<idx)
				elements.add(0);
		}	
		elements.add(idx, elem);
	}
	
	public int remove(int idx){
		return elements.remove(idx);
	}
	
	public void set(int elem, int idx){
		elements.set(idx, elem);
	}
	
	public int get(int idx){
		if(idx<0 || idx>elements.size()-1)
			throw new ArrayIndexOutOfBoundsException();
		return elements.get(idx);
	}
	
	public int size(){
		return elements.size();
	}
	
	public int count(int elem){
		int count = 0;
		for (Integer iterable_element : elements) {
			if(iterable_element==elem)
				count++;
		}
		return count;
	}
	
	public void removeDuplicates(){
		LinkedList<Integer> newList = new LinkedList<Integer>();
		Iterator<Integer> it = elements.descendingIterator();
		while(it.hasNext()){
			int elem = it.next();
			if(!contains(elem,newList)){
				newList.addFirst(elem);
			}
		}
		elements = newList;
		return;
	}
	
	private boolean contains(Integer i, LinkedList<Integer> list){
		Iterator<Integer> it = list.iterator();
		while(it.hasNext())
			if(it.next()==i)
				return true;
		return false;
	}

	@Override
	public String toString() {
		return elements.toString();
	}
	
	public int sumFirst(int k){
		int sum = 0;
		int i = 0;
		Iterator<Integer> it = elements.iterator();
		while(it.hasNext() && i<k){
			sum += it.next();
			i++;
		}
		return sum;
	}
	
	public int sumLast(int k){
		int sum = 0;
		int i = 0;
		Iterator<Integer> it = elements.descendingIterator();
		while(i<k && it.hasNext()){
			sum += it.next();
			i++;
		}
		return sum;
	}
	
	public void shiftRight(int idx, int k){
		if(k==0)
			return;
		int counter = 0;
		int newIndex = idx;
		while(counter<k){
			if(newIndex==elements.size()-1)
				newIndex = 0;
			else
				newIndex++;
			counter++;
		}
		int e = elements.remove(idx);
		elements.add(newIndex, e);
	}
	
	public void shiftLeft(int idx, int k){
		if(k==0)
			return;
		int counter = 0;
		int newIndex = idx;
		while(counter <k){
			if(newIndex==0)
				newIndex = elements.size()-1;
			else
				newIndex--;
			counter++;
		}
		int e = elements.remove(idx);
		elements.add(newIndex, e);
	}
	
	public IntegerList addValue(int v){
		IntegerList ret = new IntegerList();
		Iterator<Integer> it = elements.iterator();
		int p = 0;
		while(it.hasNext()){
			ret.add(it.next()+v,p);
			p++;
		}
		return ret;
	}
	
	
	
}
