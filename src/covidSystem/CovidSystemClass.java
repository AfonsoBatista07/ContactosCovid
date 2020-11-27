package covidSystem;

import group.*;
import message.*;
import user.*;
import dataStructures.*;
import user.exceptions.*;
import covidSystem.exceptions.*;
import group.exceptions.*;

/**
 * Implements a CovidSystem.
 * @author Afonso Batista 57796
 * @author Joao Jorge 57994
 */
public class CovidSystemClass implements CovidSystem {
	
	/**
	 * Decidimos usar uma DoublyLinkedList para armazenar os Users e os Groups porque estes nao precisam de estar ordenados
	 * e tambem sentimos que a DLL seria mais eficiente do que a SinlyLinkedList na pesquisa e remocao dos elementos.
	 */
	
	HashTable<String, User> users;
	HashTable<String, Group> groups;
	
	/**
	 * Constructor of CovidSystemClass, initializes variables.
	 */
	public CovidSystemClass() {
		users = new ChainedHashTable<String,User>();
		groups = new ChainedHashTable<String,Group>();
	}

	@Override
	public void insertUser(String login, String name, int age, String address, String profession)
			throws UserAlreadyExistException {
		
		if(getUser(login)!=null) throw new UserAlreadyExistException();
		User newUser = new UserClass(login, name, age, address, profession);
		users.insert(login, newUser);																				
	}

	@Override
	public User showUser(String login) throws UserDoesntExistException {
		User user = getUser(login);
		if(user == null) throw new UserDoesntExistException();
		return user;
	}

	@Override
	public void insertContact(String login1, String login2)
			throws UserDoesntExistException, UsersAlreadyFriendsException {
		
		User user1 = showUser(login1); User user2 = showUser(login2);
		user1.newContact(user2); user2.newContact(user1);
	}

	@Override
	public void removeContact(String login1, String login2)
			throws UserDoesntExistException, UserNotFriendException, SameUserException {
		
		User user1 = showUser(login1); User user2 = showUser(login2);
		if(login1.equals(login2)) throw new SameUserException();
		
		user1.removeContact(user2); user2.removeContact(user1);
		
	}

	@Override
	public Iterator<Entry<String, User>> listContacts(String login) throws UserDoesntExistException, UserNoContactsException { 
		Iterator<Entry<String, User>> it = showUser(login).listContacts(); 
		if(!it.hasNext()) throw new UserNoContactsException(); 
		return it;
	}

	@Override
	public void insertGroup(String group, String description) throws GroupAlreadyExistsException {
		if(getGroup(group)!=null) throw new GroupAlreadyExistsException();
		Group newGroup = new GroupClass(group, description);
		groups.insert(group, newGroup);
	}

	@Override
	public Group showGroup(String group) throws GroupDoesntExistException {
		Group Objgroup = getGroup(group);
		if(Objgroup == null) throw new GroupDoesntExistException();
		return Objgroup;
	}

	@Override
	public void removeGroup(String group) throws GroupDoesntExistException {
		Group objGroup = showGroup(group); 
		Iterator<Entry<String, User>> it = objGroup.listMembers(); 
		while(it.hasNext()) { 
			it.next().getValue().removeGroup(objGroup); 
		} 
		groups.remove(group); 
	}

	@Override
	public void subscribeGroup(String login, String group)
			throws UserDoesntExistException, GroupDoesntExistException, UserAlreadyInGroupException {
		User user = showUser(login); Group objGroup = showGroup(group);
		user.addGroup(objGroup); objGroup.addMember(user);
	}

	@Override
	public void removeSubscription(String login, String group)
			throws UserDoesntExistException, GroupDoesntExistException, UserIsntInGroupException {
		User user = showUser(login); Group objGroup = showGroup(group);
		user.removeGroup(objGroup); objGroup.removeMember(user);
	}

	@Override
	public Iterator<Entry<String, User>> listParticipants(String group) throws GroupDoesntExistException, GroupIsEmptyException { 
		Iterator<Entry<String, User>> it = showGroup(group).listMembers(); 
		if(!it.hasNext()) throw new GroupIsEmptyException(); 
		return it; 
	} 

	@Override
	public void insertMessage(String login, String title, String text, String url) throws UserDoesntExistException {
		Message message = new MessageClass(title, text, url);
		User user = showUser(login);
		user.recieveMessage(message);
		Iterator<Entry<String, Group>> itGroups = user.listGroups(); sendToGroups(itGroups, message); 
		Iterator<Entry<String, User>> itContacts = user.listContacts(); sendToContacts(itContacts, message);
		
	}

	@Override
	public Iterator<Message> listContactMessages(String login1, String login2) throws UserDoesntExistException,
			UserNotFriendException, NoFriendMessagesException {
		User user1 = showUser(login1); User user2 = showUser(login2);
		if(!user1.isContact(user2)) throw new UserNotFriendException();
		
		Iterator<Message> it = user1.listMessages();
		if(!it.hasNext()) throw new NoFriendMessagesException();
		
		return it;
	}

	@Override
	public Iterator<Message> listGroupMessages(String group, String login) throws GroupDoesntExistException,
			UserDoesntExistException, UserIsntInGroupException, NoGroupMessagesException {
		Group objGroup = showGroup(group);
		User user = showUser(login);
		if(!user.inGroup(objGroup)) throw new UserIsntInGroupException();
		
		Iterator<Message> it = objGroup.listMessages();
		if(!it.hasNext()) throw new NoGroupMessagesException();
		
		return it;
	}
	
	/**
	 * @param login - The user login.
	 * @return The user wanted.
	 * @throws UserDoesntExistException - If the user with <login> doesn't exist.
	 */
	private User getUser(String login) throws UserDoesntExistException {
		return users.find(login);
	}

	/**
	 * @param group - The group name.
	 * @return The group wanted.
	 * @throws GroupDoesntExistException - If the group with <groupName> doesn't exist.
	 */
	private Group getGroup(String groupName) throws GroupDoesntExistException {
		return groups.find(groupName);
	}
	
	/**
	 * Send a <message> to all the user groups.
	 * @param itGroups - Iterator to all the user groups.
	 * @param message - The message to send to all.
	 */
	private void sendToGroups(Iterator<Entry<String, Group>> itGroups, Message message) { 
		while(itGroups.hasNext()) 
			itGroups.next().getValue().recieveMessage(message); 
	} 
	
	/**
	 * Send a <message> to all the user contacts.
	 * @param itContacs - Iterator to all the user contacts.
	 * @param message - The message to send to all.
	 */
	private void sendToContacts(Iterator<Entry<String, User>> itContacs, Message message) { 
		while(itContacs.hasNext()) 
			itContacs.next().getValue().recieveMessage(message); 
	} 
}
