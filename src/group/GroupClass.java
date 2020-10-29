package group;

import dataStructures.DoublyLinkedList;
import dataStructures.Iterator;
import dataStructures.List;
import dataStructures.OrderedSequence;
import dataStructures.OrderedSequenceClass;
import message.Message;
import user.User;

/**
 * Implements a Group.
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public class GroupClass implements Group, Comparable<Group>{
	
	/**
	 * Decidimos utilizar uma OrderedSequence para guardar os Users pois e necessario estarem ordenados por ordem lexicografica para o comando 3.11.
	 * Para armazenar as Messages usamos um DoublyLinkedList porque nao precisam de estar ordenadas
	 * e tambem sentimos que a DLL seria mais eficiente do que a SinlyLinkedList na pesquisa e remocao dos elementos.
	 */
	
	private String name, description;
	private OrderedSequence<User> members;
	private List<Message> messages;
	
	/**
	 * Constructs of GroupClass, initializes variable.
	 * @param name - Group name
	 * @param description - Group description
	 */
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
