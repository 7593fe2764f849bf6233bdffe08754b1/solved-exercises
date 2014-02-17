package edu.finki.np.lab1;

public class Account {
	private static long idGenerator;
	private long id;
	private String name;
	private int dollars;
	private int cents;
	private String currAmmount;

	public Account(String user_name, String user_balance) {
		name = user_name;
		currAmmount = user_balance;
		int[] values = balance2ints(user_balance);
		dollars = values[0];
		cents = values[1];
		setId();
	}

	public String getBalance() {
		return currAmmount;
	}

	public String getUserName() {
		return name;
	}

	public long getID() {
		return id;
	}

	public void setBalance(String balance) {
		currAmmount = balance;
		int[] values = balance2ints(balance);
		dollars = values[0];
		cents = values[1];
	}
	
	@Override
	public boolean equals(Object arg0) {
        if(arg0 == null)
            return false;
		Account compAcc = (Account) arg0;
		if(this.getID() == compAcc.getID())
			return true;
		else 
			return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name:" + name + "\n" + getID() + "\n");
		sb.append("Balance:" + getBalance() + "\n");
		return sb.toString();
	}

	private void setId() {
		if (idGenerator == 0) {
			idGenerator = 1;
		} else {
			idGenerator++;
		}
		id = idGenerator;
	}

	public static int[] balance2ints(String balance) {
		int[] values = new int[2];
		if(!containsDot(balance)){
			int idx = balance.length()-1;
			String newstr = balance.substring(0, idx) + balance.substring(idx + 1);
			System.out.println(newstr);
			values[1]=0;
			values[0]=Integer.parseInt(balance);
			return values;
		} else {
			String[] nums = balance.split("\\.");
			values[0] = Integer.parseInt(nums[0]);
			StringBuilder sb = new StringBuilder();
			sb.append(nums[1].charAt(0));
			if(nums[1].length()>2)
				sb.append(nums[1].charAt(1));
			values[1] = Integer.parseInt(sb.toString());
			return values;
		}
	}

	public static String ints2Balance(int dollars, int cents) {
		StringBuilder sb = new StringBuilder();
		sb.append(dollars);
		sb.append('.');
		if(cents==0){
			sb.append("00");
		} else {
			if(cents<10)
				sb.append("0");
			sb.append(cents);
		}
		sb.append('$');
		return sb.toString();
	}

	public static boolean containsDot(String s){
		char[] str = s.toCharArray();
		for (int i = 0; i < str.length; i++) {
			if(str[i]=='.')
				return true;
		}
		return false;
	}
	
//	public static void main(String[] args) {

//		String balance = "0$";
//		int idx = balance.length()-1;
//		String newstr = balance.substring(0, idx) + balance.substring(idx + 1);
//		System.out.println(newstr);
//		Account a1 = new Account("Gorjan", "0$");
//		Account a2 = new Account("Gorjan", "10.50$");
//		String[] parts = "10.50$".split("\\.");
//		for (int i = 0; i < parts.length; i++) {
//			System.out.println(parts[i]);
//		}
//		System.out.println(a1.toString());
//		System.out.println(a2.toString());
//		System.out.println(Integer.toString(a1.dollars));
//		System.out.println(Integer.toString(a1.cents));
//		a1.setBalance("32.99$");
//		System.out.println(Integer.toString(a1.dollars));
//		System.out.println(Integer.toString(a1.cents));
//		System.out.println(a1.toString());
//		System.out.println(a1.ints2Balance(a1.dollars, a1.cents));
//		System.out.println(a1.currAmmount);
//	}

}