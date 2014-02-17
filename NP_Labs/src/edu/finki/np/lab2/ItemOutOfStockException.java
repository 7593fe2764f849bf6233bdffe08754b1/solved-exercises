package edu.finki.np.lab2;

public class ItemOutOfStockException extends Exception {

	private Item item;
	
	public ItemOutOfStockException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemOutOfStockException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ItemOutOfStockException(Item item){
		this.item = item;
	}
	
	public Item getItem(){
		return item;
	}
	
}
