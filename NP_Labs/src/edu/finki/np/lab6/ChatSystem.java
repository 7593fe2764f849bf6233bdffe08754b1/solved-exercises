package edu.finki.np.lab6;
import java.util.ArrayList;
import java.util.TreeMap;


public class ChatSystem {

	private TreeMap<String, ChatRoom> rooms;
	private TreeMap<String, ArrayList<ChatRoom>> users;
	
	public ChatSystem(){
		rooms = new TreeMap<String, ChatRoom>();
		users = new TreeMap<String, ArrayList<ChatRoom>>();
	}
	
	public void addRoom(String name){
		rooms.put(name, new ChatRoom(name));
	}
	
	public void removeRoom(String name){
		ChatRoom forDeletion = rooms.get(name);
		for(String user : users.keySet()){
			ArrayList<ChatRoom> chat = users.get(user);
			if(chat!=null)
				chat.remove(forDeletion);
		}
		rooms.remove(name);
	}
	
	public ChatRoom getRoom(String name) throws NoSuchRoomException{
		if(rooms.containsKey(name))
			return rooms.get(name);
		throw new NoSuchRoomException(name);
	}
	
	public void register(String name){
		if(!rooms.isEmpty()){
			ArrayList<ChatRoom> roomList = new ArrayList<>(rooms.values());
			ChatRoom min = roomList.get(0);
			for(ChatRoom c : roomList){
				if(c.numUsers()<min.numUsers())
					min = c;
			}
			min.addUser(name);
			ArrayList<ChatRoom> newUserRooms = new ArrayList<>();
			newUserRooms.add(min);
			users.put(name, newUserRooms);
			return;
		} 
		users.put(name, null);
	}
	
	public void registerAndJoin(String username, String roomName) throws NoSuchRoomException, NoSuchUserException{
		users.put(username, null);
		joinRoom(username,roomName);
	}
	
	public void joinRoom(String userName, String roomName) throws NoSuchRoomException, NoSuchUserException{
		if(!rooms.containsKey(roomName))
			throw new NoSuchRoomException(roomName);
		if(!users.containsKey(userName))
			throw new NoSuchUserException(userName);
		ArrayList<ChatRoom> userRooms = users.get(userName);
		if(userRooms == null)
			userRooms = new ArrayList<ChatRoom>();
		ChatRoom chatRoom = rooms.get(roomName);
		chatRoom.addUser(userName);
		userRooms.add(chatRoom);
		users.put(userName, userRooms);
	}
	
	public void leaveRoom(String userName, String roomName) throws NoSuchRoomException, NoSuchUserException{
		if(!rooms.containsKey(roomName))
			throw new NoSuchRoomException(roomName);
		if(!users.containsKey(userName))
			throw new NoSuchUserException(userName);
		ChatRoom chatRoom = rooms.get(roomName);
		ArrayList<ChatRoom> userRooms = users.get(userName);
		chatRoom.removeUser(userName);
		if(userRooms != null)
			userRooms.remove(chatRoom);
	}
	
	public void followFriend(String userName, String friendUserName) throws NoSuchUserException, NoSuchRoomException{
		if(!users.containsKey(userName))
			throw new NoSuchUserException(userName);
		if(!users.containsKey(friendUserName))
			throw new NoSuchUserException(friendUserName);
		ArrayList<ChatRoom> friendsRooms = users.get(friendUserName);
		if(friendsRooms != null && friendsRooms.size() != 0 && rooms.size()!=0)
			for(ChatRoom c : friendsRooms)
				joinRoom(userName,c.getRoomName());
	}
	
}