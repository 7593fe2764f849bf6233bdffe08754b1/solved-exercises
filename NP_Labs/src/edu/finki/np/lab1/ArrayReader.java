package edu.finki.np.lab1;

import java.io.InputStream;
import java.util.Scanner;


public class ArrayReader {
	
	public static IntegerArray readIntegerArray(InputStream input){
		Scanner sc = new Scanner(input);
		int n=0;
		try{
			n = sc.nextInt();
		}catch (Exception e){
			e.printStackTrace();
		}
		int[] temp = new int[n];
		for (int i = 0; i < temp.length; i++) {
			temp[i]=sc.nextInt();
		}
		sc.close();
		IntegerArray ret = new IntegerArray(temp);
		return ret;
	}

}
