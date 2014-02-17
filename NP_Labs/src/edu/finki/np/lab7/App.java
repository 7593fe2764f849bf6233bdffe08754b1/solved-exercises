package edu.finki.np.lab7;

public class App {
	
	private String name;
	private String description;
	private double price;
	private int grade;
	
	public App(String name, String description, double price, int grade) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public int getRating() {
		return grade;
	}

}
