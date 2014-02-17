package edu.finki.np.lab2;

public class Order {
	
	private OrderItem[] items;
	private int orderCount;
	private boolean isLocked;
	
	public Order(){
		items = new OrderItem[10];
		orderCount = 0;
	}
	
	public void addItem(Item item, int count) throws ItemOutOfStockException, OrderLockedException{
		if(isLocked)
			throw new OrderLockedException();
		OrderItem oItem = new OrderItem(item, count);
		boolean replaced = false;
		for (int i = 0; i < orderCount; i++) {
			if(oItem.item.equals(items[i].item)){
				items[i] = oItem;
				replaced = true;
			}
		}
		if(orderCount == items.length - 1){
			resize();
		}
		if(!replaced){
			items[orderCount] = oItem;
			orderCount++;
		}
	}
	
	public int getPrice(){
		int price = 0;
		for (int i = 0; i < orderCount; i++) {
			price += items[i].item.getPrice() * items[i].itemCount;
		}
		return price;
	}
	
	private void resize(){
		OrderItem[] newArray = new OrderItem[items.length*2];
		for (int i = 0; i < items.length; i++) {
			newArray[i] = items[i];
		}
		items = newArray;
	}
	
	public void removeItem(int idx) throws OrderLockedException{
		if(isLocked)
			throw new OrderLockedException();
		if(idx<0 || idx>orderCount || idx>items.length)
			throw new ArrayIndexOutOfBoundsException(idx);
		for (int i = idx; i < orderCount-1; i++) {
			items[i] = items[i+1];
		}
		items[orderCount-1] = null;
		orderCount--;
	}
	
	public void lock() throws EmptyOrder, NoPizzaException{
		if(orderCount == 0)
			throw new EmptyOrder();
		boolean hasPizza = false;
		for (int i = 0; i < orderCount; i++) {
			if(items[i].item instanceof PizzaItem){
				hasPizza = true;
			}
		}
		if(!hasPizza)
			throw new NoPizzaException();
		isLocked = true;
	}
	
	public void displayOrder(){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < orderCount; i++) {
			sb.append(Integer.toString(i)+"."+items[i].toString() + "\n");
		}
		sb.append(String.format("%-20s%d", "Total", getPrice()) + "$");
		String str = sb.toString();
		System.out.println(str);
	}
	
	private class OrderItem {
		
		private Item item;
		private int itemCount;
		
		public OrderItem(Item item, int count) throws ItemOutOfStockException{
			if(count > 10){
				throw new ItemOutOfStockException(item);
			}
			this.item = item;
			itemCount = count;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(item.toString());
			sb.append("x"+itemCount+"   ");
			sb.append(Integer.toString(itemCount*item.getPrice()) + "$");
			return sb.toString();
		}
		
		
	}
	
}
