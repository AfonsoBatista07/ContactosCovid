package user;

import dataStructures.*;
import group.Group;
import message.Message;
import user.exceptions.*;

/**
 * Implements a User.
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public class UserClass implements User, Comparable<User> {
	
	/**
	 * Decidimos utilizar uma OrderedSequence para guardar os Users pois e necessario estarem ordenados por ordem lexicografica para o comando 3.5.
	 * Para armazenar as Messages e os Grupos usamos uma DoublyLinkedList porque nao precisam de estar ordenados
	 * e tambem sentimos que a DLL seria mais eficiente do que a SinlyLinkedList na pesquisa e remocao dos elementos.
	 */
	
	private String name, profession, address, login;
	private int age, numGroups;
	private HashTable<String, Group> groups;
	private OrderedDictionary<String,User> contacts;
	private List<Message> feed;
	private static int MAXGROUPS = 10;
	
	
	/**
	 * Constructor of UserClass, initializes variables.
	 * @param login - User login
	 * @param name - User name
	 * @param age - User age
	 * @param address - User address
	 * @param profession - User profession
	 */
	public UserClass(String login, String name, int age , String address, String profession ) {
		this.login = login;
		this.name = name;
		this.age = age;
		this.profession = profession;
		this.address = address;
		numGroups = 0;
		groups = new ChainedHashTable<String, Group>(10);
		contacts = new BinarySearchTree<String, User>();
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
		contacts.insert(user.getLogin(), user); 
	}
	
	public void removeContact(User user) {
		if(!isContact(user)) throw new UserNotFriendException();
		contacts.remove(user.getLogin());
	}
	
	public void addGroup(Group group) {
		if(inGroup(group)) throw new UserAlreadyInGroupException();
		if(numGroups == MAXGROUPS) throw new UserMaxedGroupsException();
		groups.insert(group.getName(), group);
		numGroups++;
	}
	
	public void removeGroup(Group group) {
		if(!inGroup(group)) throw new UserIsntInGroupException();
		groups.remove(group.getName());
		numGroups--;
	}
	
	public void recieveMessage(Message message) {
		feed.addFirst(message);
	}
	
	public Iterator<Entry<String, User>> listContacts() { 
		return contacts.iterator();
	}
	
	public Iterator<Message> listMessages() {
		return feed.iterator();
	}
	
	public Iterator<Entry<String, Group>> listGroups() {
		return groups.iterator();
	}
	
	public boolean isContact(User user) {
		if(user.compareTo(this) == 0)
			return true;
		return contacts.find(user.getLogin())!=null;
	}
	
	public boolean inGroup(Group group) {
		return groups.find(group.getName()) != null;
	}
}
