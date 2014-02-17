package edu.finki.np.lab2;

import java.util.Arrays;

public class Contact {

	private String name;
	private String[] phoneNumbers;
	private int numbersCurrentlyStored;
	
	
	public Contact() {
		// TODO Auto-generated constructor stub
	}
	
	private String[] validPrefixes = { "070", "071", "072", "075","076","077", "078"};
	
	public Contact(String contactName) throws InvalidNameException{
		if(contactName.length()<4 || contactName.length()>10)
			throw new InvalidNameException();
		char[] name = contactName.toCharArray();
		for (int i = 0; i < name.length; i++) {
			if(!Character.isLetter(name[i]) || Character.isDigit(name[i]))
				throw new InvalidNameException();
		}
		this.name = new String(name);
		numbersCurrentlyStored = 0;
		phoneNumbers = new String[5];
	}
	
	public Contact(String contactName, String contactNumber) throws InvalidNameException, InvalidNumberException, MaximumSizeExceddedException{
		if(contactName.length()<4 || contactName.length()>10)
			throw new InvalidNameException();
		char[] name = contactName.toCharArray();
		for (int i = 0; i < name.length; i++) {
			if(!Character.isLetter(name[i]) || Character.isDigit(name[i]))
				throw new InvalidNameException();
		}
		this.name = new String(name);
		numbersCurrentlyStored = 0;
		phoneNumbers = new String[5];
		if(isValid(contactNumber)){
			phoneNumbers[0] = contactNumber;
			numbersCurrentlyStored++;
		}
	}
	
	public Contact(String contactName, String contactNumber1, String contactNumber2, String contactNumber3) throws InvalidNameException, InvalidNumberException, MaximumSizeExceddedException{
		if(contactName.length()<4 || contactName.length()>10)
			throw new InvalidNameException();
		char[] name = contactName.toCharArray();
		for (int i = 0; i < name.length; i++) {
			if(!Character.isLetter(name[i]) || Character.isDigit(name[i]))
				throw new InvalidNameException();
		}
		this.name = new String(name);
		numbersCurrentlyStored = 0;
		phoneNumbers = new String[5];
		if(isValid(contactNumber1)){
			phoneNumbers[0] = contactNumber1;
			numbersCurrentlyStored++;
		}
		if(isValid(contactNumber1)){
			phoneNumbers[1] = contactNumber2;
			numbersCurrentlyStored++;
		}
		if(isValid(contactNumber1)){
			phoneNumbers[2] = contactNumber3;
			numbersCurrentlyStored++;
		}
	}
	
	
	public Contact(String contactName, String[] contactNumbers) throws InvalidNameException, MaximumSizeExceddedException, InvalidNumberException{
		if(contactName.length()<4 || contactName.length()>10)
			throw new InvalidNameException();
		char[] name = contactName.toCharArray();
		for (int i = 0; i < name.length; i++) {
			if(!Character.isLetter(name[i]) || Character.isDigit(name[i]))
				throw new InvalidNameException();
		}
		this.name = new String(name);
		if(contactNumbers.length > 5)
			throw new MaximumSizeExceddedException();
		boolean valid;
		for (int i = 0; contactNumbers[i]!=null; i++) {
			valid = false;
			if(contactNumbers[i].toCharArray().length >9)
				throw new InvalidNumberException();
			for(int j=0; j< validPrefixes.length; j++)
				if(contactNumbers[i].startsWith(validPrefixes[j])){
					valid = true;
					break;
				}
			if(!valid)
				throw new InvalidNumberException();
		}
		phoneNumbers = new String[5];
		for (int i = 0; contactNumbers[i]!=null; i++) {
			addNumber(contactNumbers[i]);
		}
	}

	public String getName() {
		return name;
	}

	public String[] getNumbers() {
		String[] numbersCopy = new String[numbersCurrentlyStored];
		for (int i = 0; i < numbersCopy.length; i++) {
			numbersCopy[i] = phoneNumbers[i];
		}
		return numbersCopy;
	}
	
	public void addNumber(String phoneNumber) throws MaximumSizeExceddedException, InvalidNumberException{
		if(numbersCurrentlyStored>=5)
			throw new MaximumSizeExceddedException();
		if(isValid(phoneNumber)){
			phoneNumbers[numbersCurrentlyStored] = phoneNumber;
			numbersCurrentlyStored++;
		}
	}
	

	private boolean isValid(String phoneNumber) throws InvalidNumberException, MaximumSizeExceddedException{
		boolean valid = false;
		char[] num = phoneNumber.toCharArray();
		if(num.length >9)
			throw new InvalidNumberException();
		for(int j=0; j< validPrefixes.length; j++)
			if(phoneNumber.startsWith(validPrefixes[j])){
				valid = true;
				break;
			}
		for(int i=0; i<num.length; i++)
			if(!Character.isDigit(num[i]))
				throw new InvalidNumberException();
		if(!valid)
			throw new InvalidNumberException();
		
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name + "\n");
		String[] numbers = getNumbers();
		sb.append(Integer.toString(numbersCurrentlyStored)+ "\n");
		for (int i = 0; i < numbersCurrentlyStored; i++) {
			sb.append(numbers[i] + "\n");
		}
		String s = sb.toString();
		return s;
	}
	
	public static Contact valueOf(String s){
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		Contact c = (Contact) obj;
		return c.getName().equals(this.name);
	}
}
