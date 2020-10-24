package group;

import covidSystem.exceptions.GroupIsEmptyException;
import dataStructures.DoublyLinkedList;
import dataStructures.Iterator;
import dataStructures.List;
import dataStructures.OrderedSequence;
import dataStructures.OrderedSequenceClass;
import message.Message;
import user.User;

public class GroupClass implements Group, Comparable<Group>{
	
	private String name, description;
	private OrderedSequence<User> members;
	private List<Message> messages;
	
	public GroupClass(String name, String description) {
		this.name = name;
		this.description = description;
		members = new OrderedSequenceClass<User>();
		messages = new DoublyLinkedList<Message>();
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
	
	public void recieveMessage(Message message) {
		messages.addFirst(message);
	}
	
	public Iterator<User> listMembers() {
		return members.iterator();
	}
	
	public Iterator<Message> listMessages() {
		return messages.iterator();
	}
}	
