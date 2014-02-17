package edu.finki.np.lab8;

import java.util.Scanner;

public class MAIN {

	public static void main(String args[]){
//		String str = "Berovo;1 2012.10.12 4 24 987 0.0;2 2012.02.15 -10 17 990 0.5;";
//		String[] parts = str.split(";");
//		for (String string : parts) {
//			System.out.println(string);
//			String[] info = string.split(" ");
//			for (String string2 : info) {
//				System.out.println(string2);
//			}
//		}
		
				
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine())
			System.out.println(sc.nextLine());
		sc.close();
		
	}
}
