package covidSystem;

import covidSystem.exceptions.GroupAlreadyExistsException;
import covidSystem.exceptions.GroupDoesntExistException;
import covidSystem.exceptions.SameUserException;
import covidSystem.exceptions.UserAlreadyExistException;
import covidSystem.exceptions.UserDoesntExistException;
import dataStructures.Iterator;
import group.Group;
import group.exceptions.GroupIsEmptyException;
import group.exceptions.NoGroupMessagesException;
import message.Message;
import user.User;
import user.exceptions.NoFriendMessagesException;
import user.exceptions.UserAlreadyInGroupException;
import user.exceptions.UserIsntInGroupException;
import user.exceptions.UserNoContactsException;
import user.exceptions.UserNotFriendException;
import user.exceptions.UsersAlreadyFriendsException;

public class CovidSystemClass implements CovidSystem {

	public CovidSystemClass() {
		
	}

	@Override
	public void insertUser(String login, String name, int age, String address, String profession)
			throws UserAlreadyExistException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User showUser(String login) throws UserDoesntExistException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertContact(String login1, String login2)
			throws UserDoesntExistException, UsersAlreadyFriendsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeContact(String login1, String login2)
			throws UserDoesntExistException, UserNotFriendException, SameUserException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User listContacts(String login) throws UserDoesntExistException, UserNoContactsException {
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
