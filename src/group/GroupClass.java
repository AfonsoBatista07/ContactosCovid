package group;

import dataStructures.OrderedSequence;
import dataStructures.OrderedSequenceClass;
import user.User;

public class GroupClass implements Group, Comparable<Group>{
	
	private String name, description;
	private OrderedSequence<User> members;
	
	public GroupClass(String name, String description) {
		this.name = name;
		this.description = description;
		members = new OrderedSequenceClass<User>();
	}
	
	public int compareTo(Group group) {
		return name.compareTo(group.getName());
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescritpion() {
		return description;
	}
	
	public void addMember(User user) {
		members.insert(user);
	}
	
	public void removeMember(User user) {
		members.remove(user);
	}
}	
