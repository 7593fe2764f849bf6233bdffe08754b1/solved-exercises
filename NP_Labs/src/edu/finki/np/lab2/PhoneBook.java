package edu.finki.np.lab2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class PhoneBook {

	private Contact contacts[];
	private int currentlyStoredContacts;
	
	public PhoneBook() {
		contacts = new Contact[250];
		currentlyStoredContacts = 0;
	}

	public void addContact(Contact contact) throws MaximumSizeExceddedException, InvalidNameException, InvalidNumberException{
		if(currentlyStoredContacts>=contacts.length)
			throw new MaximumSizeExceddedException();
		if(!isUnique(contact))
			throw new InvalidNameException();
		Contact c = new Contact(contact.getName(), contact.getNumbers());
		contacts[currentlyStoredContacts] = c;
		currentlyStoredContacts++;
		return;
	}
	
	private boolean isUnique(Contact contact){
		boolean unique = true;
		for (int i = 0; i < currentlyStoredContacts; i++) {
			if(contact.equals(contacts[i]))
				unique = false;
		}
		return unique;
	}
	
	public Contact getContactForName(String name){
		Contact returnContact = null;
		for (int i = 0; i < currentlyStoredContacts; i++) {
			if(name.equals(contacts[i].getName())){
				returnContact = contacts[i];
				break;
			}
		}
		return returnContact;
	}
	
	public int numberOfContacts(){
		return currentlyStoredContacts;
	}
	
	public Contact[] getContacts(){
		Contact[] copy = new Contact[currentlyStoredContacts];
		for (int i = 0; i < copy.length; i++) {
			copy[i] = contacts[i];
		}
		Arrays.sort(contacts);
		return copy;
	}

	public boolean removeContact(String name){
		boolean removed = false;
		for (int i = 0; i < currentlyStoredContacts; i++) {
			if(name.equals(contacts[i].getName())){
				contacts[i] = null;
				currentlyStoredContacts--;
				removed = true;
				break;
			}
		}
		return removed;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Contact[] printContacts = getContacts();
		for (int i = 0; i < printContacts.length; i++) {
			sb.append(printContacts[i].toString() + "\n\n");
		}
		return sb.toString();
	}
	
	public static boolean saveAsTextFile(PhoneBook phonebook, String path){
		PrintWriter pwriter = null;
		try{
			pwriter = new PrintWriter(new FileOutputStream(path, true));
			pwriter.print(phonebook.toString());
			pwriter.close();
			return true;
		} catch (Exception e){
			return false;
		}
	}
	
	public static PhoneBook loadFromTextFile(String path) throws IOException, InvalidFormatException{
		Scanner fileInput = null;
		try {
			fileInput = new Scanner(new FileInputStream(path));
			PhoneBook phonebook = new PhoneBook();
			Contact contactToAdd;
			String contactName;
			String[] contactNumbers = new String[5];
			int currentContactNumbers = 0;
			String textLine;
			contactName = fileInput.nextLine();
			while(fileInput.hasNext()){
				textLine = fileInput.nextLine();
				if(textLine.startsWith("07")){
					contactNumbers[currentContactNumbers] = textLine;
					currentContactNumbers++;
					continue;
				} else {
					contactName = textLine;
					contactToAdd = new Contact(contactName,contactNumbers);
					phonebook.addContact(contactToAdd);
					currentContactNumbers = 0;
					contactNumbers = new String[5];
				}
			}
			fileInput.close();
			return phonebook;
		} catch (IOException e) {
			throw e;
		} catch (InvalidNameException e) {
			throw new InvalidFormatException();
		} catch (InvalidNumberException e) {
			throw new InvalidFormatException();
		} catch (MaximumSizeExceddedException e) {
			throw new InvalidFormatException();
		}
	}
	
	public Contact[] getContactsForNumber(String number_prefix) throws InvalidNameException, MaximumSizeExceddedException, InvalidNumberException{
		Contact[] contacts = getContacts();
		Contact[] returnContacts = new Contact[contacts.length];
		int j = 0;
		for(int i=0; i<contacts.length; i++){
			String[] numbers = contacts[i].getNumbers();
			for(int z=0; z<5; z++){
				if(numbers[z]!=null){
					 if(numbers[z].startsWith(number_prefix)){
						 returnContacts[j] = new Contact(contacts[i].getName(), contacts[i].getNumbers());
						 j++;
						 break;
					 }
				}
			}
		}
		Contact[] toReturn = new Contact[j];
		for (int i = 0; i < toReturn.length; i++) {
			toReturn[i] = returnContacts[i];
		}
		return toReturn;
	}
	
	
}
