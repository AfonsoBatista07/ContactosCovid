package covidSystem;

import group.*;
import message.*;
import user.*;
import dataStructures.DoublyLinkedList;
import dataStructures.Iterator;
import dataStructures.List;
import user.exceptions.*;
import covidSystem.exceptions.*;
import group.exceptions.*;

public class CovidSystemClass implements CovidSystem {
	
	List<User> users;
	List<Group> groups;
	
	public CovidSystemClass() {
		users = new DoublyLinkedList<User>();
		groups = new DoublyLinkedList<Group>();
	}

	@Override
	public void insertUser(String login, String name, int age, String address, String profession)
			throws UserAlreadyExistException {
		
		if(users.find(login)!=null) throw new UserAlreadyExistException();
		
		User newUser = new UserClass(login, name, age, address, profession);
		users.addLast(newUser);
	}

	@Override
	public User showUser(String login) throws UserDoesntExistException {
		User user = users.find(login);
		if(user==null) throw new UserDoesntExistException();
		return user;
	}

	@Override
	public void insertContact(String login1, String login2)
			throws UserDoesntExistException, UsersAlreadyFriendsException {
		
		User user1 = users.find(login1); User user2 = users.find(login2);
		
		if(user1==null || user2==null) throw new UserDoesntExistException();
		
		user1.newContact(user2); user2.newContact(user1);
		//TODO
	}

	@Override
	public void removeContact(String login1, String login2)
			throws UserDoesntExistException, UserNotFriendException, SameUserException {
		
		User user1 = users.find(login1); User user2 = users.find(login2);
		
		if(user1==null || user2==null) throw new UserDoesntExistException();
		//TODO
		if(login1.equals(login2)) throw new SameUserException();
		
		user1.removeContact(user2); user2.removeContact(user1);
		
	}

	@Override
	public Iterator<User> listContacts(String login) throws UserDoesntExistException, UserNoContactsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertGroup(String group, String description) throws GroupAlreadyExistsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Group showGroup(String group) throws UserDoesntExistException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeGroup(String group) throws UserDoesntExistException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void subscribeGroup(String login, String group)
			throws UserDoesntExistException, GroupDoesntExistException, UserAlreadyInGroupException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeSubscription(String login, String group)
			throws UserDoesntExistException, GroupDoesntExistException, UserIsntInGroupException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterator<User> listParticipants(String group) throws UserDoesntExistException, GroupIsEmptyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertMessage(String login, String title, String text, String url) throws UserDoesntExistException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterator<Message> listContactMessages(String login1, String login2)
			throws UserDoesntExistException, UserNotFriendException, NoFriendMessagesException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Message> listGroupMessages(String group, String login) throws UserNotFriendException,
			UserDoesntExistException, UserIsntInGroupException, NoGroupMessagesException {
		// TODO Auto-generated method stub
		return null;
	}
}
