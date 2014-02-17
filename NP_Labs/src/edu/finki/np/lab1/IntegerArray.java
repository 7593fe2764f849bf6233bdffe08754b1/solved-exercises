package edu.finki.np.lab1;

import java.util.Arrays;

public final class IntegerArray {

	private int[] numbers;

	public IntegerArray() {

	}

	public IntegerArray(int a[]) {
		numbers = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			numbers[i] = a[i];
		}
	}

	public int length() {
		return numbers.length;
	}

	public int getElementAt(int i) {
		return numbers[i];
	}

	public int sum() {
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}
		return sum;
	}

	public double average() {
		return (this.sum() * 1.0) / this.length();
	}

	public IntegerArray getSorted() {
		IntegerArray newIntArray = new IntegerArray(numbers);
		Arrays.sort(newIntArray.numbers);
		return newIntArray;
	}

	public IntegerArray concat(IntegerArray ia) {
		IntegerArray newIntArray = new IntegerArray();
		newIntArray.numbers = new int[numbers.length + ia.length()];
		int i;
		for (i = 0; i < numbers.length; i++) {
			newIntArray.numbers[i] = numbers[i];
		}
		for (int j = i, k=0; j < newIntArray.numbers.length; j++, k++) {
			newIntArray.numbers[j] = ia.getElementAt(k);
		}
		return newIntArray;
	}

	@Override
	public String toString() {
		return Arrays.toString(numbers);
	}

}
