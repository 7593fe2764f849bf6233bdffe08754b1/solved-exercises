package edu.finki.np.lab3;

public class ComplexNumber<T extends Number, U extends Number> implements
		Comparable<ComplexNumber<?, ?>> {

	private T realPart;
	private U imaginaryPart;

	public ComplexNumber() {
		// TODO Auto-generated constructor stub
	}

	public ComplexNumber(T real, U imaginary) {
		realPart = real;
		imaginaryPart = imaginary;
	}

	public T getR() {
		return realPart;
	}

	public U getI() {
		return imaginaryPart;
	}

	public double modul() {
		return Math.sqrt((realPart.doubleValue() * realPart.doubleValue())
				+ (imaginaryPart.doubleValue() * imaginaryPart.doubleValue()));
	}

	@Override
	public int compareTo(ComplexNumber<?, ?> o) {
		return Double.compare(modul(), o.modul());
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%.2f", realPart.doubleValue()));
		if (imaginaryPart.doubleValue() >= 0)
			sb.append("+");
		sb.append(String.format("%.2f", imaginaryPart.doubleValue()));
		sb.append("i");
		String s = sb.toString();
		return s;
	}

}
