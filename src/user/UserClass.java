package user;

import dataStructures.DoublyLinkedList;
import dataStructures.List;
import group.Group;
import user.exceptions.*;

public class UserClass {
	private String name, profession, locality;
	private int age;
	private List<Group> groups;
	private static int MAXGROUPS = 10;
	
	public UserClass( String name, int age , String locality, String profession ) {
		this.name = name;
		this.age = age;
		this.profession = profession;
		this.locality = locality;
		groups = new DoublyLinkedList<Group>() ;
	}
	
	public String getName() {
		return name;
	}
	
	public String getProfession() {
		return profession;
	}
	
	public String getLocality() {
		return locality;
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
