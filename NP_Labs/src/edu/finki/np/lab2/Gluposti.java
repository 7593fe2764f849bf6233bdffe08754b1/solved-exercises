package edu.finki.np.lab2;

public class Gluposti {

	public static void main(String[] args) {
		String s = "Gorjan";
		System.out.println(s);
		char[] letters = s.toCharArray();
		for (int i = 0; i < letters.length; i++) {
			System.out.println(letters[i]);
		}
		System.out.println(new String(letters));

	}

}
