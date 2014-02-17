package edu.finki.np.lab1;

public abstract class Transaction {
	private long fromAccountId;
	private long toAccountId;
	private String description;
	private String amount;
	private String provision;

	public Transaction(){
		
	}
	
	public Transaction(long from_id, long to_id, String descr, String amount){
		fromAccountId = from_id;
		toAccountId = to_id;
		description = descr;
		this.amount = amount;
	}
	
	public long getFromAccountId() {
		return fromAccountId;
	}

	public long getToAccountId() {
		return toAccountId;
	}

	public String getAmount() {
		return amount;
	}
	
	public String getDescription() {
		return description;
	}
	
	protected void setProvision(String prov){
		provision = prov;
	}
	
	public String getProvision(){
		return provision;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Append:" + getAmount() + "\n");
		sb.append("Provision:" + getProvision() + "\n");
		sb.append("Description:" + getDescription() + "\n");
		sb.append("From:" + getFromAccountId() + "\n");
		return sb.toString();
	}
	
}
