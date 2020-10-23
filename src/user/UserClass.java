package user;

import dataStructures.DoublyLinkedList;
import dataStructures.List;
import dataStructures.OrderedSequence;
import dataStructures.OrderedSequenceClass;
import group.Group;
import user.exceptions.*;

public class UserClass implements User, Comparable<User> {
	private String name, profession, address, login;
	private int age;
	private List<Group> groups;
	private OrderedSequence<User> contacts;
	private static int MAXGROUPS = 10;
	
	public UserClass(String login, String name, int age , String address, String profession ) {
		this.login = login;
		this.name = name;
		this.age = age;
		this.profession = profession;
		this.address = address;
		groups = new DoublyLinkedList<Group>();
		contacts = new OrderedSequenceClass<User>();
	}
	
	public int compareTo(User user) {
		return login.compareTo(user.getLogin());
	}
	
	public void newContact(User user) {
		
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
	
	public void addGroup(Group group) {
		if(inGroup(group)) { throw new UserAlreadyInGroupException();}
		groups.addLast(group);
	}
	
	private boolean inGroup(Group group) {
		return groups.find(group) != -1;
	}

}
