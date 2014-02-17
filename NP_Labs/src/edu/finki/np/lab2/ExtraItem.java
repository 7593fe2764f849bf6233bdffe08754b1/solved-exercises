package edu.finki.np.lab2;

public class ExtraItem extends Item {

	private String type;
	private int price;
	
	public ExtraItem(String type) throws InvalidExtraTypeException{
		if(type.equals("Coke")){
			this.type = type;
			price = 5;
		} else {
			if(type.equals("Ketchup")){
				this.type = type;
				price = 3;
			}
			else throw new InvalidExtraTypeException();
		}
	}
	
	public String getType() {
		return type;
	}
	
	@Override
	public int getPrice() {
		return price;
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
