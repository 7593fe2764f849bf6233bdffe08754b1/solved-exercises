package edu.finki.np.lab5;

public class Example {

	public static void main(String[] args) {
		IntegerList i = new IntegerList(new Integer[]{1,2,2,3,4,5,6,5,1,1,5}); //2,3,4,6,1,5
		System.out.println(i.toString());
		//i.removeDuplicates();
		//System.out.println(i.sumFirst(2));
		//System.out.println(i.sumLast(2));
		//System.out.println(i.toString());
		//i.shiftRight(8, 3);
		i.shiftLeft(0, 21);
		System.out.println(i.toString());
	}
	
}


