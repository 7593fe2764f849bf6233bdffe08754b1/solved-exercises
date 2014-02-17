package edu.finki.np.lab1;

public class FlatAmountProvisionTransaction extends Transaction {

	private String flatProvision;
	
	public FlatAmountProvisionTransaction() {
		super();
	}

	public FlatAmountProvisionTransaction(long from_id, long to_id, String amount, String flat_amount_provision) {
		super(from_id,to_id,"FlatAmount",amount);
		flatProvision = flat_amount_provision;
		setProvision(flatProvision);
	}
	
	public String getFlatAmount(){
		return flatProvision;
	}

	@Override
	public boolean equals(Object obj) {
        if(obj == null)
            return false;
		FlatAmountProvisionTransaction t = (FlatAmountProvisionTransaction) obj;
		if(this.getFromAccountId() == t.getFromAccountId() &&
				this.getToAccountId() == t.getToAccountId() &&
					this.getAmount() == t.getAmount() &&
						this.getProvision() == t.getProvision()){
			return true;
		}
		return false;
	}
}
