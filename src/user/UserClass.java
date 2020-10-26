package user;

import covidSystem.exceptions.NoFriendMessagesException;
import covidSystem.exceptions.UserNoContactsException;
import dataStructures.*;
import group.Group;
import message.Message;
import user.exceptions.*;

public class UserClass implements User, Comparable<User> {
	private String name, profession, address, login;
	private int age, numGroups;
	private List<Group> groups;
	private OrderedSequence<User> contacts;
	private List<Message> feed;
	private static int MAXGROUPS = 10;
	
	/**
	 * The groups TAD could be and array with just 10 elements, or a DLL or array ask the teacher about this shit
	 * MAXGroups isnt being verified
	 * 
	 */
	
	public UserClass(String login, String name, int age , String address, String profession ) {
		this.login = login;
		this.name = name;
		this.age = age;
		this.profession = profession;
		this.address = address;
		numGroups = 0;
		groups = new DoublyLinkedList<Group>();
		contacts = new OrderedSequenceClass<User>();
		feed = new DoublyLinkedList<Message>();
	}
	
	public int compareTo(User user) {
		return login.compareTo(user.getLogin());
	}
	
	public String getLogin() {
		return login;
	}
	
	public String getName() {
		return name;
	}
	
	public String getProfession() {
		return profession;
	}
	
	public String getAddress() {
		return address;
	}
	
	public int getAge() {
		return age;
	}
	
	public void newContact(User user) {
		if(isContact(user) || user.compareTo(this) == 0) throw new UsersAlreadyFriendsException();
		contacts.insert(user);
	}
	
	public void removeContact(User user) {
		if(!isContact(user)) throw new UserNotFriendException();
		contacts.remove(user);
	}
	
	public void addGroup(Group group) {
		if(inGroup(group)) throw new UserAlreadyInGroupException();
		if(numGroups == 10) throw new UserMaxedGroupsException();
		groups.addLast(group);
		numGroups++;
	}
	
	public void removeGroup(Group group) {
		if(!inGroup(group)) throw new UserIsntInGroupException();
		groups.remove(group);
		numGroups--;
	}
	
	public void recieveMessage(Message message) {
		feed.addFirst(message);
	}
	
	public Iterator<User> listContacts() {
		return contacts.iterator();
	}
	
	public Iterator<Message> listMessages() {
		return feed.iterator();
	}
	
	public Iterator<Group> listGroups() {
		return groups.iterator();
	}
	
	public boolean isContact(User user) {
		if(user.compareTo(this) == 0)
			return true;
		return contacts.contains(user);
	}
	
	public boolean inGroup(Group group) {
		return groups.find(group) != -1;
	}
}
