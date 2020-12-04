package group;

import dataStructures.*;
import message.Message;
import user.User;

/**
 * Implements a Group.
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public class GroupClass implements Group, Comparable<Group>{
	
	private String name, description;
	private OrderedDictionary<String,User> members; 
	private List<Message> messages;
	
	/**
	 * Constructs of GroupClass, initializes variable.
	 * @param name - Group name
	 * @param description - Group description
	 */
	public GroupClass(String name, String description) {
		this.name = name;
		this.description = description;
		members = new BinarySearchTree<String, User>(); 
		messages = new SinglyLinkedList<Message>();
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
		members.insert(user.getLogin(), user); 
	}
	
	public void removeMember(User user) {
		members.remove(user.getLogin()); 
	}
	
	public void recieveMessage(Message message) {
		messages.addFirst(message);
	}
	
	public Iterator<User> listMembers() { 
		return members.values();
	}
	
	public Iterator<Message> listMessages() {
		return messages.iterator();
	}
	
}	
