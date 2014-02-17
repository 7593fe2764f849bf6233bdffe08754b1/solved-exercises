package edu.finki.np.lab3;

import java.util.Date;

public class Timestamp<T> implements Comparable<Timestamp<?>> {

	private final Date date;
	private final T element;
	
	public Timestamp(Date d, T elem) {
		date = d;
		element = elem;
	}

	public Date getDate(){
		return date;
	}
	
	public T getElement(){
		return element;
	}
	
	@Override
	public int compareTo(Timestamp<?> o) {
		return date.compareTo(o.getDate());
	}

	@Override
	public String toString() {
		return date.toString() + " " + element.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj==null)
			return false;
		if(obj.getClass() == getClass()){
			Timestamp<T> cmpObj = (Timestamp<T>) obj;
			return date.equals(cmpObj.getDate()) && element.equals(cmpObj.getElement());
		} else 
			return false;
	}

}
