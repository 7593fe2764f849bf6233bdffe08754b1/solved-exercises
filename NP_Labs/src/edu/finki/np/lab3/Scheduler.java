package edu.finki.np.lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Scheduler<T> {
	
	private ArrayList<Timestamp<T>> elements;

	public Scheduler() {
		elements = new ArrayList<Timestamp<T>>();
	}
	
	public void add(Timestamp<T> t){
		elements.add(t);
	}
	
	public boolean remove(Timestamp<T> e){
		return elements.remove(e);
	}
	
	public Timestamp<T> next(){
		Date now = new Date();
		Collections.sort(elements);
		for (Timestamp<T> element : elements) {
			if(element.getDate().after(now))
				return element;
		}
		return null;
	}
	
	public Timestamp<T> last(){
		Date now = new Date();
		Collections.sort(elements, Collections.reverseOrder());
		for (Timestamp<T> element : elements) {
			if(element.getDate().before(now))
				return element;
		}
		return null;
	}
	
	public ArrayList<Timestamp<T>> getAll(Date begin, Date end){
		Collections.sort(elements);
		ArrayList<Timestamp<T>> returnList = new ArrayList<Timestamp<T>>();
		for (Timestamp<T> element : elements) {
			if(element.getDate().after(begin) && element.getDate().before(end))
				returnList.add(element);
		}
		return returnList;
	}

}
