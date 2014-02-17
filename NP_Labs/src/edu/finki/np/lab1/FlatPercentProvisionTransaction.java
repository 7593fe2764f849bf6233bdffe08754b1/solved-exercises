package edu.finki.np.lab1;

public class FlatPercentProvisionTransaction extends Transaction {

	private int percentProvision;
	
	public FlatPercentProvisionTransaction(long from_id, long to_id, String amount, int cents_per_dollar){
		super(from_id,to_id,"FlatPercent",amount);
		percentProvision = cents_per_dollar;
		String[] vals = amount.split("\\.");
		int dollars = Integer.parseInt(vals[0]);
		int provision = (dollars * cents_per_dollar);
		int d = provision / 100;
		int c = provision % 100;
		String prov = Account.ints2Balance(d, c);
//		String prov = Integer.toString(provision) + "." + "00$";
		setProvision(prov);
	}
	
	public int getPercent(){
		return percentProvision;
	}
	

	@Override
	public boolean equals(Object obj) {
        if(obj == null)
            return false;
		FlatPercentProvisionTransaction t = (FlatPercentProvisionTransaction) obj;
		if(this.getFromAccountId() == t.getFromAccountId() &&
				this.getToAccountId() == t.getToAccountId() &&
					this.getAmount() == t.getAmount() &&
						this.getProvision() == t.getProvision()){
			return true;
		}
		return false;
	}
	
}
