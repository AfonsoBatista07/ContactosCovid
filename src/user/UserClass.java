package user;

import dataStructures.DoublyLinkedList;
import dataStructures.Iterator;
import dataStructures.List;
import dataStructures.OrderedSequence;
import dataStructures.OrderedSequenceClass;
import group.Group;
import user.exceptions.*;

public class UserClass implements User, Comparable<User> {
	private String name, profession, address, login;
	private int age;
	private OrderedSequence<Group> groups;
	private OrderedSequence<User> contacts;
	private static int MAXGROUPS = 10;
	
	public UserClass(String login, String name, int age , String address, String profession ) {
		this.login = login;
		this.name = name;
		this.age = age;
		this.profession = profession;
		this.address = address;
		groups = new OrderedSequenceClass<Group>();
		contacts = new OrderedSequenceClass<User>();
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
		if(isContact(user)) throw new UsersAlreadyFriendsException();
		contacts.insert(user);
	}
	
	public void removeContact(User user) {
		if(!isContact(user)) throw new UserNotFriendException();
		contacts.remove(user);
	}
	
	public void addGroup(Group group) {
		if(inGroup(group)) throw new UserAlreadyInGroupException();
		groups.insert(group);
	}
	
	public void removeGroup(Group group) {
		if(!inGroup(group)) throw new UserIsntInGroupException();
		groups.remove(group);
	}
	
	public Iterator<User> contactIterator() {
		return contacts.iterator();
	}
	
	private boolean isContact(User user) {
		return contacts.contains(user);
	}
	
	private boolean inGroup(Group group) {
		return groups.contains(group);
	}

}
