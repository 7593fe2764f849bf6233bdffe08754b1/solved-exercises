package edu.finki.np.lab2;

public class PizzaItem extends Item {

	private String type;
	private int price;
	
	public PizzaItem(String type) throws InvalidPizzaTypeException{
		if(type.equals("Standard")){
			this.type = type;
			price = 10;
		} else if (type.equals("Pepperoni")){
			this.type = type;
			price = 12;
		} else if (type.equals("Vegetarian")){
			this.type = type;
			price = 8;
		} else throw new InvalidPizzaTypeException();
	}

	@Override
	public int getPrice() {
		return price;
	}
	
	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return String.format("%-15s", type);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		String str = null;
		if( obj instanceof ExtraItem){
			ExtraItem extra = (ExtraItem) obj;
			str = extra.getType();
		} else {
			PizzaItem extra = (PizzaItem) obj;
			str = extra.getType();
		}
		if(!type.equalsIgnoreCase(str))
			return false;
		return true;
	}
}
