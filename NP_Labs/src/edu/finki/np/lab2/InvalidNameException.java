package edu.finki.np.lab2;

public class InvalidNameException extends Exception {

	public String name;
	
	public InvalidNameException() {
		name = "InvalidNameException";
		// TODO Auto-generated constructor stub
	}

	public InvalidNameException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
