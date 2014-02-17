package edu.finki.np.lab6;
import java.util.TreeSet;


public class ChatRoom {

	private String roomName;
	private TreeSet<String> users;
	
	public ChatRoom(String name){
		roomName = name;
		users = new TreeSet<String>();
	}
	
	public String getRoomName() {
		return roomName;
	}

	public void addUser(String userName){
		users.add(userName);
	}
	
	public void removeUser(String userName){
		users.remove(userName);
	}
	
	public boolean hasUser(String userName){
		if(users.contains(userName))
			return true;
		return false;
	}
	
	public int numUsers(){
		return users.size();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(roomName + "\n");
		if(users.isEmpty()){
			sb.append("EMPTY");
			return sb.toString();
		}
		for (String s : users) {
			sb.append(s + "\n");
		}
		return sb.toString();
	}
	
}
