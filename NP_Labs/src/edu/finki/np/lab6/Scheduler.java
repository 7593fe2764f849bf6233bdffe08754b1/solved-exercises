package edu.finki.np.lab6;

import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;

public class Scheduler<T> {
	
	private TreeMap<Date, T> elements;
	
	public Scheduler(){
		elements = new TreeMap<Date, T>();
	}
	
	public void add(Date d, T t){
		elements.put(d, t);
	}
	
	public boolean remove(Date d){
		if(elements.containsKey(d)){
			elements.remove(d);
			return true;
		}
		return false;
	}
	
	public T last(){
		Date d = new Date();
		Date key = elements.lowerKey(d);
		return elements.get(key);
	}
	
	public T next(){
		Date d = new Date();
		Date key = elements.higherKey(d);
		return elements.get(key);
	}
	
	public ArrayList<T> getAll(Date begin, Date end){
		ArrayList<T> ret = new ArrayList<>(elements.subMap(begin, end).values());
		return ret;
	}
	
	public T getFirst(){
		Date key = elements.firstKey();
		return elements.get(key);
	}
	
	public T getLast(){
		Date key = elements.lastKey();
		return elements.get(key);
	}
}
