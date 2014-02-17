package edu.finki.np.lab1;

public class Bank {

	private String bankName;
	public Account[] accounts;
	private String totalTransactionAmount;
	private String totalProvision;

	public Bank(String name, Account accounts[]) {
		bankName = name;
		totalTransactionAmount = "0.00$";
		totalProvision = "0.00$";
		this.accounts = new Account[accounts.length];
		for (int i = 0; i < accounts.length; i++) {
			this.accounts[i] = accounts[i];
		}
	}

	public String getBankName() {
		return bankName;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null)
            return false;
        Bank cmpBank = (Bank) obj;
        if(this.getBankName() != cmpBank.getBankName()){
        	System.out.println("not equal: don't have the same name!");
        	return false;
        }
        if(accounts.length != cmpBank.accounts.length){
        	System.out.println("not equal: don't have the same number of accounts!");
        	return false;
        }
        for (int i = 0; i < this.accounts.length; i++) {
        	if(!(this.accounts[i].equals(cmpBank.accounts[i]))){
            	System.out.println("not equal: the accounts are not in the same order!");
        		return false;
        	}
		}
        if(!(totalProvision.equals(cmpBank.totalProvision))){
        	System.out.println("not equal: don't have the same provision!");
        	return false;
        }
        if(!(totalTransfers().equals(cmpBank.totalTransfers()))){
        	System.out.println("not equal: don't have the same total transfers!");
        	return false;
        }
        System.out.println("true");
        return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(bankName + "\n\n");
		for (int i = 0; i < accounts.length; i++) {
			sb.append("Name:" + accounts[i].getUserName() + "\n"
					+ "Balance:" + accounts[i].getBalance() + "\n\n");
		}
		return sb.toString();

	}

	public static boolean isMore(int[] amount1, int[] amount2) {
		int val1 = amount1[0] * 100 + amount1[1];
		int val2 = amount2[0] * 100 + amount1[1];
		return val1 > val2;
	}

	public boolean makeTransaction(Transaction t) {
		boolean toIdIsInBank = false;
		boolean fromIdIsInBank = false;
		int fromAccountId = -1;
		int toAccountId = -1;
		for (int i = 0; i < accounts.length; i++) {
			if (t.getFromAccountId() == accounts[i].getID()) {
				fromIdIsInBank = true;
				fromAccountId = i;
			}
			if (t.getToAccountId() == accounts[i].getID()) {
				toIdIsInBank = true;
				toAccountId = i;
			}
			if(fromIdIsInBank && toIdIsInBank)
				break;
		}
		if (fromIdIsInBank
				&& toIdIsInBank
				&& (fromAccountId != -1)
				&& (toAccountId != -1)
				&& isMore(Account.balance2ints(accounts[fromAccountId]
						.getBalance()), Account.balance2ints(Bank.addToSum(t.getAmount(), t.getProvision())))) {
			String transactionAmount = Bank.addToSum(t.getAmount(), t.getProvision());
			accounts[toAccountId].setBalance(Bank.addToSum(accounts[toAccountId].getBalance(), t.getAmount()));
			accounts[fromAccountId].setBalance(Bank.takeAwayFromSum(accounts[fromAccountId].getBalance(), transactionAmount));
			totalTransactionAmount = Bank.addToSum(totalTransactionAmount, t.getAmount());
			totalProvision = Bank.addToSum(totalProvision, t.getProvision());
			return true;
		}
		return false;
	}

	public static String addToSum(String previousSum, String plusSum) {
		int[] amount1 = Account.balance2ints(previousSum);
		int[] amount2 = Account.balance2ints(plusSum);
		int cents = amount1[1] + amount2[1];
		int dollars = cents / 100;
		cents = cents - dollars * 100;
		dollars += amount1[0] + amount2[0];
		return Account.ints2Balance(dollars, cents);
	}

	public static String takeAwayFromSum(String sum, String minusSum) {
		int[] amount1 = Account.balance2ints(sum);
		int[] amount2 = Account.balance2ints(minusSum);
		if (amount1[1] < amount2[1]) {
			amount1[1] += 100;
			amount1[0] -= 1;
		}
		int cents = amount1[1] - amount2[1];
		int dollars = amount1[0] - amount2[0];
		return Account.ints2Balance(dollars, cents);
	}

	public String totalTransfers() {
		return totalTransactionAmount;
	}

	public String totalProvision() {
		return totalProvision;
	}

	// public static void main(String[] args) {
	// Bank b = new Bank("NLB", new Account[] {
	// new Account("Gorjan", "10.50$"),
	// new Account("Zajkovski", "00.50") });
	// System.out.println(b.toString());
	// }

}